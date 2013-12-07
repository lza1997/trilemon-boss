package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.PosterRecommendActivityItem;

public interface PosterRecommendActivityItemDAO {
    int deleteByPrimaryKey(Long id);

    void insert(PosterRecommendActivityItem record);

    void insertSelective(PosterRecommendActivityItem record);

    PosterRecommendActivityItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PosterRecommendActivityItem record);

    int updateByPrimaryKey(PosterRecommendActivityItem record);
}