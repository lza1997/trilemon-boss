package com.trilemon.boss.showcase.web.controller;

import com.trilemon.boss.infra.base.service.SessionService;
import com.trilemon.boss.showcase.ShowcaseException;
import com.trilemon.boss.showcase.model.Setting;
import com.trilemon.boss.showcase.service.SettingService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 橱窗规则设置
 */
@Controller
@RequestMapping("/setting")
public class SettingController {
    @Autowired
    private SettingService settingService;
    @Autowired
    private SessionService sessionService;

    /**
     * 获取当前规则
     *
     * @return
     * @throws ShowcaseException
     * @throws TaobaoSessionExpiredException
     * @throws TaobaoEnhancedApiException
     */
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Setting show() throws ShowcaseException, TaobaoSessionExpiredException, TaobaoEnhancedApiException {
        return settingService.getSetting(sessionService.getUserId());
    }

    /**
     * 修改规则
     *
     * @return
     * @throws ShowcaseException
     * @throws TaobaoSessionExpiredException
     * @throws TaobaoEnhancedApiException
     */
    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public Setting update(@RequestBody @Valid Setting setting) throws ShowcaseException, TaobaoSessionExpiredException, TaobaoEnhancedApiException, TaobaoAccessControlException {
        settingService.updateSetting(sessionService.getUserId(), setting);
        return setting;
    }

    /**
     * 暂停
     *
     * @return
     * @throws ShowcaseException
     * @throws TaobaoSessionExpiredException
     * @throws TaobaoEnhancedApiException
     */
    @RequestMapping(value = "/pause", method = RequestMethod.POST)
    @ResponseBody
    public Setting pauseSetting() throws ShowcaseException, TaobaoSessionExpiredException, TaobaoEnhancedApiException {
        settingService.pauseSetting(sessionService.getUserId());
        return settingService.getSetting(sessionService.getUserId());
    }

    /**
     * 开启规则
     *
     * @return
     * @throws ShowcaseException
     * @throws TaobaoSessionExpiredException
     * @throws TaobaoEnhancedApiException
     * @throws TaobaoAccessControlException
     */
    @RequestMapping(value = "/pause", method = RequestMethod.DELETE)
    @ResponseBody
    public Setting resumeSetting() throws ShowcaseException, TaobaoSessionExpiredException, TaobaoEnhancedApiException, TaobaoAccessControlException {
        settingService.resumeSetting(sessionService.getUserId());
        return settingService.getSetting(sessionService.getUserId());
    }

}
