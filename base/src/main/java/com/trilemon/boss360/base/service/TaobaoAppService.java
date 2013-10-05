package com.trilemon.boss360.base.service;

import com.trilemon.boss360.base.dao.TaobaoAppMapper;
import com.trilemon.boss360.base.model.TaobaoApp;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author kevin
 */
public class TaobaoAppService {
    @Autowired
    private TaobaoAppMapper taobaoAppMapper;

    public TaobaoApp getTaobaoApp(String taobaoAppKey){
         return taobaoAppMapper.selectByAppKey(taobaoAppKey);
    }
}
