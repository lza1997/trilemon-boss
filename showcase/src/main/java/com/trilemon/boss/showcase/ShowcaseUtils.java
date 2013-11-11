package com.trilemon.boss.showcase;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.taobao.api.domain.Item;
import com.trilemon.boss.showcase.model.AdjustDetail;
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

    public static List<AdjustDetail> getAdjustHistories(List<AdjustDetail> adjustDetails, Collection<Long> numIids) {
        List<AdjustDetail> filteredAdjustDetails = Lists.newArrayList();

        for (AdjustDetail adjustDetail : adjustDetails) {
            if (numIids.contains(adjustDetail.getItemNumIid())) {
                filteredAdjustDetails.add(adjustDetail);
            }
        }
        return filteredAdjustDetails;
    }

    public static AdjustDetail getAdjustDetail(List<AdjustDetail> adjustDetails, Long numIid) {
        for (AdjustDetail adjustDetail : adjustDetails) {
            if (numIid == adjustDetail.getItemNumIid()) {
                return adjustDetail;
            }
        }
        return null;
    }

    public static List<Long> getAdjustDetailsNumIids(List<AdjustDetail> adjustDetails) {
        return Lists.transform(adjustDetails, new Function<AdjustDetail, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable AdjustDetail input) {
                return input.getItemNumIid();
            }
        });
    }

    /**
     * 按照下架时间排序（越靠近下架时间越靠前）
     * @param items
     * @param reverse true desc false acs
     * @return
     */
    public static List<Item> orderItemsByDelistingTime(List<Item> items, boolean reverse) {
        if (reverse) {
            return byDelistingTimeOrdering.reverse().sortedCopy(items);
        } else {
            return byDelistingTimeOrdering.sortedCopy(items);
        }
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
