package com.trilemon.boss.center.web.auth.shiro;

import com.trilemon.boss.infra.base.client.BaseClient;
import com.trilemon.boss.infra.base.model.TaobaoSession;
import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.infra.base.service.TaobaoApiService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kevin
 */
public class ShiroTaobaoAuthorizingRealm extends AuthorizingRealm {
    private final static Logger logger = LoggerFactory.getLogger(ShiroTaobaoAuthorizingRealm.class);
    private BaseClient baseClient;
    private AppService appService;
    private TaobaoApiService taobaoApiService;

    /**
     * 认证回调函数,登录时调用.
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws
            AuthenticationException {
//        //获取 code 等信息
//        ShiroTaobaoAuthenticationToken token = (ShiroTaobaoAuthenticationToken) authToken;
//        //访问淘宝获取最终授权
//        TaobaoApp taobaoApp = baseClient.getTaobaoApp(taobaoApiService.getAppKey());
//        Map<String, String> param = Maps.newHashMap();
//        param.put("grant_type", "authorization_code");
//        param.put("code", token.getCode());
//        param.put("client_id", token.getClientId());
//        param.put("client_secret", taobaoApp.getAppSecret());
//        param.put("redirect_uri", token.getRedirectUri());
//        param.put("view", token.getView());
//        param.put("state", token.getState());
//
//        String responseJson;
//        int retry = 5;
//        while (true) {
//            try {
//                responseJson = WebUtils.doPost("https://oauth.taobao.com/token", param, 3000, 3000);
//                break;
//            } catch (IOException e) {
//                retry--;
//                if (retry == 0) {
//                    throw new AuthenticationException("get token error, authToken[" + ToStringBuilder.reflectionToString(authToken) + "]", e);
//                } else {
//                    logger.info("retry get token [{}] times.", retry);
//                }
//            }
//        }
//
//        TaobaoSession taobaoSession = JsonMapper.nonEmptyMapper().fromJson(responseJson, TaobaoSession.class);
//
//        //获取卖家信息如果获取不到则新建
//        TaobaoSeller taobaoSeller = baseClient.getSeller(taobaoSession.getTaobaoUserId());
//        if (null == taobaoSeller) {
//            try {
//                baseClient.createSeller(taobaoSession.getAccessToken(), taobaoApiService.getAppKey());
//            } catch (EnhancedApiException e) {
//                throw new AuthenticationException("createSeller error, authToken[" + ToStringBuilder.reflectionToString(authToken) + "]", e);
//            }
//        }
//
//        //更新 session 信息
//        baseClient.saveOrUpdateTaobaoSession(taobaoSession);
//
//        ShiroTaobaoUser shiroTaobaoUser = new ShiroTaobaoUser();
//        if (null != taobaoSession.getSubTaobaoUserId()) {
//            shiroTaobaoUser.setTaobaoUserId(taobaoSession.getSubTaobaoUserId());
//            shiroTaobaoUser.setTaobaoUserNick(taobaoSession.getSubTaobaoUserNick());
//        } else {
//            shiroTaobaoUser.setTaobaoUserId(taobaoSession.getTaobaoUserId());
//            shiroTaobaoUser.setTaobaoUserNick(taobaoSession.getTaobaoUserNick());
//        }
        ShiroTaobaoUser shiroTaobaoUser=new ShiroTaobaoUser();
        shiroTaobaoUser.setTaobaoUserId(56912708L);
        shiroTaobaoUser.setTaobaoUserNick("gymitat");
        TaobaoSession taobaoSession=new TaobaoSession();
        taobaoSession.setAccessToken("1231455");
        return new SimpleAuthenticationInfo(shiroTaobaoUser, taobaoSession.getAccessToken(), getName());
    }

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        ShiroTaobaoUser shiroUser = (ShiroTaobaoUser) principals.getPrimaryPrincipal();
//        TaobaoSession taobaoSession = baseClient.getTaobaoSession(shiroUser.taobaoUserId, taobaoApiService.getAppKey());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //info.addRoles(user.getRoleList());
        return info;
    }


    @Override
    public boolean supports(AuthenticationToken token) {
        return token != null && ShiroTaobaoAuthenticationToken.class.isAssignableFrom(token.getClass());
    }

    public BaseClient getBaseClient() {
        return baseClient;
    }

    public void setBaseClient(BaseClient baseClient) {
        this.baseClient = baseClient;
    }

    public AppService getAppService() {
        return appService;
    }

    public void setAppService(AppService appService) {
        this.appService = appService;
    }

    public TaobaoApiService getTaobaoApiService() {
        return taobaoApiService;
    }

    public void setTaobaoApiService(TaobaoApiService taobaoApiService) {
        this.taobaoApiService = taobaoApiService;
    }
}