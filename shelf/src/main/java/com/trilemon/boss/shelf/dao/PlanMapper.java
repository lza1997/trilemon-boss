package com.trilemon.boss.shelf.dao;

import com.google.common.collect.ImmutableList;
import com.trilemon.boss.shelf.model.Plan;
import com.trilemon.boss.shelf.model.PlanExample;
import com.trilemon.boss.shelf.model.dto.PlanStatus;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
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

    void deleteByPlanSettingId(Long planSettingId);

    void deleteByUserIdAndNumIids(@Param("userId") Long userId, @Param("numIids") List<Long> numIids);

    void deleteByUserIdAndPlanSettingId(@Param("userId") Long userId, @Param("planSettingId") Long planSettingId);

    List<Plan> selectByUserIdAndPlanSettingId(@Param("userId") Long userId, @Param("planSettingId") Long planSettingId);

    List<Plan> selectByPlanSettingIdAndStatus(@Param("planSettingId") Long planSettingId,
                                              @Param("statusList") List<Byte> statusList);

    int countByUserIdAndPlanSettingIdAndStatus(@Param("userId") Long userId,
                                               @Param("planSettingId") Long planSettingId,
                                               @Param("statusList") List<Byte> statusList,
                                               @Param("query") String query);

    List<Plan> paginateByUserIdAndPlanSettingIdAndStatus(@Param("userId") Long userId,
                                                         @Param("planSettingId") Long planSettingId,
                                                         @Param("statusList") List<Byte> statusList,
                                                         @Param("query") String query,
                                                         @Param("offset") Integer offset,
                                                         @Param("limit") Integer limit);

    PlanStatus calcPlanStatus(@Param("planSettingId") Long planSettingId, @Param("lastPlanTime") Date lastPlanTime);

    List<Plan> selectByPlanSettingIdAndStatusAndPlanTime(@Param("planSettingId") Long planSettingId,
                                                         @Param("statusList") ImmutableList<Byte> statusList,
                                                         @Param("planAdjustDay") Date planAdjustDay,
                                                         @Param("planAdjustEndTime") Date planAdjustEndTime);

    void updateByPlanSettingIdAndNumIid(Plan plan);

    List<Long> selectNumIidsByUserId(Long userId);
}