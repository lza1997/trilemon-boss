package com.trilemon.boss.poster.recommend.cache;

import com.taobao.api.domain.Item;
import com.trilemon.boss.infra.base.service.api.TaobaoApiShopService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.commons.redis.JedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

import static com.trilemon.boss.poster.recommend.cache.TaobaoApiFieldConstants.*;
import static com.trilemon.commons.Collections3.COMMA_SPLITTER;

/**
 * @author kevin
 */
@Component
public class TaobaoApiCache {
    public static final int ITEM_EXPIRED = 5 * 60;
    @Autowired
    private JedisTemplate jedisTemplate;
    @Autowired
    private TaobaoApiShopService taobaoApiShopService;

    public Item getItem(Long userId, Long itemNumIid) throws TaobaoAccessControlException, TaobaoEnhancedApiException, TaobaoSessionExpiredException {
        String cacheKey = getItemCacheKey(itemNumIid);
        Item item = jedisTemplate.getObj(cacheKey);
        if (null == item) {
            item = taobaoApiShopService.getItem(userId, itemNumIid, COMMA_SPLITTER.splitToList(ITEM_FIELDS));
            jedisTemplate.setex(cacheKey.getBytes(), item, ITEM_EXPIRED);
        }
        return item;


    }

    public String getItemCacheKey(Long itemNumIid) {
        return getItemCachePrefix() + itemNumIid;
    }

    public String getItemCachePrefix() {
        return "taobao-item:";
    }

    public Set<String> getCachedItems() {
        return jedisTemplate.keys(getItemCachePrefix());
    }
}
