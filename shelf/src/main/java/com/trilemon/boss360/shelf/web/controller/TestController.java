package com.trilemon.boss360.shelf.web.controller;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.taobao.api.domain.Item;
import com.taobao.api.domain.SellerCat;
import com.trilemon.boss360.infrastructure.base.service.api.EnhancedApiException;
import com.trilemon.boss360.infrastructure.base.service.api.TaobaoApiShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @ResponseBody
    @RequestMapping(value = "/sellercats", method = RequestMethod.GET)
    Map<SellerCat, Long> getSellerCats() throws EnhancedApiException {
        Map<SellerCat, Long> map = taobaoApiShopService.getSellerCatAndOnSaleItemNum(56912708L);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/item", method = RequestMethod.GET)
    List<SellerCat> getSellerCats2() throws EnhancedApiException {
        List<SellerCat> cids = taobaoApiShopService.getSellerCats(56912708L);
        return cids;
    }

    @ResponseBody
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    List<Item> getSellerCats3() throws EnhancedApiException {
        List<SellerCat> cids = taobaoApiShopService.getSellerCats(56912708L);
        List<Long> cidList= Lists.transform(cids,new Function<SellerCat, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable SellerCat input) {
                return input.getCid();  //To change body of implemented methods use File | Settings | File Templates.
            }
        });
        List<Item> items = taobaoApiShopService.getOnSaleItems(56912708L,cidList);
        return items;
    }
}
