package com.trilemon.boss.rate.dao.impl;

import com.trilemon.boss.rate.dao.BaseDAO;
import com.trilemon.boss.rate.dao.RateOrderDAO;
import com.trilemon.boss.rate.model.RateOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RateOrderDAOImpl extends BaseDAO implements RateOrderDAO {

    public RateOrderDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Long id) {
        RateOrder _key = new RateOrder();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("rate_order.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(RateOrder record) {
        getSqlMapClientTemplate().insert("rate_order.insert", record);
    }

    public void insertSelective(RateOrder record) {
        getSqlMapClientTemplate().insert("rate_order.insertSelective", record);
    }

    public RateOrder selectByPrimaryKey(Long id) {
        RateOrder _key = new RateOrder();
        _key.setId(id);
        RateOrder record = (RateOrder) getSqlMapClientTemplate().queryForObject("rate_order.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(RateOrder record) {
        int rows = getSqlMapClientTemplate().update("rate_order.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RateOrder record) {
        int rows = getSqlMapClientTemplate().update("rate_order.updateByPrimaryKey", record);
        return rows;
    }

    @Override
    public int batchInsertSelective(List<RateOrder> rateOrders) {
        return batchInsert("rate_order.insertSelective",rateOrders);
    }
}