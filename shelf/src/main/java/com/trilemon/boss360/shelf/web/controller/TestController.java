package com.trilemon.boss360.shelf.web.controller;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.taobao.api.domain.Item;
import com.taobao.api.domain.SellerCat;
import com.trilemon.boss360.infrastructure.base.client.BaseClient;
import com.trilemon.boss360.infrastructure.base.model.TaobaoApp;
import com.trilemon.boss360.infrastructure.base.model.TaobaoSession;
import com.trilemon.boss360.infrastructure.base.service.TaobaoApiService;
import com.trilemon.boss360.infrastructure.base.service.api.EnhancedApiException;
import com.trilemon.boss360.infrastructure.base.service.api.TaobaoApiItemService;
import com.trilemon.boss360.infrastructure.base.service.api.TaobaoApiShopService;
import com.trilemon.boss360.shelf.ShelfConstants;
import com.trilemon.commons.DateUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

/**
 * @author kevin
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TaobaoApiShopService taobaoApiShopService;
    @Autowired
    private BaseClient baseClient;
    @Autowired
    private TaobaoApiService taobaoApiService;
    @Autowired
    private TaobaoApiItemService taobaoApiItemService;

    /**
     * 获取类目对应宝贝个数
     *
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/sellerCatAndOnSaleItemNum", method = RequestMethod.GET)
    Map<SellerCat, Long> getSellerCatAndOnSaleItemNum() throws EnhancedApiException {
        Map<SellerCat, Long> map = taobaoApiShopService.getSellerCatAndOnSaleItemNum(56912708L, ShelfConstants.ITEM_FIELDS);
        return map;
    }

    /**
     * 获取类目
     *
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/sellerCats", method = RequestMethod.GET)
    List<SellerCat> getSellerCats() throws EnhancedApiException {
        List<SellerCat> cids = taobaoApiShopService.getSellerCats(56912708L);
        return cids;
    }

    /**
     * 获取类目 id
     *
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/sellerCatsByNick", method = RequestMethod.GET)
    List<SellerCat> getSellerCatsByNick() throws EnhancedApiException {
        List<SellerCat> cids = taobaoApiShopService.getSellerCats("gymitat");
        return cids;
    }

    /**
     * 获取在售宝贝，带分页
     *
     * @param pageNum
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/onSaleItems", method = RequestMethod.GET)
    Pair<List<Item>, Long> getOnSaleItems(@RequestParam int pageNum) throws EnhancedApiException {
        List<SellerCat> cids = taobaoApiShopService.getSellerCats(56912708L);
        List<Long> cidList = Lists.transform(cids, new Function<SellerCat, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable SellerCat input) {
                return input.getCid();
            }
        });
        Pair<List<Item>, Long> items = taobaoApiShopService.getOnSaleItems(56912708L, cidList, ShelfConstants.ITEM_FIELDS,
                pageNum, 1);
        return items;
    }

    /**
     * 获取所有在售宝贝
     *
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/allOnSaleItems", method = RequestMethod.GET)
    List<Item> getAllOnSaleItems() throws EnhancedApiException {
        List<SellerCat> cids = taobaoApiShopService.getSellerCats(56912708L);
        List<Long> cidList = Lists.transform(cids, new Function<SellerCat, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable SellerCat input) {
                return input.getCid();
            }
        });
        List<Item> items = taobaoApiShopService.getOnSaleItems(56912708L, cidList, ShelfConstants.ITEM_FIELDS);
        return items;
    }

    /**
     * 获取所有在售宝贝数量
     *
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/allOnSaleItemNum", method = RequestMethod.GET)
    long getAllOnSaleItemNum() throws EnhancedApiException {
        List<SellerCat> cids = taobaoApiShopService.getSellerCats(56912708L);
        List<Long> cidList = Lists.transform(cids, new Function<SellerCat, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable SellerCat input) {
                return input.getCid();
            }
        });
        long num = taobaoApiShopService.getOnSaleItemNum(56912708L, cidList, ShelfConstants.ITEM_FIELDS);
        return num;
    }

    /**
     * 获取已经出售订单数量
     *
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/tradeNumFromTop", method = RequestMethod.GET)
    long getTradeNumFromTop() throws EnhancedApiException {
        long num = taobaoApiShopService.getTradeNumFromTop(56912708L, DateUtils.startOfNDaysBefore(90).toDate(),
                DateUtils.endOfNDaysBefore(1).toDate());
        return num;
    }

    /**
     * 根据 use_id 获取 nick
     *
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/nick", method = RequestMethod.GET)
    String getNick() throws EnhancedApiException {
        return baseClient.getNick(56912708L);
    }

    /**
     * 获取{@link TaobaoApp}
     *
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/taobaoApp", method = RequestMethod.GET)
    TaobaoApp getTaobaoApp() throws EnhancedApiException {
        return baseClient.getTaobaoApp(taobaoApiService.getAppKey());
    }

    /**
     * 获取{@link TaobaoSession}
     *
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/taobaoSession", method = RequestMethod.GET)
    TaobaoSession getTaobaoSession() throws EnhancedApiException {
        return baseClient.getTaobaoSession(56912708L, taobaoApiService.getAppKey());
    }

    /**
     * 按关键词搜索
     *
     * @param query
     * @param pageNum
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    Pair<? extends List<Item>, Long> searchOnSaleItem(@RequestParam String query, @RequestParam int pageNum) throws
            EnhancedApiException {
        if (NumberUtils.isNumber(query)) {
            Item item = taobaoApiItemService.getItem(56912708L, Long.valueOf(query), ShelfConstants.ITEM_FIELDS);
            if (null != item) {
                return Pair.of(Lists.newArrayList(item), 1L);
            }
        }
        List<SellerCat> cids = taobaoApiShopService.getSellerCats(56912708L);
        List<Long> cidList = Lists.transform(cids, new Function<SellerCat, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable SellerCat input) {
                return input.getCid();
            }
        });
        return taobaoApiShopService.searchOnSaleItems(56912708L, query, cidList, ShelfConstants.ITEM_FIELDS,
                pageNum, 1);
    }
}
