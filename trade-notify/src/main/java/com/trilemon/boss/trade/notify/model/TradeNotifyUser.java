package com.trilemon.boss.trade.notify.model;

import java.util.Date;

public class TradeNotifyUser {
    private Long id;

    private Long userId;

    private Boolean enableDeliverNotify;

    private Boolean enableDelayDeliverNotify;

    private Boolean enableArriveNotify;

    private Boolean enableConfirmNotify;

    private Boolean enablePayNotify;

    private Boolean enableRefundNotify;

    private Integer receiveNotifyDay;

    private Integer enableSameCityArriveNotify;

    private Integer delayDeliverNotifyHour;

    private Integer payNotifyHour;

    private String sendTimeLimit;

    private Date lastDeliverSyncTime;

    private Date lastConfirmSyncTime;

    private Date lastRefundSyncTime;

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

    public Boolean getEnableDeliverNotify() {
        return enableDeliverNotify;
    }

    public void setEnableDeliverNotify(Boolean enableDeliverNotify) {
        this.enableDeliverNotify = enableDeliverNotify;
    }

    public Boolean getEnableDelayDeliverNotify() {
        return enableDelayDeliverNotify;
    }

    public void setEnableDelayDeliverNotify(Boolean enableDelayDeliverNotify) {
        this.enableDelayDeliverNotify = enableDelayDeliverNotify;
    }

    public Boolean getEnableArriveNotify() {
        return enableArriveNotify;
    }

    public void setEnableArriveNotify(Boolean enableArriveNotify) {
        this.enableArriveNotify = enableArriveNotify;
    }

    public Boolean getEnableConfirmNotify() {
        return enableConfirmNotify;
    }

    public void setEnableConfirmNotify(Boolean enableConfirmNotify) {
        this.enableConfirmNotify = enableConfirmNotify;
    }

    public Boolean getEnablePayNotify() {
        return enablePayNotify;
    }

    public void setEnablePayNotify(Boolean enablePayNotify) {
        this.enablePayNotify = enablePayNotify;
    }

    public Boolean getEnableRefundNotify() {
        return enableRefundNotify;
    }

    public void setEnableRefundNotify(Boolean enableRefundNotify) {
        this.enableRefundNotify = enableRefundNotify;
    }

    public Integer getReceiveNotifyDay() {
        return receiveNotifyDay;
    }

    public void setReceiveNotifyDay(Integer receiveNotifyDay) {
        this.receiveNotifyDay = receiveNotifyDay;
    }

    public Integer getEnableSameCityArriveNotify() {
        return enableSameCityArriveNotify;
    }

    public void setEnableSameCityArriveNotify(Integer enableSameCityArriveNotify) {
        this.enableSameCityArriveNotify = enableSameCityArriveNotify;
    }

    public Integer getDelayDeliverNotifyHour() {
        return delayDeliverNotifyHour;
    }

    public void setDelayDeliverNotifyHour(Integer delayDeliverNotifyHour) {
        this.delayDeliverNotifyHour = delayDeliverNotifyHour;
    }

    public Integer getPayNotifyHour() {
        return payNotifyHour;
    }

    public void setPayNotifyHour(Integer payNotifyHour) {
        this.payNotifyHour = payNotifyHour;
    }

    public String getSendTimeLimit() {
        return sendTimeLimit;
    }

    public void setSendTimeLimit(String sendTimeLimit) {
        this.sendTimeLimit = sendTimeLimit == null ? null : sendTimeLimit.trim();
    }

    public Date getLastDeliverSyncTime() {
        return lastDeliverSyncTime;
    }

    public void setLastDeliverSyncTime(Date lastDeliverSyncTime) {
        this.lastDeliverSyncTime = lastDeliverSyncTime;
    }

    public Date getLastConfirmSyncTime() {
        return lastConfirmSyncTime;
    }

    public void setLastConfirmSyncTime(Date lastConfirmSyncTime) {
        this.lastConfirmSyncTime = lastConfirmSyncTime;
    }

    public Date getLastRefundSyncTime() {
        return lastRefundSyncTime;
    }

    public void setLastRefundSyncTime(Date lastRefundSyncTime) {
        this.lastRefundSyncTime = lastRefundSyncTime;
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