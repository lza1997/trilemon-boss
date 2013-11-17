package com.trilemon.boss.inventory.model;

import java.util.Date;

public class InventoryListSetting {
    private Long id;

    private Long userId;

    //仓库类型
    private String includeInventoryTypes;

    private Byte autoAddNewItem;

    private String distribution;

    //调整规则类型，均匀还是间隔
    private Byte listType;

    //调整间隔时间
    private Integer listInterval;

    //上一次执行时间
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

    public String getIncludeInventoryTypes() {
        return includeInventoryTypes;
    }

    public void setIncludeInventoryTypes(String includeInventoryTypes) {
        this.includeInventoryTypes = includeInventoryTypes == null ? null : includeInventoryTypes.trim();
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