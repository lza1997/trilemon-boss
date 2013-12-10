package com.trilemon.boss.poster.template.model;

import java.util.Date;

public class PosterTemplate {
    private Long id;

    private Byte previewType;

    private String previewPicUrl;

    private String preivewPicHtml;

    private String templateFtl;

    private String templateItemFtl;

    private Integer slotNum;

    private String sizes;

    private String colors;

    private String copyKeys;

    private String categories;

    private String topics;

    private String festivals;

    private Byte type;

    private Integer useNum;

    private Integer favoriteNum;

    private Integer likeNum;

    private Byte applyVersion;

    private Byte status;

    private Date addTime;

    private Date updTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getPreviewType() {
        return previewType;
    }

    public void setPreviewType(Byte previewType) {
        this.previewType = previewType;
    }

    public String getPreviewPicUrl() {
        return previewPicUrl;
    }

    public void setPreviewPicUrl(String previewPicUrl) {
        this.previewPicUrl = previewPicUrl == null ? null : previewPicUrl.trim();
    }

    public String getPreivewPicHtml() {
        return preivewPicHtml;
    }

    public void setPreivewPicHtml(String preivewPicHtml) {
        this.preivewPicHtml = preivewPicHtml == null ? null : preivewPicHtml.trim();
    }

    public String getTemplateFtl() {
        return templateFtl;
    }

    public void setTemplateFtl(String templateFtl) {
        this.templateFtl = templateFtl == null ? null : templateFtl.trim();
    }

    public String getTemplateItemFtl() {
        return templateItemFtl;
    }

    public void setTemplateItemFtl(String templateItemFtl) {
        this.templateItemFtl = templateItemFtl == null ? null : templateItemFtl.trim();
    }

    public Integer getSlotNum() {
        return slotNum;
    }

    public void setSlotNum(Integer slotNum) {
        this.slotNum = slotNum;
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes == null ? null : sizes.trim();
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors == null ? null : colors.trim();
    }

    public String getCopyKeys() {
        return copyKeys;
    }

    public void setCopyKeys(String copyKeys) {
        this.copyKeys = copyKeys == null ? null : copyKeys.trim();
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories == null ? null : categories.trim();
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics == null ? null : topics.trim();
    }

    public String getFestivals() {
        return festivals;
    }

    public void setFestivals(String festivals) {
        this.festivals = festivals == null ? null : festivals.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getUseNum() {
        return useNum;
    }

    public void setUseNum(Integer useNum) {
        this.useNum = useNum;
    }

    public Integer getFavoriteNum() {
        return favoriteNum;
    }

    public void setFavoriteNum(Integer favoriteNum) {
        this.favoriteNum = favoriteNum;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Byte getApplyVersion() {
        return applyVersion;
    }

    public void setApplyVersion(Byte applyVersion) {
        this.applyVersion = applyVersion;
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