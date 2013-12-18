package com.trilemon.boss.poster.template.model;

import java.util.Date;

public class PosterTemplate {
    private Long id;

    //预览类型，0图片还是 ；1 html 代码
    private Byte previewType;

    //预览图片地址
    private String previewPicUrl;

    //预览图片代码
    private String previewPicHtml;

    //模板代码
    private String templateFtl;

    //可以放置宝贝的数量
    private Integer slotNum;

    //支持的尺寸
    private String sizes;

    //支持的颜色
    private String colors;

    //文案的 key
    private String copyKeys;

    //类目，目前只存一个，当做单数使用
    private String categories;

    //主题，目前只存一个，当做单数使用
    private String topics;
    //节日，目前只存一个，当做单数使用
    private String festivals;

    //类型 参见常量TEMPLATE_TYPE_ITEM_RECOMMEND
    private Byte type;

    //使用次数
    private Integer useNum;

    //收藏次数
    private Integer favoriteNum;

    //喜欢次数
    private Integer likeNum;

    //哪些软件版本可以使用 暂时没有用到
    private Byte applyVersion;

    //状态 暂时没有用到
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

    public String getPreviewPicHtml() {
        return previewPicHtml;
    }

    public void setPreviewPicHtml(String previewPicHtml) {
        this.previewPicHtml = previewPicHtml == null ? null : previewPicHtml.trim();
    }

    public String getTemplateFtl() {
        return templateFtl;
    }

    public void setTemplateFtl(String templateFtl) {
        this.templateFtl = templateFtl == null ? null : templateFtl.trim();
    }
}