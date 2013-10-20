package com.trilemon.boss360.shelf.web.controller;

import com.taobao.api.domain.Item;
import com.trilemon.boss360.infrastructure.base.service.api.EnhancedApiException;
import com.trilemon.boss360.infrastructure.base.service.api.TaobaoApiShopService;
import com.trilemon.boss360.shelf.ShelfConstants;
import com.trilemon.commons.web.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;

/**
 * @author edokeh
 */
@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private TaobaoApiShopService taobaoApiShopService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    Page<Item> index(String key, @RequestParam(defaultValue = "") Long[] cids, @RequestParam(defaultValue = "1") int page) throws EnhancedApiException {
        //List<SellerCat> cids = taobaoApiShopService.getSellerCats(56912708L);
//        List<Long> sellerCats = Lists.transform(cids, new Function<SellerCat, Long>() {
//            @Nullable
//            @Override
//            public Long apply(@Nullable SellerCat input) {
//                return input.getCid();
//            }
//        });
        Page<Item> items = taobaoApiShopService.paginateOnSaleItems(56912708L, key, ShelfConstants.ITEM_FIELDS, Arrays.asList(cids),
                page, 2,true);
        return items;
    }
}
