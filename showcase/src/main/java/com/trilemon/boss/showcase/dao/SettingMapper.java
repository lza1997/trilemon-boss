package com.trilemon.boss.showcase.dao;

import com.trilemon.boss.showcase.model.Setting;
import com.trilemon.boss.showcase.model.SettingExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SettingMapper {
    int countByExample(SettingExample example);

    int deleteByExample(SettingExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Setting record);

    int insertSelective(Setting record);

    List<Setting> selectByExample(SettingExample example);

    Setting selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Setting record, @Param("example") SettingExample example);

    int updateByExample(@Param("record") Setting record, @Param("example") SettingExample example);

    int updateByPrimaryKeySelective(Setting record);

    int updateByPrimaryKey(Setting record);

    Setting selectByUserId(Long userId);

    void updateStatusByUserId(@Param("userId")Long userId,@Param("status") Byte status);

    void updateByUserIdSelective(Setting setting);
}