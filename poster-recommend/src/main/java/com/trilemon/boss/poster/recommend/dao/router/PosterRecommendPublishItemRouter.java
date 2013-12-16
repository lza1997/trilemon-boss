package com.trilemon.boss.poster.recommend.dao.router;

import com.google.common.math.LongMath;
import com.trilemon.boss.poster.recommend.model.PosterRecommendPublishItem;
import com.trilemon.commons.db.ShardTableRouter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author kevin
 */
@Component
public class PosterRecommendPublishItemRouter extends ShardTableRouter<PosterRecommendPublishItem> {
    @Value("${poster_recommend_publish_item_table_num}")
    private int tableNum;

    @Override
    public int route(PosterRecommendPublishItem publishItem) {
        checkNotNull(publishItem.getUserId(), "userId is null");
        return LongMath.mod(publishItem.getUserId(), tableNum) + 1;
    }
}
