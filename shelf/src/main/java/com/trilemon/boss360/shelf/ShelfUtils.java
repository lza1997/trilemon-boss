package com.trilemon.boss360.shelf;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.taobao.api.domain.Item;
import com.trilemon.boss360.shelf.model.Plan;
import com.trilemon.commons.Languages;
import com.trilemon.commons.LocalTimeInterval;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;

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
        Table<Integer, LocalTimeInterval, Integer> table = HashBasedTable.create(7, 23);
        for (Plan plan : plans) {
            DateTime adjustDateTime = new DateTime(plan.getAdjustTime());
            int dayOfWeek = adjustDateTime.getDayOfWeek();
            int hourOfDay = adjustDateTime.getHourOfDay();
            Integer itemNum = table.get(dayOfWeek, hourOfDay + 1);
            if (null == itemNum) {
                table.put(dayOfWeek, new LocalTimeInterval(hourOfDay, hourOfDay + 1), 1);
            } else {
                table.put(dayOfWeek, new LocalTimeInterval(hourOfDay, hourOfDay + 1), itemNum + 1);
            }
        }
        return table;
    }

    /**
     * distribution 的格式约定为 <code> week|hour|宝贝个数||week|hour|宝贝个数</code>； 例如<code>1|9:00-10:00||1|10:00-12:00</code>。
     *
     * @param distribution
     * @return
     */
    public static Table<Integer, LocalTimeInterval, Integer> parseDistribution(String distribution) {
        Table<Integer, LocalTimeInterval, Integer> table = HashBasedTable.create(7, 23);
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
        int cellDivision = itemNum / (7 * (23 - 9));
        int cellMod = itemNum % (7 * (23 - 9));
        for (int dayOfWeek = 1; dayOfWeek <= 7; dayOfWeek++) {
            for (int hourOfDay = 9; hourOfDay <= 23; hourOfDay++) {
                if (itemNum == 0) {
                    break;
                } else {
                    LocalTime startHour = new LocalTime(hourOfDay, 0);
                    LocalTime endHour = new LocalTime(hourOfDay + 1, 0);
                    if (cellMod == 0) {
                        table.put(dayOfWeek, new LocalTimeInterval(startHour, endHour), cellDivision + 1);
                    } else {
                        table.put(dayOfWeek, new LocalTimeInterval(startHour, endHour), cellDivision);
                        cellMod--;
                    }
                    hourOfDay += 2;
                    itemNum -= cellDivision;
                }
            }
        }
        return table;
    }

    public static Table.Cell<Integer, LocalTimeInterval, Integer> findDistributionFloorCell(Table<Integer,
            LocalTimeInterval, Integer> distribution) {
        Integer floor = Integer.MAX_VALUE;
        Table.Cell<Integer, LocalTimeInterval, Integer> floorCell = null;
        for (Table.Cell<Integer, LocalTimeInterval, Integer> cell : distribution.cellSet()) {
            if ((null != cell.getValue()) && (cell.getValue() < floor)) {
                floor = cell.getValue();
                floorCell = cell;
            }
        }
        return floorCell;
    }

    public static Table<Integer, LocalTimeInterval, Integer> getNewItemDistribution(List<Item> items,
                                                                                    Table<Integer, LocalTimeInterval, Integer>
                                                                                            currDistribution) {
        Table<Integer, LocalTimeInterval, Integer> newItemDistribution = HashBasedTable.create();
        for (Item item : items) {
            Table.Cell<Integer, LocalTimeInterval, Integer> floorCell = ShelfUtils.findDistributionFloorCell(currDistribution);
            currDistribution.put(floorCell.getRowKey(), floorCell.getColumnKey(), floorCell.getValue() + 1);

        }
        return null;
    }

    public static void listItem(Item item) throws ShelfException {

    }

    public static void delistItem(Item item) throws ShelfException {

    }

    public static Plan buildPlan(Item item, DateTime planListingDateTime, boolean isNew) throws ShelfException {
        Plan plan = new Plan();
        plan.setAdjustTime(planListingDateTime.toDate());
        plan.setItemIid(item.getNumIid());
        plan.setItemTitle(item.getTitle());
        plan.setItemPicUrl(item.getPicUrl());
        plan.setStatus(ShelfConstants.PLAN_STATUS_WAITING_ADJUST);
        if (isNew) {
            plan.setIsNewItem(true);
        } else {
            plan.setIsNewItem(false);
        }
        try {
            plan.setItemTitlePinyin(Languages.getHanYuPinyin(item.getTitle()));
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            throw new ShelfException("get pinyin of itemTitle[" + item.getTitle() + "] itemIid[" + item.getNumIid()
                    + "] error", e);
        }
        return plan;
    }
}
