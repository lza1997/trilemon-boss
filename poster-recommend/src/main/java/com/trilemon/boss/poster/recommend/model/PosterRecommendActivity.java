package com.trilemon.boss.poster.recommend.model;

import java.util.Date;

public class PosterRecommendActivity {
    private Long id;

    private Long userId;

    private Long templateId;

    private String title;

    private String color;

    private Integer size;

    private Byte detailPagePosition;

    private String publishHtml;

    private Byte status;

    private Date publishTime;

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

    public Long getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Byte getDetailPagePosition() {
        return detailPagePosition;
    }

    public void setDetailPagePosition(Byte detailPagePosition) {
        this.detailPagePosition = detailPagePosition;
    }

    public String getPublishHtml() {
        return publishHtml;
    }

    public void setPublishHtml(String publishHtml) {
        this.publishHtml = publishHtml == null ? null : publishHtml.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
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