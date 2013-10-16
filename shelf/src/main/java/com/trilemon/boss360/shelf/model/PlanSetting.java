package com.trilemon.boss360.shelf.model;

import java.util.Date;

public class PlanSetting {
    private Long id;

    private Long userId;

    private String name;

    private String namePinyin;

    private String includeCids;

    private Boolean isAutoAddNewItems;

    private String excludeItemIids;

    private String distribution;

    private Byte distributionType;

    private String beforeAdjustDistribution;

    private Byte status;

    private Date nextPlanTime;

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

    public String getIncludeCids() {
        return includeCids;
    }

    public void setIncludeCids(String includeCids) {
        this.includeCids = includeCids == null ? null : includeCids.trim();
    }

    public Boolean getIsAutoAddNewItems() {
        return isAutoAddNewItems;
    }

    public void setIsAutoAddNewItems(Boolean isAutoAddNewItems) {
        this.isAutoAddNewItems = isAutoAddNewItems;
    }

    public String getExcludeItemIids() {
        return excludeItemIids;
    }

    public void setExcludeItemIids(String excludeItemIids) {
        this.excludeItemIids = excludeItemIids == null ? null : excludeItemIids.trim();
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

    public String getBeforeAdjustDistribution() {
        return beforeAdjustDistribution;
    }

    public void setBeforeAdjustDistribution(String beforeAdjustDistribution) {
        this.beforeAdjustDistribution = beforeAdjustDistribution == null ? null : beforeAdjustDistribution.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getNextPlanTime() {
        return nextPlanTime;
    }

    public void setNextPlanTime(Date nextPlanTime) {
        this.nextPlanTime = nextPlanTime;
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