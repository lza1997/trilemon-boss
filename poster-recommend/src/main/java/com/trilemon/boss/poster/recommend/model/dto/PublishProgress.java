package com.trilemon.boss.poster.recommend.model.dto;

/**
 * @author kevin
 */
public class PublishProgress {
    private int waitingPublishItemNum;
    private int publishedSuccessfullyItemNum;
    private int publishedFailedItemNum;

    public int getWaitingPublishItemNum() {
        return waitingPublishItemNum;
    }

    public void setWaitingPublishItemNum(int waitingPublishItemNum) {
        this.waitingPublishItemNum = waitingPublishItemNum;
    }

    public int getPublishedSuccessfullyItemNum() {
        return publishedSuccessfullyItemNum;
    }

    public void setPublishedSuccessfullyItemNum(int publishedSuccessfullyItemNum) {
        this.publishedSuccessfullyItemNum = publishedSuccessfullyItemNum;
    }

    public int getPublishedFailedItemNum() {
        return publishedFailedItemNum;
    }

    public void setPublishedFailedItemNum(int publishedFailedItemNum) {
        this.publishedFailedItemNum = publishedFailedItemNum;
    }

    public int getPublishedItemNum() {
        return publishedSuccessfullyItemNum + publishedFailedItemNum;
    }

    public boolean isFinished() {
        return waitingPublishItemNum == 0;
    }

    /**
     * 返回百分比，95%返回0.95
     * @return
     */
    public float getProgress() {
        int total = waitingPublishItemNum + publishedSuccessfullyItemNum + publishedFailedItemNum;
        if (total == 0) {
            return 0;
        } else {
            return (getPublishedItemNum() * 1f) /
                    (waitingPublishItemNum + publishedSuccessfullyItemNum + publishedFailedItemNum);
        }
    }
}
