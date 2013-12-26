package com.trilemon.boss.poster.recommend.model.dto;

import com.taobao.api.domain.Item;

/**
 * @author kevin
 */
public class PublishItem {
    private byte publishItemStatus;//后台投放宝贝投放状态
    private Item item;


    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public byte getPublishItemStatus() {
        return publishItemStatus;
    }

    public void setPublishItemStatus(byte publishItemStatus) {
        this.publishItemStatus = publishItemStatus;
    }
}
