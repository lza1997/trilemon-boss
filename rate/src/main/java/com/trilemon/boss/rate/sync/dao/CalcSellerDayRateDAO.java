package com.trilemon.boss.rate.sync.dao;

import com.trilemon.boss.rate.sync.model.CalcSellerDayRate;

public interface CalcSellerDayRateDAO {
    int deleteByPrimaryKey(Long id);

    void insert(CalcSellerDayRate record);

    void insertSelective(CalcSellerDayRate record);

    CalcSellerDayRate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CalcSellerDayRate record);

    int updateByPrimaryKey(CalcSellerDayRate record);
}