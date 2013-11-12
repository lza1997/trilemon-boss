package com.trilemon.boss.showcase;

import com.google.common.collect.Lists;
import com.taobao.api.domain.Item;
import com.trilemon.commons.DateUtils;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author kevin
 */
public class ShowcaseUtilsTest {
    @Test
    public void testIsItemDelistingWithin() {
        Item item = new Item();
        item.setDelistTime(DateUtils.parse("2013-01-01 00:09:01", DateUtils.yyyy_MM_dd_HH_mm_ss).toDate());
        assertTrue(ShowcaseUtils.isItemDelistingWithin(item, 9, DateUtils.parse("2013-01-01 00:00:01",
                DateUtils.yyyy_MM_dd_HH_mm_ss)));
        assertFalse(ShowcaseUtils.isItemDelistingWithin(item, 9, DateUtils.parse("2013-01-01 00:00:00",
                DateUtils.yyyy_MM_dd_HH_mm_ss)));
        assertTrue(ShowcaseUtils.isItemDelistingWithin(item, 9, DateUtils.parse("2013-01-01 00:09:00",
                DateUtils.yyyy_MM_dd_HH_mm_ss)));
    }

    @Test
    public void testOrderItemsByDelistingTime() {
        Item item1 = new Item();
        item1.setNumIid(1L);
        item1.setDelistTime(DateUtils.parse("2013-01-01 00:00:00", DateUtils.yyyy_MM_dd_HH_mm_ss).toDate());

        Item item2 = new Item();
        item2.setNumIid(2L);
        item2.setDelistTime(DateUtils.parse("2013-01-01 00:00:00", DateUtils.yyyy_MM_dd_HH_mm_ss).toDate());

        Item item3 = new Item();
        item3.setNumIid(3L);
        item3.setDelistTime(DateUtils.parse("2013-01-01 00:00:01", DateUtils.yyyy_MM_dd_HH_mm_ss).toDate());

        List<Item> items = ShowcaseUtils.orderItemsByDelistingTime(Lists.newArrayList(item1, item2, item3), true);
        assertArrayEquals(items.toArray(new Item[0]), new Item[]{item3, item1, item2});

        items = ShowcaseUtils.orderItemsByDelistingTime(Lists.newArrayList(item1, item2, item3), false);
        assertArrayEquals(items.toArray(new Item[0]), new Item[]{item1, item2, item3});
    }
}
