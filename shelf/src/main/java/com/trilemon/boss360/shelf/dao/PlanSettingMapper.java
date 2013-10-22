package com.trilemon.boss360.shelf.dao;

import com.trilemon.boss360.shelf.model.PlanSetting;
import com.trilemon.boss360.shelf.model.PlanSettingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlanSettingMapper {
    int countByExample(PlanSettingExample example);

    int deleteByExample(PlanSettingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PlanSetting record);

    int insertSelective(PlanSetting record);

    List<PlanSetting> selectByExample(PlanSettingExample example);

    PlanSetting selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PlanSetting record, @Param("example") PlanSettingExample example);

    int updateByExample(@Param("record") PlanSetting record, @Param("example") PlanSettingExample example);

    int updateByPrimaryKeySelective(PlanSetting record);

    int updateByPrimaryKey(PlanSetting record);

    List<PlanSetting> selectByUserId(Long userId);

    List<PlanSetting> selectByUserIdAndStatus(@Param("userId") Long userId, @Param("statusList") List<Byte> statusList);

    List<PlanSetting> paginateByUserIdAndStatus(@Param("userId") Long userId,
                                                @Param("offset") Integer offset,
                                                @Param("limit") Integer limit,
                                                @Param("statusList") List<Byte> statusList);

    int countByUserIdAndStatus(@Param("userId") Long userId, @Param("statusList") List<Byte> statusList);

    List<PlanSetting> paginateByStatus(@Param("offset") Integer offset,
                                       @Param("limit") Integer limit,
                                       @Param("statusList") List<Byte> statusList);

    int deleteByPrimaryKeyAndUserId(@Param("id") Long planSettingId, @Param("userId") Long userId);

    int updateByPrimaryKeyAndUserIdSelective(PlanSetting planSetting);

    PlanSetting selectByPrimaryKeyAndUserId(@Param("id") Long id, @Param("userId") Long userId);

    int countByUserId(Long userId);

    List<PlanSetting> paginateByUserIdAndName(@Param("userId") Long userId, @Param("query") String query,
                                              @Param("offset") Integer offset, @Param("limit") Integer limit);

    int countByUserIdAndName(@Param("userId") Long userId, @Param("query") String query);

    List<PlanSetting> paginateAutoAddItemPlanSettings(@Param("offset") Integer offset, @Param("limit") Integer limit);
}