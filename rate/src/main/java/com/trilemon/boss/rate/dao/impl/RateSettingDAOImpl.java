package com.trilemon.boss.rate.dao.impl;

import com.trilemon.boss.rate.dao.RateSettingDAO;
import com.trilemon.boss.rate.model.RateSetting;
import com.trilemon.boss.rate.model.RateSettingExample;
import java.util.List;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class RateSettingDAOImpl extends SqlMapClientDaoSupport implements RateSettingDAO {

    public RateSettingDAOImpl() {
        super();
    }

    public int countByExample(RateSettingExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("rate_setting.countByExample", example);
        return count;
    }

    public int deleteByExample(RateSettingExample example) {
        int rows = getSqlMapClientTemplate().delete("rate_setting.deleteByExample", example);
        return rows;
    }

    public int deleteByPrimaryKey(Long id) {
        RateSetting _key = new RateSetting();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("rate_setting.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(RateSetting record) {
        getSqlMapClientTemplate().insert("rate_setting.insert", record);
    }

    public void insertSelective(RateSetting record) {
        getSqlMapClientTemplate().insert("rate_setting.insertSelective", record);
    }

    @SuppressWarnings("unchecked")
    public List<RateSetting> selectByExample(RateSettingExample example) {
        List<RateSetting> list = getSqlMapClientTemplate().queryForList("rate_setting.selectByExample", example);
        return list;
    }

    public RateSetting selectByPrimaryKey(Long id) {
        RateSetting _key = new RateSetting();
        _key.setId(id);
        RateSetting record = (RateSetting) getSqlMapClientTemplate().queryForObject("rate_setting.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(RateSetting record, RateSettingExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("rate_setting.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(RateSetting record, RateSettingExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("rate_setting.updateByExample", parms);
        return rows;
    }

    public int updateByPrimaryKeySelective(RateSetting record) {
        int rows = getSqlMapClientTemplate().update("rate_setting.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RateSetting record) {
        int rows = getSqlMapClientTemplate().update("rate_setting.updateByPrimaryKey", record);
        return rows;
    }

    protected static class UpdateByExampleParms extends RateSettingExample {
        private Object record;

        public UpdateByExampleParms(Object record, RateSettingExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}