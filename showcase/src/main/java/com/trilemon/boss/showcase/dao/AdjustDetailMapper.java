package com.trilemon.boss.showcase.dao;

import com.trilemon.boss.showcase.model.AdjustDetail;
import com.trilemon.boss.showcase.model.AdjustDetailExample;
import com.trilemon.boss.showcase.model.Setting;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdjustDetailMapper {
    int countByExample(AdjustDetailExample example);

    int deleteByExample(AdjustDetailExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdjustDetail record);

    int insertSelective(AdjustDetail record);

    List<AdjustDetail> selectByExample(AdjustDetailExample example);

    AdjustDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdjustDetail record, @Param("example") AdjustDetailExample example);

    int updateByExample(@Param("record") AdjustDetail record, @Param("example") AdjustDetailExample example);

    int updateByPrimaryKeySelective(AdjustDetail record);

    int updateByPrimaryKey(AdjustDetail record);

    List<AdjustDetail> selectByUserIdAndAdjustType(@Param("userId") Long userId, @Param("adjustType") Byte adjustType);

    int updateOrInsertByNumIid(Setting setting);

    int countByUserIdAndQuery(@Param("userId") Long userId,@Param("query")  String query);

    List<AdjustDetail> paginateByUserIdAndQuery(@Param("userId")Long userId,
                                                @Param("query") String query,
                                                @Param("offset") Integer offset,
                                                @Param("limit") Integer limit);
}