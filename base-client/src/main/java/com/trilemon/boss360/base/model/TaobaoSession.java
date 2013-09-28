package com.trilemon.boss360.base.model;

import java.util.Date;

public class TaobaoSession {
    private Integer id;

    private Long shopId;

    private Integer appId;

    private String sessionKey;

    private String sign;

    private Date ts;

    private Byte iframe;

    private Long visitorId;

    private String visitorNick;

    private Integer expiresIn;

    private String refreshToken;

    private Integer reExpiresIn;

    private Long subVisitorId;

    private String subTaobaoUserNick;

    private Integer r1ExpiresIn;

    private Integer w1ExpiresIn;

    private Integer r2ExpiresIn;

    private Integer w2ExpiresIn;

    private Date addTime;

    private Date updTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey == null ? null : sessionKey.trim();
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public Byte getIframe() {
        return iframe;
    }

    public void setIframe(Byte iframe) {
        this.iframe = iframe;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public String getVisitorNick() {
        return visitorNick;
    }

    public void setVisitorNick(String visitorNick) {
        this.visitorNick = visitorNick == null ? null : visitorNick.trim();
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken == null ? null : refreshToken.trim();
    }

    public Integer getReExpiresIn() {
        return reExpiresIn;
    }

    public void setReExpiresIn(Integer reExpiresIn) {
        this.reExpiresIn = reExpiresIn;
    }

    public Long getSubVisitorId() {
        return subVisitorId;
    }

    public void setSubVisitorId(Long subVisitorId) {
        this.subVisitorId = subVisitorId;
    }

    public String getSubTaobaoUserNick() {
        return subTaobaoUserNick;
    }

    public void setSubTaobaoUserNick(String subTaobaoUserNick) {
        this.subTaobaoUserNick = subTaobaoUserNick == null ? null : subTaobaoUserNick.trim();
    }

    public Integer getR1ExpiresIn() {
        return r1ExpiresIn;
    }

    public void setR1ExpiresIn(Integer r1ExpiresIn) {
        this.r1ExpiresIn = r1ExpiresIn;
    }

    public Integer getW1ExpiresIn() {
        return w1ExpiresIn;
    }

    public void setW1ExpiresIn(Integer w1ExpiresIn) {
        this.w1ExpiresIn = w1ExpiresIn;
    }

    public Integer getR2ExpiresIn() {
        return r2ExpiresIn;
    }

    public void setR2ExpiresIn(Integer r2ExpiresIn) {
        this.r2ExpiresIn = r2ExpiresIn;
    }

    public Integer getW2ExpiresIn() {
        return w2ExpiresIn;
    }

    public void setW2ExpiresIn(Integer w2ExpiresIn) {
        this.w2ExpiresIn = w2ExpiresIn;
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