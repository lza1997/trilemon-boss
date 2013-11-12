package com.trilemon.boss.rate.model.dto;

/**
 * @author kevin
 */
public class RateSyncStatus {
    private Long userId;
    private String buyerNick;
    private int goodRateNum;
    private int neutralRateNum;
    private int badRateNum;

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
        this.buyerNick = buyerNick;
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
}
