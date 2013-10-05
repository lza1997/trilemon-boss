package com.trilemon.boss360.base.client.impl;

import com.taobao.api.ApiException;
import com.taobao.api.domain.Item;
import com.taobao.api.request.ItemsOnsaleGetRequest;
import com.trilemon.boss360.base.client.BaseClient;
import com.trilemon.boss360.base.model.TaobaoApiUsage;
import com.trilemon.boss360.base.model.TaobaoApp;
import com.trilemon.boss360.base.serivce.TaobaoItemService;
import com.trilemon.boss360.base.service.TaobaoApiUsageService;
import com.trilemon.boss360.base.service.TaobaoAppService;

import java.util.List;

/**
 * @author kevin
 */
public class BaseClientImpl implements BaseClient {
    private TaobaoApiUsageService taobaoApiUsageService;
    private TaobaoAppService taobaoAppService;
    private TaobaoItemService taobaoItemService;

    @Override
    public void updateApiUsage(List<TaobaoApiUsage> taobaoApiUsageList) {
        taobaoApiUsageService.updateApiUsage(taobaoApiUsageList);
    }

    @Override
    public TaobaoApp getTaobaoApp(String taobaoAppKey) {
        return taobaoAppService.getTaobaoApp(taobaoAppKey);
    }

    @Override
    public List<Item> getOnSaleItemsByNick(ItemsOnsaleGetRequest request, String appKey, String nick) throws ApiException {
        return taobaoItemService.getOnSaleItemsByNick(request, appKey, nick);
    }

    @Override
    public List<Item> getOnSaleItemsByUserId(ItemsOnsaleGetRequest request, String appKey, long userId) throws ApiException {
        return taobaoItemService.getOnSaleItemsByUserId(request, appKey, userId);
    }
}
