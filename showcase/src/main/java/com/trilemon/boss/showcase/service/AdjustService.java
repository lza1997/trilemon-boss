package com.trilemon.boss.showcase.service;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import com.taobao.api.domain.Item;
import com.taobao.api.domain.SellerCat;
import com.taobao.api.request.ItemsOnsaleGetRequest;
import com.taobao.api.response.ItemsOnsaleGetResponse;
import com.trilemon.boss.infra.base.model.dto.ShowcaseNum;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.infra.base.service.api.TaobaoApiShopService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.infra.base.util.TopApiUtils;
import com.trilemon.boss.showcase.ShowcaseConstants;
import com.trilemon.boss.showcase.ShowcaseException;
import com.trilemon.boss.showcase.ShowcaseUtils;
import com.trilemon.boss.showcase.dao.AdjustDetailMapper;
import com.trilemon.boss.showcase.dao.SettingMapper;
import com.trilemon.boss.showcase.model.AdjustDetail;
import com.trilemon.boss.showcase.model.Setting;
import com.trilemon.commons.Collections3;
import com.trilemon.commons.Languages;
import com.trilemon.commons.mybatis.MyBatisBatchWriter;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.joda.time.DateTime;
import org.joda.time.Minutes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.math.RoundingMode;
import java.util.List;
import java.util.Set;

import static com.trilemon.boss.showcase.ShowcaseConstants.*;

/**
 * @author kevin
 */
@Service
public class AdjustService {
    private final static Logger logger = LoggerFactory.getLogger(AdjustService.class);
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

    /**
     * 进行橱窗调整
     *
     * @param userId
     * @throws ShowcaseException
     * @throws TaobaoSessionExpiredException
     * @throws TaobaoEnhancedApiException
     * @throws TaobaoAccessControlException
     */
    public void adjust(Long userId) throws TaobaoSessionExpiredException, TaobaoEnhancedApiException,
            ShowcaseException, TaobaoAccessControlException {
        Setting setting = settingMapper.selectByUserId(userId);
        //////////////////////////////////step1. 获取各种信息////////////////////////////////
        List<SellerCat> sellerCats = taobaoApiShopService.getSellerCats(setting.getUserId());
        List<Long> includeSellerCatIds = TopApiUtils.getSellerCatIds(setting.getIncludeSellerCids());
        List<Long> sellerCatIds = TopApiUtils.getSellerCatIds(sellerCats);
        List<Long> notUserSellerCatIds = Lists.newArrayList(sellerCatIds);
        notUserSellerCatIds.removeAll(includeSellerCatIds);
        //获取用户设定类目的宝贝
        List<Item> usedSellerCatOnSaleItems = getUsedSellerCatOnSaleItems(setting, sellerCatIds, includeSellerCatIds);
        logger.info("userId[{}] get [{}] on sale items with used sellercats[{}].", setting.getUserId(),
                usedSellerCatOnSaleItems.size(), includeSellerCatIds);

        //获取用户设定类目的橱窗宝贝
        List<Item> showcaseUsedSellerCatOnSaleItems = Lists.newArrayList(TopApiUtils.getShowcaseItems(usedSellerCatOnSaleItems, true));
        logger.info("userId[{}] get [{}] on sale showcase items.", setting.getUserId(), showcaseUsedSellerCatOnSaleItems.size());

        //获取用户设定类目的非橱窗宝贝
        List<Item> notHasShowcaseUsedSellerCatOnSaleItems = Lists.newArrayList(TopApiUtils.getShowcaseItems(usedSellerCatOnSaleItems, false));
        logger.info("userId[{}] get [{}] on sale non showcase items.", setting.getUserId(), notHasShowcaseUsedSellerCatOnSaleItems.size());

        //获取数据库中的橱窗中的宝贝
        List<AdjustDetail> adjustDetails = adjustDetailMapper.selectByUserIdAndAdjustType(setting.getUserId(),
                HAS_SHOWCASE);
        logger.info("userId[{}] get [{}] has showcase adjustDetails.", setting.getUserId(), adjustDetails.size());

        //////////////////////////////////step2. 下橱窗非用户选择类目宝贝////////////////////////////////
        //获取用户设定类目的宝贝
        List<Item> notUsedSellerCatOnSaleShowcaseItems = getNotUsedSellerCatOnSaleShowcaseItems(setting, notUserSellerCatIds);
        logger.info("userId[{}] get [{}] on sale items with not used sellercats.", setting.getUserId(),
                usedSellerCatOnSaleItems.size());
        removeShowcaseNotUserSelectedSellerCatItems(setting, notUsedSellerCatOnSaleShowcaseItems);

        //////////////////////////////////step3. 校准数据库状态////////////////////////////////
        syncTopAndDb(setting, showcaseUsedSellerCatOnSaleItems, adjustDetails);

        //////////////////////////////////step4. 调整不推/////////////////////////
        List<Item> notShowcaseItems = adjustNotShowcaseItems(setting, showcaseUsedSellerCatOnSaleItems);
        if (CollectionUtils.isNotEmpty(notShowcaseItems)) {
            Iterables.removeAll(showcaseUsedSellerCatOnSaleItems, notShowcaseItems);
        }

        //////////////////////////////////step5. 调整必推（一定在不推之后做）/////////////////////////
        List<Item> fixShowcaseItems = adjustFixShowItems(setting, notHasShowcaseUsedSellerCatOnSaleItems);
        if (CollectionUtils.isNotEmpty(fixShowcaseItems)) {
            Iterables.removeAll(notHasShowcaseUsedSellerCatOnSaleItems, fixShowcaseItems);
        }
        //////////////////////////////////step6. 调整一般规则宝贝////////////////////////////////
        List<Item> generalRuleShowcaseItems = adjustGeneralRuleItems(setting, showcaseUsedSellerCatOnSaleItems,
                notHasShowcaseUsedSellerCatOnSaleItems);
        if (CollectionUtils.isNotEmpty(generalRuleShowcaseItems)) {
            Iterables.removeAll(showcaseUsedSellerCatOnSaleItems, generalRuleShowcaseItems);
        }
        //////////////////////////////////step7. 如果橱窗不全，补全////////////////////////////////
        completeShowcase(setting, showcaseUsedSellerCatOnSaleItems);
        //////////////////////////////////step8. 如果橱窗还不全，用非用户选择分类补全////////////////////////////////
        completeAdditionalShowcase(setting, notUserSellerCatIds);
    }

    private void completeAdditionalShowcase(Setting setting, List<Long> notUserSellerCatIds) throws TaobaoAccessControlException, TaobaoEnhancedApiException, TaobaoSessionExpiredException {
        ShowcaseNum showcaseNum = taobaoApiShopService.getShowcaseStatus(setting.getUserId());
        logger.info("userId[{}] get showcase remain [{}/{}/{}](all/used/remain).", setting.getUserId(),
                showcaseNum.getAllShowcases(), showcaseNum.getUsedShowcases(), showcaseNum.getRemainShowcases());
        int pageSize = 50;
        int totalPageNum = IntMath.divide((int) showcaseNum.getRemainShowcases(), pageSize, RoundingMode.CEILING);
        long pageNum = 1;
        while (true) {
            if (pageNum > totalPageNum) {
                return;
            }
            ItemsOnsaleGetRequest request = new ItemsOnsaleGetRequest();
            request.setFields(Collections3.COMMA_JOINER.join(ShowcaseConstants.ITEM_FIELDS));
            request.setHasShowcase(false);
            request.setPageNo(pageNum);
            request.setPageSize((long) pageSize);
            request.setSellerCids(Collections3.COMMA_JOINER.join(notUserSellerCatIds));
            ItemsOnsaleGetResponse result = taobaoApiShopService.getOnSaleItems(setting.getUserId(), request);
            if (null != result.getItems()) {
                pageNum++;
                for (Item item : result.getItems()) {
                    taobaoApiShopService.showcase(setting.getUserId(), item.getNumIid());
                }
            } else {
                return;
            }
        }
    }

    private void removeShowcaseNotUserSelectedSellerCatItems(Setting setting, List<Item> notUsedSellerCatOnSaleShowcaseItems) throws TaobaoSessionExpiredException, TaobaoAccessControlException {
        for (Item item : notUsedSellerCatOnSaleShowcaseItems) {
            try {
                taobaoApiShopService.removeFromShowcase(setting.getUserId(), item.getNumIid());
            } catch (TaobaoEnhancedApiException e) {
                //ignore
                logger.warn("remove showcase error", e);
            }
        }
    }

    /**
     * 如果必推和一般推荐都完成后，橱窗还是补全，则补充知道橱窗上全
     *
     * @param setting
     * @param showcaseUsedSellerCatOnSaleItems
     *
     * @return
     * @throws TaobaoAccessControlException
     * @throws TaobaoEnhancedApiException
     * @throws TaobaoSessionExpiredException
     */
    private List<Item> completeShowcase(Setting setting, List<Item> showcaseUsedSellerCatOnSaleItems)
            throws TaobaoAccessControlException, TaobaoEnhancedApiException, TaobaoSessionExpiredException {
        ShowcaseNum showcaseNum = taobaoApiShopService.getShowcaseStatus(setting.getUserId());
        logger.info("userId[{}] get showcase remain [{}/{}/{}](all/used/remain).", setting.getUserId(),
                showcaseNum.getAllShowcases(), showcaseNum.getUsedShowcases(), showcaseNum.getRemainShowcases());

        if (showcaseNum.isShowcaseFull() || CollectionUtils.isEmpty(showcaseUsedSellerCatOnSaleItems)) {
            logger.info("userId[{}] showcase[{}] full.", setting.getUserId(), showcaseNum.getAllShowcases());
            return Lists.newArrayList();
        } else {
            List<Item> completeShowcaseItems = Lists.newArrayList();
            List<AdjustDetail> completeShowcaseAdjustDetails = Lists.newArrayList();
            int index = 0;
            while (true) {
                if (index >= showcaseUsedSellerCatOnSaleItems.size()) {
                    break;
                }
                if (showcaseNum.isShowcaseFull()) {
                    logger.info("userId[{}] showcase[{}] full.", setting.getUserId(), showcaseNum.getAllShowcases());
                    break;
                }
                try {
                    Item item = showcaseUsedSellerCatOnSaleItems.get(index);
                    taobaoApiShopService.showcase(setting.getUserId(), item.getNumIid());
                    completeShowcaseItems.add(item);
                    AdjustDetail showcaseAdjustDetail = buildAdjustDetail(setting, item, NOT_HAS_SHOWCASE);
                    completeShowcaseAdjustDetails.add(showcaseAdjustDetail);
                    showcaseNum.incrShowcases();
                    index++;
                } catch (TaobaoEnhancedApiException e) {
                    logger.error("userId[" + setting.getUserId() + "] remove item from showcase error.", e);
                }
            }
            if (CollectionUtils.isNotEmpty(completeShowcaseAdjustDetails)) {
                logger.info("userId[{}] update[HAS_SHOWCASE] [{}] adjustDetails.", setting.getUserId(), completeShowcaseAdjustDetails.size());
                myBatisBatchWriter.write("com.trilemon.boss.showcase.dao.AdjustDetailMapper.updateOrInsertByNumIid",
                        completeShowcaseAdjustDetails);
            }
            logger.info("userId[{}] fix showcase done, status [{}]", setting.getUserId(), showcaseNum);
            return completeShowcaseItems;
        }
    }

    /**
     * 调整固定推荐宝贝
     *
     * @param setting
     * @param notHasShowcaseUsedSellerCatOnSaleItems
     *
     * @return
     * @throws TaobaoEnhancedApiException
     * @throws TaobaoSessionExpiredException
     * @throws TaobaoAccessControlException
     */
    private List<Item> adjustFixShowItems(Setting setting, List<Item> notHasShowcaseUsedSellerCatOnSaleItems)
            throws TaobaoEnhancedApiException, TaobaoSessionExpiredException, TaobaoAccessControlException {
        ShowcaseNum showcaseNum = taobaoApiShopService.getShowcaseStatus(setting.getUserId());
        logger.info("userId[{}] get showcase remain [{}/{}/{}](all/used/remain).", setting.getUserId(),
                showcaseNum.getAllShowcases(), showcaseNum.getUsedShowcases(), showcaseNum.getRemainShowcases());

        List<AdjustDetail> fixShowcaseAdjustDetails = Lists.newArrayList();
        List<Item> fixShowcaseItems = Lists.newArrayList();
        //获取必推宝贝
        final List<Long> includeShowcaseItemNumIids = Collections3.getLongList(setting.getIncludeItemNumIids());

        //计算属于必推但是非橱窗的宝贝
        List<Item> needShowcaseItemsOfIncludeShowcaseItems = Lists.newArrayList(Iterables.filter(notHasShowcaseUsedSellerCatOnSaleItems,
                new Predicate<Item>() {
                    @Override
                    public boolean apply(@Nullable final Item item) {
                        return includeShowcaseItemNumIids.contains(item.getNumIid());
                    }
                }));

        if (CollectionUtils.isEmpty(needShowcaseItemsOfIncludeShowcaseItems)) {
            logger.info("userId[{}] no item need to fix showcase.", setting.getUserId());
            return Lists.newArrayList();
        }

        //对属于必推但是非橱窗的宝贝上橱窗并且记录操作到数据库
        for (Item item : needShowcaseItemsOfIncludeShowcaseItems) {
            //如果到达showcase 数量限制，则直接返回
            if (showcaseNum.isShowcaseFull()) {
                logger.info("userId[{}] showcase[{}] full.", setting.getUserId(), showcaseNum.getAllShowcases());
                break;
            }
            try {
                taobaoApiShopService.showcase(setting.getUserId(), item.getNumIid());
                AdjustDetail adjustDetail = buildAdjustDetail(setting, item, HAS_SHOWCASE);
                fixShowcaseAdjustDetails.add(adjustDetail);
                fixShowcaseItems.add(item);
                showcaseNum.incrShowcases();
            } catch (TaobaoEnhancedApiException e) {
                logger.error("userId[" + setting.getUserId() + "] rec showcase item error.", e);
            }
        }
        if (CollectionUtils.isNotEmpty(fixShowcaseItems)) {
            logger.info("userId[{}] update[HAS_SHOWCASE] [{}] adjustDetails.", setting.getUserId(), fixShowcaseAdjustDetails.size());
            myBatisBatchWriter.write("com.trilemon.boss.showcase.dao.AdjustDetailMapper.updateOrInsertByNumIid",
                    fixShowcaseAdjustDetails);
        }
        logger.info("userId[{}] fix showcase done, status [{}]", setting.getUserId(), showcaseNum);
        return fixShowcaseItems;
    }

    /**
     * 调整不推荐宝贝
     *
     * @param setting
     * @param showcaseUsedSellerCatOnSaleItems
     *
     * @throws TaobaoEnhancedApiException
     * @throws TaobaoSessionExpiredException
     * @throws TaobaoAccessControlException
     */
    private List<Item> adjustNotShowcaseItems(Setting setting, List<Item> showcaseUsedSellerCatOnSaleItems)
            throws TaobaoEnhancedApiException, TaobaoSessionExpiredException, TaobaoAccessControlException {
        ShowcaseNum showcaseNum = taobaoApiShopService.getShowcaseStatus(setting.getUserId());
        logger.info("userId[{}] get showcase remain [{}/{}/{}](all/used/remain).", setting.getUserId(),
                showcaseNum.getAllShowcases(), showcaseNum.getUsedShowcases(), showcaseNum.getRemainShowcases());

        List<AdjustDetail> notAdjustDetails = Lists.newArrayList();
        List<Item> notShowcaseItems = Lists.newArrayList();
        //获取必不推宝贝
        final List<Long> excludeShowcaseItemNumIids = Collections3.getLongList(setting.getExcludeItemNumIids());
        if (CollectionUtils.isEmpty(excludeShowcaseItemNumIids)) {
            logger.info("userId[{}] no item need to not showcase.", setting.getUserId());
            return Lists.newArrayList();
        }
        //一个个获取，以免失败（可能宝贝已经不在线）
        final List<Item> excludeShowcaseItems = taobaoApiShopService.getItemsOneByOne(setting.getUserId(), excludeShowcaseItemNumIids, ITEM_FIELDS);
        logger.info("userId[{}] get [{}] must not showcase items.", setting.getUserId(), excludeShowcaseItems.size());

        //计算属于不推但是实际在橱窗的宝贝
        List<Item> needRemovedFromShowcaseItemsOfExcludeShowcaseItems = Lists.newArrayList(Iterables.filter(showcaseUsedSellerCatOnSaleItems,
                new Predicate<Item>() {
                    @Override
                    public boolean apply(@Nullable final Item item) {
                        return excludeShowcaseItemNumIids.contains(item.getNumIid());
                    }
                }));
        //对属于不推但是实际在橱窗的宝贝下橱窗并且记录操作到数据库
        for (Item item : needRemovedFromShowcaseItemsOfExcludeShowcaseItems) {
            try {
                taobaoApiShopService.removeFromShowcase(setting.getUserId(), item.getNumIid());
                AdjustDetail adjustDetail = buildAdjustDetail(setting, item, NOT_HAS_SHOWCASE);
                notAdjustDetails.add(adjustDetail);
                notShowcaseItems.add(item);
                showcaseNum.decrShowcases();
            } catch (TaobaoEnhancedApiException e) {
                logger.error("userId[" + setting.getUserId() + "] remove item from showcase error.", e);
            }
        }
        if (CollectionUtils.isNotEmpty(notAdjustDetails)) {
            logger.info("userId[{}] update[NOT_HAS_SHOWCASE] [{}] adjustDetails.", setting.getUserId(), notAdjustDetails.size());
            myBatisBatchWriter.write("com.trilemon.boss.showcase.dao.AdjustDetailMapper.updateOrInsertByNumIid",
                    notAdjustDetails);
        }
        logger.info("userId[{}] not showcase done, status [{}]", setting.getUserId(), showcaseNum);
        return notShowcaseItems;
    }

    /**
     * 调整一般规则宝贝
     *
     * @param setting
     * @param showcaseUsedSellerCatOnSaleItems
     *
     * @param notHasShowcaseUsedSellerCatOnSaleItems
     *
     * @throws TaobaoSessionExpiredException
     * @throws TaobaoAccessControlException
     */
    private List<Item> adjustGeneralRuleItems(Setting setting, List<Item> showcaseUsedSellerCatOnSaleItems,
                                              List<Item> notHasShowcaseUsedSellerCatOnSaleItems)
            throws TaobaoSessionExpiredException, TaobaoAccessControlException, TaobaoEnhancedApiException {
        ShowcaseNum showcaseNum = taobaoApiShopService.getShowcaseStatus(setting.getUserId());
        logger.info("userId[{}] get showcase remain [{}/{}/{}](all/used/remain).", setting.getUserId(),
                showcaseNum.getAllShowcases(), showcaseNum.getUsedShowcases(), showcaseNum.getRemainShowcases());

        List<AdjustDetail> adjustDetails = adjustDetailMapper.selectByUserIdAndAdjustType(setting.getUserId(),
                HAS_SHOWCASE);

        //计算符合橱窗条件的宝贝
        List<Item> canBeShowcaseItems = filterShowcaseItems(setting, notHasShowcaseUsedSellerCatOnSaleItems);

        //计算符合下橱窗条件的宝贝
        List<Item> canBeRemovedShowcaseItems = filterRemovedShowcaseItems(setting, showcaseUsedSellerCatOnSaleItems, adjustDetails);

        //被上橱窗的宝贝
        List<Item> generalRulesShowcaseItems = Lists.newArrayList();
        List<Item> allShowcaseItems = Lists.newArrayList();

        List<AdjustDetail> newAdjustDetails = Lists.newArrayList();

        int removedShowcaseItemIndex = 0;
        int showcaseItemIndex = 0;
        boolean isRemovedSuccessfully = true;
        boolean isShowcaseSuccessfully = true;
        if (!CollectionUtils.isNotEmpty(canBeShowcaseItems) && !CollectionUtils.isNotEmpty(canBeRemovedShowcaseItems)) {
            while (removedShowcaseItemIndex < canBeRemovedShowcaseItems.size() || showcaseItemIndex < canBeShowcaseItems
                    .size()) {
                if (showcaseNum.isShowcaseFull()) {
                    logger.info("userId[{}] showcase[{}] full.", setting.getUserId(), showcaseNum.getAllShowcases());
                    break;
                }
                //先下橱窗
                if (isShowcaseSuccessfully) {
                    try {
                        Item item = canBeRemovedShowcaseItems.get(removedShowcaseItemIndex);
                        taobaoApiShopService.removeFromShowcase(setting.getUserId(), item.getNumIid());
                        AdjustDetail removedAdjustDetail = buildAdjustDetail(setting, item, NOT_HAS_SHOWCASE);
                        newAdjustDetails.add(removedAdjustDetail);
                        showcaseNum.decrShowcases();
                        isRemovedSuccessfully = true;
                    } catch (TaobaoEnhancedApiException e) {
                        isRemovedSuccessfully = false;
                        logger.error("userId[" + setting.getUserId() + "] remove item from showcase error.", e);
                    } finally {
                        removedShowcaseItemIndex++;
                    }
                }
                //如果下橱窗成功了才接着上橱窗另外一个宝贝
                if (isRemovedSuccessfully) {
                    try {
                        Item item = canBeShowcaseItems.get(showcaseItemIndex);
                        taobaoApiShopService.showcase(setting.getUserId(), item.getNumIid());
                        generalRulesShowcaseItems.add(item);
                        AdjustDetail showcaseAdjustDetail = buildAdjustDetail(setting, item, NOT_HAS_SHOWCASE);
                        newAdjustDetails.add(showcaseAdjustDetail);
                        showcaseNum.incrShowcases();
                        isShowcaseSuccessfully = true;
                    } catch (TaobaoEnhancedApiException e) {
                        logger.error("userId[" + setting.getUserId() + "] remove item from showcase error.", e);
                        isShowcaseSuccessfully = false;
                    } finally {
                        showcaseItemIndex++;
                    }
                }
            }
            allShowcaseItems.addAll(generalRulesShowcaseItems);
            //如果橱窗还没有满，则填充满
            if (!showcaseNum.isShowcaseFull() && CollectionUtils.isNotEmpty(canBeShowcaseItems)) {
                Iterables.removeAll(canBeShowcaseItems, generalRulesShowcaseItems);
                int index = 0;
                while (true) {
                    if (showcaseNum.isShowcaseFull()) {
                        logger.info("userId[{}] showcase[{}] full.", setting.getUserId(), showcaseNum.getAllShowcases());
                        break;
                    }
                    try {
                        Item item = canBeShowcaseItems.get(index);
                        taobaoApiShopService.showcase(setting.getUserId(), item.getNumIid());
                        allShowcaseItems.add(item);
                        AdjustDetail showcaseAdjustDetail = buildAdjustDetail(setting, item, NOT_HAS_SHOWCASE);
                        newAdjustDetails.add(showcaseAdjustDetail);
                        showcaseNum.incrShowcases();
                        index++;
                    } catch (TaobaoEnhancedApiException e) {
                        logger.error("userId[" + setting.getUserId() + "] remove item from showcase error.", e);
                    }
                }
            }
            //更新数据库的橱窗历史日志
            myBatisBatchWriter.write("com.trilemon.boss.showcase.dao.AdjustDetailMapper.updateOrInsertByNumIid",
                    newAdjustDetails);
        }
        logger.info("userId[{}] general rule showcase done, status [{}]", setting.getUserId(), showcaseNum);
        return allShowcaseItems;
    }

    private AdjustDetail buildAdjustDetail(Setting setting, Item item, byte adjustType) {
        AdjustDetail adjustDetail = new AdjustDetail();
        adjustDetail.setUserId(setting.getUserId());
        adjustDetail.setItemNumIid(item.getNumIid());
        adjustDetail.setItemTitle(item.getTitle());
        try {
            String hanYuPinyin = Languages.getHanYuPinyin(item.getTitle());
            adjustDetail.setItemTitlePinyin(hanYuPinyin);
        } catch (BadHanyuPinyinOutputFormatCombination badHanyuPinyinOutputFormatCombination) {
            logger.error("create adjustDetail error, settingId[" + setting.getId() + "].",
                    badHanyuPinyinOutputFormatCombination);
        }
        adjustDetail.setItemPicUrl(item.getPicUrl());
        adjustDetail.setAddTime(appService.getLocalSystemTime().toDate());
        adjustDetail.setAdjustTime(appService.getLocalSystemTime().toDate());
        adjustDetail.setAdjustType(adjustType);
        return adjustDetail;
    }

    /**
     * 获取并且筛选符合{@link Setting}条件的宝贝，获取设定类目的在售宝贝
     *
     * @param setting
     * @param sellerCatIds
     * @param includeSellerCatIds
     * @return
     * @throws TaobaoEnhancedApiException
     * @throws TaobaoSessionExpiredException
     * @throws TaobaoAccessControlException
     */
    private List<Item> getUsedSellerCatOnSaleItems(Setting setting, List<Long> sellerCatIds, List<Long> includeSellerCatIds) throws TaobaoEnhancedApiException,
            TaobaoSessionExpiredException, TaobaoAccessControlException {
        Set<Long> validSellerCatIds = Sets.intersection(Sets.newHashSet(sellerCatIds),
                Sets.newHashSet(includeSellerCatIds));

        List<Item> onSaleItems = Lists.newArrayList();
        Iterable<List<Long>> sellerCatPartitions = Iterables.partition(validSellerCatIds, 32);
        for (List<Long> partition : sellerCatPartitions) {
            ItemsOnsaleGetRequest request = new ItemsOnsaleGetRequest();
            request.setFields(Collections3.COMMA_JOINER.join(ITEM_FIELDS));
            request.setSellerCids(Collections3.COMMA_JOINER.join(partition));
            ItemsOnsaleGetResponse result = taobaoApiShopService.getOnSaleItems(setting.getUserId(),
                    request);
            if (null != result.getItems()) {
                onSaleItems.addAll(result.getItems());
            }
        }
        return onSaleItems;
    }

    /**
     * 获取非设定类目的在售宝贝
     *
     * @param setting
     * @param notUserSellerCatIds
     * @return
     * @throws TaobaoEnhancedApiException
     * @throws TaobaoSessionExpiredException
     * @throws TaobaoAccessControlException
     */
    private List<Item> getNotUsedSellerCatOnSaleShowcaseItems(Setting setting, List<Long> notUserSellerCatIds) throws TaobaoEnhancedApiException,
            TaobaoSessionExpiredException, TaobaoAccessControlException {
        List<Item> onSaleItems = Lists.newArrayList();
        Iterable<List<Long>> sellerCatPartitions = Iterables.partition(notUserSellerCatIds, 32);
        for (List<Long> partition : sellerCatPartitions) {
            ItemsOnsaleGetRequest request = new ItemsOnsaleGetRequest();
            request.setFields(Collections3.COMMA_JOINER.join(ITEM_FIELDS));
            request.setSellerCids(Collections3.COMMA_JOINER.join(partition));
            request.setHasShowcase(true);
            ItemsOnsaleGetResponse result = taobaoApiShopService.getOnSaleItems(setting.getUserId(),
                    request);
            if (null != result.getItems()) {
                onSaleItems.addAll(result.getItems());
            }
        }
        return onSaleItems;
    }

    /**
     * 选取可以被下橱窗的宝贝，并且按照下架时间排序（越不接近下架时间的越靠前）
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

    /**
     * 选取可以上架的宝贝，并且按照下架时间排序（越接近下架时间的越靠前）
     *
     * @param setting
     * @param notHasShowcaseItems
     * @return
     */
    private List<Item> filterShowcaseItems(Setting setting, List<Item> notHasShowcaseItems) {
        //可以上橱窗的商品
        List<Item> canBeShowcaseItems = Lists.newArrayList();
        List<Long> excludeShowcaseItemNumIids = Collections3.getLongList(setting.getExcludeItemNumIids());
        DateTime now = appService.getLocalSystemTime();
        for (Item item : notHasShowcaseItems) {
            if (!excludeShowcaseItemNumIids.contains(item.getNumIid())
                    //过滤库存量
                    && !ShowcaseUtils.isItemInventoryLt(item, setting.getExcludeItemInventoryLt())
                    //过滤下架剩余时间好过 xx 的宝贝（刚上架宝贝）
                    && ShowcaseUtils.isItemDelistingWithin(item, setting.getExcludeItemDelistingAfter(), now)
                    //过滤 xx 分钟内下架的宝贝（快下架宝贝）
                    && !ShowcaseUtils.isItemDelistingWithin(item, setting.getExcludeItemDelistingWithin(), now)) {
                canBeShowcaseItems.add(item);
            }
        }
        return ShowcaseUtils.orderItemsByDelistingTime(canBeShowcaseItems, true);
    }

    /**
     * 以在线的橱窗宝贝为准，校准数据库中的宝贝状态。
     *
     * @param setting
     * @param onSaleShowcaseItems
     * @param adjustDetails
     * @return
     */
    public Set<Long> syncTopAndDb(Setting setting, List<Item> onSaleShowcaseItems, List<AdjustDetail> adjustDetails)
            throws TaobaoAccessControlException, TaobaoEnhancedApiException, TaobaoSessionExpiredException {
        List<Long> onSaleShowcaseItemNumIids = TopApiUtils.getItemNumIids(Lists.newArrayList(onSaleShowcaseItems));
        List<Long> adjustDetailItemNumIids = ShowcaseUtils.getAdjustDetailsNumIids(adjustDetails);

        Set<Long> validShowcaseItemNumIids = Sets.intersection(Sets.newHashSet(onSaleShowcaseItemNumIids),
                Sets.newHashSet(adjustDetailItemNumIids));

        //数据库中还在橱窗但是实际已经下橱窗的宝贝
        List<Long> invalidShowcaseItemNumIids = ListUtils.removeAll(adjustDetailItemNumIids, validShowcaseItemNumIids);
        //在线但是数据库中没有记录的宝贝
        List<Long> newShowcaseItemNumIids = ListUtils.removeAll(onSaleShowcaseItemNumIids, validShowcaseItemNumIids);

        //更新数据库中还在橱窗但是实际已经下橱窗的宝贝
        List<AdjustDetail> updateOrInsertAdjustDetails = Lists.newArrayList();
        List<Item> invalidShowcaseItem = taobaoApiShopService.getItemsOneByOne(setting.getUserId(),
                invalidShowcaseItemNumIids, ITEM_FIELDS);
        for (Item item : invalidShowcaseItem) {
            updateOrInsertAdjustDetails.add(buildAdjustDetail(setting, item, NOT_HAS_SHOWCASE));
        }
        //更新实际在线但是数据库中没有记录的宝贝
        List<Item> newShowcaseItem = taobaoApiShopService.getItemsOneByOne(setting.getUserId(),
                newShowcaseItemNumIids, ITEM_FIELDS);
        for (Item item : newShowcaseItem) {
            updateOrInsertAdjustDetails.add(buildAdjustDetail(setting, item, HAS_SHOWCASE));
        }
        if (CollectionUtils.isNotEmpty(updateOrInsertAdjustDetails)) {
            myBatisBatchWriter.write("com.trilemon.boss.showcase.dao.AdjustDetailMapper.updateOrInsertByNumIid",
                    updateOrInsertAdjustDetails);
            logger.info("userId[{}] sync [{}/{}] invalid/new items.", setting.getUserId(),
                    invalidShowcaseItemNumIids.size(), newShowcaseItemNumIids.size());
        }
        return validShowcaseItemNumIids;
    }
}
