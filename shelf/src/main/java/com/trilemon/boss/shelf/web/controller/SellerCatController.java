package com.trilemon.boss.shelf.web.controller;

import com.trilemon.boss.infra.base.model.dto.SellerCatExtended;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.shelf.service.PlanSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author kevin
 */
@Controller
@RequestMapping("/sellercats")
public class SellerCatController {
    @Autowired
    private PlanSettingService planSettingService;


    /**
     * 获取卖家的分类信息
     * @return
     * @throws TaobaoEnhancedApiException
     * @throws TaobaoSessionExpiredException
     * @throws TaobaoAccessControlException
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<SellerCatExtended> index() throws TaobaoEnhancedApiException, TaobaoSessionExpiredException, TaobaoAccessControlException {
        return planSettingService.getSellerCatsExtended(56912708L);
    }
}
