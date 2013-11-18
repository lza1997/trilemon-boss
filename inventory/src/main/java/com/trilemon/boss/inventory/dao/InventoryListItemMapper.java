package com.trilemon.boss.inventory.dao;

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

    int countByUserIdAndSettingIdAndStatusAndBanners(@Param("userId") Long userId,
                                                     @Param("inventoryListSettingId") Long settingId,
                                                     @Param("statusList") List<Byte> statusList,
                                                     @Param("query") String query,
                                                     @Param("banners") List<String> banners);

    List<InventoryListItem> paginateByUserIdAndSettingIdAndStatusAndBanners(@Param("userId") Long userId,
                                                                            @Param("inventoryListSettingId") Long settingId,
                                                                            @Param("statusList") List<Byte> statusList,
                                                                            @Param("query") String query,
                                                                            @Param("banners") List<String> banners,
                                                                            @Param("offset") Integer offset,
                                                                            @Param("limit") Integer limit);

    List<InventoryListItem> selectBySettingId(Long settingId);

    void deleteByNumIids(@Param("userId") Long userId,
                         @Param("numIids") List<Long> numIids);

    List<InventoryListItem> selectBySettingIdAndStatusAndPlanTime(@Param("inventoryListSettingId") Long settingId,
                                                                  @Param("statusList") List<Byte> statusList,
                                                                  @Param("planAdjustDay") Date planAdjustDay,
                                                                  @Param("planAdjustEndTime") Date planAdjustEndTime);

    List<Long> selectNumIidsByUserId(Long userId);

    void updateByUserIdAndNumIid(InventoryListItem listItem);

    InventoryListItem selectByUserIdAndNumIid(@Param("userId") Long userId,
                                              @Param("numIids") Long numIid);
}