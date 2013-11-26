package com.trilemon.boss.inventory.web.controller;

import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.inventory.InventoryException;
import com.trilemon.boss.inventory.model.InventoryListSetting;
import com.trilemon.boss.inventory.service.InventoryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 仓库计划设置
 */
@Controller
@RequestMapping("/setting")
public class SettingController {
    @Autowired
    private InventoryListService inventoryListService;

    /**
     * 获取当前计划设置
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public InventoryListSetting show() throws TaobaoSessionExpiredException, TaobaoAccessControlException, InventoryException,
            TaobaoEnhancedApiException {
        return inventoryListService.getSetting(56912708L);
    }

    /**
     * 创建计划设置
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public InventoryListSetting create() throws TaobaoSessionExpiredException, TaobaoAccessControlException, InventoryException,
            TaobaoEnhancedApiException {
        inventoryListService.createSetting(56912708L, new ArrayList<String>());
        return inventoryListService.getSetting(56912708L);
    }

    /**
     * 修改计划所属的仓库类型
     *
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public InventoryListSetting update(@RequestBody @Valid InventoryListSetting setting) throws TaobaoSessionExpiredException, TaobaoEnhancedApiException, TaobaoAccessControlException {
        inventoryListService.updateIncludeBanners(56912708L, Arrays.asList(setting.getIncludeBanners().split(",")));
        return inventoryListService.getSetting(56912708L);
    }

    /**
     * 暂停
     */
    @RequestMapping(value = "/pause", method = RequestMethod.POST)
    @ResponseBody
    public InventoryListSetting pauseSetting() throws InventoryException, TaobaoSessionExpiredException, TaobaoEnhancedApiException {
        inventoryListService.pauseSetting(56912708L);
        return inventoryListService.getSetting(56912708L);
    }

    /**
     * 开启规则
     */
    @RequestMapping(value = "/pause", method = RequestMethod.DELETE)
    @ResponseBody
    public InventoryListSetting resumeSetting() throws TaobaoSessionExpiredException, TaobaoAccessControlException, InventoryException, TaobaoEnhancedApiException {
        inventoryListService.resumeSetting(56912708L);
        return inventoryListService.getSetting(56912708L);
    }

}
