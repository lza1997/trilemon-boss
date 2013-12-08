package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.PosterRecommendPublishItemDetailPage;

public interface PosterRecommendPublishItemDetailPageDAO {
    int deleteByPrimaryKey(Long id);

    void insert(PosterRecommendPublishItemDetailPage record);

    void insertSelective(PosterRecommendPublishItemDetailPage record);

    PosterRecommendPublishItemDetailPage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PosterRecommendPublishItemDetailPage record);

    int updateByPrimaryKeyWithBLOBs(PosterRecommendPublishItemDetailPage record);

    int updateByPrimaryKeyWithoutBLOBs(PosterRecommendPublishItemDetailPage record);
}