package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.PosterRecommendUser;

public interface PosterRecommendUserDAO {
    int deleteByPrimaryKey(Long id);

    void insert(PosterRecommendUser record);

    void insertSelective(PosterRecommendUser record);

    PosterRecommendUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PosterRecommendUser record);

    int updateByPrimaryKey(PosterRecommendUser record);
}