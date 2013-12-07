package com.trilemon.boss.poster.recommend.model;

import java.util.Date;

public class PosterRecommendActivityLog {
    private Long id;

    private Long userId;

    private Long activityId;

    private Long templateId;

    private Integer itemNum;

    private Integer itemSuccessfulNum;

    private Integer itemFailedNum;

    private Byte type;

    private Byte status;

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

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public Integer getItemSuccessfulNum() {
        return itemSuccessfulNum;
    }

    public void setItemSuccessfulNum(Integer itemSuccessfulNum) {
        this.itemSuccessfulNum = itemSuccessfulNum;
    }

    public Integer getItemFailedNum() {
        return itemFailedNum;
    }

    public void setItemFailedNum(Integer itemFailedNum) {
        this.itemFailedNum = itemFailedNum;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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