package com.trilemon.boss.rate.dao.router;

import com.google.common.math.LongMath;
import com.trilemon.boss.rate.model.RateFilterTrade;
import com.trilemon.commons.db.ShardTableRouter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author kevin
 */
@Component
public class RateFilterTradeRouter extends ShardTableRouter<RateFilterTrade> {
    @Value("${rate_filter_trade_table_num}")
    private int tableNum;

    @Override
    public int route(RateFilterTrade rateFilterTrade) {
        checkNotNull(rateFilterTrade.getUserId(), "userId is null");
        return LongMath.mod(rateFilterTrade.getUserId(), tableNum) + 1;
    }
}
