package com.trilemon.boss.rate.dao.impl;

import com.trilemon.boss.rate.dao.RateFilterTradeDAO;
import com.trilemon.boss.rate.model.RateFilterTrade;
import com.trilemon.boss.rate.model.RateFilterTradeExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class RateFilterTradeDAOImpl extends SqlMapClientDaoSupport implements RateFilterTradeDAO {

    public RateFilterTradeDAOImpl() {
        super();
    }

    public int countByExample(RateFilterTradeExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("rate_filter_trade.countByExample", example);
        return count;
    }

    public int deleteByExample(RateFilterTradeExample example) {
        int rows = getSqlMapClientTemplate().delete("rate_filter_trade.deleteByExample", example);
        return rows;
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

    @SuppressWarnings("unchecked")
    public List<RateFilterTrade> selectByExample(RateFilterTradeExample example) {
        List<RateFilterTrade> list = getSqlMapClientTemplate().queryForList("rate_filter_trade.selectByExample", example);
        return list;
    }

    public RateFilterTrade selectByPrimaryKey(Long id) {
        RateFilterTrade _key = new RateFilterTrade();
        _key.setId(id);
        RateFilterTrade record = (RateFilterTrade) getSqlMapClientTemplate().queryForObject("rate_filter_trade.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(RateFilterTrade record, RateFilterTradeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("rate_filter_trade.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(RateFilterTrade record, RateFilterTradeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("rate_filter_trade.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(RateFilterTrade record) {
        int rows = getSqlMapClientTemplate().update("rate_filter_trade.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RateFilterTrade record) {
        int rows = getSqlMapClientTemplate().update("rate_filter_trade.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends RateFilterTradeExample {
        private Object record;

        public UpdateByExampleParms(Object record, RateFilterTradeExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}