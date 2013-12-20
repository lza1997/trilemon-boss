package com.trilemon.boss.poster.recommend.web.controller;

import com.trilemon.boss.poster.recommend.service.RecommendTemplateService;
import com.trilemon.boss.poster.template.model.PosterTemplate;
import com.trilemon.commons.web.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 店铺模板
 *
 * @author edokeh
 */
@Controller
@RequestMapping("/templates")
public class TemplateController {
    @Autowired
    private RecommendTemplateService templateService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Page<PosterTemplate> index(Integer category, Integer topic, @RequestParam(defaultValue = "1") int page) {
        List<Integer> categoryIds = new ArrayList<Integer>();
        List<Integer> topicIds = new ArrayList<Integer>();
        if (category != null) {
            categoryIds.add(category);
        }
        if (topic != null) {
            topicIds.add(topic);
        }
        return templateService.paginatePosterTemplates(categoryIds, topicIds, page, 2);
    }

}