package com.trilemon.boss.poster.recommend.model;

import com.trilemon.boss.poster.recommend.model.dto.ActivityItem;
import com.trilemon.boss.poster.recommend.model.dto.PublishItem;
import com.trilemon.boss.poster.recommend.model.dto.PublishProgress;
import com.trilemon.boss.poster.template.model.PosterTemplate;
import com.trilemon.commons.db.ShardTable;

import java.util.Date;
import java.util.List;

public class PosterRecommendActivity extends ShardTable {
    private Long id;
    private Long userId;
    private Long templateId;
    private String title;
    private String color;//16进制颜色代码
    private Integer size;//750 790 950 990
    private Byte status;
    private Byte detailPagePosition;//详情页位置
    private String publishHtml;//发布到详情页的代码
    private String publishOwner;//发布的服务器
    private Date publishTime;//发布到详情页的时间
    private Date unpublishTime;//从详情页卸载的时间
    private String unpublishOwner;//卸载服务器
    private Byte publishType;//发布类型，一直还是定时
    private Date publishStartTime;//如果发布类型是定时，开始时间
    private Date publishEndTime;//如果发布类型是定时，结束时间
    private Date addTime;
    private Date updTime;

    //non db fields
    private int itemNum;//已经参加活动的宝贝数量，非数据库字段，供前台使用
    private PublishProgress publishProgress;//非数据库字段，投放的宝贝数量统计
    private List<ActivityItem> activityItems;//数据库海报宝贝
    private List<PublishItem> publishItems;//数据库投放宝贝
    private PosterTemplate template;//海报

    public PosterTemplate getTemplate() {
        return template;
    }

    public void setTemplate(PosterTemplate template) {
        this.template = template;
    }

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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public Byte getPublishType() {
        return publishType;
    }

    public void setPublishType(Byte publishType) {
        this.publishType = publishType;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public Date getPublishStartTime() {
        return publishStartTime;
    }

    public void setPublishStartTime(Date publishStartTime) {
        this.publishStartTime = publishStartTime;
    }

    public Date getPublishEndTime() {
        return publishEndTime;
    }

    public void setPublishEndTime(Date publishEndTime) {
        this.publishEndTime = publishEndTime;
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

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public PublishProgress getPublishProgress() {
        return publishProgress;
    }

    public void setPublishProgress(PublishProgress publishProgress) {
        this.publishProgress = publishProgress;
    }

    public Date getUnpublishTime() {
        return unpublishTime;
    }

    public void setUnpublishTime(Date unpublishTime) {
        this.unpublishTime = unpublishTime;
    }

    public String getPublishOwner() {
        return publishOwner;
    }

    public void setPublishOwner(String publishOwner) {
        this.publishOwner = publishOwner;
    }

    public String getUnpublishOwner() {
        return unpublishOwner;
    }

    public void setUnpublishOwner(String unpublishOwner) {
        this.unpublishOwner = unpublishOwner;
    }

    public List<ActivityItem> getActivityItems() {
        return activityItems;
    }

    public void setActivityItems(List<ActivityItem> activityItems) {
        this.activityItems = activityItems;
    }

    public List<PublishItem> getPublishItems() {
        return publishItems;
    }

    public void setPublishItems(List<PublishItem> publishItems) {
        this.publishItems = publishItems;
    }
}