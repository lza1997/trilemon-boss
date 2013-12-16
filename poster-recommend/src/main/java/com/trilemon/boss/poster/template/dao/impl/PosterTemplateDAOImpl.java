package com.trilemon.boss.poster.template.dao.impl;

import com.alibaba.cobarclient.BaseSqlMapClientDaoSupport;
import com.trilemon.boss.poster.template.client.request.PosterTemplateQueryRequest;
import com.trilemon.boss.poster.template.dao.PosterTemplateDAO;
import com.trilemon.boss.poster.template.model.PosterTemplate;

import java.util.List;

public class PosterTemplateDAOImpl extends BaseSqlMapClientDaoSupport implements PosterTemplateDAO {

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
       return (int)getSqlMapClientTemplate().queryForObject("poster_template.countByQueryRequest", request);
    }

    @Override
    public List<PosterTemplate> paginateByQueryRequest(PosterTemplateQueryRequest request) {
        return (List<PosterTemplate>)getSqlMapClientTemplate().queryForList("poster_template.paginateByQueryRequest", request);
    }
}