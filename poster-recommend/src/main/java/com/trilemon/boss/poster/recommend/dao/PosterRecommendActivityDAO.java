package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.PosterRecommendActivity;

import java.util.List;

public interface PosterRecommendActivityDAO {

    long insertSelective(PosterRecommendActivity record);

    PosterRecommendActivity selectByUserIdAndActivityId(Long userId, Long activityId);

    int updateByUserIdAndActivityIdSelective(PosterRecommendActivity activity);

    int deleteByUserIdAndActivityId(Long userId, Long activityId);

    PosterRecommendActivity selectLastCreatedActivity(Long userId);

    List<PosterRecommendActivity> paginateActivityAndStatus(Long userId, List<Byte> statusList, int offset, int limit);

    int countActivityByUserIdAndStatus(Long userId, List<Byte> statusList);
}