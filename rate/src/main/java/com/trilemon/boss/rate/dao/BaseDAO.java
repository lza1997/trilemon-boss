package com.trilemon.boss.rate.dao;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import javax.annotation.PostConstruct;

/**
 * @author kevin
 */
public class BaseDAO extends MysdalCobarSqlMapClientDaoSupport {
    @Autowired
    private SqlMapClientTemplate sqlMapClientTemplate = new SqlMapClientTemplate();

    @PostConstruct
    public void init() {
        setSqlMapClientTemplate(sqlMapClientTemplate);
    }

}
