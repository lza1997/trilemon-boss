package com.trilemon.boss.poster.template.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.google.common.collect.Maps;
import com.trilemon.boss.poster.template.client.request.PosterTemplateQueryRequest;
import com.trilemon.boss.poster.template.dao.PosterTemplateDAO;
import com.trilemon.boss.poster.template.model.PosterTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PosterTemplateDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements PosterTemplateDAO {

    public int deleteByPrimaryKey(Long id) {
        PosterTemplate _key = new PosterTemplate();
        _key.setId(id);
        return getSqlMapClientTemplate().delete("poster_template.deleteByPrimaryKey", _key);
    }

    public void insertSelective(PosterTemplate record) {
        getSqlMapClientTemplate().insert("poster_template.insertSelective", record);
    }

    public PosterTemplate selectByPrimaryKey(Long id) {
        PosterTemplate _key = new PosterTemplate();
        _key.setId(id);
        return (PosterTemplate) getSqlMapClientTemplate().queryForObject("poster_template.selectByPrimaryKey", _key);
    }

    public int updateByPrimaryKeySelective(PosterTemplate record) {
        return getSqlMapClientTemplate().update("poster_template.updateByPrimaryKeySelective", record);
    }

    @Override
    public int countByQueryRequest(PosterTemplateQueryRequest request) {
        return (int) getSqlMapClientTemplate().queryForObject("poster_template.countByQueryRequest", request);
    }

    @Override
    public List<PosterTemplate> paginateByQueryRequest(PosterTemplateQueryRequest request) {
        return (List<PosterTemplate>) getSqlMapClientTemplate().queryForList("poster_template.paginateByQueryRequest", request);
    }

    @Override
    public int updateFavoriteByPrimaryKey(long templateId, int count) {
        Map<String, Object> map = Maps.newHashMap();
        map.put("templateId", templateId);
        map.put("favoriteNum", count);
        return getSqlMapClientTemplate().update("poster_template.updateFavoriteByPrimaryKey", map);
    }

    @Override
    public List<PosterTemplate> selectByPrimaryKeys(List<Long> templateIds) {
        return (List<PosterTemplate>) getSqlMapClientTemplate().queryForList("poster_template.selectByPrimaryKeys",
                templateIds);
    }
}