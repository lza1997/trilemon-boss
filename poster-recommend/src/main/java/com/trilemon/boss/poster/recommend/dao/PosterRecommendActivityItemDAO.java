package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.PosterRecommendActivityItem;

import java.util.List;

public interface PosterRecommendActivityItemDAO {

    Long insertSelective(PosterRecommendActivityItem record);

    Integer countByUserIdAndActivityId(Long userId, Long activityId);

    Integer deleteByUserIdAndActivityId(Long userId, Long activityId);

    Integer deleteByUserIdAndActivityIdAndItemNumIid(Long userId, Long activityId, Long itemNumIid);

    List<PosterRecommendActivityItem> selectByUserIdAndActivityId(Long userId, Long activityId);

    List<PosterRecommendActivityItem> paginateByUserIdAndActivityId(Long userId, Long activityId, String orderBy,
                                                                    int offset, int limit);

    Integer batchInsert(List<PosterRecommendActivityItem> posterRecommendActivityItems);

    Integer batchDelete(List<PosterRecommendActivityItem> posterRecommendActivityItems);

    Integer batchUpdate(List<PosterRecommendActivityItem> posterRecommendActivityItems);
}