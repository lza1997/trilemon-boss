package com.trilemon.boss.rate.sync.dao.impl;

import com.google.common.collect.ImmutableMap;
import com.trilemon.boss.rate.dao.BaseDAO;
import com.trilemon.boss.rate.model.dto.RateStatus;
import com.trilemon.boss.rate.sync.dao.SyncRateDAO;
import com.trilemon.boss.rate.sync.model.SyncRate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class SyncRateDAOImpl extends BaseDAO implements SyncRateDAO {

    public SyncRateDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Long userId) {
        SyncRate _key = new SyncRate();
        _key.setUserId(userId);
        int rows = getSqlMapClientTemplate().delete("sync_rate.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(SyncRate record) {
        getSqlMapClientTemplate().insert("sync_rate.insert", record);
    }

    public void insertSelective(SyncRate record) {
        getSqlMapClientTemplate().insert("sync_rate.insertSelective", record);
    }

    public SyncRate selectByPrimaryKey(Long userId) {
        SyncRate _key = new SyncRate();
        _key.setUserId(userId);
        SyncRate record = (SyncRate) getSqlMapClientTemplate().queryForObject("sync_rate.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(SyncRate record) {
        int rows = getSqlMapClientTemplate().update("sync_rate.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(SyncRate record) {
        int rows = getSqlMapClientTemplate().update("sync_rate.updateByPrimaryKey", record);
        return rows;
    }

    @Override
    public int batchInsertSelective(List<SyncRate> syncRates) {
        return batchInsert("sync_rate.insertSelective", syncRates);
    }


    @Override
    public RateStatus calcSellerDayRate(Long userId, Date startDate, Date endDate) {
        Map<String, ?> paramMap = ImmutableMap.of("userId", userId, "startDate", startDate, "endDate", endDate);
        return (RateStatus) getSqlMapClientTemplate().queryForObject("sync_rate.calcSellerDayRate", paramMap);
    }


    @Override
    public RateStatus calcBuyerRateStatus(Long userId, String buyerNick) {
        Map<String, ?> paramMap = ImmutableMap.of("userId", userId, "buyerNick", buyerNick);
        SyncRate record = (SyncRate) getSqlMapClientTemplate().queryForObject("sync_rate.calcBuyerRateStatus", paramMap);
        return null;
    }
}