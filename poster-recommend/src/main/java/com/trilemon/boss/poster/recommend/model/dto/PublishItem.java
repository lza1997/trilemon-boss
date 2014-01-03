package com.trilemon.boss.poster.recommend.model.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.taobao.api.domain.Item;

import java.util.Map;

/**
 * @author kevin
 */
public class PublishItem {
    private byte publishItemStatus;//后台投放宝贝投放状态
    private Item item;

    public PublishItem() {

    }

    @JsonCreator
    public PublishItem(Map<String, Object> map) {
        Item item = new Item();
        item.setNumIid((Long) map.get("numIid"));
        item.setPicUrl((String) map.get("picUrl"));
        item.setTitle((String) map.get("title"));
        item.setPrice((String) map.get("price"));

        setItem(item);
    }


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
