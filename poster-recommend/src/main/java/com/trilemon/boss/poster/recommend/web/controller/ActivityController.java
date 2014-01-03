package com.trilemon.boss.poster.recommend.web.controller;

import com.trilemon.boss.infra.base.service.SessionService;
import com.trilemon.boss.poster.recommend.PosterRecommendConstants;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivity;
import com.trilemon.boss.poster.recommend.service.PosterRecommendException;
import com.trilemon.boss.poster.recommend.service.RecommendActivityService;
import com.trilemon.boss.poster.recommend.service.RecommendPublishService;
import com.trilemon.commons.web.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    private RecommendPublishService publishService;
    @Autowired
    private SessionService sessionService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Page<PosterRecommendActivity> index(@RequestParam(defaultValue = "1") Integer page) {
        return activityService.paginateActivityByUserId(sessionService.getUserId(), PosterRecommendConstants.ALL_LIST_ACTIVITY_STATUS, null, page, 5);
    }

    /**
     * 创建，这一步对应选择宝贝后
     *
     * @param activity
     * @return
     * @throws PosterRecommendException
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public PosterRecommendActivity create(@RequestBody PosterRecommendActivity activity) throws PosterRecommendException {
        return activityService.createActivityDesignS1(sessionService.getUserId(), activity);
    }

    /**
     * 修改活动的标题、HTML
     *
     * @param activity
     * @return
     * @throws PosterRecommendException
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/html", method = RequestMethod.PUT)
    public void html(@RequestBody PosterRecommendActivity activity) throws PosterRecommendException {
        activityService.updateActivityDesignS2(sessionService.getUserId(), activity);
    }

    /**
     * 修改活动的标题、HTML
     *
     * @param activity
     * @return
     * @throws PosterRecommendException
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/publish-setting", method = RequestMethod.PUT)
    public void publishSetting(@RequestBody PosterRecommendActivity activity) throws PosterRecommendException {
        activityService.updateActivityPublishPart(sessionService.getUserId(), activity);
    }

    /**
     * 获取活动
     *
     * @param id
     * @param template 是否包含模板对象
     * @param publishItems
     * @param activityItems
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PosterRecommendActivity show(@PathVariable Long id,
                                        @RequestParam(defaultValue = "false") Boolean template,
                                        @RequestParam(defaultValue = "false") Boolean publishItems,
                                        @RequestParam(defaultValue = "false") Boolean activityItems) {
        PosterRecommendActivity activity = activityService.getActivity(sessionService.getUserId(), id, activityItems, publishItems, template);
        return activity;
    }

    /**
     * 删除
     *
     * @param id
     */
    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        activityService.deleteActivity(sessionService.getUserId(), id);
    }

    /**
     * 发布
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/publish", method = RequestMethod.POST)
    public PosterRecommendActivity publish(@PathVariable Long id) {
        publishService.publishActivity(sessionService.getUserId(), id);
        return activityService.getActivity(sessionService.getUserId(), id, false, false, false);
    }

    /**
     * 停止发布
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/publish", method = RequestMethod.DELETE)
    public PosterRecommendActivity unpublish(@PathVariable Long id) {
        publishService.unpublishActivity(sessionService.getUserId(), id);
        return activityService.getActivity(sessionService.getUserId(), id, false, false, false);
    }
}