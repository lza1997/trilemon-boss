package com.trilemon.boss360.shelf.job;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.trilemon.boss360.infrastructure.base.service.AbstractQueueService;
import com.trilemon.boss360.infrastructure.base.service.AppService;
import com.trilemon.boss360.shelf.ShelfConstants;
import com.trilemon.boss360.shelf.dao.PlanSettingMapper;
import com.trilemon.boss360.shelf.model.PlanSetting;
import com.trilemon.boss360.shelf.service.PlanService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 执行计划
 *
 * @author kevin
 */
@Service
public class ExecPlanJob extends AbstractQueueService<PlanSetting> {
    private final static Logger logger = LoggerFactory.getLogger(ExecPlanJob.class);
    @Autowired
    private PlanService planService;
    @Autowired
    private PlanSettingMapper planSettingMapper;
    @Autowired
    private AppService appService;

    @PostConstruct
    public void init() {
        reboot();
        startPoll();
        appService.addThreads(getThreadPoolExecutorMap());
        logger.info("add [{}] thread[{}] to monitor.", getThreadPoolExecutorMap().size(), getThreadPoolExecutorMap());
    }

    @Override
    public void timeout() {
    }

    @Override
    public void fillQueue() {
        logger.info("start to fill exec queue.");
        long hitUserId = 0;
        while (true) {
            try {
                List<PlanSetting> planSettings = planSettingMapper.paginateByStatus(hitUserId, 100,
                        ImmutableList.of(ShelfConstants.PLAN_SETTING_STATUS_RUNNING));
                if (CollectionUtils.isEmpty(planSettings)) {
                    break;
                } else {
                    hitUserId = Iterables.getLast(planSettings).getUserId();
                    fillQueue(planSettings);
                }
            } catch (Throwable e) {
                logger.error("exec plan error", e);
            }
        }
        logger.info("end to fill exec queue[{}].", getQueue().size());
    }

    @Override
    public void process(PlanSetting planSetting) throws Exception {
        planService.execPlan(planSetting.getId());
    }
}
