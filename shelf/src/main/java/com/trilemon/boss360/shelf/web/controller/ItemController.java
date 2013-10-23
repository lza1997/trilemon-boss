package com.trilemon.boss360.shelf.web.controller;

import com.taobao.api.domain.Item;
import com.trilemon.boss360.infrastructure.base.service.api.EnhancedApiException;
import com.trilemon.boss360.infrastructure.base.service.api.TaobaoApiShopService;
import com.trilemon.boss360.shelf.ShelfConstants;
import com.trilemon.boss360.shelf.ShelfUtils;
import com.trilemon.boss360.shelf.model.Plan;
import com.trilemon.boss360.shelf.service.PlanSettingService;
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
    @Autowired
    private PlanSettingService planSettingService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    Page<Item> index(String key, @RequestParam(defaultValue = "") Long[] cids, @RequestParam(defaultValue = "1") int page, @RequestParam(required = false) Long pid) throws EnhancedApiException {
        if (pid == null) {
            return taobaoApiShopService.paginateOnSaleItems(56912708L, key, ShelfConstants.ITEM_FIELDS, Arrays.asList(cids),
                    page, 2, true);
        } else {
            Page<Plan> plans = planSettingService.paginatePlans(56912708L, pid, page, 2);
            return ShelfUtils.planToItem(plans);
        }
    }
}
