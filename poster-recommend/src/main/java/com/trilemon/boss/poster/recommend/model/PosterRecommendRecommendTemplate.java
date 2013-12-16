package com.trilemon.boss.poster.recommend.model;

import java.util.Date;

public class PosterRecommendRecommendTemplate{
    private Long id;

    private String title;

    private Byte recommendType;

    private Long templateId;

    private Date recommendStartTime;

    private Date recommendEndTime;

    private Byte status;

    private Date addTime;

    private Date updTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Byte getRecommendType() {
        return recommendType;
    }

    public void setRecommendType(Byte recommendType) {
        this.recommendType = recommendType;
    }

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public Date getRecommendStartTime() {
        return recommendStartTime;
    }

    public void setRecommendStartTime(Date recommendStartTime) {
        this.recommendStartTime = recommendStartTime;
    }

    public Date getRecommendEndTime() {
        return recommendEndTime;
    }

    public void setRecommendEndTime(Date recommendEndTime) {
        this.recommendEndTime = recommendEndTime;
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