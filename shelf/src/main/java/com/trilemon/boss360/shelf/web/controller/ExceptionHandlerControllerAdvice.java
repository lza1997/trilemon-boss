package com.trilemon.boss360.shelf.web.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author kevin
 */
@ControllerAdvice
public class ExceptionHandlerControllerAdvice {
    @ExceptionHandler
    public @ResponseBody
    String handleException(Exception ex, WebRequest request, HttpServletResponse response) throws IOException {
            response.setHeader("Content-Type", "application/json");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return "Unknown error occurred: " + ex.getMessage();
    }
}
