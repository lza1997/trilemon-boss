package com.trilemon.boss.center;

import com.google.common.collect.*;
import com.google.common.math.IntMath;
import com.taobao.api.domain.Item;
import com.trilemon.boss.center.model.PlanDistribution;
import com.trilemon.commons.JsonMapper;
import com.trilemon.commons.LocalTimeInterval;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 安排计划的公共类
 * @author kevin
 */
public class PlanDistributionUtils {
    public static String getDefaultDistribution() {
        Map<String, Map<String, Boolean>> map = Maps.newTreeMap();
        for (int dayOfWeek = 1; dayOfWeek <= 7; dayOfWeek++) {
            Map<String, Boolean> hourMap = Maps.newTreeMap();
            for (int hour = 9; hour <= 23; hour++) {
                hourMap.put(String.valueOf(hour), true);
            }
            map.put(String.valueOf(dayOfWeek), hourMap);
        }
        return JsonMapper.nonEmptyMapper().toJson(map);
    }

    /**
     * 根据宝贝获取时间分布。
     *
     * @param planDistributions
     * @return
     */
    public static Table<Integer, LocalTimeInterval, Integer> getDistribution(Iterable<? extends PlanDistribution>
                                                                                     planDistributions) {
        Table<Integer, LocalTimeInterval, Integer> table = TreeBasedTable.create();
        for (PlanDistribution planDistribution : planDistributions) {
            DateTime adjustDay = new DateTime(planDistribution.getPlanAdjustDay());
            int dayOfWeek = adjustDay.getDayOfWeek();
            DateTime startHour = new DateTime(planDistribution.getPlanAdjustStartTime());
            DateTime endHour = new DateTime(planDistribution.getPlanAdjustEndTime());
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
     * @param distribution
     * @return
     */
    public static Table<Integer, LocalTimeInterval, Integer> parseAndFillZeroDistribution(String distribution) throws Exception {
        Table<Integer, LocalTimeInterval, Integer> table = TreeBasedTable.create();
        Map<String, Map<String, Boolean>> distributionMap = (Map<String, Map<String, Boolean>>) JsonMapper.nonEmptyMapper().fromJson2Map(distribution);
        for (Map.Entry<String, Map<String, Boolean>> day : distributionMap.entrySet()) {
            for (Map.Entry<String, Boolean> hour : day.getValue().entrySet()) {
                if (true == hour.getValue()) {
                    LocalTime startTime = new LocalTime(Integer.valueOf(hour.getKey()), 0);
                    LocalTime endTime;
                    if (Integer.valueOf(hour.getKey()) == 23) {
                        endTime = new LocalTime(0, 0);
                    } else {
                        endTime = new LocalTime(Integer.valueOf(hour.getKey()) + 1, 0);
                    }
                    table.put(Integer.valueOf(day.getKey()), new LocalTimeInterval(startTime, endTime), 0);
                }
            }
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
        Table<Integer, LocalTimeInterval, Integer> table = TreeBasedTable.create();
        int cellDivision = IntMath.divide(itemNum, 7 * (23 - 9), RoundingMode.CEILING);

        for (int hourOfDay = 9; hourOfDay <= 22; hourOfDay++) {
            for (int dayOfWeek = 1; dayOfWeek <= 7; dayOfWeek++) {
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
        Table<Integer, LocalTimeInterval, Integer> table = TreeBasedTable.create();
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
        Table.Cell<Integer, LocalTimeInterval, Integer> currentCell = null;
        Set<Table.Cell<Integer, LocalTimeInterval, Integer>> cells = distribution.cellSet();
        for (LocalTimeInterval column : distribution.columnKeySet()) {
            for (Integer row : distribution.rowKeySet()) {
                for (Table.Cell<Integer, LocalTimeInterval, Integer> c : cells) {
                    if (c.getRowKey() == row && c.getColumnKey().equals(column)) {
                        currentCell = c;
                        break;
                    }
                }
                if (null == currentCell) {
                    continue;
                }
                if ((null == currentCell.getValue()) || currentCell.getValue() == 0) {
                    return currentCell;
                } else {
                    if (currentCell.getValue() < minCellValue) {
                        minCellValue = currentCell.getValue();
                        minCell = currentCell;
                    }
                }
            }
        }
        return minCell;
    }

    public static Table<Integer, LocalTimeInterval, Integer> getNewItemDistribution(int itemNum,
                                                                                    Table<Integer, LocalTimeInterval, Integer> planDistribution,
                                                                                    Table<Integer, LocalTimeInterval, Integer> currDistribution) {
        Table<Integer, LocalTimeInterval, Integer> newItemDistribution = TreeBasedTable.create();
        Table<Integer, LocalTimeInterval, Integer> combinedDistribution = combineDistribution(planDistribution, currDistribution);
        for (int index = 0; index < itemNum; index++) {
            Table.Cell<Integer, LocalTimeInterval, Integer> minCell = findMinCellOfDistribution(combinedDistribution);
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
        Table<Integer, LocalTimeInterval, Integer> combinedDistribution = TreeBasedTable.create();
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

    /**
     * 把宝贝平均的安排到计划时间段
     *
     * @param items
     * @param distribution
     * @return
     */
    public static Table<Integer, LocalTimeInterval, List<Item>> assignItems(List<Item> items, Table<Integer,
            LocalTimeInterval, Integer> distribution) {
        Table<Integer, LocalTimeInterval, List<Item>> assignTable = TreeBasedTable.create();
        int fromIndex = 0;
        for (Table.Cell<Integer, LocalTimeInterval, Integer> cell : distribution.cellSet()) {
            assignTable.put(cell.getRowKey(), cell.getColumnKey(),
                    items.subList(fromIndex, fromIndex + cell.getValue()));
            fromIndex += cell.getValue();
        }
        return assignTable;
    }

    /**
     * 获取商品的下架分布日期（周几）分布
     * @param items
     * @return
     */
    public static Multiset<Integer> getItemDelistDayOfWeekNum(List<Item> items) {
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
