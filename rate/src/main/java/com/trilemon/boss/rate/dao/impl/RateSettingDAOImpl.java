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
        return getSqlMapClientTemplate().delete("rate_setting.deleteByPrimaryKey", _key);
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
        return (RateSetting) getSqlMapClientTemplate().queryForObject("rate_setting.selectByPrimaryKey", _key);
    }

    public int updateByPrimaryKeySelective(RateSetting record) {
        return getSqlMapClientTemplate().update("rate_setting.updateByPrimaryKeySelective", record);
    }

    public int updateByPrimaryKey(RateSetting record) {
        return getSqlMapClientTemplate().update("rate_setting.updateByPrimaryKey", record);
    }

    @Override
    public int updateByUserId(RateSetting rateSetting) {
        return getSqlMapClientTemplate().update("rate_setting.updateByUserId", rateSetting);
    }

    @Override
    public RateSetting selectByUserId(Long userId) {
        RateSetting _key = new RateSetting();
        _key.setUserId(userId);
        return (RateSetting) getSqlMapClientTemplate().queryForObject("rate_setting.selectByUserId", _key);
    }

    @Override
    public List<Long> paginateUserIdByStatus(Integer offset, Integer limit, List<Byte> statusList) {
        Map<String, ?> paramMap = ImmutableMap.of("offset", offset, "limit", limit, "statusList", statusList);
        return getSqlMapClientTemplate().queryForList("rate_setting.paginateUserIdByStatus", paramMap);
    }
}