package com.trilemon.boss.inventory;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * @author kevin
 */
public interface InventoryConstants {
    List<String> ITEM_FIELDS = ImmutableList.of("num_iid", "delist_time", "title", "pic_url", "seller_cids");
    //banner type
    String BANNER_REGULAR_SHELVED = "regular_shelved";
    String BANNER_NEVER_ON_SHELF = "never_on_shelf";
    String BANNER_OFF_SHELF = "off_shelf";
    String BANNER_FOR_SHELVED = "for_shelved";
    String BANNER_SOLD_OUT = "sold_out";
    String BANNER_VIOLATION_OFF_SHELF = "violation_off_shelf";
    //list type
    byte LIST_TYPE_AVG = 1;
    //list status
    byte LIST_STATUS_WAITING_ADJUST = 0;
    byte LIST_STATUS_SUCCESSFUL = 1;
    byte LIST_STATUS_FAILED = 2;
    byte LIST_STATUS_EXCLUDED = 3;
    //setting status
    byte SETTING_STATUS_EMPTY = -1;  // 并非数据库的状态
    byte SETTING_STATUS_WAITING_PLAN = 0;
    byte SETTING_STATUS_RUNNING = 1;
    byte SETTING_STATUS_PAUSED = 2;
    //auto add new item
    byte SETTING_AUTO_ADD_NEW_ITEM_OFF = 0;
    byte SETTING_AUTO_ADD_NEW_ITEM_ON = 1;
}
