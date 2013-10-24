package com.trilemon.boss360.center.web.controller;

import com.trilemon.boss360.center.web.auth.shiro.ShiroTaobaoAuthenticationToken;
import com.trilemon.boss360.center.web.auth.shiro.ShiroTaobaoUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author kevin
 */
@Controller
@RequestMapping("/test")
public class SessionController {
    @RequestMapping(value = "/testSession", method = RequestMethod.GET)
    public void testSession(){
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            //collect user principals and credentials in a gui specific manner
            //such as username/password html form, X509 certificate, OpenID, etc.
            //We'll use the username/password example here since it is the most common.
            //(do you know what movie this is from? ;)
            ShiroTaobaoAuthenticationToken token=new ShiroTaobaoAuthenticationToken("","1231455","","","","","","","");
            currentUser.login(token);
        }
        System.out.println(((ShiroTaobaoUser) currentUser.getPrincipal())
                .getTaobaoUserNick());
    }
}
