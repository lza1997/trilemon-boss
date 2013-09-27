package com.trilemon.top.boss360.shelf.service;

import org.springframework.stereotype.Service;

/**
 * @author kevin
 */
@Service
public class PlanService {
//    @Autowired
//    private PlanMapper planMapper;
//    @Autowired
//    private PlanSettingService planSettingService;
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private TopItemService topItemService;
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
//    public List<Plan> plan(PlanSetting planSetting) {
//        List<Item> items = getItemsNeed2Plan(planSetting);
//        List<Plan> plans = plan(planSetting, items);
//        return plans;
//    }
//
//    private List<Plan> plan(PlanSetting planSetting, List<Item> items) {
//        List<Item> sortedItems = delistingOrdering.sortedCopy(items);
//        Map<Interval, Integer> intervals = (Map<Interval, Integer>) planSetting.getParsedAdjustPeriod();
//        List<Plan> plans = Lists.newArrayList();
//        for (Map.Entry<Interval, Integer> interval : intervals.entrySet()) {
//            Seconds seconds = interval.getKey().toDuration().toStandardSeconds();
//            List<Item> subItems = Lists.newArrayList();
//            if (sortedItems.size() >= interval.getValue()) {
//                // subItemList.addAll();
//            }
//            Iterable<List<Item>> dist = Iterables.partition(subItems, seconds.getSeconds());
//
//            for (List<Item> partitionItems : dist) {
//                for (Item item : partitionItems) {
//                    Plan plan = new Plan();
//                    plan.setPlanListingTime(interval.getKey().getStart().plusSeconds(1).toDate());
//                    plan.setItemIid(item.getNumIid());
//                }
//            }
//        }
//        return plans;
//    }
//
//    /**
//     * 考虑橱窗情况
//     *
//     * @param planSetting
//     * @return
//     */
//    private List<Item> getItemsNeed2Plan(PlanSetting planSetting) {
//        List<Item> items = Lists.transform(topItemService.getOnSaleItems(), new Function<Item, Item>() {
//            @Nullable
//            @Override
//            public Item apply(@Nullable Item input) {
//                if (null == input.getDelistTime()) {
//                    input.setDelistTime(DateUtils.parse("1986-02-10 00:00:00", DateUtils.yyyy_MM_dd_HH_mm_ss).toDate());
//                }
//                return input;
//            }
//        });
//        return items;
//    }
//
//    public void execPlan(Plan plan) {
//        boolean auth = userService.auth(plan.getUserId());
//        if (auth) {
//
//        }
//    }
}
