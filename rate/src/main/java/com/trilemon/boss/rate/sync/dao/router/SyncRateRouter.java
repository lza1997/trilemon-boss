package com.trilemon.boss.rate.sync.dao.router;

import com.alibaba.cobarclient.route.ShardTableRouter;
import com.google.common.math.LongMath;
import com.trilemon.boss.rate.sync.model.SyncRate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author kevin
 */
@Component
public class SyncRateRouter extends ShardTableRouter<SyncRate> {
    @Value("#{sync_rate_table_num}")
    private int tableNum;

    @Override
    public int route(SyncRate syncRate) {
        checkNotNull(syncRate.getUserId(), "userId is null");
        return LongMath.mod(syncRate.getUserId(), tableNum);
    }

}
