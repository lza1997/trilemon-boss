package com.trilemon.boss.rate.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.google.common.collect.ImmutableMap;
import com.trilemon.boss.rate.dao.RateSettingDAO;
import com.trilemon.boss.rate.model.RateSetting;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RateSettingDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements RateSettingDAO {

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

    public RateSetting selectByPrimaryKey(Long id) {
        RateSetting _key = new RateSetting();
        _key.setId(id);
        RateSetting record = (RateSetting) getSqlMapClientTemplate().queryForObject("rate_setting.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(RateSetting record) {
        int rows = getSqlMapClientTemplate().update("rate_setting.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RateSetting record) {
        int rows = getSqlMapClientTemplate().update("rate_setting.updateByPrimaryKey", record);
        return rows;
    }

    @Override
    public int updateByUserId(RateSetting rateSetting) {
        int rows = getSqlMapClientTemplate().update("rate_setting.updateByUserId", rateSetting);
        return rows;
    }

    @Override
    public RateSetting selectByUserId(Long userId) {
        RateSetting _key = new RateSetting();
        _key.setUserId(userId);
        RateSetting record = (RateSetting) getSqlMapClientTemplate().queryForObject("rate_setting.selectByUserId", _key);
        return record;
    }

    @Override
    public List<Long> paginateUserIdByStatus(Integer offset, Integer limit, List<Byte> statusList) {
        Map<String, ?> paramMap = ImmutableMap.of("offset", offset, "limit", limit, "statusList", statusList);
        return getSqlMapClientTemplate().queryForList("rate_setting.paginateUserIdByStatus", paramMap);
    }
}