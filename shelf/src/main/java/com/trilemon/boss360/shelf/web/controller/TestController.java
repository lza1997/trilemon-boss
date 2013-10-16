package com.trilemon.boss360.shelf.web.controller;

import com.taobao.api.domain.SellerCat;
import com.trilemon.boss360.infrastructure.base.service.api.EnhancedApiException;
import com.trilemon.boss360.infrastructure.base.service.api.TaobaoApiShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
        Map<SellerCat, Long> map=taobaoApiShopService.getSellerCatAndOnSaleItemNum(56912708L);
        return map;
    }
}
