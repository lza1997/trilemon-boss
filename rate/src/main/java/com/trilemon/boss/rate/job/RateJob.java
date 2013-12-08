package com.trilemon.boss.rate.job;

import com.google.common.collect.ImmutableList;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.rate.dao.RateSettingDAO;
import com.trilemon.boss.rate.service.RateService;
import com.trilemon.jobqueue.service.AbstractFixRateQueueService;
import com.trilemon.jobqueue.service.queue.JobQueue;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.trilemon.boss.rate.RateConstants.*;


/**
 * @author kevin
 */
public class RateJob extends AbstractFixRateQueueService<Long> {
    private final static Logger logger = LoggerFactory.getLogger(RateJob.class);
    @Autowired
    private RateService rateService;
    @Autowired
    private RateSettingDAO rateSettingDAO;
    @Autowired
    private AppService appService;
    @Autowired
    private JobQueue<Long> jobQueue;

    @PostConstruct
    public void init() {
        setJobQueue(jobQueue);
        setTag("job-queue[calc-seller-day-rate]");
        setFixSeconds(10 * 60);
        start();
        appService.addThreads(getThreadPoolExecutorMap());
        logger.info("add [{}] thread[{}] to monitor.", getThreadPoolExecutorMap().size(), getThreadPoolExecutorMap());
    }

    @Override
    public void process(Long userId) throws Exception {
        rateService.rate(userId);
    }

    @Override
    public void fillQueue() {
        logger.info("start to fill queue.");
        int elemCount = 0;
        int pageNum = 1;
        int pageSize = 500;
        while (true) {
            try {
                List<Long> userIds = rateSettingDAO.paginateUserIdByStatus((pageNum - 1) * pageSize, pageSize,
                        ImmutableList.of(RATE_SETTING_RATE_STATUS_INIT, RATE_SETTING_RATE_STATUS_SUCCESSFUL,
                                RATE_SETTING_RATE_STATUS_FAILED));
                if (CollectionUtils.isEmpty(userIds)) {
                    break;
                } else {
                    pageNum++;
                    fillQueue(userIds);
                    elemCount += userIds.size();
                }
            } catch (Throwable e) {
                logger.error("poll update error", e);
            }
        }
        logger.info("end to fill queue[{}].", elemCount);
    }
}
