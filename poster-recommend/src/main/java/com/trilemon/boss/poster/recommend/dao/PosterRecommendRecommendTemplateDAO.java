package com.trilemon.boss.poster.recommend.dao;

import com.trilemon.boss.poster.recommend.model.PosterRecommendRecommendTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PosterRecommendRecommendTemplateDAO {

    long insertSelective(PosterRecommendRecommendTemplate record);

    PosterRecommendRecommendTemplate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PosterRecommendRecommendTemplate record);

    List<PosterRecommendRecommendTemplate> selectByRecommendType(Byte recommendType, Date now);
}