package com.trilemon.boss.poster.recommend.dao.impl;

import com.trilemon.boss.poster.recommend.dao.PosterRecommendActivityLogDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivityLog;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class PosterRecommendActivityLogDAOImpl extends SqlMapClientDaoSupport implements PosterRecommendActivityLogDAO {

    public PosterRecommendActivityLogDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Long id) {
        PosterRecommendActivityLog _key = new PosterRecommendActivityLog();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("poster_recommend_activity_log.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(PosterRecommendActivityLog record) {
        getSqlMapClientTemplate().insert("poster_recommend_activity_log.insert", record);
    }

    public void insertSelective(PosterRecommendActivityLog record) {
        getSqlMapClientTemplate().insert("poster_recommend_activity_log.insertSelective", record);
    }

    public PosterRecommendActivityLog selectByPrimaryKey(Long id) {
        PosterRecommendActivityLog _key = new PosterRecommendActivityLog();
        _key.setId(id);
        PosterRecommendActivityLog record = (PosterRecommendActivityLog) getSqlMapClientTemplate().queryForObject("poster_recommend_activity_log.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(PosterRecommendActivityLog record) {
        int rows = getSqlMapClientTemplate().update("poster_recommend_activity_log.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(PosterRecommendActivityLog record) {
        int rows = getSqlMapClientTemplate().update("poster_recommend_activity_log.updateByPrimaryKey", record);
        return rows;
    }
}