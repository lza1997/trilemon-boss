package com.trilemon.boss.sms.dao;

import com.trilemon.boss.trade.notify.model.TradeNotifyLogistics;

public interface TradeNotifyLogisticsDAO {
    int deleteByPrimaryKey(Integer id);

    void insert(TradeNotifyLogistics record);

    void insertSelective(TradeNotifyLogistics record);
}