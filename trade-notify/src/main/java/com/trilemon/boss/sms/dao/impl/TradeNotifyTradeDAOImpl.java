package com.trilemon.boss.sms.dao.impl;

import com.trilemon.boss.sms.dao.TradeNotifyTradeDAO;
import com.trilemon.boss.trade.notify.model.TradeNotifyTrade;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class TradeNotifyTradeDAOImpl extends SqlMapClientDaoSupport implements TradeNotifyTradeDAO {

    public TradeNotifyTradeDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Integer id) {
        TradeNotifyTrade _key = new TradeNotifyTrade();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("trade_notify_trade.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(TradeNotifyTrade record) {
        getSqlMapClientTemplate().insert("trade_notify_trade.insert", record);
    }

    public void insertSelective(TradeNotifyTrade record) {
        getSqlMapClientTemplate().insert("trade_notify_trade.insertSelective", record);
    }
}