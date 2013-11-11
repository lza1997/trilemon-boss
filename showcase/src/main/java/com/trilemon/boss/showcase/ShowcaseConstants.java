package com.trilemon.boss.showcase;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * @author kevin
 */
public interface ShowcaseConstants {
    List<String> ITEM_FIELDS = ImmutableList.of("num_iid", "has_showcase", "title", "pic_url", "seller_cids", "num");
    List<String> INVENTORY_BANNER_TYPES = ImmutableList.of("for_shelved");
    byte NOT_HAS_SHOWCASE = 0;
    byte HAS_SHOWCASE = 1;
    byte RULE_TYPE_INCLUDE_SELLER_CIDS = 1;
    byte SETTING_ON_SALE = 1;
    byte SETTING_INVENTORY = 2;
    String ASC_ORDER_BY_DELIST_TIME = "delist_time:asc";
    String DESC_ORDER_BY_DELIST_TIME = "delist_time:desc";

    // 规则是否开启，顾焱是傻逼
    byte SETTING_STATUS_PAUSED = 1;
    byte SETTING_STATUS_RUNNING = 2;

    byte ITEM_SHOWCASE = 1;//一般规则
    byte ITEM_EXCLUDE = 2;//不推荐
    byte ITEM_INCLUDE = 3;//固定推荐
}
