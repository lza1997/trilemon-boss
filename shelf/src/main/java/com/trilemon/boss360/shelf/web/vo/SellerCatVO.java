package com.trilemon.boss360.shelf.web.vo;

import com.taobao.api.domain.SellerCat;

/**
 * @author kevin
 */
public class SellerCatVO extends SellerCat{
    private Long itemNum;
    private boolean isPlanned = false;

    public SellerCatVO(SellerCat sellerCat) {
        this.setCid(sellerCat.getCid());
        this.setCreated(sellerCat.getCreated());
        this.setModified(sellerCat.getModified());
        this.setName(sellerCat.getName());
        this.setParentCid(sellerCat.getParentCid());
        this.setPicUrl(sellerCat.getPicUrl());
        this.setSortOrder(sellerCat.getSortOrder());
        this.setType(sellerCat.getType());
    }

    public Long getItemNum() {
        return itemNum;
    }

    public void setItemNum(Long itemNum) {
        this.itemNum = itemNum;
    }

    public boolean isPlanned() {
        return isPlanned;
    }

    public void setPlanned(boolean planned) {
        isPlanned = planned;
    }
}
