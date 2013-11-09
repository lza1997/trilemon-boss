package com.trilemon.boss360.showcase.web.controller;

import com.taobao.api.domain.Item;
import com.trilemon.boss360.infrastructure.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss360.infrastructure.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss360.infrastructure.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss360.showcase.ShowcaseConstants;
import com.trilemon.boss360.showcase.ShowcaseException;
import com.trilemon.boss360.showcase.model.Setting;
import com.trilemon.boss360.showcase.service.SettingService;
import com.trilemon.commons.web.Page;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/create")
    @ResponseBody
    public Setting create() throws ShowcaseException, TaobaoSessionExpiredException, TaobaoEnhancedApiException, TaobaoAccessControlException {
        Setting setting = new Setting();
        setting.setExcludeItemDelistingAfter((int) 6.5 * 24 * 60);
        setting.setExcludeItemDelistingWithin(30);
        setting.setExcludeItemInventoryLt(1);
        setting.setExcludeItemNumIids("19440841598");
        setting.setIncludeItemNumIids("19480514567,19491833743");
        setting.setIncludeSellerCids("804731967");
        setting.setRuleType(ShowcaseConstants.RULE_TYPE_INCLUDE_SELLER_CIDS);
        setting.setStatus(ShowcaseConstants.SETTING_STATUS_RUNNING);
        setting.setUserId(56912708L);
        setting.setAddTime(DateTime.now().toDate());
        settingService.createSetting(56912708L, setting);
        return setting;
    }

    @RequestMapping("/update")
    @ResponseBody
    public Setting update() throws ShowcaseException, TaobaoSessionExpiredException, TaobaoEnhancedApiException, TaobaoAccessControlException {
        Setting setting = new Setting();
        setting.setExcludeItemDelistingAfter((int) 6.5 * 24 * 60);
        setting.setExcludeItemDelistingWithin(30);
        setting.setExcludeItemInventoryLt(5);
        setting.setExcludeItemNumIids("19440841598");
        setting.setIncludeItemNumIids("19480514567,19491833743");
        setting.setIncludeSellerCids("804731967");
        setting.setRuleType(ShowcaseConstants.RULE_TYPE_INCLUDE_SELLER_CIDS);
        setting.setStatus(ShowcaseConstants.SETTING_STATUS_RUNNING);
        setting.setUserId(56912708L);
        setting.setAddTime(DateTime.now().toDate());
        settingService.updateSetting(56912708L, setting);
        return setting;
    }

    @RequestMapping("/getSetting")
    @ResponseBody
    public Setting getSetting() throws ShowcaseException, TaobaoSessionExpiredException, TaobaoEnhancedApiException {
        return settingService.getSetting(56912708L);
    }

    @RequestMapping("/resumeSetting")
    @ResponseBody
    public String resumeSetting() throws ShowcaseException, TaobaoSessionExpiredException, TaobaoEnhancedApiException, TaobaoAccessControlException {
        settingService.resumeSetting(56912708L);
        return "resume success";
    }

    @RequestMapping("/pauseSetting")
    @ResponseBody
    public String pauseSetting() throws ShowcaseException, TaobaoSessionExpiredException, TaobaoEnhancedApiException {
        settingService.pauseSetting(56912708L);
        return "pause success";
    }

    @RequestMapping("/includeItem")
    @ResponseBody
    public String includeItem(@RequestParam Long numIid, @RequestParam Boolean addOrDelete) throws
            ShowcaseException,
            TaobaoSessionExpiredException,
            TaobaoEnhancedApiException {
        settingService.includeItem(56912708L, numIid, addOrDelete);
        return "includeItem success";
    }

    @RequestMapping("/excludeItem")
    @ResponseBody
    public String excludeItem(@RequestParam Long numIid, @RequestParam Boolean addOrDelete) throws
            ShowcaseException,
            TaobaoSessionExpiredException,
            TaobaoEnhancedApiException {
        settingService.excludeItem(56912708L, numIid, addOrDelete);
        return "excludeItem success";
    }

    @RequestMapping("/paginateShowcaseItems")
    @ResponseBody
    public Page<Item> paginateShowcaseItems(@RequestParam Integer pageNum, @RequestParam Integer pageSize) throws
            ShowcaseException,
            TaobaoSessionExpiredException,
            TaobaoEnhancedApiException, TaobaoAccessControlException {
      return  settingService.paginateShowcaseItems(56912708L, pageNum, pageSize);
    }
}
