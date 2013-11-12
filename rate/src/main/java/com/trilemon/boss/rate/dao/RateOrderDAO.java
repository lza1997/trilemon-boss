package com.trilemon.boss.rate.dao;

import com.trilemon.boss.rate.model.RateOrder;
import com.trilemon.boss.rate.model.RateOrderExample;
import java.util.List;

public interface RateOrderDAO {
    int countByExample(RateOrderExample example);

    int deleteByExample(RateOrderExample example);

    int deleteByPrimaryKey(Long id);

    void insert(RateOrder record);

    void insertSelective(RateOrder record);

    List<RateOrder> selectByExample(RateOrderExample example);

    RateOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(RateOrder record, RateOrderExample example);

    int updateByExample(RateOrder record, RateOrderExample example);

    int updateByPrimaryKeySelective(RateOrder record);

    int updateByPrimaryKey(RateOrder record);
}