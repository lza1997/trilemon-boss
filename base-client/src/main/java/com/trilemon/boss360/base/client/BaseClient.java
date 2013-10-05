package com.trilemon.boss360.base.client;

import com.taobao.api.ApiException;
import com.taobao.api.domain.Item;
import com.taobao.api.request.ItemsOnsaleGetRequest;
import com.trilemon.boss360.base.model.TaobaoApiUsage;
import com.trilemon.boss360.base.model.TaobaoApp;

import java.util.List;

/**
 * @author kevin
 */
public interface BaseClient {
    void updateApiUsage(List<TaobaoApiUsage> taobaoApiUsageList);

    TaobaoApp getTaobaoApp(String taobaoAppKey);

    List<Item> getOnSaleItemsByNick(ItemsOnsaleGetRequest request, String appKey, String nick) throws ApiException;

    List<Item> getOnSaleItemsByUserId(ItemsOnsaleGetRequest request, String appKey, long userId) throws ApiException;
}
