package com.trilemon.boss360.shelf.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;
import com.taobao.api.domain.Item;
import com.trilemon.boss360.infrastructure.base.service.AppService;
import com.trilemon.boss360.shelf.model.Plan;
import com.trilemon.boss360.shelf.model.PlanSetting;
import com.trilemon.commons.DateUtils;
import com.trilemon.commons.LocalTimeInterval;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author kevin
 */
public class TestPlanService {
    private PlanService planService=new PlanService();
    @Autowired
    private AppService appService = mock(AppService.class);

    @Test
    public void testPlan() {
        Item item1=new Item();
        item1.setTitle("测试1");
        item1.setNumIid(1L);
        item1.setPicUrl("pic1");
        Item item2=new Item();
        item2.setTitle("测试2");
        item2.setNumIid(2L);
        item2.setPicUrl("pic2");
        Item item3=new Item();
        item3.setTitle("测试3");
        item3.setNumIid(3L);
        item3.setPicUrl("pic3");
        Item item4=new Item();
        item4.setTitle("测试4");
        item4.setNumIid(4L);
        item4.setPicUrl("pic4");
        Item item5=new Item();
        item5.setTitle("测试5");
        item5.setNumIid(5L);
        item5.setPicUrl("pic5");
        Item item6=new Item();
        item6.setTitle("测试6");
        item6.setNumIid(6L);
        item6.setPicUrl("pic6");
        Item item7=new Item();
        item7.setTitle("测试7");
        item7.setNumIid(7L);
        item7.setPicUrl("pic7");
        when(appService.getLocalSystemTime()).thenReturn(DateUtils.parse("2013-01-01 23:51:00",
                DateUtils.yyyy_MM_dd_HH_mm_ss));
        planService.setAppService(appService);
        Table<Integer, LocalTimeInterval, List<Item>> table = TreeBasedTable.create();
        table.put(1, new LocalTimeInterval(9, 10), Lists.newArrayList(item1,item2));
        table.put(1, new LocalTimeInterval(10, 11), Lists.newArrayList(item3,item4));
        table.put(2, new LocalTimeInterval(9, 10), Lists.newArrayList(item5));
        table.put(3, new LocalTimeInterval(23, 0), Lists.newArrayList(item6));
        table.put(4, new LocalTimeInterval(0, 1), Lists.newArrayList(item7));
        PlanSetting planSetting = new PlanSetting();
        planSetting.setId(1L);
        planSetting.setUserId(10L);
        List<Plan> plans =planService.plan(planSetting, table);

        assertEquals(7, plans.size());
        assertEquals(DateUtils.parse("20130107",DateUtils.yyyyMMdd).toDate(), plans.get(0).getPlanAdjustDay());
        assertEquals(DateUtils.parse("20130107",DateUtils.yyyyMMdd).toDate(), plans.get(1).getPlanAdjustDay());
        assertEquals(DateUtils.parse("20130107",DateUtils.yyyyMMdd).toDate(), plans.get(2).getPlanAdjustDay());
        assertEquals(DateUtils.parse("20130107",DateUtils.yyyyMMdd).toDate(), plans.get(3).getPlanAdjustDay());
        assertEquals(DateUtils.parse("20130108",DateUtils.yyyyMMdd).toDate(), plans.get(4).getPlanAdjustDay());
        assertEquals(DateUtils.parse("20130102",DateUtils.yyyyMMdd).toDate(), plans.get(5).getPlanAdjustDay());
        assertEquals(DateUtils.parse("20130103",DateUtils.yyyyMMdd).toDate(), plans.get(6).getPlanAdjustDay());
    }
}
