package com.trilemon.boss.rate.web.controller;

import com.trilemon.boss.infra.base.model.BuyerBlacklist;
import com.trilemon.boss.infra.base.service.SessionService;
import com.trilemon.boss.rate.service.RateSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 买家黑名单
 *
 * @author edokeh
 */
@Controller
@RequestMapping("/blacklist")
public class BlacklistController {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private RateSettingService rateSettingService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<BuyerBlacklist> index() {
        List<BuyerBlacklist> list =  rateSettingService.getBuyerBlacklist(sessionService.getUserId());
        return list;
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public void create(@RequestBody BuyerBlacklist blacklist) {
        rateSettingService.addBlacklist(sessionService.getUserId(), blacklist.getBuyerNick());
    }

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //rateSettingService.
    }

}