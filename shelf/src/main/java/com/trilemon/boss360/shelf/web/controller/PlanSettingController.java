package com.trilemon.boss360.shelf.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author kevin
 */
@Controller
public class PlanSettingController {
    @RequestMapping("")
    public ModelAndView home() {
        ModelAndView modelAndView=new ModelAndView("/plan_setting/home");
        return modelAndView;
    }
    @RequestMapping("/plans")
    public ModelAndView index() {
        ModelAndView modelAndView=new ModelAndView("/plan_setting/index");
        return modelAndView;
    }
    @RequestMapping("/new")
    public ModelAndView add() {
        ModelAndView modelAndView=new ModelAndView("/plan_setting/new_step_1");
        return modelAndView;
    }

    @RequestMapping("/new2")
    public ModelAndView add2() {
        ModelAndView modelAndView=new ModelAndView("/plan_setting/new_step_2");
        return modelAndView;
    }

    public ModelAndView create() {
        return null;
    }

    @RequestMapping("/show")
    public ModelAndView show() {
        ModelAndView modelAndView=new ModelAndView("/plan_setting/show");
        return modelAndView;
    }

    public ModelAndView edit() {
        return null;
    }

    public ModelAndView update() {
        return null;
    }
}
