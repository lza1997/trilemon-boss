package com.trilemon.boss360.shelf.model;

import java.util.Date;

public class Plan {
    private Long id;

    private Long planSettingId;

    private Long userId;

    private Long itemIid;

    private String itemName;

    private String itemPicUrl;

    private Integer status;

    private Date planListingTime;

    private Date listingTime;

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

    public Long getItemIid() {
        return itemIid;
    }

    public void setItemIid(Long itemIid) {
        this.itemIid = itemIid;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getItemPicUrl() {
        return itemPicUrl;
    }

    public void setItemPicUrl(String itemPicUrl) {
        this.itemPicUrl = itemPicUrl == null ? null : itemPicUrl.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getPlanListingTime() {
        return planListingTime;
    }

    public void setPlanListingTime(Date planListingTime) {
        this.planListingTime = planListingTime;
    }

    public Date getListingTime() {
        return listingTime;
    }

    public void setListingTime(Date listingTime) {
        this.listingTime = listingTime;
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