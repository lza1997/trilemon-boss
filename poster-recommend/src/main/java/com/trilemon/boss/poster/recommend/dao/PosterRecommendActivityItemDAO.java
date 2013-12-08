package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.PosterRecommendActivityItem;
import com.trilemon.commons.web.Page;

public interface PosterRecommendActivityItemDAO {
    int deleteByPrimaryKey(Long id);

    void insert(PosterRecommendActivityItem record);

    void insertSelective(PosterRecommendActivityItem record);

    PosterRecommendActivityItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PosterRecommendActivityItem record);

    int updateByPrimaryKey(PosterRecommendActivityItem record);

    int deleteByUserIdAndActivityIdAndItemNumIid(Long userId, Long activityId, Long itemNumIid);

    Page<PosterRecommendActivityItem> paginateByUserIdAndActivityId(Long userId, Long activityId, int offset, int limit);
}