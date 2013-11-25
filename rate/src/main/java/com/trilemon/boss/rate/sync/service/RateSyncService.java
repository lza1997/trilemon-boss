package com.trilemon.boss.rate.sync.service;

import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.taobao.api.domain.TradeRate;
import com.taobao.api.request.TraderatesGetRequest;
import com.taobao.api.response.TraderatesGetResponse;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.infra.base.service.api.TaobaoApiShopService;
import com.trilemon.boss.infra.base.service.api.exception.BaseTaobaoApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.rate.sync.RateSyncConstants;
import com.trilemon.boss.rate.sync.dao.SyncRateDAO;
import com.trilemon.boss.rate.sync.dao.SyncStatusDAO;
import com.trilemon.boss.rate.sync.model.SyncRate;
import com.trilemon.boss.rate.sync.model.SyncStatus;
import com.trilemon.commons.DateUtils;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.trilemon.boss.rate.sync.RateSyncConstants.*;
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

    @PostConstruct
    public void init() {
        cleanExpiredSyncTasks();
    }

    /**
     * 删除机器启动后没有执行完毕的任务，并置为失败状态，下次重新执行。
     */
    public void cleanExpiredSyncTasks() {
        syncStatusDAO.deleteByRateSyncOwnerAndStatus(appService.getOwner(),
                ImmutableList.of(RATE_SYNC_STATUS_DOING));

    }

    public void sync(Long userId) {
        SyncStatus syncStatus = syncStatusDAO.selectByUserId(userId);
        try {
            sync(syncStatus);
        } catch (TaobaoEnhancedApiException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (TaobaoSessionExpiredException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (TaobaoAccessControlException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (RateSyncException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    private void sync(SyncStatus syncStatus) throws RateSyncException, TaobaoSessionExpiredException, TaobaoAccessControlException, TaobaoEnhancedApiException {
        Date rateSyncEndDate = null;
        switch (syncStatus.getRateSyncStatus()) {
            case RateSyncConstants.RATE_SYNC_STATUS_SUCCESSFUL:
                rateSyncEndDate = syncStatus.getRateEndTime();
                break;
            case RateSyncConstants.RATE_SYNC_STATUS_FAILED:
                rateSyncEndDate = syncStatus.getRateStartTime();
                break;
        }

        if (null == rateSyncEndDate) {
            throw new RateSyncException("rate[" + syncStatus.getUserId() + "] sync error, rateSyncEndDate is null");
        }

        try {
            setRateSyncDoing(syncStatus, rateSyncEndDate);
            internalSync(syncStatus, rateSyncEndDate);
            setRateSyncSuccessful(syncStatus, rateSyncEndDate);
        } catch (BaseTaobaoApiException e) {
            setRateSyncFailed(syncStatus, rateSyncEndDate);
            throw e;
        }
    }

    private void setRateSyncSuccessful(SyncStatus syncStatus, Date rateSyncEndDate) {

    }

    private void setRateSyncFailed(SyncStatus syncStatus, Date rateSyncEndDate) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private void setRateSyncDoing(SyncStatus syncStatus, Date rateSyncEndDate) {
        //To change body of created methods use File | Settings | File Templates.
    }

    private void internalSync(SyncStatus syncStatus, Date endDate) throws TaobaoAccessControlException,
            TaobaoEnhancedApiException,
            TaobaoSessionExpiredException {
        Long userId = syncStatus.getUserId();
        Date startDate = syncStatus.getRateStartTime();

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
                if (CollectionUtils.isNotEmpty(rates) && rates.size() == pageSize) {
                    syncRates.addAll(buildSyncRates(rates));
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
        int rows = syncRateDAO.batchInsertSelective(syncRates);
        logger.info("userId[{}] flush batch insert [{}/{}], startDate[{}] endDate[{}]",
                userId,
                rows,
                syncRates.size(),
                DateUtils.format(startDate, DateUtils.yyyy_MM_dd_HH_mm_ss),
                DateUtils.format(endDate, DateUtils.yyyy_MM_dd_HH_mm_ss));
        syncRates.clear();

        stopwatch.stop();
        logger.info("userId[{}] end sync rate, startDate[{}] endDate[{}], spend time [{} sec]",
                userId,
                DateUtils.format(startDate, DateUtils.yyyy_MM_dd_HH_mm_ss),
                DateUtils.format(endDate, DateUtils.yyyy_MM_dd_HH_mm_ss),
                stopwatch.elapsed(TimeUnit.SECONDS));
    }

    private List<SyncRate> buildSyncRates(List<TradeRate> rates) {
        return null;  //To change body of created methods use File | Settings | File Templates.
    }
}
