package com.trilemon.boss360.commons.service;

import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.collect.*;
import com.taobao.api.AutoRetryTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.TaobaoResponse;
import com.trilemon.boss360.base.Constants;
import com.trilemon.boss360.base.dao.TaobaoAppMapper;
import com.trilemon.boss360.base.model.TaobaoApi;
import com.trilemon.boss360.base.model.TaobaoApp;
import com.trilemon.boss360.base.util.TopApiRequestTemplate;
import net.spy.memcached.MemcachedClient;
import org.dozer.util.ReflectionUtils;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.net.SocketException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author kevin
 */
public class TaobaoApiService {
    private final String STATE_SUCCESSFUL = "successful";
    private final String STATE_FAIL = "fail";
    private final String TOP_API_COUNT_CACHE_KEY_PREFIX = "top_api_count";
    private final int CACHE_EXPIRE_TIME = 7 * 24 * 60 * 60;
    private Multiset<String> totalApiExecTime = HashMultiset.create();
    private Multiset<String> totalApiExecCount = HashMultiset.create();
    @Value("#{'${taobao_app_keys}'.split(',')}")
    private List<String> taobaoAppKeys;
    @Autowired
    private MemcachedClient memcachedClient;
    @Autowired
    private SystemService systemService;
    @Autowired
    private TaobaoApiMapper taobaoAppMapper;
    private Multimap<String, String> cacheKeys = HashMultimap.create();
    private Map<String, TaobaoClient> taobaoClientMap = Maps.newHashMap();
    @Value("${service_id}")
    private String serviceId;

    public static <T> List<Class<? extends T>> getSubTypesOf(String packageName, final Class<T> type) {
        List<Class<? extends T>> subTypes = Lists.newArrayList();
        for (Class<? extends T> subType : new Reflections(packageName).getSubTypesOf(type)) {
            if (subType.isInterface()) {
                subTypes.addAll(getSubTypesOf(packageName, subType));
            } else {
                subTypes.add(subType);
            }
        }
        return subTypes;
    }

    @PostConstruct
    public void init() throws SocketException {
        Preconditions.checkNotNull(Constants.SERVICE_NAME);
        Preconditions.checkNotNull(serviceId);
        initTaobaoClient();
        for (Map.Entry<String, TaobaoClient> entry : taobaoClientMap.entrySet()) {
            initCacheKeyList(entry.getKey());
        }
    }

    private void initTaobaoClient() {
        for (String taobaoAppKey : taobaoAppKeys) {
            TaobaoApp taobaoApp = taobaoAppMapper.selectByAppKey(taobaoAppKey);
            if (null != taobaoApp) {
                taobaoClientMap.put(taobaoAppKey, new AutoRetryTaobaoClient(taobaoApp.getAppCallbackUrl(),
                        taobaoApp.getAppKey(), taobaoApp.getAppSecret()));
            }
        }
    }

    public void initCacheKeyList(String appKey) {
        for (Class<? extends TaobaoRequest> subType : getSubTypesOf("com.taobao.api", TaobaoRequest.class)) {
            Method method = ReflectionUtils.getMethod(subType, "getApiMethodName");
            try {
                String apiName = (String) ReflectionUtils.invoke(method, ReflectionUtils.newInstance(subType), new Object[0]);
                cacheKeys.put(getCacheKeyPrefix(appKey, apiName), STATE_SUCCESSFUL);
                cacheKeys.put(getCacheKeyPrefix(appKey, apiName), STATE_FAIL);
            } catch (Exception e) {
            }
        }
    }

    public String getCacheKeyPrefix(String appKey, String apiName) {
        return Joiner.on(":").join(TOP_API_COUNT_CACHE_KEY_PREFIX, appKey, apiName, Constants.SERVICE_NAME, serviceId);
    }

    public <REQ extends TaobaoRequest<RES>, RES extends TaobaoResponse> RES request(TopApiRequestTemplate<REQ, RES>
                                                                                            topApiRequestTemplate,
                                                                                    REQ req, String appKey) throws Exception {
        return request(topApiRequestTemplate, req, appKey, null);
    }

    public <REQ extends TaobaoRequest<RES>, RES extends TaobaoResponse> RES request(TopApiRequestTemplate<REQ, RES>
                                                                                            topApiRequestTemplate,
                                                                                    REQ req, String appKey, String sessionKey) throws Exception {
        TaobaoClient taobaoClient = taobaoClientMap.get(appKey);
        if (null == taobaoClient) {
            throw new Exception("can not find taobaoClient for appkey[" + appKey + "] , taobaoClientMap[" + taobaoClientMap
                    + "]");
        }

        String apiName = req.getApiMethodName();

        String callDetailCacheKeyPrefix = getCacheKeyPrefix(appKey, apiName);

        try {
            final Stopwatch stopwatch = new Stopwatch().start();
            RES response = topApiRequestTemplate.request(taobaoClient, req, sessionKey);
            if (!response.isSuccess()) {
                recordCall(callDetailCacheKeyPrefix, STATE_SUCCESSFUL);
            } else {
                recordCall(callDetailCacheKeyPrefix, STATE_FAIL);
            }
            final long elapsedMillis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
            totalApiExecTime.add(appKey, (int) elapsedMillis);
            totalApiExecCount.add(appKey);
            return response;
        } catch (Exception e) {
            recordCall(callDetailCacheKeyPrefix, STATE_FAIL);
            throw e;
        }
    }

    public void recordCall(String cacheKeyPrefix, String state) {
        String cacheKey = cacheKeyPrefix + ":" + state;
        Object cacheValue = memcachedClient.get(cacheKey);
        if (null == cacheValue) {
            memcachedClient.set(cacheKey, CACHE_EXPIRE_TIME, "0");
        }
        memcachedClient.asyncIncr(cacheKey, 1);
    }

    @Scheduled(fixedDelay = 1000 * 60)
    public void flushCache() {
        List<TaobaoApi> taobaoApiList = Lists.newArrayList();
        for (String cacheKeyPrefix : cacheKeys.keys()) {
            Object successfulCacheValue = memcachedClient.get(cacheKeyPrefix + ":" + STATE_SUCCESSFUL);
            Object failCacheValue = memcachedClient.get(cacheKeyPrefix + ":" + STATE_FAIL);
            if (null != successfulCacheValue || null != failCacheValue) {
                int successfulCount = Integer.valueOf(String.valueOf(successfulCacheValue));
                int failCount = Integer.valueOf(String.valueOf(failCacheValue));
                if (successfulCount > 0 || failCount > 0) {
                    String[] keys = cacheKeyPrefix.split(":");
                    TaobaoApi taobaoApi = new TaobaoApi();
                    taobaoApi.setApiName(keys[2]);
                    taobaoApi.setServiceName(keys[3]);
                    taobaoApi.setTaobaoAppKey(keys[1]);
                    taobaoApi.setServiceId(keys[4]);
                    taobaoApi.setSuccessfulCall((long) successfulCount);
                    taobaoApi.setFailedCall((long) failCount);
                    taobaoApi.setAvgExecTime(getAvgTaobaoApiExecTime(keys[1]));
                    taobaoApi.setAddTime(systemService.getLocalSystemTime().toDate());
                    taobaoApiList.add(taobaoApi);
                    //clear cache
                    memcachedClient.set(cacheKeyPrefix + ":" + STATE_SUCCESSFUL, CACHE_EXPIRE_TIME, "0");
                    memcachedClient.set(cacheKeyPrefix + ":" + STATE_FAIL, CACHE_EXPIRE_TIME, "0");
                    totalApiExecTime.remove(keys[1]);
                    totalApiExecCount.remove(keys[1]);
                }
            }
        }
        taobaoAppMapper.batchInsert(taobaoApiList);
    }

    public int getAvgTaobaoApiExecTime(String appKey) {
        return totalApiExecTime.count(appKey) / totalApiExecCount.count(appKey);
    }
}
