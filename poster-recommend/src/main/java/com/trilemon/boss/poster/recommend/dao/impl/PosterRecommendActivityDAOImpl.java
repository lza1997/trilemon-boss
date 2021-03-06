package com.trilemon.boss.poster.recommend.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendActivityDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivity;
import com.trilemon.commons.db.ShardTableMap;
import com.trilemon.commons.db.ShardTableRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@Repository
public class PosterRecommendActivityDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements PosterRecommendActivityDAO {
    @Autowired
    @Qualifier("posterRecommendActivityRouter")
    private ShardTableRouter<PosterRecommendActivity> router;

    public Long insertSelective(PosterRecommendActivity record) {
        checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        return (Long) getSqlMapClientTemplate().insert("poster_recommend_activity.insertSelective", record);
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
    public Integer updateByUserIdAndActivityIdSelective(PosterRecommendActivity activity) {
        checkNotNull(activity.getUserId());
        router.routeAndSetTableId(activity);
        return getSqlMapClientTemplate().update("poster_recommend_activity.updateByUserIdAndActivityIdSelective", activity);
    }

    @Override
    public Integer deleteByUserIdAndActivityId(Long userId, Long activityId) {
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
        return (PosterRecommendActivity) getSqlMapClientTemplate().queryForObject("poster_recommend_activity.selectLastCreatedActivity", _key);
    }

    @Override
    public List<PosterRecommendActivity> paginateActivityByUserId(Long userId, List<Byte> statusList,
                                                                  Date publishTime, String orderBy,
                                                                  int offset, int limit) {
        checkNotNull(userId);
        PosterRecommendActivity activity = new PosterRecommendActivity();
        activity.setUserId(userId);
        ShardTableMap shardTableMap = router.getRouteMap(activity);
        shardTableMap.put("userId", userId);
        shardTableMap.put("statusList", statusList);
        shardTableMap.put("publishTime", publishTime);
        shardTableMap.put("orderBy", orderBy);
        shardTableMap.put("offset", offset);
        shardTableMap.put("limit", limit);
        return (List<PosterRecommendActivity>) getSqlMapClientTemplate().queryForList("poster_recommend_activity.paginateActivityByUserId", shardTableMap);
    }

    @Override
    public Integer countActivityByUserId(Long userId, List<Byte> statusList, Date publishTime) {
        checkNotNull(userId);
        PosterRecommendActivity activity = new PosterRecommendActivity();
        activity.setUserId(userId);
        ShardTableMap shardTableMap = router.getRouteMap(activity);
        shardTableMap.put("userId", userId);
        shardTableMap.put("statusList", statusList);
        shardTableMap.put("publishTime", publishTime);
        return (int) getSqlMapClientTemplate().queryForObject("poster_recommend_activity.countActivityByUserId", shardTableMap);
    }

    @Override
    public List<Long> paginateActivityUsedTemplateByUserId(Long userId, List<Byte> statusList, Date publishTime, String orderBy, int offset, int limit) {
        checkNotNull(userId);
        PosterRecommendActivity activity = new PosterRecommendActivity();
        activity.setUserId(userId);
        ShardTableMap shardTableMap = router.getRouteMap(activity);
        shardTableMap.put("userId", userId);
        shardTableMap.put("statusList", statusList);
        shardTableMap.put("publishTime", publishTime);
        shardTableMap.put("orderBy", orderBy);
        shardTableMap.put("offset", offset);
        shardTableMap.put("limit", limit);
        return (List<Long>) getSqlMapClientTemplate().queryForList("poster_recommend_activity" +
                ".paginateActivityUsedTemplateByUserId", shardTableMap);
    }

    @Override
    public int countActivityUsedTemplateByUserId(Long userId, List<Byte> statusList, Date publishTime) {
        checkNotNull(userId);
        PosterRecommendActivity activity = new PosterRecommendActivity();
        activity.setUserId(userId);
        ShardTableMap shardTableMap = router.getRouteMap(activity);
        shardTableMap.put("userId", userId);
        shardTableMap.put("statusList", statusList);
        shardTableMap.put("publishTime", publishTime);
        return (int) getSqlMapClientTemplate().queryForObject("poster_recommend_activity.countActivityUsedTemplateByUserId", shardTableMap);
    }

    public ShardTableRouter<PosterRecommendActivity> getRouter() {
        return router;
    }

    public void setRouter(ShardTableRouter<PosterRecommendActivity> router) {
        this.router = router;
    }
}