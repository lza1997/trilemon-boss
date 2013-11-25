package com.trilemon.boss.inventory.job;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.inventory.InventoryConstants;
import com.trilemon.boss.inventory.dao.InventoryListSettingMapper;
import com.trilemon.boss.inventory.model.InventoryListSetting;
import com.trilemon.boss.inventory.service.InventoryListAdjustService;
import com.trilemon.jobqueue.service.AbstractFixRateQueueService;
import com.trilemon.jobqueue.service.queue.JobQueue;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 执行计划
 *
 * @author kevin
 */
//@Component
public class ExecPlanJob extends AbstractFixRateQueueService<Long> {
    private final static Logger logger = LoggerFactory.getLogger(ExecPlanJob.class);
    @Autowired
    private InventoryListAdjustService inventoryListAdjustService;
    @Autowired
    private InventoryListSettingMapper inventoryListSettingMapper;
    @Autowired
    private AppService appService;
    @Autowired
    private JobQueue<Long> jobQueue;

    @PostConstruct
    public void init() {
        setJobQueue(jobQueue);
        setTag("inventory-exec-queue");
        setFixSeconds(10 * 60);
        start();
        appService.addThreads(getThreadPoolExecutorMap());
        logger.info("add [{}] thread[{}] to monitor.", getThreadPoolExecutorMap().size(), getThreadPoolExecutorMap());
    }

    @Override
    public void process(Long userId) throws Exception {
        InventoryListSetting inventoryListSetting = inventoryListSettingMapper.selectByUserId(userId);
        inventoryListAdjustService.execPlan(inventoryListSetting.getId());
    }

    @Override
    public void fillQueue() {
        logger.info("start to fill exec queue.");
        int elemCount = 0;
        long hitUserId = 0;
        while (true) {
            try {
                List<Long> planSettingUserIds = inventoryListSettingMapper.paginateUserIdByStatus(hitUserId, 100,
                        ImmutableList.of(InventoryConstants.SETTING_STATUS_RUNNING));
                if (CollectionUtils.isEmpty(planSettingUserIds)) {
                    break;
                } else {
                    hitUserId = Iterables.getLast(planSettingUserIds);
                    fillQueue(planSettingUserIds);
                    elemCount += planSettingUserIds.size();
                }
            } catch (Throwable e) {
                logger.error("exec plan error", e);
            }
        }
        logger.info("end to fill exec queue[{}].", elemCount);
    }
}
