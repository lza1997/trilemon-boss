package com.trilemon.boss.rate.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.trilemon.boss.rate.dao.RateOrderDAO;
import com.trilemon.boss.rate.dao.router.RateOrderRouter;
import com.trilemon.boss.rate.model.RateOrder;
import com.trilemon.commons.db.ShardTableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

@Repository
public class RateOrderDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements RateOrderDAO {
    @Autowired
    private RateOrderRouter router;

    public int deleteByPrimaryKey(Long userId, Long id) {
        RateOrder _key = new RateOrder();
        _key.setId(id);
        _key.setUserId(userId);
        router.routeAndSetTableId(_key);
        return getSqlMapClientTemplate().delete("rate_order.deleteByPrimaryKey", _key);
    }

    public void insert(RateOrder record) {
        checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        getSqlMapClientTemplate().insert("rate_order.insert", record);
    }

    public void insertSelective(RateOrder record) {
        checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        getSqlMapClientTemplate().insert("rate_order.insertSelective", record);
    }

    public RateOrder selectByPrimaryKey(Long userId, Long id) {
        RateOrder _key = new RateOrder();
        _key.setId(id);
        _key.setUserId(userId);
        router.routeAndSetTableId(_key);
        return (RateOrder) getSqlMapClientTemplate().queryForObject("rate_order.selectByPrimaryKey", _key);
    }

    public int updateByPrimaryKeySelective(RateOrder record) {
        checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        return getSqlMapClientTemplate().update("rate_order.updateByPrimaryKeySelective", record);
    }

    public int updateByPrimaryKey(RateOrder record) {
        checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        return getSqlMapClientTemplate().update("rate_order.updateByPrimaryKey", record);
    }

    @Override
    public int batchInsertSelective(List<RateOrder> rateOrders) {
        for (RateOrder rateOrder : rateOrders) {
            checkNotNull(rateOrder.getUserId());
            router.routeAndSetTableId(rateOrder);
        }
        return batchInsert("rate_order.insertSelective", rateOrders);
    }

    @Override
    public RateOrder selectByUserIdAndOid(Long userId, Long oid) {
        checkNotNull(userId);
        RateOrder rateOrder = new RateOrder();
        rateOrder.setUserId(userId);
        ShardTableMap shardTableMap = router.getRouteMap(rateOrder);
        shardTableMap.put("userId", userId);
        shardTableMap.put("oid", oid);
        return (RateOrder) getSqlMapClientTemplate().queryForObject("rate_order.selectByUserIdAndOid", shardTableMap);
    }

    @Override
    public int countBuyerRate(Long userId, Long tid, String buyerNick, List<Byte> statusList, List<String> rateTypes, Date startDate,
                              Date endDate,
                              int offset,
                              int limit) {
        checkNotNull(userId);
        RateOrder rateOrder = new RateOrder();
        rateOrder.setUserId(userId);
        ShardTableMap shardTableMap = router.getRouteMap(rateOrder);
        shardTableMap.put("userId", userId);
        shardTableMap.put("tid", tid);
        shardTableMap.put("buyerNick", buyerNick);
        shardTableMap.put("statusList", statusList);
        shardTableMap.put("rateTypes", rateTypes);
        shardTableMap.put("startDate", buyerNick);
        shardTableMap.put("endDate", buyerNick);
        shardTableMap.put("offset", buyerNick);
        shardTableMap.put("limit", buyerNick);
        return (int) getSqlMapClientTemplate().queryForObject("rate_order.countBuyerRate", shardTableMap);
    }

    @Override
    public List<RateOrder> paginateBuyerRate(Long userId, Long tid, String buyerNick, List<Byte> statusList, List<String> rateTypes, Date startDate, Date endDate, int offset, int limit) {
        checkNotNull(userId);
        RateOrder rateOrder = new RateOrder();
        rateOrder.setUserId(userId);
        ShardTableMap shardTableMap = router.getRouteMap(rateOrder);
        shardTableMap.put("tid", tid);
        shardTableMap.put("buyerNick", buyerNick);
        shardTableMap.put("statusList", statusList);
        shardTableMap.put("rateTypes", rateTypes);
        shardTableMap.put("startDate", startDate);
        shardTableMap.put("endDate", endDate);
        shardTableMap.put("offset", offset);
        shardTableMap.put("limit", limit);
        shardTableMap.put("userId", userId);
        return (List<RateOrder>) getSqlMapClientTemplate().queryForList("rate_order.paginateBuyerRate", shardTableMap);
    }
}