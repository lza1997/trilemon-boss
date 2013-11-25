package com.trilemon.boss.rate.sync.dao;

import com.google.common.collect.ImmutableList;
import com.trilemon.boss.rate.sync.model.SyncStatus;
import org.springframework.stereotype.Repository;

@Repository
public interface
        SyncStatusDAO {
    int deleteByPrimaryKey(Integer id);

    void insert(SyncStatus record);

    void insertSelective(SyncStatus record);

    SyncStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SyncStatus record);

    int updateByPrimaryKey(SyncStatus record);

    SyncStatus selectByUserId(Long userId);

    int deleteByRateSyncOwnerAndStatus(String owner, ImmutableList<Byte> statusList);
}