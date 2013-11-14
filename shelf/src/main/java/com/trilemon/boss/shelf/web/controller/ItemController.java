package com.trilemon.boss.shelf.web.controller;

import com.trilemon.boss.infra.base.service.api.TaobaoApiShopService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.shelf.ShelfUtils;
import com.trilemon.boss.shelf.model.Plan;
import com.trilemon.boss.shelf.model.dto.ShelfItem;
import com.trilemon.boss.shelf.service.PlanSettingService;
import com.trilemon.commons.web.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author edokeh
 */
@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private TaobaoApiShopService taobaoApiShopService;
    @Autowired
    private PlanSettingService planSettingService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    Page<ShelfItem> index(String key,
                          @RequestParam(defaultValue = "") Long[] cids,
                          @RequestParam(defaultValue = "1") int page,
                          @RequestParam(required = false) Long pid) throws TaobaoEnhancedApiException,
            TaobaoSessionExpiredException {
        Page<Plan> plans = planSettingService.paginatePlans(56912708L, pid, key, page, 2);
        Page<ShelfItem> itemPage = Page.empty();
        itemPage.setTotalSize(plans.getTotalSize());
        itemPage.setPageSize(plans.getPageSize());
        itemPage.setPageNum(plans.getPageNum());
        itemPage.setItems(ShelfUtils.planToItem(plans.getItems()));
        return itemPage;
    }
}
