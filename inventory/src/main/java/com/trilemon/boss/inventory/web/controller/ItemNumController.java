package com.trilemon.boss.inventory.web.controller;

import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.inventory.InventoryException;
import com.trilemon.boss.inventory.service.InventoryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 仓库中宝贝的数量
 */
@Controller
@RequestMapping("/item-num")
public class ItemNumController {
    @Autowired
    private InventoryListService inventoryListService;

    /**
     * 获取当前计划设置
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Map<String, Long> show() throws TaobaoSessionExpiredException, TaobaoAccessControlException, InventoryException,
            TaobaoEnhancedApiException {
        return inventoryListService.getInventoryItemNum(56912708L);
    }
}
