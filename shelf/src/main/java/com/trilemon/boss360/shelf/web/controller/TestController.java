package com.trilemon.boss360.shelf.web.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.taobao.api.domain.Item;
import com.taobao.api.domain.SellerCat;
import com.trilemon.boss360.infrastructure.base.BaseConstants;
import com.trilemon.boss360.infrastructure.base.client.BaseClient;
import com.trilemon.boss360.infrastructure.base.model.TaobaoApp;
import com.trilemon.boss360.infrastructure.base.model.TaobaoSession;
import com.trilemon.boss360.infrastructure.base.service.AppService;
import com.trilemon.boss360.infrastructure.base.service.TaobaoApiService;
import com.trilemon.boss360.infrastructure.base.service.api.EnhancedApiException;
import com.trilemon.boss360.infrastructure.base.service.api.TaobaoApiShopService;
import com.trilemon.boss360.shelf.ShelfConstants;
import com.trilemon.boss360.shelf.ShelfException;
import com.trilemon.boss360.shelf.model.PlanSetting;
import com.trilemon.boss360.shelf.service.PlanSettingService;
import com.trilemon.commons.DateUtils;
import com.trilemon.commons.JsonMapper;
import com.trilemon.commons.web.Page;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author kevin
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    AppService appService;
    @Autowired
    private TaobaoApiShopService taobaoApiShopService;
    @Autowired
    private BaseClient baseClient;
    @Autowired
    private TaobaoApiService taobaoApiService;
    @Autowired
    private PlanSettingService planSettingService;

    /**
     * json 到对象
     *
     * @param args
     */
    public static void main(String[] args) {
        String json = "{\"delistTime\":1382430509000,\"numIid\":19491833743,\"picUrl\":\"http://img04.taobaocdn.com/bao/uploaded/i4/12708025971010288/T1lj89FdxdXXXXXXXX_!!0-item_pic.jpg\",\"sellerCids\":\"809023016,\",\"title\":\"勤茂micro/usb黑莓三星小米诺基亚安卓机中兴华为加长数据充电线\"}";
        JsonMapper jsonMapper = new JsonMapper();
        Item item = jsonMapper.fromJson(JsonMapper.normalizeJson(json), Item.class);
        System.out.println(ToStringBuilder.reflectionToString(item));
    }

    /**
     * 获取类目对应宝贝个数
     *
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/sellerCatAndOnSaleItemNum", method = RequestMethod.GET)
    Set<SellerCat> getSellerCatAndOnSaleItemNum() throws EnhancedApiException {
        Map<SellerCat, Long> map = taobaoApiShopService.getSellerCatAndOnSaleItemNum(56912708L);
        return map.keySet();
    }

    /**
     * 获取类目
     *
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/sellerCats", method = RequestMethod.GET)
    List<SellerCat> getSellerCats() throws EnhancedApiException {
        List<SellerCat> cids = taobaoApiShopService.getSellerCats(56912708L);
        return cids;
    }

    /**
     * 获取类目 id
     *
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/sellerCatsByNick", method = RequestMethod.GET)
    List<SellerCat> getSellerCatsByNick() throws EnhancedApiException {
        List<SellerCat> cids = taobaoApiShopService.getSellerCats("gymitat");
        return cids;
    }

    /**
     * 获取在售宝贝，带分页
     *
     * @param pageNum
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/onSaleItems", method = RequestMethod.GET)
    Page<Item> getOnSaleItems(@RequestParam int pageNum) throws EnhancedApiException {
        List<SellerCat> cids = taobaoApiShopService.getSellerCats(56912708L);
        List<Long> sellerCats = Lists.transform(cids, new Function<SellerCat, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable SellerCat input) {
                return input.getCid();
            }
        });
        Page<Item> items = taobaoApiShopService.paginateOnSaleItems(56912708L, null, ShelfConstants.ITEM_FIELDS,
                sellerCats, pageNum, 1, false);
        return items;
    }

    /**
     * 获取所有在售宝贝数量
     *
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/allOnSaleItemNum", method = RequestMethod.GET)
    long getAllOnSaleItemNum() throws EnhancedApiException {
        List<SellerCat> cids = taobaoApiShopService.getSellerCats(56912708L);
        List<Long> cidList = Lists.transform(cids, new Function<SellerCat, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable SellerCat input) {
                return input.getCid();
            }
        });
        long num = taobaoApiShopService.getOnSaleItemNum(56912708L, cidList);
        return num;
    }

    /**
     * 获取已经出售订单数量
     *
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/tradeNumFromTop", method = RequestMethod.GET)
    long getTradeNumFromTop() throws EnhancedApiException {
        long num = taobaoApiShopService.getTradeNumFromTop(56912708L, BaseConstants.TRADE_TYPES,
                DateUtils.startOfNDaysBefore(90).toDate(),
                DateUtils.endOfNDaysBefore(1).toDate());
        return num;
    }

    /**
     * 根据 use_id 获取 nick
     *
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/nick", method = RequestMethod.GET)
    String getNick() throws EnhancedApiException {
        return baseClient.getNick(56912708L);
    }

    /**
     * 获取{@link TaobaoApp}
     *
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/taobaoApp", method = RequestMethod.GET)
    TaobaoApp getTaobaoApp() throws EnhancedApiException {
        return baseClient.getTaobaoApp(taobaoApiService.getAppKey());
    }

    /**
     * 获取{@link TaobaoSession}
     *
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/taobaoSession", method = RequestMethod.GET)
    TaobaoSession getTaobaoSession() throws EnhancedApiException {
        return baseClient.getTaobaoSession(56912708L, taobaoApiService.getAppKey());
    }

    /**
     * 按关键词搜索
     *
     * @param query
     * @param pageNum
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    Page<Item> searchOnSaleItem(@RequestParam String query, @RequestParam int pageNum) throws
            EnhancedApiException {
        return taobaoApiShopService.paginateOnSaleItems(56912708L, query, ShelfConstants.ITEM_FIELDS, null,
                pageNum, 1, true);
    }

    /**
     * 展示 json 用法
     *
     * @return
     * @throws EnhancedApiException
     */
    @ResponseBody
    @RequestMapping(value = "/items/{numIid}", method = RequestMethod.GET)
    public String searchOnSaleItem(@PathVariable String numIid) throws
            EnhancedApiException {
        Item item = taobaoApiShopService.getItem(56912708L, Long.valueOf(numIid), ShelfConstants.ITEM_FIELDS);
        JsonMapper jsonMapper = new JsonMapper(JsonInclude.Include.NON_NULL);
        return jsonMapper.toJson(item);
    }

    /**
     * 创建计划
     *
     * @return
     * @throws ShelfException
     */
    @ResponseBody
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String savePlanSetting() throws ShelfException {
        PlanSetting planSetting = new PlanSetting();
        planSetting.setAddTime(appService.getLocalSystemTime().toDate());
        planSetting.setAutoAddNewItems(true);
        planSetting.setBeforeAdjustDistribution("test");
        planSetting.setDistribution("test");
        planSetting.setDistributionType(ShelfConstants.PLAN_SETTING_DISTRIBUTE_TYPE_AUTO);
        planSetting.setExcludeItemIids("19491833743");
        planSetting.setIncludeCids("791686717,809023016,804731967");
        planSetting.setDistributionType(ShelfConstants.PLAN_SETTING_DISTRIBUTE_TYPE_AUTO);
        planSetting.setName("你和我的测试计划");
        planSetting.setStatus(ShelfConstants.PLAN_SETTING_STATUS_WAITING_PLAN);
        planSetting.setUserId(56912708L);
        planSettingService.createPlanSetting(56912708L, planSetting);
        return "success";
    }

    /**
     * 查询特定计划
     *
     * @return
     * @throws ShelfException
     */
    @ResponseBody
    @RequestMapping(value = "/planSetting", method = RequestMethod.GET)
    public PlanSetting getPlanSetting(@RequestParam long planSettingId) throws ShelfException {
        return planSettingService.getPlanSetting(56912708L, planSettingId);
    }

    /**
     * 翻页计划
     *
     * @return
     * @throws ShelfException
     */
    @ResponseBody
    @RequestMapping(value = "/paginatePlanSettings", method = RequestMethod.GET)
    public Page<PlanSetting> paginatePlanSettings(@RequestParam int pageNum) throws ShelfException {
        return planSettingService.paginatePlanSettings(56912708L, pageNum, 1);
    }

    /**
     * 删除计划
     *
     * @return
     * @throws ShelfException
     */
    @ResponseBody
    @RequestMapping(value = "/deletePlanSetting", method = RequestMethod.GET)
    public boolean deletePlan(@RequestParam long planSettingId) throws ShelfException {
        return planSettingService.deletePlanSetting(56912708L, planSettingId);
    }

    /**
     * 暂停计划
     *
     * @return
     * @throws ShelfException
     */
    @ResponseBody
    @RequestMapping(value = "/pausePlanSetting", method = RequestMethod.GET)
    public boolean pause(@RequestParam long planSettingId) throws ShelfException {
        return planSettingService.pausePlanSetting(56912708L, planSettingId);
    }

    /**
     * 恢复计划
     *
     * @return
     * @throws ShelfException
     */
    @ResponseBody
    @RequestMapping(value = "/resumePlanSetting", method = RequestMethod.GET)
    public boolean resume(@RequestParam long planSettingId) throws ShelfException {
        return planSettingService.resumePlanSetting(56912708L, planSettingId);
    }

    /**
     * 恢复计划
     *
     * @return
     * @throws ShelfException
     */
    @ResponseBody
    @RequestMapping(value = "/searchPlanSetting", method = RequestMethod.GET)
    public Page<PlanSetting> searchPlanSetting(@RequestParam String query, @RequestParam Integer pageNum) throws ShelfException {
        return planSettingService.searchPlanSettings(56912708L, query, pageNum, 2);
    }

    /**
     * 更新计划
     *
     * @return
     * @throws ShelfException
     */
    @ResponseBody
    @RequestMapping(value = "/updatePlanSetting", method = RequestMethod.GET)
    public String updatePlanSetting(@RequestParam long planSettingId) throws ShelfException {
        PlanSetting planSetting=new PlanSetting();
        planSetting.setId(planSettingId);
        planSetting.setName("更新的计划");
        planSettingService.updatePlanSetting(56912708L,planSetting);
        return "success";
    }

    /**
     * 更新计划名字
     *
     * @return
     * @throws ShelfException
     */
    @ResponseBody
    @RequestMapping(value = "/updatePlanSettingName", method = RequestMethod.GET)
    public String updatePlanSettingName(@RequestParam long planSettingId) throws ShelfException {
        planSettingService.updatePlanSettingName(56912708L,planSettingId,"caocao");
        return "success";
    }


    @ResponseBody
    @RequestMapping(value = "/testException", method = RequestMethod.GET)
    public boolean testException() throws ShelfException {
        throw new ShelfException("test exception");
    }



}
