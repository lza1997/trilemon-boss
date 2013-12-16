package com.trilemon.boss.poster.recommend.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendPublishItemDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendPublishItem;
import com.trilemon.boss.poster.recommend.model.dto.PublishProgress;
import com.trilemon.commons.db.ShardTableMap;
import com.trilemon.commons.db.ShardTableRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.trilemon.boss.poster.recommend.PosterRecommendConstants.*;

@Repository
public class PosterRecommendPublishItemDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements PosterRecommendPublishItemDAO {
    @Autowired
    @Qualifier("posterRecommendPublishItemRouter")
    private ShardTableRouter<PosterRecommendPublishItem> router;

    public long insertSelective(PosterRecommendPublishItem record) {
        checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        return (long) getSqlMapClientTemplate().insert("poster_recommend_publish_item.insertSelective", record);
    }

    @Override
    public int deleteByUserIdAndActivityIdAndItemNumIid(Long userId, Long activityId, Long itemNumIid) {
        PosterRecommendPublishItem _key = new PosterRecommendPublishItem();
        _key.setUserId(userId);
        _key.setActivityId(activityId);
        _key.setItemNumIid(itemNumIid);
        router.routeAndSetTableId(_key);
        return getSqlMapClientTemplate().delete("poster_recommend_publish_item.deleteByUserIdAndActivityIdAndItemNumIid", _key);
    }

    @Override
    public List<PosterRecommendPublishItem> selectByUserIdAndActivityId(Long userId, Long activityId) {
        PosterRecommendPublishItem _key = new PosterRecommendPublishItem();
        _key.setUserId(userId);
        _key.setActivityId(activityId);
        router.routeAndSetTableId(_key);
        return (List<PosterRecommendPublishItem>) getSqlMapClientTemplate().queryForList("poster_recommend_publish_item.selectByUserIdAndActivityId", _key);
    }

    @Override
    public PosterRecommendPublishItem selectByUserIdAndActivityIdAndItemNumIid(Long userId, Long activityId, Long itemNumIid) {
        PosterRecommendPublishItem _key = new PosterRecommendPublishItem();
        _key.setUserId(userId);
        _key.setActivityId(activityId);
        _key.setItemNumIid(itemNumIid);
        router.routeAndSetTableId(_key);
        return (PosterRecommendPublishItem) getSqlMapClientTemplate().queryForObject("poster_recommend_publish_item.selectByUserIdAndActivityIdAndItemNumIid", _key);
    }

    @Override
    public int updateByUserIdAndActivityIdAndItemNumIid(PosterRecommendPublishItem publishItem) {
        checkNotNull(publishItem.getUserId());
        router.routeAndSetTableId(publishItem);
        return getSqlMapClientTemplate().update("poster_recommend_publish_item.updateByUserIdAndActivityIdAndItemNumIidSelective", publishItem);
    }

    @Override
    public List<PosterRecommendPublishItem> paginateByUserIdAndActivityId(Long userId, Long activityId,
                                                                          String orderBy, int offset, int limit) {
        checkNotNull(userId);
        PosterRecommendPublishItem publishItem = new PosterRecommendPublishItem();
        publishItem.setUserId(userId);
        ShardTableMap shardTableMap = router.getRouteMap(publishItem);
        shardTableMap.put("userId", userId);
        shardTableMap.put("activityId", activityId);
        shardTableMap.put("orderBy", orderBy);
        shardTableMap.put("offset", offset);
        shardTableMap.put("limit", limit);
        return (List<PosterRecommendPublishItem>) getSqlMapClientTemplate().queryForList("poster_recommend_publish_item.paginateByUserIdAndActivityId", shardTableMap);
    }

    @Override
    public PublishProgress groupStatus(Long userId, Long activityId) {
        checkNotNull(userId);
        PosterRecommendPublishItem publishItem = new PosterRecommendPublishItem();
        publishItem.setUserId(userId);
        ShardTableMap shardTableMap = router.getRouteMap(publishItem);
        shardTableMap.put("userId", userId);
        shardTableMap.put("activityId", activityId);
        Map<String, Object> returnMap = getSqlMapClientTemplate().queryForMap("poster_recommend_publish_item.groupStatus",
                shardTableMap, "status", "count");
        PublishProgress publishProgress = new PublishProgress();

        Object waitingPublishItemNumObj = returnMap.get(PUBLISH_ITEM_STATUS_WAITING_PUBLISH);
        if (null != returnMap.get(waitingPublishItemNumObj)) {
            publishProgress.setWaitingPublishItemNum((int) waitingPublishItemNumObj);
        }

        Object publishedSuccessfullyItemNumObj = returnMap.get(PUBLISH_ITEM_STATUS_PUBLISHED_SUCCESSFULLY);
        if (null != returnMap.get(publishedSuccessfullyItemNumObj)) {
            publishProgress.setPublishedSuccessfullyItemNum((int) publishedSuccessfullyItemNumObj);
        }

        Object publishedFailedItemNumObj = returnMap.get(PUBLISH_ITEM_STATUS_PUBLISHED_FAILED);
        if (null != returnMap.get(publishedFailedItemNumObj)) {
            publishProgress.setPublishedFailedItemNum((int) publishedFailedItemNumObj);
        }
        return publishProgress;
    }

    @Override
    public int countByUserIdAndActivityId(Long userId, Long activityId) {
        checkNotNull(userId);
        PosterRecommendPublishItem publishItem = new PosterRecommendPublishItem();
        publishItem.setUserId(userId);
        ShardTableMap shardTableMap = router.getRouteMap(publishItem);
        shardTableMap.put("userId", userId);
        shardTableMap.put("activityId", activityId);
        return (int) getSqlMapClientTemplate().queryForObject("poster_recommend_publish_item.countByUserIdAndActivityId", shardTableMap);
    }
}