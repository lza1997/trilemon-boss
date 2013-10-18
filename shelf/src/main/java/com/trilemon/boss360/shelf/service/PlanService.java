package com.trilemon.boss360.shelf.service;

import com.google.common.base.Predicate;
import com.google.common.collect.*;
import com.google.common.math.IntMath;
import com.taobao.api.domain.Item;
import com.trilemon.boss360.infrastructure.base.client.BaseClient;
import com.trilemon.boss360.infrastructure.base.service.AppService;
import com.trilemon.boss360.infrastructure.base.service.TaobaoApiService;
import com.trilemon.boss360.infrastructure.base.service.api.EnhancedApiException;
import com.trilemon.boss360.infrastructure.base.service.api.TaobaoApiShopService;
import com.trilemon.boss360.infrastructure.base.util.TopApiUtils;
import com.trilemon.boss360.shelf.ShelfConstants;
import com.trilemon.boss360.shelf.ShelfException;
import com.trilemon.boss360.shelf.ShelfUtils;
import com.trilemon.boss360.shelf.dao.PlanMapper;
import com.trilemon.boss360.shelf.dao.PlanSettingMapper;
import com.trilemon.boss360.shelf.model.Plan;
import com.trilemon.boss360.shelf.model.PlanSetting;
import com.trilemon.commons.LocalTimeInterval;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;
import org.joda.time.LocalTime;
import org.joda.time.Minutes;
import org.joda.time.Seconds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static com.trilemon.boss360.shelf.ShelfUtils.buildPlan;

/**
 * @author kevin
 */
@Service
public class PlanService {
    private final static Logger logger = LoggerFactory.getLogger(PlanService.class);
    @Autowired
    private TaobaoApiService taobaoApiService;
    @Autowired
    private PlanMapper planMapper;
    @Autowired
    private PlanSettingMapper planSettingMapper;
    @Autowired
    private PlanSettingService planSettingService;
    @Autowired
    private AppService applicationService;
    @Autowired
    private BaseClient baseClient;
    @Autowired
    private TaobaoApiShopService taobaoApiShopService;

    /**
     * 更新一个计划。
     *
     * @param planSetting
     * @throws ShelfException
     */
    public void updatePlan(Long userId, PlanSetting planSetting) throws ShelfException {
        //所有在售宝贝
        List<Item> onSaleItems = null;
        try {
            onSaleItems = taobaoApiShopService.getOnSaleItems(userId, ShelfConstants.ITEM_FIELDS,
                    TopApiUtils.getSellerCatIds(planSetting.getIncludeCids()));
        } catch (EnhancedApiException e) {
            new ShelfException("update plan error, userId[" + userId + "], PlanSetting[" + ToStringBuilder.reflectionToString
                    (planSetting) + "]", e);
        }
        Set<Long> onSaleNumIids = Sets.newHashSet(TopApiUtils.getItemNumIids(onSaleItems));

        //所有计划中宝贝
        List<Plan> runningPlans = planMapper.selectByUserIdAndPlanSettingId(userId, planSetting.getId());
        final List<Long> runningPlanNumIids = ShelfUtils.getPlanNumIids(runningPlans);

        //正在运行的的并且有效的宝贝NumIid
        Set<Long> validItemNumIids = Sets.intersection(Sets.newHashSet(onSaleNumIids),
                Sets.newHashSet(runningPlanNumIids));

        //计划中失效宝贝NumIid
        runningPlanNumIids.removeAll(validItemNumIids);

        //需要加入计划的新加入宝贝NumIid
        onSaleNumIids.removeAll(validItemNumIids);
        //需要加入计划的新加入宝贝
        List<Item> newItems = Lists.newArrayList();
        for (Item item : onSaleItems) {
            if (onSaleNumIids.contains(item.getNumIid())) {
                newItems.add(item);
            }
        }
        //删除计划中失效宝贝
        planMapper.batchDeleteByNumIid(userId, planSetting.getId(), runningPlanNumIids);
        //更新调整分布
        Iterable<Plan> validRunningPlans = Iterables.filter
                (runningPlans,
                        new Predicate<Plan>() {
                            @Override
                            public boolean apply(@Nullable Plan input) {
                                return runningPlanNumIids.contains(input.getItemNumIid());
                            }
                        });
        Table<Integer, LocalTimeInterval, Integer> currDistribution = ShelfUtils.getDistribution(validRunningPlans);
        //为新添宝贝安排具体的调整时间
        Table<Integer, LocalTimeInterval, List<Item>> assignTable = avgAssignNewItems(newItems, currDistribution);
        //安排计划
        List<Plan> plans = plan(planSetting, assignTable);
        planMapper.batchInsert(plans);
    }

    /**
     * 安排单个计划并保存
     *
     * @param planSetting
     * @throws ShelfException
     */
    public void plan(Long userId, PlanSetting planSetting) throws ShelfException {
        try {
            List<Item> items = taobaoApiShopService.getOnSaleItems(userId, ShelfConstants.ITEM_FIELDS,
                    TopApiUtils.getSellerCatIds(planSetting.getIncludeCids()));
            //确保是这个用户的计划设置
            planSetting.setUserId(userId);
            List<Plan> plans = plan(planSetting, items);
            planMapper.batchInsert(plans);
        } catch (EnhancedApiException e) {
            throw new ShelfException(e);
        }
    }

    /**
     * 依据计划设置安排计划，并且返回计划列表。
     *
     * @param planSetting
     * @param items
     * @return 不会返回 null，如果没有计划，返回一个空的集合
     */
    private List<Plan> plan(PlanSetting planSetting, List<Item> items) throws ShelfException {
        Table<Integer, LocalTimeInterval, List<Item>> assignTable = null;
        switch (planSetting.getDistributionType()) {
            case ShelfConstants.PLAN_SETTING_DISTRIBUTE_TYPE_AUTO:
                //首先平均，然后后续采用智能分析 TODO
                assignTable = autoAssignItems(items);
                break;
            case ShelfConstants.PLAN_SETTING_DISTRIBUTE_TYPE_MANUAL:
                assignTable = manualAssignItems(planSetting, items);
                break;
        }
        if (null == assignTable) {
            throw new ShelfException("plan for userId[" + planSetting.getUserId() + "] planSettingId[" + planSetting.getId() + "] " +
                    "error, assign table is null.");
        }
        return plan(planSetting, assignTable);
    }

    /**
     * @param planSetting
     * @param assignTable
     * @return
     */
    private List<Plan> plan(PlanSetting planSetting, Table<Integer, LocalTimeInterval, List<Item>> assignTable) {
        List<Plan> plans = Lists.newArrayList();

        DateTime now = applicationService.getLocalSystemTime();
        DateTime tomorrow = now.plusDays(1).withTimeAtStartOfDay();
        DateTime firstAdjustDay = now;
        //如果离第二天小于15分钟，就把首次调整计划安排到第二天
        if (Minutes.minutesBetween(now, tomorrow).getMinutes() >= 15) {
            firstAdjustDay = now.plusDays(1);
        }
        int firstAdjustDayOfWeek = firstAdjustDay.getDayOfWeek();
        for (Map.Entry<Integer, Map<LocalTimeInterval, List<Item>>> intervalDay : assignTable.rowMap().entrySet()) {
            for (Map.Entry<LocalTimeInterval, List<Item>> intervalHour : intervalDay.getValue().entrySet()) {
                LocalTimeInterval localTimeInterval = intervalHour.getKey();
                List<Item> items = intervalHour.getValue();
                int intervalSeconds = Seconds.secondsBetween(localTimeInterval.getFrom(), localTimeInterval.getTo()).getSeconds();

                //1 宝贝数量小于时间间隔的总秒数：最快1秒钟上下架一个宝贝 2 宝贝数量大于时间间隔的总秒数，则一秒钟上下架多个宝贝
                if (items.size() <= intervalSeconds) {
                    int segmentSeconds = IntMath.divide(intervalSeconds, items.size(), RoundingMode.CEILING);
                    LocalTime index;
                    for (Item item : items) {
                        DateTime planListingDateTime = firstAdjustDay.plusDays(Math.abs(intervalDay.getKey() - firstAdjustDayOfWeek));
                        index = localTimeInterval.getFrom().plusSeconds(segmentSeconds);
                        planListingDateTime = planListingDateTime.withMillisOfDay(index.getMillisOfDay());
                        try {
                            Plan plan = buildPlan(item, planListingDateTime, false);
                            plans.add(plan);
                        } catch (ShelfException e) {
                            logger.error("plan error, planSettingID[" + planSetting.getId() + "]", e);
                        }
                    }
                } else {
                    Iterable<List<Item>> itemsPartitionList = Iterables.partition(items, intervalSeconds);
                    LocalTime index;
                    for (List<Item> itemPartition : itemsPartitionList) {
                        DateTime planListingDateTime = firstAdjustDay.plusDays(Math.abs(intervalDay.getKey() - firstAdjustDayOfWeek));
                        index = localTimeInterval.getFrom().plusSeconds(1);
                        planListingDateTime = planListingDateTime.withMillisOfDay(index.getMillisOfDay());
                        for (Item item : itemPartition) {
                            try {
                                Plan plan = buildPlan(item, planListingDateTime, false);
                                plans.add(plan);
                            } catch (ShelfException e) {
                                logger.error("plan error, planSettingID[" + planSetting.getId() + "]", e);
                            }
                        }
                    }
                }
            }
        }
        return plans;
    }

    private Table<Integer, LocalTimeInterval, List<Item>> avgAssignNewItems(List<Item> items, Table<Integer, LocalTimeInterval, Integer> currDistribution) {
        Table<Integer, LocalTimeInterval, Integer> newItemDistribution = ShelfUtils.getNewItemDistribution(items, currDistribution);
        return assignItems(items, newItemDistribution);
    }

    /**
     * 平均分布商品
     *
     * @param items
     * @return
     */
    private Table<Integer, LocalTimeInterval, List<Item>> autoAssignItems(List<Item> items) {
        Table<Integer, LocalTimeInterval, Integer> distribution = ShelfUtils.getDefaultDistribution(items.size());
        return assignItems(items, distribution);
    }

    /**
     * 平均分布商品到用户指定的时段
     *
     * @param planSetting
     * @param items
     * @return
     */
    private Table<Integer, LocalTimeInterval, List<Item>> manualAssignItems(PlanSetting planSetting, List<Item> items) {
        Table<Integer, LocalTimeInterval, Integer> distribution = ShelfUtils.parseAndFillZeroDistribution(planSetting
                .getDistribution());
        return assignItems(items, distribution);
    }

    /**
     * 把宝贝平均的安排到计划时间段
     *
     * @param items
     * @param intervals
     * @return
     */
    private Table<Integer, LocalTimeInterval, List<Item>> assignItems(List<Item> items, Table<Integer, LocalTimeInterval, Integer> intervals) {
        Table<Integer, LocalTimeInterval, List<Item>> assignTable = HashBasedTable.create();
        int fromIndex = 0;
        for (Table.Cell<Integer, LocalTimeInterval, Integer> cell : intervals.cellSet()) {
            assignTable.put(cell.getRowKey(), cell.getColumnKey(),
                    items.subList(fromIndex, fromIndex + (cell.getValue() - 1)));
            fromIndex += cell.getValue();
        }
        return assignTable;
    }

    public void execPlan(Long userId, Long planSettingId) {
    }

    public List<Plan> searchPlanItem(Long userId, String keyword) {
        return null;
    }

    public void pausePlan(Long userId, Long planSettingId) {

    }

    public void resumePlan(Long userId, Long planSettingId) {

    }

    @Transactional
    public void deletePlan(Long userId, Long planSettingId) {
        planMapper.deleteByUserIdAndPlanSettingId(userId, planSettingId);
        planSettingMapper.deleteByPrimaryKeyAndUserId(planSettingId, userId);
    }
}