package com.trilemon.boss.sms.dao;

import com.trilemon.boss.trade.notify.model.TradeNotifyTrade;

public interface TradeNotifyTradeDAO {
    int deleteByPrimaryKey(Integer id);

    void insert(TradeNotifyTrade record);

    void insertSelective(TradeNotifyTrade record);
}