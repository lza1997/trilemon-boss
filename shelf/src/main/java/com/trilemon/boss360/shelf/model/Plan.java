package com.trilemon.boss360.shelf.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

public class Plan {
    private Long id;
    private Long planSettingId;
    private Long userId;
    private Long itemNumIid;
    private String itemTitle;
    private String itemTitlePinyin;
    private String itemPicUrl;
    private Byte status;
    private String failedCause;
    private Date planAdjustDay;
    private Date planAdjustStartTime;
    private Date planAdjustEndTime;
    private Date adjustTime;
    private Date addTime;
    private Date updTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlanSettingId() {
        return planSettingId;
    }

    public void setPlanSettingId(Long planSettingId) {
        this.planSettingId = planSettingId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getItemNumIid() {
        return itemNumIid;
    }

    public void setItemNumIid(Long itemNumIid) {
        this.itemNumIid = itemNumIid;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle == null ? null : itemTitle.trim();
    }

    public String getItemTitlePinyin() {
        return itemTitlePinyin;
    }

    public void setItemTitlePinyin(String itemTitlePinyin) {
        this.itemTitlePinyin = itemTitlePinyin == null ? null : itemTitlePinyin.trim();
    }

    public String getItemPicUrl() {
        return itemPicUrl;
    }

    public void setItemPicUrl(String itemPicUrl) {
        this.itemPicUrl = itemPicUrl == null ? null : itemPicUrl.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getFailedCause() {
        return failedCause;
    }

    public void setFailedCause(String failedCause) {
        this.failedCause = failedCause == null ? null : failedCause.trim();
    }

    public Date getPlanAdjustDay() {
        return planAdjustDay;
    }

    public void setPlanAdjustDay(Date planAdjustDay) {
        this.planAdjustDay = planAdjustDay;
    }

    public Date getPlanAdjustStartTime() {
        return planAdjustStartTime;
    }

    public void setPlanAdjustStartTime(Date planAdjustStartTime) {
        this.planAdjustStartTime = planAdjustStartTime;
    }

    public Date getPlanAdjustEndTime() {
        return planAdjustEndTime;
    }

    public void setPlanAdjustEndTime(Date planAdjustEndTime) {
        this.planAdjustEndTime = planAdjustEndTime;
    }

    public Date getAdjustTime() {
        return adjustTime;
    }

    public void setAdjustTime(Date adjustTime) {
        this.adjustTime = adjustTime;
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

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}