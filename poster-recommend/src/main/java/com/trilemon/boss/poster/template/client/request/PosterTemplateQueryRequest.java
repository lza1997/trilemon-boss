package com.trilemon.boss.poster.template.client.request;

import java.util.List;

/**
 * @author kevin
 */
public class PosterTemplateQueryRequest {
    private int slotNum;
    private List<String> tags;
    private List<String> categories;
    private List<String> topics;
    private List<String> festivals;
    private List<Byte> type;
    private Byte applyVersion;
    private Byte status;
    private String orderBy;
    private int pageNum;
    private int pageSize;

    public int getSlotNum() {
        return slotNum;
    }

    public void setSlotNum(int slotNum) {
        this.slotNum = slotNum;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public List<String> getFestivals() {
        return festivals;
    }

    public void setFestivals(List<String> festivals) {
        this.festivals = festivals;
    }

    public List<Byte> getType() {
        return type;
    }

    public void setType(List<Byte> type) {
        this.type = type;
    }

    public Byte getApplyVersion() {
        return applyVersion;
    }

    public void setApplyVersion(Byte applyVersion) {
        this.applyVersion = applyVersion;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
