package com.trilemon.boss.poster.recommend.dao.impl;

import com.trilemon.boss.poster.recommend.dao.PosterRecommendActivityDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivity;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class PosterRecommendActivityDAOImpl extends SqlMapClientDaoSupport implements PosterRecommendActivityDAO {

    public PosterRecommendActivityDAOImpl() {
        super();
    }

    public long insertSelective(Long userId, PosterRecommendActivity record) {
        return (long) getSqlMapClientTemplate().insert("poster_recommend_activity.insertSelective", record);
    }

    public int updateByPrimaryKeySelective(Long userId, PosterRecommendActivity record) {
        int rows = getSqlMapClientTemplate().update("poster_recommend_activity.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(Long userId, PosterRecommendActivity record) {
        int rows = getSqlMapClientTemplate().update("poster_recommend_activity.updateByPrimaryKey", record);
        return rows;
    }

    @Override
    public PosterRecommendActivity selectByUserIdAndActivityId(Long userId, Long activityId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int updateByUserIdAndActivityId(PosterRecommendActivity record) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int deleteByUserIdAndActivityId(Long userId, Long activityId) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PosterRecommendActivity selectLastCreatedActivity(Long userId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}