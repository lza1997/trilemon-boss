package com.trilemon.boss.infra.sync.rate.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.google.common.base.Preconditions;
import com.trilemon.boss.infra.sync.rate.dao.CalcSellerDayRateDAO;
import com.trilemon.boss.infra.sync.rate.dao.router.CalcSellerDayRateRouter;
import com.trilemon.boss.infra.sync.rate.model.CalcSellerDayRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class CalcSellerDayRateDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements CalcSellerDayRateDAO {

    @Autowired
    private CalcSellerDayRateRouter router;

    public int deleteByPrimaryKey(Long userId,Long id) {
        CalcSellerDayRate _key = new CalcSellerDayRate();
        _key.setId(id);
        _key.setUserId(userId);
        router.routeAndSetTableId(_key);

        int rows = getSqlMapClientTemplate().delete("calc_seller_day_rate.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(CalcSellerDayRate record) {
        Preconditions.checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        getSqlMapClientTemplate().insert("calc_seller_day_rate.insert", record);
    }

    public void insertSelective(CalcSellerDayRate record) {
        Preconditions.checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        getSqlMapClientTemplate().insert("calc_seller_day_rate.insertSelective", record);
    }

    public CalcSellerDayRate selectByPrimaryKey(Long userId,Long id) {
        CalcSellerDayRate _key = new CalcSellerDayRate();
        _key.setId(id);
        _key.setUserId(userId);
        router.routeAndSetTableId(_key);
        CalcSellerDayRate record = (CalcSellerDayRate) getSqlMapClientTemplate().queryForObject("calc_seller_day_rate.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(CalcSellerDayRate record) {
        Preconditions.checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        int rows = getSqlMapClientTemplate().update("calc_seller_day_rate.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(CalcSellerDayRate record) {
        Preconditions.checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        int rows = getSqlMapClientTemplate().update("calc_seller_day_rate.updateByPrimaryKey", record);
        return rows;
    }

    @Override
    public void replaceSelective(CalcSellerDayRate calcSellerDayRate) {
        Preconditions.checkNotNull(calcSellerDayRate.getUserId());
        router.routeAndSetTableId(calcSellerDayRate);
        getSqlMapClientTemplate().insert("calc_seller_day_rate.replaceSelective", calcSellerDayRate);
    }

    @Override
    public CalcSellerDayRate selectByUserIdAndRateTime(Long userId, Date rateTime) {
        CalcSellerDayRate _key = new CalcSellerDayRate();
        _key.setUserId(userId);
        _key.setRateTime(rateTime);
        router.routeAndSetTableId(_key);
        CalcSellerDayRate record = (CalcSellerDayRate) getSqlMapClientTemplate().queryForObject("calc_seller_day_rate.selectByUserIdAndRateTime", _key);
        return record;
    }
}