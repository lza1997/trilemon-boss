package com.trilemon.boss.trade.notify;

/**
 * @author kevin
 */
public interface TradeNotifyConstants {
    String TRADE_CONFIRM_STATUS = "WAIT_BUYER_CONFIRM_GOODS";
    String TRADE_NOTIFY_FIELDS = "tid,receiver_name,buyer_nick,receiver_mobile,created,modified";
    //确认收货状态
    byte CONFIRM_STATUS_NOT_CONFIRM = 0;
    byte CONFIRM_STATUS_CONFIRM = 1;
    byte CONFIRM_STATUS_CONFIRM_AND_NOT_SEND = 1;
    byte CONFIRM_STATUS_CONFIRM_AND_SENDED = 2;
    //物流状态
    byte LOGISTICS_STATUS_END = 1;//已经结束
    byte LOGISTICS_STATUS_ARRIVED = 2;//已经到达
    byte LOGISTICS_STATUS_NOT_ARRIVED = 3;//没有到达
    byte LOGISTICS_STATUS_SKIP = 4;//跳过，不处理
}
