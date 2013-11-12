package com.trilemon.boss.shelf.model.dto;

/**
 * @author kevin
 */
public class PlanStatus {
    private int itemNum; // 宝贝数量
    private int newItemNum; // 新上架宝贝数量
    private int waitAdjustItemNum; // 待调整宝贝数量

    public int getItemNum() {
        return itemNum;
    }

    public void setItemNum(int itemNum) {
        this.itemNum = itemNum;
    }

    public int getNewItemNum() {
        return newItemNum;
    }

    public void setNewItemNum(int newItemNum) {
        this.newItemNum = newItemNum;
    }

    public int getWaitAdjustItemNum() {
        return waitAdjustItemNum;
    }

    public void setWaitAdjustItemNum(int waitAdjustItemNum) {
        this.waitAdjustItemNum = waitAdjustItemNum;
    }
}
