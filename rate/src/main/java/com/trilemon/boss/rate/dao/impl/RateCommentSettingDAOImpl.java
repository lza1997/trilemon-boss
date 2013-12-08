package com.trilemon.boss.rate.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.google.common.collect.ImmutableMap;
import com.trilemon.boss.rate.dao.RateCommentSettingDAO;
import com.trilemon.boss.rate.model.RateCommentSetting;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class RateCommentSettingDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements RateCommentSettingDAO {
    @Override
    public int deleteByPrimaryKey(Long id) {
        RateCommentSetting _key = new RateCommentSetting();
        _key.setId(id);
        return getSqlMapClientTemplate().delete("rate_comment_setting.deleteByPrimaryKey", _key);
    }

    @Override
    public void insert(RateCommentSetting record) {
        getSqlMapClientTemplate().insert("rate_comment_setting.insert", record);
    }

    @Override
    public void insertSelective(RateCommentSetting record) {
        getSqlMapClientTemplate().insert("rate_comment_setting.insertSelective", record);
    }

    @Override
    public RateCommentSetting selectByPrimaryKey(Long id) {
        RateCommentSetting _key = new RateCommentSetting();
        _key.setId(id);
        return (RateCommentSetting) getSqlMapClientTemplate().queryForObject("rate_comment_setting.selectByPrimaryKey", _key);
    }

    @Override
    public int updateByPrimaryKeySelective(RateCommentSetting record) {
        return getSqlMapClientTemplate().update("rate_comment_setting.updateByPrimaryKeySelective", record);
    }

    @Override
    public int updateByPrimaryKey(RateCommentSetting record) {
        return getSqlMapClientTemplate().update("rate_comment_setting.updateByPrimaryKey", record);
    }

    @Override
    public List<String> selectContentByUserIdAndStatus(Long userId, List<Byte> statusList) {
        Map<String, ?> parameterObject = ImmutableMap.of(
                "userId", userId,
                "statusList", statusList
        );
        return getSqlMapClientTemplate().queryForList("rate_comment_setting.selectContentByUserIdAndStatus", parameterObject);
    }

    @Override
    public RateCommentSetting selectByPrimaryKeyAndUserId(Long rateCommentSettingId, Long userId) {
        RateCommentSetting _key = new RateCommentSetting();
        _key.setUserId(userId);
        _key.setId(rateCommentSettingId);
        return (RateCommentSetting) getSqlMapClientTemplate().queryForObject("rate_comment_setting.selectByPrimaryKeyAndUserId", _key);
    }
}