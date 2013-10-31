package com.trilemon.boss360.shelf.web.controller;

import com.google.common.collect.Lists;
import com.taobao.api.domain.SellerCat;
import com.trilemon.boss360.infrastructure.base.service.api.TaobaoApiShopService;
import com.trilemon.boss360.infrastructure.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss360.infrastructure.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss360.shelf.service.PlanSettingService;
import com.trilemon.boss360.shelf.web.vo.SellerCatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author kevin
 */
@Controller
@RequestMapping("/sellercats")
public class SellerCatController {
    @Autowired
    private TaobaoApiShopService taobaoApiShopService;
    @Autowired
    private PlanSettingService planSettingService;

    /**
     * 获取卖家的分类信息
     *
     * @return
     * @throws TaobaoEnhancedApiException
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<SellerCatVO> index() throws TaobaoEnhancedApiException, TaobaoSessionExpiredException {
        List<SellerCat> sellerCats = taobaoApiShopService.getSellerCats(56912708L);
        Map<SellerCat, Long> map = taobaoApiShopService.getSellerCatAndOnSaleItemNum(56912708L, sellerCats);
        Set<Long> plannedSellerCatIds = planSettingService.getUsedSellerCatIds(56912708L);

        // map -> list , use DTO to transfer
        List<SellerCatVO> list = Lists.newArrayList();
        for (SellerCat sellerCat : map.keySet()) {
            SellerCatVO sellerCatVO = new SellerCatVO(sellerCat);
            sellerCatVO.setItemNum(map.get(sellerCat));
            //设置是否分类已经被占用了
            if (plannedSellerCatIds.contains(sellerCat.getCid())) {
                sellerCatVO.setPlanned(true);
            }
            list.add(sellerCatVO);
        }

        return list;
    }
}
