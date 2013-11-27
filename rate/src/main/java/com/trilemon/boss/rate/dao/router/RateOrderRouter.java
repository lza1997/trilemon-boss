package com.trilemon.boss.rate.dao.router;

import com.google.common.math.LongMath;
import com.trilemon.boss.rate.model.RateOrder;
import com.trilemon.commons.db.ShardTableRouter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author kevin
 */
@Component
public class RateOrderRouter extends ShardTableRouter<RateOrder> {
    @Value("${rate_order_table_num}")
    private int tableNum;

    @Override
    public int route(RateOrder rateOrder) {
        checkNotNull(rateOrder.getUserId(), "userId is null");
        return LongMath.mod(rateOrder.getUserId(), tableNum) + 1;
    }
}
