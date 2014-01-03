package com.trilemon.boss.poster.recommend.service;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
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
import com.trilemon.boss.poster.template.PosterTemplateConstants;
import com.trilemon.boss.poster.template.client.PosterTemplateClient;
import com.trilemon.boss.poster.template.model.PosterTemplate;
import com.trilemon.commons.JsonMapper;
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
import java.util.Set;

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
    @Autowired
    private RecommendTemplateService recommendTemplateService;

    /**
     * 获取活动信息
     *
     * @param userId
     * @param activityId
     * @param loadActivityItems 是否加载海报宝贝信息
     * @param loadPublishItems  是否加载投放宝贝信息
     * @return
     */
    public PosterRecommendActivity getActivity(Long userId, Long activityId,
                                               boolean loadActivityItems,
                                               boolean loadPublishItems,
                                               boolean loadTemplate) {
        PosterRecommendActivity activity = posterRecommendActivityDAO.selectByUserIdAndActivityId(userId, activityId);
        if (null == activity) {
            return null;
        }
        Integer itemNum = posterRecommendActivityItemDAO.countByUserIdAndActivityId(userId, activityId);
        activity.setItemNum(itemNum);

        if (loadTemplate && (null != activity.getTemplateId())) {
            PosterTemplate template = recommendTemplateService.getTemplate(activity.getTemplateId());
            activity.setTemplate(template);
        }

        if (loadActivityItems) {
            List<PosterRecommendActivityItem> posterRecommendActivityItems = posterRecommendActivityItemDAO.selectByUserIdAndActivityId(userId, activityId);

            List<ActivityItem> activityItems = Lists.newArrayList();
            if (!CollectionUtils.isEmpty(posterRecommendActivityItems)) {
                for (PosterRecommendActivityItem posterRecommendActivityItem : posterRecommendActivityItems) {
                    ActivityItem activityItem = new ActivityItem();

                    activityItem.setActivityItemStatus(posterRecommendActivityItem.getStatus());
                    Map<String, String> copy = null;
                    try {
                        copy = (Map<String, String>) JsonMapper.nonEmptyMapper().fromJson2Map(posterRecommendActivityItem.getCopy());
                    } catch (Exception e) {
                        logger.error("json 2 map error", e);
                    }
                    if (null != copy && !copy.isEmpty()) {
                        activityItem.setCopy(copy);
                    }
                    Item item = new Item();
                    item.setNumIid(posterRecommendActivityItem.getItemNumIid());
                    item.setTitle(posterRecommendActivityItem.getItemTitle());
                    item.setPicUrl(posterRecommendActivityItem.getItemPicUrl());
                    item.setPrice(posterRecommendActivityItem.getItemPrice().toString());
                    activityItem.setItem(item);

                    activityItems.add(activityItem);
                }
            }
            activity.setActivityItems(activityItems);
        }

        if (loadPublishItems) {
            List<PosterRecommendPublishItem> posterRecommendPublishItems = posterRecommendPublishItemDAO
                    .selectByUserIdAndActivityId(userId, activityId);

            List<PublishItem> publishItems = Lists.newArrayList();
            if (!CollectionUtils.isEmpty(posterRecommendPublishItems)) {
                for (PosterRecommendPublishItem posterRecommendPublishItem : posterRecommendPublishItems) {
                    PublishItem publishItem = new PublishItem();

                    publishItem.setPublishItemStatus(posterRecommendPublishItem.getStatus());
                    Item item = new Item();
                    item.setNumIid(posterRecommendPublishItem.getItemNumIid());
                    item.setTitle(posterRecommendPublishItem.getItemTitle());
                    item.setPicUrl(posterRecommendPublishItem.getItemPicUrl());
                    item.setPrice(posterRecommendPublishItem.getItemPrice().toString());
                    publishItem.setItem(item);

                    publishItems.add(publishItem);
                }
            }
            activity.setPublishItems(publishItems);
        }

        return activity;
    }

    /**
     * 创建活动（{@literal ACTIVITY_STATUS_DESIGNED_S1}，选择海报宝贝步骤）
     *
     * @param userId
     * @param activity
     */
    @Transactional
    public PosterRecommendActivity createActivityDesignS1(Long userId, PosterRecommendActivity activity) throws PosterRecommendException {
        checkNotNull(userId, "userId id is null.");
        checkNotNull(activity.getTemplateId(), "templateId id is null.");

        createUser(userId);

        activity.setUserId(userId);
        activity.setStatus(ACTIVITY_STATUS_DESIGNED_S1);
        activity.setAddTime(appService.getLocalSystemTime().toDate());
        activity.setPublishType(PosterRecommendConstants.PUBLISH_TYPE_ALWAYS);
        activity.setDetailPagePosition(PosterTemplateConstants.PUBLISH_POSITION_TOP);
        activity.setSize(750);

        Long activityId = posterRecommendActivityDAO.insertSelective(activity);
        logger.info("add activity [DesignS1]  , activityId[{}] userId[{}].", activityId, userId);

        //创建海报宝贝
        updateActivityItems(userId, activityId, activity.getActivityItems());
        return getActivity(userId, activityId, true, false, false);
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
        logger.info("update activity [DesignS2], activityId[{}] userId[{}].", activity.getId(), userId);
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

        //把前台传入的投放宝贝分为，待加入、待删除宝贝
        //1获取已有的海报宝贝
        Page<PosterRecommendPublishItem> posterRecommendPublishItemPage = recommendPublishService.paginatePublishAddedItems(userId,
                activityId, 1, 1000);
        if (posterRecommendPublishItemPage.hasNextPage()) {
            logger.warn("item max num [{}]", ACTIVITY_ITEM_MAX_NUM);
        }

        List<PosterRecommendPublishItem> posterRecommendPublishItems = posterRecommendPublishItemPage.getItems();
        Map<Long, PosterRecommendPublishItem> posterRecommendPublishItemIndexMap = Maps.uniqueIndex(posterRecommendPublishItems, new Function<PosterRecommendPublishItem, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable PosterRecommendPublishItem input) {
                return input.getItemNumIid();
            }
        });

        Map<Long, PublishItem> publishItemIndexMap = Maps.uniqueIndex(publishItems, new Function<PublishItem, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable PublishItem input) {
                return input.getItem().getNumIid();
            }
        });

        Set<Long> toBeAddedPublishItemNumIids = Sets.newHashSet();
        Set<Long> toBeDeletedPublishItemNumIids = Sets.newHashSet();
        //获取没有变化的宝贝num iid
        Set<Long> remainActivityItemNumIids = Sets.intersection(posterRecommendPublishItemIndexMap.keySet(), publishItemIndexMap.keySet());

        //获取新添加宝贝num iid
        for (Long numIid : publishItemIndexMap.keySet()) {
            if (!remainActivityItemNumIids.contains(numIid)) {
                toBeAddedPublishItemNumIids.add(numIid);
            }
        }
        //获取删除宝贝num iid
        for (Long numIid : posterRecommendPublishItemIndexMap.keySet()) {
            if (!remainActivityItemNumIids.contains(numIid)) {
                toBeDeletedPublishItemNumIids.add(numIid);
            }
        }


        //开始加入和删除逻辑
        PosterRecommendActivity currentActivity = getActivity(userId, activityId, false, true, false);

        if (null != currentActivity &&
                (CollectionUtils.isNotEmpty(toBeAddedPublishItemNumIids)
                        || CollectionUtils.isNotEmpty(toBeDeletedPublishItemNumIids))) {
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
            List<PosterRecommendPublishItem> batchItems = Lists.newArrayList();
            for (Long numIid : toBeAddedPublishItemNumIids) {
                PublishItem publishItem = publishItemIndexMap.get(numIid);
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
            if (CollectionUtils.isNotEmpty(batchItems)) {
                posterRecommendPublishItemDAO.batchInsert(batchItems);
                batchItems.clear();
            }

            //删除投放宝贝
            for (Long numIid : toBeDeletedPublishItemNumIids) {
                PosterRecommendPublishItem posterRecommendPublishItem = new PosterRecommendPublishItem();
                posterRecommendPublishItem.setUserId(userId);
                posterRecommendPublishItem.setActivityId(activityId);
                posterRecommendPublishItem.setItemNumIid(numIid);
                batchItems.add(posterRecommendPublishItem);
            }
            if (CollectionUtils.isNotEmpty(batchItems)) {
                posterRecommendPublishItemDAO.batchDelete(batchItems);
                batchItems.clear();
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
        if (null == posterRecommendUser) {
            posterRecommendUser = new PosterRecommendUser();
            posterRecommendUser.setAddTime(appService.getLocalSystemTime().toDate());
            posterRecommendUser.setStatus(USER_STATUS_NORMAL);
            posterRecommendUser.setUserId(userId);
            posterRecommendUserDAO.insertSelective(posterRecommendUser);
            logger.info("add user, userId[{}].", userId);
        } else {
            logger.debug("add user, userId[{}] exist, skip.", userId);
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
    public void updateActivityItems(Long userId, Long activityId, List<ActivityItem> activityItems) throws PosterRecommendException {
        if (CollectionUtils.isEmpty(activityItems)) {
            return;
        }
        //把前台传入的海报宝贝分为，待加入、待删除和待更新宝贝
        //1获取已有的海报宝贝
        Page<PosterRecommendActivityItem> posterRecommendActivityItemPage = paginateActivityAddedItems(userId,
                activityId, 1, 1000);
        if (posterRecommendActivityItemPage.hasNextPage()) {
            logger.warn("item max num [{}]", ACTIVITY_ITEM_MAX_NUM);
        }

        List<PosterRecommendActivityItem> posterRecommendActivityItemPageItems = posterRecommendActivityItemPage.getItems();

        //按照 num iid 索引宝贝
        Map<Long, PosterRecommendActivityItem> posterRecommendActivityItemIndexMap = Maps.uniqueIndex(posterRecommendActivityItemPageItems, new Function<PosterRecommendActivityItem, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable PosterRecommendActivityItem input) {
                return input.getItemNumIid();
            }
        });

        Map<Long, ActivityItem> activityItemIndexMap = Maps.uniqueIndex(activityItems, new Function<ActivityItem, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable ActivityItem input) {
                return input.getItem().getNumIid();
            }
        });

        Set<Long> toBeAddedActivityItemNumIids = Sets.newHashSet();
        Set<Long> toBeDeletedActivityItemNumIids = Sets.newHashSet();
        //获取更新宝贝num iid（还没有判断是否确实去要更新）
        Set<Long> toBeUpdatedActivityItemNumIids = Sets.intersection(posterRecommendActivityItemIndexMap.keySet(),
                activityItemIndexMap.keySet());

        //获取新添加宝贝num iid
        for (Long numIid : activityItemIndexMap.keySet()) {
            if (!toBeUpdatedActivityItemNumIids.contains(numIid)) {
                toBeAddedActivityItemNumIids.add(numIid);
            }
        }
        //获取删除宝贝num iid
        for (Long numIid : posterRecommendActivityItemIndexMap.keySet()) {
            if (!toBeUpdatedActivityItemNumIids.contains(numIid)) {
                toBeDeletedActivityItemNumIids.add(numIid);
            }
        }

        //操作数据库，进行加入、更新和删除逻辑
        PosterRecommendActivity posterRecommendActivity = getActivity(userId, activityId, true, false, false);

        if (null != posterRecommendActivity &&
                (CollectionUtils.isNotEmpty(toBeAddedActivityItemNumIids)
                        || CollectionUtils.isNotEmpty(toBeDeletedActivityItemNumIids)
                        || CollectionUtils.isNotEmpty(toBeUpdatedActivityItemNumIids))) {
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

            List<PosterRecommendActivityItem> batchItems = Lists.newArrayList();
            //添加海报宝贝
            for (Long numIid : toBeAddedActivityItemNumIids) {
                ActivityItem activityItem = activityItemIndexMap.get(numIid);
                PosterRecommendActivityItem posterRecommendActivityItem = new PosterRecommendActivityItem();
                posterRecommendActivityItem.setUserId(userId);
                posterRecommendActivityItem.setTemplateId(posterRecommendActivity.getTemplateId());
                posterRecommendActivityItem.setActivityId(activityId);
                String copy = JsonMapper.nonEmptyMapper().toJson(activityItem.getCopy());
                if ("null".equals(copy)) {
                    continue;
                } else {
                    posterRecommendActivityItem.setCopy(copy);
                }
                posterRecommendActivityItem.setStatus(ACTIVITY_ITEM_STATUS_NORMAL);
                posterRecommendActivityItem.setItemNumIid(activityItem.getItem().getNumIid());
                posterRecommendActivityItem.setItemTitle(activityItem.getItem().getTitle());
                posterRecommendActivityItem.setItemPrice(new BigDecimal(activityItem.getItem().getPrice()));
                posterRecommendActivityItem.setItemPicUrl(activityItem.getItem().getPicUrl());
                posterRecommendActivityItem.setAddTime(appService.getLocalSystemTime().toDate());
                batchItems.add(posterRecommendActivityItem);
            }
            if (CollectionUtils.isNotEmpty(batchItems)) {
                posterRecommendActivityItemDAO.batchInsert(batchItems);
                batchItems.clear();
            }

            //更新海报宝贝，这个里面多了一个逻辑就是需要判断是否真的需要更新，目前只需要判断自定义文案内容是否改变
            for (Long numIid : toBeUpdatedActivityItemNumIids) {
                ActivityItem activityItem = activityItemIndexMap.get(numIid);
                if (!isChanged(activityItem, posterRecommendActivityItemIndexMap.get(numIid))) {
                    continue;
                }
                PosterRecommendActivityItem posterRecommendActivityItem = new PosterRecommendActivityItem();
                posterRecommendActivityItem.setUserId(userId);
                posterRecommendActivityItem.setActivityId(activityId);
                posterRecommendActivityItem.setItemNumIid(activityItem.getItem().getNumIid());
                posterRecommendActivityItem.setItemTitle(activityItem.getItem().getTitle());
                posterRecommendActivityItem.setItemPrice(new BigDecimal(activityItem.getItem().getPrice()));
                posterRecommendActivityItem.setItemPicUrl(activityItem.getItem().getPicUrl());
                String copy = JsonMapper.nonEmptyMapper().toJson(activityItem.getCopy());
                if ("null".equals(copy)) {
                    continue;
                } else {
                    posterRecommendActivityItem.setCopy(copy);
                }
                batchItems.add(posterRecommendActivityItem);
            }
            if (CollectionUtils.isNotEmpty(batchItems)) {
                posterRecommendActivityItemDAO.batchUpdate(batchItems);
                batchItems.clear();
            }

            //删除海报宝贝
            for (Long numIid : toBeDeletedActivityItemNumIids) {
                PosterRecommendActivityItem posterRecommendActivityItem = new PosterRecommendActivityItem();
                posterRecommendActivityItem.setUserId(userId);
                posterRecommendActivityItem.setActivityId(activityId);
                posterRecommendActivityItem.setItemNumIid(numIid);
                batchItems.add(posterRecommendActivityItem);
            }
            if (CollectionUtils.isNotEmpty(batchItems)) {
                posterRecommendActivityItemDAO.batchDelete(batchItems);
                batchItems.clear();
            }
        }
    }

    /**
     * 判断宝贝是否改变了
     *
     * @param activityItem                前台传入宝贝
     * @param posterRecommendActivityItem 数据库宝贝
     *                                    <p/>
     *                                    {@literal}
     * @return
     */
    private boolean isChanged(ActivityItem activityItem, PosterRecommendActivityItem posterRecommendActivityItem) {
        //get template copy
        PosterTemplate posterTemplate = posterTemplateClient.getPosterTemplate(posterRecommendActivityItem
                .getTemplateId());
        Map<?, ?> copyKeyMap = posterTemplate.getCopyKeyMap();
        if (null == copyKeyMap || copyKeyMap.isEmpty()) {
            return false;
        }

        for (Object key : copyKeyMap.keySet()) {
            if (activityItem.getCopy().containsKey((String) key)) {
                if (!copyKeyMap.get(key).equals(activityItem.getCopy().get(key))) {
                    return true;
                }
            }
        }

        return false;
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
            return Page.create(count, pageNum, pageSize, Lists.<PosterRecommendActivityItem>newArrayList());
        } else {
            return Page.create(count, pageNum, pageSize, activityItems);
        }
    }

    /**
     * 查询可供选择加入活动的宝贝
     *
     * @param userId
     * @param activityId 创建时可以传递 null
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

        Map<Long, PosterRecommendActivityItem> indexMap = Maps.newHashMap();
        if (null != activityId) {
            //获取已经加入活动的宝贝并且设置是否加入活动的标志位
            List<PosterRecommendActivityItem> posterRecommendActivityItems = posterRecommendActivityItemDAO
                    .selectByUserIdAndActivityId(userId, activityId);

            indexMap = Maps.uniqueIndex(posterRecommendActivityItems, new Function<PosterRecommendActivityItem, Long>() {
                @Nullable
                @Override
                public Long apply(@Nullable PosterRecommendActivityItem input) {
                    return input.getItemNumIid();
                }
            });
        }

        for (Item item : taobaoItems) {
            ActivityItem activityItem = new ActivityItem();
            activityItem.setItem(item);

            if (indexMap.keySet().contains(item.getNumIid())) {
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
