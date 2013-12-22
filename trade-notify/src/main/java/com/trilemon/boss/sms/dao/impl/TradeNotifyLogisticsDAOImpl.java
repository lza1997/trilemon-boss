package com.trilemon.boss.sms.dao.impl;

import com.trilemon.boss.sms.dao.TradeNotifyLogisticsDAO;
import com.trilemon.boss.trade.notify.model.TradeNotifyLogistics;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class TradeNotifyLogisticsDAOImpl extends SqlMapClientDaoSupport implements TradeNotifyLogisticsDAO {

    public TradeNotifyLogisticsDAOImpl() {
        super();
    }

    public int deleteByPrimaryKey(Integer id) {
//        TradeNotifyLogistics _key = new TradeNotifyLogistics();
//        _key.setId(id);
//        int rows = getSqlMapClientTemplate().delete("trade_notify_logistics.deleteByPrimaryKey", _key);
//        return rows;
        return 1;
    }

    public void insert(TradeNotifyLogistics record) {
        getSqlMapClientTemplate().insert("trade_notify_logistics.insert", record);
    }

    public void insertSelective(TradeNotifyLogistics record) {
        getSqlMapClientTemplate().insert("trade_notify_logistics.insertSelective", record);
    }
}