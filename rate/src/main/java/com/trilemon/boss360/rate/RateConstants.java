package com.trilemon.boss360.rate;

import com.google.common.collect.ImmutableList;
import com.trilemon.commons.Collections3;

import java.util.List;

/**
 * @author kevin
 */
public interface RateConstants {
    String DEFAULT_COMMENT_CONTENT = "感谢您购买我们的产品，您的支持是我们最大的动力，欢迎再次惠顾。";
    int RATE_TRADE_OFFSET_MINUS = 10;
    int RATE_OFFSET_DAYS = 15;
    List<String> RATE_TRADE_FIELDS_LIST = ImmutableList.of("buyer_nick", "buyer_rate", "seller_rate", "num_iid", "tid",
            "modified", "end_time",
            "orders.oid", "orders.num_iid", "orders.buyer_rate", "orders.seller_rate", "orders.status", "orders.end_time");
    List<String> RATE_TRADE_STATUS_LIST = ImmutableList.of("TRADE_FINISHED");
    List<String> TRADE_TYPE_LIST = ImmutableList.of("fixed", "auction", "step", "guarantee_trade",
            "independent_simple_trade", "independent_shop_trade", "auto_delivery",
            "ec", "cod", "fenxiao", "game_equipment", "shopex_trade", "netcn_trade", "external_trade",
            "instant_trade,b2c_cod", "hotel_trade", "super_market_trade",
            "super_market_cod_trade", "taohua", "waimai", "nopaid", "eticket");
    String RATE_TRADE_FIELDS = Collections3.COMMA_JOINER.join(RATE_TRADE_FIELDS_LIST);
    String RATE_TRADE_STATUS = Collections3.COMMA_JOINER.join(RATE_TRADE_STATUS_LIST);
    String TRADE_TYPE = Collections3.COMMA_JOINER.join(TRADE_TYPE_LIST);
    //rate_setting_status
    byte RATE_SETTING_STATUS_EXPIRED = 1;
}
