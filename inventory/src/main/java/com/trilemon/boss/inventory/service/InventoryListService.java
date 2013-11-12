package com.trilemon.boss.inventory.service;

import com.taobao.api.request.ItemsInventoryGetRequest;
import com.taobao.api.response.ItemsInventoryGetResponse;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.infra.base.service.TaobaoApiService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.inventory.InventoryConstants;
import com.trilemon.boss.inventory.dao.InventoryListSettingMapper;
import com.trilemon.boss.inventory.model.InventoryListSetting;
import com.trilemon.commons.Collections3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kevin
 */
@Service
public class InventoryListService {
    @Autowired
    private InventoryListSettingMapper inventoryListSettingMapper;
    @Autowired
    private AppService appService;
    @Autowired
    private TaobaoApiService taobaoApiService;

    public void createInventoryListSetting(Long userId, InventoryListSetting inventoryListSetting) {
        inventoryListSetting.setUserId(userId);
        inventoryListSetting.setAddTime(appService.getLocalSystemTime().toDate());
        inventoryListSettingMapper.insertSelective(inventoryListSetting);
    }

    public void updateInventoryListSetting(InventoryListSetting inventoryListSetting) {

    }

    public void updateDistribution(Long userId, String distribution) {
        InventoryListSetting inventoryListSetting = new InventoryListSetting();
        inventoryListSetting.setUserId(userId);
        inventoryListSetting.setDistribution(distribution);
        inventoryListSettingMapper.updateByUserIdSelective(inventoryListSetting);
    }

    public void updateIncludeInventoryTypes(Long userId, String includeInventoryTypes) {
        InventoryListSetting inventoryListSetting = new InventoryListSetting();
        inventoryListSetting.setUserId(userId);
        inventoryListSetting.setIncludeInventoryTypes(includeInventoryTypes);
        inventoryListSettingMapper.updateByUserIdSelective(inventoryListSetting);
    }

    public void updateListType(Long userId, byte listType, int listInterval) {
        InventoryListSetting inventoryListSetting = new InventoryListSetting();
        inventoryListSetting.setUserId(userId);
        if (InventoryConstants.LIST_TYPE_AVG == listType) {
            inventoryListSetting.setListType(listType);
            inventoryListSettingMapper.updateByUserIdSelective(inventoryListSetting);
            return;
        } else {
            if (InventoryConstants.LIST_TYPE_INTERVAL == listType) {
                inventoryListSetting.setListType(listType);
                inventoryListSetting.setListInterval(listInterval);
                inventoryListSettingMapper.updateByUserIdSelective(inventoryListSetting);
            }
        }
    }

    public void list(InventoryListSetting inventoryListSetting) {

    }

    public Long getNeverOnShelfItemNum(Long userId) throws TaobaoSessionExpiredException, TaobaoEnhancedApiException, TaobaoAccessControlException {
        return getInventoryItemNum(userId, InventoryConstants.ITEM_FIELDS, InventoryConstants.NEVER_ON_SHELF);
    }

    public Long getOffShelfItemNum(Long userId) throws TaobaoSessionExpiredException, TaobaoEnhancedApiException, TaobaoAccessControlException {
        return getInventoryItemNum(userId, InventoryConstants.ITEM_FIELDS, InventoryConstants.OFF_SHELF);
    }

    public Long getInventoryItemNum(Long userId, List<String> fields, String inventoryType) throws TaobaoSessionExpiredException, TaobaoEnhancedApiException, TaobaoAccessControlException {
        ItemsInventoryGetRequest request = new ItemsInventoryGetRequest();
        request.setFields(Collections3.COMMA_JOINER.join(fields));
        request.setBanner(inventoryType);
        request.setPageNo(1L);
        request.setPageSize(1L);
        ItemsInventoryGetResponse response = taobaoApiService.request(request);
        return response.getTotalResults();
    }
}
