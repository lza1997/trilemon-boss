package com.trilemon.boss.poster.recommend.dao.router;

import com.google.common.math.LongMath;
import com.trilemon.boss.poster.recommend.model.PosterRecommendUser;
import com.trilemon.commons.db.ShardTableRouter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author kevin
 */
@Component
public class PosterRecommendUserRouter extends ShardTableRouter<PosterRecommendUser> {
    @Value("${poster_recommend_user_table_num}")
    private int tableNum;

    @Override
    public int route(PosterRecommendUser posterRecommendUser) {
        checkNotNull(posterRecommendUser.getUserId(), "userId is null");
        return LongMath.mod(posterRecommendUser.getUserId(), tableNum) + 1;
    }
}
