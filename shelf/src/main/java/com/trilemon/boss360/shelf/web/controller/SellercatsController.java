package com.trilemon.boss360.shelf.web.controller;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.taobao.api.domain.Item;
import com.taobao.api.domain.SellerCat;
import com.trilemon.boss360.infrastructure.base.service.api.EnhancedApiException;
import com.trilemon.boss360.infrastructure.base.service.api.TaobaoApiShopService;
import com.trilemon.boss360.shelf.ShelfConstants;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author kevin
 */
@Controller
@RequestMapping("/sellercats")
public class SellercatsController {
    @Autowired
    private TaobaoApiShopService taobaoApiShopService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public List<SellerCatDTO> index() throws EnhancedApiException {
        Map<SellerCat, Long> map = taobaoApiShopService.getSellerCatAndOnSaleItemNum(56912708L, ShelfConstants.ITEM_FIELDS);

        // map -> list , use DTO to transfer
        List<SellerCatDTO> list = new ArrayList<SellerCatDTO>();
        for (SellerCat sellerCat : map.keySet()) {
            SellerCatDTO sellerCatDTO =new SellerCatDTO(sellerCat);
            sellerCatDTO.setItemNum(map.get(sellerCat));
            list.add(sellerCatDTO);
        }

        return list;
    }

    public static class SellerCatDTO extends SellerCat {
        private Long itemNum;

        public SellerCatDTO(SellerCat sellerCat) {
            this.setCid(sellerCat.getCid());
            this.setCreated(sellerCat.getCreated());
            this.setModified(sellerCat.getModified());
            this.setName(sellerCat.getName());
            this.setParentCid(sellerCat.getParentCid());
            this.setPicUrl(sellerCat.getPicUrl());
            this.setSortOrder(sellerCat.getSortOrder());
            this.setType(sellerCat.getType());
        }

        public Long getItemNum() {
            return itemNum;
        }

        public void setItemNum(Long itemNum) {
            this.itemNum = itemNum;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public Pair<List<Item>, Long> getSellerCats3(@RequestParam int pageNum) throws EnhancedApiException {
        List<SellerCat> cids = taobaoApiShopService.getSellerCats(56912708L);
        List<Long> cidList = Lists.transform(cids, new Function<SellerCat, Long>() {
            @Nullable
            @Override
            public Long apply(@Nullable SellerCat input) {
                return input.getCid();
            }
        });
        Pair<List<Item>, Long> items = taobaoApiShopService.getOnSaleItems(56912708L, cidList, ShelfConstants.ITEM_FIELDS,
                pageNum, 1);
        return items;
    }
}
