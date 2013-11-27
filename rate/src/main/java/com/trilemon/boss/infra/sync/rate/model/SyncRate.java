package com.trilemon.boss.infra.sync.rate.model;

import com.trilemon.commons.db.ShardTable;

import java.util.Date;

public class SyncRate extends ShardTable {
    private Long id;

    private Long userId;

    private Long numIid;

    private Boolean validScore;

    private Long tid;

    private Long oid;

    private String role;

    private String nick;

    private String result;

    private Date created;

    private String ratedNick;

    private String itemTitle;

    private String itemPrice;

    private String content;

    private String reply;

    private Date addTime;

    private Date updTime;

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

    public Long getNumIid() {
        return numIid;
    }

    public void setNumIid(Long numIid) {
        this.numIid = numIid;
    }

    public Boolean getValidScore() {
        return validScore;
    }

    public void setValidScore(Boolean validScore) {
        this.validScore = validScore;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick == null ? null : nick.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getRatedNick() {
        return ratedNick;
    }

    public void setRatedNick(String ratedNick) {
        this.ratedNick = ratedNick == null ? null : ratedNick.trim();
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle == null ? null : itemTitle.trim();
    }

    public String getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice == null ? null : itemPrice.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
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