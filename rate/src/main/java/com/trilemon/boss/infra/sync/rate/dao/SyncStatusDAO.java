package com.trilemon.boss.infra.sync.rate.dao;

import com.trilemon.boss.infra.sync.rate.model.SyncStatus;

import java.util.List;

public interface SyncStatusDAO {
    int deleteByPrimaryKey(Integer id);

    void insert(SyncStatus record);

    void insertSelective(SyncStatus record);

    SyncStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SyncStatus record);

    int updateByPrimaryKey(SyncStatus record);

    List<Long> paginateUserIdByCalcSellerDayRateStatus(long hitUserId, int pageSize, List<Byte> statusList);

    List<Long> paginateUserIdByRateSyncStatus(long hitUserId, int pageSize, List<Byte> statusList);

    int deleteByRateSyncOwnerAndStatus(String owner, List<Byte> statusList);

    SyncStatus selectByUserId(Long userId);

    int updateByUserIdSelective(SyncStatus syncStatus);
}