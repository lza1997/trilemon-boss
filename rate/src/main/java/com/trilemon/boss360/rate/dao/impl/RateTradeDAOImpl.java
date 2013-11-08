package com.trilemon.boss360.rate.dao.impl;

import com.trilemon.boss360.rate.dao.RateTradeDAO;
import com.trilemon.boss360.rate.model.RateTrade;
import com.trilemon.boss360.rate.model.RateTradeExample;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.util.List;

public class RateTradeDAOImpl extends SqlMapClientDaoSupport implements RateTradeDAO {

    public RateTradeDAOImpl() {
        super();
    }

    public int countByExample(RateTradeExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("rate_trade.countByExample", example);
        return count;
    }

    public int deleteByExample(RateTradeExample example) {
        int rows = getSqlMapClientTemplate().delete("rate_trade.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        RateTrade _key = new RateTrade();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("rate_trade.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(RateTrade record) {
        getSqlMapClientTemplate().insert("rate_trade.insert", record);
    }

    public void insertSelective(RateTrade record) {
        getSqlMapClientTemplate().insert("rate_trade.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<RateTrade> selectByExample(RateTradeExample example) {
        List<RateTrade> list = getSqlMapClientTemplate().queryForList("rate_trade.selectByExample", example);
        return list;
    }

    public RateTrade selectByPrimaryKey(Long id) {
        RateTrade _key = new RateTrade();
        _key.setId(id);
        RateTrade record = (RateTrade) getSqlMapClientTemplate().queryForObject("rate_trade.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(RateTrade record, RateTradeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("rate_trade.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(RateTrade record, RateTradeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("rate_trade.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(RateTrade record) {
        int rows = getSqlMapClientTemplate().update("rate_trade.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RateTrade record) {
        int rows = getSqlMapClientTemplate().update("rate_trade.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends RateTradeExample {
        private Object record;

        public UpdateByExampleParms(Object record, RateTradeExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}