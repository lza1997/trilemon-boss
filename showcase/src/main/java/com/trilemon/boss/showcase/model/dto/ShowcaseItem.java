package com.trilemon.boss.showcase.model.dto;

import com.taobao.api.domain.Item;
import com.trilemon.boss.showcase.ShowcaseConstants;

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

    public boolean isExclude() {
        return this.getStatus() == ShowcaseConstants.ITEM_EXCLUDE;
    }

    public boolean isInclude() {
        return this.getStatus() == ShowcaseConstants.ITEM_INCLUDE;
    }
}
