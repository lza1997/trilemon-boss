package com.trilemon.boss.rate.web.controller;

import com.trilemon.boss.infra.base.service.SessionService;
import com.trilemon.boss.rate.model.RateSetting;
import com.trilemon.boss.rate.service.RateSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 评价买家过滤的设置
 *
 * @author edokeh
 */
@Controller
@RequestMapping("/setting")
public class SettingController {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private RateSettingService rateSettingService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public RateSetting show() {
        return rateSettingService.getRateSetting(sessionService.getUserId());
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public RateSetting create(@RequestBody RateSetting setting) {
        rateSettingService.updateRateSetting(sessionService.getUserId(),setting);
        return rateSettingService.getRateSetting(sessionService.getUserId());
    }
}