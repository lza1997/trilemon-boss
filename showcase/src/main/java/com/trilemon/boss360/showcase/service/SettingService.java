package com.trilemon.boss360.showcase.service;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.taobao.api.domain.Item;
import com.taobao.api.domain.SellerCat;
import com.taobao.api.request.ItemsOnsaleGetRequest;
import com.trilemon.boss360.infrastructure.base.service.AppService;
import com.trilemon.boss360.infrastructure.base.service.TaobaoApiService;
import com.trilemon.boss360.infrastructure.base.service.api.TaobaoApiShopService;
import com.trilemon.boss360.infrastructure.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss360.infrastructure.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss360.infrastructure.base.util.TopApiUtils;
import com.trilemon.boss360.showcase.ShowcaseConstants;
import com.trilemon.boss360.showcase.ShowcaseException;
import com.trilemon.boss360.showcase.ShowcaseUtils;
import com.trilemon.boss360.showcase.dao.AdjustDetailMapper;
import com.trilemon.boss360.showcase.dao.SettingMapper;
import com.trilemon.boss360.showcase.model.AdjustDetail;
import com.trilemon.boss360.showcase.model.Setting;
import com.trilemon.commons.Collections3;
import com.trilemon.commons.Exceptions;
import com.trilemon.commons.mybatis.MyBatisBatchWriter;
import com.trilemon.commons.web.Page;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author kevin
 */
@Service
public class SettingService {
    private final static Logger logger = LoggerFactory.getLogger(SettingService.class);
    @Autowired
    private TaobaoApiShopService taobaoApiShopService;
    @Autowired
    private SettingMapper settingMapper;
    @Autowired
    private AdjustDetailMapper adjustDetailMapper;
    @Autowired
    private AppService appService;
    @Autowired
    private MyBatisBatchWriter myBatisBatchWriter;

    public void createSetting(Long userId, Setting setting) throws ShowcaseException, TaobaoSessionExpiredException, TaobaoEnhancedApiException {
        if (null != settingMapper.selectByUserId(userId)) {
            logger.debug("userId[{}] setting exist.", userId);
            return;
        }
        setting.setUserId(userId);
        setting.setStatus(ShowcaseConstants.SETTING_STATUS_PAUSE);
        setting.setAddTime(appService.getLocalSystemTime().toDate());
        settingMapper.insertSelective(setting);
        adjust(userId);
    }

    public void updateSetting(Long userId, Setting setting) throws ShowcaseException, TaobaoSessionExpiredException, TaobaoEnhancedApiException {
        setting.setUserId(userId);
        settingMapper.updateByUserIdSelective(setting);
        adjust(userId);
    }

    public Setting getSetting(Long userId) throws ShowcaseException {
        return settingMapper.selectByUserId(userId);
    }

    public void resumeSetting(Long userId) throws ShowcaseException, TaobaoSessionExpiredException,
            TaobaoEnhancedApiException {
        settingMapper.updateStatusByUserId(userId, ShowcaseConstants.SETTING_STATUS_RUNNING);
        adjust(userId);
    }

    public void pauseSetting(Long userId) throws ShowcaseException, TaobaoSessionExpiredException,
            TaobaoEnhancedApiException {
        settingMapper.updateStatusByUserId(userId, ShowcaseConstants.SETTING_STATUS_PAUSE);
    }

    /**
     * 必推商品
     *
     * @param userId
     * @param numIid * @param addOrDelete true is add,false is delete
     * @return
     */
    public boolean includeItem(Long userId, Long numIid, boolean addOrDelete) throws ShowcaseException {
        Setting setting = settingMapper.selectByUserId(userId);
        final List<Long> includeNumIids = Collections3.getLongList(setting.getIncludeItemNumIids());
        final List<Long> excludeNumIids = Collections3.getLongList(setting.getExcludeItemNumIids());
        if (addOrDelete) {
            if (excludeNumIids.contains(numIid)) {
                throw new ShowcaseException("userId[" + userId + "] can not add include item[" + numIid + "], " +
                        "it already in exclude items.");
            }
            includeNumIids.add(numIid);
        } else {
            includeNumIids.remove(numIid);
        }
        Setting updateSetting = new Setting();
        updateSetting.setId(setting.getId());
        updateSetting.setIncludeItemNumIids(Collections3.COMMA_JOINER.join(includeNumIids));
        int rows = settingMapper.updateByPrimaryKeySelective(updateSetting);
        return rows == 1;
    }

    /**
     * 不必推商品
     *
     * @param userId
     * @param numIid
     * @param addOrDelete true is add,false is delete
     * @return
     */
    public boolean excludeItem(Long userId, Long numIid, boolean addOrDelete) throws ShowcaseException {
        Setting setting = settingMapper.selectByUserId(userId);
        final List<Long> includeNumIids = Collections3.getLongList(setting.getIncludeItemNumIids());
        final List<Long> excludeNumIids = Collections3.getLongList(setting.getExcludeItemNumIids());
        if (addOrDelete) {
            if (includeNumIids.contains(numIid)) {
                throw new ShowcaseException("userId[" + userId + "] can not add include item[" + numIid + "], it already in exclude items.");
            }
            excludeNumIids.add(numIid);
        } else {
            excludeNumIids.remove(numIid);
        }
        Setting updateSetting = new Setting();
        updateSetting.setId(setting.getId());
        updateSetting.setExcludeItemNumIids(Collections3.COMMA_JOINER.join(excludeNumIids));
        int rows = settingMapper.updateByPrimaryKeySelective(updateSetting);
        return rows == 1;
    }

    public Page<Item> paginateShowcaseItems(Long userId, int pageNum, int pageSize) throws TaobaoEnhancedApiException, TaobaoSessionExpiredException {
        checkNotNull(userId, "userId must be not null.");

        ItemsOnsaleGetRequest request = new ItemsOnsaleGetRequest();
        request.setFields(Joiner.on(",").join(ShowcaseConstants.ITEM_FIELDS));
        request.setHasShowcase(true);
        request.setPageNo(Long.valueOf(pageNum));
        request.setPageSize(Long.valueOf(pageSize));
        Pair<List<Item>, Long> result = taobaoApiShopService.getOnSaleItems(userId, request);
        return Page.create(result.getRight().intValue(), request.getPageNo().intValue(),
                request.getPageSize().intValue(),
                result.getLeft());
    }

    /**
     * 1. 获取在线商品，使用{@link Setting}进行过滤，找出符合橱窗条件饿商品
     * <p/>
     * 2. 获取橱窗商品，判断哪些商品可以取消橱窗
     * <p/>
     * 3. 进行橱窗调整
     *
     * @param userId
     * @throws ShowcaseException
     * @throws TaobaoSessionExpiredException
     */

    public void adjust(Long userId) throws TaobaoSessionExpiredException, TaobaoEnhancedApiException,
            ShowcaseException {
        Setting setting = settingMapper.selectByUserId(userId);
        //////////////////////////////////step1. 获取各种信息////////////////////////////////
        List<SellerCat> sellerCats = taobaoApiShopService.getSellerCats(setting.getUserId());
        List<Long> includeSellerCatIds = TopApiUtils.getSellerCatIds(setting.getIncludeSellerCids());
        List<Long> sellerCatIds = TopApiUtils.getSellerCatIds(sellerCats);
        //获取在线的符合条件的宝贝
        List<Item> filteredOnSaleItems = getFilteredOnSaleItems(setting, sellerCatIds, includeSellerCatIds);
        logger.info("userId[{}] get [{}] items.", setting.getUserId(), filteredOnSaleItems.size());

        //获取在线的橱窗宝贝
        List<Item> showcaseItems = Lists.newArrayList(TopApiUtils.getShowcaseItems(filteredOnSaleItems, true));
        logger.info("userId[{}] get [{}] showcase items.", setting.getUserId(), showcaseItems.size());

        //获取在线的非橱窗宝贝
        List<Item> nonShowcaseItems = Lists.newArrayList(TopApiUtils.getShowcaseItems(filteredOnSaleItems, false));
        logger.info("userId[{}] get [{}] non showcase items.", setting.getUserId(), nonShowcaseItems.size());

        //获取数据库中的橱窗中的宝贝
        List<AdjustDetail> adjustDetails = adjustDetailMapper.selectByUserIdAndAdjustType(setting.getUserId(),
                ShowcaseConstants.HAS_SHOWCASE);
        logger.info("userId[{}] get [{}] has showcase adjustDetails.", setting.getUserId(), adjustDetails.size());

        //获取必推宝贝
        final List<Long> includeShowcaseItemNumIids = Collections3.getLongList(setting.getIncludeItemNumIids());
        final List<Item> includeShowcaseItems = taobaoApiShopService.getItems(setting.getUserId(), includeShowcaseItemNumIids, ShowcaseConstants.ITEM_FIELDS);
        logger.info("userId[{}] get [{}] must showcase items.", setting.getUserId(), includeShowcaseItems.size());

        //获取必不推宝贝
        final List<Long> excludeShowcaseItemNumIids = Collections3.getLongList(setting.getExcludeItemNumIids());
        final List<Item> excludeShowcaseItems = taobaoApiShopService.getItems(setting.getUserId(), excludeShowcaseItemNumIids, ShowcaseConstants.ITEM_FIELDS);
        logger.info("userId[{}] get [{}] must not showcase items.", setting.getUserId(), excludeShowcaseItems.size());

        // 获取橱窗状态
        Long[] showcaseRemain = taobaoApiShopService.getShowcaseRemain(setting.getUserId());
        long allShowcases = showcaseRemain[0];
        long usedShowcases = showcaseRemain[1];
        long remainShowcases = showcaseRemain[2];
        logger.info("userId[{}] get showcase remain [{}/{}/{}](all/used/remain).", setting.getUserId(),
                allShowcases,
                usedShowcases, remainShowcases);

        //////////////////////////////////step2. 同步数据库状态////////////////////////////////
        syncTopAndDb(setting, showcaseItems, adjustDetails);

        //////////////////////////////////step3. 调整必推和必不推的宝贝/////////////////////////
        List<AdjustDetail> newAdjustDetails = Lists.newArrayList();
        //计算属于必不推但是在橱窗的宝贝
        List<Item> needRemovedFromShowcaseItemsOfExcludeShowcaseItems = Lists.newArrayList(Iterables.filter
                (showcaseItems,
                        new Predicate<Item>() {
                            @Override
                            public boolean apply(@Nullable final Item showcaseItem) {
                                return Iterables.any(excludeShowcaseItems, new Predicate<Item>() {
                                    @Override
                                    public boolean apply(@Nullable Item excludeShowcaseItem) {
                                        return showcaseItem.getNumIid() == excludeShowcaseItem.getNumIid();
                                    }
                                });
                            }
                        }));
        //计算属于必推但是非橱窗的宝贝
        List<Item> needShowcaseItemsOfIncludeShowcaseItems = Lists.newArrayList(Iterables.filter(nonShowcaseItems,
                new Predicate<Item>() {
                    @Override
                    public boolean apply(@Nullable final Item nonShowcaseItem) {
                        return Iterables.any(includeShowcaseItems, new Predicate<Item>() {
                            @Override
                            public boolean apply(@Nullable Item excludeShowcaseItem) {
                                return nonShowcaseItem.getNumIid() == excludeShowcaseItem.getNumIid();
                            }
                        });
                    }
                }));
        for (Item item : needRemovedFromShowcaseItemsOfExcludeShowcaseItems) {
            try {
                taobaoApiShopService.removeFromShowcase(setting.getUserId(), item.getNumIid());
                AdjustDetail adjustDetail = new AdjustDetail();
                adjustDetail.setUserId(setting.getUserId());
                adjustDetail.setItemNumIid(item.getNumIid());
                adjustDetail.setAddTime(appService.getLocalSystemTime().toDate());
                adjustDetail.setAdjustTime(appService.getLocalSystemTime().toDate());
                adjustDetail.setAdjustType(ShowcaseConstants.NOT_HAS_SHOWCASE);
                newAdjustDetails.add(adjustDetail);
                remainShowcases++;
                usedShowcases--;
            } catch (TaobaoEnhancedApiException e) {
                logger.error("userId[" + setting.getUserId() + "] remove item from showcase error.", e);
            }
        }
        for (Item item : needShowcaseItemsOfIncludeShowcaseItems) {
            //如果到达showcase 数量限制，则直接返回
            if (remainShowcases >= showcaseRemain[0]) {
                break;
            }
            try {
                taobaoApiShopService.showcase(setting.getUserId(), item.getNumIid());
                AdjustDetail adjustDetail = new AdjustDetail();
                adjustDetail.setUserId(setting.getUserId());
                adjustDetail.setItemNumIid(item.getNumIid());
                adjustDetail.setAddTime(appService.getLocalSystemTime().toDate());
                adjustDetail.setAdjustTime(appService.getLocalSystemTime().toDate());
                adjustDetail.setAdjustType(ShowcaseConstants.NOT_HAS_SHOWCASE);
                newAdjustDetails.add(adjustDetail);
                remainShowcases--;
                usedShowcases++;
            } catch (TaobaoEnhancedApiException e) {
                logger.error("userId[" + setting.getUserId() + "] rec showcase item error.", e);
            }
        }
        if (CollectionUtils.isNotEmpty(newAdjustDetails)) {
            myBatisBatchWriter.write("com.trilemon.boss360.showcase.dao.AdjustDetailMapper.updateOrInsertByNumIid",
                    newAdjustDetails);
            newAdjustDetails.clear();
        }
        if (remainShowcases >= allShowcases) {
            logger.info("userId[{}] showcase is full.", setting.getUserId());
            return;
        }

        //////////////////////////////////step4. 调整其他宝贝////////////////////////////////
        //计算符合橱窗条件的宝贝
        List<Item> canBeShowcaseItems = filterShowcaseItems(setting, nonShowcaseItems);
        //计算符合下橱窗条件的宝贝
        List<Item> canBeRemovedShowcaseItems = filterRemovedShowcaseItems(setting, showcaseItems, adjustDetails);

        int removedShowcaseItemIndex = 0;
        int showcaseItemIndex = 0;
        boolean isRemovedSuccessfully = true;
        boolean isShowcaseSuccessfully = true;
        while (removedShowcaseItemIndex < canBeRemovedShowcaseItems.size() || showcaseItemIndex < canBeShowcaseItems
                .size()) {
            //如果上橱窗成功了才接着下橱窗另外一个宝贝
            if (isShowcaseSuccessfully && CollectionUtils.isNotEmpty(canBeRemovedShowcaseItems)) {
                try {
                    Item item = canBeRemovedShowcaseItems.get(removedShowcaseItemIndex);
                    taobaoApiShopService.removeFromShowcase(setting.getUserId(), item.getNumIid());
                    AdjustDetail removedAdjustDetail = new AdjustDetail();
                    removedAdjustDetail.setUserId(setting.getUserId());
                    removedAdjustDetail.setItemNumIid(item.getNumIid());
                    removedAdjustDetail.setAddTime(appService.getLocalSystemTime().toDate());
                    removedAdjustDetail.setAdjustTime(appService.getLocalSystemTime().toDate());
                    removedAdjustDetail.setAdjustType(ShowcaseConstants.NOT_HAS_SHOWCASE);
                    newAdjustDetails.add(removedAdjustDetail);
                    remainShowcases++;
                    usedShowcases--;
                    isRemovedSuccessfully = true;
                } catch (TaobaoEnhancedApiException e) {
                    isRemovedSuccessfully = false;
                    logger.error("userId[" + setting.getUserId() + "] remove item from showcase error.", e);
                } finally {
                    removedShowcaseItemIndex++;
                }
            }
            //如果下橱窗成功了才接着上橱窗另外一个宝贝
            if (isRemovedSuccessfully && CollectionUtils.isNotEmpty(canBeShowcaseItems)) {
                try {
                    Item item = canBeShowcaseItems.get(showcaseItemIndex);
                    taobaoApiShopService.removeFromShowcase(setting.getUserId(), item.getNumIid());
                    AdjustDetail showcaseAdjustDetail = new AdjustDetail();
                    showcaseAdjustDetail.setUserId(setting.getUserId());
                    showcaseAdjustDetail.setItemNumIid(item.getNumIid());
                    showcaseAdjustDetail.setAddTime(appService.getLocalSystemTime().toDate());
                    showcaseAdjustDetail.setAdjustTime(appService.getLocalSystemTime().toDate());
                    showcaseAdjustDetail.setAdjustType(ShowcaseConstants.NOT_HAS_SHOWCASE);
                    newAdjustDetails.add(showcaseAdjustDetail);
                    remainShowcases--;
                    usedShowcases++;
                    isShowcaseSuccessfully = true;
                } catch (TaobaoEnhancedApiException e) {
                    logger.error("userId[" + setting.getUserId() + "] remove item from showcase error.", e);
                    isShowcaseSuccessfully = false;
                } finally {
                    showcaseItemIndex++;
                }
            }
        }

        //更新数据库的橱窗历史日志
        myBatisBatchWriter.write("com.trilemon.boss360.showcase.dao.AdjustDetailMapper.updateOrInsertByNumIid",
                newAdjustDetails);

    }

    /**
     * 获取并且筛选符合{@link Setting}条件的宝贝
     *
     * @param setting
     * @param sellerCatIds
     * @param includeSellerCatIds @return
     * @throws TaobaoEnhancedApiException
     * @throws TaobaoSessionExpiredException
     */
    private List<Item> getFilteredOnSaleItems(Setting setting, List<Long> sellerCatIds, List<Long> includeSellerCatIds) throws TaobaoEnhancedApiException,
            TaobaoSessionExpiredException {
        Set<Long> validSellerCatIds = Sets.intersection(Sets.newHashSet(sellerCatIds),
                Sets.newHashSet(includeSellerCatIds));

        List<Item> onSaleItems = Lists.newArrayList();
        Iterable<List<Long>> sellerCatPartitions = Iterables.partition(validSellerCatIds, 32);
        for (List<Long> partition : sellerCatPartitions) {
            ItemsOnsaleGetRequest request = new ItemsOnsaleGetRequest();
            request.setFields(Joiner.on(",").join(ShowcaseConstants.ITEM_FIELDS));
            request.setSellerCids(Collections3.COMMA_JOINER.join(partition));
            try {
                Pair<List<Item>, Long> onSaleItemPair = taobaoApiShopService.getOnSaleItems(setting.getUserId(),
                        request);
                onSaleItems.addAll(onSaleItemPair.getKey());
            } catch (TaobaoEnhancedApiException e) {
                Exceptions.logAndThrow(logger, "userId[" + setting.getUserId() + "] get filter on sale item failure.", e);
            } catch (TaobaoSessionExpiredException e) {
                Exceptions.logAndThrow(logger, "userId[" + setting.getUserId() + "] get filter on sale item failure.", e);
            }
        }
        return onSaleItems;
    }

    /**
     * 可以被下橱窗的宝贝
     * <p/>
     * 1. 在橱窗待满了30分钟
     *
     * @param setting
     * @param showcaseItems
     * @return
     */
    private List<Item> filterRemovedShowcaseItems(Setting setting, List<Item> showcaseItems, List<AdjustDetail> adjustDetails) {
        //可以上橱窗的商品
        List<Item> canBeRemovedShowcaseItems = Lists.newArrayList();
        List<Long> includeShowcaseItemNumIids = Collections3.getLongList(setting.getIncludeItemNumIids());

        DateTime adjustTime;
        DateTime now;
        for (Item item : showcaseItems) {
            if (!includeShowcaseItemNumIids.contains(item.getNumIid())) {
                for (AdjustDetail adjustDetail : adjustDetails) {
                    //在数据库的调整记录中
                    if (adjustDetail.getItemNumIid() == item.getNumIid()) {
                        adjustTime = new DateTime(adjustDetail.getAdjustTime());
                        now = appService.getLocalSystemTime();
                        //已经在橱窗待了30分钟以上
                        if (Minutes.minutesBetween(adjustTime, now).getMinutes() > 30) {
                            canBeRemovedShowcaseItems.add(item);
                        }
                    }
                }
            }
        }
        return ShowcaseUtils.orderItemsByDelistingTime(canBeRemovedShowcaseItems, false);
    }

    private List<Item> filterShowcaseItems(Setting setting, List<Item> nonShowcaseItems) {
        //可以上橱窗的商品
        List<Item> canBeShowcaseItems = Lists.newArrayList();
        List<Long> excludeShowcaseItemNumIids = Collections3.getLongList(setting.getExcludeItemNumIids());
        DateTime now = appService.getLocalSystemTime();
        for (Item item : nonShowcaseItems) {
            if (!excludeShowcaseItemNumIids.contains(item.getNumIid())
                    && !ShowcaseUtils.isItemInventoryLt(item, setting.getExcludeItemInventoryLt())
                    && ShowcaseUtils.isItemDelistingWithin(item, setting.getExcludeItemDelistingAfter(), now)
                    && !ShowcaseUtils.isItemDelistingWithin(item, setting.getExcludeItemDelistingWithin(), now)) {
                canBeShowcaseItems.add(item);
            }
        }
        return canBeShowcaseItems;
    }

    /**
     * 以在线的橱窗宝贝为准，校准数据库中的宝贝状态。
     *
     * @param setting
     * @param onlineShowcaseItems
     * @param adjustDetails
     * @return
     */
    public Set<Long> syncTopAndDb(Setting setting, List<Item> onlineShowcaseItems,
                                  List<AdjustDetail> adjustDetails) {
        List<Long> onlineShowcaseItemNumIids = TopApiUtils.getItemNumIids(Lists.newArrayList(onlineShowcaseItems));
        List<Long> adjustDetailItemNumIids = ShowcaseUtils.getAdjustDetailsNumIids(adjustDetails);

        Set<Long> validShowcaseItemNumIids = Sets.intersection(Sets.newHashSet(onlineShowcaseItemNumIids),
                Sets.newHashSet(adjustDetailItemNumIids));

        //数据库中还在橱窗但是实际已经下橱窗的宝贝
        List<Long> invalidShowcaseItemNumIids = ListUtils.removeAll(adjustDetailItemNumIids, validShowcaseItemNumIids);
        //实际在线但是数据库中没有记录的宝贝
        List<Long> newShowcaseItemNumIids = ListUtils.removeAll(onlineShowcaseItemNumIids, validShowcaseItemNumIids);
        List<AdjustDetail> adjustOfAdjustDetails = Lists.newArrayList();
        //更新数据库中还在橱窗但是实际已经下橱窗的宝贝
        for (Long invalidItemNumIid : invalidShowcaseItemNumIids) {
            AdjustDetail adjustDetail = new AdjustDetail();
            adjustDetail.setUserId(setting.getUserId());
            adjustDetail.setItemNumIid(invalidItemNumIid);
            adjustDetail.setAdjustTime(appService.getLocalSystemTime().toDate());
            adjustDetail.setAdjustType(ShowcaseConstants.NOT_HAS_SHOWCASE);
            adjustDetail.setAddTime(appService.getLocalSystemTime().toDate());
            adjustOfAdjustDetails.add(adjustDetail);
        }
        //更新实际在线但是数据库中没有记录的宝贝
        for (Long newShowcaseItemNumIid : newShowcaseItemNumIids) {
            AdjustDetail adjustDetail = new AdjustDetail();
            adjustDetail.setUserId(setting.getUserId());
            adjustDetail.setItemNumIid(newShowcaseItemNumIid);
            adjustDetail.setAdjustTime(appService.getLocalSystemTime().toDate());
            adjustDetail.setAdjustType(ShowcaseConstants.HAS_SHOWCASE);
            adjustDetail.setAddTime(appService.getLocalSystemTime().toDate());
            adjustOfAdjustDetails.add(adjustDetail);
        }
        if (CollectionUtils.isNotEmpty(adjustOfAdjustDetails)) {
            myBatisBatchWriter.write("com.trilemon.boss360.showcase.dao.AdjustDetailMapper.updateOrInsertByNumIid",
                    adjustOfAdjustDetails);
            logger.info("userId[{}] sync [{}/{}] invalid/new items.", setting.getUserId(),
                    invalidShowcaseItemNumIids.size(), newShowcaseItemNumIids.size());
        }
        return validShowcaseItemNumIids;
    }
}
