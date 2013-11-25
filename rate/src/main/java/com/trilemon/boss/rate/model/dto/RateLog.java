package com.trilemon.boss.rate.model.dto;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * @author kevin
 */
public class RateLog {
    private int tradeNum;
    private int orderNum;
    private int insertedRateOrderNum;
    private int day14RateNum;
    private int day15RateNum;
    private int goodRateNum;
    private int neutralRateNum;
    private int badRateNum;
    private Multiset<Byte> filterTradeNum = HashMultiset.create();

    public int getDay14RateNum() {
        return day14RateNum;
    }

    public void setDay14RateNum(int day14RateNum) {
        this.day14RateNum = day14RateNum;
    }

    public int getDay15RateNum() {
        return day15RateNum;
    }

    public void setDay15RateNum(int day15RateNum) {
        this.day15RateNum = day15RateNum;
    }

    public int getGoodRateNum() {
        return goodRateNum;
    }

    public void setGoodRateNum(int goodRateNum) {
        this.goodRateNum = goodRateNum;
    }

    public int getNeutralRateNum() {
        return neutralRateNum;
    }

    public void setNeutralRateNum(int neutralRateNum) {
        this.neutralRateNum = neutralRateNum;
    }

    public int getBadRateNum() {
        return badRateNum;
    }

    public void setBadRateNum(int badRateNum) {
        this.badRateNum = badRateNum;
    }

    public int getTradeNum() {
        return tradeNum;
    }

    public void setTradeNum(int tradeNum) {
        this.tradeNum = tradeNum;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public Multiset getFilterTradeNum() {
        return filterTradeNum;
    }

    public void setFilterTradeNum(Multiset filterTradeNum) {
        this.filterTradeNum = filterTradeNum;
    }

    public int getInsertedRateOrderNum() {
        return insertedRateOrderNum;
    }

    public void setInsertedRateOrderNum(int insertedRateOrderNum) {
        this.insertedRateOrderNum = insertedRateOrderNum;
    }

    public void incrFilterTradeNum(byte filterType) {
        filterTradeNum.add(filterType);
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
        Multiset<Byte> filterTradeNum = HashMultiset.create();
        filterTradeNum.addAll(this.getFilterTradeNum());
        filterTradeNum.addAll(other.getFilterTradeNum());
        rateLog.setFilterTradeNum(filterTradeNum);
        return rateLog;
    }
}
