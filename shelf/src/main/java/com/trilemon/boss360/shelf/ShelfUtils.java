package com.trilemon.boss360.shelf;

import com.google.common.base.Function;
import com.google.common.collect.*;
import com.google.common.math.IntMath;
import com.taobao.api.domain.Item;
import com.trilemon.boss360.shelf.model.Plan;
import com.trilemon.boss360.shelf.model.PlanSetting;
import com.trilemon.boss360.shelf.web.controller.ItemController;
import com.trilemon.commons.Languages;
import com.trilemon.commons.LocalTimeInterval;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import javax.annotation.Nullable;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.List;

/**
 * @author kevin
 */
public class ShelfUtils {

    /**
     * 根据宝贝获取时间分布。
     *
     * @param plans
     * @return
     */
    public static Table<Integer, LocalTimeInterval, Integer> getDistribution(Iterable<Plan> plans) {
        Table<Integer, LocalTimeInterval, Integer> table = HashBasedTable.create();
        for (Plan plan : plans) {
            DateTime adjustDay = new DateTime(plan.getPlanAdjustDay());
            int dayOfWeek = adjustDay.getDayOfWeek();
            DateTime startHour = new DateTime(plan.getPlanAdjustStartTime());
            DateTime endHour = new DateTime(plan.getPlanAdjustEndTime());
            LocalTimeInterval localTimeInterval = new LocalTimeInterval(new LocalTime(startHour.getHourOfDay(),
                    startHour.getMinuteOfHour()), new LocalTime(endHour.getHourOfDay(), endHour.getMinuteOfHour()));
            Integer itemNum = table.get(dayOfWeek, localTimeInterval);
            if (null == itemNum) {
                table.put(dayOfWeek, localTimeInterval, 1);
            } else {
                table.put(dayOfWeek, localTimeInterval, itemNum + 1);
            }
        }
        return table;
    }

    /**
     * distribution 的格式约定为 <code> week|hour||week|hour</code>； 例如<code>1|9:00-10:00||1|10:00-12:00</code>。
     *
     * @param distribution
     * @return
     */
    public static Table<Integer, LocalTimeInterval, Integer> parseAndFillZeroDistribution(String distribution) {
        Table<Integer, LocalTimeInterval, Integer> table = HashBasedTable.create();
        for (String interval : distribution.split("\\|\\|")) {
            String[] segments = interval.split("\\|");
            //解析|分隔符
            int weekDay = Integer.valueOf(segments[0]);
            String[] hourAndMin = segments[1].split("\\-");

            //解析小时段
            String[] startHourAndMin = hourAndMin[0].split(":");
            String[] endHourAndMin = hourAndMin[1].split(":");
            LocalTime startTime = new LocalTime(Integer.valueOf(startHourAndMin[0]),
                    Integer.valueOf(startHourAndMin[1]));
            LocalTime endTime = new LocalTime(Integer.valueOf(endHourAndMin[0]),
                    Integer.valueOf(endHourAndMin[1]));

            table.put(weekDay, new LocalTimeInterval(startTime, endTime), 0);
        }
        return table;
    }

    /**
     * 从周一到周日，每日的9点到23点平均安排宝贝上下架数量
     *
     * @param itemNum 宝贝数量
     * @return
     */
    public static Table<Integer, LocalTimeInterval, Integer> getDefaultDistribution(int itemNum) {
        Table<Integer, LocalTimeInterval, Integer> table = HashBasedTable.create();
        int cellDivision = IntMath.divide(itemNum, 7 * (23 - 9), RoundingMode.CEILING);
        for (int dayOfWeek = 1; dayOfWeek <= 7; dayOfWeek++) {
            for (int hourOfDay = 9; hourOfDay <= 23; hourOfDay++) {
                if (itemNum == 0) {
                    break;
                }
                LocalTime startHour = new LocalTime(hourOfDay, 0);
                LocalTime endHour = new LocalTime(hourOfDay + 1, 0);
                table.put(dayOfWeek, new LocalTimeInterval(startHour, endHour), cellDivision);
                itemNum -= cellDivision;
            }
            if (itemNum == 0) {
                break;
            }
        }
        return table;
    }

    public static Table<Integer, LocalTimeInterval, Integer> getDefaultZeroFilledDistribution() {
        Table<Integer, LocalTimeInterval, Integer> table = HashBasedTable.create();
        for (int dayOfWeek = 1; dayOfWeek <= 7; dayOfWeek++) {
            for (int hourOfDay = 9; hourOfDay <= 23; hourOfDay++) {
                LocalTime startHour = new LocalTime(hourOfDay, 0);
                int endHourInt = hourOfDay + 1;
                LocalTime endHour = new LocalTime(endHourInt == 24 ? 0 : endHourInt, 0);
                table.put(dayOfWeek, new LocalTimeInterval(startHour, endHour), 0);
            }
        }

        return table;
    }

    public static Table.Cell<Integer, LocalTimeInterval, Integer> findMinCellOfDistribution(Table<Integer,
            LocalTimeInterval, Integer> distribution) {
        Integer minCellValue = Integer.MAX_VALUE;
        Table.Cell<Integer, LocalTimeInterval, Integer> minCell = null;
        for (Table.Cell<Integer, LocalTimeInterval, Integer> cell : distribution.cellSet()) {
            if ((null == cell.getValue()) || cell.getValue() == 0) {
                return cell;
            } else {
                if (cell.getValue() < minCellValue) {
                    minCellValue = cell.getValue();
                    minCell = cell;
                }
            }
        }
        return minCell;
    }

    public static Table<Integer, LocalTimeInterval, Integer> getNewItemDistribution(int itemNum,
                                                                                    Table<Integer, LocalTimeInterval, Integer> planDistribution,
                                                                                    Table<Integer, LocalTimeInterval, Integer> currDistribution) {
        Table<Integer, LocalTimeInterval, Integer> newItemDistribution = HashBasedTable.create();
        Table<Integer, LocalTimeInterval, Integer> combinedDistribution = combineDistribution(planDistribution, currDistribution);
        for (int index = 0; index < itemNum; index++) {
            Table.Cell<Integer, LocalTimeInterval, Integer> minCell = ShelfUtils.findMinCellOfDistribution(combinedDistribution);
            //对新的安排表赋值
            Integer newCellValue = newItemDistribution.get(minCell.getRowKey(), minCell.getColumnKey());
            newItemDistribution.put(minCell.getRowKey(), minCell.getColumnKey(), null == newCellValue ? 1 : (newCellValue += 1));
            //更新全计划表
            Integer cellValue = combinedDistribution.get(minCell.getRowKey(), minCell.getColumnKey());
            combinedDistribution.put(minCell.getRowKey(), minCell.getColumnKey(), null == cellValue ? 1 : (cellValue += 1));
        }
        return newItemDistribution;
    }

    public static Table<Integer, LocalTimeInterval, Integer> combineDistribution(Table<Integer, LocalTimeInterval,
            Integer>... distributions) {
        Table<Integer, LocalTimeInterval, Integer> combinedDistribution = HashBasedTable.create();
        for (Table<Integer, LocalTimeInterval, Integer> distribution : distributions) {
            for (Table.Cell<Integer, LocalTimeInterval, Integer> cell : distribution.cellSet()) {
                if (null != cell.getValue()) {
                    Integer cellValue = combinedDistribution.get(cell.getRowKey(), cell.getColumnKey());
                    if (null == cellValue || cellValue == 0) {
                        combinedDistribution.put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
                    } else {
                        combinedDistribution.put(cell.getRowKey(), cell.getColumnKey(), cell.getValue() + cellValue);
                    }
                }
            }
        }
        return combinedDistribution;
    }

    public static Plan buildPlan(PlanSetting planSetting, Item item, DateTime planListingDay, LocalTimeInterval hourInterval) throws
            ShelfException {
        Plan plan = new Plan();
        plan.setPlanSettingId(planSetting.getId());
        plan.setUserId(planSetting.getUserId());
        plan.setPlanAdjustDay(planListingDay.toDate());
        plan.setPlanAdjustStartTime(hourInterval.getFrom().toDateTimeToday().toDate());
        plan.setPlanAdjustEndTime(hourInterval.getTo().toDateTimeToday().toDate());
        plan.setItemNumIid(item.getNumIid());
        plan.setItemTitle(item.getTitle());
        plan.setItemPicUrl(item.getPicUrl());
        if (null != item.getSellerCids()) {
            plan.setItemSellerCid(Long.valueOf(StringUtils.remove(item.getSellerCids(), ",")));
        }
        plan.setStatus(ShelfConstants.PLAN_STATUS_WAITING_ADJUST);
        try {
            plan.setItemTitlePinyin(Languages.getHanYuPinyin(item.getTitle()));
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            throw new ShelfException("get pinyin of itemTitle[" + item.getTitle() + "] itemIid[" + item.getNumIid()
                    + "] error", e);
        }
        return plan;
    }

    public static List<Long> getPlanNumIids(List<Plan> plans) {
        return Lists.transform(plans, new Function<Plan, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable Plan input) {
                return input.getItemNumIid();
            }
        });
    }

    public static List<Item> getItems(List<Item> items, Collection<Long> numIids) {
        List<Item> filterItems = Lists.newArrayList();

        for (Item item : items) {
            if (numIids.contains(item.getNumIid())) {
                filterItems.add(item);
            }
        }
        return filterItems;
    }

    public static List<Plan> getPlans(List<Plan> plans, Collection<Long> numIids) {
        List<Plan> filerPlans = Lists.newArrayList();

        for (Plan plan : plans) {
            if (numIids.contains(plan.getItemNumIid())) {
                filerPlans.add(plan);
            }
        }
        return filerPlans;
    }

    /**
     * 将 Plan 对象转为 Item，注意是另一个 VO
     *
     * @param plans
     * @return
     */
    public static List<ItemController.Item> planToItem(List<Plan> plans) {
        List<ItemController.Item> items = Lists.newArrayList();
        for (Plan plan : plans) {
            ItemController.Item item = new ItemController.Item();
            item.setTitle(plan.getItemTitle());
            item.setNumIid(plan.getItemNumIid());
            item.setPicUrl(plan.getItemPicUrl());
            item.setExclude(plan.getStatus().equals(ShelfConstants.PLAN_STATUS_EXCLUDED));  // just for u，草
            items.add(item);
        }
        return items;
    }

    public static Multiset<Integer> getItemDayOfWeekNum(List<Item> items) {
        Multiset<Integer> dayOfWeekNum = TreeMultiset.create();
        for (Item item : items) {
            if (null != item.getDelistTime()) {
                DateTime delistDateTime = new DateTime(item.getDelistTime());
                dayOfWeekNum.add(delistDateTime.getDayOfWeek());
            }
        }
        return dayOfWeekNum;
    }
}
