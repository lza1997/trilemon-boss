package com.trilemon.boss.poster.recommend.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendUserDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PosterRecommendUserDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements PosterRecommendUserDAO {

    public long insertSelective(PosterRecommendUser record) {
        return (long) getSqlMapClientTemplate().insert("poster_recommend_user.insertSelective", record);
    }

    public int updateByUserIdSelective(Long userId) {
        PosterRecommendUser _key = new PosterRecommendUser();
        _key.setUserId(userId);
        return getSqlMapClientTemplate().update("poster_recommend_user.updateByUserIdSelective", _key);
    }

    @Override
    public PosterRecommendUser selectByUserId(Long userId) {
        PosterRecommendUser _key = new PosterRecommendUser();
        _key.setUserId(userId);
        return (PosterRecommendUser) getSqlMapClientTemplate().queryForObject("poster_recommend_user.selectByUserId", _key);
    }

    @Override
    public List<PosterRecommendUser> paginateUsersByStatus(ImmutableList<Byte> statusList, int offset, int limit) {
        Map<String,Object> map= Maps.newHashMap();
        map.put("statusList",statusList);
        map.put("offset",offset);
        map.put("limit",limit);
        return (List<PosterRecommendUser>) getSqlMapClientTemplate().queryForList("poster_recommend_user.paginateUsersByStatus", map);
    }

    @Override
    public int countUsersByStatus(ImmutableList<Byte> statusList) {
        Map<String,Object> map= Maps.newHashMap();
        map.put("statusList",statusList);
        return (int) getSqlMapClientTemplate().queryForObject("poster_recommend_user.countUsersByStatus", map);
    }
}