package com.trilemon.boss.poster.recommend;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * @author kevin
 */
public interface PosterRecommendConstants {
    //模板自定义文案的 key，原价
    String TEMPLATE_COPY_KEY_ORIGINAL_PRICE = "original_price";
    //活动状态
    byte ACTIVITY_STATUS_WAITING_PUBLISH = 0;//等待投放
    byte ACTIVITY_STATUS_PUBLISHING = 1;//正在投放
    byte ACTIVITY_STATUS_PUBLISHED = 2;//投放完毕
    byte ACTIVITY_STATUS_PUBLISHED_WITH_ERROR = 3;//投放完毕，但是有错
    //海报宝贝状态，正常
    byte ACTIVITY_ITEM_STATUS_NORMAL = 0;
    //参与投放宝贝状态
    byte PUBLISH_ITEM_STATUS_WAITING_PUBLISH = 0;//待投放
    byte PUBLISH_ITEM_STATUS_PUBLISHED = 1;//投放完毕
    byte PUBLISH_ITEM_STATUS_PUBLISH_FAILED = 2;//投放完毕
    //宝贝推荐用户状态，正常
    byte USER_STATUS_NORMAL = 0;
    //on sale item field
    List<String> ITEM_FIELDS = ImmutableList.of("num_iid", "price", "title", "pic_url");
    //banner type
    String BANNER_REGULAR_SHELVED = "regular_shelved";
    String BANNER_NEVER_ON_SHELF = "never_on_shelf";
    String BANNER_OFF_SHELF = "off_shelf";
    String BANNER_FOR_SHELVED = "for_shelved";
    String BANNER_SOLD_OUT = "sold_out";
    String BANNER_VIOLATION_OFF_SHELF = "violation_off_shelf";
}
