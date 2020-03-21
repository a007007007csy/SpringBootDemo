//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.springbootdemo.demo03.component;

import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class MyErrorAttribute extends DefaultErrorAttributes {
    public MyErrorAttribute() {
        super(true);
    }


    //返回值的map就是页面和json能获取的所有字段
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, includeStackTrace);

        //我们的异常处理器携带的数据
        Map<String, Object> ext = (Map) webRequest.getAttribute("ext", 0);
        map.put("ext", ext);
        return map;
    }
}
