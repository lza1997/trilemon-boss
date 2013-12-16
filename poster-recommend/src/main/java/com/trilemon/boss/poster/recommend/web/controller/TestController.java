package com.trilemon.boss.poster.recommend.web.controller;

import com.google.common.collect.Lists;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivity;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivityItem;
import com.trilemon.boss.poster.recommend.model.PosterRecommendPublishItem;
import com.trilemon.boss.poster.recommend.model.PosterRecommendRecommendTemplate;
import com.trilemon.boss.poster.recommend.model.dto.ActivityItem;
import com.trilemon.boss.poster.recommend.model.dto.LastUsedPosterTemplate;
import com.trilemon.boss.poster.recommend.model.dto.PublishItem;
import com.trilemon.boss.poster.recommend.model.dto.PublishProgress;
import com.trilemon.boss.poster.recommend.service.RecommendActivityService;
import com.trilemon.boss.poster.recommend.service.RecommendPublishService;
import com.trilemon.boss.poster.recommend.service.RecommendTemplateService;
import com.trilemon.boss.poster.template.model.PosterTemplate;
import com.trilemon.boss.poster.template.model.PosterTemplateCategory;
import com.trilemon.boss.poster.template.model.PosterTemplateTopic;
import com.trilemon.commons.DateUtils;
import com.trilemon.commons.web.Page;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author kevin
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RecommendActivityService activityService;
    @Autowired
    private RecommendPublishService publishService;
    @Autowired
    private RecommendTemplateService templateService;

    //*******************活动测试********************
    @ResponseBody
    @RequestMapping(value = "/getActivity", method = RequestMethod.GET)
    public PosterRecommendActivity getActivity(@RequestParam Long userId, @RequestParam Long activityId) {
        return activityService.getActivity(userId, activityId);
    }

    @ResponseBody
    @RequestMapping(value = "/createActivityDesignPart", method = RequestMethod.GET)
    public String createActivityDesignPart(@RequestParam Long userId) {
        PosterRecommendActivity activity = new PosterRecommendActivity();
        activity.setTemplateId(100L);
        activity.setTitle("测试活动设计部分");
        activity.setColor("12344");
        activity.setSize(790);
        activityService.createActivityDesignPart(userId, activity);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/updateActivityPublishPart", method = RequestMethod.GET)
    public String updateActivityPublishPart(@RequestParam Long userId, @RequestParam Long activityId, byte detailPagePosition) {
        PosterRecommendActivity activity = new PosterRecommendActivity();
        activity.setId(activityId);
        activity.setDetailPagePosition((byte) 1);
        activity.setPublishEndTime(DateUtils.endOfNDaysBefore(10).toDate());
        activity.setPublishEndTime(DateUtils.endOfNDaysBefore(1).toDate());
        activity.setPublishHtml("<a>test</a>");
        activityService.updateActivityPublishPart(userId, activity);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/updateActivityDetailPagePosition", method = RequestMethod.GET)
    public boolean updateActivityDetailPagePosition(@RequestParam Long userId, @RequestParam Long activityId, byte detailPagePosition) {
        return activityService.updateActivityDetailPagePosition(userId, activityId, detailPagePosition);
    }

    @ResponseBody
    @RequestMapping(value = "/updateActivityPublishTime", method = RequestMethod.GET)
    public boolean updateActivityPublishTime(@RequestParam Long userId, @RequestParam Long activityId, byte publishType) {
        return activityService.updateActivityPublishTime(userId, activityId, publishType,
                DateUtils.endOfNDaysBefore(100).toDate(), DateUtils.endOfNDaysBefore(10).toDate());
    }

    @ResponseBody
    @RequestMapping(value = "/deleteActivity", method = RequestMethod.GET)
    public String deleteActivity(@RequestParam Long userId, @RequestParam Long activityId, boolean deleteDetailPage) {
        activityService.deleteActivity(userId, activityId, deleteDetailPage);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/getActivityPublishHtml", method = RequestMethod.GET)
    public String getActivityPublishHtml(@RequestParam Long userId, @RequestParam Long activityId) {
        return activityService.getActivityPublishHtml(userId, activityId);
    }

    @ResponseBody
    @RequestMapping(value = "/addActivityItem", method = RequestMethod.GET)
    public PosterRecommendActivityItem addActivityItem(@RequestParam Long userId, @RequestParam Long activityId) {
        PosterRecommendActivityItem posterRecommendActivityItem = new PosterRecommendActivityItem();
        posterRecommendActivityItem.setItemNumIid(123456L);
        posterRecommendActivityItem.setItemPicUrl("pic_url");
        posterRecommendActivityItem.setItemPrice(BigDecimal.TEN);
        posterRecommendActivityItem.setItemTitle("test title");
        return activityService.addActivityItem(userId, activityId, posterRecommendActivityItem);
    }

    @ResponseBody
    @RequestMapping(value = "/removeActivityItem", method = RequestMethod.GET)
    public int removeActivityItem(@RequestParam Long userId, @RequestParam Long activityId,
                                  @RequestParam Long itemNumIid) {
        return activityService.removeActivityItem(userId, activityId, itemNumIid);
    }

    @ResponseBody
    @RequestMapping(value = "/paginateActivityAddedItems", method = RequestMethod.GET)
    public Page<PosterRecommendActivityItem> paginateActivityAddedItems(@RequestParam Long userId, @RequestParam Long activityId,
                                                                        @RequestParam Integer pageNum) {
        return activityService.paginateActivityAddedItems(userId, activityId, pageNum, 2);
    }

    @ResponseBody
    @RequestMapping(value = "/paginateItems", method = RequestMethod.GET)
    public Page<ActivityItem> paginateItems(@RequestParam Long userId, @RequestParam Long activityId,
                                            @RequestParam Integer pageNum) throws TaobaoSessionExpiredException, TaobaoAccessControlException, TaobaoEnhancedApiException {
        return activityService.paginateItems(userId, activityId, true, "充电", null, pageNum, 2);
    }

    @ResponseBody
    @RequestMapping(value = "/getLastUsedPosterTemplate", method = RequestMethod.GET)
    public LastUsedPosterTemplate getLastUsedPosterTemplate(@RequestParam Long userId) {
        return activityService.getLastUsedPosterTemplate(userId);
    }

    @ResponseBody
    @RequestMapping(value = "/paginateActivity", method = RequestMethod.GET)
    public Page<PosterRecommendActivity> paginateActivity(@RequestParam Long userId, @RequestParam Integer pageNum) {
        return activityService.paginateActivity(userId, pageNum, 2);
    }

    //*******************投放测试********************
    @ResponseBody
    @RequestMapping(value = "/addPublishItem", method = RequestMethod.GET)
    public PosterRecommendPublishItem addPublishItem(@RequestParam Long userId, @RequestParam Long activityId) {
        PosterRecommendPublishItem posterRecommendPublishItem = new PosterRecommendPublishItem();
        posterRecommendPublishItem.setPublishTime(DateTime.now().toDate());
        posterRecommendPublishItem.setItemPicUrl("pic_url");
        posterRecommendPublishItem.setItemPrice(BigDecimal.TEN);
        posterRecommendPublishItem.setItemTitle("test title");
        return publishService.addPublishItem(userId, activityId, posterRecommendPublishItem);
    }

    @ResponseBody
    @RequestMapping(value = "/removePublishItem", method = RequestMethod.GET)
    public int removePublishItem(@RequestParam Long userId, @RequestParam Long activityId,
                                 @RequestParam Long itemNumIid) {
        return publishService.removePublishItem(userId, activityId, itemNumIid);
    }

    @ResponseBody
    @RequestMapping(value = "/publishActivity", method = RequestMethod.GET)
    public void publishActivity(@RequestParam Long userId, @RequestParam Long activityId) {
        publishService.publishActivity(userId, activityId);
    }

    @ResponseBody
    @RequestMapping(value = "/paginatePublishAddedItems", method = RequestMethod.GET)
    public Page<PosterRecommendPublishItem> paginatePublishAddedItems(@RequestParam Long userId, @RequestParam Long activityId,
                                                                      @RequestParam Integer pageNum) {
        return publishService.paginatePublishAddedItems(userId, activityId, pageNum, 2);
    }

    @ResponseBody
    @RequestMapping(value = "/publish_paginateItems", method = RequestMethod.GET)
    public Page<PublishItem> publishPaginateItems(@RequestParam Long userId, @RequestParam Long activityId,
                                                  @RequestParam Integer pageNum) throws TaobaoSessionExpiredException, TaobaoAccessControlException, TaobaoEnhancedApiException {
        return publishService.paginateItems(userId, activityId, true, "充电", null, pageNum, 2);
    }

    @ResponseBody
    @RequestMapping(value = "/queryPublishProgress", method = RequestMethod.GET)
    public PublishProgress queryPublishProgress(@RequestParam Long userId, @RequestParam Long activityId) {
        return publishService.queryPublishProgress(userId, activityId);
    }

    //*******************模板测试********************
    @ResponseBody
    @RequestMapping(value = "/getRecommendPosterTemplate", method = RequestMethod.GET)
    public List<PosterRecommendRecommendTemplate> getRecommendPosterTemplate(@RequestParam Long userId, @RequestParam Byte recommendType) {
        return templateService.getRecommendPosterTemplate(userId, recommendType);
    }

    @ResponseBody
    @RequestMapping(value = "/paginatePosterTemplates", method = RequestMethod.GET)
    public Page<PosterTemplate> paginatePosterTemplates(@RequestParam Long userId, @RequestParam int pageNum) {
        return templateService.paginatePosterTemplates(userId, Lists.newArrayList(1, 2), Lists.newArrayList(1, 2),
                pageNum, 2);
    }

    @ResponseBody
    @RequestMapping(value = "/getTemplateCategories", method = RequestMethod.GET)
    public List<PosterTemplateCategory> getTemplateCategories() {
        return templateService.getTemplateCategories();
    }

    @ResponseBody
    @RequestMapping(value = "/getTemplateTopics", method = RequestMethod.GET)
    public List<PosterTemplateTopic> getTemplateTopics() {
        return templateService.getTemplateTopics();
    }
}
