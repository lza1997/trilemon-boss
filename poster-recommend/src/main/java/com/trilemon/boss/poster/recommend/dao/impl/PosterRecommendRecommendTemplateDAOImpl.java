package com.trilemon.boss.poster.recommend.dao.impl;

import com.alibaba.cobarclient.BaseSqlMapClientDaoSupport;
import com.google.common.collect.Maps;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendRecommendTemplateDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendRecommendTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class PosterRecommendRecommendTemplateDAOImpl extends BaseSqlMapClientDaoSupport implements PosterRecommendRecommendTemplateDAO {

    @Override
    public long insertSelective(PosterRecommendRecommendTemplate record) {
        return (long) getSqlMapClientTemplate().insert("poster_recommend_recommend_template.insertSelective", record);
    }

    @Override
    public PosterRecommendRecommendTemplate selectByPrimaryKey(Long id) {
        PosterRecommendRecommendTemplate _key = new PosterRecommendRecommendTemplate();
        _key.setId(id);
        return (PosterRecommendRecommendTemplate) getSqlMapClientTemplate().queryForObject("poster_recommend_recommend_template.selectByPrimaryKey", _key);
    }

    @Override
    public int updateByPrimaryKeySelective(PosterRecommendRecommendTemplate record) {
        return  getSqlMapClientTemplate().update("poster_recommend_recommend_template.updateByPrimaryKeySelective", record);
    }

    @Override
    public List<PosterRecommendRecommendTemplate> selectByRecommendType(Byte recommendType, Date now) {
        Map<String, Object> parameterMap = Maps.newHashMap();
        parameterMap.put("recommendType", recommendType);
        return (List<PosterRecommendRecommendTemplate>) getSqlMapClientTemplate().queryForObject("poster_recommend_recommend_template.selectByRecommendType", parameterMap);
    }
}