package com.trilemon.boss.poster.recommend.service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.taobao.api.domain.Item;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.infra.base.service.api.TaobaoApiShopService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.poster.recommend.PosterRecommendConstants;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendActivityDAO;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendActivityItemDAO;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendPublishItemDAO;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendUserDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivity;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivityItem;
import com.trilemon.boss.poster.recommend.model.PosterRecommendPublishItem;
import com.trilemon.boss.poster.recommend.model.PosterRecommendUser;
import com.trilemon.boss.poster.recommend.model.dto.ActivityItem;
import com.trilemon.boss.poster.recommend.model.dto.LastUsedPosterTemplate;
import com.trilemon.boss.poster.recommend.model.dto.PublishItem;
import com.trilemon.boss.poster.recommend.model.dto.PublishProgress;
import com.trilemon.boss.poster.template.client.PosterTemplateClient;
import com.trilemon.boss.poster.template.model.PosterTemplate;
import com.trilemon.commons.web.Page;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.trilemon.boss.poster.recommend.PosterRecommendConstants.*;

/**
 * @author kevin
 */
@Service
public class RecommendActivityService {
    private final static Logger logger = LoggerFactory.getLogger(RecommendActivityService.class);
    @Autowired
    private PosterRecommendActivityItemDAO posterRecommendActivityItemDAO;
    @Autowired
    private PosterRecommendPublishItemDAO posterRecommendPublishItemDAO;
    @Autowired
    private PosterRecommendActivityDAO posterRecommendActivityDAO;
    @Autowired
    private RecommendPublishService recommendPublishService;
    @Autowired
    private PosterRecommendUserDAO posterRecommendUserDAO;
    @Autowired
    private AppService appService;
    @Autowired
    private TaobaoApiShopService taobaoApiShopService;
    @Autowired
    private PosterTemplateClient posterTemplateClient;

    /**
     * 获取活动信息
     *
     * @param userId
     * @param activityId
     * @return
     */
    public PosterRecommendActivity getActivity(Long userId, Long activityId) {
        PosterRecommendActivity activity = posterRecommendActivityDAO.selectByUserIdAndActivityId(userId, activityId);
        if(null==activity){
            return null;
        }
        Integer itemNum = posterRecommendActivityItemDAO.countByUserIdAndActivityId(userId, activityId);
        activity.setItemNum(itemNum);
        return activity;
    }

    /**
     * 创建活动（{@literal ACTIVITY_STATUS_DESIGNED_S1}，选择海报宝贝步骤）
     *
     * @param userId
     * @param activity
     */
    @Transactional
    public void createActivityDesignS1(Long userId,
                                       PosterRecommendActivity activity,
                                       List<ActivityItem> activityItems) {
        checkNotNull(userId, "userId id is null.");
        checkNotNull(activity.getTemplateId(), "templateId id is null.");

        createUser(userId);

        activity.setUserId(userId);
        activity.setStatus(ACTIVITY_STATUS_DESIGNED_S1);
        activity.setAddTime(appService.getLocalSystemTime().toDate());

        Long activityId = posterRecommendActivityDAO.insertSelective(activity);
        logger.info("add activity, activityId[{}] userId[{}].", activityId, userId);

        //创建海报宝贝
        updateActivityItems(userId, activityId, activityItems);
    }

    /**
     * 更新活动（{@literal ACTIVITY_STATUS_DESIGNED_S2}，选择海报宝贝完毕，预览取名步骤，在这一步保存生成的海报代码）
     *
     * @param userId
     * @param activity
     */
    @Transactional
    public void updateActivityDesignS2(Long userId, PosterRecommendActivity activity) throws PosterRecommendException {
        checkNotNull(userId, "userId id is null.");
        checkNotNull(activity.getId(), "activity id is null.");

        if (StringUtils.isEmpty(activity.getTitle())) {
            throw new PosterRecommendException("activity title is null");
        }

        //过滤非法html 代码
        String safeHtml = Jsoup.clean(activity.getPublishHtml(), Whitelist.relaxed());
        activity.setPublishHtml(safeHtml);

        activity.setUserId(userId);
        activity.setStatus(ACTIVITY_STATUS_DESIGNED_S2);

        posterRecommendActivityDAO.updateByUserIdAndActivityIdSelective(activity);
        logger.info("add activity, activityId[{}] userId[{}].", activity.getId(), userId);
    }

    /**
     * 更新活动（{@literal ACTIVITY_STATUS_PUBLISH_SETTING_DONE}，投放设置完毕，还没有投放）
     *
     * @param userId
     * @param activity
     * @param publishItems
     */
    @Transactional
    public void updateActivityPublishPart(Long userId, PosterRecommendActivity activity,
                                          List<PublishItem> publishItems) {
        checkNotNull(activity.getId(), "activity id is null");

        activity.setUserId(userId);
        activity.setStatus(PosterRecommendConstants.ACTIVITY_STATUS_PUBLISH_SETTING_DONE);

        posterRecommendActivityDAO.updateByUserIdAndActivityIdSelective(activity);
        logger.info("update activity, activityId[{}] userId[{}].", activity.getId(), userId);

        updatePublishItems(userId, activity.getId(), publishItems);

    }

    /**
     * 添加、更新、删除多个投放宝贝，主要用于投放宝贝的列表页
     *
     * @param userId
     * @param activityId
     * @param publishItems
     */
    @Transactional
    public void updatePublishItems(Long userId, Long activityId, List<PublishItem> publishItems) {
        if (CollectionUtils.isEmpty(publishItems)) {
            return;
        }

        //把前台传入的海报宝贝分为，待加入、待删除和待更新宝贝
        List<PublishItem> toBeAddedPublishItems = Lists.newArrayList();
        List<PublishItem> toBeDeletedPublishItems = Lists.newArrayList();
        for (PublishItem publishItem : publishItems) {
            byte publishItemStatus = publishItem.getPublishItemStatus();
            byte publishStatus = publishItem.getStatus();
            if (publishItemStatus == PUBLISH_ITEM_STATUS_NOT_IN_DB
                    && publishStatus == PublishItem.STATUS_NEW) {
                toBeAddedPublishItems.add(publishItem);
            }
            if (publishItemStatus != PUBLISH_ITEM_STATUS_NOT_IN_DB
                    && publishStatus == PublishItem.STATUS_DELETED) {
                toBeDeletedPublishItems.add(publishItem);
            }
        }

        //开始加入和删除逻辑
        PosterRecommendActivity currentActivity = getActivity(userId, activityId);

        if (null != currentActivity &&
                (CollectionUtils.isNotEmpty(toBeAddedPublishItems)
                        || CollectionUtils.isNotEmpty(toBeDeletedPublishItems))) {
            //更新活动状态位
            PosterRecommendActivity newActivity = new PosterRecommendActivity();
            byte status = currentActivity.getStatus();
            //如果还没有进行投放，那么状态不变，否则状态设为「设置完毕，还未投放」
            if (status != ACTIVITY_STATUS_DESIGNED_S1
                    && status != ACTIVITY_STATUS_DESIGNED_S2
                    && status != ACTIVITY_STATUS_PUBLISH_SETTING_DONE
                    && status != ACTIVITY_STATUS_UNPUBLISHED
                    && status != ACTIVITY_STATUS_UNPUBLISHED_WITH_ERROR) {
                newActivity.setStatus(ACTIVITY_STATUS_PUBLISH_SETTING_DONE);
                newActivity.setUserId(currentActivity.getUserId());
                newActivity.setId(currentActivity.getId());
                posterRecommendActivityDAO.updateByUserIdAndActivityIdSelective(newActivity);
            }

            //添加投放宝贝
            if (CollectionUtils.isNotEmpty(toBeAddedPublishItems)) {
                List<PosterRecommendPublishItem> batchItems = Lists.newArrayList();
                for (PublishItem publishItem : toBeAddedPublishItems) {
                    PosterRecommendPublishItem posterRecommendPublishItem = new PosterRecommendPublishItem();
                    posterRecommendPublishItem.setUserId(userId);
                    posterRecommendPublishItem.setActivityId(activityId);
                    posterRecommendPublishItem.setStatus(ACTIVITY_ITEM_STATUS_NORMAL);
                    posterRecommendPublishItem.setItemNumIid(publishItem.getItem().getNumIid());
                    posterRecommendPublishItem.setItemTitle(publishItem.getItem().getTitle());
                    posterRecommendPublishItem.setItemPrice(new BigDecimal(publishItem.getItem().getPrice()));
                    posterRecommendPublishItem.setItemPicUrl(publishItem.getItem().getPicUrl());
                    posterRecommendPublishItem.setAddTime(appService.getLocalSystemTime().toDate());
                    posterRecommendPublishItem.setDetailPagePosition(currentActivity.getDetailPagePosition());

                    batchItems.add(posterRecommendPublishItem);
                }
                posterRecommendPublishItemDAO.batchInsert(batchItems);
            }

            //删除投放宝贝
            if (CollectionUtils.isNotEmpty(toBeDeletedPublishItems)) {
                List<PosterRecommendPublishItem> batchItems = Lists.newArrayList();
                for (PublishItem publishItem : toBeAddedPublishItems) {
                    PosterRecommendPublishItem posterRecommendPublishItem = new PosterRecommendPublishItem();
                    posterRecommendPublishItem.setUserId(userId);
                    posterRecommendPublishItem.setActivityId(activityId);
                    posterRecommendPublishItem.setItemNumIid(publishItem.getItem().getNumIid());

                    batchItems.add(posterRecommendPublishItem);
                }
                posterRecommendPublishItemDAO.batchDelete(batchItems);
            }
        }
    }

    /**
     * 创建用户
     *
     * @param userId
     */
    public void createUser(Long userId) {
        PosterRecommendUser posterRecommendUser = posterRecommendUserDAO.selectByUserId(userId);
        if (null != posterRecommendUser) {
            posterRecommendUser.setAddTime(appService.getLocalSystemTime().toDate());
            posterRecommendUser.setStatus(USER_STATUS_NORMAL);
            posterRecommendUser.setUserId(userId);
            posterRecommendUserDAO.insertSelective(posterRecommendUser);
            logger.info("add user, userId[{}].", userId);
        } else {
            logger.info("add user, userId[{}] exist, skip.", userId);
        }
    }

    /**
     * 删除活动
     *
     * @param userId
     * @param activityId
     */
    @Transactional
    public void deleteActivity(Long userId, Long activityId) {

        //移除详情页海报
        recommendPublishService.unpublishActivity(userId, activityId);

        //删除数据库信息
        posterRecommendPublishItemDAO.deleteByUserIdAndActivityId(userId, activityId);
        posterRecommendActivityItemDAO.deleteByUserIdAndActivityId(userId, activityId);
        posterRecommendActivityDAO.deleteByUserIdAndActivityId(userId, activityId);

    }

    /**
     * 获取投放代码
     *
     * @param userId
     * @param activityId
     * @return 没有则返回空字符串
     */
    public String getActivityPublishHtml(Long userId, Long activityId) {
        PosterRecommendActivity posterRecommendActivity = posterRecommendActivityDAO.selectByUserIdAndActivityId(userId, activityId);
        return null != posterRecommendActivity ? posterRecommendActivity.getPublishHtml() : "";
    }

    /**
     * 添加多个宝贝到活动模板
     *
     * @param userId
     * @param activityId
     * @param activityItems
     */
    @Transactional
    public void updateActivityItems(Long userId, Long activityId, List<ActivityItem> activityItems) {
        if (CollectionUtils.isEmpty(activityItems)) {
            return;
        }
        //把前台传入的海报宝贝分为，待加入、待删除和待更新宝贝
        List<ActivityItem> toBeAddedActivityItems = Lists.newArrayList();
        List<ActivityItem> toBeDeletedActivityItems = Lists.newArrayList();
        List<ActivityItem> toBeUpdatedActivityItems = Lists.newArrayList();
        for (ActivityItem activityItem : activityItems) {
            byte activityItemStatus = activityItem.getActivityItemStatus();
            byte activityStatus = activityItem.getStatus();
            if (activityItemStatus == ACTIVITY_ITEM_STATUS_NOT_IN_DB
                    && activityStatus == ActivityItem.STATUS_NEW) {
                toBeAddedActivityItems.add(activityItem);
            }
            if (activityItemStatus != ACTIVITY_ITEM_STATUS_NOT_IN_DB
                    && activityStatus == ActivityItem.STATUS_DELETED) {
                toBeDeletedActivityItems.add(activityItem);
            }
            if (activityItemStatus != ACTIVITY_ITEM_STATUS_NOT_IN_DB
                    && activityStatus == ActivityItem.STATUS_UPDATED) {
                toBeUpdatedActivityItems.add(activityItem);
            }
        }

        //开始加入和删除逻辑
        PosterRecommendActivity posterRecommendActivity = getActivity(userId, activityId);

        if (null != posterRecommendActivity &&
                (CollectionUtils.isNotEmpty(toBeAddedActivityItems)
                        || CollectionUtils.isNotEmpty(toBeDeletedActivityItems)
                        || CollectionUtils.isNotEmpty(toBeUpdatedActivityItems))) {
            //更新活动状态位
            PosterRecommendActivity newActivity = new PosterRecommendActivity();
            byte status = posterRecommendActivity.getStatus();
            //如果还没有进行投放设置，那么状态不变；否则状态设置为投放设置完毕，还未投放
            if (status != ACTIVITY_STATUS_DESIGNED_S1
                    && status != ACTIVITY_STATUS_DESIGNED_S2
                    && status != ACTIVITY_STATUS_PUBLISH_SETTING_DONE
                    && status != ACTIVITY_STATUS_UNPUBLISHED
                    && status != ACTIVITY_STATUS_UNPUBLISHED_WITH_ERROR) {
                newActivity.setStatus(ACTIVITY_STATUS_PUBLISH_SETTING_DONE);
                newActivity.setUserId(posterRecommendActivity.getUserId());
                newActivity.setId(posterRecommendActivity.getId());
                posterRecommendActivityDAO.updateByUserIdAndActivityIdSelective(newActivity);
            }

            //添加海报宝贝
            if (CollectionUtils.isNotEmpty(toBeAddedActivityItems)) {
                List<PosterRecommendActivityItem> posterRecommendActivityItems = Lists.newArrayList();
                for (ActivityItem toBeAddedActivity : toBeAddedActivityItems) {
                    PosterRecommendActivityItem posterRecommendActivityItem = new PosterRecommendActivityItem();
                    posterRecommendActivityItem.setUserId(userId);
                    posterRecommendActivityItem.setTemplateId(posterRecommendActivity.getTemplateId());
                    posterRecommendActivityItem.setActivityId(activityId);
                    posterRecommendActivityItem.setStatus(ACTIVITY_ITEM_STATUS_NORMAL);
                    posterRecommendActivityItem.setItemNumIid(toBeAddedActivity.getItem().getNumIid());
                    posterRecommendActivityItem.setItemTitle(toBeAddedActivity.getItem().getTitle());
                    posterRecommendActivityItem.setItemPrice(new BigDecimal(toBeAddedActivity.getItem().getPrice()));
                    posterRecommendActivityItem.setItemPicUrl(toBeAddedActivity.getItem().getPicUrl());
                    posterRecommendActivityItem.setAddTime(appService.getLocalSystemTime().toDate());
                }
                posterRecommendActivityItemDAO.batchInsert(posterRecommendActivityItems);
            }

            //更新海报宝贝
            if (CollectionUtils.isNotEmpty(toBeUpdatedActivityItems)) {
                List<PosterRecommendActivityItem> posterRecommendActivityItems = Lists.newArrayList();
                for (ActivityItem toBeUpdatedActivity : toBeAddedActivityItems) {
                    PosterRecommendActivityItem posterRecommendActivityItem = new PosterRecommendActivityItem();
                    posterRecommendActivityItem.setUserId(userId);
                    posterRecommendActivityItem.setActivityId(activityId);
                    posterRecommendActivityItem.setItemNumIid(toBeUpdatedActivity.getItem().getNumIid());
                    posterRecommendActivityItem.setItemTitle(toBeUpdatedActivity.getItem().getTitle());
                    posterRecommendActivityItem.setItemPrice(new BigDecimal(toBeUpdatedActivity.getItem().getPrice()));
                    posterRecommendActivityItem.setItemPicUrl(toBeUpdatedActivity.getItem().getPicUrl());
                }
                posterRecommendActivityItemDAO.batchUpdate(posterRecommendActivityItems);
            }

            //删除海报宝贝
            if (CollectionUtils.isNotEmpty(toBeDeletedActivityItems)) {
                List<PosterRecommendActivityItem> posterRecommendActivityItems = Lists.newArrayList();
                for (ActivityItem toBeUpdatedActivity : toBeAddedActivityItems) {
                    PosterRecommendActivityItem posterRecommendActivityItem = new PosterRecommendActivityItem();
                    posterRecommendActivityItem.setUserId(userId);
                    posterRecommendActivityItem.setActivityId(activityId);
                    posterRecommendActivityItem.setItemNumIid(toBeUpdatedActivity.getItem().getNumIid());
                    posterRecommendActivityItems.add(posterRecommendActivityItem);
                }
                posterRecommendActivityItemDAO.batchDelete(posterRecommendActivityItems);
            }
        }
    }

    /**
     * 查询已加入活动宝贝
     *
     * @param userId
     * @param activityId
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<PosterRecommendActivityItem> paginateActivityAddedItems(Long userId,
                                                                        Long activityId,
                                                                        int pageNum, int pageSize) {
        List<PosterRecommendActivityItem> activityItems = posterRecommendActivityItemDAO.paginateByUserIdAndActivityId
                (userId, activityId, "add_time desc", (pageNum - 1) * pageSize, pageSize);
        int count = posterRecommendActivityItemDAO.countByUserIdAndActivityId(userId, activityId);
        if (CollectionUtils.isEmpty(activityItems)) {
            return Page.empty();
        } else {
            return Page.create(count, pageNum, pageSize, activityItems);
        }
    }

    /**
     * 查询可供选择加入活动的宝贝
     *
     * @param userId
     * @param activityId
     * @param onSale
     * @param query
     * @param sellerCids
     * @param pageNum
     * @param pageSize
     * @return 一定有对象，返回不为空
     * @throws TaobaoAccessControlException
     * @throws TaobaoEnhancedApiException
     * @throws TaobaoSessionExpiredException
     */
    @NotNull
    public Page<ActivityItem> paginateItems(Long userId, Long activityId, boolean onSale, String query,
                                            List<Long> sellerCids, int pageNum, int pageSize)
            throws TaobaoAccessControlException, TaobaoEnhancedApiException, TaobaoSessionExpiredException {

        Page<Item> itemPage;
        List<ActivityItem> returnActivityItems = Lists.newArrayList();

        //从淘宝 api 获取商品
        if (onSale) {
            itemPage = taobaoApiShopService.paginateOnSaleItems(userId, query,
                    ITEM_FIELDS, sellerCids, pageNum, pageSize, true, null, "modified:asc");

        } else {
            itemPage = taobaoApiShopService.paginateInventoryItems(userId, query,
                    ITEM_FIELDS, Lists.newArrayList(BANNER_FOR_SHELVED), sellerCids,
                    pageNum, pageSize, true, "modified:asc");
        }

        List<Item> taobaoItems = itemPage.getItems();

        if (CollectionUtils.isEmpty(taobaoItems)) {
            return Page.create(itemPage.getTotalSize(), pageNum, pageSize, Lists.<ActivityItem>newArrayList());
        }

        //获取已经加入活动的宝贝并且设置是否加入活动的标志位
        List<PosterRecommendActivityItem> posterRecommendActivityItems = posterRecommendActivityItemDAO
                .selectByUserIdAndActivityId(userId, activityId);

        Map<Long, PosterRecommendActivityItem> indexMap = Maps.uniqueIndex(posterRecommendActivityItems, new Function<PosterRecommendActivityItem, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable PosterRecommendActivityItem input) {
                return input.getItemNumIid();
            }
        });

        for (Item item : taobaoItems) {
            ActivityItem activityItem = new ActivityItem();
            activityItem.setItem(item);

            if (indexMap.values().contains(item.getNumIid())) {
                activityItem.setActivityItemStatus(indexMap.get(item.getNumIid()).getStatus());
            } else {
                activityItem.setActivityItemStatus(ACTIVITY_ITEM_STATUS_NOT_IN_DB);
            }
            returnActivityItems.add(activityItem);
        }
        return Page.create(itemPage.getTotalSize(), pageNum, pageSize, returnActivityItems);
    }

    /**
     * 获取最近创建的模板
     *
     * @param userId
     * @return
     */

    public LastUsedPosterTemplate getLastUsedPosterTemplate(Long userId) {
        PosterRecommendActivity lastCreatedActivity = posterRecommendActivityDAO.selectLastCreatedActivity(userId);
        if (null != lastCreatedActivity) {
            LastUsedPosterTemplate lastUsedPosterTemplate = new LastUsedPosterTemplate();
            Long templateId = lastCreatedActivity.getTemplateId();
            PosterTemplate posterTemplate = posterTemplateClient.getPosterTemplate(templateId);
            lastUsedPosterTemplate.setPosterTemplate(posterTemplate);
            lastUsedPosterTemplate.setLastUsedTime(lastCreatedActivity.getAddTime());
            return lastUsedPosterTemplate;
        } else {
            return null;
        }
    }

    /**
     * 获取用户曾经使用过的模板
     *
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<PosterTemplate> paginateUsedPosterTemplates(Long userId, int pageNum, int pageSize) {
        List<PosterTemplate> templates = Lists.newArrayList();
        List<PosterRecommendActivity> activities = posterRecommendActivityDAO.paginateActivityByUserId(userId,
                null, null, "add_time desc", (pageNum - 1) * pageSize, pageSize);
        int count = posterRecommendActivityDAO.countActivityByUserId(userId, null, null);
        if (CollectionUtils.isEmpty(activities)) {
            return Page.empty();
        } else {
            for (PosterRecommendActivity activity : activities) {
                PosterTemplate template = posterTemplateClient.getPosterTemplate(activity.getTemplateId());
                templates.add(template);
            }
            return Page.create(count, pageNum, pageSize, templates);
        }
    }

    /**
     * 查询活动列表
     *
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<PosterRecommendActivity> paginateActivityByUserId(Long userId, List<Byte> statusList, Date publishTime,
                                                                  int pageNum, int pageSize) {
        List<PosterRecommendActivity> activities = posterRecommendActivityDAO.paginateActivityByUserId(userId,
                statusList, publishTime, "add_time desc",
                (pageNum - 1) * pageSize, pageSize);
        int totalCount = posterRecommendActivityDAO.countActivityByUserId(userId, statusList, publishTime);

        //查询投放进度
        if (CollectionUtils.isNotEmpty(activities)) {
            for (PosterRecommendActivity activity : activities) {
                PublishProgress publishProgress = posterRecommendPublishItemDAO.groupStatus(userId,
                        activity.getId());
                activity.setPublishProgress(publishProgress);
            }
        }
        return Page.create(totalCount, pageNum, pageSize, activities);
    }
}
