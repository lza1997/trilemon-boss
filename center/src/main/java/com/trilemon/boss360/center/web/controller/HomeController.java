package com.trilemon.boss360.center.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author kevin
 */
@Controller
public class HomeController {

    @RequestMapping(value="/", method= RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("/home");
        return modelAndView;
    }
}
