package com.trilemon.boss.rate.model;

import com.trilemon.commons.db.ShardTable;

import java.io.Serializable;
import java.util.Date;

public class RateFilterTrade extends ShardTable implements Serializable {
    private Long id;

    private Long userId;

    private String buyerNick;

    private Long tid;

    private Boolean isSellerRate;

    private Boolean isBuyerRate;

    private Byte status;

    private Byte filterType;

    private Date filterTime;

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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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