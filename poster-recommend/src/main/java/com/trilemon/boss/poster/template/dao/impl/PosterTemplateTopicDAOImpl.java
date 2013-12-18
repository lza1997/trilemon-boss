package com.trilemon.boss.poster.template.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.trilemon.boss.poster.template.dao.PosterTemplateTopicDAO;
import com.trilemon.boss.poster.template.model.PosterTemplateTopic;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PosterTemplateTopicDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements PosterTemplateTopicDAO {

    public int deleteByPrimaryKey(Long id) {
        PosterTemplateTopic _key = new PosterTemplateTopic();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("poster_template_topic.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(PosterTemplateTopic record) {
        getSqlMapClientTemplate().insert("poster_template_topic.insert", record);
    }

    public void insertSelective(PosterTemplateTopic record) {
        getSqlMapClientTemplate().insert("poster_template_topic.insertSelective", record);
    }

    public PosterTemplateTopic selectByPrimaryKey(Long id) {
        PosterTemplateTopic _key = new PosterTemplateTopic();
        _key.setId(id);
        return (PosterTemplateTopic) getSqlMapClientTemplate().queryForObject("poster_template_topic.selectByPrimaryKey", _key);
    }

    public int updateByPrimaryKeySelective(PosterTemplateTopic record) {
        return getSqlMapClientTemplate().update("poster_template_topic.updateByPrimaryKeySelective", record);
    }

    public int updateByPrimaryKey(PosterTemplateTopic record) {
        return getSqlMapClientTemplate().update("poster_template_topic.updateByPrimaryKey", record);
    }

    @Override
    public List<PosterTemplateTopic> selectAll() {
        return getSqlMapClientTemplate().queryForList("poster_template_topic.selectAll");
    }
}