package com.trilemon.boss.poster.template.dao;

import com.trilemon.boss.poster.template.model.PosterTemplateCategory;

import java.util.List;

public interface PosterTemplateCategoryDAO {
    int deleteByPrimaryKey(Long id);

    void insert(PosterTemplateCategory record);

    void insertSelective(PosterTemplateCategory record);

    PosterTemplateCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PosterTemplateCategory record);

    int updateByPrimaryKey(PosterTemplateCategory record);

    List<PosterTemplateCategory> selectAll();
}