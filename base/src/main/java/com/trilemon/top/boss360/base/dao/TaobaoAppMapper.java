package com.trilemon.top.boss360.base.dao;

import com.trilemon.top.boss360.base.model.TaobaoApp;
import com.trilemon.top.boss360.base.model.TaobaoAppExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaobaoAppMapper {
    int countByExample(TaobaoAppExample example);

    int deleteByExample(TaobaoAppExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaobaoApp record);

    int insertSelective(TaobaoApp record);

    List<TaobaoApp> selectByExample(TaobaoAppExample example);

    TaobaoApp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaobaoApp record, @Param("example") TaobaoAppExample example);

    int updateByExample(@Param("record") TaobaoApp record, @Param("example") TaobaoAppExample example);

    int updateByPrimaryKeySelective(TaobaoApp record);

    int updateByPrimaryKey(TaobaoApp record);
}