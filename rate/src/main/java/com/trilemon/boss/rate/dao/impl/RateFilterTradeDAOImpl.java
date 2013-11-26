package com.trilemon.boss.rate.dao.impl;

import com.trilemon.boss.rate.dao.BaseDAO;
import com.trilemon.boss.rate.dao.RateFilterTradeDAO;
import com.trilemon.boss.rate.model.RateFilterTrade;
import org.springframework.stereotype.Repository;

@Repository
public class RateFilterTradeDAOImpl extends BaseDAO implements RateFilterTradeDAO {

    public RateFilterTradeDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Long id) {
        RateFilterTrade _key = new RateFilterTrade();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("rate_filter_trade.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(RateFilterTrade record) {
        getSqlMapClientTemplate().insert("rate_filter_trade.insert", record);
    }

    public void insertSelective(RateFilterTrade record) {
        getSqlMapClientTemplate().insert("rate_filter_trade.insertSelective", record);
    }

    public RateFilterTrade selectByPrimaryKey(Long id) {
        RateFilterTrade _key = new RateFilterTrade();
        _key.setId(id);
        RateFilterTrade record = (RateFilterTrade) getSqlMapClientTemplate().queryForObject("rate_filter_trade.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(RateFilterTrade record) {
        int rows = getSqlMapClientTemplate().update("rate_filter_trade.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RateFilterTrade record) {
        int rows = getSqlMapClientTemplate().update("rate_filter_trade.updateByPrimaryKey", record);
        return rows;
    }
}