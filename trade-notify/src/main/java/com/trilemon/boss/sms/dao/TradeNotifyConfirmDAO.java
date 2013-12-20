package com.trilemon.boss.sms.dao;

import com.google.common.collect.ImmutableList;
import com.trilemon.boss.trade.notify.model.TradeNotifyConfirm;

import java.util.List;

public interface TradeNotifyConfirmDAO {
    int deleteByPrimaryKey(Long id);

    void insert(TradeNotifyConfirm record);

    void insertSelective(TradeNotifyConfirm record);

    TradeNotifyConfirm selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TradeNotifyConfirm record);

    int updateByPrimaryKey(TradeNotifyConfirm record);

    void batchInsertIgnore(List<TradeNotifyConfirm> confirms);

    List<TradeNotifyConfirm> selectByUserIdAndStatus(Long userId, ImmutableList<Byte> statusList);
}