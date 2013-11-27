package com.trilemon.boss.inventory.service;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.trilemon.boss.center.PlanDistributionUtils;
import com.trilemon.boss.infra.base.service.AppService;
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
import com.trilemon.commons.JsonMapper;
import com.trilemon.commons.web.Page;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static com.trilemon.boss.inventory.InventoryConstants.*;
import static com.trilemon.commons.Collections3.COMMA_JOINER;

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
    private InventoryListAdjustService adjustService;
    @Autowired
    private TaobaoApiShopService taobaoApiShopService;

    /**
     * 根据仓库类型创建/恢复计划
     *
     * @param userId
     * @param banners
     * @throws InventoryException
     */
    public void createSetting(Long userId, List<String> banners) throws InventoryException,
            TaobaoSessionExpiredException, TaobaoAccessControlException, TaobaoEnhancedApiException {
        InventoryListSetting setting = inventoryListSettingMapper.selectByUserId(userId);
        if (null != setting) {
            setting.setStatus(SETTING_STATUS_WAITING_PLAN);
            inventoryListSettingMapper.updateByPrimaryKeySelective(setting);
            if (StringUtils.isNotBlank(setting.getIncludeBanners())) {
                adjustService.update(userId);
            }
        } else {
            setting = new InventoryListSetting();
            setting.setUserId(userId);
            setting.setAutoAddNewItem(SETTING_AUTO_ADD_NEW_ITEM_ON);
            setting.setDistribution(PlanDistributionUtils.getDefaultTimeDistributionJson());
            setting.setStatus(SETTING_STATUS_WAITING_PLAN);
            setting.setListType(LIST_TYPE_AVG);
            setting.setIncludeBanners(COMMA_JOINER.join(banners));
            setting.setAddTime(appService.getLocalSystemTime().toDate());
            inventoryListSettingMapper.insertSelective(setting);
            adjustService.createPlan(userId,setting);
        }
    }

    public void resumeSetting(Long userId) throws InventoryException,
            TaobaoSessionExpiredException, TaobaoAccessControlException, TaobaoEnhancedApiException {
        InventoryListSetting setting = inventoryListSettingMapper.selectByUserId(userId);
        if (null != setting) {
            setting.setStatus(SETTING_STATUS_WAITING_PLAN);
            inventoryListSettingMapper.updateByPrimaryKeySelective(setting);
            if (StringUtils.isNotBlank(setting.getIncludeBanners())) {
                adjustService.update(userId);
            }
        }
    }

    /**
     * 暂定计划
     *
     * @param userId
     * @throws InventoryException
     * @throws TaobaoSessionExpiredException
     * @throws TaobaoEnhancedApiException
     */
    public void pauseSetting(Long userId) throws InventoryException, TaobaoSessionExpiredException,
            TaobaoEnhancedApiException {
        InventoryListSetting setting = inventoryListSettingMapper.selectByUserId(userId);
        if (null != setting) {
            setting.setStatus(SETTING_STATUS_PAUSED);
            inventoryListSettingMapper.updateByPrimaryKeySelective(setting);
        }

    }

    /**
     * 获取用户设置
     *
     * @param userId
     * @return
     */
    public InventoryListSetting getSetting(Long userId) {
        InventoryListSetting setting =  inventoryListSettingMapper.selectByUserId(userId);
        if(setting==null){
            setting = new InventoryListSetting();
            setting.setStatus(InventoryConstants.SETTING_STATUS_EMPTY);
        }
        return setting;
    }

    /**
     * 更新计划时间
     *
     * @param userId
     * @param distribution
     */
    public void updateDistribution(Long userId, Map<String, Map<String, Boolean>> distribution) {
        InventoryListSetting inventoryListSetting = new InventoryListSetting();
        inventoryListSetting.setUserId(userId);
        inventoryListSetting.setDistribution(JsonMapper.nonEmptyMapper().toJson(distribution));
        inventoryListSettingMapper.updateByUserIdSelective(inventoryListSetting);
    }

    /**
     * 更新库存类型
     *
     * @param userId
     * @param banners
     */
    public void updateIncludeBanners(Long userId, List<String> banners) {
        InventoryListSetting inventoryListSetting = new InventoryListSetting();
        inventoryListSetting.setUserId(userId);
        inventoryListSetting.setIncludeBanners(COMMA_JOINER.join(banners));
        inventoryListSettingMapper.updateByUserIdSelective(inventoryListSetting);
    }

    /**
     * 搜索仓库上架计划执行情况
     *
     * @param userId
     * @param settingId
     * @param query
     * @param pageNum
     * @param pageSize
     * @param statusList
     * @param banners
     * @return
     */
    public Page<InventoryListItem> paginationInventoryListItems(long userId,
                                                                long settingId,
                                                                String query,
                                                                int pageNum,
                                                                int pageSize,
                                                                List<Byte> statusList,
                                                                List<String> banners) {
        int totalSize = inventoryListItemMapper.countByUserIdAndSettingIdAndStatusAndBanners(userId,
                settingId,
                statusList,
                query,
                banners);
        List<InventoryListItem> plans = inventoryListItemMapper.paginateByUserIdAndSettingIdAndStatusAndBanners(userId,
                settingId,
                statusList,
                query,
                banners,
                (pageNum - 1) * pageSize,
                pageSize);
        if (CollectionUtils.isEmpty(plans)) {
            return Page.create(totalSize, pageNum, pageSize, Lists.<InventoryListItem>newArrayList());
        } else {
            return Page.create(totalSize, pageNum, pageSize, plans);
        }
    }

    /**
     * 立刻上架
     *
     * @param userId
     * @param numIid
     * @throws TaobaoEnhancedApiException
     * @throws TaobaoAccessControlException
     * @throws TaobaoSessionExpiredException
     */
    public void list(Long userId, Long numIid) throws TaobaoEnhancedApiException, TaobaoAccessControlException, TaobaoSessionExpiredException {
        InventoryListItem listItem = inventoryListItemMapper.selectByUserIdAndNumIid(userId, numIid);
        adjustService.execPlan(listItem);
    }

    /**
     * 排除宝贝
     *
     * @param userId
     * @param numIid
     */
    public void excludeItem(Long userId, Long numIid) {
        includeOrExcludeItem(userId, numIid, true);
    }

    /**
     * 恢复宝贝
     *
     * @param userId
     * @param numIid
     */
    public void includeItem(Long userId, Long numIid) {
        includeOrExcludeItem(userId, numIid, false);
    }

    @Transactional
    private void includeOrExcludeItem(Long userId, Long numIid, boolean exclude) {
        InventoryListItem listItem = new InventoryListItem();
        listItem.setUserId(userId);
        listItem.setItemNumIid(numIid);
        if (exclude) {
            listItem.setStatus(InventoryConstants.LIST_STATUS_EXCLUDED);
        } else {
            listItem.setStatus(InventoryConstants.LIST_STATUS_WAITING_ADJUST);
        }
        inventoryListItemMapper.updateByUserIdAndNumIid(listItem);

        InventoryListSetting setting = inventoryListSettingMapper.selectByUserId(userId);
        String excludeItemNumIidsStr = setting.getExcludeItemNumIids();
        excludeItemNumIidsStr = (null == excludeItemNumIidsStr ? "" : excludeItemNumIidsStr);
        List<Long> excludeNumIids = Collections3.getLongList(excludeItemNumIidsStr);
        if (exclude) {
            excludeNumIids.add(numIid);
        } else {
            excludeNumIids.remove(numIid);
        }

        InventoryListSetting updateSetting = new InventoryListSetting();
        updateSetting.setId(setting.getId());
        updateSetting.setExcludeItemNumIids(Collections3.COMMA_JOINER.join(excludeNumIids));
        inventoryListSettingMapper.updateByPrimaryKeySelective(updateSetting);
    }

    public Map<String, Long> getInventoryItemNum(Long userId) throws TaobaoSessionExpiredException, TaobaoAccessControlException, TaobaoEnhancedApiException {
        return taobaoApiShopService.getInventoryItemNum(userId, ImmutableList.of(InventoryConstants
                .BANNER_REGULAR_SHELVED, InventoryConstants.BANNER_NEVER_ON_SHELF));
    }
}
