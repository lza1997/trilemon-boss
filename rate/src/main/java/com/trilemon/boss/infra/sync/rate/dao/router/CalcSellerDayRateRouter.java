package com.trilemon.boss.infra.sync.rate.dao.router;

import com.google.common.math.LongMath;
import com.trilemon.boss.infra.sync.rate.model.CalcSellerDayRate;
import com.trilemon.commons.db.ShardTableRouter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author kevin
 */
@Component
public class CalcSellerDayRateRouter extends ShardTableRouter<CalcSellerDayRate> {
    @Value("${calc_seller_day_rate_table_num}")
    private int tableNum;

    @Override
    public int route(CalcSellerDayRate calcSellerDayRate) {
        checkNotNull(calcSellerDayRate.getUserId(), "userId is null");
        return LongMath.mod(calcSellerDayRate.getUserId(), tableNum) + 1;
    }
}
