package com.trilemon.boss.rate.sync.dao;

import com.trilemon.boss.rate.sync.model.CalcMemberDayRate;

public interface CalcMemberDayRateDAO {
    int deleteByPrimaryKey(Long id);

    void insert(CalcMemberDayRate record);

    void insertSelective(CalcMemberDayRate record);

    CalcMemberDayRate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CalcMemberDayRate record);

    int updateByPrimaryKey(CalcMemberDayRate record);
}