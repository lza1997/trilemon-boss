package com.trilemon.top.boss360.shelf.model;

import java.util.Date;

public class Plan {
    private Integer id;

    private Integer planSettingId;

    private Integer userId;

    private Long itemIid;

    private Integer itemName;

    private Integer itemPicUrl;

    private Integer state;

    private Date planListingTime;

    private Integer listingTime;

    private Integer addTime;

    private Integer updTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlanSettingId() {
        return planSettingId;
    }

    public void setPlanSettingId(Integer planSettingId) {
        this.planSettingId = planSettingId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getItemIid() {
        return itemIid;
    }

    public void setItemIid(Long itemIid) {
        this.itemIid = itemIid;
    }

    public Integer getItemName() {
        return itemName;
    }

    public void setItemName(Integer itemName) {
        this.itemName = itemName;
    }

    public Integer getItemPicUrl() {
        return itemPicUrl;
    }

    public void setItemPicUrl(Integer itemPicUrl) {
        this.itemPicUrl = itemPicUrl;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getPlanListingTime() {
        return planListingTime;
    }

    public void setPlanListingTime(Date planListingTime) {
        this.planListingTime = planListingTime;
    }

    public Integer getListingTime() {
        return listingTime;
    }

    public void setListingTime(Integer listingTime) {
        this.listingTime = listingTime;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Integer updTime) {
        this.updTime = updTime;
    }
}