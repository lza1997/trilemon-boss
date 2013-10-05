package com.trilemon.boss360.base.dao;

import com.trilemon.boss360.base.model.TaobaoApiUsage;
import com.trilemon.boss360.base.model.TaobaoApiUsageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaobaoApiUsageMapper {
    int countByExample(TaobaoApiUsageExample example);

    int deleteByExample(TaobaoApiUsageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaobaoApiUsage record);

    int insertSelective(TaobaoApiUsage record);

    List<TaobaoApiUsage> selectByExample(TaobaoApiUsageExample example);

    TaobaoApiUsage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaobaoApiUsage record, @Param("example") TaobaoApiUsageExample example);

    int updateByExample(@Param("record") TaobaoApiUsage record, @Param("example") TaobaoApiUsageExample example);

    int updateByPrimaryKeySelective(TaobaoApiUsage record);

    int updateByPrimaryKey(TaobaoApiUsage record);

    void batchInsert(List<TaobaoApiUsage> taobaoApiUsageList);
}