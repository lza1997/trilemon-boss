package com.trilemon.boss360.shelf.service;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.taobao.api.ApiException;
import com.taobao.api.domain.Item;
import com.taobao.api.request.ItemsOnsaleGetRequest;
import com.trilemon.boss360.infrastructure.base.client.BaseClient;
import com.trilemon.boss360.infrastructure.base.serivce.TaobaoApiService;
import com.trilemon.boss360.shelf.ShelfException;
import com.trilemon.boss360.shelf.dao.PlanMapper;
import com.trilemon.boss360.shelf.model.Plan;
import com.trilemon.boss360.shelf.model.PlanSetting;
import com.trilemon.commons.DateUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.Interval;
import org.joda.time.Seconds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author kevin
 */
@Service
public class PlanService {
//    private final static Logger logger = LoggerFactory.getLogger(PlanService.class);
//    @Autowired
//    private TaobaoApiService taobaoApiService;
//    @Autowired
//    private PlanMapper planMapper;
//    @Autowired
//    private PlanSettingService planSettingService;
//    @Autowired
//    private BaseClient baseClient;
//    private Ordering<Item> delistingOrdering = new Ordering<Item>() {
//        @Override
//        public int compare(@Nullable Item left, @Nullable Item right) {
//            checkNotNull(left);
//            checkNotNull(right);
//            if (left == right) {
//                return 0;
//            }
//            return (int) (left.getDelistTime().getTime() - right.getDelistTime().getTime());
//        }
//    };
//
//    public void savePlan(PlanSetting planSetting) {
//        List<Plan> plans = plan(planSetting);
//        planMapper.insert(plans);
//    }
//
//    public List<Plan> plan(PlanSetting planSetting) throws ShelfException {
//        try {
//            List<Item> items = getPlanItems(planSetting);
//            if (CollectionUtils.isNotEmpty(items)) {
//                List<Plan> plans = plan(planSetting, items);
//                return plans;
//            } else {
//                return Lists.newArrayList();
//            }
//        } catch (ApiException e) {
//            ShelfException shelfException = new ShelfException("getPlanItems error," +
//                    "planSetting[" + ToStringBuilder.reflectionToString(planSetting) + "]");
//            throw shelfException;
//        }
//
//    }
//
//    private List<Plan> plan(PlanSetting planSetting, List<Item> items) {
//        List<Item> sortedItems = delistingOrdering.sortedCopy(items);
//        Map<Interval, Integer> intervals = (Map<Interval, Integer>) planSetting.getParsedAdjustPeriod();
//        List<Plan> plans = Lists.newArrayList();
//        for (Map.Entry<Interval, Integer> intervalEntry : intervals.entrySet()) {
//            Interval interval = intervalEntry.getKey();
//            int itemNum = intervalEntry.getValue();
//            Seconds seconds = interval.toDuration().toStandardSeconds();
//            List<Item> subItems = Lists.newArrayList();
//            if (sortedItems.size() >= itemNum) {
//                // subItemList.addAll();
//            }
//            Iterable<List<Item>> dist = Iterables.partition(subItems, seconds.getSeconds() / 2);
//
//            for (List<Item> partitionItems : dist) {
//                for (Item item : partitionItems) {
//                    Plan plan = new Plan();
//                    plan.setPlanListingTime(interval.getStart().plusSeconds(1).toDate());
//                    plan.setItemIid(item.getNumIid());
//                }
//            }
//        }
//        return plans;
//    }
//
//    /**
//     * @param planSetting
//     * @return
//     */
//    private List<Item> getPlanItems(PlanSetting planSetting) throws ApiException {
//        List<Item> totalItems = Lists.newArrayList();
//        long userId = planSetting.getUserId();
//        boolean adjustShowcase = planSetting.getAdjustShowcase();
//        String appKey = taobaoApiService.getTaobaoAppKey();
//        long pageSize = 100;
//        long pageNum = 1;
//        while (true) {
//            ItemsOnsaleGetRequest request = new ItemsOnsaleGetRequest();
//            if (!adjustShowcase) {
//                request.setHasShowcase(false);
//            }
//            request.setFields(Joiner.on(",").join("num_iid", "delist_time"));
//            request.setPageNo(pageNum);
//            request.setPageSize(pageSize);
//            List<Item> onSaleItems = baseClient.getOnSaleItemsByUserId(request, appKey, userId);
//            if (onSaleItems.size() == 0) {
//                break;
//            } else {
//                pageNum++;
//            }
//            List<Item> items = Lists.transform(onSaleItems, new Function<Item, Item>() {
//                @Nullable
//                @Override
//                public Item apply(@Nullable Item input) {
//                    if (null == input.getDelistTime()) {
//                        input.setDelistTime(DateUtils.parse("1986-02-10 00:00:00", DateUtils.yyyy_MM_dd_HH_mm_ss).toDate());
//                    }
//                    return input;
//                }
//            });
//            totalItems.addAll(items);
//        }
//        logger.info("userId[{}] get {} item to plan", userId, totalItems.size());
//        return totalItems;
//    }
//
//    public void execPlan(Plan plan) {
//    }
}
