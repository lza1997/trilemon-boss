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
 * 调整计划，主要需要调整 <ul> <li>新加入宝贝纳入计划</li> <li>已加入宝贝下架</li> </ul>
 *
 * @author kevin
 */
@Service
public class UpdatePlanJob extends AbstractQueueService<Long> {
    private final static Logger logger = LoggerFactory.getLogger(UpdatePlanJob.class);
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
        logger.info("start to fill queue.");
        //自动纳入宝贝的才更新
        long hitUserId = 0;
        while (true) {
            List<Long> userIds = planSettingMapper.paginateUserIdByStatus(hitUserId, 100,
                    ImmutableList.of(ShelfConstants.PLAN_SETTING_STATUS_RUNNING));
            if (CollectionUtils.isEmpty(userIds)) {
                break;
            } else {
                hitUserId = Iterables.getLast(userIds);
                fillQueue(userIds);
            }
        }
        logger.info("end to fill queue[{}].", getQueue().size());
    }

    @Override
    public void process(Long userId) throws Exception {
        List<PlanSetting> planSettings = planSettingMapper.selectByUserId(userId);
        for (PlanSetting planSetting : planSettings) {
            planService.updatePlan(planSetting.getId());
        }
    }
}
