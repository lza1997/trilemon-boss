package com.trilemon.boss360.base.dao;

import com.trilemon.boss360.base.model.TaobaoShop;
import com.trilemon.boss360.base.model.TaobaoShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaobaoShopMapper {
    int countByExample(TaobaoShopExample example);

    int deleteByExample(TaobaoShopExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TaobaoShop record);

    int insertSelective(TaobaoShop record);

    List<TaobaoShop> selectByExample(TaobaoShopExample example);

    TaobaoShop selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TaobaoShop record, @Param("example") TaobaoShopExample example);

    int updateByExample(@Param("record") TaobaoShop record, @Param("example") TaobaoShopExample example);

    int updateByPrimaryKeySelective(TaobaoShop record);

    int updateByPrimaryKey(TaobaoShop record);
}