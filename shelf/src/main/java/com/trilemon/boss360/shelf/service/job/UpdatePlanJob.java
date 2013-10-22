package com.trilemon.boss360.shelf.service.job;

import com.trilemon.boss360.infrastructure.base.service.AbstractQueueService;
import com.trilemon.boss360.infrastructure.base.service.AppService;
import com.trilemon.boss360.shelf.dao.PlanSettingMapper;
import com.trilemon.boss360.shelf.model.PlanSetting;
import com.trilemon.boss360.shelf.service.PlanService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;

/**
 * 调整计划，主要需要调整 <ul> <li>新加入宝贝纳入计划</li> <li>已加入宝贝下架</li> </ul>
 *
 * @author kevin
 */
@Service
public class UpdatePlanJob extends AbstractQueueService<PlanSetting> {
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
        int offset = 0;
        while (true) {
            Collection<PlanSetting> planSettings = planSettingMapper.paginateAutoAddItemPlanSettings(offset, 500);
            if (CollectionUtils.isEmpty(planSettings)) {
                break;
            } else {
                fillQueue(planSettings);
            }
        }
        logger.info("end to fill queue[{}].", getQueue().size());
    }

    @Override
    public void process(PlanSetting planSetting) throws Exception {
        planService.updatePlan(planSetting.getId());
    }
}
