package com.trilemon.boss360.rate.dao.impl;

import com.trilemon.boss360.rate.dao.RateCanNotRateTradeDAO;
import com.trilemon.boss360.rate.model.RateCanNotRateTrade;
import com.trilemon.boss360.rate.model.RateCanNotRateTradeExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class RateCanNotRateTradeDAOImpl extends SqlMapClientDaoSupport implements RateCanNotRateTradeDAO {

    public RateCanNotRateTradeDAOImpl() {
        super();
    }

    public int countByExample(RateCanNotRateTradeExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("rate_can_not_rate_trade.countByExample", example);
        return count;
    }

    public int deleteByExample(RateCanNotRateTradeExample example) {
        int rows = getSqlMapClientTemplate().delete("rate_can_not_rate_trade.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        RateCanNotRateTrade _key = new RateCanNotRateTrade();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("rate_can_not_rate_trade.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(RateCanNotRateTrade record) {
        getSqlMapClientTemplate().insert("rate_can_not_rate_trade.insert", record);
    }

    public void insertSelective(RateCanNotRateTrade record) {
        getSqlMapClientTemplate().insert("rate_can_not_rate_trade.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<RateCanNotRateTrade> selectByExample(RateCanNotRateTradeExample example) {
        List<RateCanNotRateTrade> list = getSqlMapClientTemplate().queryForList("rate_can_not_rate_trade.selectByExample", example);
        return list;
    }

    public RateCanNotRateTrade selectByPrimaryKey(Long id) {
        RateCanNotRateTrade _key = new RateCanNotRateTrade();
        _key.setId(id);
        RateCanNotRateTrade record = (RateCanNotRateTrade) getSqlMapClientTemplate().queryForObject("rate_can_not_rate_trade.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(RateCanNotRateTrade record, RateCanNotRateTradeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("rate_can_not_rate_trade.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(RateCanNotRateTrade record, RateCanNotRateTradeExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("rate_can_not_rate_trade.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(RateCanNotRateTrade record) {
        int rows = getSqlMapClientTemplate().update("rate_can_not_rate_trade.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RateCanNotRateTrade record) {
        int rows = getSqlMapClientTemplate().update("rate_can_not_rate_trade.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends RateCanNotRateTradeExample {
        private Object record;

        public UpdateByExampleParms(Object record, RateCanNotRateTradeExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}