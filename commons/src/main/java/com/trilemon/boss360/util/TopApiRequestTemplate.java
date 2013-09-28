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

import com.taobao.api.TaobaoClient;
import com.taobao.api.TaobaoRequest;
import com.taobao.api.TaobaoResponse;

/**
 * 淘宝api调用的模板类
 *
 * @author kevin
 */
public abstract class TopApiRequestTemplate<REQ extends TaobaoRequest<RES>, RES extends TaobaoResponse> {

    /**
     * 发起top请求。
     *
     * @param taobaoClient 淘宝客户端
     * @param req          top请求
     * @param sessionKey   请求session
     * @return 自定义的返回类型的对象
     * @throws Exception 请求不成功或者api请求出错抛出异常
     */
    public RES request(TaobaoClient taobaoClient, REQ req, String sessionKey) throws Exception {
        return taobaoClient.execute(req, sessionKey);
    }

    /**
     * 发起top请求。
     *
     * @param taobaoClient 淘宝客户端
     * @param req          top请求
     * @return 自定义的返回类型的对象
     * @throws Exception 请求不成功或者api请求出错抛出异常
     */
    public RES request(TaobaoClient taobaoClient, REQ req) throws Exception {
        return taobaoClient.execute(req, null);
    }
}
