package com.trilemon.boss360.shelf.web.controller;

import com.taobao.api.domain.SellerCat;
import com.trilemon.boss360.infrastructure.base.service.api.EnhancedApiException;
import com.trilemon.boss360.infrastructure.base.service.api.TaobaoApiShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Map;

/**
 * @author kevin
 */
@Controller
@RequestMapping("/sellercats")
public class SellercatsController {
    @Autowired
    private TaobaoApiShopService taobaoApiShopService;

    @ResponseBody
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Collection getSellerCats() throws EnhancedApiException {
        Map<SellerCat, Long> map=taobaoApiShopService.getSellerCatAndOnSaleItemNum(56912708L);

        return map.keySet();
    }
}
