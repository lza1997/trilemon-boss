package com.trilemon.boss.poster.recommend.service;

import com.google.common.collect.Lists;
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
import com.trilemon.boss.poster.template.PosterTemplateConstants;
import com.trilemon.boss.poster.template.PublishUtils;
import com.trilemon.commons.web.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

import static com.trilemon.boss.poster.recommend.PosterRecommendConstants.*;

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
     * 添加投放宝贝，已商品做为前台id
     *
     * @param userId
     * @param activityId
     * @param posterRecommendPublishItem
     */
    public PosterRecommendPublishItem addPublishItem(Long userId, Long activityId, PosterRecommendPublishItem posterRecommendPublishItem) {
        posterRecommendPublishItem.setUserId(userId);
        posterRecommendPublishItem.setActivityId(activityId);
        posterRecommendPublishItem.setStatus(PUBLISH_ITEM_STATUS_WAITING_PUBLISH);
        posterRecommendPublishItem.setAddTime(appService.getLocalSystemTime().toDate());
        posterRecommendPublishItemDAO.insertSelective(posterRecommendPublishItem);
        return posterRecommendPublishItem;
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
        //开始投放活动
        PosterRecommendActivity newActivity = new PosterRecommendActivity();
        newActivity.setUserId(userId);
        newActivity.setId(activityId);
        newActivity.setStatus(PosterRecommendConstants.ACTIVITY_STATUS_PUBLISHING);
        newActivity.setPublishTime(appService.getLocalSystemTime().toDate());
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
            newActivity.setStatus(PosterRecommendConstants.ACTIVITY_STATUS_PUBLISHING);
        } else {
            newActivity.setStatus(PosterRecommendConstants.ACTIVITY_STATUS_PUBLISHED_WITH_ERROR);
        }
        posterRecommendActivityDAO.updateByUserIdAndActivityIdSelective(newActivity);
    }

    @Transactional
    public void publish2Item(Long userId, Long activityId, Long publishItemNumIid, String publishHtml)
            throws TaobaoAccessControlException, TaobaoEnhancedApiException, TaobaoSessionExpiredException {
        PosterRecommendPublishItem publishItem = posterRecommendPublishItemDAO.selectByUserIdAndActivityIdAndItemNumIid(userId, activityId, publishItemNumIid);
        if (null == publishItem) {
            return;
        }

        //更新详情页
        Item item = taobaoApiCache.getItem(userId, publishItemNumIid);
        //1 备份
        String backupDesc = item.getDesc();
        //important
        String updatedDesc = PublishUtils.addHtml2DetailPage(publishItem.getDetailPagePosition(),
                PosterTemplateConstants.HTML_TAG_RECOMMEND, activityId,
                publishHtml,
                item.getDesc());
        ItemUpdateRequest request = new ItemUpdateRequest();
        request.setNumIid(publishItemNumIid);
        request.setDesc(updatedDesc);
        try {
            taobaoApiItemService.updateItem(userId, request);
            publishSuccessful(userId, activityId, publishItemNumIid);
        } catch (BaseTaobaoApiException e) {
            throw e;
        } finally {
            publishFailed(userId, activityId, publishItemNumIid);
        }

        //插入详情页备份
        PosterRecommendPublishItemDetailPage posterRecommendPublishItemDetailPage = new
                PosterRecommendPublishItemDetailPage();
        posterRecommendPublishItemDetailPage.setUserId(userId);
        posterRecommendPublishItemDetailPage.setActivityId(activityId);
        posterRecommendPublishItemDetailPage.setItemNumIid(item.getNumIid());
        posterRecommendPublishItemDetailPage.setItemTitle(item.getTitle());
        posterRecommendPublishItemDetailPage.setItemPrice(new BigDecimal(item.getPrice()));
        posterRecommendPublishItemDetailPage.setItemPicUrl(item.getPicUrl());
        posterRecommendPublishItemDetailPage.setStatus(DETAIL_PAGE_STATUS_NORMAL);
        posterRecommendPublishItemDetailPage.setBackupDesc(backupDesc);
        posterRecommendPublishItemDetailPage.setDesc(updatedDesc);
        posterRecommendPublishItemDetailPage.setAddTime(appService.getLocalSystemTime().toDate());
        posterRecommendPublishItemDetailPageDAO.insertSelective(posterRecommendPublishItemDetailPage);
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
        if (CollectionUtils.isEmpty(publishItems)) {
            return Page.create(count, pageNum, pageSize, publishItems);
        } else {
            return Page.empty();
        }
    }

    /**
     *  查询可供选择加入投放的宝贝
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
        List<PublishItem> publishItems = Lists.newArrayList();

        //从淘宝 api 获取商品
        if (onSale) {
            itemPage = taobaoApiShopService.paginateOnSaleItems(userId, query, ITEM_FIELDS, sellerCids, pageNum,
                    pageSize, true, null, PosterRecommendConstants.API_ITEM_GET_ORDER_BY_MODIFIED_DESC);

        } else {
            itemPage = taobaoApiShopService.paginateInventoryItems(userId, query,
                    ITEM_FIELDS, Lists.newArrayList(BANNER_FOR_SHELVED), sellerCids,
                    pageNum, pageSize, true, PosterRecommendConstants.API_ITEM_GET_ORDER_BY_MODIFIED_DESC);
        }

        //获取已经加入活动的宝贝
        List<PosterRecommendPublishItem> addedPublishItems = posterRecommendPublishItemDAO
                .selectByUserIdAndActivityId(userId, activityId);

        //设置是否加入活动的标志位
        if (org.apache.commons.collections.CollectionUtils.isNotEmpty(itemPage.getItems())) {
            for (Item item : itemPage.getItems()) {
                PublishItem publishItem = new PublishItem();
                publishItem.setItem(item);

                if (org.apache.commons.collections.CollectionUtils.isNotEmpty(addedPublishItems) && addedPublishItems.contains(item)) {
                    publishItem.setPublished(true);
                } else {
                    publishItem.setPublished(false);
                }

                publishItems.add(publishItem);
            }
        }

        return Page.create(itemPage.getTotalSize(), itemPage.getPageNum(), itemPage.getPageSize(), publishItems);
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
}
