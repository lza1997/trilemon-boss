package com.trilemon.boss.poster.recommend.web.controller;

import com.trilemon.boss.infra.base.service.SessionService;
import com.trilemon.boss.poster.recommend.PosterRecommendConstants;
import com.trilemon.boss.poster.recommend.model.PosterRecommendRecommendTemplate;
import com.trilemon.boss.poster.recommend.service.RecommendTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 推荐的模板
 *
 * @author edokeh
 */
@Controller
@RequestMapping("/recommend-templates")
public class RecommendTemplateController {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private RecommendTemplateService templateService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<PosterRecommendRecommendTemplate> index() {
        return templateService.getRecommendPosterTemplate(sessionService.getUserId(), PosterRecommendConstants.RECOMMEND_TYPE_FESTIVAL);
    }
}