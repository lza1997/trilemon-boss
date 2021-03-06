package com.trilemon.boss.poster.recommend.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendActivityItemDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivityItem;
import com.trilemon.commons.db.ShardTableMap;
import com.trilemon.commons.db.ShardTableRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@Repository
public class PosterRecommendActivityItemDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements PosterRecommendActivityItemDAO {
    @Autowired
    @Qualifier("posterRecommendActivityItemRouter")
    private ShardTableRouter<PosterRecommendActivityItem> router;

    @Override
    public Long insertSelective(PosterRecommendActivityItem record) {
        checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        return (Long) getSqlMapClientTemplate().insert("poster_recommend_activity_item.insertSelective", record);
    }

    @Override
    public Integer countByUserIdAndActivityId(Long userId, Long activityId) {
        checkNotNull(userId);
        PosterRecommendActivityItem activityItem = new PosterRecommendActivityItem();
        activityItem.setUserId(userId);
        ShardTableMap shardTableMap = router.getRouteMap(activityItem);
        shardTableMap.put("userId", userId);
        shardTableMap.put("activityId", activityId);
        return (Integer) getSqlMapClientTemplate().queryForObject("poster_recommend_activity_item.countByUserIdAndActivityId", shardTableMap);
    }

    @Override
    public Integer deleteByUserIdAndActivityId(Long userId, Long activityId) {
        PosterRecommendActivityItem _key = new PosterRecommendActivityItem();
        _key.setUserId(userId);
        _key.setActivityId(activityId);
        router.routeAndSetTableId(_key);
        int rows = getSqlMapClientTemplate().delete("poster_recommend_activity_item.deleteByUserIdAndActivityId", _key);
        return rows;
    }

    @Override
    public Integer deleteByUserIdAndActivityIdAndItemNumIid(Long userId, Long activityId, Long itemNumIid) {
        PosterRecommendActivityItem _key = new PosterRecommendActivityItem();
        _key.setUserId(userId);
        _key.setItemNumIid(itemNumIid);
        _key.setActivityId(activityId);
        router.routeAndSetTableId(_key);
        int rows = getSqlMapClientTemplate().delete("poster_recommend_activity_item.deleteByUserIdAndActivityIdAndItemNumIid", _key);
        return rows;
    }

    @Override
    public List<PosterRecommendActivityItem> paginateByUserIdAndActivityId(Long userId, Long activityId, String orderBy,
                                                                           int offset, int limit) {
        checkNotNull(userId);
        PosterRecommendActivityItem _key = new PosterRecommendActivityItem();
        _key.setUserId(userId);
        ShardTableMap shardTableMap = router.getRouteMap(_key);
        shardTableMap.put("userId", userId);
        shardTableMap.put("activityId", activityId);
        shardTableMap.put("orderBy", orderBy);
        shardTableMap.put("offset", offset);
        shardTableMap.put("limit", limit);
        return (List<PosterRecommendActivityItem>) getSqlMapClientTemplate().queryForList("poster_recommend_activity_item.paginateByUserIdAndActivityId", shardTableMap);
    }

    @Override
    public Integer batchInsert(List<PosterRecommendActivityItem> posterRecommendActivityItems) {
        for(PosterRecommendActivityItem posterRecommendActivityItem:posterRecommendActivityItems){
            router.routeAndSetTableId(posterRecommendActivityItem);
        }
        return batchInsert("poster_recommend_activity_item.insertSelective", posterRecommendActivityItems);
    }

    @Override
    public Integer batchDelete(List<PosterRecommendActivityItem> posterRecommendActivityItems) {
        for(PosterRecommendActivityItem posterRecommendActivityItem:posterRecommendActivityItems){
            router.routeAndSetTableId(posterRecommendActivityItem);
        }
        return batchDelete("poster_recommend_activity_item.deleteByUserIdAndActivityIdAndItemNumIid",posterRecommendActivityItems);
    }

    @Override
    public Integer batchUpdate(List<PosterRecommendActivityItem> posterRecommendActivityItems) {
        for(PosterRecommendActivityItem posterRecommendActivityItem:posterRecommendActivityItems){
            router.routeAndSetTableId(posterRecommendActivityItem);
        }
        return batchUpdate("poster_recommend_activity_item.updateByUserIdAndActivityIdAndItemNumIidSelective",
                posterRecommendActivityItems);
    }

    @Override
    public List<PosterRecommendActivityItem> selectByUserIdAndActivityId(Long userId, Long activityId) {
        PosterRecommendActivityItem _key = new PosterRecommendActivityItem();
        _key.setUserId(userId);
        _key.setActivityId(activityId);
        router.routeAndSetTableId(_key);
        return (List<PosterRecommendActivityItem>) getSqlMapClientTemplate().queryForList("poster_recommend_activity_item.selectByUserIdAndActivityId", _key);
    }

    public ShardTableRouter<PosterRecommendActivityItem> getRouter() {
        return router;
    }

    public void setRouter(ShardTableRouter<PosterRecommendActivityItem> router) {
        this.router = router;
    }
}