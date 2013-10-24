package com.trilemon.boss360.center;

import com.google.common.collect.Lists;
import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.net.URISyntaxException;
import java.util.List;

/**
 * @author kevin
 */
public class CenterUtils {
    public static String buildHttpURI(String url, String path, List<NameValuePair> params) {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http");
        uriBuilder.setHost(url);
        uriBuilder.setPath(path);
        for (NameValuePair nameValuePair : params) {
            uriBuilder.addParameter(nameValuePair.getName(), nameValuePair.getValue());
        }
        try {
            return uriBuilder.build().toString();
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public static String buildHttpsURI(String url, String path, List<NameValuePair> params) {
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost(url);
        uriBuilder.setPath(path);
        for (NameValuePair nameValuePair : params) {
            uriBuilder.addParameter(nameValuePair.getName(), nameValuePair.getValue());
        }
        try {
            return uriBuilder.build().toString();
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public static String buildTaobaoOauthAuthorizeURI(String clientId, String responseType, String redirectUri,
                                                      String state, String view) {
        List<NameValuePair> params = Lists.newArrayList();
        params.add(new BasicNameValuePair("client_id", clientId));
        params.add(new BasicNameValuePair("response_type", responseType));
        params.add(new BasicNameValuePair("redirect_uri", redirectUri));
        params.add(new BasicNameValuePair("state", state));
        params.add(new BasicNameValuePair("view", view));
        return buildHttpsURI("oauth.taobao.com", "/authorize", params);
    }

    public static String buildDefaultTaobaoOauthAuthorizeURI(String clientId, String redirectUri, String state) {
        return buildTaobaoOauthAuthorizeURI(clientId, "code", redirectUri, state, "web");
    }
}
