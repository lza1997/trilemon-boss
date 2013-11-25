package com.trilemon.boss.rate.sync.model;

import java.util.Date;

public class SyncStatus {
    private Integer id;

    private Long userId;

    private Byte rateSyncStatus;

    private Date rateSyncStartTime;

    private Date rateSyncEndTime;

    private Date rateStartTime;

    private Date rateEndTime;

    private Date updTime;

    private Date addTime;

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

    public Byte getRateSyncStatus() {
        return rateSyncStatus;
    }

    public void setRateSyncStatus(Byte rateSyncStatus) {
        this.rateSyncStatus = rateSyncStatus;
    }

    public Date getRateSyncStartTime() {
        return rateSyncStartTime;
    }

    public void setRateSyncStartTime(Date rateSyncStartTime) {
        this.rateSyncStartTime = rateSyncStartTime;
    }

    public Date getRateSyncEndTime() {
        return rateSyncEndTime;
    }

    public void setRateSyncEndTime(Date rateSyncEndTime) {
        this.rateSyncEndTime = rateSyncEndTime;
    }

    public Date getRateStartTime() {
        return rateStartTime;
    }

    public void setRateStartTime(Date rateStartTime) {
        this.rateStartTime = rateStartTime;
    }

    public Date getRateEndTime() {
        return rateEndTime;
    }

    public void setRateEndTime(Date rateEndTime) {
        this.rateEndTime = rateEndTime;
    }

    public Date getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Date updTime) {
        this.updTime = updTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}