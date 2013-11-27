package com.trilemon.boss.infra.sync.rate.service;

import com.google.common.base.Stopwatch;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.infra.sync.rate.dao.CalcSellerDayRateDAO;
import com.trilemon.boss.infra.sync.rate.dao.SyncRateDAO;
import com.trilemon.boss.infra.sync.rate.dao.SyncStatusDAO;
import com.trilemon.boss.infra.sync.rate.model.CalcSellerDayRate;
import com.trilemon.boss.infra.sync.rate.model.SyncStatus;
import com.trilemon.boss.rate.model.dto.RateStatus;
import com.trilemon.commons.DateUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static com.trilemon.boss.infra.sync.rate.RateSyncConstants.*;

/**
 * @author kevin
 */
@Service
public class RateCalcService {
    private static Logger logger = LoggerFactory.getLogger(RateCalcService.class);
    @Autowired
    private SyncStatusDAO syncStatusDAO;
    @Autowired
    private SyncRateDAO syncRateDAO;
    @Autowired
    private CalcSellerDayRateDAO calcSellerDayRateDAO;
    @Autowired
    private AppService appService;

    public void calcSellerDayRate(Long userId) {
        SyncStatus syncStatus = syncStatusDAO.selectByUserId(userId);

        DateTime endDateTime = getCalcSellerDayRateEndDateTime(syncStatus);

        switch (syncStatus.getCalcSellerDayRateStatus()) {
            case RATE_CALC_SELLER_DAY_RATE_STATUS_INIT:
                calcSellerDayRate(userId,
                        new DateTime(syncStatus.getRateStartTime()),
                        endDateTime);
                break;
            case RATE_CALC_SELLER_DAY_RATE_STATUS_SUCCESSFUL:
                calcSellerDayRate(userId,
                        new DateTime(syncStatus.getLastCalcSellerDayRateEndTime()),
                        endDateTime);
                break;
            case RATE_CALC_SELLER_DAY_RATE_STATUS_FAILED:
                calcSellerDayRate(userId,
                        new DateTime(syncStatus.getLastCalcSellerDayRateStartTime()),
                        endDateTime);
                break;
        }
    }

    private DateTime getCalcSellerDayRateEndDateTime(SyncStatus syncStatus) {
        Date endDate = null;
        switch (syncStatus.getRateSyncStatus()) {
            case RATE_SYNC_STATUS_SUCCESSFUL:
                endDate = syncStatus.getLastRateEndTime();
                break;
            case RATE_SYNC_STATUS_FAILED:
                endDate = syncStatus.getRateStartTime();
                break;
        }
        if (null == endDate) {
            endDate = DateUtils.endOfYesterday().toDate();
        }
        DateTime endDateTime = new DateTime(endDate);
        if (endDateTime.isBefore(appService.getLocalSystemTime().withTimeAtStartOfDay())) {
            //如果当天还没到最后一秒钟，那么只能计算前一天的
            if (endDateTime.isBefore(DateUtils.endOf(endDateTime))) {
                return DateUtils.endOf(endDateTime).minusDays(1);
            } else {
                return endDateTime;
            }
        } else {
            return DateUtils.endOfYesterday();
        }
    }

    public void calcSellerDayRate(Long userId, DateTime startDateTime, DateTime endDateTime) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        logger.info("start to calc userId[{}] startDate[{}] endDate[{}]",
                userId,
                startDateTime.toString(DateUtils.yyyy_MM_dd_HH_mm_ss),
                endDateTime.toString(DateUtils.yyyy_MM_dd_HH_mm_ss));

        startDateTime = startDateTime.withTimeAtStartOfDay();
        endDateTime = DateUtils.endOf(endDateTime);
        DateTime tempStartDateTime = new DateTime(startDateTime);
        for (; startDateTime.isBefore(endDateTime); startDateTime = startDateTime.plusDays(1)) {
            logger.info("calculating... userId[{}] startDate[{}] endDate[{}]",
                    userId,
                    startDateTime.toString(DateUtils.yyyy_MM_dd_HH_mm_ss),
                    DateUtils.endOf(startDateTime).toString(DateUtils.yyyy_MM_dd_HH_mm_ss));

            RateStatus rateStatus = syncRateDAO.calcSellerDayRate(userId,
                    startDateTime.toDate(),
                    DateUtils.endOf(startDateTime).toDate());
            CalcSellerDayRate calcSellerDayRate = new CalcSellerDayRate();
            calcSellerDayRate.setAddTime(appService.getLocalSystemTime().toDate());
            calcSellerDayRate.setRateTime(startDateTime.withTimeAtStartOfDay().toDate());
            calcSellerDayRate.setUserId(userId);
            calcSellerDayRate.setGoodRateNum(rateStatus.getGoodRateNum());
            calcSellerDayRate.setNeutralRateNum(rateStatus.getNeutralRateNum());
            calcSellerDayRate.setBadRateNum(rateStatus.getBadRateNum());

            calcSellerDayRateDAO.replaceSelective(calcSellerDayRate);
        }

        stopwatch.stop();
        logger.info("end to calc userId[{}] startDate[{}] endDate[{}], spend time [{}] sec",
                userId,
                tempStartDateTime.toString(DateUtils.yyyy_MM_dd_HH_mm_ss),
                endDateTime.toString(DateUtils.yyyy_MM_dd_HH_mm_ss),
                stopwatch.elapsed(TimeUnit.SECONDS));
    }
}
