package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.PosterRecommendPublishItemDetailPage;
import org.springframework.stereotype.Repository;

@Repository
public interface PosterRecommendPublishItemDetailPageDAO {

    void insertSelective(PosterRecommendPublishItemDetailPage record);
}