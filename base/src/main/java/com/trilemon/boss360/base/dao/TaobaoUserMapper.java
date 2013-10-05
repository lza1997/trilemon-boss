package com.trilemon.boss360.base.dao;

import com.trilemon.boss360.base.model.TaobaoUser;
import com.trilemon.boss360.base.model.TaobaoUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaobaoUserMapper {
    int countByExample(TaobaoUserExample example);

    int deleteByExample(TaobaoUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TaobaoUser record);

    int insertSelective(TaobaoUser record);

    List<TaobaoUser> selectByExample(TaobaoUserExample example);

    TaobaoUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TaobaoUser record, @Param("example") TaobaoUserExample example);

    int updateByExample(@Param("record") TaobaoUser record, @Param("example") TaobaoUserExample example);

    int updateByPrimaryKeySelective(TaobaoUser record);

    int updateByPrimaryKey(TaobaoUser record);
}