package com.trilemon.boss.poster.recommend.web.controller;

import com.google.common.collect.Lists;
import com.taobao.api.domain.Item;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.poster.recommend.PosterRecommendConstants;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivity;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivityItem;
import com.trilemon.boss.poster.recommend.model.PosterRecommendPublishItem;
import com.trilemon.boss.poster.recommend.model.PosterRecommendRecommendTemplate;
import com.trilemon.boss.poster.recommend.model.dto.ActivityItem;
import com.trilemon.boss.poster.recommend.model.dto.LastUsedPosterTemplate;
import com.trilemon.boss.poster.recommend.model.dto.PublishItem;
import com.trilemon.boss.poster.recommend.model.dto.PublishProgress;
import com.trilemon.boss.poster.recommend.service.PosterRecommendException;
import com.trilemon.boss.poster.recommend.service.RecommendActivityService;
import com.trilemon.boss.poster.recommend.service.RecommendPublishService;
import com.trilemon.boss.poster.recommend.service.RecommendTemplateService;
import com.trilemon.boss.poster.template.model.PosterTemplate;
import com.trilemon.boss.poster.template.model.PosterTemplateCategory;
import com.trilemon.boss.poster.template.model.PosterTemplateTopic;
import com.trilemon.commons.DateUtils;
import com.trilemon.commons.web.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.trilemon.boss.poster.recommend.PosterRecommendConstants.*;

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
    @RequestMapping(value = "/createActivityDesignS1", method = RequestMethod.GET)
    public String createActivityDesignS1(@RequestParam Long userId) {
        PosterRecommendActivity activity = new PosterRecommendActivity();
        activity.setTemplateId(100L);
        activity.setTitle("测试活动设计部分");
        activity.setColor("12344");
        activity.setSize(790);
        activity.setPublishHtml("<a>test</a>");

        //测试数据
        List<ActivityItem> activityItems=Lists.newArrayList();
        //加入
        ActivityItem activityItem1=new ActivityItem();
        activityItem1.setActivityItemStatus(ACTIVITY_ITEM_STATUS_NOT_IN_DB);
        activityItem1.setStatus(ActivityItem.STATUS_NEW);
        Item item1=new Item();
        item1.setTitle("test title");
        item1.setNumIid(123L);
        item1.setPrice("123.12");
        item1.setPicUrl("test pic url");
        activityItem1.setItem(item1);
        activityItems.add(activityItem1);

        //更新
        ActivityItem activityItem2=new ActivityItem();
        activityItem2.setActivityItemStatus(PosterRecommendConstants.ACTIVITY_ITEM_STATUS_NORMAL);
        activityItem2.setStatus(ActivityItem.STATUS_UPDATED);
        Item item2=new Item();
        item2.setTitle("test title 2");
        item2.setNumIid(1234L);
        item2.setPrice("123.12");
        item2.setPicUrl("test pic url2");
        activityItem2.setItem(item2);
        activityItems.add(activityItem2);

        //删除
        ActivityItem activityItem3=new ActivityItem();
        activityItem3.setActivityItemStatus(PosterRecommendConstants.ACTIVITY_ITEM_STATUS_NORMAL);
        activityItem3.setStatus(ActivityItem.STATUS_DELETED);
        Item item3=new Item();
        item3.setTitle("test title 3");
        item3.setNumIid(12345L);
        item3.setPrice("123.12");
        item3.setPicUrl("test pic url2");
        activityItem3.setItem(item3);
        activityItems.add(activityItem3);

        activityService.createActivityDesignS1(userId, activity,activityItems);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/updateActivityDesignS2", method = RequestMethod.GET)
    public String updateActivityDesignS2(@RequestParam Long userId) throws PosterRecommendException {
        PosterRecommendActivity activity = new PosterRecommendActivity();
        activity.setId(3L);
        activity.setTitle("测试活动设计部分S2");
        activity.setPublishHtml("<a>test_html</a>");
        activityService.updateActivityDesignS2(userId, activity);
        return "success";
    }



    @ResponseBody
    @RequestMapping(value = "/updateActivityPublishPart", method = RequestMethod.GET)
    public String updateActivityPublishPart(@RequestParam Long userId, @RequestParam Long activityId) {
        PosterRecommendActivity activity = new PosterRecommendActivity();
        activity.setId(activityId);
        activity.setDetailPagePosition((byte) 1);
        activity.setPublishStartTime(DateUtils.endOfNDaysBefore(10).toDate());
        activity.setPublishEndTime(DateUtils.endOfNDaysBefore(1).toDate());

        //测试数据
        List<PublishItem> publishItems=Lists.newArrayList();
        //加入
        PublishItem publishItem1=new PublishItem();
        publishItem1.setPublishItemStatus(PUBLISH_ITEM_STATUS_NOT_IN_DB);
        publishItem1.setStatus(PublishItem.STATUS_NEW);
        Item item1=new Item();
        item1.setTitle("test title");
        item1.setNumIid(123L);
        item1.setPrice("123.12");
        item1.setPicUrl("test pic url");
        publishItem1.setItem(item1);
        publishItems.add(publishItem1);

        //删除
        PublishItem publishItem2=new PublishItem();
        publishItem2.setPublishItemStatus(PosterRecommendConstants.PUBLISH_ITEM_STATUS_WAITING_PUBLISH);
        publishItem2.setStatus(PublishItem.STATUS_DELETED);
        Item item2=new Item();
        item2.setTitle("test title 2");
        item2.setNumIid(1234L);
        item2.setPrice("123.12");
        item2.setPicUrl("test pic url2");
        publishItem2.setItem(item2);
        publishItems.add(publishItem2);

        activityService.updateActivityPublishPart(userId, activity,publishItems);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/deleteActivity", method = RequestMethod.GET)
    public String deleteActivity(@RequestParam Long userId, @RequestParam Long activityId) {
        activityService.deleteActivity(userId, activityId);
        return "success";
    }

    @ResponseBody
    @RequestMapping(value = "/getActivityPublishHtml", method = RequestMethod.GET)
    public String getActivityPublishHtml(@RequestParam Long userId, @RequestParam Long activityId) {
        return activityService.getActivityPublishHtml(userId, activityId);
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
        return activityService.paginateActivityByUserId(userId, ALL_ACTIVITY_STATUS, null, pageNum, 2);
    }

    //*******************投放测试********************
    @ResponseBody
    @RequestMapping(value = "/publishActivity", method = RequestMethod.GET)
    public void publishActivity(@RequestParam Long userId, @RequestParam Long activityId) {
        publishService.publishActivity(userId, activityId);
    }

    @ResponseBody
    @RequestMapping(value = "/unpublishActivity", method = RequestMethod.GET)
    public void unpublishActivity(@RequestParam Long userId, @RequestParam Long activityId) {
        publishService.unpublishActivity(userId, activityId);
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
        return templateService.paginatePosterTemplates(Lists.newArrayList(1, 2), Lists.newArrayList(1, 2),
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
