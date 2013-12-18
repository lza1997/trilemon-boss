package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.PosterRecommendActivity;

import java.util.Date;
import java.util.List;

public interface PosterRecommendActivityDAO {

    Long insertSelective(PosterRecommendActivity record);

    PosterRecommendActivity selectByUserIdAndActivityId(Long userId, Long activityId);

    Integer updateByUserIdAndActivityIdSelective(PosterRecommendActivity activity);

    Integer deleteByUserIdAndActivityId(Long userId, Long activityId);

    PosterRecommendActivity selectLastCreatedActivity(Long userId);

    List<PosterRecommendActivity> paginateActivityByUserId(Long userId, List<Byte> statusList, Date publishTime,
                                                           String orderBy, int offset, int limit);

    Integer countActivityByUserId(Long userId, List<Byte> statusList, Date publishTime);

}