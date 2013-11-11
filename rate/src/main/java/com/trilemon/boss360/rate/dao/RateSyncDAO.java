package com.trilemon.boss360.rate.dao;

import com.trilemon.boss360.rate.model.RateSync;
import com.trilemon.boss360.rate.model.RateSyncExample;
import com.trilemon.boss360.rate.model.dto.RateSyncStatus;

import java.util.List;

public interface RateSyncDAO {
    int countByExample(RateSyncExample example);

    int deleteByExample(RateSyncExample example);

    int deleteByPrimaryKey(Long userId);

    void insert(RateSync record);

    void insertSelective(RateSync record);

    List<RateSync> selectByExample(RateSyncExample example);

    RateSync selectByPrimaryKey(Long userId);

    int updateByExampleSelective(RateSync record, RateSyncExample example);

    int updateByExample(RateSync record, RateSyncExample example);

    int updateByPrimaryKeySelective(RateSync record);

    int updateByPrimaryKey(RateSync record);

    RateSyncStatus selectRateSyncStatusByUserIdAndBuyerNick(Long userId, String buyerNick);
}