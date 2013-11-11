package com.trilemon.boss360.rate.dao.impl;

import com.trilemon.boss360.rate.dao.RateSyncDAO;
import com.trilemon.boss360.rate.model.RateSync;
import com.trilemon.boss360.rate.model.RateSyncExample;
import com.trilemon.boss360.rate.model.dto.RateSyncStatus;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.util.List;

public class RateSyncDAOImpl extends SqlMapClientDaoSupport implements RateSyncDAO {

    public RateSyncDAOImpl() {
        super();
    }

    public int countByExample(RateSyncExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("rate_sync.countByExample", example);
        return count;
    }

    public int deleteByExample(RateSyncExample example) {
        int rows = getSqlMapClientTemplate().delete("rate_sync.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long userId) {
        RateSync _key = new RateSync();
        _key.setUserId(userId);
        int rows = getSqlMapClientTemplate().delete("rate_sync.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(RateSync record) {
        getSqlMapClientTemplate().insert("rate_sync.insert", record);
    }

    public void insertSelective(RateSync record) {
        getSqlMapClientTemplate().insert("rate_sync.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<RateSync> selectByExample(RateSyncExample example) {
        List<RateSync> list = getSqlMapClientTemplate().queryForList("rate_sync.selectByExample", example);
        return list;
    }

    public RateSync selectByPrimaryKey(Long userId) {
        RateSync _key = new RateSync();
        _key.setUserId(userId);
        RateSync record = (RateSync) getSqlMapClientTemplate().queryForObject("rate_sync.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(RateSync record, RateSyncExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("rate_sync.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(RateSync record, RateSyncExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("rate_sync.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(RateSync record) {
        int rows = getSqlMapClientTemplate().update("rate_sync.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RateSync record) {
        int rows = getSqlMapClientTemplate().update("rate_sync.updateByPrimaryKey", record);
        return rows;
    }

    @Override
    public RateSyncStatus selectRateSyncStatusByUserIdAndBuyerNick(Long userId, String buyerNick) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    protected static class UpdateByExampleParms extends RateSyncExample {
        private Object record;

        public UpdateByExampleParms(Object record, RateSyncExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}