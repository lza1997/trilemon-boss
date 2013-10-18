package com.trilemon.boss360.shelf.dao;

import com.trilemon.boss360.shelf.model.Plan;
import com.trilemon.boss360.shelf.model.PlanExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlanMapper {
    int countByExample(PlanExample example);

    int deleteByExample(PlanExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Plan record);

    int insertSelective(Plan record);

    List<Plan> selectByExample(PlanExample example);

    Plan selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Plan record, @Param("example") PlanExample example);

    int updateByExample(@Param("record") Plan record, @Param("example") PlanExample example);

    int updateByPrimaryKeySelective(Plan record);

    int updateByPrimaryKey(Plan record);

    List<Plan> selectByPlanSettingId(Long planSettingId);

    void batchInsert(List<Plan> plans);

    void deleteByPlanSettingId(Long planSettingId);

    void batchDeleteByNumIid(Long userId, Long id, List<Long> numIids);

    void deleteByUserIdAndPlanSettingId(Long userId, Long planSettingId);

    List<Plan> selectByUserIdAndPlanSettingId(Long userId, Long planSettingId);
}