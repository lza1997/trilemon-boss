package com.trilemon.boss.rate.sync.service;

import com.google.common.base.Stopwatch;
import com.trilemon.boss.rate.sync.dao.CalcMemberDayRateDAO;
import com.trilemon.boss.rate.sync.dao.CalcSellerDayRateDAO;
import com.trilemon.boss.rate.sync.dao.SyncRateDAO;
import com.trilemon.boss.rate.sync.model.CalcMemberDayRate;
import com.trilemon.boss.rate.sync.model.CalcSellerDayRate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author kevin
 */
@Service
public class RateCalcService {
    private static Logger logger = LoggerFactory.getLogger(RateCalcService.class);
    @Autowired
    private SyncRateDAO syncRateDAO;
    @Autowired
    private CalcSellerDayRateDAO calcSellerDayRateDAO;
    @Autowired
    private CalcMemberDayRateDAO calcMemberDayRateDAO;

    public void calcSellerDayRate(Long userId) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        logger.info("start to calc userId[{}]", userId);

        CalcSellerDayRate calcSellerDayRate = syncRateDAO.calcSellerDayRate(userId);
        calcSellerDayRateDAO.insertSelective(calcSellerDayRate);

        stopwatch.stop();
        logger.info("end to calc userId[{}], spend time [{}] sec", userId, stopwatch.elapsed(TimeUnit.SECONDS));
    }

    public void calcMemberDayRate(String buyerNick) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        logger.info("start to calc buyerNick[{}]", buyerNick);

        CalcMemberDayRate calcMemberDayRate = syncRateDAO.calcMemberDayRate(buyerNick);
        calcMemberDayRateDAO.insertSelective(calcMemberDayRate);

        stopwatch.stop();
        logger.info("end to calc buyerNick[{}], spend time [{}] sec", buyerNick, stopwatch.elapsed(TimeUnit.SECONDS));
    }
}
