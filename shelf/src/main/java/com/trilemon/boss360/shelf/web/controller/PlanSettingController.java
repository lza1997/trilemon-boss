package com.trilemon.boss360.shelf.web.controller;

import com.trilemon.boss360.infrastructure.base.service.AppService;
import com.trilemon.boss360.infrastructure.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss360.infrastructure.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss360.shelf.ShelfConstants;
import com.trilemon.boss360.shelf.ShelfException;
import com.trilemon.boss360.shelf.model.PlanSetting;
import com.trilemon.boss360.shelf.service.PlanService;
import com.trilemon.boss360.shelf.service.PlanSettingService;
import com.trilemon.commons.web.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * @author kevin
 */
@Controller
@RequestMapping("/plan-settings")
public class PlanSettingController {
    @Autowired
    AppService appService;
    @Autowired
    private PlanSettingService planSettingService;
    @Autowired
    private PlanService planService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Page<PlanSetting> index(@RequestParam(defaultValue = "1") int page) {
        return planSettingService.paginatePlanSettings(56912708L, page, 5);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Object create(@RequestBody @Valid PlanSetting planSetting, BindingResult result, HttpServletResponse response) throws ShelfException, TaobaoSessionExpiredException {
        if (result.hasErrors()) {
            response.setStatus(422);
            return result.getAllErrors();
        } else {
            planSetting.setAddTime(appService.getLocalSystemTime().toDate());
            planSetting.setDistribution("test");
            planSetting.setDistributionType(ShelfConstants.PLAN_SETTING_DISTRIBUTE_TYPE_AUTO);
            planSetting.setStatus(ShelfConstants.PLAN_SETTING_STATUS_WAITING_PLAN);
            planSetting.setUserId(56912708L);
            planSettingService.createPlanSetting(56912708L, planSetting);
            return planSetting;
        }
    }

    @RequestMapping(value = "/{planSettingId}", method = RequestMethod.GET)
    @ResponseBody
    public PlanSetting show(@PathVariable Long planSettingId) {
        return planSettingService.getPlanSetting(56912708L, planSettingId);
    }

    @RequestMapping(value = "/{planSettingId}", method = RequestMethod.PUT)
    @ResponseBody
    public Object update(@PathVariable Long planSettingId, @RequestBody @Valid PlanSetting planSetting, BindingResult result) throws TaobaoSessionExpiredException {
        try {
            planSetting.setId(planSettingId);
            planSettingService.updatePlanSetting(56912708L, planSetting);
            return planSetting;
        } catch (ShelfException e) {
            return e;
        }
    }

    /**
     * 删除计划
     * @param planSettingId
     * @return
     */
    @RequestMapping(value = "/{planSettingId}", method = RequestMethod.DELETE)
    @ResponseBody
    public boolean delete(@PathVariable Long planSettingId) {
        return planSettingService.deletePlanSetting(56912708L, planSettingId);
    }

    /**
     * 暂停计划
     * @param planSettingId
     * @return
     */
    @RequestMapping(value = "/{planSettingId}/pause", method = RequestMethod.POST)
    @ResponseBody
    public byte pause(@PathVariable Long planSettingId) {
        planSettingService.pausePlanSetting(56912708L, planSettingId);
        return ShelfConstants.PLAN_SETTING_STATUS_PAUSED;
    }

    /**
     * 继续计划
     * @param planSettingId
     * @return
     */
    @RequestMapping(value = "/{planSettingId}/pause", method = RequestMethod.DELETE)
    @ResponseBody
    public byte resume(@PathVariable Long planSettingId) {
        planSettingService.resumePlanSetting(56912708L, planSettingId);
        return ShelfConstants.PLAN_SETTING_STATUS_RUNNING;
    }

    /**
     * 排除宝贝
     * @param planSettingId
     * @param numIid
     * @return
     */
    @RequestMapping(value = "/{planSettingId}/exclude-item/{numIid}", method = RequestMethod.POST)
    @ResponseBody
    public String excludeItem(@PathVariable Long planSettingId, @PathVariable Long numIid){
        planService.excludeItem(planSettingId, numIid);
        return "";
    }

    /**
     * 取消排除宝贝
     * @param planSettingId
     * @param numIid
     * @return
     */
    @RequestMapping(value = "/{planSettingId}/exclude-item/{numIid}", method = RequestMethod.DELETE)
    @ResponseBody
    public String includeItem(@PathVariable Long planSettingId,@PathVariable Long numIid){
        planService.includeItem(planSettingId, numIid);
        return "";
    }

    /**
     * 获取用于展示店铺上下架图形的数据
     * @return
     * @throws ShelfException
     */
    @ResponseBody
    @RequestMapping(value = "/chart", method = RequestMethod.GET)
    public List<Integer> chart() throws
            ShelfException, TaobaoEnhancedApiException, TaobaoSessionExpiredException {
        return planSettingService.getShelfStatus(56912708L).getListItemNum();
    }



}
