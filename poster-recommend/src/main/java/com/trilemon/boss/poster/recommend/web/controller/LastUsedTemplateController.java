package com.trilemon.boss.poster.recommend.web.controller;

import com.trilemon.boss.infra.base.service.SessionService;
import com.trilemon.boss.poster.recommend.model.dto.LastUsedPosterTemplate;
import com.trilemon.boss.poster.recommend.service.RecommendActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 推荐的模板
 *
 * @author edokeh
 */
@Controller
@RequestMapping("/last-used-template")
public class LastUsedTemplateController {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private RecommendActivityService activityService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public LastUsedPosterTemplate index() {
        return activityService.getLastUsedPosterTemplate(sessionService.getUserId());
    }
}