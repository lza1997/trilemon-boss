package com.trilemon.boss.inventory.web.controller;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.trilemon.boss.inventory.InventoryConstants;
import com.trilemon.boss.inventory.model.InventoryListItem;
import com.trilemon.boss.inventory.service.InventoryListService;
import com.trilemon.commons.web.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nullable;
import java.util.List;

import static com.trilemon.commons.Collections3.COMMA_SPLITTER;

/**
 * 仓库计划的宝贝
 *
 * @author edokeh
 */
@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private InventoryListService inventoryListService;


    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Page<InventoryListItem> index(
            String key, @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = InventoryConstants.BANNER_NEVER_ON_SHELF + "," + InventoryConstants.BANNER_FOR_SHELVED) String banner,
            @RequestParam(defaultValue = InventoryConstants.LIST_STATUS_SUCCESSFUL + "," + InventoryConstants.LIST_STATUS_WAITING_ADJUST) String status) {

        List<String> statusList = COMMA_SPLITTER.splitToList(status);
        List<String> banners = COMMA_SPLITTER.splitToList(banner);

        List<Byte> statusByteList = Lists.transform(statusList, new Function<String, Byte>() {
            @Nullable
            @Override
            public Byte apply(@Nullable String s) {
                return Byte.parseByte(s);
            }
        });

        return inventoryListService.paginationInventoryListItems(56912708L, key, page, 2, statusByteList, banners);
    }

    /**
     * 移除
     */
    @ResponseBody
    @RequestMapping(value = "/{itemIid}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long itemIid) {
        inventoryListService.excludeItem(56912708L, itemIid);
        inventoryListService.includeItem();
    }

//    /**
//     * 设置固定推荐或取消
//     */
//    @RequestMapping(value = "/include", method = RequestMethod.PUT)
//    @ResponseBody
//    public String includeItem(@RequestBody IncludeJSONParam jsonParam) throws ShowcaseException, TaobaoSessionExpiredException, TaobaoAccessControlException, TaobaoEnhancedApiException {
//        for (Long numIid : jsonParam.numIids) {
//            if (jsonParam.include) {
//                settingService.addIncludeItem(56912708L, numIid);
//            } else {
//                settingService.deleteIncludeItem(56912708L, numIid);
//            }
//        }
//        return "";
//    }

    /**
     * 辅助，用于接收 JSON Request
     */
    public static class IncludeJSONParam {
        public Long[] numIids;
        public boolean include;
    }
}