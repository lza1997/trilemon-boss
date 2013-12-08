package com.trilemon.boss.poster.recommend.model;

import java.math.BigDecimal;
import java.util.Date;

public class PosterRecommendActivityItem {
    private Long id;

    private Long userId;

    private Long activityId;

    private Long itemNumIid;

    private String itemTitle;

    private BigDecimal itemPrice;

    private String itemPicUrl;

    private Byte templateSequenceIndex;

    private String templateCopy;

    private Byte status;

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

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
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

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemPicUrl() {
        return itemPicUrl;
    }

    public void setItemPicUrl(String itemPicUrl) {
        this.itemPicUrl = itemPicUrl == null ? null : itemPicUrl.trim();
    }

    public Byte getTemplateSequenceIndex() {
        return templateSequenceIndex;
    }

    public void setTemplateSequenceIndex(Byte templateSequenceIndex) {
        this.templateSequenceIndex = templateSequenceIndex;
    }

    public String getTemplateCopy() {
        return templateCopy;
    }

    public void setTemplateCopy(String templateCopy) {
        this.templateCopy = templateCopy == null ? null : templateCopy.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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