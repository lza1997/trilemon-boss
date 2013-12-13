package com.trilemon.boss.infra.sync.rate.client.impl;

import com.trilemon.boss.infra.sync.rate.client.RateClient;
import com.trilemon.boss.infra.sync.rate.client.RatePageRequest;
import com.trilemon.boss.infra.sync.rate.model.CalcSellerDayRate;
import com.trilemon.boss.infra.sync.rate.model.SyncRate;
import com.trilemon.boss.infra.sync.rate.service.RateCalcService;
import com.trilemon.boss.infra.sync.rate.service.RateSyncService;
import com.trilemon.commons.web.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author kevin
 */
@Component
public class RateClientImpl implements RateClient {
    @Autowired
    private RateSyncService rateSyncService;
    @Autowired
    private RateCalcService rateCalcService;

    @Override
    public Page<SyncRate> getSyncRates(RatePageRequest request) {
        return rateSyncService.getSyncRatePage(request);
    }

    @Override
    public CalcSellerDayRate getCalcSellerDayRate(Long userId, Date rateTime) {
        return rateCalcService.getCalcSellerDayRate(userId, rateTime);
    }
}
