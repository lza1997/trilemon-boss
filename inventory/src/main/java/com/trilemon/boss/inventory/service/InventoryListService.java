package com.trilemon.boss.inventory.service;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.infra.base.service.TaobaoApiService;
import com.trilemon.boss.infra.base.service.api.TaobaoApiShopService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.inventory.InventoryConstants;
import com.trilemon.boss.inventory.InventoryException;
import com.trilemon.boss.inventory.dao.InventoryListItemMapper;
import com.trilemon.boss.inventory.dao.InventoryListSettingMapper;
import com.trilemon.boss.inventory.model.InventoryListItem;
import com.trilemon.boss.inventory.model.InventoryListSetting;
import com.trilemon.commons.Collections3;
import com.trilemon.commons.web.Page;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.trilemon.boss.inventory.InventoryConstants.*;

/**
 * @author kevin
 */
@Service
public class InventoryListService {
    @Autowired
    private InventoryListSettingMapper inventoryListSettingMapper;
    @Autowired
    private InventoryListItemMapper inventoryListItemMapper;
    @Autowired
    private AppService appService;
    @Autowired
    private TaobaoApiService taobaoApiService;
    @Autowired
    private TaobaoApiShopService taobaoApiShopService;

    /**
     * 根据仓库类型创建计划
     *
     * @param userId
     * @param inventoryTypes
     * @throws InventoryException
     */
    public void createSetting(Long userId, List<String> inventoryTypes) throws InventoryException {
        if (isSettingExist(userId)) {
            throw new InventoryException("userId[" + userId + "] exist.");
        }
        InventoryListSetting setting;
        setting = new InventoryListSetting();
        setting.setUserId(userId);
        setting.setIncludeInventoryTypes(Collections3.COMMA_JOINER.join(inventoryTypes));
        setting.setAddTime(appService.getLocalSystemTime().toDate());
        inventoryListSettingMapper.insertSelective(setting);
    }

    public boolean isSettingExist(Long userId) {
        InventoryListSetting setting = inventoryListSettingMapper.selectByUserId(userId);
        return null != setting;
    }

    /**
     * 创建新的计划
     *
     * @param userId
     * @param inventoryListSetting
     * @throws InventoryException
     */
    public void createSetting(Long userId, InventoryListSetting inventoryListSetting) throws InventoryException {
        if (isSettingExist(userId)) {
            throw new InventoryException("userId[" + userId + "] exist.");
        }
        inventoryListSetting.setUserId(userId);
        inventoryListSetting.setAddTime(appService.getLocalSystemTime().toDate());
        inventoryListSettingMapper.insertSelective(inventoryListSetting);
    }

    /**
     * 获取用户设置
     *
     * @param userId
     * @return
     */
    public InventoryListSetting getSetting(Long userId) {
        return inventoryListSettingMapper.selectByUserId(userId);
    }

    public void updateSetting(Long userId, InventoryListSetting inventoryListSetting) {
        inventoryListSetting.setUserId(userId);
        if (isSettingExist(userId)) {
            inventoryListSettingMapper.updateByUserIdSelective(inventoryListSetting);
        }
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
        if (LIST_TYPE_AVG == listType) {
            inventoryListSetting.setListType(listType);
            inventoryListSettingMapper.updateByUserIdSelective(inventoryListSetting);
            return;
        } else {
            if (LIST_TYPE_INTERVAL == listType) {
                inventoryListSetting.setListType(listType);
                inventoryListSetting.setListInterval(listInterval);
                inventoryListSettingMapper.updateByUserIdSelective(inventoryListSetting);
            }
        }
    }

    /**
     * 执行计划
     *
     * @param inventoryListSetting
     */
    public void list(InventoryListSetting inventoryListSetting) {

    }

    /**
     * 上架某个商品
     *
     * @param inventoryListItem
     */
    public void list(InventoryListItem inventoryListItem) {

    }

    /**
     * 下架某个商品
     *
     * @param userId
     * @param numIid
     */
    public void  delist(Long userId,Long numIid) {
        try {
            taobaoApiShopService.delistItem(userId, numIid);
        } catch (TaobaoAccessControlException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (TaobaoEnhancedApiException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (TaobaoSessionExpiredException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void  list(Long userId,Long numIid) {
        try {
            taobaoApiShopService.listItem(userId, numIid);
        } catch (TaobaoAccessControlException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (TaobaoEnhancedApiException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (TaobaoSessionExpiredException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    /**
     * 搜索仓库上架计划执行情况
     * @param userId
     * @param settingId
     * @param query
     * @param pageNum
     * @param pageSize
     * @return
     */
    public Page<InventoryListItem> paginationInventoryListItems(long userId,
                                                                long settingId,
                                                                String query,
                                                                int pageNum,
                                                                int pageSize) {
        List<Byte> statusList = ImmutableList.of(LIST_STATUS_EXCLUDED, LIST_STATUS_WAITING_ADJUST,
                LIST_STATUS_EXCLUDED);
        int totalSize = inventoryListItemMapper.countByUserIdAndSettingIdAndStatus(userId,
                settingId,
                statusList,
                query);
        List<InventoryListItem> plans = inventoryListItemMapper.paginateByUserIdAndSettingIdAndStatus(userId,
                settingId,
                statusList,
                query,
                (pageNum - 1) * pageSize,
                pageSize);
        if (CollectionUtils.isEmpty(plans)) {
            return Page.create(totalSize, pageNum, pageSize, Lists.<InventoryListItem>newArrayList());
        } else {
            return Page.create(totalSize, pageNum, pageSize, plans);
        }
    }
}
