package com.trilemon.boss.infra.sync.rate.client;

import com.trilemon.boss.infra.sync.rate.model.CalcSellerDayRate;
import com.trilemon.boss.infra.sync.rate.model.SyncRate;
import com.trilemon.commons.web.Page;

import java.util.Date;

/**
 * @author kevin
 */
public interface RateClient {
    Page<SyncRate> getSyncRates(RatePageRequest request);
    CalcSellerDayRate getCalcSellerDayRate(Long userId,Date rateTime);
}
