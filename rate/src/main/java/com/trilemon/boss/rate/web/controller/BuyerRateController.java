package com.trilemon.boss.rate.web.controller;

import com.trilemon.boss.infra.base.service.SessionService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.rate.model.RateOrder;
import com.trilemon.boss.rate.service.RateSettingService;
import com.trilemon.commons.web.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;

/**
 * 中差评
 *
 * @author edokeh
 */
@Controller
@RequestMapping("/buyer-rates")
public class BuyerRateController {
    @Autowired
    private SessionService sessionService;
    @Autowired
    private RateSettingService rateSettingService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Page<RateOrder> index(String key, @RequestParam(defaultValue = "1") Integer page,
                                 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                 @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        Long tid;
        try {
            tid = Long.parseLong(key);
        } catch (NumberFormatException e) {
            tid = null;
        }

        return rateSettingService.paginateBuyerWaitingRate(sessionService.getUserId(), tid, null, startDate, endDate, page, 2);
    }

    /**
     * 自动评价，含批量
     *
     * @param param
     * @throws TaobaoAccessControlException
     * @throws TaobaoEnhancedApiException
     * @throws TaobaoSessionExpiredException
     */
    @ResponseBody
    @RequestMapping(value = "/auto", method = RequestMethod.POST)
    public void auto(@RequestBody AutoJSONParam param) throws TaobaoAccessControlException, TaobaoEnhancedApiException, TaobaoSessionExpiredException {
        rateSettingService.autoRate(sessionService.getUserId(), Arrays.asList(param.oids));
    }

    /**
     * 手工评价
     */
    @ResponseBody
    @RequestMapping(value = "/{oid}/manual", method = RequestMethod.POST)
    public void manual(@PathVariable Long oid, @RequestBody RateOrder rate) throws TaobaoAccessControlException, TaobaoEnhancedApiException, TaobaoSessionExpiredException {
        rateSettingService.autoRate(sessionService.getUserId(), oid, rate.getComment());
    }

    /**
     * 辅助，用于接收 JSON Request
     */
    public static class AutoJSONParam {
        public Long[] oids;
    }
}