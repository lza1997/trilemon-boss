package com.trilemon.boss.rate.dao;

import com.trilemon.boss.rate.model.RateSetting;

import java.util.List;

public interface RateSettingDAO {
    int deleteByPrimaryKey(Long id);

    void insert(RateSetting record);

    void insertSelective(RateSetting record);

    RateSetting selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RateSetting record);

    int updateByPrimaryKey(RateSetting record);

    int updateByUserId(RateSetting rateSetting);

    RateSetting selectByUserId(Long userId);

    List<Long> paginateUserIdByStatus(Integer offset, Integer limit, List<Byte> statusList);
}