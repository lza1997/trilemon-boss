package com.trilemon.boss360.shelf.model;

import java.util.Date;

public class PlanSetting {
    private Long id;

    private Long userId;

    private String name;

    private String namePinyin;

    private Boolean adjustShowcase;

    private String excludeItemIids;

    private String includeCids;

    private String intervals;

    private Byte intervalsType;

    private Byte status;

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

    public Boolean getAdjustShowcase() {
        return adjustShowcase;
    }

    public void setAdjustShowcase(Boolean adjustShowcase) {
        this.adjustShowcase = adjustShowcase;
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

    public String getIntervals() {
        return intervals;
    }

    public void setIntervals(String intervals) {
        this.intervals = intervals == null ? null : intervals.trim();
    }

    public Byte getIntervalsType() {
        return intervalsType;
    }

    public void setIntervalsType(Byte intervalsType) {
        this.intervalsType = intervalsType;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
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