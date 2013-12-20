package com.trilemon.boss.sms.dao;

import com.trilemon.boss.trade.notify.model.TradeNotifyRefund;

public interface TradeNotifyRefundDAO {
    int deleteByPrimaryKey(Integer id);

    void insert(TradeNotifyRefund record);

    void insertSelective(TradeNotifyRefund record);
}