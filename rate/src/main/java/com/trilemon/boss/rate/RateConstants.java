package com.trilemon.boss.rate;

import com.google.common.collect.ImmutableList;
import com.trilemon.commons.Collections3;

import java.util.List;

/**
 * @author kevin
 */
public interface RateConstants {
    //默认评论
    List<String> DEFAULT_COMMENT_LIST = ImmutableList.of("感谢您购买我们的产品，您的支持是我们最大的动力，欢迎再次惠顾。");
    //评论同步提前10分钟，防止淘宝漏单
    int RATE_TRADE_OFFSET_MINUS = 10;
    //评论最长只能往前同步15天
    int RATE_OFFSET_DAYS = 15;
    //同步评论所需要的订单字段
    List<String> RATE_TRADE_FIELDS_LIST = ImmutableList.of("buyer_nick", "buyer_rate", "seller_rate", "num_iid", "tid",
            "modified", "end_time",
            "orders.oid", "orders.num_iid", "orders.buyer_rate", "orders.seller_rate", "orders.status", "orders.end_time");
    //同步评论所需要的订单状态
    List<String> RATE_TRADE_STATUS_LIST = ImmutableList.of("TRADE_FINISHED");
    //同步评论所需要的订单类型
    List<String> TRADE_TYPE_LIST = ImmutableList.of("fixed", "auction", "step", "guarantee_trade",
            "independent_simple_trade", "independent_shop_trade", "auto_delivery",
            "ec", "cod", "fenxiao", "game_equipment", "shopex_trade", "netcn_trade", "external_trade",
            "instant_trade,b2c_cod", "hotel_trade", "super_market_trade",
            "super_market_cod_trade", "taohua", "waimai", "nopaid", "eticket");
    String RATE_TRADE_FIELDS = Collections3.COMMA_JOINER.join(RATE_TRADE_FIELDS_LIST);
    String RATE_TRADE_STATUS = Collections3.COMMA_JOINER.join(RATE_TRADE_STATUS_LIST);
    String TRADE_TYPE = Collections3.COMMA_JOINER.join(TRADE_TYPE_LIST);
    //buyer_field
    List<String> BUYER_FIELDS = ImmutableList.of("user_id", "buyer_credit", "created", "type");
    //comment setting status，暂时都是0
    byte RATE_COMMENT_SETTING_STATUS_VALID = 0;
    byte RATE_COMMENT_SETTING_STATUS_INVALID = 1;
    //评价类型
    byte RATE_TYPE_IMMEDIATELY = 0;
    byte RATE_TYPE_AFTER_BUYER_RATE = 1;
    //rate filter type
    byte RATE_FILTER_TYPE_CREDIT = 1;
    byte RATE_FILTER_TYPE_REGISTER_DAY = 2;
    byte RATE_FILTER_TYPE_GOOD_RATE = 3;
    byte RATE_FILTER_TYPE_BAD_RATE = 4;
    byte RATE_FILTER_TYPE_BLACKLIST = 5;
    //rate filter type
    byte RATE_FILTER_STATUS_FILTERED = 1;
    //评论job标志位
    byte RATE_SETTING_RATE_STATUS_INIT = 0;
    byte RATE_SETTING_RATE_STATUS_SUCCESSFUL = 1;
    byte RATE_SETTING_RATE_STATUS_FAILED = 2;
    byte RATE_SETTING_RATE_STATUS_DOING = 3;
    //使用评论的用户
    byte RATE_SETTING_STATUS_RUNNING = 0;
    byte RATE_SETTING_STATUS_PAUSE = 1;
    byte RATE_SETTING_STATUS_EXPIRED = 2;
    //评论状态
    byte RATE_ORDER_STATUS_WAITING_RATE = 0;//还没有评论
    byte RATE_ORDER_STATUS_DONE_IMMEDIATELY  = 1;//立刻评论
    byte RATE_ORDER_STATUS_DONE_AFTER_BUYER_RATE  = 2;//买家评论后立刻评论
    byte RATE_ORDER_STATUS_DONE_IN_15DAY = 3;//第15天评论
    byte RATE_ORDER_STATUS_DONE_MANUAL = 4;//手动评论
    byte RATE_ORDER_STATUS_15DAY_AGO = 5;//超出15天限制，没有评论
    //已经评论
    List<Byte> RATE_ORDER_STATUS_LIST_RATED = ImmutableList.of(RATE_ORDER_STATUS_DONE_IMMEDIATELY,
            RATE_ORDER_STATUS_DONE_AFTER_BUYER_RATE,
            RATE_ORDER_STATUS_DONE_IN_15DAY, RATE_ORDER_STATUS_DONE_MANUAL);
    //还没有评论
    List<Byte> RATE_ORDER_STATUS_LIST_NOT_RATED = ImmutableList.of(RATE_ORDER_STATUS_WAITING_RATE);
}
