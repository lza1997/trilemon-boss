package com.trilemon.top.boss360.shelf.dao;

import com.trilemon.top.boss360.shelf.model.PlanSetting;
import com.trilemon.top.boss360.shelf.model.PlanSettingExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlanSettingMapper {
    int countByExample(PlanSettingExample example);

    int deleteByExample(PlanSettingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PlanSetting record);

    int insertSelective(PlanSetting record);

    List<PlanSetting> selectByExample(PlanSettingExample example);

    PlanSetting selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PlanSetting record, @Param("example") PlanSettingExample example);

    int updateByExample(@Param("record") PlanSetting record, @Param("example") PlanSettingExample example);

    int updateByPrimaryKeySelective(PlanSetting record);

    int updateByPrimaryKey(PlanSetting record);
}