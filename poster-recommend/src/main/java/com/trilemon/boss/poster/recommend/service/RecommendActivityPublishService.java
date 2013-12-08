package com.trilemon.boss.poster.recommend.service;

import com.google.common.collect.Lists;
import com.taobao.api.domain.Item;
import com.taobao.api.request.ItemUpdateRequest;
import com.taobao.api.response.ItemUpdateResponse;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.infra.base.service.TaobaoApiService;
import com.trilemon.boss.infra.base.service.api.TaobaoApiItemService;
import com.trilemon.boss.infra.base.service.api.TaobaoApiShopService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.poster.publish.model.dto.PublishProgress;
import com.trilemon.boss.poster.recommend.PosterRecommendConstants;
import com.trilemon.boss.poster.recommend.PosterRecommendUtils;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendActivityDAO;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendPublishItemDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivity;
import com.trilemon.boss.poster.recommend.model.PosterRecommendPublishItem;
import com.trilemon.commons.web.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.trilemon.boss.poster.recommend.PosterRecommendConstants.*;

/**
 * @author kevin
 */
public class RecommendActivityPublishService {
    private final static Logger logger = LoggerFactory.getLogger(RecommendActivityService.class);
    @Autowired
    private PosterRecommendPublishItemDAO posterRecommendPublishItemDAO;
    @Autowired
    private PosterRecommendActivityDAO posterRecommendActivityDAO;
    @Autowired
    private AppService appService;
    @Autowired
    private TaobaoApiShopService taobaoApiShopService;
    @Autowired
    private TaobaoApiItemService taobaoApiItemService;

    /**
     * 添加投放宝贝
     *
     * @param userId
     * @param activityId
     * @param posterRecommendPublishItem
     */
    public void addPublishItem(Long userId, Long activityId, PosterRecommendPublishItem posterRecommendPublishItem) {
        posterRecommendPublishItem.setUserId(userId);
        posterRecommendPublishItem.setActivityId(activityId);
        posterRecommendPublishItem.setStatus(PUBLISH_ITEM_STATUS_WAITING_PUBLISH);
        posterRecommendPublishItem.setAddTime(appService.getLocalSystemTime().toDate());
        posterRecommendPublishItemDAO.insertSelective(posterRecommendPublishItem);
    }

    /**
     * 移除投放宝贝
     *
     * @param userId
     * @param activityId
     * @param itemNumIid
     */
    public int removePublishItem(Long userId, Long activityId, Long itemNumIid) {
        return posterRecommendPublishItemDAO.deleteByUserIdAndActivityIdAndItemNumIid(userId, activityId, itemNumIid);
    }

    /**
     * 投放活动
     *
     * @param userId
     * @param activityId
     */
    public void publishActivity(Long userId, Long activityId) {
        PosterRecommendActivity activity = posterRecommendActivityDAO.selectByUserIdAndActivityId(userId, activityId);
        if (null == activity) {
            return;
        }
        //开始投放
        PosterRecommendActivity newActivity = new PosterRecommendActivity();
        newActivity.setUserId(userId);
        newActivity.setId(activityId);
        newActivity.setStatus(PosterRecommendConstants.ACTIVITY_STATUS_PUBLISHING);
        newActivity.setPublishTime(appService.getLocalSystemTime().toDate());
        posterRecommendActivityDAO.updateByUserIdAndActivityId(newActivity);

        List<PosterRecommendPublishItem> publishItems = posterRecommendPublishItemDAO.selectByUserIdAndActivityId
                (userId, activityId);
        boolean error = false;
        for (PosterRecommendPublishItem publishItem : publishItems) {
            boolean currentError = publish2Item(userId, activityId, publishItem.getItemNumIid());
            if (!error) {
                error = currentError;
            }
        }

        //结束投放
        if (error) {
            newActivity.setStatus(PosterRecommendConstants.ACTIVITY_STATUS_PUBLISHED_WITH_ERROR);
        } else {
            newActivity.setStatus(PosterRecommendConstants.ACTIVITY_STATUS_PUBLISHING);
        }
        posterRecommendActivityDAO.updateByUserIdAndActivityId(newActivity);
    }

    @Transactional
    public boolean publish2Item(Long userId, Long activityId, Long publishItemNumIid) {
        PosterRecommendPublishItem publishItem = posterRecommendPublishItemDAO.selectByUserIdAndActivityIdAndItemNumIid
                (userId, activityId, publishItemNumIid);
        if (null == publishItem) {
            return true;
        }
        boolean error = false;
        //更新详情页
        String detailPageHtml = null;
        ItemUpdateRequest request = new ItemUpdateRequest();
        request.setNumIid(publishItemNumIid);
        request.setDesc(detailPageHtml);
        try {
            ItemUpdateResponse response = taobaoApiItemService.updateItem(userId, request);
            publishSuccessful(userId, activityId, publishItemNumIid);
        } catch (TaobaoEnhancedApiException e) {
            error = true;
            publishFailed(userId, activityId, publishItemNumIid);
        } catch (TaobaoSessionExpiredException e) {
            error = true;
            publishFailed(userId, activityId, publishItemNumIid);
        } catch (TaobaoAccessControlException e) {
            error = true;
            publishFailed(userId, activityId, publishItemNumIid);
        } finally {
            return error;
        }
    }

    public void publishFailed(Long userId, Long activityId, Long publishItemNumIid) {
        afterPublish(userId, activityId, publishItemNumIid, false);
    }

    public void publishSuccessful(Long userId, Long activityId, Long publishItemNumIid) {
        afterPublish(userId, activityId, publishItemNumIid, true);
    }

    public void afterPublish(Long userId, Long activityId, Long publishItemNumIid, boolean successful) {
        PosterRecommendPublishItem newPublishItem = new PosterRecommendPublishItem();
        //开始投放
        newPublishItem.setUserId(userId);
        newPublishItem.setActivityId(activityId);
        newPublishItem.setItemNumIid(publishItemNumIid);
        if (successful) {
            newPublishItem.setStatus(PosterRecommendConstants.PUBLISH_ITEM_STATUS_PUBLISHED);
        } else {
            newPublishItem.setStatus(PosterRecommendConstants.PUBLISH_ITEM_STATUS_PUBLISH_FAILED);
        }
        posterRecommendPublishItemDAO.updateByUserIdAndActivityIdAndItemNumIid(newPublishItem);
    }

    /**
     * 已加入投放的宝贝
     *
     * @param userId
     * @param activityId
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<PosterRecommendPublishItem> paginatePublishAddedItems(Long userId, Long activityId, int pageNum,
                                                                      int pageSize) {
        return posterRecommendPublishItemDAO.paginateByUserIdAndActivityId(userId, activityId, (pageNum - 1) * pageSize, pageSize);
    }

    /**
     * 在售宝贝，以供加入投放
     *
     * @param userId
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<PosterRecommendPublishItem> paginateCanBeAddPublishItems(Long userId,
                                                                         Long activityId,
                                                                         boolean onSale,
                                                                         String query,
                                                                         List<Long> sellerCids,
                                                                         int pageNum,
                                                                         int pageSize) throws TaobaoAccessControlException, TaobaoEnhancedApiException, TaobaoSessionExpiredException {
        Page<Item> itemPage;
        List<PosterRecommendPublishItem> activityItems;
        if (onSale) {
            itemPage = taobaoApiShopService.paginateOnSaleItems(userId, query,
                    ITEM_FIELDS, sellerCids, pageNum, pageSize, true, true, "modified:desc");
            activityItems = PosterRecommendUtils.items2PosterRecommendPublishItems
                    (userId, activityId, itemPage.getItems());
            return Page.create(itemPage.getTotalSize(), itemPage.getPageNum(), itemPage.getPageSize(), activityItems);
        } else {
            itemPage = taobaoApiShopService.paginateInventoryItems(userId, query,
                    ITEM_FIELDS, Lists.newArrayList(BANNER_OFF_SHELF), sellerCids, pageNum, pageSize, true, "modified:desc");
            activityItems = PosterRecommendUtils.items2PosterRecommendPublishItems
                    (userId, activityId, itemPage.getItems());
            return Page.create(itemPage.getTotalSize(), itemPage.getPageNum(), itemPage.getPageSize(), activityItems);
        }
    }

    /**
     * 查询投放进度
     *
     * @param userId
     * @param activityId
     */
    public PublishProgress queryPublishProgress(Long userId, Long activityId) {
        PublishProgress publishProgress = new PublishProgress();
        int totalItemNum = posterRecommendPublishItemDAO.countByUserIdAndActivityIdAndStatus(userId, activityId, null);
        int publishedItemNum = posterRecommendPublishItemDAO.countByUserIdAndActivityIdAndStatus(userId, activityId,
                Lists.newArrayList(PosterRecommendConstants.PUBLISH_ITEM_STATUS_PUBLISHED));
        int failedItemNum = posterRecommendPublishItemDAO.countByUserIdAndActivityIdAndStatus(userId, activityId,
                Lists.newArrayList(PosterRecommendConstants.PUBLISH_ITEM_STATUS_PUBLISH_FAILED));
        publishProgress.setTotalItemNum(totalItemNum);
        publishProgress.setPublishedItemNum(publishedItemNum);
        publishProgress.setFailedItemNum(failedItemNum);
        int processedItemNum = (publishedItemNum + failedItemNum);
        publishProgress.setFinished(totalItemNum == processedItemNum);
        publishProgress.setProgress((processedItemNum * 100.0f) / totalItemNum);
        return publishProgress;
    }
}
