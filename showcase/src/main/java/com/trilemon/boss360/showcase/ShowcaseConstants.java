package com.trilemon.boss360.showcase;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * @author kevin
 */
public interface ShowcaseConstants {
    List<String> ITEM_FIELDS = ImmutableList.of("num_iid", "delist_time", "title", "pic_url", "seller_cids");
    byte NOT_HAS_SHOWCASE = 0;
    byte HAS_SHOWCASE = 1;
    byte RULE_TYPE_INCLUDE_SELLER_CIDS = 1;
    Byte SETTING_STATUS_PAUSE = 1;
    Byte SETTING_STATUS_RUNNING = 2;
}
