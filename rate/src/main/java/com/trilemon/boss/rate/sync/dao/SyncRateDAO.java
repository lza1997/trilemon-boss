package com.trilemon.boss.rate.sync.dao;

import com.trilemon.boss.rate.sync.model.CalcMemberDayRate;
import com.trilemon.boss.rate.sync.model.CalcSellerDayRate;
import com.trilemon.boss.rate.sync.model.SyncRate;

import java.util.List;

public interface SyncRateDAO {
    int deleteByPrimaryKey(Long userId);

    void insert(SyncRate record);

    void insertSelective(SyncRate record);

    SyncRate selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(SyncRate record);

    int updateByPrimaryKey(SyncRate record);

    int batchInsertSelective(List<SyncRate> records);

    CalcSellerDayRate calcSellerDayRate(Long userId);

    CalcMemberDayRate calcMemberDayRate(String buyerNick);
}