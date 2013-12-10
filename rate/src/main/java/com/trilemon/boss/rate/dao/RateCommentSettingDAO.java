package com.trilemon.boss.rate.dao;

import com.google.common.collect.ImmutableList;
import com.trilemon.boss.rate.model.RateCommentSetting;

import java.util.List;

public interface RateCommentSettingDAO {
    int deleteByPrimaryKey(Long id);

    void insert(RateCommentSetting record);

    void insertSelective(RateCommentSetting record);

    RateCommentSetting selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RateCommentSetting record);

    int updateByPrimaryKey(RateCommentSetting record);

    List<String> selectContentByUserIdAndStatus(Long userId, List<Byte> status);

    RateCommentSetting selectByPrimaryKeyAndUserId(Long rateCommentSettingId, Long userId);

    List<RateCommentSetting> selectByUserIdAndStatus(Long userId, ImmutableList<Byte> status);
}