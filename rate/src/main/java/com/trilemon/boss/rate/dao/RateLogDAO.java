package com.trilemon.boss.rate.dao;

import com.trilemon.boss.rate.model.RateLog;

public interface RateLogDAO {
    int deleteByPrimaryKey(Long userId,Long id);

    void insert(RateLog record);

    void insertSelective(RateLog record);

    RateLog selectByPrimaryKey(Long userId,Long id);

    int updateByPrimaryKeySelective(RateLog record);

    int updateByPrimaryKey(RateLog record);
}