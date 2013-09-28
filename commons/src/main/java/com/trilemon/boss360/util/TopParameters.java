/*
 * Copyright (c) 2013 Raycloud.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.trilemon.boss360.util;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 对应top_parameters的json串的java bean。参见<a href="http://open.taobao.com/doc/detail.htm?spm=0.0.0.0.HHWzhQ&id=105">淘宝文档</a>。
 *
 * @author kevin
 */
public class TopParameters {
    @JsonProperty("ts")
    private long timestamp;
    @JsonProperty("iframe")
    private String iframe;
    @JsonProperty("visitor_id")
    private long visitorId;
    @JsonProperty("visitor_nick")
    private String visitorNick;
    @JsonProperty("visitor_role")
    private String visitorRole;
    @JsonProperty("sub_visitor_id")
    private String subVisitorId;
    @JsonProperty("sub_taobao_user_nick")
    private String subTaobaoUserNick;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("top_session")
    private String sessionKey;
    @JsonProperty("re_expires_in")
    private int reExpiresIn;
    @JsonProperty("expires_in")
    private int expiresIn;
    @JsonProperty("r1_expires_in")
    private int r1ExpiresIn;
    @JsonProperty("r2_expires_in")
    private int r2ExpiresIn;
    @JsonProperty("w1_expires_in")
    private int w1ExpiresIn;
    @JsonProperty("w2_expires_in")
    private int w2ExpiresIn;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getIframe() {
        return iframe;
    }

    public void setIframe(String iframe) {
        this.iframe = iframe;
    }

    public long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(long visitorId) {
        this.visitorId = visitorId;
    }

    public String getVisitorNick() {
        return visitorNick;
    }

    public void setVisitorNick(String visitorNick) {
        this.visitorNick = visitorNick;
    }

    public String getVisitorRole() {
        return visitorRole;
    }

    public void setVisitorRole(String visitorRole) {
        this.visitorRole = visitorRole;
    }

    public String getSubVisitorId() {
        return subVisitorId;
    }

    public void setSubVisitorId(String subVisitorId) {
        this.subVisitorId = subVisitorId;
    }

    public String getSubTaobaoUserNick() {
        return subTaobaoUserNick;
    }

    public void setSubTaobaoUserNick(String subTaobaoUserNick) {
        this.subTaobaoUserNick = subTaobaoUserNick;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public int getReExpiresIn() {
        return reExpiresIn;
    }

    public void setReExpiresIn(int reExpiresIn) {
        this.reExpiresIn = reExpiresIn;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    public int getR1ExpiresIn() {
        return r1ExpiresIn;
    }

    public void setR1ExpiresIn(int r1ExpiresIn) {
        this.r1ExpiresIn = r1ExpiresIn;
    }

    public int getR2ExpiresIn() {
        return r2ExpiresIn;
    }

    public void setR2ExpiresIn(int r2ExpiresIn) {
        this.r2ExpiresIn = r2ExpiresIn;
    }

    public int getW1ExpiresIn() {
        return w1ExpiresIn;
    }

    public void setW1ExpiresIn(int w1ExpiresIn) {
        this.w1ExpiresIn = w1ExpiresIn;
    }

    public int getW2ExpiresIn() {
        return w2ExpiresIn;
    }

    public void setW2ExpiresIn(int w2ExpiresIn) {
        this.w2ExpiresIn = w2ExpiresIn;
    }
}
