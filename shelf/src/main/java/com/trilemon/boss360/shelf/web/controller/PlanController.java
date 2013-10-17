package com.trilemon.boss360.shelf.web.controller;

import com.trilemon.boss360.shelf.ShelfException;
import com.trilemon.boss360.shelf.model.PlanSetting;
import com.trilemon.boss360.shelf.service.PlanSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * @author kevin
 */
@Controller
@RequestMapping("/plans")
public class PlanController {
    @Autowired
    private PlanSettingService planSettingService;

    @RequestMapping("")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/plans/index");
        return modelAndView;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public ModelAndView _new() {
        ModelAndView modelAndView = new ModelAndView("/plans/new");
        PlanSetting planSetting = new PlanSetting();
        modelAndView.addObject("planSetting", planSetting);
        return modelAndView;
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String create(@Valid PlanSetting planSetting, BindingResult result) {
        if (result.hasErrors()) {
            return "/plans/new";
        } else {
            try {
                planSettingService.createPlanSetting(planSetting);
            } catch (ShelfException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            return "/plans/" + planSetting.getId();
        }
    }

    @RequestMapping(value = "/{planSettingId}", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable Long planSettingId) {
        ModelAndView modelAndView = new ModelAndView("/plans/show");
        PlanSetting planSetting = planSettingService.getPlanSetting(planSettingId);
        modelAndView.addObject("planSetting", planSetting);
        return modelAndView;
    }

    @RequestMapping(value = "/{planSettingId}/edit", method = RequestMethod.GET)
    public ModelAndView edit(@PathVariable Long planSettingId) {
        return null;
    }

    public ModelAndView update() {
        return null;
    }
}
