package com.trilemon.boss.poster.recommend.model.dto;

import com.taobao.api.domain.Item;

/**
 * @author kevin
 */
public class PublishItem {
    private boolean published;
    private Item item;

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
