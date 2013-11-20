package com.trilemon.boss.rate.service;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.taobao.api.domain.Order;
import com.taobao.api.domain.Trade;
import com.taobao.api.domain.TradeRate;
import com.taobao.api.domain.User;
import com.taobao.api.request.TraderateAddRequest;
import com.taobao.api.request.TradesSoldIncrementGetRequest;
import com.taobao.api.response.TradesSoldIncrementGetResponse;
import com.trilemon.boss.infra.base.service.api.TaobaoApiTradeService;
import com.trilemon.boss.infra.base.service.api.TaobaoApiUserService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.rate.RateConstants;
import com.trilemon.boss.rate.dao.RateSettingDAO;
import com.trilemon.boss.rate.dao.RateSyncDAO;
import com.trilemon.boss.rate.model.RateFilterTrade;
import com.trilemon.boss.rate.model.RateOrder;
import com.trilemon.boss.rate.model.RateSetting;
import com.trilemon.boss.rate.model.dto.RateStatus;
import com.trilemon.boss.rate.model.dto.RateSyncStatus;
import com.trilemon.commons.Collections3;
import com.trilemon.commons.DateUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
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
    private TaobaoApiUserService taobaoApiUserService;
    @Autowired
    private RateSettingService rateSettingService;
    @Autowired
    private RateSyncDAO rateSyncDAO;
    @Autowired
    private RateSettingDAO rateSettingDAO;

    public void rate(RateSetting rateSetting) throws TaobaoSessionExpiredException, TaobaoEnhancedApiException, TaobaoAccessControlException {
        //放置淘宝自己漏单，往前推5分钟
        DateTime now = DateTime.now().plusMinutes(RATE_TRADE_OFFSET_MINUS);
        DateTime lastRateTime = getLastRateTime(rateSetting, now);

        //这里防止订单过多，需要分段分页处理
        List<Interval> intervals = DateUtils.partitionByMinute(lastRateTime, now, 30);
        Stopwatch stopwatch = Stopwatch.createStarted();
        logger.info("start to rate, rateSettingId[{}] userId[{}]", rateSetting.getId(), rateSetting.getUserId());
        //获取卖家的所有预设评论
        List<String> commentContents = rateSettingService.getComments(rateSetting.getUserId());
        //统计信息
        RateStatus rateStatus = new RateStatus();

        //分时间段
        for (Interval interval : intervals) {
            long pageNo = 1;
            long pageSize = 50;
            List<Trade> trades = Lists.newArrayList();
            //分页
            while (true) {
                TradesSoldIncrementGetRequest request = new TradesSoldIncrementGetRequest();
                request.setFields(RATE_TRADE_FIELDS);
                request.setStartModified(interval.getStart().toDate());
                request.setEndModified(interval.getEnd().toDate());
                request.setType(TRADE_TYPE);
                request.setStatus(RATE_TRADE_STATUS);
                request.setPageNo(pageNo);
                request.setPageSize(pageSize);
                request.setUseHasNext(true);
                TradesSoldIncrementGetResponse response = taobaoApiTradeService.getTrades(rateSetting.getUserId(),
                        request);
                if (null != response.getTrades()) {
                    trades.addAll(response.getTrades());
                    if (trades.size() > 100) {
                        try {
                            RateStatus rateStatus2 = rate(rateSetting, trades, commentContents);
                            rateStatus.combine(rateStatus2);
                            trades.clear();
                            pageNo++;
                        } catch (Exception e) {
                            stopwatch.stop();
                            fail(rateSetting, interval.getStart().toDateTime());
                            logger.info("fail to rate userId[{}] rateSettingId[{}] spend[{} mins]",
                                    rateSetting.getUserId(),
                                    rateSetting.getId(),
                                    stopwatch.elapsed(TimeUnit.MINUTES));
                            throw e;
                        }
                    }
                } else {
                    break;
                }
            }
            success(rateSetting, interval.getEnd().toDateTime());
        }
        stopwatch.stop();
        logger.info("end to rate userId[{}] rateStatus[{}], rateSettingId[{}] spend[{} mins]",
                rateSetting.getUserId(),
                ToStringBuilder.reflectionToString(rateStatus),
                rateSetting.getId(),
                stopwatch.elapsed(TimeUnit.MINUTES));
    }

    private RateStatus rate(RateSetting rateSetting, List<Trade> trades,
                            List<String> commentContents) throws TaobaoSessionExpiredException,
            TaobaoEnhancedApiException, TaobaoAccessControlException {
        RateStatus rateStatus = new RateStatus();
        List<RateFilterTrade> rateFilterTrades = Lists.newArrayList();
        List<RateOrder> rateOrders = Lists.newArrayList();

        rateStatus.setTradeNum(trades.size());
        for (Trade trade : trades) {
            if (trade.getSellerRate()) {
                //已经评价
                continue;
            }
            List<Order> orders = trade.getOrders();
            if (null != orders) {
                rateStatus.setOrderNum(orders.size());
                //过滤买家
                User buyer = taobaoApiUserService.getUser(rateSetting.getUserId(), trade.getBuyerNick(), BUYER_FIELDS);
                if (filterBuyerByCredit(rateSetting, buyer)) {
                    logger.info("filter by creditLevel[{}], buyerNick[{}] userId[{}]",
                            buyer.getBuyerCredit().getLevel(),
                            buyer.getNick(),
                            rateSetting.getUserId());
                    RateFilterTrade rateFilterTrade = buildFilterTrade(rateSetting, trade, buyer, RATE_FILTER_TYPE_CREDIT);
                    rateFilterTrades.add(rateFilterTrade);
                    rateStatus.incrFilterTradeNum(RATE_FILTER_TYPE_CREDIT);
                    continue;
                }
                if (filterBuyerByGoodRate(rateSetting, buyer)) {
                    logger.info("filter by goodNum[{}], buyerNick[{}] userId[{}]",
                            buyer.getBuyerCredit().getGoodNum(),
                            buyer.getNick(),
                            rateSetting.getUserId());
                    RateFilterTrade rateFilterTrade = buildFilterTrade(rateSetting, trade, buyer, RATE_FILTER_TYPE_GOOD_RATE);
                    rateFilterTrades.add(rateFilterTrade);
                    continue;
                }
                if (filterBuyerByRegisterDay(rateSetting, buyer)) {
                    logger.info("filter by registerDay[{}] buyerNick[{}] userId[{}]",
                            DateUtils.format(buyer.getCreated(), DateUtils.yyyy_MM_dd_HH_mm_ss),
                            buyer.getNick(),
                            rateSetting.getUserId());
                    RateFilterTrade rateFilterTrade = buildFilterTrade(rateSetting, trade, buyer, RATE_FILTER_TYPE_REGISTER_DAY);
                    rateFilterTrades.add(rateFilterTrade);
                    rateStatus.incrFilterTradeNum(RATE_FILTER_TYPE_REGISTER_DAY);
                    continue;
                }
                if (filterBuyerByBadRate(rateSetting, buyer)) {
                    logger.info("filter by badRate, buyerNick[{}] userId[{}]",
                            buyer.getNick(),
                            rateSetting.getUserId());
                    RateFilterTrade rateFilterTrade = buildFilterTrade(rateSetting, trade, buyer, RATE_FILTER_TYPE_BAD_RATE);
                    rateFilterTrades.add(rateFilterTrade);
                    rateStatus.incrFilterTradeNum(RATE_FILTER_TYPE_BAD_RATE);
                    continue;
                }
                if (filterBuyerByBlacklist(rateSetting, buyer)) {
                    logger.info("filter by blacklist, buyerNick[{}] userId[{}]",
                            buyer.getNick(),
                            rateSetting.getUserId());
                    RateFilterTrade rateFilterTrade = buildFilterTrade(rateSetting, trade, buyer, RateConstants.RATE_FILTER_TYPE_BLACKLIST);
                    rateFilterTrades.add(rateFilterTrade);
                    rateStatus.incrFilterTradeNum(RATE_FILTER_TYPE_BLACKLIST);
                    continue;
                }
                //过滤订单
                for (Order order : orders) {
                    if (order.getSellerRate()) {
                        continue;
                    }
                    //买家已评马上就评
                    if (order.getBuyerRate()) {
                        RateOrder rateOrder = rate(rateSetting, trade, order, commentContents);
                        rateOrders.add(rateOrder);
                        rateStatus.incrDay15RateNum();
                    } else {
                        //超过15天的不评，剩下的第14天评
                        DateTime endDateTime = new DateTime(order.getEndTime());
                        int days = Days.daysBetween(endDateTime, DateTime.now()).getDays();

                        if (days > 15) {
                            logger.info("order is 15 day ago, tid[{}] oid[{}] buyerNick[{}] userId[{}]",
                                    trade.getTid(),
                                    order.getOid(),
                                    buyer.getNick(),
                                    rateSetting.getUserId());
                            continue;
                        } else if (days <= 15 && days >= 14) {
                            RateOrder rateOrder = rate(rateSetting, trade, order, commentContents);
                            rateOrders.add(rateOrder);
                            rateStatus.incrDay14RateNum();
                        }
                    }
                }
            }
        }
        return rateStatus;
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

    private RateOrder rate(RateSetting rateSetting, Trade trade, Order order,
                           List<String> commentContents) throws TaobaoAccessControlException,
            TaobaoEnhancedApiException, TaobaoSessionExpiredException {
        TraderateAddRequest request = new TraderateAddRequest();
        request.setAnony(false);
        request.setResult("good");
        request.setRole("seller");
        request.setTid(trade.getTid());
        request.setOid(order.getOid());
        request.setContent(Collections3.getRandomElem(commentContents));
        TradeRate tradeRate = taobaoApiTradeService.addRate(rateSetting.getUserId(), request);
        RateOrder rateOrder = new RateOrder();
        rateOrder.setUserId(rateSetting.getUserId());
        rateOrder.setComment(tradeRate.getContent());
        rateOrder.setItemNumIid(tradeRate.getNumIid());
        rateOrder.setBuyerNick(order.getBuyerNick());
        rateOrder.setTid(trade.getTid());
        rateOrder.setOid(order.getOid());
        rateOrder.setRateTime(DateTime.now().toDate());
        return rateOrder;
    }

    /**
     * 过滤黑名单
     *
     * @param buyer
     * @return
     */
    public boolean filterBuyerByBlacklist(RateSetting rateSetting, User buyer) {
        if (rateSetting.getIsFilterBlacklist()) {
            Set<String> blacklist = rateSettingService.getBlacklist(buyer.getNick());
            return blacklist.contains(buyer.getNick());
        } else {
            return false;
        }
    }

    /**
     * 注册时间过滤
     *
     * @param buyer
     * @return
     */
    private boolean filterBuyerByRegisterDay(RateSetting rateSetting, User buyer) {
        if (rateSetting.getIsFilterRegisterDay()) {
            int days = Days.daysBetween(new DateTime(buyer.getCreated()), DateTime.now()).getDays();
            return days < rateSetting.getFilterRegisterDay();
        } else {
            return false;
        }
    }

    /**
     * 差评过滤
     *
     * @param buyer
     * @return
     */
    private boolean filterBuyerByBadRate(RateSetting rateSetting, User buyer) {
        if (rateSetting.getIsFilterBadRate()) {
            return false;
        } else {
            RateSyncStatus rateSyncStatus = getRateSyncStatus(rateSetting.getUserId(), buyer.getNick());
            return rateSyncStatus.getBadRateNum() > rateSetting.getFilterBadRateCount();
        }
    }

    /**
     * 好评过滤
     *
     * @param buyer
     * @return
     */
    private boolean filterBuyerByGoodRate(RateSetting rateSetting, User buyer) {
        if (rateSetting.getIsFilterGoodRate()) {
            return buyer.getBuyerCredit().getGoodNum() / buyer.getBuyerCredit().getTotalNum() / 1.0 < rateSetting
                    .getFilterGoodRate();
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
        if (rateSetting.getIsFilterCredit()) {
            return buyer.getBuyerCredit().getLevel() >= rateSetting.getFilterCreditMin() && buyer.getBuyerCredit()
                    .getLevel() <= rateSetting.getFilterCreditMax();
        } else {
            return false;
        }
    }

    /**
     * 1 如果第一次登录则返回15天前的日期
     * <p/>
     * 2 如果上次评论距离当前时间超过15天，则返回15天前的日期
     * <p/>
     * 3 如果上次评论距离当前时间不超过15天，则返回上次评论时间
     *
     * @param rateSetting
     * @param endDateTime
     * @return
     */
    public DateTime getLastRateTime(RateSetting rateSetting, DateTime endDateTime) {
        DateTime maxStartDateTime = endDateTime.minusDays(RATE_OFFSET_DAYS).minusMinutes(RATE_TRADE_OFFSET_MINUS);
        if (null == rateSetting.getLastRateTime()) {
            return maxStartDateTime;
        } else {
            DateTime lastRateTime = new DateTime(rateSetting.getLastRateTime());
            if (lastRateTime.isBefore(maxStartDateTime)) {
                return maxStartDateTime;
            } else {
                return lastRateTime;
            }
        }
    }

    private void fail(RateSetting rateSetting, DateTime lastRateDateTime) {
        RateSetting update = new RateSetting();
        update.setId(rateSetting.getId());
        update.setStatus(RATE_SETTING_STATUS_FAILED);
        update.setLastRateTime(lastRateDateTime.toDate());
        rateSettingDAO.updateByPrimaryKeySelective(update);
    }

    private void success(RateSetting rateSetting, DateTime lastRateDateTime) {
        RateSetting update = new RateSetting();
        update.setId(rateSetting.getId());
        update.setStatus(RATE_SETTING_STATUS_SUCCESSFUL);
        update.setLastRateTime(lastRateDateTime.toDate());
        rateSettingDAO.updateByPrimaryKeySelective(update);
    }

    public RateSyncStatus getRateSyncStatus(Long userId, String buyerNick) {
        return rateSyncDAO.selectRateSyncStatusByUserIdAndBuyerNick(userId, buyerNick);
    }

//    public Page<TradeRate> paginateRate(){
//        TraderatesGetRequest request=new TraderatesGetRequest();
//        request.setFields("tid,oid,role,rated_nick,nick,result,created,item_title,item_price,content,reply");
//        request.setPageNo(1L);
//        request.setPageSize(1L);
//        request.set
//    }
}