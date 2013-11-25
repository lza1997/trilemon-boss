package com.trilemon.boss.rate.sync.model;

import com.alibaba.cobarclient.ShardTable;

public class CalcMemberDayRate  extends ShardTable {
    private Long id;

    private Integer userId;

    private String buyerNick;

    private Integer goodRateNum;

    private Integer neutralRateNum;

    private Integer badRateNum;

    private Integer calTime;

    private Integer addTime;

    private Integer updTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick == null ? null : buyerNick.trim();
    }

    public Integer getGoodRateNum() {
        return goodRateNum;
    }

    public void setGoodRateNum(Integer goodRateNum) {
        this.goodRateNum = goodRateNum;
    }

    public Integer getNeutralRateNum() {
        return neutralRateNum;
    }

    public void setNeutralRateNum(Integer neutralRateNum) {
        this.neutralRateNum = neutralRateNum;
    }

    public Integer getBadRateNum() {
        return badRateNum;
    }

    public void setBadRateNum(Integer badRateNum) {
        this.badRateNum = badRateNum;
    }

    public Integer getCalTime() {
        return calTime;
    }

    public void setCalTime(Integer calTime) {
        this.calTime = calTime;
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