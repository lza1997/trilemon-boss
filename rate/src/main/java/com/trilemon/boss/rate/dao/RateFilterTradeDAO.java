package com.trilemon.boss.rate.dao;

import com.trilemon.boss.rate.model.RateFilterTrade;
import com.trilemon.boss.rate.model.RateFilterTradeExample;
import java.util.List;

public interface RateFilterTradeDAO {
    int countByExample(RateFilterTradeExample example);

    int deleteByExample(RateFilterTradeExample example);

    int deleteByPrimaryKey(Long id);

    void insert(RateFilterTrade record);

    void insertSelective(RateFilterTrade record);

    List<RateFilterTrade> selectByExample(RateFilterTradeExample example);

    RateFilterTrade selectByPrimaryKey(Long id);

    int updateByExampleSelective(RateFilterTrade record, RateFilterTradeExample example);

    int updateByExample(RateFilterTrade record, RateFilterTradeExample example);

    int updateByPrimaryKeySelective(RateFilterTrade record);

    int updateByPrimaryKey(RateFilterTrade record);
}