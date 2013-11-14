package com.trilemon.boss.showcase.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.trilemon.boss.showcase.ShowcaseConstants;

import java.math.BigDecimal;
import java.util.Date;

@JsonIgnoreProperties(value="id", ignoreUnknown = true)
public class Setting implements Comparable<Setting> {
    private Integer id;
    private Long userId;
    //是否开启橱窗
    private Byte status;
    //调整类型，现在固定只使用按照分类调整
    private Byte ruleType;
    //冗余字段
    private Integer includeMinSaleVolume;
    //冗余字段
    private Integer includeMaxSaleVolume;
    //冗余字段
    private BigDecimal includeMinPrice;
    //冗余字段
    private BigDecimal includeMaxPrice;
    //冗余字段
    private String includeKeywords;
    //调整分类，按照逗号隔开
    private String includeSellerCids;
    //固定橱窗宝贝，按照逗号隔开
    private String includeItemNumIids;
    //不推橱窗宝贝，按照逗号隔开
    private String excludeItemNumIids;
    //下架时间小于多少不推荐（单位分钟）
    private Integer excludeItemDelistingWithin;
    //库存小于多少不推荐
    private Integer excludeItemInventoryLt;
    //下架时间还剩大于几天不推荐（单位分钟）
    private Integer excludeItemDelistingAfter;
    private Boolean isExcludeItemDelistingWithin;
    private Boolean isExcludeItemInventoryLt;
    private Boolean isExcludeItemDelistingAfter;
    private Date addTime;
    private Date updTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Byte getRuleType() {
        return ruleType;
    }

    public void setRuleType(Byte ruleType) {
        this.ruleType = ruleType;
    }

    public Integer getIncludeMinSaleVolume() {
        return includeMinSaleVolume;
    }

    public void setIncludeMinSaleVolume(Integer includeMinSaleVolume) {
        this.includeMinSaleVolume = includeMinSaleVolume;
    }

    public Integer getIncludeMaxSaleVolume() {
        return includeMaxSaleVolume;
    }

    public void setIncludeMaxSaleVolume(Integer includeMaxSaleVolume) {
        this.includeMaxSaleVolume = includeMaxSaleVolume;
    }

    public BigDecimal getIncludeMinPrice() {
        return includeMinPrice;
    }

    public void setIncludeMinPrice(BigDecimal includeMinPrice) {
        this.includeMinPrice = includeMinPrice;
    }

    public BigDecimal getIncludeMaxPrice() {
        return includeMaxPrice;
    }

    public void setIncludeMaxPrice(BigDecimal includeMaxPrice) {
        this.includeMaxPrice = includeMaxPrice;
    }

    public String getIncludeKeywords() {
        return includeKeywords;
    }

    public void setIncludeKeywords(String includeKeywords) {
        this.includeKeywords = includeKeywords;
    }

    public String getIncludeSellerCids() {
        return includeSellerCids;
    }

    public void setIncludeSellerCids(String includeSellerCids) {
        this.includeSellerCids = includeSellerCids;
    }

    public String getIncludeItemNumIids() {
        return includeItemNumIids;
    }

    public void setIncludeItemNumIids(String includeItemNumIids) {
        this.includeItemNumIids = includeItemNumIids;
    }

    public String getExcludeItemNumIids() {
        return excludeItemNumIids;
    }

    public void setExcludeItemNumIids(String excludeItemNumIids) {
        this.excludeItemNumIids = excludeItemNumIids;
    }

    public Integer getExcludeItemDelistingWithin() {
        return excludeItemDelistingWithin;
    }

    public void setExcludeItemDelistingWithin(Integer excludeItemDelistingWithin) {
        this.excludeItemDelistingWithin = excludeItemDelistingWithin;
    }

    public Integer getExcludeItemInventoryLt() {
        return excludeItemInventoryLt;
    }

    public void setExcludeItemInventoryLt(Integer excludeItemInventoryLt) {
        this.excludeItemInventoryLt = excludeItemInventoryLt;
    }

    public Integer getExcludeItemDelistingAfter() {
        return excludeItemDelistingAfter;
    }

    public void setExcludeItemDelistingAfter(Integer excludeItemDelistingAfter) {
        this.excludeItemDelistingAfter = excludeItemDelistingAfter;
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

    public Boolean getIsExcludeItemDelistingAfter() {
        return isExcludeItemDelistingAfter;
    }

    public void setIsExcludeItemDelistingAfter(Boolean isExcludeItemDelistingAfter) {
        this.isExcludeItemDelistingAfter = isExcludeItemDelistingAfter;
    }

    public Boolean getIsExcludeItemInventoryLt() {
        return isExcludeItemInventoryLt;
    }

    public void setIsExcludeItemInventoryLt(Boolean isExcludeItemInventoryLt) {
        this.isExcludeItemInventoryLt = isExcludeItemInventoryLt;
    }

    public Boolean getIsExcludeItemDelistingWithin() {
        return isExcludeItemDelistingWithin;
    }

    public void setIsExcludeItemDelistingWithin(Boolean isExcludeItemDelistingWithin) {
        this.isExcludeItemDelistingWithin = isExcludeItemDelistingWithin;
    }

    public boolean isPaused() {
        return this.getStatus().equals(ShowcaseConstants.SETTING_STATUS_PAUSED);
    }

    @Override
    public int compareTo(Setting o) {
        return (int) (o.getUpdTime().getTime() - this.getUpdTime().getTime());
    }
}