package com.trilemon.boss.poster.recommend.web.controller;

import com.trilemon.boss.infra.base.model.dto.SellerCatExtended;
import com.trilemon.boss.infra.base.service.SessionService;
import com.trilemon.boss.infra.base.service.api.TaobaoApiShopService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 宝贝分类
 *
 * @author edokeh
 */
@Controller
@RequestMapping("/sellercats")
public class SellerCatController {
    @Autowired
    private TaobaoApiShopService taobaoApiShopService;
    @Autowired
    private SessionService sessionService;


    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<SellerCatExtended> index() throws TaobaoEnhancedApiException, TaobaoSessionExpiredException, TaobaoAccessControlException {
        List<SellerCatExtended> list = taobaoApiShopService.getOnsaleSellerCatExtended(sessionService.getUserId(), null);
        // 排序，让子分类排列在父分类之后
        List<SellerCatExtended> sortedList = new ArrayList<SellerCatExtended>();
        for (SellerCatExtended cat : list) {
            if (cat.getSellerCat().getParentCid().equals(0L)) {
                sortedList.add(cat);
                for (SellerCatExtended anCat : list) {
                    if (anCat.getSellerCat().getParentCid().equals(cat.getSellerCat().getCid())) {
                        sortedList.add(anCat);
                    }
                }
            }
        }
        return sortedList;
    }
}
