package com.trilemon.boss.center.web.controller;

import com.trilemon.boss.infra.base.service.AppService;
import com.trilemon.boss.infra.base.service.TaobaoApiService;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoAccessControlException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoEnhancedApiException;
import com.trilemon.boss.infra.base.service.api.exception.TaobaoSessionExpiredException;
import com.trilemon.boss.infra.base.web.auth.TaobaoOauthException;
import com.trilemon.boss.infra.base.web.auth.shiro.ShiroTaobaoAuthenticationToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author kevin
 */
@Controller
public class SignInController {
    @Autowired
    private TaobaoApiService taobaoApiService;
    @Autowired
    private AppService appService;

    /**
     * cas登录，手工登录
     *
     * @param redirect
     * @return
     */
    @RequestMapping(value = "/signIn", method = RequestMethod.GET)
    public ModelAndView create(@RequestParam String redirect, @ModelAttribute("ex_msg") String exMsg) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("sign_in");
        modelAndView.addObject("redirect", redirect);
        modelAndView.addObject("exMsg", exMsg);
        return modelAndView;
    }

    /**
     * cas 登录
     *
     * @param redirect
     * @param userId
     * @param appKey
     * @param accessToken
     * @param refreshToken
     * @return
     * @throws TaobaoSessionExpiredException
     * @throws TaobaoEnhancedApiException
     * @throws TaobaoOauthException
     * @throws TaobaoAccessControlException
     */
    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    public String signIn(@RequestParam String redirect,
                         @RequestParam String nick,
                         @RequestParam Long userId,
                         @RequestParam String appKey,
                         @RequestParam String accessToken,
                         @RequestParam String refreshToken) throws TaobaoSessionExpiredException, TaobaoEnhancedApiException, TaobaoOauthException, TaobaoAccessControlException {

        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            ShiroTaobaoAuthenticationToken token = new ShiroTaobaoAuthenticationToken();
            token.setNick(nick);
            token.setUserId(userId);
            token.setAppKey(appKey);
            token.setAccessToken(accessToken);
            token.setRefreshToken(refreshToken);
            subject.login(token);
        }
        return "redirect:" + redirect;
    }

    /**
     * 获取淘宝的授权 code，并换取访问 token
     *
     * @return
     */
    @RequestMapping(value = "/callback", method = RequestMethod.GET)
    public String callback(@RequestParam(required = false) String code,
                           @RequestParam(required = false) String error,
                           @RequestParam(required = false) String error_description,
                           @RequestParam(required = false) String state) throws TaobaoOauthException {
        if (null != code) {
            Subject currentSubject = SecurityUtils.getSubject();
            if (!currentSubject.isAuthenticated()) {
                ShiroTaobaoAuthenticationToken token = new ShiroTaobaoAuthenticationToken();
                token.setClientId(taobaoApiService.getAppKey());
                token.setCode(code);
                token.setState(state);
                token.setAppKey(taobaoApiService.getAppKey());
                token.setRedirectUri(appService.getTaobaoCallbackUrl());
                try {
                    currentSubject.login(token);
                } catch (UnknownAccountException uae) {
                    throw new AuthenticationException("UnknownAccountException occurred.", uae);
                } catch (IncorrectCredentialsException ice) {
                    throw new AuthenticationException("IncorrectCredentialsException occurred.", ice);
                } catch (LockedAccountException lae) {
                    throw new AuthenticationException("LockedAccountException occurred.", lae);
                }
            }
            return "redirect:/";//返回首页
        } else {
            return "redirect:/400";//返回首页
        }
    }

    @RequestMapping(value = "/manual", method = RequestMethod.GET)
    public Subject manualCallback(@RequestParam Long userId,
                                  @RequestParam String appKey,
                                  @RequestParam String accessToken,
                                  @RequestParam String refreshToken) throws TaobaoOauthException {
        Subject currentSubject = SecurityUtils.getSubject();
        if (!currentSubject.isAuthenticated()) {
            ShiroTaobaoAuthenticationToken token = new ShiroTaobaoAuthenticationToken();
            token.setUserId(userId);
            token.setAppKey(appKey);
            token.setAccessToken(accessToken);
            token.setRefreshToken(refreshToken);
            token.setAppKey(taobaoApiService.getAppKey());
            try {
                currentSubject.login(token);
            } catch (UnknownAccountException uae) {
                throw new AuthenticationException("UnknownAccountException occurred.", uae);
            } catch (IncorrectCredentialsException ice) {
                throw new AuthenticationException("IncorrectCredentialsException occurred.", ice);
            } catch (LockedAccountException lae) {
                throw new AuthenticationException("LockedAccountException occurred.", lae);
            }
        }
        return SecurityUtils.getSubject();
    }
}
