package com.trilemon.boss360.shelf.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Plan {
    @JsonProperty
    private Long id;

    private Long planSettingId;

    private Long userId;

    private Long itemNumIid;

    private Boolean isNewItem;

    private Long itemSellerCid;

    private String itemTitle;

    private String itemTitlePinyin;

    private String itemPicUrl;

    private Byte status;

    private Date planAdjustTime;

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

    public Boolean getIsNewItem() {
        return isNewItem;
    }

    public void setIsNewItem(Boolean isNewItem) {
        this.isNewItem = isNewItem;
    }

    public Long getItemSellerCid() {
        return itemSellerCid;
    }

    public void setItemSellerCid(Long itemSellerCid) {
        this.itemSellerCid = itemSellerCid;
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

    public Date getPlanAdjustTime() {
        return planAdjustTime;
    }

    public void setPlanAdjustTime(Date planAdjustTime) {
        this.planAdjustTime = planAdjustTime;
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
}