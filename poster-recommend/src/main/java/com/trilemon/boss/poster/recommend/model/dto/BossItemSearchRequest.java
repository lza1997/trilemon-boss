package com.trilemon.boss.poster.recommend.model.dto;

import java.util.List;

/**
 * @author kevin
 */
public class BossItemSearchRequest {
    private Long userId;
    private String query;
    private boolean onSale;
    private float price;
    private String sort;
    private List<Long> sellerCids;
    private int pageNum;
    private int pageSize;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale(boolean onSale) {
        this.onSale = onSale;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public List<Long> getSellerCids() {
        return sellerCids;
    }

    public void setSellerCids(List<Long> sellerCids) {
        this.sellerCids = sellerCids;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
