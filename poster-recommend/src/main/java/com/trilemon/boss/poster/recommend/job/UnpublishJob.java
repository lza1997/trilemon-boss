package com.trilemon.boss.poster.recommend.job;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendActivityDAO;
import com.trilemon.boss.poster.recommend.dao.PosterRecommendUserDAO;
import com.trilemon.boss.poster.recommend.model.PosterRecommendUser;
import com.trilemon.boss.poster.recommend.service.RecommendPublishService;
import com.trilemon.jobqueue.service.AbstractFixRateQueueService;
import com.trilemon.jobqueue.service.queue.JobQueue;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

import static com.trilemon.boss.poster.recommend.PosterRecommendConstants.USER_STATUS_NORMAL;

/**
 * @author kevin
 */
@Component
public class UnpublishJob extends AbstractFixRateQueueService<Long> {
    private final static Logger logger = LoggerFactory.getLogger(UnpublishJob.class);
    @Autowired
    private RecommendPublishService recommendPublishService;
    @Autowired
    private PosterRecommendUserDAO posterRecommendUserDAO;
    @Autowired
    private PosterRecommendActivityDAO posterRecommendActivityDAO;
    @Autowired
    private AppService appService;
    @Autowired
    private JobQueue<Long> jobQueue;

    @PostConstruct
    public void init() {
        setJobQueue(jobQueue);
        setTag("job-queue[poster-item-recommend-adjust]");
        setFixSeconds(10 * 60);
        start();
        appService.addThreads(getThreadPoolExecutorMap());
        logger.info("add [{}] thread[{}] to monitor.", getThreadPoolExecutorMap().size(), getThreadPoolExecutorMap());
    }

    @Override
    public void process(Long userId) throws Exception {
        recommendPublishService.unpublishActivityByUserId(userId);
    }

    @Override
    public void fillQueue() {
        logger.info("start to fill exec queue.");
        int elemCount = 0;
        int pageNum = 1;
        int pageSize = 500;
        while (true) {
            try {
                List<PosterRecommendUser> users = posterRecommendUserDAO.paginateUsersByStatus(ImmutableList.of
                        (USER_STATUS_NORMAL), (pageNum - 1) * pageSize, pageSize);
                if (CollectionUtils.isEmpty(users)) {
                    break;
                } else {
                    pageNum++;
                    List<Long> userIds = Lists.newArrayList();
                    for (PosterRecommendUser user : users) {
                        userIds.add(user.getUserId());
                    }
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