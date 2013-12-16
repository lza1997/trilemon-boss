package com.trilemon.boss.poster.template.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.trilemon.boss.poster.template.dao.PosterTemplateFestivalDAO;
import com.trilemon.boss.poster.template.model.PosterTemplateFestival;
import org.springframework.stereotype.Repository;

@Repository
public class PosterTemplateFestivalDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements PosterTemplateFestivalDAO {

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
        return (PosterTemplateFestival) getSqlMapClientTemplate().queryForObject("poster_template_festival.selectByPrimaryKey", _key);
    }

    public int updateByPrimaryKeySelective(PosterTemplateFestival record) {
        return getSqlMapClientTemplate().update("poster_template_festival.updateByPrimaryKeySelective", record);
    }

    public int updateByPrimaryKey(PosterTemplateFestival record) {
        return getSqlMapClientTemplate().update("poster_template_festival.updateByPrimaryKey", record);
    }
}