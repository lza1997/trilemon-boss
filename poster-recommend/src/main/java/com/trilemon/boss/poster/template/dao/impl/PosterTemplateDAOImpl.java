package com.trilemon.boss.poster.template.dao.impl;

import com.trilemon.boss.poster.template.client.request.PosterTemplateQueryRequest;
import com.trilemon.boss.poster.template.dao.PosterTemplateDAO;
import com.trilemon.boss.poster.template.model.PosterTemplate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.util.List;

public class PosterTemplateDAOImpl extends SqlMapClientDaoSupport implements PosterTemplateDAO {

    public PosterTemplateDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Long id) {
        PosterTemplate _key = new PosterTemplate();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("poster_template.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(PosterTemplate record) {
        getSqlMapClientTemplate().insert("poster_template.insert", record);
    }

    public void insertSelective(PosterTemplate record) {
        getSqlMapClientTemplate().insert("poster_template.insertSelective", record);
    }

    public PosterTemplate selectByPrimaryKey(Long id) {
        PosterTemplate _key = new PosterTemplate();
        _key.setId(id);
        PosterTemplate record = (PosterTemplate) getSqlMapClientTemplate().queryForObject("poster_template.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(PosterTemplate record) {
        int rows = getSqlMapClientTemplate().update("poster_template.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(PosterTemplate record) {
        int rows = getSqlMapClientTemplate().update("poster_template.updateByPrimaryKey", record);
        return rows;
    }

    @Override
    public int countByQueryRequest(PosterTemplateQueryRequest request) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<PosterTemplate> selectByQueryRequest(PosterTemplateQueryRequest request) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}