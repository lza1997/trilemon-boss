package com.trilemon.boss.sms.dao.impl;

import com.google.common.collect.ImmutableList;
import com.trilemon.boss.sms.dao.TradeNotifyConfirmDAO;
import com.trilemon.boss.trade.notify.model.TradeNotifyConfirm;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.util.List;

public class TradeNotifyConfirmDAOImpl extends SqlMapClientDaoSupport implements TradeNotifyConfirmDAO {

    public TradeNotifyConfirmDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Long id) {
        TradeNotifyConfirm _key = new TradeNotifyConfirm();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("trade_notify_confirm.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(TradeNotifyConfirm record) {
        getSqlMapClientTemplate().insert("trade_notify_confirm.insert", record);
    }

    public void insertSelective(TradeNotifyConfirm record) {
        getSqlMapClientTemplate().insert("trade_notify_confirm.insertSelective", record);
    }

    public TradeNotifyConfirm selectByPrimaryKey(Long id) {
        TradeNotifyConfirm _key = new TradeNotifyConfirm();
        _key.setId(id);
        TradeNotifyConfirm record = (TradeNotifyConfirm) getSqlMapClientTemplate().queryForObject("trade_notify_confirm.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(TradeNotifyConfirm record) {
        int rows = getSqlMapClientTemplate().update("trade_notify_confirm.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TradeNotifyConfirm record) {
        int rows = getSqlMapClientTemplate().update("trade_notify_confirm.updateByPrimaryKey", record);
        return rows;
    }

    @Override
    public void batchInsertIgnore(List<TradeNotifyConfirm> confirms) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<TradeNotifyConfirm> selectByUserIdAndStatus(Long userId, ImmutableList<Byte> statusList) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}