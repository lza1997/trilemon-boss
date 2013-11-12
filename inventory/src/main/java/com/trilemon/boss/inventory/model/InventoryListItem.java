package com.trilemon.boss.inventory.model;

import java.util.Date;

public class InventoryListItem {
    private Long id;

    private Long inventoryListSettingId;

    private Long userId;

    private Long itemNumIid;

    private String itemTitle;

    private String itemTitlePinyin;

    private String itemPicUrl;

    private Date planListDay;

    private Date planListStartTime;

    private Date planListEndTime;

    private Date listTime;

    private Date addTime;

    private Date updTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInventoryListSettingId() {
        return inventoryListSettingId;
    }

    public void setInventoryListSettingId(Long inventoryListSettingId) {
        this.inventoryListSettingId = inventoryListSettingId;
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

    public Date getPlanListDay() {
        return planListDay;
    }

    public void setPlanListDay(Date planListDay) {
        this.planListDay = planListDay;
    }

    public Date getPlanListStartTime() {
        return planListStartTime;
    }

    public void setPlanListStartTime(Date planListStartTime) {
        this.planListStartTime = planListStartTime;
    }

    public Date getPlanListEndTime() {
        return planListEndTime;
    }

    public void setPlanListEndTime(Date planListEndTime) {
        this.planListEndTime = planListEndTime;
    }

    public Date getListTime() {
        return listTime;
    }

    public void setListTime(Date listTime) {
        this.listTime = listTime;
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