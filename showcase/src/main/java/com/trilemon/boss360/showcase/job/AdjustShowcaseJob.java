package com.trilemon.boss360.showcase.job;

import com.trilemon.boss360.infrastructure.base.service.AbstractQueueService;
import com.trilemon.boss360.showcase.model.Setting;
import com.trilemon.boss360.showcase.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author kevin
 */
public class AdjustShowcaseJob extends AbstractQueueService<Setting> {
    @Autowired
    private SettingService settingService;
    @Override
    public void timeout() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void process(Setting setting) throws Exception {
        settingService.adjust(setting);
    }

    @Override
    public void fillQueue() {
    }
}
