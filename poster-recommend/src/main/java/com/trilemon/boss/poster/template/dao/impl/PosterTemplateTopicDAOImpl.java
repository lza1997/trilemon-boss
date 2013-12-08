package com.trilemon.boss.poster.template.dao.impl;

import com.trilemon.boss.poster.template.dao.PosterTemplateTopicDAO;
import com.trilemon.boss.poster.template.model.PosterTemplateTopic;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.util.List;

public class PosterTemplateTopicDAOImpl extends SqlMapClientDaoSupport implements PosterTemplateTopicDAO {

    public PosterTemplateTopicDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Integer id) {
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

    public PosterTemplateTopic selectByPrimaryKey(Integer id) {
        PosterTemplateTopic _key = new PosterTemplateTopic();
        _key.setId(id);
        PosterTemplateTopic record = (PosterTemplateTopic) getSqlMapClientTemplate().queryForObject("poster_template_topic.selectByPrimaryKey", _key);
        return record;
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