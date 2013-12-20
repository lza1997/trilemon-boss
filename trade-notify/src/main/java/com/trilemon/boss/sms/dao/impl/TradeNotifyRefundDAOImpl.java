package com.trilemon.boss.sms.dao.impl;

import com.trilemon.boss.sms.dao.TradeNotifyRefundDAO;
import com.trilemon.boss.trade.notify.model.TradeNotifyRefund;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class TradeNotifyRefundDAOImpl extends SqlMapClientDaoSupport implements TradeNotifyRefundDAO {

    public TradeNotifyRefundDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Integer id) {
        TradeNotifyRefund _key = new TradeNotifyRefund();
        _key.setId(id);
        int rows = getSqlMapClientTemplate().delete("trade_notify_refund.deleteByPrimaryKey", _key);
        return rows;
    }

    public void insert(TradeNotifyRefund record) {
        getSqlMapClientTemplate().insert("trade_notify_refund.insert", record);
    }

    public void insertSelective(TradeNotifyRefund record) {
        getSqlMapClientTemplate().insert("trade_notify_refund.insertSelective", record);
    }
}