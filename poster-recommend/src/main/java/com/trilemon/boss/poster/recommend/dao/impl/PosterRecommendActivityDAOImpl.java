package com.trilemon.boss.poster.recommend.dao.impl;

import com.trilemon.boss.poster.recommend.dao.PosterRecommendActivityDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivity;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class PosterRecommendActivityDAOImpl extends SqlMapClientDaoSupport implements PosterRecommendActivityDAO {

    public PosterRecommendActivityDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Long id) {
        PosterRecommendActivity _key = new PosterRecommendActivity();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("poster_recommend_activity.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(PosterRecommendActivity record) {
        getSqlMapClientTemplate().insert("poster_recommend_activity.insert", record);
    }

    public void insertSelective(PosterRecommendActivity record) {
        getSqlMapClientTemplate().insert("poster_recommend_activity.insertSelective", record);
    }

    public PosterRecommendActivity selectByPrimaryKey(Long id) {
        PosterRecommendActivity _key = new PosterRecommendActivity();
        _key.setId(id);
        PosterRecommendActivity record = (PosterRecommendActivity) getSqlMapClientTemplate().queryForObject("poster_recommend_activity.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(PosterRecommendActivity record) {
        int rows = getSqlMapClientTemplate().update("poster_recommend_activity.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(PosterRecommendActivity record) {
        int rows = getSqlMapClientTemplate().update("poster_recommend_activity.updateByPrimaryKey", record);
        return rows;
    }
}