package com.trilemon.boss360.rate.dao.impl;

import com.trilemon.boss360.rate.dao.RateBlacklistDAO;
import com.trilemon.boss360.rate.model.RateBlacklist;
import com.trilemon.boss360.rate.model.RateBlacklistExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class RateBlacklistDAOImpl extends SqlMapClientDaoSupport implements RateBlacklistDAO {

    public RateBlacklistDAOImpl() {
        super();
    }

    public int countByExample(RateBlacklistExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("rate_blacklist.countByExample", example);
        return count;
    }

    public int deleteByExample(RateBlacklistExample example) {
        int rows = getSqlMapClientTemplate().delete("rate_blacklist.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        RateBlacklist _key = new RateBlacklist();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("rate_blacklist.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(RateBlacklist record) {
        getSqlMapClientTemplate().insert("rate_blacklist.insert", record);
    }

    public void insertSelective(RateBlacklist record) {
        getSqlMapClientTemplate().insert("rate_blacklist.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<RateBlacklist> selectByExample(RateBlacklistExample example) {
        List<RateBlacklist> list = getSqlMapClientTemplate().queryForList("rate_blacklist.selectByExample", example);
        return list;
    }

    public RateBlacklist selectByPrimaryKey(Long id) {
        RateBlacklist _key = new RateBlacklist();
        _key.setId(id);
        RateBlacklist record = (RateBlacklist) getSqlMapClientTemplate().queryForObject("rate_blacklist.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(RateBlacklist record, RateBlacklistExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("rate_blacklist.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(RateBlacklist record, RateBlacklistExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("rate_blacklist.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(RateBlacklist record) {
        int rows = getSqlMapClientTemplate().update("rate_blacklist.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RateBlacklist record) {
        int rows = getSqlMapClientTemplate().update("rate_blacklist.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends RateBlacklistExample {
        private Object record;

        public UpdateByExampleParms(Object record, RateBlacklistExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}