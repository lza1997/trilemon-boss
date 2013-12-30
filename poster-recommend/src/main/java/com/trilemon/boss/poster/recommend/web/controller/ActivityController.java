package com.trilemon.boss.poster.recommend.web.controller;

import com.trilemon.boss.infra.base.service.SessionService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivity;
import com.trilemon.boss.poster.recommend.model.dto.ActivityItem;
import com.trilemon.boss.poster.recommend.service.PosterRecommendException;
import com.trilemon.boss.poster.recommend.service.RecommendActivityService;
import com.trilemon.boss.poster.recommend.service.RecommendTemplateService;
import com.trilemon.commons.web.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 海报活动，就是用户制作的海报
 *
 * @author edokeh
 */
@Controller
@RequestMapping("/activities")
public class ActivityController {
    @Autowired
    private RecommendActivityService activityService;
    @Autowired
    private RecommendTemplateService templateService;
    @Autowired
    private SessionService sessionService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Page<ActivityItem> index(String key, @RequestParam(defaultValue = "1") Integer page, Long category) throws TaobaoSessionExpiredException, TaobaoAccessControlException, TaobaoEnhancedApiException {
        List<Long> categoryIds = new ArrayList<Long>();
        if (category != null) {
            categoryIds.add(category);
        }
        return activityService.paginateItems(sessionService.getUserId(), null, true, key, categoryIds, page, 4);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public PosterRecommendActivity create(@RequestBody PosterRecommendActivity activity) throws PosterRecommendException {
        return activityService.createActivityDesignS1(sessionService.getUserId(), activity);
    }

    /**
     * 获取活动
     * @param id
     * @param detail 是否包含模板对象
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PosterRecommendActivity show(@PathVariable Long id, Boolean detail) {
        PosterRecommendActivity activity = activityService.getActivity(sessionService.getUserId(), id);
        if (detail) {
            activity.setTemplate(templateService.getTemplate(activity.getTemplateId()));
        }
        return activity;
    }
}