package com.trilemon.boss.rate.dao;

import com.trilemon.boss.rate.model.RateFilterTrade;

public interface RateFilterTradeDAO {
    int deleteByPrimaryKey(Long userId,Long id);

    void insert(RateFilterTrade record);

    void insertSelective(RateFilterTrade record);

    RateFilterTrade selectByPrimaryKey(Long userId,Long id);

    int updateByPrimaryKeySelective(RateFilterTrade record);

    int updateByPrimaryKey(RateFilterTrade record);
}