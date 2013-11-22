package com.trilemon.boss.shelf.service;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import com.taobao.api.domain.Item;
import com.taobao.api.request.ItemUpdateDelistingRequest;
import com.taobao.api.request.ItemUpdateListingRequest;
import com.taobao.api.request.ItemsOnsaleGetRequest;
import com.taobao.api.response.ItemUpdateDelistingResponse;
import com.taobao.api.response.ItemUpdateListingResponse;
import com.taobao.api.response.ItemsOnsaleGetResponse;
import com.trilemon.boss.center.PlanDistributionUtils;
import com.trilemon.boss.center.model.PlanDistribution;
import com.trilemon.boss.infra.base.client.BaseClient;
import com.trilemon.boss.infra.base.model.TaobaoSession;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.infra.base.service.TaobaoApiService;
import com.trilemon.boss.infra.base.service.api.TaobaoApiShopService;
import com.trilemon.boss.infra.base.service.api.exception.BaseTaobaoApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.infra.base.util.TopApiUtils;
import com.trilemon.boss.shelf.ShelfConstants;
import com.trilemon.boss.shelf.ShelfException;
import com.trilemon.boss.shelf.ShelfUtils;
import com.trilemon.boss.shelf.dao.PlanMapper;
import com.trilemon.boss.shelf.dao.PlanSettingMapper;
import com.trilemon.boss.shelf.model.Plan;
import com.trilemon.boss.shelf.model.PlanSetting;
import com.trilemon.commons.Collections3;
import com.trilemon.commons.DateUtils;
import com.trilemon.commons.LocalTimeInterval;
import com.trilemon.commons.mybatis.MyBatisBatchWriter;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.trilemon.boss.shelf.ShelfUtils.buildPlan;

/**
 * @author kevin
 */
@Service
public class PlanService {
    private final static Logger logger = LoggerFactory.getLogger(PlanService.class);
    @Autowired
    private PlanMapper planMapper;
    @Autowired
    private PlanSettingMapper planSettingMapper;
    @Autowired
    private AppService appService;
    @Autowired
    private TaobaoApiShopService taobaoApiShopService;
    @Autowired
    private BaseClient baseClient;
    @Autowired
    private TaobaoApiService taobaoApiService;
    @Autowired
    private MyBatisBatchWriter myBatisBatchWriter;

    /**
     * 更新一个计划。
     *
     * @throws ShelfException
     */
    public void updatePlan(Long userId, Long planSettingId) throws TaobaoSessionExpiredException,
            TaobaoEnhancedApiException, TaobaoAccessControlException, ShelfException {
        PlanSetting planSetting = planSettingMapper.selectByPrimaryKey(planSettingId);
        checkNotNull(planSetting, "planSetting[%s] is null.", planSettingId);
        //清理过期宝贝
        // TODO 过期的宝贝用另外一种标识符代替，现在在界面上会并入「新加入宝贝」显示，参见 issue-51。
        DateTime now = appService.getLocalSystemTime();
        int deletedPlanNum = planMapper.deleteByPlanSettingIdAndStatusAndPlanTime(planSettingId,
                ImmutableList.of(ShelfConstants.PLAN_STATUS_WAITING_ADJUST),
                now.withTimeAtStartOfDay().toDate(),
                now.toDate());
        logger.debug("delete [{}] expired plans, checkpoint[{}].", deletedPlanNum,
                now.toString(DateUtils.yyyy_MM_dd_HH_mm_ss));
        if (deletedPlanNum > 0) {
            logger.info("delete [{}] expired items, checkpoint[{}].", deletedPlanNum, now.toString(DateUtils.yyyy_MM_dd_HH_mm_ss));
        }
        //所有在售宝贝
        ItemsOnsaleGetRequest request = new ItemsOnsaleGetRequest();
        request.setFields(Joiner.on(",").join(ShelfConstants.ITEM_FIELDS));
        request.setSellerCids(planSetting.getIncludeSellerCids());
        ItemsOnsaleGetResponse result = taobaoApiShopService.getOnSaleItems(planSetting.getUserId(), request);

        List<Item> onSaleItems = result.getItems();

        if (null == onSaleItems) {
            logger.info("onsale item is empty, userId[{}], PlanSettingId[{}]", planSetting.getUserId(),
                    planSetting.getId());
            return;
        }

        Set<Long> onSaleNumIids = Sets.newHashSet(TopApiUtils.getItemNumIids(onSaleItems));

        //所有需要排除宝贝
        Iterable<Long> excludeItemNumIids = null;

        if (StringUtils.isNotBlank(planSetting.getExcludeItemNumIids())) {
            excludeItemNumIids = Iterables.transform(Splitter.on(",").split(planSetting.getExcludeItemNumIids
                    ()),
                    new Function<String, Long>() {
                        @Nullable
                        @Override
                        public Long apply(@Nullable String input) {
                            return Long.valueOf(input);
                        }
                    });
        }

        //所有计划中宝贝
        List<Plan> runningPlans = planMapper.selectByPlanSettingId(planSetting.getId());
        final List<Long> runningPlanNumIids = ShelfUtils.getPlanNumIids(runningPlans);

        //正在计划中的并且在售的宝贝NumIid
        Set<Long> existAndOnSaleItemNumIids = Sets.intersection(Sets.newHashSet(onSaleNumIids),
                Sets.newHashSet(runningPlanNumIids));

        //计划中失效宝贝NumIid
        List<Long> invalidPlanItemNumIids = ListUtils.removeAll(runningPlanNumIids,
                existAndOnSaleItemNumIids);

        //需要加入计划的新加入宝贝NumIid
        List<Long> newItemNumIids = ListUtils.removeAll(onSaleNumIids, existAndOnSaleItemNumIids);

        //需要加入计划的新加入宝贝
        List<Item> newItems = TopApiUtils.getItems(onSaleItems, newItemNumIids);

        //1. 删除计划中失效宝贝
        if (CollectionUtils.isNotEmpty(invalidPlanItemNumIids)) {
            planMapper.deleteByUserIdAndNumIids(planSetting.getUserId(), invalidPlanItemNumIids);
        }

        //2. 加入新宝贝
        if (CollectionUtils.isEmpty(newItems)) {
            return;
        }
        List<Plan> validPlans = ShelfUtils.getPlans(runningPlans, existAndOnSaleItemNumIids);
        //安排计划
        try {
            List<Plan> plans = getPlans4Update(planSetting, validPlans, newItems);
            //为排除宝贝计划生成标志位
            if (null != excludeItemNumIids) {
                for (Plan plan : plans) {
                    if (Iterables.contains(excludeItemNumIids, plan.getItemNumIid())) {
                        plan.setStatus(ShelfConstants.PLAN_STATUS_EXCLUDED);
                    }
                }
            }
            savePlan(planSetting.getId(), plans);
            logger.info("userId[{}] generate {} plans for planSettingId[{}].", userId, plans.size(), planSetting.getId());
        } catch (Exception e) {
            throw new ShelfException(e);
        }
    }

    /**
     * 安排计划并保存
     *
     * @param planSetting
     * @throws ShelfException
     */
    public void createPlan(Long userId, PlanSetting planSetting) throws ShelfException, TaobaoSessionExpiredException, TaobaoAccessControlException, TaobaoEnhancedApiException {
        checkArgument(userId.equals(planSetting.getUserId()), "userId[%s] is not equal with userId of planSetting[%s]",
                userId, planSetting.getUserId());
        ItemsOnsaleGetRequest request = new ItemsOnsaleGetRequest();
        request.setFields(Joiner.on(",").join(ShelfConstants.ITEM_FIELDS));
        request.setSellerCids(planSetting.getIncludeSellerCids());
        ItemsOnsaleGetResponse result = taobaoApiShopService.getOnSaleItems(userId, request);

        //获取已经计划的宝贝
        List<Long> usedItemNumIids = planMapper.selectNumIidsByUserId(userId);
        try {
            List<Plan> plans = getPlans4Create(planSetting, TopApiUtils.excludeItems(result.getItems(), usedItemNumIids));
            logger.info("userId[{}] generate {} plans for planSettingId[{}].", userId, plans.size(), planSetting.getId());
            savePlan(planSetting.getId(), plans);
        } catch (Exception e) {
            throw new ShelfException(e);
        }
    }

    @Transactional
    private void savePlan(Long planSettingId, List<Plan> plans) {
        if (CollectionUtils.isNotEmpty(plans)) {
            for (Plan plan : plans) {
                plan.setAddTime(appService.getLocalSystemTime().toDate());
            }
            myBatisBatchWriter.write("com.trilemon.boss.shelf.dao.PlanMapper.insertSelective", plans);
        }
        PlanSetting planSetting = new PlanSetting();
        planSetting.setId(planSettingId);
        planSetting.setStatus(ShelfConstants.PLAN_SETTING_STATUS_RUNNING);
        planSetting.setLastPlanTime(appService.getLocalSystemTime().toDate());
        planSettingMapper.updateByPrimaryKeySelective(planSetting);
    }

    /**
     * 依据计划设置安排计划，并且返回计划列表。
     *
     * @param planSetting {@link PlanSetting}
     * @param items       需要纳入计划的宝贝
     * @return 不会返回 null，如果没有计划，返回一个空的集合
     */
    private List<Plan> getPlans4Create(PlanSetting planSetting, List<Item> items) throws Exception {
        DateTime startDay = getPlanStartDay();
        Table<DateTime, LocalTimeInterval, List<Item>> itemDistTable = PlanDistributionUtils
                .getItemDistributionInstanceTable(items, planSetting.getDistribution(),
                        startDay,
                        startDay.getHourOfDay());
        return plan(planSetting, itemDistTable);
    }

    public List<Plan> getPlans4Update(PlanSetting setting, List<? extends PlanDistribution> assignedPlans,
                                      List<Item> items)
            throws Exception {
        DateTime firstAdjustDay = getPlanStartDay();
        Table<DateTime, LocalTimeInterval, List<Item>> itemDistTable = PlanDistributionUtils.getNewNumDistributionInstanceTable(setting.getDistribution(),
                assignedPlans,
                items,
                firstAdjustDay,
                firstAdjustDay.getHourOfDay());
        if (null == itemDistTable) {
            throw new ShelfException("userId[" + setting.getUserId() + "] assign table is null.");
        }
        return plan(setting, itemDistTable);
    }

    private List<Plan> plan(PlanSetting planSetting, Table<DateTime, LocalTimeInterval, List<Item>> itemDistTable) {
        List<Plan> plans = Lists.newArrayList();
        for (Table.Cell<DateTime, LocalTimeInterval, List<Item>> cell : itemDistTable.cellSet()) {
            List<Item> items = cell.getValue();
            if (CollectionUtils.isNotEmpty(items)) {
                for (Item item : items) {
                    try {
                        Plan plan = buildPlan(planSetting,
                                item,
                                cell.getRowKey(),
                                cell.getColumnKey());
                        plans.add(plan);
                    } catch (ShelfException e) {
                        logger.error("plan error, planSettingId[" + planSetting.getId() + "]", e);
                    }
                }
            }
        }
        return plans;
    }

    private DateTime getPlanStartDay() {
        DateTime now = appService.getLocalSystemTime();
        DateTime tomorrow = now.plusDays(1).withTimeAtStartOfDay();
        //第一次调整是周几
        DateTime firstAdjustDay = now;
        //如果离第二天小于10分钟，就把首次调整计划安排到第二天
        if (Minutes.minutesBetween(now, tomorrow).getMinutes() < 10) {
            firstAdjustDay = now.plusDays(1);
        }
        return firstAdjustDay;
    }

    public void execPlan(Long planSettingId) throws TaobaoSessionExpiredException, TaobaoAccessControlException, TaobaoEnhancedApiException {
        DateTime now = appService.getLocalSystemTime();
        List<Plan> plans = planMapper.selectByPlanSettingIdAndStatusAndPlanTime(planSettingId,
                ImmutableList.of(ShelfConstants.PLAN_STATUS_WAITING_ADJUST, ShelfConstants.PLAN_STATUS_FAILED),
                now.withTimeAtStartOfDay().toDate(),
                now.toDate());
        logger.info("planSetting[{}] get [{}] plan to adjust", planSettingId, plans.size());
        for (Plan plan : plans) {
            execPlan(plan);
        }
    }

    private void execPlan(Plan plan) throws TaobaoAccessControlException, TaobaoSessionExpiredException, TaobaoEnhancedApiException {
        DateTime now = appService.getLocalSystemTime();
        if (now.toLocalTime().getMillisOfDay() < plan.getPlanAdjustStartTime().getTime()) {
            logger.info("planId[{}] is delay, startTime[{}] but now[{}]", plan.getId(),
                    DateUtils.format(plan.getPlanAdjustEndTime(), DateUtils.yyyy_MM_dd_HH_mm_ss),
                    now.toString(DateUtils.yyyy_MM_dd_HH_mm_ss));
        }

        Plan planResult = new Plan();
        planResult.setId(plan.getId());
        ItemUpdateDelistingRequest request = new ItemUpdateDelistingRequest();
        request.setNumIid(plan.getItemNumIid());
        planResult.setAdjustTime(appService.getLocalSystemTime().toDate());
        TaobaoSession taobaoSession = baseClient.getTaobaoSession(plan.getUserId(), taobaoApiService.getAppKey());
        try {
            //下架
            ItemUpdateDelistingResponse delistingResponse = taobaoApiService.request(request,
                    taobaoSession.getAccessToken());
            if (delistingResponse.isSuccess() || delistingResponse.getSubCode().equals("isv.item-listing-service-error")) {
                //获取商品数量
                Item item = taobaoApiShopService.getItem(plan.getUserId(), plan.getItemNumIid(),
                        ImmutableList.of("num"));
                //上架
                ItemUpdateListingRequest listingRequest = new ItemUpdateListingRequest();
                listingRequest.setNumIid(plan.getItemNumIid());
                listingRequest.setNum(item.getNum());
                ItemUpdateListingResponse listingResponse = taobaoApiService.request(listingRequest,
                        taobaoSession.getAccessToken());
                if (listingResponse.isSuccess()) {
                    planResult.setFailedCause("");
                    planResult.setStatus(ShelfConstants.PLAN_STATUS_SUCCESSFUL);
                } else {
                    planResult.setStatus(ShelfConstants.PLAN_STATUS_FAILED);
                    planResult.setFailedCause(listingResponse.getSubCode() + listingResponse.getSubMsg());
                }
            } else {
                planResult.setStatus(ShelfConstants.PLAN_STATUS_FAILED);
                planResult.setFailedCause(delistingResponse.getSubCode() + delistingResponse.getSubMsg());
            }
        } catch (BaseTaobaoApiException e) {
            planResult.setStatus(ShelfConstants.PLAN_STATUS_FAILED);
            planResult.setFailedCause(ToStringBuilder.reflectionToString(e));
            planMapper.updateByPrimaryKeySelective(planResult);
            throw e;
        }
        planMapper.updateByPrimaryKeySelective(planResult);
    }

    public void deletePlan(Long userId, Long planSettingId) {
        planMapper.deleteByUserIdAndPlanSettingId(userId, planSettingId);
    }

    public void excludeItem(Long userId, Long planSettingId, Long numIid) {
        excludeOrIncludeItem(userId, planSettingId, numIid, true);
    }

    public void includeItem(Long userId, Long planSettingId, Long numIid) {
        excludeOrIncludeItem(userId, planSettingId, numIid, false);
    }

    @Transactional
    public void excludeOrIncludeItem(Long userId, Long planSettingId, Long numIid, boolean exclude) {
        Plan plan = new Plan();
        plan.setUserId(userId);
        plan.setItemNumIid(numIid);
        if (exclude) {
            plan.setStatus(ShelfConstants.PLAN_STATUS_EXCLUDED);
        } else {
            plan.setStatus(ShelfConstants.PLAN_SETTING_STATUS_WAITING_PLAN);
        }
        planMapper.updateByUserIdAndNumIid(plan);

        PlanSetting planSetting = planSettingMapper.selectByPrimaryKeyAndUserId(planSettingId, userId);
        String excludeItemNumIidsStr = planSetting.getExcludeItemNumIids();
        excludeItemNumIidsStr = (null == excludeItemNumIidsStr ? "" : excludeItemNumIidsStr);
        List<Long> excludeNumIids = Collections3.getLongList(excludeItemNumIidsStr);
        if (exclude) {
            excludeNumIids.add(numIid);
        } else {
            excludeNumIids.remove(numIid);
        }

        PlanSetting updateSetting = new PlanSetting();
        updateSetting.setId(planSetting.getId());
        updateSetting.setExcludeItemNumIids(Collections3.COMMA_JOINER.join(excludeNumIids));
        planSettingMapper.updateByPrimaryKeySelective(updateSetting);
    }

    public void setAppService(AppService appService) {
        this.appService = appService;
    }
}