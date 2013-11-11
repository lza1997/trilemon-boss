package com.trilemon.boss.showcase.model.dto;

import com.taobao.api.domain.Item;

/**
 * @author kevin
 */
public class ShowcaseItem {
    private byte status;
    private Item item;

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
