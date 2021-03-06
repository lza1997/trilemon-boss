package com.trilemon.boss.rate.service;

import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoApiExceptionHandler;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;

/**
 * @author kevin
 */
public class RateTaobaoApiExceptionHandler extends TaobaoApiExceptionHandler {
    public void handlerApiException(TaobaoEnhancedApiException e){

    }

    public void handlerSessionExpired(TaobaoSessionExpiredException e){

    }

    public void handlerAccessControl(TaobaoAccessControlException e){

    }
}
