package com.trilemon.boss.rate.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.google.common.base.Preconditions;
import com.trilemon.boss.rate.dao.RateOrderDAO;
import com.trilemon.boss.rate.dao.router.RateOrderRouter;
import com.trilemon.boss.rate.model.RateOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RateOrderDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements RateOrderDAO {
    @Autowired
    private RateOrderRouter router;

    public int deleteByPrimaryKey(Long userId, Long id) {
        RateOrder _key = new RateOrder();
        _key.setId(id);
        _key.setUserId(userId);
        router.routeAndSetTableId(_key);
        int rows = getSqlMapClientTemplate().delete("rate_order.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(RateOrder record) {
        Preconditions.checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        getSqlMapClientTemplate().insert("rate_order.insert", record);
    }

    public void insertSelective(RateOrder record) {
        Preconditions.checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        getSqlMapClientTemplate().insert("rate_order.insertSelective", record);
    }

    public RateOrder selectByPrimaryKey(Long userId, Long id) {
        RateOrder _key = new RateOrder();
        _key.setId(id);
        _key.setUserId(userId);
        router.routeAndSetTableId(_key);
        RateOrder record = (RateOrder) getSqlMapClientTemplate().queryForObject("rate_order.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(RateOrder record) {
        Preconditions.checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        int rows = getSqlMapClientTemplate().update("rate_order.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RateOrder record) {
        Preconditions.checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        int rows = getSqlMapClientTemplate().update("rate_order.updateByPrimaryKey", record);
        return rows;
    }

    @Override
    public int batchInsertSelective(List<RateOrder> rateOrders) {
        for (RateOrder rateOrder : rateOrders) {
            Preconditions.checkNotNull(rateOrder.getUserId());
            router.routeAndSetTableId(rateOrder);
        }
        return batchInsert("rate_order.insertSelective", rateOrders);
    }
}