//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.springbootdemo.demo03.config;

import com.springbootdemo.demo03.component.LoginHandlerIntercepter;
import com.springbootdemo.demo03.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
//@EnableWebMvc   //会全盘接管SpringMVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    public MyMvcConfig() {
    }

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/haha").setViewName("success");
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(new String[]{"/**"}).addResourceLocations(new String[]{"classpath:/static/"});
        registry.addResourceHandler(new String[]{"/webjars/**"}).addResourceLocations(new String[]{"/webjars/"});
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    //注册拦截器
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns(new String[]{"/**"}).excludePathPatterns(new String[]{"/index.html", "/", "/user/login", "/webjars/**", "/asserts/**"});
    }
}
