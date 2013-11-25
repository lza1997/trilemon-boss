package com.trilemon.boss.rate.sync.dao.impl;

import com.trilemon.boss.rate.sync.dao.CalcSellerDayRateDAO;
import com.trilemon.boss.rate.sync.model.CalcSellerDayRate;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class CalcSellerDayRateDAOImpl extends SqlMapClientDaoSupport implements CalcSellerDayRateDAO {

    public CalcSellerDayRateDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Long id) {
        CalcSellerDayRate _key = new CalcSellerDayRate();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("calc_seller_day_rate.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(CalcSellerDayRate record) {
        getSqlMapClientTemplate().insert("calc_seller_day_rate.insert", record);
    }

    public void insertSelective(CalcSellerDayRate record) {
        getSqlMapClientTemplate().insert("calc_seller_day_rate.insertSelective", record);
    }

    public CalcSellerDayRate selectByPrimaryKey(Long id) {
        CalcSellerDayRate _key = new CalcSellerDayRate();
        _key.setId(id);
        CalcSellerDayRate record = (CalcSellerDayRate) getSqlMapClientTemplate().queryForObject("calc_seller_day_rate.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(CalcSellerDayRate record) {
        int rows = getSqlMapClientTemplate().update("calc_seller_day_rate.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(CalcSellerDayRate record) {
        int rows = getSqlMapClientTemplate().update("calc_seller_day_rate.updateByPrimaryKey", record);
        return rows;
    }
}