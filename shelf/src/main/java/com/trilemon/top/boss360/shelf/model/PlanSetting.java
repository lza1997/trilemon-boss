package com.trilemon.top.boss360.shelf.model;

import com.sun.tools.javac.util.List;
import org.joda.time.DateTime;
import org.joda.time.Interval;

public class PlanSetting {
    private Integer id;
    private Integer userId;
    private Integer name;
    private Boolean isAuto;
    private Integer type;
    private Integer excludeKeywords;
    private Integer excludeItemIids;
    private Integer includeCids;
    private Integer includeKeywords;
    private Integer includeItemIids;
    private Integer addTime;
    private Integer updTime;
    private java.util.List<Interval> parsedAdjustPeriod;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Boolean getAuto() {
        return isAuto;
    }

    public void setAuto(Boolean auto) {
        isAuto = auto;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getExcludeKeywords() {
        return excludeKeywords;
    }

    public void setExcludeKeywords(Integer excludeKeywords) {
        this.excludeKeywords = excludeKeywords;
    }

    public Integer getExcludeItemIids() {
        return excludeItemIids;
    }

    public void setExcludeItemIids(Integer excludeItemIids) {
        this.excludeItemIids = excludeItemIids;
    }

    public Integer getIncludeCids() {
        return includeCids;
    }

    public void setIncludeCids(Integer includeCids) {
        this.includeCids = includeCids;
    }

    public Integer getIncludeKeywords() {
        return includeKeywords;
    }

    public void setIncludeKeywords(Integer includeKeywords) {
        this.includeKeywords = includeKeywords;
    }

    public Integer getIncludeItemIids() {
        return includeItemIids;
    }

    public void setIncludeItemIids(Integer includeItemIids) {
        this.includeItemIids = includeItemIids;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getUpdTime() {
        return updTime;
    }

    public void setUpdTime(Integer updTime) {
        this.updTime = updTime;
    }

    public List<DateTime> getParsedAdjustTime() {
       return null;
    }

    public java.util.List<Interval> getParsedAdjustPeriod() {
        return parsedAdjustPeriod;
    }
}