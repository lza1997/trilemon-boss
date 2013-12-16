package com.trilemon.boss.rate.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.trilemon.boss.rate.dao.RateLogDAO;
import com.trilemon.boss.rate.dao.router.RateLogRouter;
import com.trilemon.boss.rate.model.RateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.google.common.base.Preconditions.checkNotNull;

@Repository
public class RateLogDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements RateLogDAO {
    @Autowired
    private RateLogRouter router;

    public RateLogDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Long userId, Long id) {
        RateLog _key = new RateLog();
        _key.setId(id);
        _key.setUserId(userId);
        router.routeAndSetTableId(_key);
        return getSqlMapClientTemplate().delete("rate_log.deleteByPrimaryKey", _key);
    }

    public void insert(RateLog record) {
        checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        getSqlMapClientTemplate().insert("rate_log.insert", record);
    }

    public void insertSelective(RateLog record) {
        checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        getSqlMapClientTemplate().insert("rate_log.insertSelective", record);
    }

    public RateLog selectByPrimaryKey(Long userId, Long id) {
        RateLog _key = new RateLog();
        _key.setId(id);
        _key.setUserId(userId);
        router.routeAndSetTableId(_key);
        return (RateLog) getSqlMapClientTemplate().queryForObject("rate_log.selectByPrimaryKey", _key);
    }

    public int updateByPrimaryKeySelective(RateLog record) {
        checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        return getSqlMapClientTemplate().update("rate_log.updateByPrimaryKeySelective", record);
    }

    public int updateByPrimaryKey(RateLog record) {
        checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        return getSqlMapClientTemplate().update("rate_log.updateByPrimaryKey", record);
    }
}