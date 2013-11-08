package com.trilemon.boss360.rate.dao;

import com.trilemon.boss360.rate.model.RateTrade;
import com.trilemon.boss360.rate.model.RateTradeExample;
import java.util.List;

public interface RateTradeDAO {
    int countByExample(RateTradeExample example);

    int deleteByExample(RateTradeExample example);

    int deleteByPrimaryKey(Long id);

    void insert(RateTrade record);

    void insertSelective(RateTrade record);

    List<RateTrade> selectByExample(RateTradeExample example);

    RateTrade selectByPrimaryKey(Long id);

    int updateByExampleSelective(RateTrade record, RateTradeExample example);

    int updateByExample(RateTrade record, RateTradeExample example);

    int updateByPrimaryKeySelective(RateTrade record);

    int updateByPrimaryKey(RateTrade record);
}