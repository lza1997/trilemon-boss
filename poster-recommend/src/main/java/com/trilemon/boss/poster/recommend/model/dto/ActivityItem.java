package com.trilemon.boss.poster.recommend.model.dto;

import com.taobao.api.domain.Item;

/**
 * @author kevin
 */
public class ActivityItem {
    private boolean added;
    private Item item;

    public boolean isAdded() {
        return added;
    }

    public void setAdded(boolean added) {
        this.added = added;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
