package com.trilemon.boss.rate.dao;

import com.google.common.collect.ImmutableList;
import com.trilemon.boss.rate.model.RateCommentSetting;
import com.trilemon.boss.rate.model.RateCommentSettingExample;
import java.util.List;

public interface RateCommentSettingDAO {
    int countByExample(RateCommentSettingExample example);

    int deleteByExample(RateCommentSettingExample example);

    int deleteByPrimaryKey(Long id);

    void insert(RateCommentSetting record);

    void insertSelective(RateCommentSetting record);

    List<RateCommentSetting> selectByExample(RateCommentSettingExample example);

    RateCommentSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(RateCommentSetting record, RateCommentSettingExample example);

    int updateByExample(RateCommentSetting record, RateCommentSettingExample example);

    int updateByPrimaryKeySelective(RateCommentSetting record);

    int updateByPrimaryKey(RateCommentSetting record);

    List<String> selectContentByUserIdAndStatus(Long userId, ImmutableList<Byte> statusList);
}