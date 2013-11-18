package com.trilemon.boss.inventory.job;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.inventory.InventoryConstants;
import com.trilemon.boss.inventory.dao.InventoryListSettingMapper;
import com.trilemon.boss.inventory.model.InventoryListSetting;
import com.trilemon.boss.inventory.service.InventoryListAdjustService;
import com.trilemon.jobqueue.service.AbstractQueueService;
import com.trilemon.jobqueue.service.queue.JobQueue;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * 调整计划，主要需要调整 <ul> <li>新加入宝贝纳入计划</li> <li>已加入宝贝下架</li> </ul>
 *
 * @author kevin
 */
@Component
public class UpdatePlanJob extends AbstractQueueService<Long> {
    private final static Logger logger = LoggerFactory.getLogger(UpdatePlanJob.class);
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
        setTag("inventory-update-queue");
        start();
        appService.addThreads(getThreadPoolExecutorMap());
        logger.info("add [{}] thread[{}] to monitor.", getThreadPoolExecutorMap().size(), getThreadPoolExecutorMap());
    }

    @Override
    public void process(Long userId) throws Exception {
        InventoryListSetting setting = inventoryListSettingMapper.selectByUserId(userId);
        inventoryListAdjustService.update(setting.getId());
    }

    @Override
    public void fillQueue() {
        logger.info("start to fill update queue.");
        int elemCount = 0;
        long hitUserId = 0;
        while (true) {
            try {
                List<Long> userIds = inventoryListSettingMapper.paginateUserIdByStatus(hitUserId, 100,
                        ImmutableList.of(InventoryConstants.SETTING_STATUS_RUNNING));
                if (CollectionUtils.isEmpty(userIds)) {
                    break;
                } else {
                    hitUserId = Iterables.getLast(userIds);
                    fillQueue(userIds);
                    elemCount += userIds.size();
                }
            } catch (Throwable e) {
                logger.error("poll update error", e);
            }
        }
        logger.info("end to fill update queue[{}].", elemCount);
    }
}
