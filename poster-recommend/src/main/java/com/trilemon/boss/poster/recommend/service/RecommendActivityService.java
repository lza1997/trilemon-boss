package com.trilemon.boss.poster.recommend.service;

import com.google.common.collect.Lists;
import com.taobao.api.domain.Item;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.infra.base.service.api.TaobaoApiShopService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.poster.recommend.PosterRecommendConstants;
import com.trilemon.boss.poster.recommend.PosterRecommendUtils;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendActivityDAO;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendActivityItemDAO;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendUserDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivity;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivityItem;
import com.trilemon.boss.poster.recommend.model.PosterRecommendUser;
import com.trilemon.boss.poster.template.client.PosterTemplateClient;
import com.trilemon.boss.poster.template.model.PosterTemplate;
import com.trilemon.commons.web.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * 创建活动
     *
     * @param userId
     * @param activity
     */
    public void createActivity(Long userId, PosterRecommendActivity activity) {
        createUser(userId);

        activity.setUserId(userId);
        activity.setAddTime(appService.getLocalSystemTime().toDate());
        activity.setStatus(PosterRecommendConstants.ACTIVITY_ITEM_STATUS_NORMAL);
        Long id = posterRecommendActivityDAO.insertSelective(userId, activity);
        logger.info("add activityId[{}] userId[{}].", id, userId);
    }

    public void createUser(Long userId) {
        PosterRecommendUser posterRecommendUser = posterRecommendUserDAO.selectByUserId(userId);
        if (null != posterRecommendUser) {
            posterRecommendUser.setAddTime(appService.getLocalSystemTime().toDate());
            posterRecommendUser.setLastUseTime(appService.getLocalSystemTime().toDate());
            posterRecommendUser.setStatus(USER_STATUS_NORMAL);
            posterRecommendUser.setUserId(userId);
            posterRecommendUserDAO.insertSelective(posterRecommendUser);
            logger.info("add userId[{}].", userId);
        } else {
            logger.info("add userId[{}] exist, skip.", userId);
        }
    }

    public int updateActivityDetailPagePosition(Long userId, Long activityId, Byte detailPagePosition) {
        PosterRecommendActivity posterRecommendActivity = posterRecommendActivityDAO.selectByUserIdAndActivityId(userId, activityId);
        if (null != posterRecommendActivity) {
            PosterRecommendActivity newPosterRecommendActivity = new PosterRecommendActivity();
            newPosterRecommendActivity.setId(activityId);
            newPosterRecommendActivity.setUserId(userId);
            newPosterRecommendActivity.setDetailPagePosition(detailPagePosition);
            return posterRecommendActivityDAO.updateByUserIdAndActivityId(newPosterRecommendActivity);
        } else {
            return 0;
        }
    }

    /**
     * 删除活动
     *
     * @param userId
     * @param activityId
     */
    public int deleteActivity(Long userId, Long activityId) {
        return posterRecommendActivityDAO.deleteByUserIdAndActivityId(userId, activityId);
    }

    /**
     * 获取投放代码
     *
     * @param userId
     * @param activityId
     * @return
     */
    public String getActivityPublishHtml(Long userId, Long activityId) {
        PosterRecommendActivity posterRecommendActivity = posterRecommendActivityDAO.selectByUserIdAndActivityId(userId, activityId);
        return null != posterRecommendActivity ? posterRecommendActivity.getPublishHtml() : "";
    }

    /**
     * 添加宝贝到活动
     *
     * @param userId
     * @param activityId
     * @param posterRecommendActivityItem
     */
    public String addActivityItem(Long userId, Long activityId, PosterRecommendActivityItem
            posterRecommendActivityItem) {
        PosterRecommendActivity activity = posterRecommendActivityDAO.selectByUserIdAndActivityId(userId, activityId);
        //生成 投放的 html 代码
        PosterTemplate template = posterTemplateClient.getPosterTemplate(activity.getTemplateId());
        String itemTemplateFtl = template.getTemplateItemFtl();
        //String itemPreviewHtml=PosterRecommendUtils.posterRecommendActivityItem2Item(posterRecommendActivityItem);
        posterRecommendActivityItem.setUserId(userId);
        posterRecommendActivityItem.setActivityId(activityId);
        posterRecommendActivityItem.setStatus(ACTIVITY_ITEM_STATUS_NORMAL);
        posterRecommendActivityItem.setAddTime(appService.getLocalSystemTime().toDate());
        posterRecommendActivityItemDAO.insertSelective(posterRecommendActivityItem);
        return "";
    }

    /**
     * 移除宝贝到活动
     *
     * @param userId
     * @param activityId
     * @param itemNumIid
     */
    public int removeActivityItem(Long userId, Long activityId, Long itemNumIid) {
        return posterRecommendActivityItemDAO.deleteByUserIdAndActivityIdAndItemNumIid(userId, activityId, itemNumIid);
    }

    /**
     * 已加入活动宝贝
     *
     * @param userId
     * @param activityId
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<PosterRecommendActivityItem> paginateActivityAddedItems(Long userId, Long activityId, int pageNum,
                                                                        int pageSize) {
        return posterRecommendActivityItemDAO.paginateByUserIdAndActivityId(userId, activityId, (pageNum - 1) * pageSize, pageSize);
    }

    /**
     * 在售宝贝，以供加入活动
     *
     * @param userId
     * @param onSale
     * @param query
     * @param sellerCids
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<PosterRecommendActivityItem> paginateCanBeAddActivityItems(final Long userId,
                                                                           final Long activityId,
                                                                           boolean onSale,
                                                                           String query,
                                                                           List<Long> sellerCids,
                                                                           int pageNum,
                                                                           int pageSize) throws TaobaoAccessControlException, TaobaoEnhancedApiException, TaobaoSessionExpiredException {
        Page<Item> itemPage;
        List<PosterRecommendActivityItem> activityItems;
        if (onSale) {
            itemPage = taobaoApiShopService.paginateOnSaleItems(userId, query,
                    ITEM_FIELDS, sellerCids, pageNum, pageSize, true, true, "modified:desc");
            activityItems = PosterRecommendUtils.items2PosterRecommendActivityItems
                    (userId, activityId, itemPage.getItems());
            return Page.create(itemPage.getTotalSize(), itemPage.getPageNum(), itemPage.getPageSize(), activityItems);
        } else {
            itemPage = taobaoApiShopService.paginateInventoryItems(userId, query,
                    ITEM_FIELDS, Lists.newArrayList(BANNER_OFF_SHELF), sellerCids, pageNum, pageSize, true, "modified:desc");
            activityItems = PosterRecommendUtils.items2PosterRecommendActivityItems
                    (userId, activityId, itemPage.getItems());
            return Page.create(itemPage.getTotalSize(), itemPage.getPageNum(), itemPage.getPageSize(), activityItems);
        }
    }

    /**
     * 获取最近创建的模板
     *
     * @param userId
     * @return
     */
    public PosterTemplate getLastUsedPosterTemplate(Long userId) {
        PosterRecommendActivity posterRecommendActivity = posterRecommendActivityDAO.selectLastCreatedActivity(userId);
        if (null != posterRecommendActivity) {
            Long templateId = posterRecommendActivity.getTemplateId();
            return posterTemplateClient.getPosterTemplate(templateId);
        } else {
            return null;
        }
    }
}
