package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.*;

public interface PosterRecommendActivityDAO {
    int deleteByPrimaryKey(Long id);

    void insert(PosterRecommendActivity record);

    void insertSelective(PosterRecommendActivity record);

    PosterRecommendActivity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PosterRecommendActivity record);

    int updateByPrimaryKey(PosterRecommendActivity record);
}