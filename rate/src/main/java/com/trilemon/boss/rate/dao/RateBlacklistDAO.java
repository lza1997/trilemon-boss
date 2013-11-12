package com.trilemon.boss.rate.dao;

import com.trilemon.boss.rate.model.RateBlacklist;
import com.trilemon.boss.rate.model.RateBlacklistExample;
import java.util.List;

public interface RateBlacklistDAO {
    int countByExample(RateBlacklistExample example);

    int deleteByExample(RateBlacklistExample example);

    int deleteByPrimaryKey(Long id);

    void insert(RateBlacklist record);

    void insertSelective(RateBlacklist record);

    List<RateBlacklist> selectByExample(RateBlacklistExample example);

    RateBlacklist selectByPrimaryKey(Long id);

    int updateByExampleSelective(RateBlacklist record, RateBlacklistExample example);

    int updateByExample(RateBlacklist record, RateBlacklistExample example);

    int updateByPrimaryKeySelective(RateBlacklist record);

    int updateByPrimaryKey(RateBlacklist record);
}