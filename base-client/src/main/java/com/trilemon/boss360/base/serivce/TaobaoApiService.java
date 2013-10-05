package com.trilemon.boss360.base.serivce;

import com.google.common.base.Joiner;
import com.google.common.base.Stopwatch;
import com.google.common.collect.*;
import com.taobao.api.*;
import com.trilemon.boss360.base.client.BaseClient;
import com.trilemon.boss360.base.model.TaobaoApiUsage;
import com.trilemon.boss360.base.model.TaobaoApp;
import net.spy.memcached.MemcachedClient;
import org.dozer.util.ReflectionUtils;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.net.SocketException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author kevin
 */
@Service
public class TaobaoApiService {
    private final String STATE_SUCCESSFUL = "successful";
    private final String STATE_FAIL = "fail";
    private final String TOP_API_COUNT_CACHE_KEY_PREFIX = "top_api_count";
    private final int CACHE_EXPIRE_TIME = 7 * 24 * 60 * 60;
    private Multiset<String> totalApiExecTime = HashMultiset.create();
    private Multiset<String> totalApiExecCount = HashMultiset.create();
    @Value("${taobao_app_key}")
    private String taobaoAppKey;
    @Autowired
    private MemcachedClient memcachedClient;
    @Autowired
    private ApplicationService applicationService;
    private BaseClient baseClient;
    private Multimap<String, String> cacheKeys = HashMultimap.create();
    private TaobaoClient taobaoClient;

    //TODO add to commons
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
        checkNotNull(applicationService.getServiceName());
        checkNotNull(applicationService.getServiceId());
        initTaobaoClient();
        initCacheKeyList();
    }

    private void initTaobaoClient() {
        //TaobaoApp taobaoApp = baseClient.getTaobaoApp(taobaoAppKey);
        TaobaoApp taobaoApp =new TaobaoApp();
        taobaoApp.setAppCallbackUrl("http://boss.trilemon.com");
        taobaoApp.setAppKey("21635387");
        taobaoApp.setAppSecret("2535d805a5862eada6febca6eb91a427");
        taobaoClient = new AutoRetryTaobaoClient(taobaoApp.getAppCallbackUrl(),
                taobaoApp.getAppKey(), taobaoApp.getAppSecret());
    }

    public void initCacheKeyList() {
        for (Class<? extends TaobaoRequest> subType : getSubTypesOf("com.taobao.api", TaobaoRequest.class)) {
            Method method = ReflectionUtils.getMethod(subType, "getApiMethodName");
            try {
                String apiName = (String) ReflectionUtils.invoke(method, ReflectionUtils.newInstance(subType), new Object[0]);
                cacheKeys.put(getCacheKeyPrefix(taobaoAppKey, apiName), STATE_SUCCESSFUL);
                cacheKeys.put(getCacheKeyPrefix(taobaoAppKey, apiName), STATE_FAIL);
            } catch (Exception ignored) {
            }
        }
    }

    public String getCacheKeyPrefix(String appKey, String apiName) {
        return Joiner.on(":").join(TOP_API_COUNT_CACHE_KEY_PREFIX, appKey, apiName,
                applicationService.getServiceName(), applicationService.getServiceId());
    }

    public <REQ extends TaobaoRequest<RES>, RES extends TaobaoResponse> RES request(REQ req, String appKey) throws ApiException {
        return request(req, appKey, null);
    }

    public <REQ extends TaobaoRequest<RES>, RES extends TaobaoResponse> RES request(REQ req, String appKey, String sessionKey) throws ApiException {
        checkNotNull(taobaoClient);

        String apiName = req.getApiMethodName();

        String callDetailCacheKeyPrefix = getCacheKeyPrefix(appKey, apiName);

        final Stopwatch stopwatch = new Stopwatch().start();
        RES response = taobaoClient.execute(req, sessionKey);
        if (!response.isSuccess()) {
            recordCall(callDetailCacheKeyPrefix, STATE_SUCCESSFUL);
        } else {
            recordCall(callDetailCacheKeyPrefix, STATE_FAIL);
        }
        final long elapsedMillis = stopwatch.elapsed(TimeUnit.MILLISECONDS);
        totalApiExecTime.add(appKey, (int) elapsedMillis);
        totalApiExecCount.add(appKey);
        return response;
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
        List<TaobaoApiUsage> taobaoApiUsageList = Lists.newArrayList();
        for (String cacheKeyPrefix : cacheKeys.keys()) {
            Object successfulCacheValue = memcachedClient.get(cacheKeyPrefix + ":" + STATE_SUCCESSFUL);
            Object failCacheValue = memcachedClient.get(cacheKeyPrefix + ":" + STATE_FAIL);
            if (null != successfulCacheValue || null != failCacheValue) {
                int successfulCount = Integer.valueOf(String.valueOf(successfulCacheValue));
                int failCount = Integer.valueOf(String.valueOf(failCacheValue));
                if (successfulCount > 0 || failCount > 0) {
                    String[] keys = cacheKeyPrefix.split(":");
                    TaobaoApiUsage taobaoApiUsage = new TaobaoApiUsage();
                    taobaoApiUsage.setApiName(keys[2]);
                    taobaoApiUsage.setServiceName(keys[3]);
                    taobaoApiUsage.setTaobaoAppKey(keys[1]);
                    taobaoApiUsage.setServiceId(keys[4]);
                    taobaoApiUsage.setSuccessfulCall((long) successfulCount);
                    taobaoApiUsage.setFailedCall((long) failCount);
                    taobaoApiUsage.setAvgExecTime(getAvgTaobaoApiExecTime(keys[1]));
                    taobaoApiUsage.setAddTime(applicationService.getLocalSystemTime().toDate());
                    taobaoApiUsageList.add(taobaoApiUsage);
                    //clear cache
                    memcachedClient.set(cacheKeyPrefix + ":" + STATE_SUCCESSFUL, CACHE_EXPIRE_TIME, "0");
                    memcachedClient.set(cacheKeyPrefix + ":" + STATE_FAIL, CACHE_EXPIRE_TIME, "0");
                    totalApiExecTime.remove(keys[1]);
                    totalApiExecCount.remove(keys[1]);
                }
            }
        }
        baseClient.updateApiUsage(taobaoApiUsageList);
    }

    public int getAvgTaobaoApiExecTime(String appKey) {
        return totalApiExecTime.count(appKey) / totalApiExecCount.count(appKey);
    }

    public String getTaobaoAppKey() {
        return taobaoAppKey;
    }

    public void setTaobaoAppKey(String taobaoAppKey) {
        this.taobaoAppKey = taobaoAppKey;
    }
}
