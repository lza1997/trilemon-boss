package com.trilemon.boss360.shelf.service.job;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.trilemon.boss360.infrastructure.base.service.AbstractQueueService;
import com.trilemon.boss360.shelf.ShelfConstants;
import com.trilemon.boss360.shelf.dao.PlanMapper;
import com.trilemon.boss360.shelf.dao.PlanSettingMapper;
import com.trilemon.boss360.shelf.model.PlanSetting;
import com.trilemon.boss360.shelf.service.PlanService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * 根据{@link PlanSetting}生成计划。
 *
 * @author kevin
 */
public class PlanJob extends AbstractQueueService<PlanSetting> {
    @Autowired
    private PlanService planService;
    @Autowired
    private PlanMapper planMapper;
    @Autowired
    private PlanSettingMapper planSettingMapper;

    @PostConstruct
    public void init() {
        reboot();
        startPoll();
    }

    @Override
    public void timeout() {
    }

    @Override
    public void fillQueue() {
        int offset = 0;
        while (true) {
            List<PlanSetting> tradeAsyncList = planSettingMapper.paginateByStatus(offset,
                    100, ImmutableList.of(ShelfConstants.PLAN_SETTING_STATUS_WAITING_PLAN));
            if (CollectionUtils.isEmpty(tradeAsyncList)) {
                break;
            } else {
                fillQueue(tradeAsyncList);
            }
        }
    }

    @Override
    public void process(PlanSetting planSetting) throws Exception {
        planService.createPlan(planSetting.getUserId(), planSetting);
    }
}
