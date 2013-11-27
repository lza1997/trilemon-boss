package com.trilemon.boss.infra.sync.rate.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.google.common.collect.ImmutableMap;
import com.trilemon.boss.infra.sync.rate.dao.SyncStatusDAO;
import com.trilemon.boss.infra.sync.rate.model.SyncStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SyncStatusDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements SyncStatusDAO {
    public int deleteByPrimaryKey(Integer id) {
        SyncStatus _key = new SyncStatus();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("sync_status.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(SyncStatus record) {
        getSqlMapClientTemplate().insert("sync_status.insert", record);
    }

    public void insertSelective(SyncStatus record) {
        getSqlMapClientTemplate().insert("sync_status.insertSelective", record);
    }

    public SyncStatus selectByPrimaryKey(Integer id) {
        SyncStatus _key = new SyncStatus();
        _key.setId(id);
        SyncStatus record = (SyncStatus) getSqlMapClientTemplate().queryForObject("sync_status.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(SyncStatus record) {
        int rows = getSqlMapClientTemplate().update("sync_status.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(SyncStatus record) {
        int rows = getSqlMapClientTemplate().update("sync_status.updateByPrimaryKey", record);
        return rows;
    }

    @Override
    public List<Long> paginateUserIdByCalcSellerDayRateStatus(long hitUserId, int pageSize, List<Byte> statusList) {
        Map<String, Object> paramMap = ImmutableMap.of("hitUserId", hitUserId, "pageSize", pageSize, "statusList", statusList);
        return getSqlMapClientTemplate().queryForList("sync_status.paginateUserIdByCalcSellerDayRateStatus", paramMap);
    }

    @Override
    public List<Long> paginateUserIdByRateSyncStatus(long hitUserId, int pageSize, List<Byte> statusList) {

        Map<String, Object> paramMap = ImmutableMap.of("hitUserId", hitUserId, "pageSize", pageSize, "statusList", statusList);
        return getSqlMapClientTemplate().queryForList("sync_status.paginateUserIdByRateSyncStatus", paramMap);
    }

    @Override
    public int deleteByRateSyncOwnerAndStatus(String owner, List<Byte> statusList) {
        Map<String, Object> paramMap = ImmutableMap.of("owner", owner, "statusList", statusList);
        int rows = getSqlMapClientTemplate().delete("sync_status.deleteByRateSyncOwnerAndStatus", paramMap);
        return rows;
    }

    @Override
    public SyncStatus selectByUserId(Long userId) {
        SyncStatus _key = new SyncStatus();
        _key.setUserId(userId);
        SyncStatus record = (SyncStatus) getSqlMapClientTemplate().queryForObject("sync_status.selectByUserId", _key);
        return record;
    }

    @Override
    public int updateByUserIdSelective(SyncStatus syncStatus) {
        int rows = getSqlMapClientTemplate().update("sync_status.updateByUserIdSelective", syncStatus);
        return rows;
    }
}