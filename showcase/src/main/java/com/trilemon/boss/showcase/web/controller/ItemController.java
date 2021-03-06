package com.trilemon.boss.showcase.web.controller;

import com.trilemon.boss.infra.base.service.SessionService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.showcase.ShowcaseConstants;
import com.trilemon.boss.showcase.ShowcaseException;
import com.trilemon.boss.showcase.model.dto.ShowcaseItem;
import com.trilemon.boss.showcase.service.SettingService;
import com.trilemon.commons.web.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 所有的宝贝，用于固定推荐
 *
 * @author edokeh
 */
@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private SettingService settingService;


    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Page<ShowcaseItem> index(String key, @RequestParam(defaultValue = "1") Integer page, String category, String order, String tab) throws
            ShowcaseException,
            TaobaoSessionExpiredException,
            TaobaoEnhancedApiException, TaobaoAccessControlException {
        // tab 是固定推荐还是全部宝贝
        if ("include".equals(tab)) {
            return settingService.getIncludeShowcaseItems(sessionService.getUserId(), page, 2);
        } else {
            if ("asc".equals(order)) {
                order = ShowcaseConstants.ASC_ORDER_BY_DELIST_TIME;
            } else {
                order = ShowcaseConstants.DESC_ORDER_BY_DELIST_TIME;
            }
            // 库存中还是销售中
            if ("inventory".equals(category)) {
                return settingService.paginateInventoryItems(sessionService.getUserId(), key, ShowcaseConstants.INVENTORY_BANNER_TYPES, null, page, 2, false, order);
            } else {
                return settingService.paginateOnSaleItems(sessionService.getUserId(), key, null, page, 2, false, order);
            }
        }

    }

    /**
     * 设置固定推荐或取消
     */
    @RequestMapping(value = "/include", method = RequestMethod.PUT)
    @ResponseBody
    public String includeItem(@RequestBody IncludeJSONParam jsonParam) throws ShowcaseException, TaobaoSessionExpiredException, TaobaoAccessControlException, TaobaoEnhancedApiException {
        for (Long numIid : jsonParam.numIids) {
            if (jsonParam.include) {
                settingService.addIncludeItem(sessionService.getUserId(), numIid);
            } else {
                settingService.deleteIncludeItem(sessionService.getUserId(), numIid);
            }
        }
        return "";
    }

    /**
     * 辅助，用于接收 JSON Request
     */
    public static class IncludeJSONParam {
        public Long[] numIids;
        public boolean include;
    }
}