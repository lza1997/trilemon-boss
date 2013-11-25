package com.trilemon.boss.rate.cache;

import com.taobao.api.domain.User;
import com.trilemon.boss.infra.base.service.api.TaobaoApiUserService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.commons.redis.JedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author kevin
 */
@Component
public class RateCache {
    public static final int BUYER_EXPIRED = 24 * 60 * 60;
    @Autowired
    private JedisTemplate jedisTemplate;
    @Autowired
    private TaobaoApiUserService taobaoApiUserService;

    public User getBuyer(Long sellerId, String buyerNick, List<String> buyerFields) throws TaobaoAccessControlException, TaobaoEnhancedApiException, TaobaoSessionExpiredException {
        String buyerCacheKey = getBuyerCacheKey(buyerNick);
        User buyer = jedisTemplate.getObj(buyerCacheKey);
        if (null == buyer) {
            buyer = taobaoApiUserService.getUser(sellerId, buyerNick, buyerFields);
            jedisTemplate.setex(buyerCacheKey.getBytes(), buyer, BUYER_EXPIRED);
        }
        return buyer;
    }

    public String getBuyerCacheKey(String buyerNick) {
        return "rate-buyer-" + buyerNick;
    }
}
