package com.trilemon.boss360.inventory.dao;

import com.trilemon.boss360.inventory.model.InventoryListSetting;
import com.trilemon.boss360.inventory.model.InventoryListSettingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InventoryListSettingMapper {
    int countByExample(InventoryListSettingExample example);

    int deleteByExample(InventoryListSettingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InventoryListSetting record);

    int insertSelective(InventoryListSetting record);

    List<InventoryListSetting> selectByExample(InventoryListSettingExample example);

    InventoryListSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InventoryListSetting record, @Param("example") InventoryListSettingExample example);

    int updateByExample(@Param("record") InventoryListSetting record, @Param("example") InventoryListSettingExample example);

    int updateByPrimaryKeySelective(InventoryListSetting record);

    int updateByPrimaryKey(InventoryListSetting record);
}