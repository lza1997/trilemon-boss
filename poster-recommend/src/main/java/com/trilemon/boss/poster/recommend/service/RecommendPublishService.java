package com.trilemon.boss.poster.recommend.service;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.taobao.api.domain.Item;
import com.taobao.api.request.ItemUpdateRequest;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.infra.base.service.api.TaobaoApiItemService;
import com.trilemon.boss.infra.base.service.api.TaobaoApiShopService;
import com.trilemon.boss.infra.base.service.api.exception.BaseTaobaoApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.poster.recommend.PosterRecommendConstants;
import com.trilemon.boss.poster.recommend.cache.TaobaoApiCache;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendActivityDAO;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendPublishItemDAO;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendPublishItemDetailPageDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivity;
import com.trilemon.boss.poster.recommend.model.PosterRecommendPublishItem;
import com.trilemon.boss.poster.recommend.model.PosterRecommendPublishItemDetailPage;
import com.trilemon.boss.poster.recommend.model.dto.PublishItem;
import com.trilemon.boss.poster.recommend.model.dto.PublishProgress;
import com.trilemon.boss.poster.template.PublishUtils;
import com.trilemon.commons.web.Page;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static com.trilemon.boss.poster.recommend.PosterRecommendConstants.*;
import static com.trilemon.boss.poster.template.PosterTemplateConstants.HTML_TAG_RECOMMEND;

/**
 * @author kevin
 */
@Service
public class RecommendPublishService {
    private final static Logger logger = LoggerFactory.getLogger(RecommendPublishService.class);
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
    @Autowired
    private PosterRecommendPublishItemDetailPageDAO posterRecommendPublishItemDetailPageDAO;
    @Autowired
    private TaobaoApiCache taobaoApiCache;

    /**
     * 投放活动到详情页
     *
     * @param userId
     * @param activityId
     */
    public void publishActivity(Long userId, Long activityId) {
        PosterRecommendActivity activity = posterRecommendActivityDAO.selectByUserIdAndActivityId(userId, activityId);
        if (null == activity) {
            return;
        }
        //开始投放活动
        PosterRecommendActivity newActivity = new PosterRecommendActivity();
        newActivity.setUserId(userId);
        newActivity.setId(activityId);
        newActivity.setStatus(PosterRecommendConstants.ACTIVITY_STATUS_PUBLISHING);
        newActivity.setPublishTime(appService.getLocalSystemTime().toDate());
        newActivity.setPublishOwner(appService.getOwner());
        posterRecommendActivityDAO.updateByUserIdAndActivityIdSelective(newActivity);

        //投放单个宝贝
        List<PosterRecommendPublishItem> publishItems = posterRecommendPublishItemDAO.selectByUserIdAndActivityId(userId, activityId);
        List<Exception> exceptions = Lists.newArrayList();
        for (PosterRecommendPublishItem publishItem : publishItems) {
            try {
                publish2Item(userId, activityId, publishItem.getItemNumIid(),
                        activity.getPublishHtml());
            } catch (TaobaoAccessControlException e) {
                exceptions.add(e);
            } catch (TaobaoEnhancedApiException e) {
                exceptions.add(e);
            } catch (TaobaoSessionExpiredException e) {
                exceptions.add(e);
            }
        }

        //结束投放活动
        if (CollectionUtils.isEmpty(exceptions)) {
            newActivity.setStatus(PosterRecommendConstants.ACTIVITY_STATUS_PUBLISHED);
        } else {
            newActivity.setStatus(PosterRecommendConstants.ACTIVITY_STATUS_PUBLISHED_WITH_ERROR);
        }
        posterRecommendActivityDAO.updateByUserIdAndActivityIdSelective(newActivity);
    }

    @Transactional
    public void publish2Item(Long userId, Long activityId, Long itemNumIid, String publishHtml)
            throws TaobaoAccessControlException, TaobaoEnhancedApiException, TaobaoSessionExpiredException {
        PosterRecommendPublishItem publishItem = posterRecommendPublishItemDAO
                .selectByUserIdAndActivityIdAndItemNumIidAndStatus(userId, activityId, itemNumIid,
                        ImmutableList.of(PUBLISH_ITEM_STATUS_WAITING_PUBLISH, PUBLISH_ITEM_STATUS_PUBLISHED_SUCCESSFULLY));
        if (null == publishItem) {
            return;
        }

        //更新详情页
        Item item = taobaoApiCache.getItem(userId, itemNumIid);
        //1 备份
        String backupDesc = item.getDesc();
        //important
        String updatedDesc = PublishUtils.addHtml2DetailPage(publishItem.getDetailPagePosition(),
                HTML_TAG_RECOMMEND, activityId, publishHtml, item.getDesc());
        ItemUpdateRequest request = new ItemUpdateRequest();
        request.setNumIid(itemNumIid);
        request.setDesc(updatedDesc);
        //插入详情页备份
        PosterRecommendPublishItemDetailPage posterRecommendPublishItemDetailPage = new
                PosterRecommendPublishItemDetailPage();
        posterRecommendPublishItemDetailPage.setUserId(userId);
        posterRecommendPublishItemDetailPage.setActivityId(activityId);
        posterRecommendPublishItemDetailPage.setItemNumIid(item.getNumIid());
        posterRecommendPublishItemDetailPage.setItemTitle(item.getTitle());
        posterRecommendPublishItemDetailPage.setItemPrice(new BigDecimal(item.getPrice()));
        posterRecommendPublishItemDetailPage.setItemPicUrl(item.getPicUrl());
        posterRecommendPublishItemDetailPage.setBackupDesc(backupDesc);
        posterRecommendPublishItemDetailPage.setDesc(updatedDesc);
        posterRecommendPublishItemDetailPage.setAddTime(appService.getLocalSystemTime().toDate());
        try {
            taobaoApiItemService.updateItem(userId, request);
            posterRecommendPublishItemDetailPage.setStatus(DETAIL_PAGE_STATUS_NORMAL);
            publishSuccessful(userId, activityId, itemNumIid);
        } catch (BaseTaobaoApiException e) {
            publishFailed(userId, activityId, itemNumIid);
            posterRecommendPublishItemDetailPage.setStatus(DETAIL_PAGE_STATUS_PUBLISH_FAILED);
            throw e;
        } finally {
            posterRecommendPublishItemDetailPageDAO.insertSelective(posterRecommendPublishItemDetailPage);
        }
    }

    public void publishFailed(Long userId, Long activityId, Long itemNumIid) {
        afterPublish(userId, activityId, itemNumIid, false);
    }

    public void publishSuccessful(Long userId, Long activityId, Long itemNumIid) {
        afterPublish(userId, activityId, itemNumIid, true);
    }

    public void afterPublish(Long userId, Long activityId, Long itemNumIid, boolean successful) {
        PosterRecommendPublishItem newPublishItem = new PosterRecommendPublishItem();
        newPublishItem.setUserId(userId);
        newPublishItem.setActivityId(activityId);
        newPublishItem.setItemNumIid(itemNumIid);
        newPublishItem.setPublishTime(appService.getLocalSystemTime().toDate());
        if (successful) {
            newPublishItem.setStatus(PosterRecommendConstants.PUBLISH_ITEM_STATUS_PUBLISHED_SUCCESSFULLY);
        } else {
            newPublishItem.setStatus(PosterRecommendConstants.PUBLISH_ITEM_STATUS_PUBLISHED_FAILED);
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
        List<PosterRecommendPublishItem> publishItems = posterRecommendPublishItemDAO.paginateByUserIdAndActivityId
                (userId, activityId, "add_time desc", (pageNum - 1) * pageSize, pageSize);
        int count = posterRecommendPublishItemDAO.countByUserIdAndActivityId(userId, activityId);
        if (CollectionUtils.isNotEmpty(publishItems)) {
            return Page.create(count, pageNum, pageSize, publishItems);
        } else {
            return Page.empty();
        }
    }

    /**
     * 查询可供选择加入投放的宝贝
     *
     * @param userId
     * @param activityId
     * @param onSale
     * @param query
     * @param sellerCids
     * @param pageNum
     * @param pageSize
     * @return
     * @throws TaobaoAccessControlException
     * @throws TaobaoEnhancedApiException
     * @throws TaobaoSessionExpiredException
     */
    @NotNull
    public Page<PublishItem> paginateItems(Long userId, Long activityId, boolean onSale, String query,
                                           List<Long> sellerCids, int pageNum, int pageSize)
            throws TaobaoAccessControlException, TaobaoEnhancedApiException, TaobaoSessionExpiredException {

        Page<Item> itemPage;
        List<PublishItem> returnPublishItems = Lists.newArrayList();

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
            return Page.create(itemPage.getTotalSize(), pageNum, pageSize, Lists.<PublishItem>newArrayList());
        }

        //获取已经加入投放的宝贝并且设置是否加入投放的标志位
        List<PosterRecommendPublishItem> posterRecommendPublishItems = posterRecommendPublishItemDAO
                .selectByUserIdAndActivityId(userId, activityId);

        Map<Long, PosterRecommendPublishItem> indexMap = Maps.uniqueIndex(posterRecommendPublishItems, new Function<PosterRecommendPublishItem, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable PosterRecommendPublishItem input) {
                return input.getItemNumIid();
            }
        });

        for (Item item : taobaoItems) {
            PublishItem publishItem = new PublishItem();
            publishItem.setItem(item);

            if (indexMap.values().contains(item.getNumIid())) {
                publishItem.setPublishItemStatus(indexMap.get(item.getNumIid()).getStatus());
            } else {
                publishItem.setPublishItemStatus(PUBLISH_ITEM_STATUS_NOT_IN_DB);
            }
            returnPublishItems.add(publishItem);
        }
        return Page.create(itemPage.getTotalSize(), pageNum, pageSize, returnPublishItems);
    }

    /**
     * 查询投放进度
     *
     * @param userId
     * @param activityId
     */
    public PublishProgress queryPublishProgress(Long userId, Long activityId) {
        PublishProgress publishProgress = posterRecommendPublishItemDAO.groupStatus(userId, activityId);
        return publishProgress;
    }

    /**
     * 卸载活动
     *
     * @param userId
     * @param activityId
     */
    public void unpublishActivity(Long userId, Long activityId) {
        logger.info("start to unpublish activity, userId[{}] activityId[{}]", userId, activityId);

        PosterRecommendActivity activity = posterRecommendActivityDAO.selectByUserIdAndActivityId(userId, activityId);
        if (null == activity) {
            return;
        }
        if (!ALL_PUBLISHED_ACTIVITY_STATUS.contains(activity.getStatus())) {
            logger.info("userId[{}] activity[{}] status[{}] is not one of [{}], skip.", userId, activity,
                    activity.getStatus(), ALL_PUBLISHED_ACTIVITY_STATUS);
            return;
        }
        //开始卸载详情页海报
        PosterRecommendActivity newActivity = new PosterRecommendActivity();
        newActivity.setUserId(userId);
        newActivity.setId(activityId);
        newActivity.setStatus(PosterRecommendConstants.ACTIVITY_STATUS_UNPUBLISHING);
        newActivity.setUnpublishTime(appService.getLocalSystemTime().toDate());
        newActivity.setUnpublishOwner(appService.getOwner());
        posterRecommendActivityDAO.updateByUserIdAndActivityIdSelective(newActivity);

        //卸载单个宝贝
        List<PosterRecommendPublishItem> publishItems = posterRecommendPublishItemDAO.selectByUserIdAndActivityId(userId, activityId);
        List<Exception> exceptions = Lists.newArrayList();
        for (PosterRecommendPublishItem publishItem : publishItems) {
            try {
                unpublishItem(userId, activityId, publishItem.getItemNumIid());
            } catch (TaobaoAccessControlException e) {
                exceptions.add(e);
            } catch (TaobaoEnhancedApiException e) {
                exceptions.add(e);
            } catch (TaobaoSessionExpiredException e) {
                exceptions.add(e);
            }
        }

        //结束投放活动
        if (CollectionUtils.isEmpty(exceptions)) {
            newActivity.setStatus(ACTIVITY_STATUS_UNPUBLISHED);
        } else {
            newActivity.setStatus(ACTIVITY_STATUS_UNPUBLISHED_WITH_ERROR);
        }
        posterRecommendActivityDAO.updateByUserIdAndActivityIdSelective(newActivity);
    }

    /**
     * 卸载参与投放的宝贝
     *
     * @param userId
     * @param activityId
     * @param itemNumIid
     */
    private void unpublishItem(Long userId, Long activityId, Long itemNumIid)
            throws TaobaoAccessControlException, TaobaoEnhancedApiException, TaobaoSessionExpiredException {
        PosterRecommendPublishItem publishItem = posterRecommendPublishItemDAO
                .selectByUserIdAndActivityIdAndItemNumIidAndStatus(userId,
                        activityId,
                        itemNumIid,
                        ImmutableList.of(PUBLISH_ITEM_STATUS_PUBLISHED_SUCCESSFULLY,PUBLISH_ITEM_STATUS_UNPUBLISHED_FAILED));
        if (null == publishItem) {
            return;
        }

        //更新详情页
        Item item = taobaoApiCache.getItem(userId, itemNumIid);
        //1 备份
        String backupDesc = item.getDesc();
        //important
        String updatedDesc = PublishUtils.removeHtmlFromDetailPage(HTML_TAG_RECOMMEND, activityId, item.getDesc());
        ItemUpdateRequest request = new ItemUpdateRequest();
        request.setNumIid(itemNumIid);
        request.setDesc(updatedDesc);
        //插入详情页备份
        PosterRecommendPublishItemDetailPage posterRecommendPublishItemDetailPage = new
                PosterRecommendPublishItemDetailPage();
        posterRecommendPublishItemDetailPage.setUserId(userId);
        posterRecommendPublishItemDetailPage.setActivityId(activityId);
        posterRecommendPublishItemDetailPage.setItemNumIid(item.getNumIid());
        posterRecommendPublishItemDetailPage.setItemTitle(item.getTitle());
        posterRecommendPublishItemDetailPage.setItemPrice(new BigDecimal(item.getPrice()));
        posterRecommendPublishItemDetailPage.setItemPicUrl(item.getPicUrl());
        posterRecommendPublishItemDetailPage.setBackupDesc(backupDesc);
        posterRecommendPublishItemDetailPage.setDesc(updatedDesc);
        posterRecommendPublishItemDetailPage.setAddTime(appService.getLocalSystemTime().toDate());
        try {
            taobaoApiItemService.updateItem(userId, request);
            posterRecommendPublishItemDetailPage.setStatus(DETAIL_PAGE_STATUS_NORMAL);
            unpublishSuccessful(userId, activityId, itemNumIid);
        } catch (BaseTaobaoApiException e) {
            unpublishFailed(userId, activityId, itemNumIid);
            posterRecommendPublishItemDetailPage.setStatus(DETAIL_PAGE_STATUS_PUBLISH_FAILED);
            throw e;
        } finally {
            posterRecommendPublishItemDetailPageDAO.insertSelective(posterRecommendPublishItemDetailPage);
        }
    }

    public void unpublishFailed(Long userId, Long activityId, Long publishItemNumIid) {
        afterUnpublish(userId, activityId, publishItemNumIid, false);
    }

    public void unpublishSuccessful(Long userId, Long activityId, Long publishItemNumIid) {
        afterUnpublish(userId, activityId, publishItemNumIid, true);
    }

    public void afterUnpublish(Long userId, Long activityId, Long publishItemNumIid, boolean successful) {
        PosterRecommendPublishItem newPublishItem = new PosterRecommendPublishItem();
        newPublishItem.setUserId(userId);
        newPublishItem.setActivityId(activityId);
        newPublishItem.setItemNumIid(publishItemNumIid);
        if (successful) {
            newPublishItem.setStatus(PosterRecommendConstants.PUBLISH_ITEM_STATUS_UNPUBLISHED_SUCCESSFULLY);
        } else {
            newPublishItem.setStatus(PosterRecommendConstants.PUBLISH_ITEM_STATUS_UNPUBLISHED_FAILED);
        }
        posterRecommendPublishItemDAO.updateByUserIdAndActivityIdAndItemNumIid(newPublishItem);
    }

    /**
     * 移除指定用户的详情页海报信息
     *
     * @param userId
     */
    public void unpublishActivityByUserId(Long userId) {
        List<PosterRecommendActivity> activities = posterRecommendActivityDAO.paginateActivityByUserId
                (userId, ImmutableList.of(ACTIVITY_STATUS_PUBLISHED, ACTIVITY_STATUS_PUBLISHED_WITH_ERROR),
                        appService.getLocalSystemTime().toDate(), null, 1, 1000);
        for (PosterRecommendActivity activity : activities) {
            unpublishActivity(userId, activity.getId());
        }
    }
}
