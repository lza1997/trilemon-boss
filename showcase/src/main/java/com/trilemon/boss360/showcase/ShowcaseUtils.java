package com.trilemon.boss360.showcase;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.taobao.api.domain.Item;
import com.trilemon.boss360.showcase.model.AdjustHistory;
import org.joda.time.DateTime;
import org.joda.time.Minutes;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;

/**
 * @author kevin
 */
public class ShowcaseUtils {
    public static final Ordering<Item> byDelistingTimeOrdering = new Ordering<Item>() {
        @Override
        public int compare(@Nullable Item left, @Nullable Item right) {
            return left.getDelistTime().compareTo(right.getDelistTime());
        }
    };

    public static List<AdjustHistory> getAdjustHistories(List<AdjustHistory> adjustHistories, Collection<Long> numIids) {
        List<AdjustHistory> filerPlans = Lists.newArrayList();

        for (AdjustHistory adjustHistory : adjustHistories) {
            if (numIids.contains(adjustHistory.getItemNumIid())) {
                filerPlans.add(adjustHistory);
            }
        }
        return filerPlans;
    }

    public static AdjustHistory getAdjustHistory(List<AdjustHistory> adjustHistories, Long numIid) {
        for (AdjustHistory adjustHistory : adjustHistories) {
            if (numIid == adjustHistory.getItemNumIid()) {
                return adjustHistory;
            }
        }
        return null;
    }

    public static List<Long> getAdjustHistoryNumIids(List<AdjustHistory> adjustHistories) {
        return Lists.transform(adjustHistories, new Function<AdjustHistory, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable AdjustHistory input) {
                return input.getItemNumIid();
            }
        });
    }

    /**
     * 按照下架时间排序（越靠近下架时间越靠前）
     *
     * @param items
     * @return
     */
    public static List<Item> orderItemsByDelistingTime(List<Item> items) {
        return byDelistingTimeOrdering.sortedCopy(items);
    }

    /**
     * 库存是否小于给定值
     *
     * @param item
     * @param numLt
     * @return
     */
    public static boolean isItemInventoryLt(Item item, int numLt) {
        return item.getNum() < numLt;
    }


    /**
     * 下架时间是否在指定分钟之内
     *
     * @param item
     * @param minWithin
     * @return
     */
    public static boolean isItemDelistingWithin(Item item, int minWithin, DateTime baseDateTime) {
        DateTime delistingDateTime = new DateTime(item.getDelistTime());
        if (delistingDateTime.isAfter(baseDateTime)) {
            return false;
        } else {
            if (Minutes.minutesBetween(baseDateTime, delistingDateTime).getMinutes() <= minWithin) {
                return true;
            } else {
                return false;
            }
        }
    }
}
