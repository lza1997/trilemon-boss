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
}