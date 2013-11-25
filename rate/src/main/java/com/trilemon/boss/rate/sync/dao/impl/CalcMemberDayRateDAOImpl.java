package com.trilemon.boss.rate.sync.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.trilemon.boss.rate.sync.dao.CalcMemberDayRateDAO;
import com.trilemon.boss.rate.sync.model.CalcMemberDayRate;
import org.springframework.stereotype.Repository;

@Repository
public class CalcMemberDayRateDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements CalcMemberDayRateDAO {

    public CalcMemberDayRateDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Long id) {
        CalcMemberDayRate _key = new CalcMemberDayRate();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("calc_member_day_rate.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(CalcMemberDayRate record) {
        getSqlMapClientTemplate().insert("calc_member_day_rate.insert", record);
    }

    public void insertSelective(CalcMemberDayRate record) {
        getSqlMapClientTemplate().insert("calc_member_day_rate.insertSelective", record);
    }

    public CalcMemberDayRate selectByPrimaryKey(Long id) {
        CalcMemberDayRate _key = new CalcMemberDayRate();
        _key.setId(id);
        CalcMemberDayRate record = (CalcMemberDayRate) getSqlMapClientTemplate().queryForObject("calc_member_day_rate.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(CalcMemberDayRate record) {
        int rows = getSqlMapClientTemplate().update("calc_member_day_rate.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(CalcMemberDayRate record) {
        int rows = getSqlMapClientTemplate().update("calc_member_day_rate.updateByPrimaryKey", record);
        return rows;
    }
}