package com.trilemon.boss360.base.model;

import java.util.Date;

public class TaobaoApi {
    private Integer id;

    private String serviceName;

    private String serviceId;

    private String taobaoAppKey;

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

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public String getTaobaoAppKey() {
        return taobaoAppKey;
    }

    public void setTaobaoAppKey(String taobaoAppKey) {
        this.taobaoAppKey = taobaoAppKey == null ? null : taobaoAppKey.trim();
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