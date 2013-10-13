package com.trilemon.boss360.shelf;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.trilemon.commons.TimeInterval;
import org.joda.time.LocalTime;

/**
 * @author kevin
 */
public class ShelfUtils {
    /**
     * intervals的格式约定为 week(1)|time(9:00-10:00)|宝贝个数(2)；其中 week 为1~7，time 为00:00~23:00
     * 举例：7|9:00-12:00|2||7|10:00-23:00|2
     *
     * @param intervals
     * @return
     */
    public static Table<Integer, TimeInterval, Integer> parseIntervals(String intervals) {
        Table<Integer, TimeInterval, Integer> table = HashBasedTable.create(7, 23);
        for (String interval : intervals.split("\\|\\|")) {
            String[] segments = interval.split("\\|");
            //解析|分隔符
            int weekDay = Integer.valueOf(segments[0]);
            String[] hourAndMin = segments[1].split("\\-");
            int num = Integer.valueOf(segments[2]);

            //解析小时段
            String[] startHourAndMin=hourAndMin[0].split(":");
            String[] endHourAndMin=hourAndMin[1].split(":");
            LocalTime startTime = new LocalTime(Integer.valueOf(startHourAndMin[0]),
                    Integer.valueOf(startHourAndMin[1]));
            LocalTime endTime = new LocalTime(Integer.valueOf(endHourAndMin[0]),
                    Integer.valueOf(endHourAndMin[1]));

            table.put(weekDay, new TimeInterval(startTime,endTime),num);
        }
        return table;
    }
}
