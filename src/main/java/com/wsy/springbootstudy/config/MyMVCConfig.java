package com.wsy.springbootstudy.config;

import com.wsy.springbootstudy.component.LoginHandlerInterceptor;
import com.wsy.springbootstudy.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMVCConfig implements WebMvcConfigurer {
    //浏览器发送 / 请求来到 login
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //SpringBoot 2.0 需要排除静态资源的请求
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                //.excludePathPatterns("/login.html","/","/user/login");
                .excludePathPatterns("/login.html","/","/user/login", "/asserts/**", "/webjars/**");

    }



    //添加区域信息解析器
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
