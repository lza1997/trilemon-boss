package com.trilemon.boss.poster.recommend.dao;

import com.google.common.collect.ImmutableList;
import com.trilemon.boss.poster.recommend.model.PosterRecommendUser;

import java.util.List;

public interface PosterRecommendUserDAO {

    Long insertSelective(PosterRecommendUser record);

    Integer updateByUserIdSelective(Long userId);

    PosterRecommendUser selectByUserId(Long userId);

    List<PosterRecommendUser> paginateUsersByStatus(ImmutableList<Byte> statusList, int offset, int limit);

    Integer countUsersByStatus(ImmutableList<Byte> statusList);
}