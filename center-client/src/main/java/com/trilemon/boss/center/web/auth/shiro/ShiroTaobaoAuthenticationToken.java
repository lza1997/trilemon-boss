package com.trilemon.boss.center.web.auth.shiro;

import org.apache.shiro.authc.HostAuthenticationToken;

/**
 * @author kevin
 */
public class ShiroTaobaoAuthenticationToken implements HostAuthenticationToken {

    private String clientId;
    private String code;
    private String error;
    private String errorDescription;
    private String host;
    private String redirectUri;
    private String responseType;
    private String state;
    private String view;

    public ShiroTaobaoAuthenticationToken(String clientId, String code, String error, String errorDescription, String host, String redirectUri, String responseType, String state, String view) {
        this.clientId = clientId;
        this.code = code;
        this.error = error;
        this.errorDescription = errorDescription;
        this.host = host;
        this.redirectUri = redirectUri;
        this.responseType = responseType;
        this.state = state;
        this.view = view;
    }

    @Override
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }

    @Override
    public Object getPrincipal() {
        return clientId;
    }

    @Override
    public Object getCredentials() {
        return code;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
}
