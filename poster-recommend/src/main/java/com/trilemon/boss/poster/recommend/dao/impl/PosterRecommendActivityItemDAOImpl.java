package com.trilemon.boss.poster.recommend.dao.impl;

import com.trilemon.boss.poster.recommend.dao.PosterRecommendActivityItemDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivityItem;
import com.trilemon.commons.web.Page;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PosterRecommendActivityItemDAOImpl extends SqlMapClientDaoSupport implements PosterRecommendActivityItemDAO {

    public PosterRecommendActivityItemDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Long id) {
        PosterRecommendActivityItem _key = new PosterRecommendActivityItem();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("poster_recommend_activity_item.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(PosterRecommendActivityItem record) {
        getSqlMapClientTemplate().insert("poster_recommend_activity_item.insert", record);
    }

    public void insertSelective(PosterRecommendActivityItem record) {
        getSqlMapClientTemplate().insert("poster_recommend_activity_item.insertSelective", record);
    }

    public PosterRecommendActivityItem selectByPrimaryKey(Long id) {
        PosterRecommendActivityItem _key = new PosterRecommendActivityItem();
        _key.setId(id);
        PosterRecommendActivityItem record = (PosterRecommendActivityItem) getSqlMapClientTemplate().queryForObject("poster_recommend_activity_item.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(PosterRecommendActivityItem record) {
        int rows = getSqlMapClientTemplate().update("poster_recommend_activity_item.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(PosterRecommendActivityItem record) {
        int rows = getSqlMapClientTemplate().update("poster_recommend_activity_item.updateByPrimaryKey", record);
        return rows;
    }

    @Override
    public int deleteByUserIdAndActivityIdAndItemNumIid(Long userId, Long activityId, Long itemNumIid) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Page<PosterRecommendActivityItem> paginateByUserIdAndActivityId(Long userId, Long activityId, int offset, int limit) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<PosterRecommendActivityItem> selectByUserIdAndActivityId(Long userId, Long activityId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteByUserIdAndActivityId(Long userId, Long activityId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int countByUserIdAndActivityId(Long userId, Long activityId) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }
}