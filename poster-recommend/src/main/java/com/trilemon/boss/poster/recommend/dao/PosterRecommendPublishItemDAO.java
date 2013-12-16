package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.PosterRecommendPublishItem;
import com.trilemon.boss.poster.recommend.model.dto.PublishProgress;

import java.util.List;

public interface PosterRecommendPublishItemDAO {
    long insertSelective(PosterRecommendPublishItem record);

    int deleteByUserIdAndActivityIdAndItemNumIid(Long userId, Long activityId, Long itemNumIid);

    List<PosterRecommendPublishItem> selectByUserIdAndActivityId(Long userId, Long activityId);

    PosterRecommendPublishItem selectByUserIdAndActivityIdAndItemNumIid(Long userId, Long activityId, Long itemNumIid);

    int updateByUserIdAndActivityIdAndItemNumIid(PosterRecommendPublishItem publishItem);

    List<PosterRecommendPublishItem> paginateByUserIdAndActivityId(Long userId, Long activityId, String orderBy, int offset, int limit);

    PublishProgress groupStatus(Long userId, Long activityId);

    int countByUserIdAndActivityId(Long userId, Long activityId);
}