package com.trilemon.boss.showcase.job;

import com.trilemon.boss.infra.base.service.AbstractQueueService;
import com.trilemon.boss.showcase.model.Setting;
import com.trilemon.boss.showcase.service.AdjustService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author kevin
 */
public class AdjustShowcaseJob extends AbstractQueueService<Setting> {
    @Autowired
    private AdjustService adjustService;

    @Override
    public void timeout() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void process(Setting setting) throws Exception {
        adjustService.adjust(setting.getUserId());
    }

    @Override
    public void fillQueue() {
    }
}
