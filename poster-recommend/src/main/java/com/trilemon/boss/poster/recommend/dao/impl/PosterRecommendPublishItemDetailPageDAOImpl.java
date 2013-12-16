package com.trilemon.boss.poster.recommend.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendPublishItemDetailPageDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendPublishItemDetailPage;
import com.trilemon.commons.db.ShardTableRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static com.google.common.base.Preconditions.checkNotNull;

public class PosterRecommendPublishItemDetailPageDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements PosterRecommendPublishItemDetailPageDAO {
    @Autowired
    @Qualifier("posterRecommendPublishItemDetailPageRouter")
    private ShardTableRouter<PosterRecommendPublishItemDetailPage> router;

    public void insertSelective(PosterRecommendPublishItemDetailPage record) {
        checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        getSqlMapClientTemplate().insert("poster_recommend_publish_item_detail_page.insertSelective", record);
    }

    public ShardTableRouter<PosterRecommendPublishItemDetailPage> getRouter() {
        return router;
    }

    public void setRouter(ShardTableRouter<PosterRecommendPublishItemDetailPage> router) {
        this.router = router;
    }
}