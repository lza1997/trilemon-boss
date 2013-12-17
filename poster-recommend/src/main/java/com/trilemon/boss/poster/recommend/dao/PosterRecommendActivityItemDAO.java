package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.PosterRecommendActivityItem;

import java.util.List;

public interface PosterRecommendActivityItemDAO {

    long insertSelective(PosterRecommendActivityItem record);

    int countByUserIdAndActivityId(Long userId, Long activityId);

    int deleteByUserIdAndActivityId(Long userId, Long activityId);

    int deleteByUserIdAndActivityIdAndItemNumIid(Long userId, Long activityId, Long itemNumIid);

    List<PosterRecommendActivityItem> selectByUserIdAndActivityId(Long userId, Long activityId);

    List<PosterRecommendActivityItem> paginateByUserIdAndActivityId(Long userId, Long activityId, String orderBy,
                                                                    int offset, int limit);

    int batchInsert(List<PosterRecommendActivityItem> posterRecommendActivityItems);

    int batchDelete(Long userId, Long activityId, List<Long> itemNumIids);
}