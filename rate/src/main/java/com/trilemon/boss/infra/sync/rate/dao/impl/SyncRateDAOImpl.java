package com.trilemon.boss.infra.sync.rate.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.google.common.base.Preconditions;
import com.trilemon.boss.infra.sync.rate.client.RatePageRequest;
import com.trilemon.boss.infra.sync.rate.dao.SyncRateDAO;
import com.trilemon.boss.infra.sync.rate.dao.router.SyncRateRouter;
import com.trilemon.boss.infra.sync.rate.model.SyncRate;
import com.trilemon.boss.rate.model.dto.RateStatus;
import com.trilemon.commons.db.ShardTableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class SyncRateDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements SyncRateDAO {

    @Autowired
    private SyncRateRouter router;

    public int deleteByPrimaryKey(Long userId) {
        SyncRate _key = new SyncRate();
        _key.setUserId(userId);
        router.routeAndSetTableId(_key);
        int rows = getSqlMapClientTemplate().delete("sync_rate.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(SyncRate record) {
        Preconditions.checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        getSqlMapClientTemplate().insert("sync_rate.insert", record);
    }

    public void insertSelective(SyncRate record) {
        Preconditions.checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        getSqlMapClientTemplate().insert("sync_rate.insertSelective", record);
    }

    public SyncRate selectByPrimaryKey(Long userId) {
        SyncRate _key = new SyncRate();
        _key.setUserId(userId);
        router.routeAndSetTableId(_key);

        SyncRate record = (SyncRate) getSqlMapClientTemplate().queryForObject("sync_rate.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(SyncRate record) {
        Preconditions.checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        int rows = getSqlMapClientTemplate().update("sync_rate.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(SyncRate record) {
        Preconditions.checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        int rows = getSqlMapClientTemplate().update("sync_rate.updateByPrimaryKey", record);
        return rows;
    }

    @Override
    public int batchInsertSelective(List<SyncRate> syncRates) {
        for (SyncRate syncRate : syncRates) {
            Preconditions.checkNotNull(syncRate.getUserId());
            router.routeAndSetTableId(syncRate);
        }

        return batchInsert("sync_rate.replaceSelective", syncRates);
    }

    @Override
    public RateStatus calcSellerDayRate(Long userId, Date startDate, Date endDate) {
        Preconditions.checkNotNull(userId);
        SyncRate syncRate = new SyncRate();
        syncRate.setUserId(userId);
        ShardTableMap shardTableMap = router.getRouteMap(syncRate);
        shardTableMap.put("userId", userId);
        shardTableMap.put("startDate", startDate);
        shardTableMap.put("endDate", endDate);
        return (RateStatus) getSqlMapClientTemplate().queryForObject("sync_rate.calcSellerDayRate", shardTableMap);
    }

    @Override
    public RateStatus calcBuyerRateStatus(Long userId, String buyerNick) {
        SyncRate syncRate = new SyncRate();
        syncRate.setUserId(userId);
        ShardTableMap shardTableMap = router.getRouteMap(syncRate);
        shardTableMap.put("userId", userId);
        shardTableMap.put("buyerNick", buyerNick);

        return (RateStatus) getSqlMapClientTemplate().queryForObject("sync_rate.calcBuyerRateStatus", shardTableMap);
    }

    @Override
    public int countByRatePageRequestWithUserId(RatePageRequest request) {
        Preconditions.checkNotNull(request.getUserId(), "userId is null.");

        SyncRate syncRate = new SyncRate();
        syncRate.setUserId(request.getUserId());
        ShardTableMap shardTableMap = router.getRouteMap(syncRate);
        shardTableMap.put("request", request);
        return (int) getSqlMapClientTemplate().queryForObject("sync_rate.countByRatePageRequestWithUserId", shardTableMap);
    }

    @Override
    public List<SyncRate> selectByRatePageRequestWithUserId(RatePageRequest request) {
        Preconditions.checkNotNull(request.getUserId(), "userId is null.");

        SyncRate syncRate = new SyncRate();
        syncRate.setUserId(request.getUserId());
        ShardTableMap shardTableMap = router.getRouteMap(syncRate);
        shardTableMap.put("request", request);
        return getSqlMapClientTemplate().queryForList("sync_rate.selectByRatePageRequestWithUserId",
                shardTableMap);
    }
}