//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.springbootdemo.demo03.controller;

import com.springbootdemo.demo03.exception.UserNotExistException;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
    public MyExceptionHandler() {

    }


    @ExceptionHandler({UserNotExistException.class})
    public String handleException(Exception e, HttpServletRequest request) {
        Map<String, Object> map = new HashMap();
        //传入我们自己的错误状态码  4xx 5xx
        request.setAttribute("javax.servlet.error.status_code", 500);
        map.put("code", "user.notexist");
        map.put("message", e.getMessage());
        request.setAttribute("ext", map);
        return "forward:/error";
    }
}
