package com.trilemon.boss.rate.sync.dao;

import com.trilemon.boss.rate.model.dto.RateStatus;
import com.trilemon.boss.rate.sync.model.SyncRate;

import java.util.Date;
import java.util.List;

public interface SyncRateDAO {
    int deleteByPrimaryKey(Long userId);

    void insert(SyncRate record);

    void insertSelective(SyncRate record);

    SyncRate selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(SyncRate record);

    int updateByPrimaryKey(SyncRate record);

    RateStatus calcSellerDayRate(Long userId, Date startDate, Date endDate);

    int batchInsertSelective(List<SyncRate> syncRates);

    RateStatus calcBuyerRateStatus(Long userId, String buyerNick);
}