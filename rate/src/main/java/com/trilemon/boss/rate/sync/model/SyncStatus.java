package com.trilemon.boss.rate.sync.model;

import java.util.Date;

public class SyncStatus {
    private Integer id;

    private Long userId;

    private Date rateStartTime;

    private Date lastRateStartTime;

    private Date lastRateEndTime;

    private Date lastRateSyncStartTime;

    private Date lastRateSyncEndTime;

    private Byte rateSyncStatus;

    private String rateSyncOwner;

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

    public Date getRateStartTime() {
        return rateStartTime;
    }

    public void setRateStartTime(Date rateStartTime) {
        this.rateStartTime = rateStartTime;
    }

    public Date getLastRateStartTime() {
        return lastRateStartTime;
    }

    public void setLastRateStartTime(Date lastRateStartTime) {
        this.lastRateStartTime = lastRateStartTime;
    }

    public Date getLastRateEndTime() {
        return lastRateEndTime;
    }

    public void setLastRateEndTime(Date lastRateEndTime) {
        this.lastRateEndTime = lastRateEndTime;
    }

    public Date getLastRateSyncStartTime() {
        return lastRateSyncStartTime;
    }

    public void setLastRateSyncStartTime(Date lastRateSyncStartTime) {
        this.lastRateSyncStartTime = lastRateSyncStartTime;
    }

    public Date getLastRateSyncEndTime() {
        return lastRateSyncEndTime;
    }

    public void setLastRateSyncEndTime(Date lastRateSyncEndTime) {
        this.lastRateSyncEndTime = lastRateSyncEndTime;
    }

    public Byte getRateSyncStatus() {
        return rateSyncStatus;
    }

    public void setRateSyncStatus(Byte rateSyncStatus) {
        this.rateSyncStatus = rateSyncStatus;
    }

    public String getRateSyncOwner() {
        return rateSyncOwner;
    }

    public void setRateSyncOwner(String rateSyncOwner) {
        this.rateSyncOwner = rateSyncOwner == null ? null : rateSyncOwner.trim();
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