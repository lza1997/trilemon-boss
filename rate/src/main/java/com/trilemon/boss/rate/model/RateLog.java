package com.trilemon.boss.rate.model;

import com.trilemon.boss.rate.RateConstants;
import com.trilemon.commons.db.ShardTable;

import java.util.Date;

public class RateLog extends ShardTable {
    private Long id;
    private Long userId;
    private Integer tradeNum;
    private Integer orderNum;
    private Integer insertedRateOrderNum;
    private Integer day14RateNum;
    private Integer day15RateNum;
    private Integer goodRateNum;
    private Integer neutralRateNum;
    private Integer badRateNum;
    private Integer filteredCreditTradeNum;
    private Integer filteredRegisterDayTradeNum;
    private Integer filteredGoodRateTradeNum;
    private Integer filteredBadRateTradeNum;
    private Integer filteredBlacklistTradeNum;
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

    public Integer getTradeNum() {
        return tradeNum;
    }

    public void setTradeNum(Integer tradeNum) {
        this.tradeNum = tradeNum;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Integer getInsertedRateOrderNum() {
        return insertedRateOrderNum;
    }

    public void setInsertedRateOrderNum(Integer insertedRateOrderNum) {
        this.insertedRateOrderNum = insertedRateOrderNum;
    }

    public Integer getDay14RateNum() {
        return day14RateNum;
    }

    public void setDay14RateNum(Integer day14RateNum) {
        this.day14RateNum = day14RateNum;
    }

    public Integer getDay15RateNum() {
        return day15RateNum;
    }

    public void setDay15RateNum(Integer day15RateNum) {
        this.day15RateNum = day15RateNum;
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

    public Integer getFilteredCreditTradeNum() {
        return filteredCreditTradeNum;
    }

    public void setFilteredCreditTradeNum(Integer filteredCreditTradeNum) {
        this.filteredCreditTradeNum = filteredCreditTradeNum;
    }

    public Integer getFilteredRegisterDayTradeNum() {
        return filteredRegisterDayTradeNum;
    }

    public void setFilteredRegisterDayTradeNum(Integer filteredRegisterDayTradeNum) {
        this.filteredRegisterDayTradeNum = filteredRegisterDayTradeNum;
    }

    public Integer getFilteredGoodRateTradeNum() {
        return filteredGoodRateTradeNum;
    }

    public void setFilteredGoodRateTradeNum(Integer filteredGoodRateTradeNum) {
        this.filteredGoodRateTradeNum = filteredGoodRateTradeNum;
    }

    public Integer getFilteredBadRateTradeNum() {
        return filteredBadRateTradeNum;
    }

    public void setFilteredBadRateTradeNum(Integer filteredBadRateTradeNum) {
        this.filteredBadRateTradeNum = filteredBadRateTradeNum;
    }

    public Integer getFilteredBlacklistTradeNum() {
        return filteredBlacklistTradeNum;
    }

    public void setFilteredBlacklistTradeNum(Integer filteredBlacklistTradeNum) {
        this.filteredBlacklistTradeNum = filteredBlacklistTradeNum;
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

    public void incrFilteredTradeNum(byte filterType) {
        switch (filterType) {
            case RateConstants.RATE_FILTER_TYPE_CREDIT:
                filteredCreditTradeNum++;
            case RateConstants.RATE_FILTER_TYPE_REGISTER_DAY:
                filteredRegisterDayTradeNum++;
            case RateConstants.RATE_FILTER_TYPE_GOOD_RATE:
                filteredGoodRateTradeNum++;
            case RateConstants.RATE_FILTER_TYPE_BAD_RATE:
                filteredBadRateTradeNum++;
            case RateConstants.RATE_FILTER_TYPE_BLACKLIST:
                filteredBlacklistTradeNum++;
        }
    }

    public void incrTradeNum() {
        tradeNum++;
    }

    public void incrOrderNum() {
        orderNum++;
    }

    public void incrInsertedRateOrderNum(int num) {
        insertedRateOrderNum += num;
    }

    public void incrDay14RateNum() {
        day14RateNum++;
    }

    public void incrDay15RateNum() {
        day15RateNum++;
    }

    public void incrGoodRateNum() {
        goodRateNum++;
    }

    public void incrNeutralRateNum() {
        neutralRateNum++;
    }

    public void incrBadRateNum() {
        badRateNum++;
    }

    public RateLog combine(RateLog other) {
        RateLog rateLog = new RateLog();
        rateLog.setTradeNum(this.getTradeNum() + other.getTradeNum());
        rateLog.setOrderNum(this.getOrderNum() + other.getOrderNum());
        rateLog.setDay14RateNum(this.getDay14RateNum() + other.getDay14RateNum());
        rateLog.setDay15RateNum(this.getDay15RateNum() + other.getDay15RateNum());
        rateLog.setBadRateNum(this.getBadRateNum() + other.getBadRateNum());
        rateLog.setNeutralRateNum(this.getNeutralRateNum() + other.getNeutralRateNum());
        rateLog.setGoodRateNum(this.getGoodRateNum() + other.getGoodRateNum());

        rateLog.setFilteredCreditTradeNum(other.getFilteredCreditTradeNum() + getFilteredCreditTradeNum());
        rateLog.setFilteredRegisterDayTradeNum(other.getFilteredRegisterDayTradeNum() + getFilteredRegisterDayTradeNum());
        rateLog.setFilteredGoodRateTradeNum(other.getFilteredGoodRateTradeNum() + getFilteredGoodRateTradeNum());
        rateLog.setFilteredBadRateTradeNum(other.getFilteredBadRateTradeNum() + getFilteredBadRateTradeNum());
        rateLog.setFilteredBlacklistTradeNum(other.getFilteredBlacklistTradeNum() + getFilteredBlacklistTradeNum());
        return rateLog;
    }
}