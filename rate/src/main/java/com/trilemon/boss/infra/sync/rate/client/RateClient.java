package com.trilemon.boss.infra.sync.rate.client;

import com.trilemon.boss.infra.sync.rate.model.SyncRate;
import com.trilemon.commons.web.Page;

/**
 * @author kevin
 */
public interface RateClient {
    Page<SyncRate> getSyncRates(RatePageRequest request);
}
