package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.PosterRecommendActivity;

import java.util.Date;
import java.util.List;

public interface PosterRecommendActivityDAO {

    long insertSelective(PosterRecommendActivity record);

    PosterRecommendActivity selectByUserIdAndActivityId(Long userId, Long activityId);

    int updateByUserIdAndActivityIdSelective(PosterRecommendActivity activity);

    int deleteByUserIdAndActivityId(Long userId, Long activityId);

    PosterRecommendActivity selectLastCreatedActivity(Long userId);

    List<PosterRecommendActivity> paginateActivityByUserId(Long userId, List<Byte> statusList, Date publishTime,
                                                           String orderBy, int offset, int limit);

    int countActivityByUserId(Long userId, List<Byte> statusList, Date publishTime);

}