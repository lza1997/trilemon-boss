package com.trilemon.boss.rate.model;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RateSetting implements Serializable {
    private Long id;
    private Long userId;
    private Byte status;
    private Byte rateType;
    private Boolean autoGoodRate;
    private Boolean autoNeutralRate;
    private Boolean autoBadRate;
    private Boolean enableSmsNotify;
    private String smsNotifyPhone;
    private Boolean enableCreditFilter;
    private Integer creditFilterMin;
    private Integer creditFilterMax;
    private Boolean enableGoodRateFilter;
    private Float goodRateFilter;
    private Boolean enableBadRateFilter;
    private Float badRateFilter;
    private Boolean enableRegisterDayFilter;
    private Integer registerDayFilter;
    private Boolean enableBlacklistFilter;
    private Date lastRateStartTime;
    private Date lastRateEndTime;
    private Byte rateStatus;
    private String rateOwner;
    private Date addTime;
    private Date updTime;
    private List<String> blacklistBuyerNicks = Lists.newArrayList();

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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getRateType() {
        return rateType;
    }

    public void setRateType(Byte rateType) {
        this.rateType = rateType;
    }

    public Boolean getAutoGoodRate() {
        return autoGoodRate;
    }

    public void setAutoGoodRate(Boolean autoGoodRate) {
        this.autoGoodRate = autoGoodRate;
    }

    public Boolean getAutoNeutralRate() {
        return autoNeutralRate;
    }

    public void setAutoNeutralRate(Boolean autoNeutralRate) {
        this.autoNeutralRate = autoNeutralRate;
    }

    public Boolean getAutoBadRate() {
        return autoBadRate;
    }

    public void setAutoBadRate(Boolean autoBadRate) {
        this.autoBadRate = autoBadRate;
    }

    public Boolean getEnableSmsNotify() {
        return enableSmsNotify;
    }

    public void setEnableSmsNotify(Boolean enableSmsNotify) {
        this.enableSmsNotify = enableSmsNotify;
    }

    public String getSmsNotifyPhone() {
        return smsNotifyPhone;
    }

    public void setSmsNotifyPhone(String smsNotifyPhone) {
        this.smsNotifyPhone = smsNotifyPhone == null ? null : smsNotifyPhone.trim();
    }

    public Boolean getEnableCreditFilter() {
        return enableCreditFilter;
    }

    public void setEnableCreditFilter(Boolean enableCreditFilter) {
        this.enableCreditFilter = enableCreditFilter;
    }

    public Integer getCreditFilterMin() {
        return creditFilterMin;
    }

    public void setCreditFilterMin(Integer creditFilterMin) {
        this.creditFilterMin = creditFilterMin;
    }

    public Integer getCreditFilterMax() {
        return creditFilterMax;
    }

    public void setCreditFilterMax(Integer creditFilterMax) {
        this.creditFilterMax = creditFilterMax;
    }

    public Boolean getEnableGoodRateFilter() {
        return enableGoodRateFilter;
    }

    public void setEnableGoodRateFilter(Boolean enableGoodRateFilter) {
        this.enableGoodRateFilter = enableGoodRateFilter;
    }

    public Float getGoodRateFilter() {
        return goodRateFilter;
    }

    public void setGoodRateFilter(Float goodRateFilter) {
        this.goodRateFilter = goodRateFilter;
    }

    public Boolean getEnableBadRateFilter() {
        return enableBadRateFilter;
    }

    public void setEnableBadRateFilter(Boolean enableBadRateFilter) {
        this.enableBadRateFilter = enableBadRateFilter;
    }

    public Float getBadRateFilter() {
        return badRateFilter;
    }

    public void setBadRateFilter(Float badRateFilter) {
        this.badRateFilter = badRateFilter;
    }

    public Boolean getEnableRegisterDayFilter() {
        return enableRegisterDayFilter;
    }

    public void setEnableRegisterDayFilter(Boolean enableRegisterDayFilter) {
        this.enableRegisterDayFilter = enableRegisterDayFilter;
    }

    public Integer getRegisterDayFilter() {
        return registerDayFilter;
    }

    public void setRegisterDayFilter(Integer registerDayFilter) {
        this.registerDayFilter = registerDayFilter;
    }

    public Boolean getEnableBlacklistFilter() {
        return enableBlacklistFilter;
    }

    public void setEnableBlacklistFilter(Boolean enableBlacklistFilter) {
        this.enableBlacklistFilter = enableBlacklistFilter;
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

    public Byte getRateStatus() {
        return rateStatus;
    }

    public void setRateStatus(Byte rateStatus) {
        this.rateStatus = rateStatus;
    }

    public String getRateOwner() {
        return rateOwner;
    }

    public void setRateOwner(String rateOwner) {
        this.rateOwner = rateOwner == null ? null : rateOwner.trim();
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

    public List<String> getBlacklistBuyerNicks() {
        return blacklistBuyerNicks;
    }
}