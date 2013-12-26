package com.trilemon.boss.poster.recommend.model.dto;

import com.taobao.api.domain.Item;

import java.util.Map;

/**
 * @author kevin
 */
public class ActivityItem {
    private byte activityItemStatus;//后台数据库表状态
    /**
     * 模板自定义列的值，参见 {@link com.trilemon.boss.poster.template.model.PosterTemplate#copyKeys}
     * 格式为 {key: value}
     */
    private Map<String, String> copy;
    private Item item;

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
