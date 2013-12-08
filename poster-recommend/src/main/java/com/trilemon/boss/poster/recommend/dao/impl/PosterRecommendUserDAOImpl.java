package com.trilemon.boss.poster.recommend.dao.impl;

import com.trilemon.boss.poster.recommend.dao.PosterRecommendUserDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendUser;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class PosterRecommendUserDAOImpl extends SqlMapClientDaoSupport implements PosterRecommendUserDAO {

    public PosterRecommendUserDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Long id) {
        PosterRecommendUser _key = new PosterRecommendUser();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("poster_recommend_user.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(PosterRecommendUser record) {
        getSqlMapClientTemplate().insert("poster_recommend_user.insert", record);
    }

    public void insertSelective(PosterRecommendUser record) {
        getSqlMapClientTemplate().insert("poster_recommend_user.insertSelective", record);
    }

    public PosterRecommendUser selectByPrimaryKey(Long id) {
        PosterRecommendUser _key = new PosterRecommendUser();
        _key.setId(id);
        PosterRecommendUser record = (PosterRecommendUser) getSqlMapClientTemplate().queryForObject("poster_recommend_user.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(PosterRecommendUser record) {
        int rows = getSqlMapClientTemplate().update("poster_recommend_user.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(PosterRecommendUser record) {
        int rows = getSqlMapClientTemplate().update("poster_recommend_user.updateByPrimaryKey", record);
        return rows;
    }

    @Override
    public PosterRecommendUser selectByUserId(Long userId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}