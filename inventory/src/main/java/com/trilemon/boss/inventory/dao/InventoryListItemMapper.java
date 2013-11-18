package com.trilemon.boss.inventory.dao;

import com.google.common.collect.ImmutableList;
import com.trilemon.boss.inventory.model.InventoryListItem;
import com.trilemon.boss.inventory.model.InventoryListItemExample;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface InventoryListItemMapper {
    int countByExample(InventoryListItemExample example);

    int deleteByExample(InventoryListItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InventoryListItem record);

    int insertSelective(InventoryListItem record);

    List<InventoryListItem> selectByExample(InventoryListItemExample example);

    InventoryListItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InventoryListItem record, @Param("example") InventoryListItemExample example);

    int updateByExample(@Param("record") InventoryListItem record, @Param("example") InventoryListItemExample example);

    int updateByPrimaryKeySelective(InventoryListItem record);

    int updateByPrimaryKey(InventoryListItem record);

    int countByUserIdAndSettingIdAndStatusAndBanners(long userId, long settingId, List<Byte> statusList,
                                                     String query, List<String> banners);

    List<InventoryListItem> paginateByUserIdAndSettingIdAndStatusAndBanners(long userId,
                                                                  long settingId,
                                                                  List<Byte> statusList,
                                                                  String query,
                                                                  List<String> banners,
                                                                  int offset,
                                                                  int limit);

    List<InventoryListItem> selectBySettingId(Long settingId);

    void deleteByNumIids(Long userId, List<Long> numIids);

    List<InventoryListItem> selectBySettingIdAndStatusAndPlanTime(Long settingId, ImmutableList<Byte> statusList, Date date1, Date date);

    List<Long> selectNumIidsByUserId(Long userId);

    void updateByUserIdAndNumIid(InventoryListItem listItem);

    InventoryListItem selectByUserIdAndNumIid(Long userId, Long numIid);
}