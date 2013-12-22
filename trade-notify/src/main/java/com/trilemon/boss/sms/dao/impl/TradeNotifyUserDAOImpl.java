package com.trilemon.boss.sms.dao.impl;

import com.trilemon.boss.sms.dao.TradeNotifyUserDAO;
import com.trilemon.boss.trade.notify.model.TradeNotifyUser;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class TradeNotifyUserDAOImpl extends SqlMapClientDaoSupport implements TradeNotifyUserDAO {

    public TradeNotifyUserDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Long id) {
        TradeNotifyUser _key = new TradeNotifyUser();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("trade_notify_user.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(TradeNotifyUser record) {
        getSqlMapClientTemplate().insert("trade_notify_user.insert", record);
    }

    public void insertSelective(TradeNotifyUser record) {
        getSqlMapClientTemplate().insert("trade_notify_user.insertSelective", record);
    }

    public TradeNotifyUser selectByPrimaryKey(Long id) {
        TradeNotifyUser _key = new TradeNotifyUser();
        _key.setId(id);
        TradeNotifyUser record = (TradeNotifyUser) getSqlMapClientTemplate().queryForObject("trade_notify_user.selectByPrimaryKey", _key);
        return record;
    }

    public int updateByPrimaryKeySelective(TradeNotifyUser record) {
        int rows = getSqlMapClientTemplate().update("trade_notify_user.updateByPrimaryKeySelective", record);
        return rows;
    }

    public int updateByPrimaryKey(TradeNotifyUser record) {
        int rows = getSqlMapClientTemplate().update("trade_notify_user.updateByPrimaryKey", record);
        return rows;
    }

    @Override
    public TradeNotifyUser selectByUserId(Long userId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}