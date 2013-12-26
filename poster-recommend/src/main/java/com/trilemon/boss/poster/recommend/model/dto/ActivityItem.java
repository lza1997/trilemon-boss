package com.trilemon.boss.poster.recommend.model.dto;

import com.taobao.api.domain.Item;

import java.util.Map;

/**
 * @author kevin
 */
public class ActivityItem {
    private byte activityItemStatus;//后台数据库表状态

    @Deprecated
    private String itemOriginalPrice; // 原价
    /**
     * 前端应该获取模板对象，通过里面的 copy key 字段出自定义文案的表格列（文案key常量见本类中的getCopyKeys()），然后通过copy map 传到后台；展现亦然
     */
    private Map<String, String> copy; // 文案，key ：文案 key，value：文案的内容
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Map<String, String> getCopy() {
        return copy;
    }

    public void setCopy(Map<String, String> copy) {
        this.copy = copy;
    }
}
