package com.trilemon.boss360.rate.dao;

import com.trilemon.boss360.rate.model.RateCanNotRateTrade;
import com.trilemon.boss360.rate.model.RateCanNotRateTradeExample;
import java.util.List;

public interface RateCanNotRateTradeDAO {
    int countByExample(RateCanNotRateTradeExample example);

    int deleteByExample(RateCanNotRateTradeExample example);

    int deleteByPrimaryKey(Long id);

    void insert(RateCanNotRateTrade record);

    void insertSelective(RateCanNotRateTrade record);

    List<RateCanNotRateTrade> selectByExample(RateCanNotRateTradeExample example);

    RateCanNotRateTrade selectByPrimaryKey(Long id);

    int updateByExampleSelective(RateCanNotRateTrade record, RateCanNotRateTradeExample example);

    int updateByExample(RateCanNotRateTrade record, RateCanNotRateTradeExample example);

    int updateByPrimaryKeySelective(RateCanNotRateTrade record);

    int updateByPrimaryKey(RateCanNotRateTrade record);
}