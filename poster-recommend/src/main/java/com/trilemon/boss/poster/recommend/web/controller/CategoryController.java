package com.trilemon.boss.poster.recommend.web.controller;

import com.trilemon.boss.poster.recommend.service.RecommendTemplateService;
import com.trilemon.boss.poster.template.model.PosterTemplateCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 店铺分类
 *
 * @author edokeh
 */
@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private RecommendTemplateService templateService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<PosterTemplateCategory> index() {
        return templateService.getTemplateCategories();
    }

}