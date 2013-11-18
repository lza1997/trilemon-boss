package com.trilemon.boss.inventory.model.dto;

import com.taobao.api.domain.Item;

/**
 * @author kevin
 */
public class InventoryItem {
    private Item item;
    private byte status;
    private String banner;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }
}
