package com.trilemon.boss360.inventory.web.controller;

import com.trilemon.boss360.inventory.service.InventoryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author kevin
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private InventoryListService inventoryListService;

    @ResponseBody
    @RequestMapping(value = "/shelfStatus", method = RequestMethod.GET)
    public int[] shelfStatus() {
        int[] inventoryItemNum = new int[]{0, 0};
//        inventoryItemNum[0] = inventoryListService.getNeverOnShelfItemNum();
//        inventoryItemNum[1] = inventoryListService.getOffShelfItemNum();
        return inventoryItemNum;
    }
    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public void create() {
    }


}
