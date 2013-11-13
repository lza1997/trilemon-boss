package com.trilemon.boss.showcase.web.controller;

import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.showcase.ShowcaseConstants;
import com.trilemon.boss.showcase.ShowcaseException;
import com.trilemon.boss.showcase.model.Setting;
import com.trilemon.boss.showcase.model.dto.ShowcaseItem;
import com.trilemon.boss.showcase.service.AdjustService;
import com.trilemon.boss.showcase.service.SettingService;
import com.trilemon.commons.web.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kevin
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private SettingService settingService;
    @Autowired
    private AdjustService adjustService;

    @RequestMapping("/update")
    @ResponseBody
    public Setting update() throws ShowcaseException, TaobaoSessionExpiredException, TaobaoEnhancedApiException, TaobaoAccessControlException {
        Setting setting = new Setting();
        setting.setExcludeItemDelistingAfter((int) 6.5 * 24 * 60);
        setting.setExcludeItemDelistingWithin(30);
        setting.setExcludeItemInventoryLt(5);
        setting.setExcludeItemNumIids("19440841598");
        setting.setIncludeItemNumIids("19480514567,20005074958");
        setting.setIncludeSellerCids("819049791");
        setting.setRuleType(ShowcaseConstants.RULE_TYPE_INCLUDE_SELLER_CIDS);
        setting.setStatus(ShowcaseConstants.SETTING_STATUS_RUNNING);
        setting.setUserId(56912708L);
        settingService.updateSetting(56912708L, setting);
        return setting;
    }

    @RequestMapping("/getSetting")
    @ResponseBody
    public Setting getSetting() throws ShowcaseException, TaobaoSessionExpiredException, TaobaoEnhancedApiException {
        return settingService.getSetting(56912708L);
    }

    @RequestMapping("/adjust")
    @ResponseBody
    public String adjust() throws ShowcaseException, TaobaoSessionExpiredException, TaobaoEnhancedApiException,
            TaobaoAccessControlException {
        adjustService.adjust(56912708L);
        return "adjust success";
    }

    /**
     * 开启
     *
     * @return
     * @throws ShowcaseException
     * @throws TaobaoSessionExpiredException
     * @throws TaobaoEnhancedApiException
     * @throws TaobaoAccessControlException
     */
    @RequestMapping("/resumeSetting")
    @ResponseBody
    public String resumeSetting() throws ShowcaseException, TaobaoSessionExpiredException, TaobaoEnhancedApiException, TaobaoAccessControlException {
        settingService.resumeSetting(56912708L);
        return "resume success";
    }

    /**
     * 暂停
     */
    @RequestMapping("/pauseSetting")
    @ResponseBody
    public String pauseSetting() throws ShowcaseException, TaobaoSessionExpiredException, TaobaoEnhancedApiException {
        settingService.pauseSetting(56912708L);
        return "pause success";
    }

    /**
     * 添加必推
     *
     * @param numIid
     * @return
     * @throws ShowcaseException
     * @throws TaobaoSessionExpiredException
     * @throws TaobaoEnhancedApiException
     */
    @RequestMapping("/addIncludeItem")
    @ResponseBody
    public String addIncludeItem(@RequestParam Long numIid) throws
            ShowcaseException,
            TaobaoSessionExpiredException,
            TaobaoEnhancedApiException {
        boolean result = settingService.addIncludeItem(56912708L, numIid);
        return "add includeItem " + result;
    }

    /**
     * 删除必推
     *
     * @param numIid
     * @return
     * @throws ShowcaseException
     * @throws TaobaoSessionExpiredException
     * @throws TaobaoEnhancedApiException
     */
    @RequestMapping("/deleteIncludeItem")
    @ResponseBody
    public String deleteIncludeItem(@RequestParam Long numIid) throws
            ShowcaseException,
            TaobaoSessionExpiredException,
            TaobaoEnhancedApiException {
        boolean result = settingService.deleteIncludeItem(56912708L, numIid);
        return "delete includeItem " + result;
    }

    /**
     * 添加不推
     *
     * @param numIid
     * @return
     * @throws ShowcaseException
     * @throws TaobaoSessionExpiredException
     * @throws TaobaoEnhancedApiException
     */
    @RequestMapping("/addExcludeItem")
    @ResponseBody
    public String addExcludeItem(@RequestParam Long numIid) throws
            ShowcaseException,
            TaobaoSessionExpiredException,
            TaobaoEnhancedApiException {
        boolean result = settingService.addExcludeItem(56912708L, numIid);
        return "add excludeItem " + result;
    }

    /**
     * @param numIid
     * @return
     * @throws ShowcaseException
     * @throws TaobaoSessionExpiredException
     * @throws TaobaoEnhancedApiException
     */
    @RequestMapping("/deleteExcludeItem")
    @ResponseBody
    public String deleteExcludeItem(@RequestParam Long numIid) throws
            ShowcaseException,
            TaobaoSessionExpiredException,
            TaobaoEnhancedApiException {
        boolean result = settingService.deleteExcludeItem(56912708L, numIid);
        return "delete excludeItem " + result;
    }

    /**
     * 搜索在线商品
     *
     * @param query
     * @param pageNum
     * @return
     * @throws TaobaoEnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/searchOnSale", method = RequestMethod.GET)
    Page<ShowcaseItem> searchOnSaleItem(@RequestParam(required = false) String query, @RequestParam int pageNum) throws
            TaobaoEnhancedApiException, TaobaoSessionExpiredException, TaobaoAccessControlException {
        return settingService.paginateOnSaleItems(
                56912708L,
                query,
                null,
                pageNum,
                1,
                true,
                ShowcaseConstants.ASC_ORDER_BY_DELIST_TIME);
    }

    /**
     * 搜索仓库商品
     *
     * @param query
     * @param pageNum
     * @return
     * @throws TaobaoEnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/searchOnInventory", method = RequestMethod.GET)
    Page<ShowcaseItem> searchOnInventory(@RequestParam(required = false) String query, @RequestParam int pageNum) throws
            TaobaoEnhancedApiException, TaobaoSessionExpiredException, TaobaoAccessControlException {
        return settingService.paginateInventoryItems(56912708L,
                query,
                ShowcaseConstants.INVENTORY_BANNER_TYPES,
                null,
                pageNum,
                1,
                true,
                ShowcaseConstants.ASC_ORDER_BY_DELIST_TIME);
    }
}
