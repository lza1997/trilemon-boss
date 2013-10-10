package com.trilemon.boss360.base.serivce;

import com.taobao.api.ApiException;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.TaobaoResponse;

/**
 * @author kevin
 */
public class EnhancedApiException extends Exception {
    private String subCode;
    private String subMsg;
    private String errorCode;
    private String errorMsg;
    private TaobaoResponse taobaoResponse;
    private TaobaoRequest taobaoRequest;

    public EnhancedApiException(TaobaoRequest request, TaobaoResponse response,
                                ApiException apiException) {
        super(apiException);
        this.taobaoRequest = request;
        this.taobaoResponse = response;
        this.subCode = response.getSubCode();
        this.subMsg = response.getSubMsg();
        this.errorCode = apiException.getErrCode();
        this.errorMsg = apiException.getErrMsg();
    }

    public EnhancedApiException(TaobaoRequest request, TaobaoResponse response) {
        this.taobaoRequest = request;
        this.taobaoResponse = response;
        this.subCode = response.getSubCode();
        this.subMsg = response.getSubMsg();
        this.errorCode = response.getErrorCode();
        this.errorMsg = response.getMsg();
    }

    public EnhancedApiException(ApiException apiException) {
        super(apiException);
        this.errorCode = apiException.getErrCode();
        this.errorMsg = apiException.getErrMsg();

    }

    public String getSubCode() {
        return subCode;
    }

    public void setSubCode(String subCode) {
        this.subCode = subCode;
    }

    public String getSubMsg() {
        return subMsg;
    }

    public void setSubMsg(String subMsg) {
        this.subMsg = subMsg;
    }

    public TaobaoResponse getTaobaoResponse() {
        return taobaoResponse;
    }

    public void setTaobaoResponse(TaobaoResponse taobaoResponse) {
        this.taobaoResponse = taobaoResponse;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public TaobaoRequest getTaobaoRequest() {
        return taobaoRequest;
    }

    public void setTaobaoRequest(TaobaoRequest taobaoRequest) {
        this.taobaoRequest = taobaoRequest;
    }
}
