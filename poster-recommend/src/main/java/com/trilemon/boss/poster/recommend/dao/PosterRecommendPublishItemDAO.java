package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.PosterRecommendPublishItem;
import com.trilemon.boss.poster.recommend.model.dto.PublishProgress;

import java.util.List;

public interface PosterRecommendPublishItemDAO {
    Long insertSelective(PosterRecommendPublishItem record);

    Integer deleteByUserIdAndActivityIdAndItemNumIid(Long userId, Long activityId, Long itemNumIid);

    List<PosterRecommendPublishItem> selectByUserIdAndActivityId(Long userId, Long activityId);

    PosterRecommendPublishItem selectByUserIdAndActivityIdAndItemNumIid(Long userId, Long activityId, Long itemNumIid);

    Integer updateByUserIdAndActivityIdAndItemNumIid(PosterRecommendPublishItem publishItem);

    List<PosterRecommendPublishItem> paginateByUserIdAndActivityId(Long userId, Long activityId, String orderBy, int offset, int limit);

    PublishProgress groupStatus(Long userId, Long activityId);

    Integer countByUserIdAndActivityId(Long userId, Long activityId);

    Integer deleteByUserIdAndActivityId(Long userId, Long activityId);

    Integer batchInsert(List<PosterRecommendPublishItem> publishItems);

    Integer batchDelete(List<PosterRecommendPublishItem> publishItems);

    Integer batchUpdate(List<PosterRecommendPublishItem> publishItems);

    PosterRecommendPublishItem selectByUserIdAndActivityIdAndItemNumIidAndStatus(Long userId,
                                                                                 Long activityId,
                                                                                 Long itemNumIid,
                                                                                 List<Byte> statusList);
}