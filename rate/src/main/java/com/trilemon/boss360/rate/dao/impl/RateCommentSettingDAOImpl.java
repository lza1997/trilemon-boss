package com.trilemon.boss360.rate.dao.impl;

import com.google.common.collect.ImmutableList;
import com.trilemon.boss360.rate.dao.RateCommentSettingDAO;
import com.trilemon.boss360.rate.model.RateCommentSetting;
import com.trilemon.boss360.rate.model.RateCommentSettingExample;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.util.List;

public class RateCommentSettingDAOImpl extends SqlMapClientDaoSupport implements RateCommentSettingDAO {

    public RateCommentSettingDAOImpl() {
        super();
    }

    public int countByExample(RateCommentSettingExample example) {
        Integer count = (Integer)  getSqlMapClientTemplate().queryForObject("rate_comment_setting.countByExample", example);
        return count;
    }

    public int deleteByExample(RateCommentSettingExample example) {
        int rows = getSqlMapClientTemplate().delete("rate_comment_setting.deleteByExample", example);
        return rows;
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

    @SuppressWarnings("unchecked")
    public List<RateCommentSetting> selectByExample(RateCommentSettingExample example) {
        List<RateCommentSetting> list = getSqlMapClientTemplate().queryForList("rate_comment_setting.selectByExample", example);
        return list;
    }

    public RateCommentSetting selectByPrimaryKey(Long id) {
        RateCommentSetting _key = new RateCommentSetting();
        _key.setId(id);
        RateCommentSetting record = (RateCommentSetting) getSqlMapClientTemplate().queryForObject("rate_comment_setting.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByExampleSelective(RateCommentSetting record, RateCommentSettingExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("rate_comment_setting.updateByExampleSelective", parms);
        return rows;
    }

    public int updateByExample(RateCommentSetting record, RateCommentSettingExample example) {
        UpdateByExampleParms parms = new UpdateByExampleParms(record, example);
        int rows = getSqlMapClientTemplate().update("rate_comment_setting.updateByExample", parms);
        return rows;
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

    protected static class UpdateByExampleParms extends RateCommentSettingExample {
        private Object record;

        public UpdateByExampleParms(Object record, RateCommentSettingExample example) {
            super(example);
            this.record = record;
        }

        public Object getRecord() {
            return record;
        }
    }
}