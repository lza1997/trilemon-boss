package com.trilemon.boss.poster.template.client.request;

import java.util.List;

/**
 * @author kevin
 */
public class PosterTemplateQueryRequest {
    private int slotNum;
    private List<Integer> categoryIds;
    private List<Integer> topicIds;
    private List<Integer> festivalIds;
    private List<Byte> typeList;
    private Byte applyVersion;
    private List<Byte> statusList;
    private String orderBy;
    private int pageNum;
    private int pageSize;

    public int getSlotNum() {
        return slotNum;
    }

    public void setSlotNum(int slotNum) {
        this.slotNum = slotNum;
    }

    public List<Integer> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }

    public List<Integer> getTopicIds() {
        return topicIds;
    }

    public void setTopicIds(List<Integer> topicIds) {
        this.topicIds = topicIds;
    }

    public List<Integer> getFestivalIds() {
        return festivalIds;
    }

    public void setFestivalIds(List<Integer> festivalIds) {
        this.festivalIds = festivalIds;
    }

    public List<Byte> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<Byte> typeList) {
        this.typeList = typeList;
    }

    public Byte getApplyVersion() {
        return applyVersion;
    }

    public void setApplyVersion(Byte applyVersion) {
        this.applyVersion = applyVersion;
    }

    public List<Byte> getStatusList() {
        return statusList;
    }

    public void setStatusList(List<Byte> statusList) {
        this.statusList = statusList;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
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

    public int getOffset() {
        return (pageNum - 1) * pageSize;
    }

    public int getLimit() {
        return pageSize;
    }
}
