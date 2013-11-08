package com.trilemon.boss360.rate.model;

import java.util.Date;

public class RateSetting {
    private Long id;

    private Long userId;

    private String nick;

    private Byte status;

    private Byte autoRate;

    private Byte notify;

    private String smsNotifyPhone;

    private Boolean isFilterCredit;

    private Integer filterCreditMin;

    private Integer filterCreditMax;

    private Float isFilterGoodRate;

    private Integer filterGoodRate;

    private Float isFilterBadRate;

    private Integer filterBadRateCount;

    private Boolean isFilterRegisterDay;

    private Integer filterRegisterDay;

    private Boolean isFilterBlacklist;

    private Date lastRateTime;

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

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getAutoRate() {
        return autoRate;
    }

    public void setAutoRate(Byte autoRate) {
        this.autoRate = autoRate;
    }

    public Byte getNotify() {
        return notify;
    }

    public void setNotify(Byte notify) {
        this.notify = notify;
    }

    public String getSmsNotifyPhone() {
        return smsNotifyPhone;
    }

    public void setSmsNotifyPhone(String smsNotifyPhone) {
        this.smsNotifyPhone = smsNotifyPhone == null ? null : smsNotifyPhone.trim();
    }

    public Boolean getIsFilterCredit() {
        return isFilterCredit;
    }

    public void setIsFilterCredit(Boolean isFilterCredit) {
        this.isFilterCredit = isFilterCredit;
    }

    public Integer getFilterCreditMin() {
        return filterCreditMin;
    }

    public void setFilterCreditMin(Integer filterCreditMin) {
        this.filterCreditMin = filterCreditMin;
    }

    public Integer getFilterCreditMax() {
        return filterCreditMax;
    }

    public void setFilterCreditMax(Integer filterCreditMax) {
        this.filterCreditMax = filterCreditMax;
    }

    public Float getIsFilterGoodRate() {
        return isFilterGoodRate;
    }

    public void setIsFilterGoodRate(Float isFilterGoodRate) {
        this.isFilterGoodRate = isFilterGoodRate;
    }

    public Integer getFilterGoodRate() {
        return filterGoodRate;
    }

    public void setFilterGoodRate(Integer filterGoodRate) {
        this.filterGoodRate = filterGoodRate;
    }

    public Float getIsFilterBadRate() {
        return isFilterBadRate;
    }

    public void setIsFilterBadRate(Float isFilterBadRate) {
        this.isFilterBadRate = isFilterBadRate;
    }

    public Integer getFilterBadRateCount() {
        return filterBadRateCount;
    }

    public void setFilterBadRateCount(Integer filterBadRateCount) {
        this.filterBadRateCount = filterBadRateCount;
    }

    public Boolean getIsFilterRegisterDay() {
        return isFilterRegisterDay;
    }

    public void setIsFilterRegisterDay(Boolean isFilterRegisterDay) {
        this.isFilterRegisterDay = isFilterRegisterDay;
    }

    public Integer getFilterRegisterDay() {
        return filterRegisterDay;
    }

    public void setFilterRegisterDay(Integer filterRegisterDay) {
        this.filterRegisterDay = filterRegisterDay;
    }

    public Boolean getIsFilterBlacklist() {
        return isFilterBlacklist;
    }

    public void setIsFilterBlacklist(Boolean isFilterBlacklist) {
        this.isFilterBlacklist = isFilterBlacklist;
    }

    public Date getLastRateTime() {
        return lastRateTime;
    }

    public void setLastRateTime(Date lastRateTime) {
        this.lastRateTime = lastRateTime;
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