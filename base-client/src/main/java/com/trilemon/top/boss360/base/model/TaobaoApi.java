package com.trilemon.top.boss360.base.model;

import java.util.Date;

public class TaobaoApi {
    private Integer id;

    private String servicename;

    private Long serviceip;

    private String tapbapAppKey;

    private String apiName;

    private Long successfulCall;

    private Long failedCall;

    private Integer avgExecTime;

    private Date addTime;

    private Date updTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename == null ? null : servicename.trim();
    }

    public Long getServiceip() {
        return serviceip;
    }

    public void setServiceip(Long serviceip) {
        this.serviceip = serviceip;
    }

    public String getTapbapAppKey() {
        return tapbapAppKey;
    }

    public void setTapbapAppKey(String tapbapAppKey) {
        this.tapbapAppKey = tapbapAppKey == null ? null : tapbapAppKey.trim();
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName == null ? null : apiName.trim();
    }

    public Long getSuccessfulCall() {
        return successfulCall;
    }

    public void setSuccessfulCall(Long successfulCall) {
        this.successfulCall = successfulCall;
    }

    public Long getFailedCall() {
        return failedCall;
    }

    public void setFailedCall(Long failedCall) {
        this.failedCall = failedCall;
    }

    public Integer getAvgExecTime() {
        return avgExecTime;
    }

    public void setAvgExecTime(Integer avgExecTime) {
        this.avgExecTime = avgExecTime;
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