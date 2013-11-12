package com.trilemon.boss.showcase.model;

import java.util.Date;

public class AdjustDetail {
    private Integer id;

    private Long userId;

    private Long itemNumIid;

    private String itemTitle;

    private String itemTitlePinyin;

    private String itemPicUrl;

    //调整类型，上架/下架
    private Byte adjustType;

    private Date adjustTime;

    private Date addTime;

    private Date updTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Byte getAdjustType() {
        return adjustType;
    }

    public void setAdjustType(Byte adjustType) {
        this.adjustType = adjustType;
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