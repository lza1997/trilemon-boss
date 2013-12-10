package com.trilemon.boss.rate.web.controller;

import com.trilemon.boss.infra.base.service.SessionService;
import com.trilemon.boss.rate.model.RateCommentSetting;
import com.trilemon.boss.rate.service.RateSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 自动评价的评价内容
 *
 * @author edokeh
 */
@Controller
@RequestMapping("/comment-settings")
public class CommentSettingController {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private RateSettingService rateSettingService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<RateCommentSetting> index() {
        return rateSettingService.getRateCommentSettings(sessionService.getUserId());
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody RateCommentSetting setting) {
        rateSettingService.addRateCommentSetting(sessionService.getUserId(), setting.getContent());
        //return rateSettingService.getRateCommentSettings(sessionService.getUserId());
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public RateCommentSetting update(@PathVariable Long id, @RequestBody RateCommentSetting setting) {
        rateSettingService.updateRateCommentSetting(sessionService.getUserId(), id, setting.getContent());
        return rateSettingService.getRateCommentSetting(sessionService.getUserId(), id);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        rateSettingService.deleteRateCommentSetting(sessionService.getUserId(), id);
    }

}