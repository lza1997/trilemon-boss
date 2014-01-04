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
    private static int PAGE_SIZE = 3;

    @Autowired
    private SessionService sessionService;
    @Autowired
    private RecommendTemplateService templateService;

    /**
     * 获取所有模板
     *
     * @param category 制作时选择模板，才提供此参数
     * @param type     对应所有、使用过的、收藏的 等类型
     * @param topic
     * @param page
     * @return
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Page<PosterTemplate> index(Integer category, @RequestParam(required = false, defaultValue = "") String type, Integer topic, @RequestParam(defaultValue = "1") int page) {
        List<Integer> categoryIds = Lists.newArrayList();
        List<Integer> topicIds = Lists.newArrayList();
        Long userId = sessionService.getUserId();

        if (category != null) {
            // 制作前选择模板
            if (category != null) {
                categoryIds.add(category);
            }
            if (topic != null) {
                topicIds.add(topic);
            }
            return templateService.paginatePosterTemplates(userId, topicIds, categoryIds, page, PAGE_SIZE);
        } else {
            // 模板列表页
            if (type.equals("")) {
                return templateService.paginatePosterTemplates(userId, topicIds, categoryIds, page, PAGE_SIZE);
            } else if (type.equals("favorite")) {
                return templateService.paginateFavoritePosterTemplates(userId, page, PAGE_SIZE);
            } else if (type.equals("latest")) {
                return templateService.paginateLatestPosterTemplates(userId, page, PAGE_SIZE);
            } else if (type.equals("used")) {
                return templateService.paginateUsedPosterTemplates(userId, page, PAGE_SIZE);
            } else {
                return null;
            }
        }
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public PosterTemplate show(@PathVariable Long id) {
        return templateService.getTemplate(id);
    }

    /**
     * 添加到收藏
     *
     * @param id
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/fav", method = RequestMethod.POST)
    public void createFav(@PathVariable Long id) {
        templateService.favoriteTemplate(sessionService.getUserId(), id);
    }

    /**
     * 取消收藏
     *
     * @param id
     */
    @ResponseBody
    @RequestMapping(value = "/{id}/fav", method = RequestMethod.DELETE)
    public void deleteFav(@PathVariable Long id) {
        templateService.unFavoriteTemplate(sessionService.getUserId(), id);
    }
}