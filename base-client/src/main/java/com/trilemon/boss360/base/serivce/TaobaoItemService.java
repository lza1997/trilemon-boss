package com.trilemon.boss360.base.serivce;

import com.taobao.api.ApiException;
import com.taobao.api.domain.Item;
import com.taobao.api.request.ItemsOnsaleGetRequest;
import com.taobao.api.response.ItemsOnsaleGetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author kevin
 */
@Service
public class TaobaoItemService {
    @Autowired
    private TaobaoApiService taobaoApiService;
    @Autowired
    private TaobaoUserService taobaoUserService;

    public List<Item> getOnSaleItemsByNick(ItemsOnsaleGetRequest request, String appKey,
                                           String nick) throws ApiException {
        String sessionKey = taobaoUserService.getSessionKeyByNick(nick);
        return getOnSaleItemsBySessionKey(request, appKey, sessionKey);
    }

    public List<Item> getOnSaleItemsByUserId(ItemsOnsaleGetRequest request, String appKey,
                                             long userId) throws ApiException {
        String sessionKey = taobaoUserService.getSessionKeyByUserId(userId);
        return getOnSaleItemsBySessionKey(request, appKey, sessionKey);
    }

    public List<Item> getOnSaleItemsBySessionKey(ItemsOnsaleGetRequest request, String appKey,

                                                 String sessionKey) throws ApiException {
        checkNotNull(request);
        checkNotNull(appKey);
        checkNotNull(sessionKey);

        ItemsOnsaleGetResponse response = taobaoApiService.request(request, appKey, sessionKey);
        if (response.isSuccess()) {
            return response.getItems();
        } else {
            throw new ApiException(response.getErrorCode(), response.getMsg());
        }
    }
}
