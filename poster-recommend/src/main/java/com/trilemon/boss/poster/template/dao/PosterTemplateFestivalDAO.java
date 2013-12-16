package com.trilemon.boss.poster.template.dao;

import com.trilemon.boss.poster.template.model.PosterTemplateFestival;
import org.springframework.stereotype.Repository;

@Repository
public interface PosterTemplateFestivalDAO {
    int deleteByPrimaryKey(Integer id);

    void insert(PosterTemplateFestival record);

    void insertSelective(PosterTemplateFestival record);

    PosterTemplateFestival selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PosterTemplateFestival record);

    int updateByPrimaryKey(PosterTemplateFestival record);
}