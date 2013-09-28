package com.trilemon.top.boss360.base.model;

import java.util.Date;

public class TaobaoApp {
    private Integer id;

    private String name;

    private String articleCode;

    private String appSecret;

    private String appKey;

    private String sandboxAppKey;

    private String sandboxAppSecret;

    private String appCallbackUrl;

    private String appExtraCallbackUrl;

    private Date addTime;

    private Date updTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getArticleCode() {
        return articleCode;
    }

    public void setArticleCode(String articleCode) {
        this.articleCode = articleCode == null ? null : articleCode.trim();
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret == null ? null : appSecret.trim();
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey == null ? null : appKey.trim();
    }

    public String getSandboxAppKey() {
        return sandboxAppKey;
    }

    public void setSandboxAppKey(String sandboxAppKey) {
        this.sandboxAppKey = sandboxAppKey == null ? null : sandboxAppKey.trim();
    }

    public String getSandboxAppSecret() {
        return sandboxAppSecret;
    }

    public void setSandboxAppSecret(String sandboxAppSecret) {
        this.sandboxAppSecret = sandboxAppSecret == null ? null : sandboxAppSecret.trim();
    }

    public String getAppCallbackUrl() {
        return appCallbackUrl;
    }

    public void setAppCallbackUrl(String appCallbackUrl) {
        this.appCallbackUrl = appCallbackUrl == null ? null : appCallbackUrl.trim();
    }

    public String getAppExtraCallbackUrl() {
        return appExtraCallbackUrl;
    }

    public void setAppExtraCallbackUrl(String appExtraCallbackUrl) {
        this.appExtraCallbackUrl = appExtraCallbackUrl == null ? null : appExtraCallbackUrl.trim();
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