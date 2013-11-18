package com.trilemon.boss.inventory.web.controller;

import com.google.common.collect.ImmutableList;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.inventory.InventoryConstants;
import com.trilemon.boss.inventory.InventoryException;
import com.trilemon.boss.inventory.model.InventoryListSetting;
import com.trilemon.boss.inventory.service.InventoryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author kevin
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private InventoryListService inventoryListService;

    @ResponseBody
    @RequestMapping(value = "/getInventoryItemNum", method = RequestMethod.GET)
    public Map<String, Long> getInventoryItemNum() throws TaobaoEnhancedApiException, TaobaoSessionExpiredException, TaobaoAccessControlException {
        return inventoryListService.getInventoryItemNum(56912708L);
    }

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public void create() throws TaobaoSessionExpiredException, TaobaoAccessControlException, InventoryException,
            TaobaoEnhancedApiException {
        inventoryListService.createSetting(56912708L, ImmutableList.of(InventoryConstants.BANNER_REGULAR_SHELVED));
    }

    @ResponseBody
    @RequestMapping(value = "/resume", method = RequestMethod.GET)
    public void resume() throws TaobaoSessionExpiredException, TaobaoAccessControlException, InventoryException, TaobaoEnhancedApiException {
        inventoryListService.resumeSetting(56912708L);
    }

    @ResponseBody
    @RequestMapping(value = "/pause", method = RequestMethod.GET)
    public void pause() throws TaobaoSessionExpiredException, TaobaoAccessControlException, InventoryException,
            TaobaoEnhancedApiException {
        inventoryListService.pauseSetting(56912708L);
    }

    @ResponseBody
    @RequestMapping(value = "/getSetting", method = RequestMethod.GET)
    public InventoryListSetting getSetting() throws TaobaoSessionExpiredException, TaobaoAccessControlException, InventoryException,
            TaobaoEnhancedApiException {
      return  inventoryListService.getSetting(56912708L);
    }

    @ResponseBody
    @RequestMapping(value = "/updateIncludeBanners", method = RequestMethod.GET)
    public void updateIncludeBanners() throws TaobaoSessionExpiredException, TaobaoAccessControlException, InventoryException,
            TaobaoEnhancedApiException {
        inventoryListService.updateIncludeBanners(56912708L, ImmutableList.of(InventoryConstants.BANNER_REGULAR_SHELVED,
                InventoryConstants.BANNER_NEVER_ON_SHELF));
    }

    @ResponseBody
    @RequestMapping(value = "/excludeItem", method = RequestMethod.GET)
    public void excludeItem(@RequestParam Long numIid) throws TaobaoSessionExpiredException,
            TaobaoAccessControlException, InventoryException,
            TaobaoEnhancedApiException {
        inventoryListService.excludeItem(56912708L, numIid);
    }
    @ResponseBody
    @RequestMapping(value = "/includeItem", method = RequestMethod.GET)
    public void includeItem(@RequestParam Long numIid) throws TaobaoSessionExpiredException,
            TaobaoAccessControlException, InventoryException,
            TaobaoEnhancedApiException {
        inventoryListService.includeItem(56912708L, numIid);
    }

}
