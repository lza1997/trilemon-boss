package com.trilemon.boss.poster.recommend.dao.impl;

import com.trilemon.boss.poster.recommend.dao.PosterRecommendActivityItemDetailPageDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivityItemDetailPage;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class PosterRecommendActivityItemDetailPageDAOImpl extends SqlMapClientDaoSupport implements PosterRecommendActivityItemDetailPageDAO {

    public PosterRecommendActivityItemDetailPageDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Long id) {
        PosterRecommendActivityItemDetailPage _key = new PosterRecommendActivityItemDetailPage();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("poster_recommend_activity_item_detail_page.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(PosterRecommendActivityItemDetailPage record) {
        getSqlMapClientTemplate().insert("poster_recommend_activity_item_detail_page.insert", record);
    }

    public void insertSelective(PosterRecommendActivityItemDetailPage record) {
        getSqlMapClientTemplate().insert("poster_recommend_activity_item_detail_page.insertSelective", record);
    }

    public PosterRecommendActivityItemDetailPage selectByPrimaryKey(Long id) {
        PosterRecommendActivityItemDetailPage _key = new PosterRecommendActivityItemDetailPage();
        _key.setId(id);
        PosterRecommendActivityItemDetailPage record = (PosterRecommendActivityItemDetailPage) getSqlMapClientTemplate().queryForObject("poster_recommend_activity_item_detail_page.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(PosterRecommendActivityItemDetailPage record) {
        int rows = getSqlMapClientTemplate().update("poster_recommend_activity_item_detail_page.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKeyWithBLOBs(PosterRecommendActivityItemDetailPage record) {
        int rows = getSqlMapClientTemplate().update("poster_recommend_activity_item_detail_page.updateByPrimaryKeyWithBLOBs", record);
        return rows;
    }

    public int updateByPrimaryKeyWithoutBLOBs(PosterRecommendActivityItemDetailPage record) {
        int rows = getSqlMapClientTemplate().update("poster_recommend_activity_item_detail_page.updateByPrimaryKey", record);
        return rows;
    }
}