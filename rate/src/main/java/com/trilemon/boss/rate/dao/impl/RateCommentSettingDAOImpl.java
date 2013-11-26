package com.trilemon.boss.rate.dao.impl;

import com.google.common.collect.ImmutableList;
import com.trilemon.boss.rate.dao.BaseDAO;
import com.trilemon.boss.rate.dao.RateCommentSettingDAO;
import com.trilemon.boss.rate.model.RateCommentSetting;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RateCommentSettingDAOImpl extends BaseDAO implements RateCommentSettingDAO {

    public RateCommentSettingDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Long id) {
        RateCommentSetting _key = new RateCommentSetting();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("rate_comment_setting.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(RateCommentSetting record) {
        getSqlMapClientTemplate().insert("rate_comment_setting.insert", record);
    }

    public void insertSelective(RateCommentSetting record) {
        getSqlMapClientTemplate().insert("rate_comment_setting.insertSelective", record);
    }

    public RateCommentSetting selectByPrimaryKey(Long id) {
        RateCommentSetting _key = new RateCommentSetting();
        _key.setId(id);
        RateCommentSetting record = (RateCommentSetting) getSqlMapClientTemplate().queryForObject("rate_comment_setting.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(RateCommentSetting record) {
        int rows = getSqlMapClientTemplate().update("rate_comment_setting.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(RateCommentSetting record) {
        int rows = getSqlMapClientTemplate().update("rate_comment_setting.updateByPrimaryKey", record);
        return rows;
    }

    @Override
    public List<String> selectContentByUserIdAndStatus(Long userId, ImmutableList<Byte> statusList) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}