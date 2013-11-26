package com.trilemon.boss.inventory.model;

import com.trilemon.boss.inventory.InventoryConstants;

import java.util.Date;

public class InventoryListSetting {
    private Long id;

    private Long userId;

    private String includeSellerCids;

    private String includeBanners;

    private String excludeItemNumIids;

    private Byte autoAddNewItem;

    private Byte status = InventoryConstants.SETTING_STATUS_EMPTY;

    private String distribution;

    private Byte listType;

    private Date lastPlanTime;

    private Date addTime;

    private Date updTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getIncludeSellerCids() {
        return includeSellerCids;
    }

    public void setIncludeSellerCids(String includeSellerCids) {
        this.includeSellerCids = includeSellerCids == null ? null : includeSellerCids.trim();
    }

    public String getIncludeBanners() {
        return includeBanners;
    }

    public void setIncludeBanners(String includeBanners) {
        this.includeBanners = includeBanners == null ? null : includeBanners.trim();
    }

    public String getExcludeItemNumIids() {
        return excludeItemNumIids;
    }

    public void setExcludeItemNumIids(String excludeItemNumIids) {
        this.excludeItemNumIids = excludeItemNumIids == null ? null : excludeItemNumIids.trim();
    }

    public Byte getAutoAddNewItem() {
        return autoAddNewItem;
    }

    public void setAutoAddNewItem(Byte autoAddNewItem) {
        this.autoAddNewItem = autoAddNewItem;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution == null ? null : distribution.trim();
    }

    public Byte getListType() {
        return listType;
    }

    public void setListType(Byte listType) {
        this.listType = listType;
    }

    public Date getLastPlanTime() {
        return lastPlanTime;
    }

    public void setLastPlanTime(Date lastPlanTime) {
        this.lastPlanTime = lastPlanTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public boolean isEmpty() {
        return InventoryConstants.SETTING_STATUS_EMPTY == this.getStatus();
    }

    public boolean isPaused() {
        return InventoryConstants.SETTING_STATUS_PAUSED == this.getStatus();
    }
}