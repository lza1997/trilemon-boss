package com.trilemon.boss.sms.dao;

import com.trilemon.boss.trade.notify.model.TradeNotifyUser;

public interface TradeNotifyUserDAO {
    int deleteByPrimaryKey(Long id);

    void insert(TradeNotifyUser record);

    void insertSelective(TradeNotifyUser record);

    TradeNotifyUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TradeNotifyUser record);

    int updateByPrimaryKey(TradeNotifyUser record);

    TradeNotifyUser selectByUserId(Long userId);
}