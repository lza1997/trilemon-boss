package com.trilemon.boss.poster.template.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.trilemon.boss.poster.template.dao.PosterTemplateCategoryDAO;
import com.trilemon.boss.poster.template.model.PosterTemplateCategory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PosterTemplateCategoryDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements PosterTemplateCategoryDAO {

    public int deleteByPrimaryKey(Long id) {
        PosterTemplateCategory _key = new PosterTemplateCategory();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("poster_template_category.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(PosterTemplateCategory record) {
        getSqlMapClientTemplate().insert("poster_template_category.insert", record);
    }

    public void insertSelective(PosterTemplateCategory record) {
        getSqlMapClientTemplate().insert("poster_template_category.insertSelective", record);
    }

    public PosterTemplateCategory selectByPrimaryKey(Long id) {
        PosterTemplateCategory _key = new PosterTemplateCategory();
        _key.setId(id);
        PosterTemplateCategory record = (PosterTemplateCategory) getSqlMapClientTemplate().queryForObject("poster_template_category.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(PosterTemplateCategory record) {
        int rows = getSqlMapClientTemplate().update("poster_template_category.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(PosterTemplateCategory record) {
        int rows = getSqlMapClientTemplate().update("poster_template_category.updateByPrimaryKey", record);
        return rows;
    }

    @Override
    public List<PosterTemplateCategory> selectAll() {
        return getSqlMapClientTemplate().queryForList("poster_template_category.selectAll");
    }
}