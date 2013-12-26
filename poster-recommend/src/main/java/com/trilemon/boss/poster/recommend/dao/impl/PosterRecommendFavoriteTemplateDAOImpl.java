package com.trilemon.boss.poster.recommend.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.google.common.collect.Maps;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendFavoriteTemplateDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendFavoriteTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PosterRecommendFavoriteTemplateDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements PosterRecommendFavoriteTemplateDAO {

    public PosterRecommendFavoriteTemplateDAOImpl() {
        super();
    }

    public int deleteByUserIdAndTemplateId(Long userId, Long templateId) {
        PosterRecommendFavoriteTemplate _key = new PosterRecommendFavoriteTemplate();
        _key.setUserId(userId);
        _key.setTemplateId(templateId);
        return getSqlMapClientTemplate().delete("poster_recommend_favorite_template.deleteByUserIdAndTemplateId", _key);
    }

    public long insertSelective(PosterRecommendFavoriteTemplate record) {
        return (long) getSqlMapClientTemplate().insert("poster_recommend_favorite_template.insertSelective", record);
    }

    public PosterRecommendFavoriteTemplate selectByUserIdAndTemplateId(Long userId, Long templateId) {
        PosterRecommendFavoriteTemplate _key = new PosterRecommendFavoriteTemplate();
        _key.setUserId(userId);
        _key.setTemplateId(templateId);
        return (PosterRecommendFavoriteTemplate) getSqlMapClientTemplate().queryForObject("poster_recommend_favorite_template.selectByUserIdAndTemplateId", _key);
    }

    @Override
    public int updateByUserIdAndTemplateIdSelective(PosterRecommendFavoriteTemplate record) {
        return getSqlMapClientTemplate().update("poster_recommend_favorite_template.updateByPrimaryKeySelective", record);
    }

    @Override
    public List<PosterRecommendFavoriteTemplate> paginateByUserId(Long userId, int offset, int limit) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("userId", userId);
        map.put("offset", offset);
        map.put("limit", limit);
        return (List<PosterRecommendFavoriteTemplate>) getSqlMapClientTemplate().queryForList("poster_recommend_favorite_template.paginateByUserId", map);
    }

    @Override
    public int countByUserId(Long userId) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("userId", userId);
        return (int) getSqlMapClientTemplate().queryForObject("poster_recommend_favorite_template.countByUserId", map);
    }
}