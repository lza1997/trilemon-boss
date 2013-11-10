package com.trilemon.boss360.rate.service;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import com.taobao.api.domain.Order;
import com.taobao.api.domain.Trade;
import com.taobao.api.domain.TradeRate;
import com.taobao.api.request.TraderateAddRequest;
import com.taobao.api.request.TradesSoldIncrementGetRequest;
import com.taobao.api.response.TradesSoldIncrementGetResponse;
import com.trilemon.boss360.infrastructure.base.service.api.TaobaoApiTradeService;
import com.trilemon.boss360.infrastructure.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss360.infrastructure.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss360.infrastructure.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss360.rate.model.RateSetting;
import com.trilemon.commons.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.trilemon.boss360.rate.RateConstants.*;

/**
 * @author kevin
 */
@Service
public class RateService {
    private final static Logger logger = LoggerFactory.getLogger(RateService.class);
    private TaobaoApiTradeService taobaoApiTradeService;
    private RateSettingService rateSettingService;

    public void rate(RateSetting rateSetting) throws TaobaoSessionExpiredException, TaobaoEnhancedApiException, TaobaoAccessControlException {
        //放置淘宝自己漏单，往前推5分钟
        DateTime now = DateTime.now().plusMinutes(RATE_TRADE_OFFSET_MINUS);
        DateTime lastRateTime = getLastRateTime(rateSetting, now);

        //统计信息
        int day14TradeNum = 0;
        int normalTradeNum = 0;
        int goodRateNum = 0;
        int neutralRateNum = 0;
        int badRateNum = 0;

        //这里防止订单过多，需要分段分页处理
        List<Interval> intervals = DateUtils.partitionByMinute(lastRateTime, now, 30);
        Stopwatch stopwatch = Stopwatch.createStarted();
        logger.info("start to rate, rateSettingId[{}] userId[{}]", rateSetting.getId(), rateSetting.getUserId());
        for (Interval interval : intervals) {
            long pageNo = 1;
            long pageSize = 50;
            List<Trade> trades = Lists.newArrayList();
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
                    pageNo++;
                    List<Trade> filteredTrades = filterTrades(rateSetting, response.getTrades());
                    trades.addAll(filteredTrades);
                    if (trades.size() > 100) {
                        if (rate(rateSetting, trades)) {
                            success(rateSetting, interval.getEnd());
                        } else {
                            fail(rateSetting, interval.getEnd());
                        }
                    }
                } else {
                    break;
                }
            }
        }
        stopwatch.stop();
        logger.info("end to rate, rateSettingId[{}] userId[{}] spend[{} mins]", rateSetting.getId(),
                rateSetting.getUserId(), stopwatch.elapsed(TimeUnit.MINUTES));
    }

    private boolean rate(RateSetting rateSetting, List<Trade> trades) throws TaobaoSessionExpiredException, TaobaoEnhancedApiException, TaobaoAccessControlException {
        for (Trade trade : trades) {
            if (null != trade.getOrders()) {
                for (Order order : trade.getOrders()) {
                    TraderateAddRequest request = new TraderateAddRequest();
                    request.setAnony(false);
                    request.setResult("good");
                    request.setRole("seller");
                    request.setTid(trade.getTid());
                    request.setOid(order.getOid());
                    request.setContent(rateSettingService.getComment());
                    TradeRate tradeRate = taobaoApiTradeService.addRate(rateSetting.getUserId(), request);
                }
            }
        }
        return true;
    }

    /**
     * 根据用户设置的条件过滤订单
     *
     * @param rateSetting
     * @param trades
     * @return
     */
    public List<Trade> filterTrades(RateSetting rateSetting, List<Trade> trades) {
        trades = getTradesByRateType(rateSetting, trades);
        trades = filterTradesByCredit(rateSetting, trades);
        trades = filterTradesByGoodRate(rateSetting, trades);
        trades = filterTradesByBadRate(rateSetting, trades);
        trades = filterTradesByRegisterDay(rateSetting, trades);
        trades = filterTradesByBlacklist(rateSetting, trades);
        return trades;
    }

    /**
     * 根据评论类型判断是否需要评论
     *
     * @param rateSetting
     * @param trades
     * @return
     */
    private List<Trade> getTradesByRateType(RateSetting rateSetting, List<Trade> trades) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    /**
     * 黑名单过滤
     *
     * @param rateSetting
     * @param trades
     * @return
     */
    private List<Trade> filterTradesByBlacklist(RateSetting rateSetting, List<Trade> trades) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    /**
     * 注册时间过滤
     *
     * @param rateSetting
     * @param trades
     * @return
     */
    private List<Trade> filterTradesByRegisterDay(RateSetting rateSetting, List<Trade> trades) {
        return null;
    }

    /**
     * 差评过滤
     *
     * @param rateSetting
     * @param trades
     * @return
     */
    private List<Trade> filterTradesByBadRate(RateSetting rateSetting, List<Trade> trades) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    /**
     * 好评过滤
     *
     * @param rateSetting
     * @param trades
     * @return
     */
    private List<Trade> filterTradesByGoodRate(RateSetting rateSetting, List<Trade> trades) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }

    /**
     * 信用过滤
     *
     * @param rateSetting
     * @param trades
     * @return
     */
    private List<Trade> filterTradesByCredit(RateSetting rateSetting, List<Trade> trades) {
        return null;  //To change body of created methods use File | Settings | File Templates.
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
        //To change body of created methods use File | Settings | File Templates.
    }

    private void success(RateSetting rateSetting, DateTime lastRateDateTime) {
        //To change body of created methods use File | Settings | File Templates.
    }
}