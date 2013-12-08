package com.trilemon.boss.poster.recommend.dao.impl;

import com.trilemon.boss.poster.recommend.dao.PosterRecommendLogDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendLog;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class PosterRecommendLogDAOImpl extends SqlMapClientDaoSupport implements PosterRecommendLogDAO {

    public PosterRecommendLogDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Long id) {
        PosterRecommendLog _key = new PosterRecommendLog();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("poster_recommend_log.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(PosterRecommendLog record) {
        getSqlMapClientTemplate().insert("poster_recommend_log.insert", record);
    }

    public void insertSelective(PosterRecommendLog record) {
        getSqlMapClientTemplate().insert("poster_recommend_log.insertSelective", record);
    }

    public PosterRecommendLog selectByPrimaryKey(Long id) {
        PosterRecommendLog _key = new PosterRecommendLog();
        _key.setId(id);
        PosterRecommendLog record = (PosterRecommendLog) getSqlMapClientTemplate().queryForObject("poster_recommend_log.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(PosterRecommendLog record) {
        int rows = getSqlMapClientTemplate().update("poster_recommend_log.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(PosterRecommendLog record) {
        int rows = getSqlMapClientTemplate().update("poster_recommend_log.updateByPrimaryKey", record);
        return rows;
    }
}