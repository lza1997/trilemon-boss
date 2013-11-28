package com.trilemon.boss.infra.sync.rate.client;

import java.util.Date;
import java.util.List;

/**
 * @author kevin
 */
public class RatePageRequest {
    public static final String ORDER_BY_CREATED_ASC = "created ASC";
    public static final String ORDER_BY_CREATED_DESC = "created DESC";
    private Long userId;
    private Long tid;
    private String buyerNick;
    //good neutral bad
    private List<String> rateType;
    private Date startDate;
    private Date endDate;
    private Integer pageNum;
    private Integer pageSize;
    private String order = ORDER_BY_CREATED_DESC;
    private int offset;
    private int limit;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getBuyerNick() {
        return buyerNick;
    }

    public void setBuyerNick(String buyerNick) {
        this.buyerNick = buyerNick;
    }

    public List<String> getRateType() {
        return rateType;
    }

    public void setRateType(List<String> rateType) {
        this.rateType = rateType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public int getOffset() {
        return (pageNum - 1) * pageSize;
    }

    public int getLimit() {
        return pageSize;
    }
}
