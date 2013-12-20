package com.trilemon.boss.trade.notify.service;

import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;

/**
 * @author kevin
 */
public interface ITradeNotifyService {
    void sendSms(Long userId) throws TaobaoAccessControlException, TaobaoEnhancedApiException, TaobaoSessionExpiredException;
}
