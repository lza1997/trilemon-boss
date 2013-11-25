package com.trilemon.boss.rate.sync.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.google.common.collect.ImmutableList;
import com.trilemon.boss.rate.sync.dao.SyncStatusDAO;
import com.trilemon.boss.rate.sync.model.SyncStatus;

import java.util.List;

public class SyncStatusDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements SyncStatusDAO {

    public SyncStatusDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Integer id) {
        SyncStatus _key = new SyncStatus();
        _key.setId(id);
        return getSqlMapClientTemplate().delete("sync_status.deleteByPrimaryKey", _key);
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
        return (SyncStatus) getSqlMapClientTemplate().queryForObject("sync_status.selectByPrimaryKey", _key);
    }

    public int updateByPrimaryKeySelective(SyncStatus record) {
        return getSqlMapClientTemplate().update("sync_status.updateByPrimaryKeySelective", record);
    }

    public int updateByPrimaryKey(SyncStatus record) {
        return getSqlMapClientTemplate().update("sync_status.updateByPrimaryKey", record);
    }

    public SyncStatus selectByUserId(Long userId) {
        SyncStatus _key = new SyncStatus();
        _key.setUserId(userId);
        return (SyncStatus) getSqlMapClientTemplate().queryForObject("sync_status.selectByUserId",
                _key);
    }

    public int deleteByRateSyncOwnerAndStatus(String owner, ImmutableList<Byte> statusList) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Long> paginateUserIdByStatus(long hitUserId, int i, ImmutableList<Byte> statusList) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}