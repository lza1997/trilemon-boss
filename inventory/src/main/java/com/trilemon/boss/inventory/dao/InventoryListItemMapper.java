package com.trilemon.boss.inventory.dao;

import com.trilemon.boss.inventory.model.InventoryListItem;
import com.trilemon.boss.inventory.model.InventoryListItemExample;
import org.apache.ibatis.annotations.Param;

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

    int countByUserIdAndSettingIdAndStatus(long userId, long settingId, List<Byte> statusList, String query);

    List<InventoryListItem> paginateByUserIdAndSettingIdAndStatus(long userId,
                                                                  long settingId,
                                                                  List<Byte> statusList,
                                                                  String query,
                                                                  int offset,
                                                                  int limit);
}