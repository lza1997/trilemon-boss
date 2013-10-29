package com.trilemon.boss360.showcase.web.controller;

import com.google.common.base.Throwables;
import com.trilemon.boss360.infrastructure.base.service.api.TaobaoSessionExpiredException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;

/**
 * @author kevin
 */
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);
    @ExceptionHandler
    public
    @ResponseBody
    String handleException(Exception ex, WebRequest request, HttpServletResponse response) {
        logger.error(Throwables.getStackTraceAsString(ex));
        response.setHeader("Content-Type", "application/json");
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return "Unknown error occurred: " + Throwables.getStackTraceAsString(ex);
    }

    /**
     * 处理淘宝的 session 过期情况（重新登录）
     * @param ex
     * @param request
     * @param response
     * @return
     */
    @ExceptionHandler(TaobaoSessionExpiredException.class)
    public
    @ResponseBody
    String handleSessionExpiredException(Exception ex, WebRequest request, HttpServletResponse response) {
        logger.error(Throwables.getStackTraceAsString(ex));
        response.setHeader("Content-Type", "application/json");
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        //跳转到登录页面
        return "Unknown error occurred: " + Throwables.getStackTraceAsString(ex);
    }
}
