package com.trilemon.boss.poster.recommend.service;

import com.google.common.collect.Lists;
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
import com.trilemon.boss.poster.recommend.model.PosterRecommendUser;
import com.trilemon.boss.poster.recommend.model.dto.ActivityItem;
import com.trilemon.boss.poster.recommend.model.dto.LastUsedPosterTemplate;
import com.trilemon.boss.poster.recommend.model.dto.PublishProgress;
import com.trilemon.boss.poster.template.client.PosterTemplateClient;
import com.trilemon.boss.poster.template.model.PosterTemplate;
import com.trilemon.commons.web.Page;
import org.apache.commons.collections.CollectionUtils;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

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
        int itemNum = posterRecommendActivityItemDAO.countByUserIdAndActivityId(userId, activityId);
        activity.setItemNum(itemNum);
        return activity;
    }

    /**
     * 创建活动（设计完毕，还没有投放）
     *
     * @param userId
     * @param activity
     */
    @Transactional
    public void createActivityDesignPart(Long userId, PosterRecommendActivity activity) {
        createUser(userId);

        activity.setUserId(userId);
        activity.setAddTime(appService.getLocalSystemTime().toDate());
        activity.setStatus(PosterRecommendConstants.ACTIVITY_STATUS_DESIGNED);

        Long id = posterRecommendActivityDAO.insertSelective(activity);
        logger.info("add activity, activityId[{}] userId[{}].", id, userId);
    }

    /**
     * 更新活动（投放设置完毕，还没有投放）
     *
     * @param userId
     * @param activity
     */
    @Transactional
    public void updateActivityPublishPart(Long userId, PosterRecommendActivity activity) {
        checkNotNull(activity.getId(), "activity id is null");

        activity.setUserId(userId);
        activity.setStatus(PosterRecommendConstants.ACTIVITY_STATUS_PUBLISH_SETTING_DONE);

        //过滤非法html 代码
        String safeHtml = Jsoup.clean(activity.getPublishHtml(), Whitelist.relaxed());
        activity.setPublishHtml(safeHtml);

        posterRecommendActivityDAO.updateByUserIdAndActivityIdSelective(activity);
        logger.info("update activity, activityId[{}] userId[{}].", activity.getId(), userId);
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
     * 更新模板位置
     *
     * @param userId
     * @param activityId
     * @param detailPagePosition
     * @return 是否更新成功
     */
    public boolean updateActivityDetailPagePosition(Long userId, Long activityId, Byte detailPagePosition) {
        PosterRecommendActivity posterRecommendActivity = posterRecommendActivityDAO.selectByUserIdAndActivityId(userId, activityId);
        if (null != posterRecommendActivity) {
            PosterRecommendActivity newPosterRecommendActivity = new PosterRecommendActivity();
            newPosterRecommendActivity.setId(activityId);
            newPosterRecommendActivity.setUserId(userId);
            newPosterRecommendActivity.setDetailPagePosition(detailPagePosition);
            return posterRecommendActivityDAO.updateByUserIdAndActivityIdSelective(newPosterRecommendActivity) == 1;
        } else {
            return false;
        }
    }

    /**
     * 更新投放时间
     *
     * @param userId
     * @param activityId
     * @param publishType
     * @param publishStartTime
     * @param publishEndTime
     * @return
     */
    public boolean updateActivityPublishTime(Long userId, Long activityId, byte publishType,
                                             Date publishStartTime, Date publishEndTime) {
        PosterRecommendActivity posterRecommendActivity = posterRecommendActivityDAO.selectByUserIdAndActivityId(userId, activityId);
        if (null != posterRecommendActivity) {
            PosterRecommendActivity newPosterRecommendActivity = new PosterRecommendActivity();
            newPosterRecommendActivity.setId(activityId);
            newPosterRecommendActivity.setUserId(userId);
            newPosterRecommendActivity.setPublishType(publishType);

            if (publishType == PosterRecommendConstants.PUBLISH_TYPE_ASSIGN_TIME) {
                newPosterRecommendActivity.setPublishStartTime(publishStartTime);
                newPosterRecommendActivity.setPublishEndTime(publishEndTime);
            }
            return posterRecommendActivityDAO.updateByUserIdAndActivityIdSelective(newPosterRecommendActivity) == 1;
        } else {
            return false;
        }
    }

    /**
     * 删除活动
     *
     * @param userId
     * @param activityId
     * @param deleteDetailPage 是否需要删除淘宝详情页中相关内容
     */
    @Transactional
    public void deleteActivity(Long userId, Long activityId, boolean deleteDetailPage) {
        posterRecommendActivityItemDAO.deleteByUserIdAndActivityId(userId, activityId);
        posterRecommendActivityDAO.deleteByUserIdAndActivityId(userId, activityId);
        if (deleteDetailPage) {
            //TODO
        }
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
     * 添加宝贝到活动模板
     *
     * @param userId
     * @param activityId
     * @param posterRecommendActivityItem
     */
    public PosterRecommendActivityItem addActivityItem(Long userId, Long activityId, PosterRecommendActivityItem
            posterRecommendActivityItem) {
        PosterRecommendActivity posterRecommendActivity = getActivity(userId, activityId);
        if (null == posterRecommendActivity) {
            return null;
        }
        //@葛亮 这里PosterRecommendActivityItem，你前台需要填充和商品相关的属性
        posterRecommendActivityItem.setUserId(userId);
        posterRecommendActivityItem.setTemplateId(posterRecommendActivity.getTemplateId());
        posterRecommendActivityItem.setActivityId(activityId);
        posterRecommendActivityItem.setStatus(ACTIVITY_ITEM_STATUS_NORMAL);
        posterRecommendActivityItem.setAddTime(appService.getLocalSystemTime().toDate());
        posterRecommendActivityItemDAO.insertSelective(posterRecommendActivityItem);
        return posterRecommendActivityItem;
    }

    /**
     * 从活动模板中移除宝贝
     *
     * @param userId
     * @param activityId
     * @param itemNumIid
     */
    public int removeActivityItem(Long userId, Long activityId, Long itemNumIid) {
        return posterRecommendActivityItemDAO.deleteByUserIdAndActivityIdAndItemNumIid(userId, activityId, itemNumIid);
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
        List<ActivityItem> activityItems = Lists.newArrayList();

        //从淘宝 api 获取商品
        if (onSale) {
            itemPage = taobaoApiShopService.paginateOnSaleItems(userId, query,
                    ITEM_FIELDS, sellerCids, pageNum, pageSize, true, null, "modified:asc");

        } else {
            itemPage = taobaoApiShopService.paginateInventoryItems(userId, query,
                    ITEM_FIELDS, Lists.newArrayList(BANNER_FOR_SHELVED), sellerCids,
                    pageNum, pageSize, true, "modified:asc");
        }

        //获取已经加入活动的宝贝
        List<PosterRecommendActivityItem> addedRecommendActivityItems = posterRecommendActivityItemDAO
                .selectByUserIdAndActivityId(userId, activityId);

        //设置是否加入活动的标志位
        if (CollectionUtils.isNotEmpty(itemPage.getItems())) {
            for (Item item : itemPage.getItems()) {
                ActivityItem activityItem = new ActivityItem();
                activityItem.setAdded(false);
                activityItem.setItem(item);

                if (CollectionUtils.isNotEmpty(addedRecommendActivityItems) && addedRecommendActivityItems.contains(item)) {
                    activityItem.setAdded(true);
                } else {
                    activityItem.setAdded(false);
                }

                activityItems.add(activityItem);
            }
        }

        return Page.create(itemPage.getTotalSize(), itemPage.getPageNum(), itemPage.getPageSize(), activityItems);
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
    public Page<PosterRecommendActivity> paginateActivity(Long userId, int pageNum, int pageSize) {
        List<PosterRecommendActivity> activities = posterRecommendActivityDAO.paginateActivityAndStatus(userId,
                ALL_ACTIVITY_STATUS,
                (pageNum - 1) * pageSize, pageSize);
        int totalCount = posterRecommendActivityDAO.countActivityByUserIdAndStatus(userId, ALL_ACTIVITY_STATUS);

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
