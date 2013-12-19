package com.trilemon.boss.poster.recommend.web.controller;

import com.trilemon.boss.poster.recommend.service.RecommendTemplateService;
import com.trilemon.boss.poster.template.model.PosterTemplateTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 店铺主题
 *
 * @author edokeh
 */
@Controller
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private RecommendTemplateService templateService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<PosterTemplateTopic> index() {
        return templateService.getTemplateTopics();
    }

}