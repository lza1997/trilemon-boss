package com.trilemon.boss360.showcase.model;

import java.math.BigDecimal;
import java.util.Date;

public class Setting {
    private Integer id;

    private Long userId;

    private Byte status;

    private Byte ruleType;

    private Integer minSaleVolume;

    private Integer maxSaleVolume;

    private BigDecimal minPrice;

    private BigDecimal maxPrice;

    private String includeKeywords;

    private String includeSellerCids;

    private Integer includeItemNumIids;

    private Integer excludeItemDelistingWithin;

    private Integer excludeItemInventoryLt;

    private Integer excludeItemDelistingAfter;

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

    public Integer getMinSaleVolume() {
        return minSaleVolume;
    }

    public void setMinSaleVolume(Integer minSaleVolume) {
        this.minSaleVolume = minSaleVolume;
    }

    public Integer getMaxSaleVolume() {
        return maxSaleVolume;
    }

    public void setMaxSaleVolume(Integer maxSaleVolume) {
        this.maxSaleVolume = maxSaleVolume;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getIncludeKeywords() {
        return includeKeywords;
    }

    public void setIncludeKeywords(String includeKeywords) {
        this.includeKeywords = includeKeywords == null ? null : includeKeywords.trim();
    }

    public String getIncludeSellerCids() {
        return includeSellerCids;
    }

    public void setIncludeSellerCids(String includeSellerCids) {
        this.includeSellerCids = includeSellerCids == null ? null : includeSellerCids.trim();
    }

    public Integer getIncludeItemNumIids() {
        return includeItemNumIids;
    }

    public void setIncludeItemNumIids(Integer includeItemNumIids) {
        this.includeItemNumIids = includeItemNumIids;
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
}