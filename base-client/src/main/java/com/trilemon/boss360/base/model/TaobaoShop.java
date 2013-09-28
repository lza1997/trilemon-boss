package com.trilemon.boss360.base.model;

import java.util.Date;

public class TaobaoShop {
    private Long id;

    private Long userId;

    private Long cid;

    private String nick;

    private String title;

    private String description;

    private String bulletin;

    private String picPath;

    private Date created;

    private Date modified;

    private String shopScoreItemScore;

    private String shopScoreServiceScore;

    private String shopScoreDeliveryScore;

    private Long remainCount;

    private Long allCount;

    private Long usedCount;

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

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getBulletin() {
        return bulletin;
    }

    public void setBulletin(String bulletin) {
        this.bulletin = bulletin == null ? null : bulletin.trim();
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath == null ? null : picPath.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getShopScoreItemScore() {
        return shopScoreItemScore;
    }

    public void setShopScoreItemScore(String shopScoreItemScore) {
        this.shopScoreItemScore = shopScoreItemScore == null ? null : shopScoreItemScore.trim();
    }

    public String getShopScoreServiceScore() {
        return shopScoreServiceScore;
    }

    public void setShopScoreServiceScore(String shopScoreServiceScore) {
        this.shopScoreServiceScore = shopScoreServiceScore == null ? null : shopScoreServiceScore.trim();
    }

    public String getShopScoreDeliveryScore() {
        return shopScoreDeliveryScore;
    }

    public void setShopScoreDeliveryScore(String shopScoreDeliveryScore) {
        this.shopScoreDeliveryScore = shopScoreDeliveryScore == null ? null : shopScoreDeliveryScore.trim();
    }

    public Long getRemainCount() {
        return remainCount;
    }

    public void setRemainCount(Long remainCount) {
        this.remainCount = remainCount;
    }

    public Long getAllCount() {
        return allCount;
    }

    public void setAllCount(Long allCount) {
        this.allCount = allCount;
    }

    public Long getUsedCount() {
        return usedCount;
    }

    public void setUsedCount(Long usedCount) {
        this.usedCount = usedCount;
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