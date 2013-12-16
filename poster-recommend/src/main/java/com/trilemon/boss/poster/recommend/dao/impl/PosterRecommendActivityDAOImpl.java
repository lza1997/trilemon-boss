package com.trilemon.boss.poster.recommend.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendActivityDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivity;
import com.trilemon.commons.db.ShardTableMap;
import com.trilemon.commons.db.ShardTableRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@Repository
public class PosterRecommendActivityDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements PosterRecommendActivityDAO {
    @Autowired
    @Qualifier("posterRecommendActivityRouter")
    private ShardTableRouter<PosterRecommendActivity> router;

    public long insertSelective(PosterRecommendActivity record) {
        checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        return (long) getSqlMapClientTemplate().insert("poster_recommend_activity.insertSelective", record);
    }

    @Override
    public PosterRecommendActivity selectByUserIdAndActivityId(Long userId, Long activityId) {
        PosterRecommendActivity _key = new PosterRecommendActivity();
        _key.setUserId(userId);
        _key.setId(activityId);
        router.routeAndSetTableId(_key);
        return (PosterRecommendActivity) getSqlMapClientTemplate().queryForObject("poster_recommend_activity.selectByUserIdAndActivityId", _key);
    }

    @Override
    public int updateByUserIdAndActivityIdSelective(PosterRecommendActivity activity) {
        checkNotNull(activity.getUserId());
        router.routeAndSetTableId(activity);
        return getSqlMapClientTemplate().update("poster_recommend_activity.updateByUserIdAndActivityIdSelective", activity);
    }

    @Override
    public int deleteByUserIdAndActivityId(Long userId, Long activityId) {
        PosterRecommendActivity _key = new PosterRecommendActivity();
        _key.setUserId(userId);
        _key.setId(activityId);
        router.routeAndSetTableId(_key);
        return getSqlMapClientTemplate().delete("poster_recommend_activity.deleteByUserIdAndActivityId", _key);
    }

    @Override
    public PosterRecommendActivity selectLastCreatedActivity(Long userId) {
        PosterRecommendActivity _key = new PosterRecommendActivity();
        _key.setUserId(userId);
        router.routeAndSetTableId(_key);
        return (PosterRecommendActivity)getSqlMapClientTemplate().queryForObject("poster_recommend_activity.selectLastCreatedActivity", _key);
    }

    @Override
    public List<PosterRecommendActivity> paginateActivityAndStatus(Long userId, List<Byte> statusList,
                                                                   String orderBy, int offset, int limit) {
        checkNotNull(userId);
        PosterRecommendActivity activity = new PosterRecommendActivity();
        activity.setUserId(userId);
        ShardTableMap shardTableMap = router.getRouteMap(activity);
        shardTableMap.put("userId", userId);
        shardTableMap.put("statusList", statusList);
        shardTableMap.put("orderBy",orderBy);
        shardTableMap.put("offset", offset);
        shardTableMap.put("limit", limit);
        return (List<PosterRecommendActivity>) getSqlMapClientTemplate().queryForList("poster_recommend_activity.paginateActivityAndStatus", shardTableMap);
    }

    @Override
    public int countActivityByUserIdAndStatus(Long userId, List<Byte> statusList) {
        checkNotNull(userId);
        PosterRecommendActivity activity = new PosterRecommendActivity();
        activity.setUserId(userId);
        ShardTableMap shardTableMap = router.getRouteMap(activity);
        shardTableMap.put("userId", userId);
        shardTableMap.put("statusList", statusList);
        return (int) getSqlMapClientTemplate().queryForObject("poster_recommend_activity.countActivityByUserIdAndStatus", shardTableMap);
    }

    public ShardTableRouter<PosterRecommendActivity> getRouter() {
        return router;
    }

    public void setRouter(ShardTableRouter<PosterRecommendActivity> router) {
        this.router = router;
    }
}