package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.PosterRecommendActivityLog;

public interface PosterRecommendActivityLogDAO {
    int deleteByPrimaryKey(Long id);

    void insert(PosterRecommendActivityLog record);

    void insertSelective(PosterRecommendActivityLog record);

    PosterRecommendActivityLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PosterRecommendActivityLog record);

    int updateByPrimaryKey(PosterRecommendActivityLog record);
}