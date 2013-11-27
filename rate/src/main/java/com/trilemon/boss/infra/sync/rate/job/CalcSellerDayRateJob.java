package com.trilemon.boss.infra.sync.rate.job;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.infra.sync.rate.dao.SyncStatusDAO;
import com.trilemon.boss.infra.sync.rate.service.RateCalcService;
import com.trilemon.jobqueue.service.AbstractCronQueueService;
import com.trilemon.jobqueue.service.queue.JobQueue;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.trilemon.boss.infra.sync.rate.RateSyncConstants.*;

/**
 * 同步评论队列
 *
 * @author kevin
 */
//@Component
public class CalcSellerDayRateJob extends AbstractCronQueueService<Long> {
    private final static Logger logger = LoggerFactory.getLogger(CalcSellerDayRateJob.class);
    @Autowired
    private RateCalcService rateCalcService;
    @Autowired
    private SyncStatusDAO syncStatusDAO;
    @Autowired
    private AppService appService;
    @Autowired
    private JobQueue<Long> jobQueue;

    @PostConstruct
    public void init() {
        setJobQueue(jobQueue);
        setTag("job-queue[calc-seller-day-rate]");
        //一天同步一次
        setCron("0 0 3 * * ?");
        start();
        appService.addThreads(getThreadPoolExecutorMap());
        logger.info("add [{}] thread[{}] to monitor.", getThreadPoolExecutorMap().size(), getThreadPoolExecutorMap());
    }

    @Override
    public void process(Long userId) {
        rateCalcService.calcSellerDayRate(userId);
    }

    @Override
    public void fillQueue() {
        //还需要判断卖家的有效状态，如果过期了就不用计算了。卖家的状态使用 base 服务。
        logger.info("start to fill queue.");
        int elemCount = 0;
        long hitUserId = 0;
        while (true) {
            try {
                List<Long> userIds = syncStatusDAO.paginateUserIdByCalcSellerDayRateStatus(hitUserId, 100,
                        ImmutableList.of(RATE_CALC_SELLER_DAY_RATE_STATUS_INIT,
                                RATE_CALC_SELLER_DAY_RATE_STATUS_SUCCESSFUL,
                                RATE_CALC_SELLER_DAY_RATE_STATUS_FAILED));
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
        logger.info("end to fill queue[{}].", elemCount);
    }
}
