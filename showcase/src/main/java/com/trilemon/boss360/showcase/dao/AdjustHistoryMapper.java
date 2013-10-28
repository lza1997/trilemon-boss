package com.trilemon.boss360.showcase.dao;

import com.trilemon.boss360.showcase.model.AdjustHistory;
import com.trilemon.boss360.showcase.model.AdjustHistoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdjustHistoryMapper {
    int countByExample(AdjustHistoryExample example);

    int deleteByExample(AdjustHistoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdjustHistory record);

    int insertSelective(AdjustHistory record);

    List<AdjustHistory> selectByExample(AdjustHistoryExample example);

    AdjustHistory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdjustHistory record, @Param("example") AdjustHistoryExample example);

    int updateByExample(@Param("record") AdjustHistory record, @Param("example") AdjustHistoryExample example);

    int updateByPrimaryKeySelective(AdjustHistory record);

    int updateByPrimaryKey(AdjustHistory record);

    List<AdjustHistory> selectByUserIdAndAdjustType(@Param("userId")Long userId,
                                                    @Param("adjustType") Byte adjustType);

    void batchInsert(List<AdjustHistory> adjustHistories);
}