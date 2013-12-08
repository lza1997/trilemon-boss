package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.PosterRecommendPublishItem;
import com.trilemon.commons.web.Page;

import java.util.List;

public interface PosterRecommendPublishItemDAO {
    int deleteByPrimaryKey(Long id);

    void insert(PosterRecommendPublishItem record);

    void insertSelective(PosterRecommendPublishItem record);

    PosterRecommendPublishItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PosterRecommendPublishItem record);

    int updateByPrimaryKey(PosterRecommendPublishItem record);

    int deleteByUserIdAndActivityIdAndItemNumIid(Long userId, Long activityId, Long itemNumIid);

    Page<PosterRecommendPublishItem> paginateByUserIdAndActivityId(Long userId, Long activityId, int offset,
                                                                   int limit);

    int countByUserIdAndActivityIdAndStatus(Long userId, Long activityId, List<Byte> statusList);

    List<PosterRecommendPublishItem> selectByUserIdAndActivityId(Long userId, Long activityId);

    void updateByUserIdAndActivityIdAndItemNumIid(PosterRecommendPublishItem newPublishItem);

    PosterRecommendPublishItem selectByUserIdAndActivityIdAndItemNumIid(Long userId, Long activityId, Long publishItemNumIid);
}