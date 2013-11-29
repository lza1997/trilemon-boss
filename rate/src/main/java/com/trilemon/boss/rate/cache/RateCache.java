package com.trilemon.boss.rate.cache;

import com.google.common.collect.Lists;
import com.taobao.api.domain.User;
import com.taobao.api.domain.UserCredit;
import com.trilemon.boss.infra.base.client.BaseClient;
import com.trilemon.boss.infra.base.model.BuyerBlacklist;
import com.trilemon.boss.infra.base.service.api.TaobaoApiUserService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.infra.sync.rate.dao.SyncRateDAO;
import com.trilemon.boss.rate.model.dto.RateStatus;
import com.trilemon.commons.DateUtils;
import com.trilemon.commons.redis.JedisTemplate;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kevin
 */
@Component
public class RateCache {
    public static final int BUYER_EXPIRED = 24 * 60 * 60;
    public static final int BUYER_RATE_STATUS_EXPIRED = 24 * 60 * 60;
    public static final int BUYER_BLACKLIST_EXPIRED = 15 * 60;
    @Autowired
    private JedisTemplate jedisTemplate;
    @Autowired
    private TaobaoApiUserService taobaoApiUserService;
    @Autowired
    private SyncRateDAO syncRateDAO;
    @Autowired
    private BaseClient baseClient;
    @Autowired
    private Environment env;

    public User getBuyer(Long sellerId, String buyerNick, List<String> buyerFields) throws TaobaoAccessControlException, TaobaoEnhancedApiException, TaobaoSessionExpiredException {
        String cacheKey = getBuyerCacheKey(buyerNick);
        User buyer = jedisTemplate.getObj(cacheKey);
        if (null == buyer) {
            //应用上线前这个 api 不能调用
            if (CollectionUtils.containsAny(Lists.newArrayList(env.getActiveProfiles()),
                    Lists.newArrayList("test","development"))) {
                buyer = new User();
                //过滤注册日期
                buyer.setCreated(DateUtils.parse("2013-02-10", DateUtils.yyyyMMdd2).toDate());
                //过滤信誉
                UserCredit userCredit=new UserCredit();
                userCredit.setLevel(10L);
                //过滤好评
                userCredit.setGoodNum(20L);
                buyer.setBuyerCredit(userCredit);
            } else {
                buyer = taobaoApiUserService.getUser(sellerId, buyerNick, buyerFields);
            }
            jedisTemplate.setex(cacheKey.getBytes(), buyer, BUYER_EXPIRED);
        }
        return buyer;
    }

    public String getBuyerCacheKey(String buyerNick) {
        return "rate-buyer-" + buyerNick;
    }

    public RateStatus getBuyerRateSyncStatus(Long userId, String buyerNick) {
        String cacheKey = getBuyerRateStatusCacheKey(userId, buyerNick);
        RateStatus rateStatus = jedisTemplate.getObj(cacheKey);
        if (null == rateStatus) {
            rateStatus = syncRateDAO.calcBuyerRateStatus(userId, buyerNick);
            jedisTemplate.setex(cacheKey.getBytes(), rateStatus, BUYER_RATE_STATUS_EXPIRED);
        }
        return rateStatus;
    }

    private String getBuyerRateStatusCacheKey(Long userId, String buyerNick) {
        return "rate-status-userId[" + userId + "]-buyerNick[" + buyerNick + "]";
    }

    public BuyerBlacklist getBuyerBlacklist(Long userId, String buyerNick) {
        String cacheKey = getBuyerBlacklistCacheKey(userId, buyerNick);
        BuyerBlacklist buyerBlacklist = jedisTemplate.getObj(cacheKey);
        if (null == buyerBlacklist) {
            buyerBlacklist = baseClient.getBuyerBlacklist(userId, buyerNick);
            jedisTemplate.setex(cacheKey.getBytes(), buyerBlacklist, BUYER_BLACKLIST_EXPIRED);
        }
        return buyerBlacklist;
    }

    private String getBuyerBlacklistCacheKey(Long userId, String buyerNick) {
        return "buyer-blacklist-userId[" + userId + "]-buyerNick[" + buyerNick + "]";
    }
}
