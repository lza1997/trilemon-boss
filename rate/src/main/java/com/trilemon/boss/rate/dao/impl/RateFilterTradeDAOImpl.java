package com.trilemon.boss.rate.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.google.common.base.Preconditions;
import com.trilemon.boss.rate.dao.RateFilterTradeDAO;
import com.trilemon.boss.rate.dao.router.RateFilterTradeRouter;
import com.trilemon.boss.rate.model.RateFilterTrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RateFilterTradeDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements RateFilterTradeDAO {
    @Autowired
    private RateFilterTradeRouter router;

    public int deleteByPrimaryKey(Long userId, Long id) {
        RateFilterTrade _key = new RateFilterTrade();
        _key.setId(id);
        _key.setUserId(userId);
        router.routeAndSetTableId(_key);

        int rows = getSqlMapClientTemplate().delete("rate_filter_trade.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(RateFilterTrade record) {
        Preconditions.checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        getSqlMapClientTemplate().insert("rate_filter_trade.insert", record);
    }

    public void insertSelective(RateFilterTrade record) {
        Preconditions.checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        getSqlMapClientTemplate().insert("rate_filter_trade.insertSelective", record);
    }

    public RateFilterTrade selectByPrimaryKey(Long userId,Long id) {
        RateFilterTrade _key = new RateFilterTrade();
        _key.setId(id);
        _key.setUserId(userId);
        router.routeAndSetTableId(_key);
        RateFilterTrade record = (RateFilterTrade) getSqlMapClientTemplate().queryForObject("rate_filter_trade.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(RateFilterTrade record) {
        Preconditions.checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        int rows = getSqlMapClientTemplate().update("rate_filter_trade.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RateFilterTrade record) {
        Preconditions.checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        int rows = getSqlMapClientTemplate().update("rate_filter_trade.updateByPrimaryKey", record);
        return rows;
    }
}