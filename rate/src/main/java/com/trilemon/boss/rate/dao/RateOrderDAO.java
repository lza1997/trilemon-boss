package com.trilemon.boss.rate.dao;

import com.trilemon.boss.rate.model.RateOrder;

import java.util.Date;
import java.util.List;

public interface RateOrderDAO {
    int deleteByPrimaryKey(Long userId, Long id);

    void insert(RateOrder record);

    void insertSelective(RateOrder record);

    RateOrder selectByPrimaryKey(Long userId, Long id);

    int updateByPrimaryKeySelective(RateOrder record);

    int updateByPrimaryKey(RateOrder record);

    int batchInsertSelective(List<RateOrder> rateOrders);

    RateOrder selectByUserIdAndOid(Long userId, Long oid);

    int countBuyerRate(Long userId, Long tid, String buyerNick, List<Byte> statusList, List<String> rateTypes, Date startDate, Date endDate, int offset, int limit);

    List<RateOrder> paginateBuyerRate(Long userId, Long tid, String buyerNick, List<Byte> statusList, List<String> rateTypes, Date startDate, Date endDate,
                                      int offset, int limit);
}