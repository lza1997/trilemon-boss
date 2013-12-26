package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.PosterRecommendFavoriteTemplate;

import java.util.List;

public interface PosterRecommendFavoriteTemplateDAO {
    int deleteByUserIdAndTemplateId(Long userId, Long templateId);

    long insertSelective(PosterRecommendFavoriteTemplate record);

    PosterRecommendFavoriteTemplate selectByUserIdAndTemplateId(Long userId, Long templateId);

    int updateByUserIdAndTemplateIdSelective(PosterRecommendFavoriteTemplate record);

    List<PosterRecommendFavoriteTemplate> paginateByUserId(Long userId, int offset, int limit);

    int countByUserId(Long userId);
}