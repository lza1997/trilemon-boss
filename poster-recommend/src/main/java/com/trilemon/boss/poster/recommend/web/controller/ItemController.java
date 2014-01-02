package com.trilemon.boss.poster.recommend.web.controller;

import com.trilemon.boss.infra.base.service.SessionService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.poster.recommend.model.dto.ActivityItem;
import com.trilemon.boss.poster.recommend.service.RecommendActivityService;
import com.trilemon.commons.web.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 所有宝贝
 *
 * @author edokeh
 */
@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private RecommendActivityService activityService;

    @Autowired
    private SessionService sessionService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Page<ActivityItem> index(String key, @RequestParam(defaultValue = "1") Integer page, Long category,@RequestParam(defaultValue = "true") Boolean onsale) throws TaobaoSessionExpiredException, TaobaoAccessControlException, TaobaoEnhancedApiException {
        List<Long> categoryIds = new ArrayList<Long>();
        if (category != null) {
            categoryIds.add(category);
        }
        return activityService.paginateItems(sessionService.getUserId(), null, onsale, key, categoryIds, page, 4);
    }
}