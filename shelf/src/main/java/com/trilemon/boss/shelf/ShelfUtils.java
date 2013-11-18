package com.trilemon.boss.shelf;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.taobao.api.domain.Item;
import com.trilemon.boss.shelf.model.Plan;
import com.trilemon.boss.shelf.model.PlanSetting;
import com.trilemon.boss.shelf.model.dto.ShelfItem;
import com.trilemon.commons.Languages;
import com.trilemon.commons.LocalTimeInterval;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.joda.time.DateTime;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.List;

/**
 * @author kevin
 */
public class ShelfUtils {

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
    public static List<ShelfItem> planToItem(List<Plan> plans) {
        List<ShelfItem> items = Lists.newArrayList();
        for (Plan plan : plans) {
            ShelfItem item = new ShelfItem();
            item.setTitle(plan.getItemTitle());
            item.setNumIid(plan.getItemNumIid());
            item.setPicUrl(plan.getItemPicUrl());
            item.setExclude(plan.getStatus().equals(ShelfConstants.PLAN_STATUS_EXCLUDED));
            items.add(item);
        }
        return items;
    }
}
