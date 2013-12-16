package com.trilemon.boss.poster.recommend.dao.impl;

import com.alibaba.cobarclient.MysdalCobarSqlMapClientDaoSupport;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendUserDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendUser;
import com.trilemon.commons.db.ShardTableRouter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static com.google.common.base.Preconditions.checkNotNull;

public class PosterRecommendUserDAOImpl extends MysdalCobarSqlMapClientDaoSupport implements PosterRecommendUserDAO {
    @Autowired
    @Qualifier("posterRecommendUserRouter")
    private ShardTableRouter<PosterRecommendUser> router;

    public long insertSelective(PosterRecommendUser record) {
        checkNotNull(record.getUserId());
        router.routeAndSetTableId(record);
        return (long) getSqlMapClientTemplate().insert("poster_recommend_user.insertSelective", record);
    }

    public int updateByUserIdSelective(Long userId) {
        PosterRecommendUser _key = new PosterRecommendUser();
        _key.setUserId(userId);
        router.routeAndSetTableId(_key);
        return (int) getSqlMapClientTemplate().update("poster_recommend_user.updateByUserIdSelective", _key);
    }

    @Override
    public PosterRecommendUser selectByUserId(Long userId) {
        PosterRecommendUser _key = new PosterRecommendUser();
        _key.setUserId(userId);
        router.routeAndSetTableId(_key);
        return (PosterRecommendUser) getSqlMapClientTemplate().queryForObject("poster_recommend_user.selectByUserId", _key);
    }

    public ShardTableRouter<PosterRecommendUser> getRouter() {
        return router;
    }

    public void setRouter(ShardTableRouter<PosterRecommendUser> router) {
        this.router = router;
    }
}