package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.PosterRecommendUser;

public interface PosterRecommendUserDAO {

    long insertSelective(PosterRecommendUser record);

    int updateByUserIdSelective(Long userId);

    PosterRecommendUser selectByUserId(Long userId);

}