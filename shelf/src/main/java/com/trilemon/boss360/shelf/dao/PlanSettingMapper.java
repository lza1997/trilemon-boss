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

    PlanSetting selectByUserId(Long userId);
}