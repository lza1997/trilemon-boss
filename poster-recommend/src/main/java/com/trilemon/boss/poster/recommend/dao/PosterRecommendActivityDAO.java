package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.PosterRecommendActivity;

public interface PosterRecommendActivityDAO {
    long insertSelective(Long userId, PosterRecommendActivity record);

    int updateByPrimaryKeySelective(Long userId, PosterRecommendActivity record);

    int updateByPrimaryKey(Long userId, PosterRecommendActivity record);

    PosterRecommendActivity selectByUserIdAndActivityId(Long userId, Long activityId);

    int updateByUserIdAndActivityId(PosterRecommendActivity record);

    int deleteByUserIdAndActivityId(Long userId, Long activityId);

    PosterRecommendActivity selectLastCreatedActivity(Long userId);
}