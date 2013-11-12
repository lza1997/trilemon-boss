package com.trilemon.boss.shelf.model.dto;

import java.util.List;

/**
 * @author kevin
 */
public class ShelfStatus {
    private List<Integer> dayOfWeek;
    private List<Integer> listItemNum;

    public List<Integer> getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(List<Integer> dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public List<Integer> getListItemNum() {
        return listItemNum;
    }

    public void setListItemNum(List<Integer> listItemNum) {
        this.listItemNum = listItemNum;
    }
}
