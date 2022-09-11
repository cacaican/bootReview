package com.xiaocai.bootreview.config.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @ClassName MySecondFilter
 * @Description 第二种实例化FilterRegistrationBean方式来定义过滤器，这里定义好了filter，因为没有@webFilter注解，所以需要手动注册以下过滤器，注入过程见FilterConfig
 * @Author xiaocai
 * @Date 2022/9/11
 */
public class MySecondFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MySecondFilter被初始化了");

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) request;
        System.out.println(req.getRequestURI());
        System.out.println(req.getMethod());
        System.out.println("准备执行MySecondFilter");
        filterChain.doFilter(request, response);
        System.out.println("执行完MySecondFilter");
    }

    @Override
    public void destroy() {
        System.out.println("MySecondFilter被销毁了");
    }
}
