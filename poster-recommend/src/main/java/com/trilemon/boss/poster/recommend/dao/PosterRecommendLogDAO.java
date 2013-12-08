package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.PosterRecommendLog;

public interface PosterRecommendLogDAO {
    int deleteByPrimaryKey(Long id);

    void insert(PosterRecommendLog record);

    void insertSelective(PosterRecommendLog record);

    PosterRecommendLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PosterRecommendLog record);

    int updateByPrimaryKey(PosterRecommendLog record);
}