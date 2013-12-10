package com.trilemon.boss.poster.recommend;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.taobao.api.domain.Item;
import com.trilemon.boss.poster.recommend.model.PosterRecommendActivityItem;
import com.trilemon.boss.poster.recommend.model.PosterRecommendPublishItem;
import org.joda.time.DateTime;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author kevin
 */
public class PosterRecommendUtils {
    public static List<PosterRecommendActivityItem> items2PosterRecommendActivityItems(final Long userId, final Long activityId,
                                                                                       List<Item> itemList) {
        return Lists.transform(itemList, new Function<Item, PosterRecommendActivityItem>() {
            @Nullable
            @Override
            public PosterRecommendActivityItem apply(@Nullable Item input) {
                PosterRecommendActivityItem activityItem = new PosterRecommendActivityItem();
                activityItem.setActivityId(activityId);
                activityItem.setUserId(userId);
                activityItem.setItemNumIid(input.getNumIid());
                activityItem.setItemPicUrl(input.getPicUrl());
                activityItem.setItemTitle(input.getTitle());
                activityItem.setItemPrice(new BigDecimal(input.getPrice()));
                return activityItem;
            }
        });
    }

    public static List<PosterRecommendPublishItem> items2PosterRecommendPublishItems(final Long userId,
                                                                                     final Long activityId,
                                                                                     List<Item> itemList) {
        return Lists.transform(itemList, new Function<Item, PosterRecommendPublishItem>() {
            @Nullable
            @Override
            public PosterRecommendPublishItem apply(@Nullable Item input) {
                PosterRecommendPublishItem publishItem = new PosterRecommendPublishItem();
                publishItem.setPublishTime(DateTime.now().toDate());
                publishItem.setStatus(PosterRecommendConstants.PUBLISH_ITEM_STATUS_WAITING_PUBLISH);
                publishItem.setActivityId(activityId);
                publishItem.setUserId(userId);
                publishItem.setItemNumIid(input.getNumIid());
                publishItem.setItemPicUrl(input.getPicUrl());
                publishItem.setItemTitle(input.getTitle());
                publishItem.setItemPrice(new BigDecimal(input.getPrice()));
                return publishItem;
            }
        });
    }

    public static Item posterRecommendActivityItem2Item(PosterRecommendActivityItem posterRecommendActivityItem) {
        Item item = new Item();
        item.setNumIid(posterRecommendActivityItem.getItemNumIid());
        item.setTitle(posterRecommendActivityItem.getItemTitle());
        item.setPrice(posterRecommendActivityItem.getItemPrice().toString());
        item.setPicUrl(posterRecommendActivityItem.getItemPicUrl());
        return item;
    }

    public static Item posterRecommendPublishItem2Item(PosterRecommendPublishItem posterRecommendPublishItem) {
        Item item = new Item();
        item.setNumIid(posterRecommendPublishItem.getItemNumIid());
        item.setTitle(posterRecommendPublishItem.getItemTitle());
        item.setPrice(posterRecommendPublishItem.getItemPrice().toString());
        item.setPicUrl(posterRecommendPublishItem.getItemPicUrl());
        return item;
    }
}
