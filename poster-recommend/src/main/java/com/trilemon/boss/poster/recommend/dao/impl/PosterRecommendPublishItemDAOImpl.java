package com.trilemon.boss.poster.recommend.dao.impl;

import com.trilemon.boss.poster.recommend.dao.PosterRecommendPublishItemDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendPublishItem;
import com.trilemon.commons.web.Page;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PosterRecommendPublishItemDAOImpl extends SqlMapClientDaoSupport implements PosterRecommendPublishItemDAO {

    public PosterRecommendPublishItemDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Long id) {
        PosterRecommendPublishItem _key = new PosterRecommendPublishItem();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("poster_recommend_publish_item.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(PosterRecommendPublishItem record) {
        getSqlMapClientTemplate().insert("poster_recommend_publish_item.insert", record);
    }

    public void insertSelective(PosterRecommendPublishItem record) {
        getSqlMapClientTemplate().insert("poster_recommend_publish_item.insertSelective", record);
    }

    public PosterRecommendPublishItem selectByPrimaryKey(Long id) {
        PosterRecommendPublishItem _key = new PosterRecommendPublishItem();
        _key.setId(id);
        PosterRecommendPublishItem record = (PosterRecommendPublishItem) getSqlMapClientTemplate().queryForObject("poster_recommend_publish_item.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(PosterRecommendPublishItem record) {
        int rows = getSqlMapClientTemplate().update("poster_recommend_publish_item.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(PosterRecommendPublishItem record) {
        int rows = getSqlMapClientTemplate().update("poster_recommend_publish_item.updateByPrimaryKey", record);
        return rows;
    }

    @Override
    public int deleteByUserIdAndActivityIdAndItemNumIid(Long userId, Long activityId, Long itemNumIid) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Page<PosterRecommendPublishItem> paginateByUserIdAndActivityId(Long userId, Long activityId, int offset, int limit) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int countByUserIdAndActivityIdAndStatus(Long userId, Long activityId, List<Byte> statusList) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<PosterRecommendPublishItem> selectByUserIdAndActivityId(Long userId, Long activityId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateByUserIdAndActivityIdAndItemNumIid(PosterRecommendPublishItem newPublishItem) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public PosterRecommendPublishItem selectByUserIdAndActivityIdAndItemNumIid(Long userId, Long activityId, Long publishItemNumIid) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}