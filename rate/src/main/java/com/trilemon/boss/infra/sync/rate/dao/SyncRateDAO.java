package com.trilemon.boss.infra.sync.rate.dao;

import com.trilemon.boss.rate.model.dto.RateStatus;
import com.trilemon.boss.infra.sync.rate.model.SyncRate;

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