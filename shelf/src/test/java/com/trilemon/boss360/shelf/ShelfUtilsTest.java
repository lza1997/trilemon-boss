package com.trilemon.boss360.shelf;

import com.google.common.collect.Table;
import com.trilemon.commons.LocalTimeInterval;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author kevin
 */
public class ShelfUtilsTest {

    @Test
    public void testParseDistribution() {
        Table<Integer, LocalTimeInterval, Integer> table = ShelfUtils.parseAndFillZeroDistribution("1|9:00-10:00||2|9:00-10:00||2|10:00-11:00");
        assertEquals(table.rowKeySet().size(), 2);
        assertEquals(table.columnKeySet().size(), 2);
        assertEquals(table.cellSet().size(), 3);
        assertEquals(table.get(1, new LocalTimeInterval(9, 10)).intValue(), 0);
        assertEquals(table.get(2, new LocalTimeInterval(9, 10)).intValue(), 0);
        assertEquals(table.get(2, new LocalTimeInterval(10, 11)).intValue(), 0);
    }
}
