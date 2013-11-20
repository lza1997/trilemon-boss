package com.trilemon.boss.center;

import com.google.common.base.Function;
import com.google.common.collect.*;
import com.trilemon.boss.center.model.PlanDistribution;
import com.trilemon.commons.JsonMapper;
import com.trilemon.commons.LocalTimeInterval;
import com.trilemon.commons.NumberUtils;
import org.apache.commons.collections.CollectionUtils;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * 安排计划的公共类
 * <p/>
 * 1. TimeDistribution item在哪些周天和时间段有分布 * <p/> 2. NumDistribution item在哪些周天和时间段有分布
 * <p/>
 * 3. ItemDistributionTable item分布矩阵
 * <p/>
 * 4. ItemDistributionInstanceTable 生成一个item分布实例
 *
 * @author kevin
 */
public class PlanDistributionUtils {
    /**
     * 得到默认的计划分布（周一到周七，每天9点到23点）
     *
     * @return json 串
     */
    public static String getDefaultTimeDistributionJson() {
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
     * 从 time dist json 获取TimeDistribution
     *
     * @param timeDistributionJson
     * @return
     * @throws Exception
     */
    public static Map<String, Map<String, Boolean>> getTimeDistribution(String timeDistributionJson) throws Exception {
        return (Map<String, Map<String, Boolean>>) JsonMapper.nonEmptyMapper().fromJson2Map(timeDistributionJson);
    }

    /**
     * 根据宝贝获取时间周天小时分布。
     *
     * @param planDistributions
     * @return
     */
    public static Table<Integer, LocalTimeInterval, Integer> getNumDistributionTable(
            Iterable<? extends PlanDistribution> planDistributions) {
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
     * 根据宝贝获取时间周天分布。
     *
     * @param planDistributions
     * @return
     */
    public static HashMultiset<Integer> getDayOfWeekNumDist(
            Iterable<? extends PlanDistribution> planDistributions) {
        HashMultiset<Integer> dist = HashMultiset.create();
        for (PlanDistribution planDistribution : planDistributions) {
            DateTime adjustDay = new DateTime(planDistribution.getPlanAdjustDay());
            int dayOfWeek = adjustDay.getDayOfWeek();
            dist.add(dayOfWeek);
        }
        return dist;
    }

    /**
     * 解析宝贝的分布并且用0填充个数
     *
     * @param timeDistributionJson 时间分布json
     * @return
     */
    public static Table<Integer, LocalTimeInterval, Integer> getEmptyNumDistributionTable
    (String timeDistributionJson) throws Exception {
        Table<Integer, LocalTimeInterval, Integer> table = TreeBasedTable.create();
        Map<String, Map<String, Boolean>> timeDistribution = getTimeDistribution(timeDistributionJson);
        for (Map.Entry<String, Map<String, Boolean>> day : timeDistribution.entrySet()) {
            for (Map.Entry<String, Boolean> hour : day.getValue().entrySet()) {
                if (hour.getValue()) {
                    int hourOfDay = Integer.valueOf(hour.getKey());
                    LocalTime startTime = new LocalTime(hourOfDay, 0);
                    LocalTime endTime = new LocalTime((hourOfDay + 1) == 24 ? 0 : (hourOfDay + 1), 0);
                    table.put(Integer.valueOf(day.getKey()), new LocalTimeInterval(startTime, endTime), 0);
                }
            }
        }
        return table;
    }

    /**
     * 寻找分布矩阵中最小的单元格
     *
     * @param numDistributionTable
     * @return
     */
    public static Table.Cell<Integer, LocalTimeInterval, Integer> findMinCell(Table<Integer,
            LocalTimeInterval, Integer> numDistributionTable) {
        //最小单元格
        Table.Cell<Integer, LocalTimeInterval, Integer> minCell = null;
        //先搜索小时，在搜索天
        for (LocalTimeInterval column : numDistributionTable.columnKeySet()) {
            for (Integer row : numDistributionTable.rowKeySet()) {
                for (Table.Cell<Integer, LocalTimeInterval, Integer> cell : numDistributionTable.cellSet()) {
                    if (cell.getRowKey() == row && cell.getColumnKey() == column) {
                        minCell = cell;
                        if (cell.getValue() == 0) {
                            return cell;
                        } else {
                            if (cell.getValue() < minCell.getValue()) {
                                minCell = cell;
                            }
                        }
                    }
                }
            }
        }
        return minCell;
    }

    /**
     * 合并多个分布矩阵
     *
     * @param distributions
     * @return
     */
    public static Table<Integer, LocalTimeInterval, Integer> combineNumDistributionTable(Table<Integer, LocalTimeInterval,
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
     * 获取时间分布中的小时，从小到大排序.
     *
     * @param timeDistribution
     * @return
     */
    public static List<Integer> getSortedHoursTimeDist(Map<String, Map<String, Boolean>> timeDistribution) {
        Set<String> hourStrSet = Sets.newHashSet();
        for (Map<String, Boolean> value : timeDistribution.values()) {
            hourStrSet.addAll(value.keySet());
        }
        List<Integer> hours = Lists.transform(Lists.newArrayList(hourStrSet), new Function<String, Integer>() {
            @Nullable
            @Override
            public Integer apply(@Nullable String input) {
                return Integer.valueOf(NumberUtils.toNumberString(input));
            }
        });

        List<Integer> sortedHours = Ordering.natural().sortedCopy(hours);
        return sortedHours;
    }

    /**
     * 判断指定时间是否在允许的时间分布表中
     *
     * @param timeDistribution
     * @param day
     * @param hour
     * @return
     */
    public static boolean isInTimeDist(Map<String, Map<String, Boolean>> timeDistribution, String day, String hour) {
        Map<String, Boolean> hoursMap = timeDistribution.get(day);
        if (null != hoursMap) {
            Boolean cell = hoursMap.get(hour);
            if (null != cell && cell) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param items
     * @param timeDistribution
     * @param startDay
     * @param startHour
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> Table<DateTime, LocalTimeInterval, List<T>> getItemDistributionInstanceTable(List<T> items,
                                                                                                   Map<String, Map<String, Boolean>> timeDistribution,
                                                                                                   DateTime startDay,
                                                                                                   int startHour) throws Exception {
        checkArgument(startHour <= 23, "startHour should lg 23");

        Table<DateTime, LocalTimeInterval, List<T>> resultTable = TreeBasedTable.create();
        if (CollectionUtils.isEmpty(items)) {
            return resultTable;
        }
        //已经处理分配的 item 指针
        int itemIndex = 0;

        //给起始时间分配一个宝贝
        Map<String, Boolean> startHourDist = timeDistribution.get(String.valueOf(startDay.getDayOfWeek()));
        if (null != startHourDist) {
            //给起始小时分配一个宝贝（如果不存在就向后寻找一个最近的小时）
            for (int hourIndex = startHour; hourIndex <= 23; hourIndex++) {
                if (null != startHourDist.get(String.valueOf(hourIndex)) && startHourDist.get(String.valueOf(hourIndex))) {
                    LocalTime startHourLocalTime = new LocalTime(hourIndex, 0);
                    LocalTime endHourLocalTime = new LocalTime((hourIndex + 1) == 24 ? 0 : (hourIndex + 1), 0);
                    resultTable.put(startDay, new LocalTimeInterval(startHourLocalTime, endHourLocalTime), items.subList(itemIndex, 1));
                    itemIndex++;
                    break;
                }
            }
        }

        //然后从第二天开始分配item
        int startDayOfWeek = startDay.getDayOfWeek();
        int currDayOfWeek = startDayOfWeek + 1;
        List<Integer> hours = getSortedHoursTimeDist(timeDistribution);
        while (true) {
            for (Integer hour : hours) {
                //然后从第二天开始循环到一下周今天分配宝贝
                for (int dayIndex = currDayOfWeek; dayIndex <= currDayOfWeek + 7; dayIndex++) {
                    int dayOfWeek = (dayIndex > 7) ? (dayIndex - 7) : dayIndex;
                    if (isInTimeDist(timeDistribution, String.valueOf(dayOfWeek), String.valueOf(hour))) {
                        if (itemIndex >= items.size()) {
                            return resultTable;
                        }

                        LocalTime startHourLocalTime = new LocalTime(hour, 0);
                        LocalTime endHourLocalTime = new LocalTime((hour + 1) == 24 ? 0 : (hour + 1), 0);
                        LocalTimeInterval localTimeInterval = new LocalTimeInterval(startHourLocalTime, endHourLocalTime);
                        //判断日期
                        DateTime day;
                        if (dayOfWeek >= startDayOfWeek) {
                            day = startDay.plusDays(dayOfWeek - startDayOfWeek);
                        } else {
                            day = startDay.plusDays(7 - startDayOfWeek + dayOfWeek);
                        }
                        List<T> cellItems = resultTable.get(day, localTimeInterval);
                        if (CollectionUtils.isNotEmpty(cellItems)) {
                            cellItems.add(items.get(itemIndex));
                        } else {
                            resultTable.put(day, new LocalTimeInterval(startHourLocalTime, endHourLocalTime),
                                   Lists.newArrayList(items.get(itemIndex)));
                        }
                        itemIndex++;
                    }
                }
            }
            if (itemIndex >= items.size()) {
                break;
            }
        }
        return resultTable;
    }

    /**
     * 把宝贝平均的安排到计划时间段
     * <p/>
     * 1. 首先指定的周天的某个小时开始安排1个宝贝
     * <p/>
     * 2. 然后从第二天开始（到下一个周的今天的startHour前一个小时结束）从最早的时间开始平均安排剩下的宝贝
     *
     * @param items
     * @param timeDistributionJson
     * @param startDay             起始安排的周天
     * @param startHour            起始安排的小时
     * @param <T>
     * @return
     */
    public static <T> Table<DateTime, LocalTimeInterval, List<T>> getItemDistributionInstanceTable(List<T> items,
                                                                                                   String timeDistributionJson,
                                                                                                   DateTime startDay,
                                                                                                   int startHour) throws Exception {
        Map<String, Map<String, Boolean>> timeDistribution = getTimeDistribution(timeDistributionJson);
        return getItemDistributionInstanceTable(items, timeDistribution, startDay, startHour);
    }

    /**
     * 加入新的 item，得到新加入的 item 的时间分布表
     *
     * @param timeDistribution
     * @param plans
     * @param items
     * @param startDay
     * @param startHour
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> Table<DateTime, LocalTimeInterval, List<T>> getNewNumDistributionInstanceTable(String
                                                                                                             timeDistribution,
                                                                                                     List<? extends PlanDistribution> plans,
                                                                                                     List<T> items,
                                                                                                     DateTime startDay,
                                                                                                     int startHour) throws Exception {
        Table<Integer, LocalTimeInterval, Integer> numDistributionTable = getNumDistributionTable(plans);
        Table<Integer, LocalTimeInterval, Integer> emptyNumDistributionTable = getEmptyNumDistributionTable(timeDistribution);
        Table<Integer, LocalTimeInterval, Integer> combinedDistribution = combineNumDistributionTable(numDistributionTable, emptyNumDistributionTable);

        Table<Integer, LocalTimeInterval, List<T>> newNumDistTable = TreeBasedTable.create();
        for (T t : items) {
            Table.Cell<Integer, LocalTimeInterval, Integer> minCell = findMinCell(combinedDistribution);
            List<T> addedItems = newNumDistTable.get(minCell.getRowKey(), minCell.getColumnKey());
            if (null == addedItems) {
                addedItems = Lists.newArrayList();
                newNumDistTable.put(minCell.getRowKey(), minCell.getColumnKey(), addedItems);
            }
            addedItems.add(t);
            //更新全计划表
            Integer cellValue = combinedDistribution.get(minCell.getRowKey(), minCell.getColumnKey());
            combinedDistribution.put(minCell.getRowKey(), minCell.getColumnKey(), null == cellValue ? 1 : (cellValue += 1));
        }

        return getItemDistributionInstanceTable(items, timeDistribution, startDay, startHour);
    }
}
