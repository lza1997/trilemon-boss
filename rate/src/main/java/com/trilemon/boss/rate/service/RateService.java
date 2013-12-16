package com.trilemon.boss.rate.service;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.taobao.api.domain.Order;
import com.taobao.api.domain.Trade;
import com.taobao.api.domain.TradeRate;
import com.taobao.api.domain.User;
import com.taobao.api.request.TraderateAddRequest;
import com.taobao.api.request.TradesSoldIncrementGetRequest;
import com.taobao.api.response.TradesSoldIncrementGetResponse;
import com.trilemon.boss.infra.base.model.BuyerBlacklist;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.infra.base.service.api.TaobaoApiShopService;
import com.trilemon.boss.infra.base.service.api.TaobaoApiTradeService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.rate.RateConstants;
import com.trilemon.boss.rate.cache.RateCache;
import com.trilemon.boss.rate.dao.RateLogDAO;
import com.trilemon.boss.rate.dao.RateOrderDAO;
import com.trilemon.boss.rate.dao.RateSettingDAO;
import com.trilemon.boss.rate.model.RateFilterTrade;
import com.trilemon.boss.rate.model.RateLog;
import com.trilemon.boss.rate.model.RateOrder;
import com.trilemon.boss.rate.model.RateSetting;
import com.trilemon.boss.rate.model.dto.RateStatus;
import com.trilemon.commons.Collections3;
import com.trilemon.commons.DateUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.trilemon.boss.rate.RateConstants.*;

/**
 * @author kevin
 */
@Service
public class RateService {
    private final static Logger logger = LoggerFactory.getLogger(RateService.class);
    @Autowired
    private TaobaoApiTradeService taobaoApiTradeService;
    @Autowired
    private TaobaoApiShopService taobaoApiShopService;
    @Autowired
    private RateSettingService rateSettingService;
    @Autowired
    private RateOrderDAO rateOrderDAO;
    @Autowired
    private RateSettingDAO rateSettingDAO;
    @Autowired
    private RateCache rateCache;
    @Autowired
    private RateLogDAO rateLogDAO;
    @Autowired
    private AppService appService;

    public void rate(Long userId) {

        RateSetting rateSetting = rateSettingDAO.selectByUserId(userId);
        if (null == rateSetting) {
            logger.warn("skip rate userId[{}] status[{}]", userId, rateSetting.getStatus());
            return;
        }

        //防止淘宝自己漏单，往前推5分钟
        DateTime rateEndDateTime = DateTime.now().plusMinutes(RATE_TRADE_OFFSET_MINUS);
        DateTime ratesStartDateTime = getRateStartTime(rateSetting, rateEndDateTime);
        if (null == ratesStartDateTime) {
            return;
        }

        Stopwatch stopwatch = Stopwatch.createStarted();
        logger.info("start to rate, rateSettingId[{}] userId[{}] startDate[{}] endDate[{}]", rateSetting.getId(),
                rateSetting.getUserId(), ratesStartDateTime.toString(DateUtils.yyyy_MM_dd_HH_mm_ss),
                rateEndDateTime.toString(DateUtils.yyyy_MM_dd_HH_mm_ss));
        //获取卖家的所有预设评论
        List<String> commentContents = rateSettingService.getComments(rateSetting.getUserId());
        //统计信息
        RateLog rateLog = new RateLog();
        rateLog.setUserId(userId);
        List<Trade> trades = Lists.newArrayList();

        //成功失败标志位
        boolean successful = false;
        int totalTradeCount = 0;
        //这里防止订单过多，需要分段分页处理
        List<Interval> intervals = DateUtils.partitionByMinute(ratesStartDateTime, rateEndDateTime, 24 * 60);
        for (Interval interval : intervals) {
            Date startDate = interval.getStart().toDate();
            Date endDate = interval.getEnd().toDate();

            rateLog.setRateStartTime(startDate);
            rateLog.setRateEndTime(endDate);
            setRateDoing(rateSetting, interval.getStart().toDate(), interval.getEnd().toDate());

            int tradeCount = 0;
            try {
                long pageNo = 1;
                long pageSize = 100;
                while (true) {
                    TradesSoldIncrementGetRequest request = new TradesSoldIncrementGetRequest();
                    request.setFields(RATE_TRADE_FIELDS);
                    request.setStartModified(startDate);
                    request.setEndModified(endDate);
                    request.setType(TRADE_TYPE);
                    request.setStatus(RATE_TRADE_STATUS);
                    request.setPageNo(pageNo);
                    request.setPageSize(pageSize);
                    request.setUseHasNext(true);
                    TradesSoldIncrementGetResponse response = taobaoApiTradeService.getTrades(rateSetting.getUserId(), request);
                    if (null != response.getTrades()) {
                        tradeCount += response.getTrades().size();
                        totalTradeCount += response.getTrades().size();
                        trades.addAll(response.getTrades());
                        if (trades.size() > 100) {
                            RateLog batchRateLog = rate(rateSetting, trades, commentContents);
                            rateLog.combine(batchRateLog);
                            trades.clear();
                            pageNo++;
                        }
                    }
                    if (!response.getHasNext()) {
                        break;
                    }
                }
                //flush
                if (CollectionUtils.isNotEmpty(trades)) {
                    RateLog flushRateLog = rate(rateSetting, trades, commentContents);
                    rateLog.combine(flushRateLog);
                    trades.clear();
                }
                successful = true;
                logger.info("end to rate userId[{}] rateSettingId[{}] startDate[{}] endDate[{}], get [{}] trades, " +
                        "spend time [{} sec]",
                        rateSetting.getUserId(),
                        rateSetting.getId(),
                        DateUtils.format(startDate, DateUtils.yyyy_MM_dd_HH_mm_ss),
                        DateUtils.format(endDate, DateUtils.yyyy_MM_dd_HH_mm_ss),
                        tradeCount,
                        stopwatch.elapsed(TimeUnit.SECONDS));
            } catch (Throwable e) {
                successful = false;
                logger.error("fail to rate userId[" + rateSetting.getUserId() + "] rateSettingId[" + rateSetting
                        .getId() + "] startDate[" + DateUtils.format(startDate, DateUtils.yyyy_MM_dd_HH_mm_ss) + "] " +
                        "endDate[" + DateUtils.format(endDate, DateUtils.yyyy_MM_dd_HH_mm_ss) + "], " +
                        "get [" + tradeCount + "] trades," +
                        "spend time [" + stopwatch.elapsed(TimeUnit.SECONDS) + " sec]", e);
                break;
            }
        }
        if (successful) {
            rateLog.setRateStatus(RATE_SETTING_RATE_STATUS_SUCCESSFUL);
            setRateSuccessful(rateSetting);
        } else {
            rateLog.setRateStatus(RATE_SETTING_RATE_STATUS_FAILED);
            setRateFailed(rateSetting);
        }

        //插入日志
        rateLogDAO.insertSelective(rateLog);

        stopwatch.stop();
        logger.info("end to rate userId[{}] rateLog[{}] rateSettingId[{}] startDate[{}] endDate[{}], " +
                "get [{}] trades, " +
                "spend[{} sec]",
                rateSetting.getUserId(),
                ToStringBuilder.reflectionToString(rateLog),
                rateSetting.getId(),
                totalTradeCount,
                stopwatch.elapsed(TimeUnit.SECONDS));

    }

    private RateLog rate(RateSetting rateSetting, List<Trade> trades,
                         List<String> commentContents)
            throws TaobaoSessionExpiredException, TaobaoEnhancedApiException, TaobaoAccessControlException {
        RateLog rateLog = new RateLog();
        rateLog.setUserId(rateSetting.getUserId());
        List<RateFilterTrade> rateFilterTrades = Lists.newArrayList();
        List<RateOrder> rateOrders = Lists.newArrayList();

        rateLog.setTradeNum(trades.size());
        for (Trade trade : trades) {
            List<Order> orders = trade.getOrders();
            if (null != orders) {
                rateLog.setOrderNum(orders.size());
                //过滤买家
                User buyer = rateCache.getBuyer(rateSetting.getUserId(), trade.getBuyerNick(), BUYER_FIELDS);
                if (filterBuyerByCredit(rateSetting, buyer)) {
                    logger.info("filter by creditLevel[{}], buyerNick[{}] userId[{}]",
                            buyer.getBuyerCredit().getLevel(),
                            buyer.getNick(),
                            rateSetting.getUserId());
                    RateFilterTrade rateFilterTrade = buildFilterTrade(rateSetting, trade, buyer, RATE_FILTER_TYPE_CREDIT);
                    rateFilterTrades.add(rateFilterTrade);
                    rateLog.incrFilteredTradeNum(RATE_FILTER_TYPE_CREDIT);
                    continue;
                }
                if (filterBuyerByRegisterDay(rateSetting, buyer)) {
                    logger.info("filter by registerDay[{}] buyerNick[{}] userId[{}]",
                            DateUtils.format(buyer.getCreated(), DateUtils.yyyy_MM_dd_HH_mm_ss),
                            buyer.getNick(),
                            rateSetting.getUserId());
                    RateFilterTrade rateFilterTrade = buildFilterTrade(rateSetting, trade, buyer, RATE_FILTER_TYPE_REGISTER_DAY);
                    rateFilterTrades.add(rateFilterTrade);
                    rateLog.incrFilteredTradeNum(RATE_FILTER_TYPE_REGISTER_DAY);
                    continue;
                }
                if (filterBuyerByGoodRate(rateSetting, buyer)) {
                    logger.info("filter by goodNum[{}], buyerNick[{}] userId[{}]",
                            buyer.getBuyerCredit().getGoodNum(),
                            buyer.getNick(),
                            rateSetting.getUserId());
                    RateFilterTrade rateFilterTrade = buildFilterTrade(rateSetting, trade, buyer, RATE_FILTER_TYPE_GOOD_RATE);
                    rateFilterTrades.add(rateFilterTrade);
                    rateLog.incrFilteredTradeNum(RATE_FILTER_TYPE_GOOD_RATE);
                    continue;
                }
                if (filterBuyerByBadRate(rateSetting, buyer)) {
                    logger.info("filter by badRate, buyerNick[{}] userId[{}]",
                            buyer.getNick(),
                            rateSetting.getUserId());
                    RateFilterTrade rateFilterTrade = buildFilterTrade(rateSetting, trade, buyer, RATE_FILTER_TYPE_BAD_RATE);
                    rateFilterTrades.add(rateFilterTrade);
                    rateLog.incrFilteredTradeNum(RATE_FILTER_TYPE_BAD_RATE);
                    continue;
                }
                if (filterBuyerByBlacklist(rateSetting, buyer)) {
                    logger.info("filter by blacklist, buyerNick[{}] userId[{}]",
                            buyer.getNick(),
                            rateSetting.getUserId());
                    RateFilterTrade rateFilterTrade = buildFilterTrade(rateSetting, trade, buyer, RateConstants.RATE_FILTER_TYPE_BLACKLIST);
                    rateFilterTrades.add(rateFilterTrade);
                    rateLog.incrFilteredTradeNum(RATE_FILTER_TYPE_BLACKLIST);
                    continue;
                }
                //过滤订单
                for (Order order : orders) {
                    if (order.getSellerRate()) {
                        //卖家已经评价
                        continue;
                    }
                    List<TradeRate> tradeRates = taobaoApiShopService.getBuyerRates(rateSetting.getUserId(),
                            order.getOid(), ImmutableList.of("result", "content", "created", "item_title", "item_price"));
                    TradeRate tradeRate = tradeRates.get(0);
                    //因为只查询一个 oid，所以这里应该只有一条记录
                    if (CollectionUtils.isEmpty(tradeRates)) {
                        continue;
                    }

                    //买家已评马上就评
                    RateOrder rateOrder = null;
                    if (RateConstants.RATE_TYPE_IMMEDIATELY == rateSetting.getRateType()) {
                        rateOrder = rate(rateSetting.getUserId(), trade.getTid(), order.getOid(),
                                trade.getBuyerNick(), Collections3.getRandomElem(commentContents),
                                RATE_ORDER_STATUS_DONE_IMMEDIATELY, tradeRate);
                        rateLog.incrDay15RateNum();

                    } else if (RateConstants.RATE_TYPE_AFTER_BUYER_RATE == rateSetting.getRateType() && order.getBuyerRate()) {
                        //检查买家评论种类；根据设置评价中差评论
                        if (rateSetting.getAutoGoodRate() && tradeRate.getResult().equals("good")) {
                            rateOrder = rate(rateSetting.getUserId(), trade.getTid(), order.getOid(),
                                    trade.getBuyerNick(), Collections3.getRandomElem(commentContents),
                                    RATE_ORDER_STATUS_DONE_AFTER_BUYER_RATE, tradeRate);
                            rateLog.incrDay15RateNum();
                        } else if (rateSetting.getAutoNeutralRate() && tradeRate.getResult().equals("neutral")) {
                            rateOrder = rate(rateSetting.getUserId(), trade.getTid(), order.getOid(),
                                    trade.getBuyerNick(), Collections3.getRandomElem(commentContents),
                                    RATE_ORDER_STATUS_DONE_AFTER_BUYER_RATE, tradeRate);
                            rateLog.incrDay15RateNum();
                        } else if (rateSetting.getAutoBadRate() && tradeRate.getResult().equals("bad")) {
                            rateOrder = rate(rateSetting.getUserId(), trade.getTid(), order.getOid(),
                                    trade.getBuyerNick(), Collections3.getRandomElem(commentContents),
                                    RATE_ORDER_STATUS_DONE_AFTER_BUYER_RATE, tradeRate);
                            rateLog.incrDay15RateNum();
                        } else {
                            rateOrder = buildRateOrder(rateSetting.getUserId(), trade.getTid(), order.getOid(),
                                    trade.getBuyerNick(), order.getNumIid(), RATE_ORDER_STATUS_WAITING_RATE,
                                    Collections3.getRandomElem(commentContents), tradeRate);
                        }
                    } else {
                        //超过15天的不评，剩下的第14天评
                        DateTime endDateTime = new DateTime(order.getEndTime());
                        int days = Days.daysBetween(endDateTime, DateTime.now()).getDays();

                        if (days > 15) {
                            rateOrder = buildRateOrder(rateSetting.getUserId(), trade.getTid(), order.getOid(),
                                    trade.getBuyerNick(), order.getNumIid(), RATE_ORDER_STATUS_15DAY_AGO,
                                    Collections3.getRandomElem(commentContents), tradeRate);
                            logger.info("order is 15 day ago, tid[{}] oid[{}] buyerNick[{}] userId[{}]",
                                    trade.getTid(),
                                    order.getOid(),
                                    buyer.getNick(),
                                    rateSetting.getUserId());
                        } else if (days <= 15 && days >= 14) {
                            rateOrder = rate(rateSetting.getUserId(), trade.getTid(), order.getOid(),
                                    trade.getBuyerNick(), Collections3.getRandomElem(commentContents),
                                    RATE_ORDER_STATUS_DONE_IN_15DAY, tradeRate);
                            rateOrders.add(rateOrder);
                            rateLog.incrDay14RateNum();
                        }
                    }
                    if (null != rateOrder) {
                        rateOrders.add(rateOrder);
                    }
                }
            }
            if (rateOrders.size() >= 100) {
                int rows = rateOrderDAO.batchInsertSelective(rateOrders);
                rateLog.incrInsertedRateOrderNum(rows);
                rateOrders.clear();
            }
        }
        //flush
        if (rateOrders.size() > 0) {
            int rows = rateOrderDAO.batchInsertSelective(rateOrders);
            rateLog.incrInsertedRateOrderNum(rows);
            rateOrders.clear();
        }
        return rateLog;
    }

    private RateFilterTrade buildFilterTrade(RateSetting rateSetting, Trade trade, User buyer, byte rateFilterTypeCredit) {
        RateFilterTrade rateFilterTrade = new RateFilterTrade();
        rateFilterTrade.setUserId(rateSetting.getUserId());
        rateFilterTrade.setBuyerNick(buyer.getNick());
        rateFilterTrade.setIsBuyerRate(trade.getBuyerRate());
        rateFilterTrade.setIsSellerRate(trade.getSellerRate());
        rateFilterTrade.setFilterTime(DateTime.now().toDate());
        rateFilterTrade.setFilterType(rateFilterTypeCredit);
        rateFilterTrade.setStatus(RATE_FILTER_STATUS_FILTERED);
        rateFilterTrade.setTid(trade.getTid());
        rateFilterTrade.setAddTime(DateTime.now().toDate());
        return rateFilterTrade;
    }

    private RateOrder rate(Long userId, Long tid, Long oid, String buyerNick,
                           String comment, byte status, TradeRate buyerTradeRate) throws TaobaoAccessControlException,
            TaobaoEnhancedApiException, TaobaoSessionExpiredException {
        Preconditions.checkArgument(comment.length() <= 500, "comment length should be <= 500.");
        TraderateAddRequest request = new TraderateAddRequest();
        request.setAnony(false);
        request.setResult("good");
        request.setRole("seller");
        request.setTid(tid);
        request.setOid(oid);
        request.setContent(comment);
        TradeRate tradeRate = taobaoApiTradeService.addRate(userId, request);

        return buildRateOrder(userId, tid, oid, buyerNick, tradeRate.getNumIid(), status, comment, buyerTradeRate);
    }

    private RateOrder buildRateOrder(Long userId, Long tid, Long oid, String buyerNick, Long numIid, byte status,
                                     String comment, TradeRate buyerTradeRate) {
        RateOrder rateOrder = new RateOrder();
        rateOrder.setUserId(userId);
        rateOrder.setComment(comment);//卖家回评
        rateOrder.setItemNumIid(numIid);
        rateOrder.setBuyerNick(buyerNick);
        rateOrder.setStatus(status);
        rateOrder.setTid(tid);
        rateOrder.setOid(oid);
        rateOrder.setContent(buyerTradeRate.getContent());//买家评论
        rateOrder.setCreated(buyerTradeRate.getCreated());
        rateOrder.setItemTitle(buyerTradeRate.getItemTitle());
        rateOrder.setItemPrice(new BigDecimal(buyerTradeRate.getItemPrice()));
        rateOrder.setRateTime(DateTime.now().toDate());
        return rateOrder;
    }

    /**
     * 过滤黑名单
     *
     * @param rateSetting
     * @param buyer
     * @return
     */
    public boolean filterBuyerByBlacklist(RateSetting rateSetting, User buyer) {
        if (rateSetting.getEnableBlacklistFilter()) {
            BuyerBlacklist buyerBlacklist = rateCache.getBuyerBlacklist(rateSetting.getUserId(), buyer.getNick());
            return null != buyerBlacklist;
        } else {
            return false;
        }
    }

    /**
     * 注册时间过滤
     *
     * @param rateSetting
     * @param buyer
     * @return
     */
    private boolean filterBuyerByRegisterDay(RateSetting rateSetting, User buyer) {
        if (rateSetting.getEnableRegisterDayFilter()) {
            int days = Days.daysBetween(new DateTime(buyer.getCreated()), DateTime.now()).getDays();
            return days < rateSetting.getRegisterDayFilter();
        } else {
            return false;
        }
    }

    /**
     * 差评过滤
     *
     * @param rateSetting
     * @param buyer
     * @return
     */
    private boolean filterBuyerByBadRate(RateSetting rateSetting, User buyer) {
        if (rateSetting.getEnableBadRateFilter()) {
            return false;
        } else {
            RateStatus rateStatus = getBuyerRateSyncStatus(rateSetting.getUserId(), buyer.getNick());
            return rateStatus.getBadRateNum() > rateSetting.getBadRateFilter();
        }
    }

    /**
     * 好评过滤
     *
     * @param rateSetting
     * @param buyer
     * @return
     */
    private boolean filterBuyerByGoodRate(RateSetting rateSetting, User buyer) {
        if (rateSetting.getEnableGoodRateFilter()) {
            return buyer.getBuyerCredit().getGoodNum() / buyer.getBuyerCredit().getTotalNum() / 1.0 < rateSetting
                    .getGoodRateFilter();
        } else {
            return false;
        }
    }

    /**
     * 信用过滤
     *
     * @param rateSetting
     * @param buyer
     * @return
     */
    private boolean filterBuyerByCredit(RateSetting rateSetting, User buyer) {
        if (rateSetting.getEnableCreditFilter()) {
            return buyer.getBuyerCredit().getLevel() >= rateSetting.getCreditFilterMin() && buyer.getBuyerCredit()
                    .getLevel() <= rateSetting.getCreditFilterMax();
        } else {
            return false;
        }
    }

    /**
     * 1 如果第一次评论则返回15天前的日期
     * <p/>
     * 2 如果上次评论距离当前时间超过15天，则返回15天前的日期
     * <p/>
     * 3 如果上次评论距离当前时间不超过15天，则返回上次评论时间
     *
     * @param rateSetting
     * @param endDateTime
     * @return
     */
    private DateTime getRateStartTime(RateSetting rateSetting, DateTime endDateTime) {
        DateTime startDateTime = endDateTime.minusDays(RATE_OFFSET_DAYS).minusMinutes(RATE_TRADE_OFFSET_MINUS);
        switch (rateSetting.getRateStatus()) {
            case RateConstants.RATE_SETTING_RATE_STATUS_INIT:
                return startDateTime;
            case RateConstants.RATE_SETTING_RATE_STATUS_SUCCESSFUL:
                if (null == rateSetting.getLastRateEndTime()) {
                    return startDateTime;
                } else {
                    DateTime lastEndDateTime = new DateTime(rateSetting.getLastRateEndTime());
                    return startDateTime.isBefore(lastEndDateTime) ? lastEndDateTime : startDateTime;
                }
            case RateConstants.RATE_SETTING_RATE_STATUS_FAILED:
                if (null == rateSetting.getLastRateEndTime()) {
                    return startDateTime;
                } else {
                    DateTime lastStartDateTime = new DateTime(rateSetting.getLastRateStartTime());
                    return startDateTime.isBefore(lastStartDateTime) ? lastStartDateTime : startDateTime;
                }
            default:
                return null;
        }
    }

    private void setRateDoing(RateSetting rateSetting, Date startDate, Date endDate) {
        RateSetting update = new RateSetting();
        update.setId(rateSetting.getId());
        update.setRateStatus(RATE_SETTING_RATE_STATUS_DOING);
        update.setRateOwner(appService.getOwner());
        update.setLastRateStartTime(startDate);
        update.setLastRateEndTime(endDate);
        rateSettingDAO.updateByPrimaryKeySelective(update);
    }

    private void setRateFailed(RateSetting rateSetting) {
        RateSetting update = new RateSetting();
        update.setId(rateSetting.getId());
        update.setRateStatus(RATE_SETTING_RATE_STATUS_FAILED);
        rateSettingDAO.updateByPrimaryKeySelective(update);
    }

    private void setRateSuccessful(RateSetting rateSetting) {
        RateSetting update = new RateSetting();
        update.setId(rateSetting.getId());
        update.setRateStatus(RATE_SETTING_RATE_STATUS_SUCCESSFUL);
        rateSettingDAO.updateByPrimaryKeySelective(update);
    }

    public RateStatus getBuyerRateSyncStatus(Long userId, String buyerNick) {
        return rateCache.getBuyerRateSyncStatus(userId, buyerNick);
    }

    public boolean rate(Long userId, Long oid, String comment) throws TaobaoSessionExpiredException, TaobaoAccessControlException, TaobaoEnhancedApiException {
        RateOrder rateOrder = rateOrderDAO.selectByUserIdAndOid(userId, oid);
        //调用 taobao api 进行评论
        //rate(userId, rateOrder.getTid(), oid, rateOrder.getBuyerNick(), comment, RATE_ORDER_STATUS_DONE_MANUAL);
        //更新数据库状态
        RateOrder newRateOrder = new RateOrder();
        newRateOrder.setId(rateOrder.getId());
        newRateOrder.setUserId(userId);
        newRateOrder.setComment(comment);
        newRateOrder.setStatus(RATE_ORDER_STATUS_DONE_MANUAL);
        newRateOrder.setRateTime(appService.getLocalSystemTime().toDate());
        int row = rateOrderDAO.updateByPrimaryKeySelective(newRateOrder);
        return row == 1;
    }
}