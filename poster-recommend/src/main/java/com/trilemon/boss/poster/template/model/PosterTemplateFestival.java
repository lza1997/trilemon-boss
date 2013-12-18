package com.trilemon.boss.poster.template.model;

import java.util.Date;

public class PosterTemplateFestival {
    private Long id;

    private String name;

    private Byte calendar;

    private Byte festivalTimeType;

    private Date festivalFixTime;

    private String festivalDynamicTime;

    private Date addTime;

    private Date updTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getCalendar() {
        return calendar;
    }

    public void setCalendar(Byte calendar) {
        this.calendar = calendar;
    }

    public Byte getFestivalTimeType() {
        return festivalTimeType;
    }

    public void setFestivalTimeType(Byte festivalTimeType) {
        this.festivalTimeType = festivalTimeType;
    }

    public Date getFestivalFixTime() {
        return festivalFixTime;
    }

    public void setFestivalFixTime(Date festivalFixTime) {
        this.festivalFixTime = festivalFixTime;
    }

    public String getFestivalDynamicTime() {
        return festivalDynamicTime;
    }

    public void setFestivalDynamicTime(String festivalDynamicTime) {
        this.festivalDynamicTime = festivalDynamicTime == null ? null : festivalDynamicTime.trim();
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