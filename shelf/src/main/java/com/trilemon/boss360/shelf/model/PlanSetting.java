package com.trilemon.boss360.shelf.model;

import java.util.Date;

public class PlanSetting {
    private Long id;
    private Long userId;
    private String name;
    private String namePinyin;
    private String includeSellerCids;
    private Boolean autoAddNewItems;
    private String excludeItemNumIids;
    private String distribution;
    private Byte distributionType;
    private Byte status;
    private Date lastPlanTime;
    private Date addTime;
    private Date updTime;
    private int itemNum; // 宝贝数量
    private int newItemNum; // 新上架宝贝数量
    private int waitAdjustItemNum; // 待调整宝贝数量

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNamePinyin() {
        return namePinyin;
    }

    public void setNamePinyin(String namePinyin) {
        this.namePinyin = namePinyin == null ? null : namePinyin.trim();
    }

    public String getIncludeSellerCids() {
        return includeSellerCids;
    }

    public void setIncludeSellerCids(String includeSellerCids) {
        this.includeSellerCids = includeSellerCids == null ? null : includeSellerCids.trim();
    }

    public Boolean getAutoAddNewItems() {
        return autoAddNewItems;
    }

    public void setAutoAddNewItems(Boolean autoAddNewItems) {
        this.autoAddNewItems = autoAddNewItems;
    }

    public String getExcludeItemNumIids() {
        return excludeItemNumIids;
    }

    public void setExcludeItemNumIids(String excludeItemNumIids) {
        this.excludeItemNumIids = excludeItemNumIids == null ? null : excludeItemNumIids.trim();
    }

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
        this.distribution = distribution == null ? null : distribution.trim();
    }

    public Byte getDistributionType() {
        return distributionType;
    }

    public void setDistributionType(Byte distributionType) {
        this.distributionType = distributionType;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public int getNewItemNum() {
        return newItemNum;
    }

    public void setNewItemNum(int newItemNum) {
        this.newItemNum = newItemNum;
    }

    public int getWaitAdjustItemNum() {
        return waitAdjustItemNum;
    }

    public void setWaitAdjustItemNum(int waitAdjustItemNum) {
        this.waitAdjustItemNum = waitAdjustItemNum;
    }
}