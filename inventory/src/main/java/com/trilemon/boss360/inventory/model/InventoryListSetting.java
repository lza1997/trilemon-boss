package com.trilemon.boss360.inventory.model;

import java.util.Date;

public class InventoryListSetting {
    private Long id;

    private Long userId;

    private Byte includeInventoryType;

    private Byte autoAddNewItem;

    private String distribution;

    private Byte listType;

    private Integer listInterval;

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

    public Byte getIncludeInventoryType() {
        return includeInventoryType;
    }

    public void setIncludeInventoryType(Byte includeInventoryType) {
        this.includeInventoryType = includeInventoryType;
    }

    public Byte getAutoAddNewItem() {
        return autoAddNewItem;
    }

    public void setAutoAddNewItem(Byte autoAddNewItem) {
        this.autoAddNewItem = autoAddNewItem;
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

    public Integer getListInterval() {
        return listInterval;
    }

    public void setListInterval(Integer listInterval) {
        this.listInterval = listInterval;
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
}