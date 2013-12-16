package com.trilemon.boss.poster.recommend.dao.router;

import com.google.common.math.LongMath;
import com.trilemon.boss.poster.recommend.model.PosterRecommendPublishItemDetailPage;
import com.trilemon.commons.db.ShardTableRouter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author kevin
 */
@Component
public class PosterRecommendPublishItemDetailPageRouter extends ShardTableRouter<PosterRecommendPublishItemDetailPage> {
    @Value("${poster_recommend_publish_item_detail_page_table_num}")
    private int tableNum;

    @Override
    public int route(PosterRecommendPublishItemDetailPage detailPage) {
        checkNotNull(detailPage.getUserId(), "userId is null");
        return LongMath.mod(detailPage.getUserId(), tableNum) + 1;
    }
}
