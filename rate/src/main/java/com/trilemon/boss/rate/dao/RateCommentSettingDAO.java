package com.trilemon.boss.rate.dao;

import com.trilemon.boss.rate.model.RateCommentSetting;

import java.util.List;

public interface RateCommentSettingDAO {
    int deleteByPrimaryKey(Long id);

    void insert(RateCommentSetting record);

    void insertSelective(RateCommentSetting record);

    RateCommentSetting selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RateCommentSetting record);

    int updateByPrimaryKey(RateCommentSetting record);

    List<String> selectContentByUserIdAndStatus(Long userId, List<Byte> of);

    RateCommentSetting selectByPrimaryKeyAndUserId(Long rateCommentSettingId, Long userId);
}