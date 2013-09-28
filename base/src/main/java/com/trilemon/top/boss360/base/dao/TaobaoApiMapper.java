package com.trilemon.top.boss360.base.dao;

import com.trilemon.top.boss360.base.model.TaobaoApi;
import com.trilemon.top.boss360.base.model.TaobaoApiExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaobaoApiMapper {
    int countByExample(TaobaoApiExample example);

    int deleteByExample(TaobaoApiExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaobaoApi record);

    int insertSelective(TaobaoApi record);

    List<TaobaoApi> selectByExample(TaobaoApiExample example);

    TaobaoApi selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaobaoApi record, @Param("example") TaobaoApiExample example);

    int updateByExample(@Param("record") TaobaoApi record, @Param("example") TaobaoApiExample example);

    int updateByPrimaryKeySelective(TaobaoApi record);

    int updateByPrimaryKey(TaobaoApi record);
}