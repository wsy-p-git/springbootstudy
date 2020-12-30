package com.wsy.springbootstudy.component;


import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 页面按钮国际化信息处理
 * 实现LocaleResolver接口重写resolveLocale方法
 */
public class MyLocaleResolver implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        //l=zh_CN
        //获取requset信息中拼接的字符串
        String l = request.getParameter("l");
        //初始化locale对象等于系统默认的区域信息
        Locale locale = Locale.getDefault();
        //如果字符串不是空的拆分字符串赋值给locale
        if (!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
            locale = new Locale(split[0],split[1]);
        }
        return locale;
        //把locale 注册到容器中
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
