package com.trilemon.boss.inventory;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * @author kevin
 */
public interface InventoryConstants {
    List<String> ITEM_FIELDS = ImmutableList.of("num_iid", "delist_time", "title", "pic_url", "seller_cids");
    //banner type
    String REGULAR_SHELVED = "regular_shelved";
    String NEVER_ON_SHELF = "never_on_shelf";
    String OFF_SHELF = "off_shelf";
    String FOR_SHELVED = "for_shelved";
    String SOLD_OUT = "sold_out";
    String VIOLATION_OFF_SHELF = "violation_off_shelf";
    //list type
    byte LIST_TYPE_AVG = 1;
    byte LIST_TYPE_INTERVAL = 2;
    //list status
    byte LIST_STATUS_WAITING_ADJUST = 0;
    byte LIST_STATUS_SUCCESSFUL = 1;
    byte LIST_STATUS_FAILED = 2;
    byte LIST_STATUS_EXCLUDED = 3;
}
