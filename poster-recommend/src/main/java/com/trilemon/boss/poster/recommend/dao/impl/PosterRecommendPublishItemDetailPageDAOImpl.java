package com.trilemon.boss.poster.recommend.dao.impl;

import com.trilemon.boss.poster.recommend.dao.PosterRecommendPublishItemDetailPageDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendPublishItemDetailPage;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class PosterRecommendPublishItemDetailPageDAOImpl extends SqlMapClientDaoSupport implements PosterRecommendPublishItemDetailPageDAO {

    public PosterRecommendPublishItemDetailPageDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Long id) {
        PosterRecommendPublishItemDetailPage _key = new PosterRecommendPublishItemDetailPage();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("poster_recommend_publish_item_detail_page.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(PosterRecommendPublishItemDetailPage record) {
        getSqlMapClientTemplate().insert("poster_recommend_publish_item_detail_page.insert", record);
    }

    public void insertSelective(PosterRecommendPublishItemDetailPage record) {
        getSqlMapClientTemplate().insert("poster_recommend_publish_item_detail_page.insertSelective", record);
    }

    public PosterRecommendPublishItemDetailPage selectByPrimaryKey(Long id) {
        PosterRecommendPublishItemDetailPage _key = new PosterRecommendPublishItemDetailPage();
        _key.setId(id);
        PosterRecommendPublishItemDetailPage record = (PosterRecommendPublishItemDetailPage) getSqlMapClientTemplate().queryForObject("poster_recommend_publish_item_detail_page.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(PosterRecommendPublishItemDetailPage record) {
        int rows = getSqlMapClientTemplate().update("poster_recommend_publish_item_detail_page.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKeyWithBLOBs(PosterRecommendPublishItemDetailPage record) {
        int rows = getSqlMapClientTemplate().update("poster_recommend_publish_item_detail_page.updateByPrimaryKeyWithBLOBs", record);
        return rows;
    }

    public int updateByPrimaryKeyWithoutBLOBs(PosterRecommendPublishItemDetailPage record) {
        int rows = getSqlMapClientTemplate().update("poster_recommend_publish_item_detail_page.updateByPrimaryKey", record);
        return rows;
    }
}