package com.trilemon.boss.rate.sync.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.alibaba.cobarclient.route.ShardTableRouter;
import com.trilemon.boss.rate.sync.dao.SyncRateDAO;
import com.trilemon.boss.rate.sync.model.SyncRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SyncRateDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements SyncRateDAO {

    @Autowired
    private ShardTableRouter<SyncRate> syncRateRouter;

    public SyncRateDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Long userId) {
        SyncRate _key = new SyncRate();
        _key.setUserId(userId);
        syncRateRouter.routeAndSetTableId(_key);
        int rows = getSqlMapClientTemplate().delete("sync_rate.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(SyncRate record) {
        syncRateRouter.routeAndSetTableId(record);
        getSqlMapClientTemplate().insert("sync_rate.insert", record);
    }

    public void insertSelective(SyncRate record) {
        syncRateRouter.routeAndSetTableId(record);
        getSqlMapClientTemplate().insert("sync_rate.insertSelective", record);
    }

    public int batchInsertSelective(List<SyncRate> records) {
        for (SyncRate record : records) {
            syncRateRouter.routeAndSetTableId(record);
        }
        return batchInsert("sync_rate.insertSelective", records);
    }

    public SyncRate selectByPrimaryKey(Long userId) {
        SyncRate _key = new SyncRate();
        _key.setUserId(userId);
        syncRateRouter.routeAndSetTableId(_key);
        SyncRate record = (SyncRate) getSqlMapClientTemplate().queryForObject("sync_rate.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(SyncRate record) {
        syncRateRouter.routeAndSetTableId(record);
        int rows = getSqlMapClientTemplate().update("sync_rate.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(SyncRate record) {
        syncRateRouter.routeAndSetTableId(record);
        int rows = getSqlMapClientTemplate().update("sync_rate.updateByPrimaryKey", record);
        return rows;
    }
}