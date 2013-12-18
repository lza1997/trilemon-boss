package com.trilemon.boss.poster.recommend.model.dto;

import com.taobao.api.domain.Item;

/**
 * @author kevin
 */
public class PublishItem {
    public static final byte STATUS_NEW = 1;
    public static final byte STATUS_DELETED = 3;
    private byte status=STATUS_NEW;//前端用户操作赋予的状态

    private byte publishItemStatus;//后台投放宝贝投放状态
    private Item item;


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public byte getStatus() {
        return status;
    }

    public byte getPublishItemStatus() {
        return publishItemStatus;
    }

    public void setPublishItemStatus(byte publishItemStatus) {
        this.publishItemStatus = publishItemStatus;
    }

    public void setStatus(byte status) {
        this.status = status;
    }
}
