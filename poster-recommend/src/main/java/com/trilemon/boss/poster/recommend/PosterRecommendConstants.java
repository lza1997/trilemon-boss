package com.trilemon.boss.poster.recommend;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author kevin
 */
public interface PosterRecommendConstants {
    //活动状态
    byte ACTIVITY_STATUS_DESIGNED = 0;//设计完毕
    byte ACTIVITY_STATUS_PUBLISH_SETTING_DONE = 1;//投放设置完毕
    byte ACTIVITY_STATUS_PUBLISHING = 2;//正在投放
    byte ACTIVITY_STATUS_PUBLISHED = 3;//投放完毕
    byte ACTIVITY_STATUS_PUBLISHED_WITH_ERROR = 4;//投放完毕，但是某些宝贝投放有错
    List<Byte> ALL_ACTIVITY_STATUS = Lists.newArrayList(ACTIVITY_STATUS_DESIGNED,
            ACTIVITY_STATUS_PUBLISH_SETTING_DONE,
            ACTIVITY_STATUS_PUBLISHING,
            ACTIVITY_STATUS_PUBLISHED,
            ACTIVITY_STATUS_PUBLISHED_WITH_ERROR);
    //投放类型
    byte PUBLISH_TYPE_ALWAYS = 0;//一直投放
    byte PUBLISH_TYPE_ASSIGN_TIME = 1;//选定时间内投放
    //海报宝贝状态，正常
    byte ACTIVITY_ITEM_STATUS_NORMAL = 0;
    //参与投放宝贝状态
    byte PUBLISH_ITEM_STATUS_WAITING_PUBLISH = 0;//待投放
    byte PUBLISH_ITEM_STATUS_PUBLISHED_SUCCESSFULLY = 1;//投放完毕
    byte PUBLISH_ITEM_STATUS_PUBLISHED_FAILED = 2;//投放完毕，但是失败
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
    //海报推荐类型
    byte RECOMMEND_TYPE_FESTIVAL = 1;
    // 详情页备份表状态
    byte DETAIL_PAGE_STATUS_NORMAL = 0;//正常
    //查询宝贝排序
    String API_ITEM_GET_ORDER_BY_MODIFIED_ASC = "modified:asc";
    String API_ITEM_GET_ORDER_BY_MODIFIED_DESC = "modified:desc";

}
