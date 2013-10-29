package com.trilemon.boss360.shelf.web.controller;

import com.trilemon.boss360.infrastructure.base.service.api.TaobaoApiShopService;
import com.trilemon.boss360.infrastructure.base.service.api.TaobaoEnhancedApiException;
import com.trilemon.boss360.infrastructure.base.service.api.TaobaoSessionExpiredException;
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
    Page<Item> index(String key, @RequestParam(defaultValue = "") Long[] cids, @RequestParam(defaultValue = "1") int
            page, @RequestParam(required = false) Long pid) throws TaobaoEnhancedApiException,
            TaobaoSessionExpiredException {
        Page<Plan> plans = planSettingService.paginatePlans(56912708L, pid, page, 2);
        Page<Item> itemPage = Page.empty();
        itemPage.setTotalSize(plans.getTotalSize());
        itemPage.setPageSize(plans.getPageSize());
        itemPage.setPageNum(plans.getPageNum());
        itemPage.setItems(ShelfUtils.planToItem(plans.getItems()));
        return itemPage;
    }

    /**
     * 需要一个与淘宝提供的 Item 略有不同的 class
     */
    public static class Item {
        private String title;
        private Long numIid;
        private String picUrl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Long getNumIid() {
            return numIid;
        }

        public void setNumIid(Long numIid) {
            this.numIid = numIid;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public boolean isExclude() {
            return exclude;
        }

        public void setExclude(boolean exclude) {
            this.exclude = exclude;
        }

        private boolean exclude;

    }
}
