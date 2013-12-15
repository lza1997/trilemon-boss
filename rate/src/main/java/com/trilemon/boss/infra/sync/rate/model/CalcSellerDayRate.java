package com.trilemon.boss.infra.sync.rate.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.trilemon.commons.db.ShardTable;

import java.io.Serializable;
import java.util.Date;

public class CalcSellerDayRate extends ShardTable implements Serializable{
    @JsonIgnore
    private Long id;

    @JsonIgnore
    private Long userId;

    private Integer goodRateNum;

    private Integer neutralRateNum;

    private Integer badRateNum;

    private Date rateTime;

    @JsonIgnore
    private Date addTime;

    @JsonIgnore
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