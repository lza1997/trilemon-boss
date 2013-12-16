package com.trilemon.boss.poster.recommend.dao.router;

import com.google.common.math.LongMath;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivityItem;
import com.trilemon.commons.db.ShardTableRouter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author kevin
 */
@Component
public class PosterRecommendActivityItemRouter extends ShardTableRouter<PosterRecommendActivityItem> {
    @Value("${poster_recommend_activity_item_table_num}")
    private int tableNum;

    @Override
    public int route(PosterRecommendActivityItem activityItem) {
        checkNotNull(activityItem.getUserId(), "userId is null");
        return LongMath.mod(activityItem.getUserId(), tableNum) + 1;
    }
}
