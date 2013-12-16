package com.trilemon.boss.poster.recommend.dao.router;

import com.google.common.math.LongMath;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivity;
import com.trilemon.commons.db.ShardTableRouter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author kevin
 */
@Component
public class PosterRecommendActivityRouter extends ShardTableRouter<PosterRecommendActivity> {
    @Value("${poster_recommend_activity_table_num}")
    private int tableNum;

    @Override
    public int route(PosterRecommendActivity activity) {
        checkNotNull(activity.getUserId(), "userId is null");
        return LongMath.mod(activity.getUserId(), tableNum) + 1;
    }
}
