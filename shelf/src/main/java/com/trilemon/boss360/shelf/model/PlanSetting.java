package com.trilemon.boss360.shelf.model;

import java.util.Date;

public class PlanSetting {
    private Long id;

    private Long userId;

    private String name;

    private String namePinyin;

    private Boolean planType;

    private Boolean adjustShowcase;

    private String excludeKeywords;

    private String excludeItemIids;

    private String includeCids;

    private String includeKeywords;

    private String includeItemIids;

    private String adjustIntervals;

    private Boolean adjustIntervalsType;

    private Integer status;

    private Integer lastAdjustItemNum;

    private Date lastAdjustTime;

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

    public Boolean getPlanType() {
        return planType;
    }

    public void setPlanType(Boolean planType) {
        this.planType = planType;
    }

    public Boolean getAdjustShowcase() {
        return adjustShowcase;
    }

    public void setAdjustShowcase(Boolean adjustShowcase) {
        this.adjustShowcase = adjustShowcase;
    }

    public String getExcludeKeywords() {
        return excludeKeywords;
    }

    public void setExcludeKeywords(String excludeKeywords) {
        this.excludeKeywords = excludeKeywords == null ? null : excludeKeywords.trim();
    }

    public String getExcludeItemIids() {
        return excludeItemIids;
    }

    public void setExcludeItemIids(String excludeItemIids) {
        this.excludeItemIids = excludeItemIids == null ? null : excludeItemIids.trim();
    }

    public String getIncludeCids() {
        return includeCids;
    }

    public void setIncludeCids(String includeCids) {
        this.includeCids = includeCids == null ? null : includeCids.trim();
    }

    public String getIncludeKeywords() {
        return includeKeywords;
    }

    public void setIncludeKeywords(String includeKeywords) {
        this.includeKeywords = includeKeywords == null ? null : includeKeywords.trim();
    }

    public String getIncludeItemIids() {
        return includeItemIids;
    }

    public void setIncludeItemIids(String includeItemIids) {
        this.includeItemIids = includeItemIids == null ? null : includeItemIids.trim();
    }

    public String getAdjustIntervals() {
        return adjustIntervals;
    }

    public void setAdjustIntervals(String adjustIntervals) {
        this.adjustIntervals = adjustIntervals == null ? null : adjustIntervals.trim();
    }

    public Boolean getAdjustIntervalsType() {
        return adjustIntervalsType;
    }

    public void setAdjustIntervalsType(Boolean adjustIntervalsType) {
        this.adjustIntervalsType = adjustIntervalsType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLastAdjustItemNum() {
        return lastAdjustItemNum;
    }

    public void setLastAdjustItemNum(Integer lastAdjustItemNum) {
        this.lastAdjustItemNum = lastAdjustItemNum;
    }

    public Date getLastAdjustTime() {
        return lastAdjustTime;
    }

    public void setLastAdjustTime(Date lastAdjustTime) {
        this.lastAdjustTime = lastAdjustTime;
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