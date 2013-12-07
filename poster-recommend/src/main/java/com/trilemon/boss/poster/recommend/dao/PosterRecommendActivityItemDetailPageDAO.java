package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.PosterRecommendActivityItemDetailPage;

public interface PosterRecommendActivityItemDetailPageDAO {
    int deleteByPrimaryKey(Long id);

    void insert(PosterRecommendActivityItemDetailPage record);

    void insertSelective(PosterRecommendActivityItemDetailPage record);

    PosterRecommendActivityItemDetailPage selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PosterRecommendActivityItemDetailPage record);

    int updateByPrimaryKeyWithBLOBs(PosterRecommendActivityItemDetailPage record);

    int updateByPrimaryKeyWithoutBLOBs(PosterRecommendActivityItemDetailPage record);
}