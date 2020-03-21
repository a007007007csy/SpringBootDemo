//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.springbootdemo.demo03.controller;

import com.springbootdemo.demo03.exception.UserNotExistException;
import java.util.Arrays;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    public MainController() {
    }

    @RequestMapping({"/hello"})
    @ResponseBody
    public String hello(@RequestParam("user") String user) {
        if (user.equals("aaa")) {
            throw new UserNotExistException();
        } else {
            return "hello hello";
        }
    }

    @RequestMapping({"/success"})
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你号</h1>");
        map.put("users", Arrays.asList("dsds", "dsds2", "dsds3"));
        return "success";
    }
}
