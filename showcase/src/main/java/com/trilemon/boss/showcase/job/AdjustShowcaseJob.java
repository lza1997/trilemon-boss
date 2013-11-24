package com.trilemon.boss.showcase.job;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.showcase.ShowcaseConstants;
import com.trilemon.boss.showcase.dao.SettingMapper;
import com.trilemon.boss.showcase.service.AdjustService;
import com.trilemon.boss.showcase.service.SettingService;
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
 * @author kevin
 */
@Component
public class AdjustShowcaseJob  extends AbstractQueueService<Long> {
    private final static Logger logger = LoggerFactory.getLogger(AdjustShowcaseJob.class);
    @Autowired
    private SettingMapper settingMapper;
    @Autowired
    private AdjustService adjustService;
    @Autowired
    private AppService appService;
    @Autowired
    private JobQueue<Long> jobQueue;

    @PostConstruct
    public void init() {
        setJobQueue(jobQueue);
        setTag("queue-job-showcase-adjust");
        setSleepMinutes(10);
        setMinSleepMinutes(1);
        setQueuePollMinutes(10);
        start();
        appService.addThreads(getThreadPoolExecutorMap());
        logger.info("add [{}] thread[{}] to monitor.", getThreadPoolExecutorMap().size(), getThreadPoolExecutorMap());
    }

    @Override
    public void process(Long userId) throws Exception {
        adjustService.adjust(userId);
    }

    @Override
    public void fillQueue() {
        logger.info("start to fill exec queue.");
        int elemCount = 0;
        long hitUserId = 0;
        while (true) {
            try {
                List<Long> userIds = settingMapper.paginateUserIdByStatus(hitUserId, 100,
                        ImmutableList.of(ShowcaseConstants.SETTING_STATUS_RUNNING));
                if (CollectionUtils.isEmpty(userIds)) {
                    break;
                } else {
                    hitUserId = Iterables.getLast(userIds);
                    fillQueue(userIds);
                    elemCount += userIds.size();
                }
            } catch (Throwable e) {
                logger.error("exec adjust error", e);
            }
        }
        logger.info("end to fill exec queue[{}].", elemCount);
    }
}