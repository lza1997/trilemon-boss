package com.trilemon.boss.poster.recommend.web.controller;

import com.google.common.collect.Lists;
import com.trilemon.boss.infra.base.service.SessionService;
import com.trilemon.boss.poster.recommend.service.RecommendTemplateService;
import com.trilemon.boss.poster.template.model.PosterTemplate;
import com.trilemon.commons.web.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    private SessionService sessionService;
    @Autowired
    private RecommendTemplateService templateService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Page<PosterTemplate> index(Integer category, Integer topic, @RequestParam(defaultValue = "1") int page) {
        List<Integer> categoryIds = Lists.newArrayList();
        List<Integer> topicIds =  Lists.newArrayList();
        if (category != null) {
            categoryIds.add(category);
        }
        if (topic != null) {
            topicIds.add(topic);
        }
        return templateService.paginatePosterTemplates(sessionService.getUserId(),topicIds, categoryIds, page, 2);
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PosterTemplate show(@PathVariable Long id) {
        return templateService.getTemplate(id);
    }

    /**
     * 添加到收藏
     * @param id
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/fav", method = RequestMethod.POST)
    public void createFav(@PathVariable Long id) {
        templateService.favoriteTemplate(sessionService.getUserId(), id);
    }

    /**
     * 取消收藏
     * @param id
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/fav", method = RequestMethod.DELETE)
    public void deleteFav(@PathVariable Long id) {
        templateService.unFavoriteTemplate(sessionService.getUserId(), id);
    }
}