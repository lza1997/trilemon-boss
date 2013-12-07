package com.trilemon.boss.poster.template.dao;

import com.trilemon.boss.poster.template.model.PosterTemplateTopic;

public interface PosterTemplateTopicDAO {
    int deleteByPrimaryKey(Integer id);

    void insert(PosterTemplateTopic record);

    void insertSelective(PosterTemplateTopic record);

    PosterTemplateTopic selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PosterTemplateTopic record);

    int updateByPrimaryKey(PosterTemplateTopic record);
}