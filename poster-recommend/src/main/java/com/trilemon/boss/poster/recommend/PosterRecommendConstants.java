package com.trilemon.boss.poster.recommend;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * @author kevin
 */
public interface PosterRecommendConstants {
    /**
     *  活动状态和列表操作文案
     */
    byte ACTIVITY_STATUS_DESIGNED_S1 = 0;//海报设计，海报宝贝选择完毕；列表显示【编辑宝贝 投放设置 删除】
    byte ACTIVITY_STATUS_DESIGNED_S2 = 1;//海报设计，预览取名步骤完毕；列表显示【编辑宝贝 投放设置 删除 代码】
    byte ACTIVITY_STATUS_PUBLISH_SETTING_DONE = 2;//投放设置完毕；列表显示【编辑宝贝 投放设置 删除 代码 投放】
    byte ACTIVITY_STATUS_PUBLISHING = 3;//正在投放；列表显示【文字-正在将海报加入详情页代码 代码】
    byte ACTIVITY_STATUS_PUBLISHED = 4;//投放完毕；列表显示【编辑宝贝 投放设置 删除 代码】
    byte ACTIVITY_STATUS_PUBLISHED_WITH_ERROR = 5;//投放完毕，但是某些宝贝投放有错；【编辑宝贝 投放设置 删除 代码】
    byte ACTIVITY_STATUS_UNPUBLISHING = 6;//正在卸载；【文字-正在从详情页移除海报】
    byte ACTIVITY_STATUS_UNPUBLISHED = 7;//卸载完毕；【编辑宝贝 投放设置 删除 代码 投放】
    byte ACTIVITY_STATUS_UNPUBLISHED_WITH_ERROR = 8;//卸载完毕，但是有错；【编辑宝贝 投放设置 删除 代码 投放】
    //所有已经投放的状态
    List<Byte> ALL_PUBLISHED_ACTIVITY_STATUS = ImmutableList.of(ACTIVITY_STATUS_PUBLISHED,
            ACTIVITY_STATUS_PUBLISHED_WITH_ERROR);
    //所有供页面列表暂时的状态
    List<Byte> ALL_LIST_ACTIVITY_STATUS = ImmutableList.of(ACTIVITY_STATUS_DESIGNED_S1, ACTIVITY_STATUS_DESIGNED_S2,
            ACTIVITY_STATUS_PUBLISH_SETTING_DONE, ACTIVITY_STATUS_PUBLISHING,
            ACTIVITY_STATUS_PUBLISHED, ACTIVITY_STATUS_PUBLISHED_WITH_ERROR,ACTIVITY_STATUS_UNPUBLISHING);

    //所有状态
    List<Byte> ALL_ACTIVITY_STATUS = ImmutableList.of(ACTIVITY_STATUS_DESIGNED_S1, ACTIVITY_STATUS_DESIGNED_S2,
            ACTIVITY_STATUS_PUBLISH_SETTING_DONE, ACTIVITY_STATUS_PUBLISHING,
            ACTIVITY_STATUS_PUBLISHED, ACTIVITY_STATUS_PUBLISHED_WITH_ERROR,
            ACTIVITY_STATUS_UNPUBLISHING, ACTIVITY_STATUS_UNPUBLISHED,
            ACTIVITY_STATUS_UNPUBLISHED_WITH_ERROR);
    /**
     * 投放类型
     */
    byte PUBLISH_TYPE_ALWAYS = 0;//一直投放
    byte PUBLISH_TYPE_ASSIGN_TIME = 1;//选定时间内投放
    /**
     * 海报宝贝状态
     */
    byte ACTIVITY_ITEM_STATUS_NOT_IN_DB = 0;//数据库不存在，为前台标识是否参与活动
    byte ACTIVITY_ITEM_STATUS_NORMAL = 1;
    /**
     * 参与投放宝贝状态
     */
    byte PUBLISH_ITEM_STATUS_NOT_IN_DB = 0;//数据库不存在，为前台标识是否参与投放
    byte PUBLISH_ITEM_STATUS_WAITING_PUBLISH = 1;//待投放
    byte PUBLISH_ITEM_STATUS_PUBLISHED_SUCCESSFULLY = 2;//投放完毕
    byte PUBLISH_ITEM_STATUS_PUBLISHED_FAILED = 3;//投放完毕，但是失败
    byte PUBLISH_ITEM_STATUS_UNPUBLISHED_SUCCESSFULLY = 4;//卸载完毕
    byte PUBLISH_ITEM_STATUS_UNPUBLISHED_FAILED = 5;//卸载完毕，但是失败
    /**
     * 宝贝推荐用户状态
     */
    byte USER_STATUS_NORMAL = 0;
    byte USER_STATUS_EXPIRED = 1;
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
    byte DETAIL_PAGE_STATUS_PUBLISH_FAILED = 1;//更新详情页失败
    //查询宝贝排序
    String API_ITEM_GET_ORDER_BY_MODIFIED_ASC = "modified:asc";
    String API_ITEM_GET_ORDER_BY_MODIFIED_DESC = "modified:desc";
    //最大一个活动可以容纳宝贝
    int ACTIVITY_ITEM_MAX_NUM = 1000;
    //文案 key
    String COPY_KEY_ITEM_ORIGINAL_PRICE = "item_original_price";
    List<String> COPY_KEY_LIST=ImmutableList.of(COPY_KEY_ITEM_ORIGINAL_PRICE);

}
