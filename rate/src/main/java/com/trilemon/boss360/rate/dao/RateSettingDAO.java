package com.trilemon.boss360.rate.dao;

import com.trilemon.boss360.rate.model.RateSetting;
import com.trilemon.boss360.rate.model.RateSettingExample;
import java.util.List;

public interface RateSettingDAO {
    int countByExample(RateSettingExample example);

    int deleteByExample(RateSettingExample example);

    int deleteByPrimaryKey(Long id);

    void insert(RateSetting record);

    void insertSelective(RateSetting record);

    List<RateSetting> selectByExample(RateSettingExample example);

    RateSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(RateSetting record, RateSettingExample example);

    int updateByExample(RateSetting record, RateSettingExample example);

    int updateByPrimaryKeySelective(RateSetting record);

    int updateByPrimaryKey(RateSetting record);
}