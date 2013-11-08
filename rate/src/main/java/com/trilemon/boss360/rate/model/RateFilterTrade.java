package com.trilemon.boss360.rate.model;

import java.util.Date;

public class RateFilterTrade {
    private Long id;

    private Long userId;

    private Long itemNumIid;

    private Long buyerUserId;

    private String buyerNick;

    private Long tid;

    private Long oid;

    private Boolean isSellerRate;

    private Boolean isBuyerRate;

    private Byte filterType;

    private Date filterTime;

    private Date rateTime;

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

    public Long getItemNumIid() {
        return itemNumIid;
    }

    public void setItemNumIid(Long itemNumIid) {
        this.itemNumIid = itemNumIid;
    }

    public Long getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(Long buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick == null ? null : buyerNick.trim();
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Boolean getIsSellerRate() {
        return isSellerRate;
    }

    public void setIsSellerRate(Boolean isSellerRate) {
        this.isSellerRate = isSellerRate;
    }

    public Boolean getIsBuyerRate() {
        return isBuyerRate;
    }

    public void setIsBuyerRate(Boolean isBuyerRate) {
        this.isBuyerRate = isBuyerRate;
    }

    public Byte getFilterType() {
        return filterType;
    }

    public void setFilterType(Byte filterType) {
        this.filterType = filterType;
    }

    public Date getFilterTime() {
        return filterTime;
    }

    public void setFilterTime(Date filterTime) {
        this.filterTime = filterTime;
    }

    public Date getRateTime() {
        return rateTime;
    }

    public void setRateTime(Date rateTime) {
        this.rateTime = rateTime;
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