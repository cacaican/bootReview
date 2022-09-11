package com.xiaocai.bootreview.config.filter;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName MyFilter
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/11
 */
/*
 * 在Springboot项目中，常用的自定义过滤器的方式有两种：
 * @WebFilter和FilterRegistrationBean，
 *
 * */
@Component
@WebFilter(urlPatterns = "/filter/*",filterName = "myFilter")
@Order(1)
public class MyFilter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter被初始化了");

        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        System.out.println(req.getRequestURI());
        System.out.println(req.getMethod());
        System.out.println("准备执行MyFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("执行完MyFilter");

    }

    @Override
    public void destroy() {
        System.out.println("MyFilter被销毁了");
        Filter.super.destroy();
    }


}
