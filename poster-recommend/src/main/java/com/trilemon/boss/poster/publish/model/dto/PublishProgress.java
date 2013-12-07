package com.trilemon.boss.poster.publish.model.dto;

/**
 * @author kevin
 */
public class PublishProgress {
    private int totalItemNum;
    private int publishedItemNum;
    private float progress;

    public int getTotalItemNum() {
        return totalItemNum;
    }

    public void setTotalItemNum(int totalItemNum) {
        this.totalItemNum = totalItemNum;
    }

    public int getPublishedItemNum() {
        return publishedItemNum;
    }

    public void setPublishedItemNum(int publishedItemNum) {
        this.publishedItemNum = publishedItemNum;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }
}
