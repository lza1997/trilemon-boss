package com.trilemon.boss360.base.dao;

import com.trilemon.boss360.base.model.TaobaoSession;
import com.trilemon.boss360.base.model.TaobaoSessionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaobaoSessionMapper {
    int countByExample(TaobaoSessionExample example);

    int deleteByExample(TaobaoSessionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TaobaoSession record);

    int insertSelective(TaobaoSession record);

    List<TaobaoSession> selectByExample(TaobaoSessionExample example);

    TaobaoSession selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TaobaoSession record, @Param("example") TaobaoSessionExample example);

    int updateByExample(@Param("record") TaobaoSession record, @Param("example") TaobaoSessionExample example);

    int updateByPrimaryKeySelective(TaobaoSession record);

    int updateByPrimaryKey(TaobaoSession record);
}