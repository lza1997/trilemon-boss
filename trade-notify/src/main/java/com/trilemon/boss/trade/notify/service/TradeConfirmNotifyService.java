package com.trilemon.boss.trade.notify.service;

import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;

/**
 * 确认收货
 *
 * @author kevin
 */
public class TradeConfirmNotifyService implements ITradeNotifyService {
    @Override
    public void sendSms(Long userId) throws TaobaoAccessControlException, TaobaoEnhancedApiException, TaobaoSessionExpiredException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
//    private final static Logger logger = LoggerFactory.getLogger(TradeConfirmNotifyService.class);
//    @Autowired
//    private TradeNotifyUserDAO tradeNotifyUserDAO;
//    @Autowired
//    private TradeNotifyConfirmDAO tradeNotifyConfirmDAO;
//    @Autowired
//    private AppService appService;
//    @Autowired
//    private TaobaoApiService taobaoApiService;
//    @Autowired
//    private BaseClient baseClient;
//
//    /**
//     * 同步确认收获相关的订单和物流信息
//     *
//     * @param userId
//     * @throws TaobaoSessionExpiredException
//     * @throws TaobaoAccessControlException
//     * @throws TaobaoEnhancedApiException
//     */
//    public void syncConfirmTradeAndLogistics(Long userId) throws TaobaoSessionExpiredException, TaobaoAccessControlException, TaobaoEnhancedApiException {
//        TradeNotifyUser user = tradeNotifyUserDAO.selectByUserId(userId);
//        if (!user.getEnableConfirmNotify()) {
//            logger.debug("userId[{}] disable confirm notify", user.getUserId());
//            return;
//        }
//
//        syncConfirmTrade(user);
//        syncConfirmLogistics(user);
//    }
//
//    public void syncConfirmTrade(TradeNotifyUser user) throws TaobaoAccessControlException, TaobaoEnhancedApiException,
//            TaobaoSessionExpiredException {
//
//        DateTime endDateTime = appService.getLocalSystemTime().minusMinutes(10);
//
//        //这里最多只判断当前时间往前30分钟内的订单
//        Date startDate = getStartDate(user, endDateTime);
//
//        if (startDate.getTime() > endDateTime.getMillis()) {
//            logger.warn("userId[{}] startDateTime > endDateTime, skip", user.getUserId());
//            return;
//        }
//        long pageNo = 1;
//        long pageSize = 100;
//        while (true) {
//            TradesSoldIncrementGetRequest request = new TradesSoldIncrementGetRequest();
//            request.setFields(TRADE_NOTIFY_FIELDS);
//            request.setStartModified(startDate);
//            request.setEndModified(endDateTime.toDate());
//            request.setStatus(TRADE_CONFIRM_STATUS);
//            request.setPageNo(pageNo);
//            request.setPageSize(pageSize);
//            request.setUseHasNext(true);
//            pageNo++;
//
//            TaobaoSession taobaoSession = baseClient.getTaobaoSession(user.getUserId(), taobaoApiService.getAppKey());
//            checkNotNull(taobaoSession, "taobaoSession must be not null, userId[%s]", user.getUserId());
//
//
//            TradesSoldIncrementGetResponse response = taobaoApiService.request(request, taobaoSession.getAccessToken());
//
//            List<Trade> trades = response.getTrades();
//
//            if (CollectionUtils.isEmpty(trades)) {
//                break;
//            }
//            trades = excludeBlankMobileTrades(trades);
//
//            List<TradeNotifyConfirm> confirms = buildTradeNotifyConfirms(user.getUserId(), trades);
//            tradeNotifyConfirmDAO.batchInsertIgnore(confirms);
//            logger.info("userId[{}] get [{}] trades, startDateTime[{}] endDateTime[{}]",
//                    user.getUserId(),
//                    trades.size(),
//                    DateUtils.format(startDate, DateUtils.yyyyMMdd2),
//                    endDateTime.toString(DateUtils.yyyyMMdd2));
//        }
//    }
//
//    /**
//     * 同步确认收获的物流信息
//     *
//     * @param user
//     */
//    public void syncConfirmLogistics(TradeNotifyUser user) {
//        //逐行扫描每一条未签收的消息是否已经签收
//        List<TradeNotifyConfirm> notConfirms = tradeNotifyConfirmDAO.selectByUserIdAndStatus(user.getUserId(),
//                ImmutableList.of(CONFIRM_STATUS_NOT_CONFIRM));
//        if (CollectionUtils.isEmpty(notConfirms)) {
//            return;
//        }
//        List<TradeNotifyConfirm> confirms = Lists.newArrayList();
//        for (TradeNotifyConfirm notConfirm : notConfirms) {
//            try {
//                LogisticsTraceSearchRequest request = new LogisticsTraceSearchRequest();
//                request.setSellerNick(baseClient.getNick(user.getUserId()));
//                request.setTid(notConfirm.getTid());
//
//                TaobaoSession taobaoSession = baseClient.getTaobaoSession(user.getUserId(), taobaoApiService.getAppKey());
//                checkNotNull(taobaoSession, "taobaoSession must be not null, userId[%s]", user.getUserId());
//
//
//                LogisticsTraceSearchResponse response = taobaoApiService.request(request,taobaoSession.getAppKey());
//
//                Map<String, Object> wctMap = waitArriveMsgService.getBuyerConfirmInfoForCommonUse(response);
//                boolean isEnd = (Boolean) wctMap.get("isEnd");
//                if (isEnd) {
//                    confirmWcts.add(wct);
//                    String statusTime = (String) wctMap.get("statusTime");
//                    wct.setConfirmDate(DateUtil.parseDateTime(statusTime));
//                }
//            } catch (Exception e) {
//                logger.error(e.getMessage(), e);
//                if (e.getMessage() != null) {
//                    if (e.getMessage().contains("物流公司不支持流转查询")) {
//                        waitConfirmTradeDao.deleteWaitConfirmTrade(wct, dbId);
//                    }
//                }
//            }
//        }
//        waitConfirmTradeDao.updateWaitConfirmTradeStatus(confirmWcts, WaitConfirmStatus.CONFIRM, dbId);
//    }
//
//}
//
//    public void sendSms(Long userId) {
//
//    }
//
//    private List<TradeNotifyConfirm> buildTradeNotifyConfirms(Long userId, List<Trade> trades) {
//        List<TradeNotifyConfirm> confirms = Lists.newArrayList();
//        for (Trade trade : trades) {
//            TradeNotifyConfirm tradeNotifyConfirm = new TradeNotifyConfirm();
//            tradeNotifyConfirm.setTid(trade.getTid());
//            tradeNotifyConfirm.setUserId(userId);
//            tradeNotifyConfirm.setAddTime(appService.getLocalSystemTime().toDate());
//            tradeNotifyConfirm.setBuyerNick(trade.getBuyerNick());
//            tradeNotifyConfirm.setModified(trade.getModified());
//            tradeNotifyConfirm.setTid(trade.getTid());
//            tradeNotifyConfirm.setReceiverName(trade.getReceiverName());
//            tradeNotifyConfirm.setReceiverMobile(trade.getReceiverMobile());
//            tradeNotifyConfirm.setCreated(trade.getCreated());
//            tradeNotifyConfirm.setStatus(CONFIRM_STATUS_NOT_CONFIRM);
//            confirms.add(tradeNotifyConfirm);
//        }
//        return confirms;
//    }
//
//    /**
//     * 过滤没有电话号码的订单
//     *
//     * @param trades
//     * @return
//     */
//    private List<Trade> excludeBlankMobileTrades(List<Trade> trades) {
//        List<Trade> list = Lists.newArrayList();
//        for (Trade trade : trades) {
//            if (StringUtils.isNotBlank(trade.getReceiverMobile())) {
//                list.add(trade);
//            }
//        }
//        return list;
//    }
//
//    /**
//     * 获取同步的开始时间，只同步往前30分钟内数据
//     *
//     * @param user
//     * @param endDateTime
//     * @return
//     */
//    private Date getStartDate(TradeNotifyUser user, DateTime endDateTime) {
//        Date startDate = user.getLastConfirmSyncTime();
//        DateTime _30MinusAgo = endDateTime.minusMinutes(30);
//        if (null != startDate) {
//            if (startDate.getTime() < _30MinusAgo.getMillis()) {
//                startDate = _30MinusAgo.toDate();
//            }
//        } else {
//            startDate = _30MinusAgo.toDate();
//        }
//        return startDate;
//    }
}