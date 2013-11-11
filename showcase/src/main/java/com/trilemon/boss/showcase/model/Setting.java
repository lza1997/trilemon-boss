package com.trilemon.boss.showcase.model;

import java.math.BigDecimal;
import java.util.Date;

public class Setting implements Comparable<Setting>{
    private Integer id;

    private Long userId;

    private Byte status;

    private Byte ruleType;

    private Integer includeMinSaleVolume;

    private Integer includeMaxSaleVolume;

    private BigDecimal includeMinPrice;

    private BigDecimal includeMaxPrice;

    private String includeKeywords;

    private String includeSellerCids;

    private String includeItemNumIids;

    private String excludeItemNumIids;

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
        this.includeKeywords = includeKeywords == null ? null : includeKeywords.trim();
    }

    public String getIncludeSellerCids() {
        return includeSellerCids;
    }

    public void setIncludeSellerCids(String includeSellerCids) {
        this.includeSellerCids = includeSellerCids == null ? null : includeSellerCids.trim();
    }

    public String getIncludeItemNumIids() {
        return includeItemNumIids;
    }

    public void setIncludeItemNumIids(String includeItemNumIids) {
        this.includeItemNumIids = includeItemNumIids == null ? null : includeItemNumIids.trim();
    }

    public String getExcludeItemNumIids() {
        return excludeItemNumIids;
    }

    public void setExcludeItemNumIids(String excludeItemNumIids) {
        this.excludeItemNumIids = excludeItemNumIids == null ? null : excludeItemNumIids.trim();
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
    @Override
    public int compareTo(Setting o) {
        return (int) (o.getUpdTime().getTime() - this.getUpdTime().getTime());
    }
}