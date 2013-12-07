package com.trilemon.boss.poster.template.dao;

import com.trilemon.boss.poster.template.client.request.PosterTemplateQueryRequest;
import com.trilemon.boss.poster.template.model.PosterTemplate;

import java.util.List;

public interface PosterTemplateDAO {
    int deleteByPrimaryKey(Long id);

    void insert(PosterTemplate record);

    void insertSelective(PosterTemplate record);

    PosterTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PosterTemplate record);

    int updateByPrimaryKey(PosterTemplate record);

    int countByQueryRequest(PosterTemplateQueryRequest request);

    List<PosterTemplate> selectByQueryRequest(PosterTemplateQueryRequest request);

}