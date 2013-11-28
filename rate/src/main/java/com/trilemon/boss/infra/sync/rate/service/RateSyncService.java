package com.trilemon.boss.infra.sync.rate.service;

import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.taobao.api.domain.TradeRate;
import com.taobao.api.request.TraderatesGetRequest;
import com.taobao.api.response.TraderatesGetResponse;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.infra.base.service.api.TaobaoApiShopService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.infra.sync.rate.RateSyncConstants;
import com.trilemon.boss.infra.sync.rate.client.RatePageRequest;
import com.trilemon.boss.infra.sync.rate.dao.SyncRateDAO;
import com.trilemon.boss.infra.sync.rate.dao.SyncStatusDAO;
import com.trilemon.boss.infra.sync.rate.model.SyncRate;
import com.trilemon.boss.infra.sync.rate.model.SyncStatus;
import com.trilemon.commons.DateUtils;
import com.trilemon.commons.web.Page;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.trilemon.boss.infra.sync.rate.RateSyncConstants.*;
import static com.trilemon.commons.Collections3.COMMA_JOINER;

/**
 * @author kevin
 */
@Service
public class RateSyncService {
    private static Logger logger = LoggerFactory.getLogger(RateSyncService.class);
    @Autowired
    private SyncRateDAO syncRateDAO;
    @Autowired
    private SyncStatusDAO syncStatusDAO;
    @Autowired
    private AppService appService;
    @Autowired
    private TaobaoApiShopService taobaoApiShopService;

    /**
     * 删除机器启动后没有执行完毕的任务，并置为失败状态，下次重新执行。
     */
    public void cleanExpiredSyncTasks() {
        int rows = syncStatusDAO.deleteByRateSyncOwnerAndStatus(appService.getOwner(),
                ImmutableList.of(RATE_SYNC_STATUS_DOING));
        logger.info("delete [{}] rows, owner[{}]", rows, appService.getOwner());

    }

    public void sync(Long userId) throws RateSyncException, TaobaoAccessControlException, TaobaoSessionExpiredException, TaobaoEnhancedApiException {
        SyncStatus syncStatus = syncStatusDAO.selectByUserId(userId);
        sync(syncStatus);
    }

    private void sync(SyncStatus syncStatus) throws RateSyncException, TaobaoSessionExpiredException, TaobaoAccessControlException, TaobaoEnhancedApiException {
        Date rateStartDate = null;
        switch (syncStatus.getRateSyncStatus()) {
            case RateSyncConstants.RATE_SYNC_STATUS_INIT:
                rateStartDate = appService.getLocalSystemTime().minusMinutes(5).minusDays(180).toDate();
                break;
            case RateSyncConstants.RATE_SYNC_STATUS_SUCCESSFUL:
                rateStartDate = syncStatus.getLastRateEndTime();
                break;
            case RateSyncConstants.RATE_SYNC_STATUS_FAILED:
                rateStartDate = syncStatus.getLastRateStartTime();
                break;
        }

        if (null == rateStartDate) {
            throw new RateSyncException("rate[" + syncStatus.getUserId() + "] sync error, rateSyncStartDate is null");
        }

        try {
            Date rateSyncEndDate = appService.getLocalSystemTime().minusMinutes(5).toDate();
            setRateSyncDoing(syncStatus.getUserId(), rateStartDate, rateSyncEndDate, syncStatus.getRateSyncStatus());
            internalSync(syncStatus.getUserId(), rateStartDate, rateSyncEndDate);
            setRateSyncSuccessful(syncStatus.getUserId());
        } catch (Exception e) {
            setRateSyncFailed(syncStatus.getUserId());
            throw e;
        }
    }

    private void setRateSyncFailed(Long userId) {
        SyncStatus syncStatus = new SyncStatus();
        syncStatus.setUserId(userId);
        syncStatus.setRateSyncStatus(RATE_SYNC_STATUS_FAILED);
        syncStatus.setLastRateSyncEndTime(appService.getLocalSystemTime().toDate());
        syncStatusDAO.updateByUserIdSelective(syncStatus);
    }

    private void setRateSyncSuccessful(Long userId) {
        SyncStatus syncStatus = new SyncStatus();
        syncStatus.setUserId(userId);
        syncStatus.setRateSyncStatus(RATE_SYNC_STATUS_SUCCESSFUL);
        syncStatus.setLastRateSyncEndTime(appService.getLocalSystemTime().toDate());
        syncStatusDAO.updateByUserIdSelective(syncStatus);
    }

    private void setRateSyncDoing(Long userId, Date rateStartDate, Date rateEndDate, Byte syncType) {
        SyncStatus syncStatus = new SyncStatus();
        syncStatus.setUserId(userId);
        syncStatus.setRateSyncStatus(RATE_SYNC_STATUS_DOING);
        syncStatus.setLastRateStartTime(rateStartDate);
        syncStatus.setLastRateEndTime(rateEndDate);
        syncStatus.setRateSyncOwner(appService.getOwner());
        syncStatus.setLastRateSyncStartTime(appService.getLocalSystemTime().toDate());
        if (syncType == RATE_SYNC_STATUS_INIT) {
            syncStatus.setRateStartTime(rateStartDate);
        }
        syncStatusDAO.updateByUserIdSelective(syncStatus);
    }

    private void internalSync(Long userId, Date startDate, Date endDate) throws TaobaoAccessControlException,
            TaobaoEnhancedApiException,
            TaobaoSessionExpiredException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        logger.info("userId[{}] start to sync rate, startDate[{}] endDate[{}]",
                userId,
                DateUtils.format(startDate, DateUtils.yyyy_MM_dd_HH_mm_ss),
                DateUtils.format(endDate, DateUtils.yyyy_MM_dd_HH_mm_ss));
        //一天同步一次 TODO 分等级按照不同的同步频率同步订单
        List<SyncRate> syncRates = Lists.newArrayList();
        for (String rateType : RATE_TYPES) {
            logger.info("userId[{}] start to sync rate[{}], startDate[{}] endDate[{}]",
                    userId,
                    rateType,
                    DateUtils.format(startDate, DateUtils.yyyy_MM_dd_HH_mm_ss),
                    DateUtils.format(endDate, DateUtils.yyyy_MM_dd_HH_mm_ss));
            long pageNum = 1;
            long pageSize = 150;
            while (true) {
                logger.info("userId[{}] start to sync [{}] page of rate[{}], startDate[{}] endDate[{}]",
                        userId,
                        pageNum,
                        rateType,
                        DateUtils.format(startDate, DateUtils.yyyy_MM_dd_HH_mm_ss),
                        DateUtils.format(endDate, DateUtils.yyyy_MM_dd_HH_mm_ss));
                TraderatesGetRequest request = new TraderatesGetRequest();
                request.setFields(COMMA_JOINER.join(RATE_FIELDS));
                request.setRateType("get");
                request.setRole("buyer");
                request.setResult(rateType);
                request.setPageNo(pageNum);
                request.setPageSize(pageSize);
                request.setUseHasNext(true);
                request.setStartDate(startDate);
                request.setEndDate(endDate);

                TraderatesGetResponse response = taobaoApiShopService.getRates(userId, request);
                List<TradeRate> rates = response.getTradeRates();
                if (CollectionUtils.isNotEmpty(rates)) {
                    syncRates.addAll(buildSyncRates(userId, rates));
                    if (rates.size() < pageSize) {
                        break;
                    }
                } else {
                    break;
                }

                //insert db
                if (syncRates.size() >= 500) {
                    int rows = syncRateDAO.batchInsertSelective(syncRates);
                    logger.info("userId[{}] batch insert [{}/{}], sync [{}] page of rate[{}], startDate[{}] endDate[{}]",
                            userId,
                            rows,
                            syncRates.size(),
                            pageNum,
                            rateType,
                            DateUtils.format(startDate, DateUtils.yyyy_MM_dd_HH_mm_ss),
                            DateUtils.format(endDate, DateUtils.yyyy_MM_dd_HH_mm_ss));
                    syncRates.clear();
                }
                pageNum++;
                if (pageNum >= 200) {
                    logger.info("userId[{}] pageNum[{}] >=200, rate[{}] startDate[{}] endDate[{}]",
                            userId,
                            pageNum,
                            rateType,
                            DateUtils.format(startDate, DateUtils.yyyy_MM_dd_HH_mm_ss),
                            DateUtils.format(endDate, DateUtils.yyyy_MM_dd_HH_mm_ss));
                    break;
                }
            }
        }
        //flush
        if (CollectionUtils.isNotEmpty(syncRates)) {
            int rows = syncRateDAO.batchInsertSelective(syncRates);
            logger.info("userId[{}] flush batch insert [{}/{}], startDate[{}] endDate[{}]",
                    userId,
                    rows,
                    syncRates.size(),
                    DateUtils.format(startDate, DateUtils.yyyy_MM_dd_HH_mm_ss),
                    DateUtils.format(endDate, DateUtils.yyyy_MM_dd_HH_mm_ss));
            syncRates.clear();
        }

        stopwatch.stop();
        logger.info("userId[{}] end sync rate, startDate[{}] endDate[{}], spend time [{} sec]",
                userId,
                DateUtils.format(startDate, DateUtils.yyyy_MM_dd_HH_mm_ss),
                DateUtils.format(endDate, DateUtils.yyyy_MM_dd_HH_mm_ss),
                stopwatch.elapsed(TimeUnit.SECONDS));
    }

    private List<SyncRate> buildSyncRates(Long userId, List<TradeRate> tradeRates) {
        List<SyncRate> syncRates = Lists.newArrayList();
        for (TradeRate tradeRate : tradeRates) {
            SyncRate syncRate = new SyncRate();
            syncRate.setAddTime(appService.getLocalSystemTime().toDate());
            syncRate.setContent(tradeRate.getContent());
            syncRate.setCreated(tradeRate.getCreated());
            syncRate.setItemPrice(tradeRate.getItemPrice());
            syncRate.setItemTitle(tradeRate.getItemTitle());
            syncRate.setNick(tradeRate.getNick());
            syncRate.setNumIid(tradeRate.getNumIid());
            syncRate.setOid(tradeRate.getOid());
            syncRate.setRatedNick(tradeRate.getRatedNick());
            syncRate.setReply(tradeRate.getReply());
            syncRate.setResult(tradeRate.getResult());
            syncRate.setRole(tradeRate.getRole());
            syncRate.setTid(tradeRate.getTid());
            syncRate.setUserId(userId);
            syncRate.setValidScore(tradeRate.getValidScore());

            syncRates.add(syncRate);
        }
        return syncRates;
    }

    private SyncRate buildSyncRate(Long userId, TradeRate tradeRate) {
        SyncRate syncRate = new SyncRate();
        syncRate.setAddTime(appService.getLocalSystemTime().toDate());
        syncRate.setContent(tradeRate.getContent());
        syncRate.setCreated(tradeRate.getCreated());
        syncRate.setItemPrice(tradeRate.getItemPrice());
        syncRate.setItemTitle(tradeRate.getItemTitle());
        syncRate.setNick(tradeRate.getNick());
        syncRate.setNumIid(tradeRate.getNumIid());
        syncRate.setOid(tradeRate.getOid());
        syncRate.setRatedNick(tradeRate.getRatedNick());
        syncRate.setReply(tradeRate.getReply());
        syncRate.setResult(tradeRate.getResult());
        syncRate.setRole(tradeRate.getRole());
        syncRate.setTid(tradeRate.getTid());
        syncRate.setUserId(userId);
        syncRate.setValidScore(tradeRate.getValidScore());
        return syncRate;
    }

    /**
     * 翻页获取评论
     *
     * @param request
     * @return
     */
    public Page<SyncRate> getSyncRatePage(RatePageRequest request) {
        int count = syncRateDAO.countByRatePageRequestWithUserId(request);
        List<SyncRate> syncRates = syncRateDAO.selectByRatePageRequestWithUserId(request);
        return Page.create(count, request.getPageNum(), request.getPageSize(), syncRates);
    }
}
