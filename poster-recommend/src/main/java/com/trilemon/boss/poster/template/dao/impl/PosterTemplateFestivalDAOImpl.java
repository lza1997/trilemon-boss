package com.trilemon.boss.poster.template.dao.impl;

import com.trilemon.boss.poster.template.dao.PosterTemplateFestivalDAO;
import com.trilemon.boss.poster.template.model.PosterTemplateFestival;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class PosterTemplateFestivalDAOImpl extends SqlMapClientDaoSupport implements PosterTemplateFestivalDAO {

    public PosterTemplateFestivalDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Integer id) {
        PosterTemplateFestival _key = new PosterTemplateFestival();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("poster_template_festival.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(PosterTemplateFestival record) {
        getSqlMapClientTemplate().insert("poster_template_festival.insert", record);
    }

    public void insertSelective(PosterTemplateFestival record) {
        getSqlMapClientTemplate().insert("poster_template_festival.insertSelective", record);
    }

    public PosterTemplateFestival selectByPrimaryKey(Integer id) {
        PosterTemplateFestival _key = new PosterTemplateFestival();
        _key.setId(id);
        PosterTemplateFestival record = (PosterTemplateFestival) getSqlMapClientTemplate().queryForObject("poster_template_festival.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(PosterTemplateFestival record) {
        int rows = getSqlMapClientTemplate().update("poster_template_festival.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(PosterTemplateFestival record) {
        int rows = getSqlMapClientTemplate().update("poster_template_festival.updateByPrimaryKey", record);
        return rows;
    }
}