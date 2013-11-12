package com.trilemon.boss.rate.dao.impl;

import com.trilemon.boss.rate.dao.RateOrderDAO;
import com.trilemon.boss.rate.model.RateOrder;
import com.trilemon.boss.rate.model.RateOrderExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class RateOrderDAOImpl extends SqlMapClientDaoSupport implements RateOrderDAO {

    public RateOrderDAOImpl() {
        super();
    }

    public int countByExample(RateOrderExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("rate_order.countByExample", example);
        return count;
    }

    public int deleteByExample(RateOrderExample example) {
        int rows = getSqlMapClientTemplate().delete("rate_order.deleteByExample", example);
        return rows;
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

    @SuppressWarnings("unchecked")
    public List<RateOrder> selectByExample(RateOrderExample example) {
        List<RateOrder> list = getSqlMapClientTemplate().queryForList("rate_order.selectByExample", example);
        return list;
    }

    public RateOrder selectByPrimaryKey(Long id) {
        RateOrder _key = new RateOrder();
        _key.setId(id);
        RateOrder record = (RateOrder) getSqlMapClientTemplate().queryForObject("rate_order.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(RateOrder record, RateOrderExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("rate_order.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(RateOrder record, RateOrderExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("rate_order.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(RateOrder record) {
        int rows = getSqlMapClientTemplate().update("rate_order.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RateOrder record) {
        int rows = getSqlMapClientTemplate().update("rate_order.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends RateOrderExample {
        private Object record;

        public UpdateByExampleParms(Object record, RateOrderExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}