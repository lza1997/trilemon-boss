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
    //comment setting status
    byte RATE_COMMENT_SETTING_STATUS_VALID = 0;
    byte RATE_COMMENT_SETTING_STATUS_INVALID = 1;
    //rate filter type
    byte RATE_FILTER_TYPE_CREDIT=1;
    byte RATE_FILTER_TYPE_GOOD_RATE=2;
    byte RATE_FILTER_TYPE_REGISTER_DAY=3;
    byte RATE_FILTER_TYPE_BAD_RATE=4;
    byte RATE_FILTER_TYPE_BLACKLIST=5;
    //rate filter type
    byte RATE_FILTER_STATUS_FILTERED=1;
    byte RATE_FILTER_STATUS_RATE=2;
    //rate_setting_status
    byte RATE_SETTING_STATUS_SUCCESSFUL=0;
    byte RATE_SETTING_STATUS_FAILED=0;
    //rate setting expired flag
    byte RATE_SETTING_NOT_EXPIRED = 0;
    byte RATE_SETTING_EXPIRED = 1;
}
