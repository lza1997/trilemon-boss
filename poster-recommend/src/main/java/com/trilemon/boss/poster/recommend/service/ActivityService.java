package com.trilemon.boss.poster.recommend.service;

import com.trilemon.boss.poster.publish.model.dto.PublishProgress;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivity;

/**
 * @author kevin
 */
public class ActivityService {
    /**
     * 创建活动
     *
     * @param userId
     * @param activity
     */
    public void createActivity(Long userId, PosterRecommendActivity activity) {

    }

    /**
     * 更新活动
     *
     * @param userId
     * @param activity
     */
    public void updateActivity(Long userId, PosterRecommendActivity activity) {

    }

    /**
     * 删除活动
     *
     * @param userId
     * @param activityId
     */
    public void deleteActivity(Long userId, Long activityId) {

    }

    /**
     * 添加宝贝到活动
     *
     * @param userId
     * @param activityId
     */
    public void addItem(Long userId, Long activityId, Long itemNumIid) {

    }

    /**
     * 移除宝贝到活动
     *
     * @param userId
     * @param activityId
     */
    public void removeItem(Long userId, Long activityId, Long itemNumIid) {

    }

    /**
     * 投放活动
     *
     * @param userId
     * @param activityId
     */
    public void publishActivity(Long userId, Long activityId) {

    }

    /**
     * 查询投放进度
     *
     * @param userId
     * @param activityId
     */
    public PublishProgress queryPublishProgress(Long userId, Long activityId) {
        return null;
    }
}
