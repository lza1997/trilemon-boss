package com.trilemon.boss.poster.recommend.model.dto;

import com.taobao.api.domain.Item;

/**
 * @author kevin
 */
public class ActivityItem {
    public static final byte STATUS_NEW = 1;
    public static final byte STATUS_UPDATED = 2;
    public static final byte STATUS_DELETED = 3;
    private byte status = STATUS_NEW;//前端用户操作赋予的状态
    private byte activityItemStatus;//后台数据库表状态
    private String itemOriginalPrice; // 原价
    private Item item;

    public ActivityItem() {

    }

    public ActivityItem(Long itemId, String itemOriginalPrice) {
        Item item = new Item();
        item.setNumIid(itemId);
        setItem(item);
        setItemOriginalPrice(itemOriginalPrice);
    }

    public String getItemOriginalPrice() {
        return itemOriginalPrice;
    }

    public void setItemOriginalPrice(String itemOriginalPrice) {
        this.itemOriginalPrice = itemOriginalPrice;
    }

    public byte getActivityItemStatus() {
        return activityItemStatus;
    }

    public void setActivityItemStatus(byte activityItemStatus) {
        this.activityItemStatus = activityItemStatus;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
