package com.trilemon.top.boss360.shelf.service;

import com.google.common.base.Joiner;
import com.google.common.base.Stopwatch;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.taobao.api.TaobaoClient;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.TaobaoResponse;
import com.trilemon.top.boss360.shelf.TopApiRequestTemplate;
import net.spy.memcached.MemcachedClient;
import org.dozer.util.ReflectionUtils;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Preconditions.checkNotNull;

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
    @Autowired
    private MemcachedClient memcachedClient;
    private List<String> cacheKeys = Lists.newArrayList();
    private String serviceName;
    private String serviceId;
    private Map<String, TaobaoClient> taobaoClientMap;

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
    public void init() {
        checkNotNull(serviceName);
        checkNotNull(serviceId);
        initTaobaoClient();
        for (Map.Entry<String, TaobaoClient> entry : taobaoClientMap.entrySet()) {
            initCacheKeyList(entry.getKey());
        }
    }

    private void initTaobaoClient() {
        //To change body of created methods use File | Settings | File Templates.
    }

    public void initCacheKeyList(String appKey) {
        for (Class<? extends TaobaoRequest> subType : getSubTypesOf("com.taobao.api", TaobaoRequest.class)) {
            Method method = ReflectionUtils.getMethod(subType, "getApiMethodName");
            try {
                String apiName = (String) ReflectionUtils.invoke(method, ReflectionUtils.newInstance(subType), new Object[0]);
                cacheKeys.add(geCacheKey(appKey, apiName, STATE_SUCCESSFUL));
                cacheKeys.add(geCacheKey(appKey, apiName, STATE_FAIL));
            } catch (Exception e) {
            }
        }
    }

    public <REQ extends TaobaoRequest<RES>, RES extends TaobaoResponse> RES request(TopApiRequestTemplate<REQ, RES>
                                                                                            topApiRequestTemplate,
                                                                                    REQ req, String appKey) throws Exception {
        return request(topApiRequestTemplate, req, appKey, null);
    }

    public String geCacheKey(String appKey, String apiName, String state) {
        return Joiner.on(":").join(TOP_API_COUNT_CACHE_KEY_PREFIX, appKey, apiName,
                state, serviceName, serviceId);
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

        String successfulCallDetailCacheKey = geCacheKey(appKey, apiName, STATE_SUCCESSFUL);
        String failCallDetailCacheKey = geCacheKey(appKey, apiName, STATE_FAIL);

        try {
            final Stopwatch stopwatch = new Stopwatch().start();
            RES response = topApiRequestTemplate.request(taobaoClient, req, sessionKey);
            if (!response.isSuccess()) {
                recordCall(successfulCallDetailCacheKey);
            } else {
                recordCall(failCallDetailCacheKey);
            }
            final long elapsedMillis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
            totalApiExecTime.add(appKey, (int) elapsedMillis);
            totalApiExecCount.add(appKey);
            return response;
        } catch (Exception e) {
            recordCall(failCallDetailCacheKey);
            throw e;
        }
    }

    public void recordCall(String cacheKey) {
        if (!cacheKeys.contains(cacheKey)) {
            cacheKeys.add(cacheKey);
        }
        Object cacheValue = memcachedClient.get(cacheKey);
        if (null == cacheValue) {
            memcachedClient.set(cacheKey, CACHE_EXPIRE_TIME, "0");
        }
        memcachedClient.asyncIncr(cacheKey, 1);
    }

    @Scheduled(fixedDelay = 1000 * 60)
    public void flushCache() {
        for (String cacheKey : cacheKeys) {
            Object cacheValue = memcachedClient.get(cacheKey);
            if (null != cacheValue) {
                int count = Integer.valueOf(String.valueOf(cacheValue));
                if (count == 0) {
                    String[] keys = cacheKey.split(":");
                    // insert and update database
                    //clear cache
                    memcachedClient.set(cacheKey, CACHE_EXPIRE_TIME, "0");
                    totalApiExecTime.remove(cacheKey);
                    totalApiExecCount.remove(cacheKey);
                }
            }
        }
    }

    public long getAvgTaobaoApiExecTime(String appKey) {
        return totalApiExecTime.count(appKey) / totalApiExecCount.count(appKey);
    }
}
