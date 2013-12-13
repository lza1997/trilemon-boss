package com.trilemon.boss.infra.sync.rate.dao;

import com.trilemon.boss.infra.sync.rate.model.CalcSellerDayRate;

import java.util.Date;

public interface CalcSellerDayRateDAO {
    int deleteByPrimaryKey(Long userId,Long id);

    void insert(CalcSellerDayRate record);

    void insertSelective(CalcSellerDayRate record);

    CalcSellerDayRate selectByPrimaryKey(Long userId,Long id);

    int updateByPrimaryKeySelective(CalcSellerDayRate record);

    int updateByPrimaryKey(CalcSellerDayRate record);

    void replaceSelective(CalcSellerDayRate calcSellerDayRate);

    CalcSellerDayRate selectByUserIdAndRateTime(Long userId, Date rateTime);
}