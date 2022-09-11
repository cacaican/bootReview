package com.xiaocai.bootreview.config.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName MyInterceptor
 * @Description 我自定义的拦截器
 * @Author xiaocai
 * @Date 2022/9/11
 */
@Component
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        request.setAttribute("startTime",System.currentTimeMillis());
        System.out.println("在请求处理之前进行调用（Controller方法调用之前）");

        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            System.out.println("controller 对象 is " + handlerMethod.getBean().getClass().getName());
            System.out.println("controller 方法 is " + handlerMethod.getMethod());
        }else {
            System.out.println("未定义的 api");
            return false;
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后），如果异常发生，则该方法不会被调用");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）");
        long startTime = (long) request.getAttribute("startTime");
        System.out.println("time consume is " + String.valueOf(System.currentTimeMillis() - startTime));
    }

/*
自定义拦截器通用流程
1、自定义拦截器, 实现HandlerInterceptor接口
preHandle：调用Controller某个方法之前
postHandle：Controller之后调用，视图渲染之前，如果控制器Controller出现了异常，则不会执行此方法
afterCompletion：不管有没有异常，这个afterCompletion都会被调用，用于资源清理

2、@Configuration
SpringBoot2.X 新版本配置拦截器 implements WebMvcConfigurer，添加自定义的拦截器

3、按照注册顺序进行拦截，先注册，先被拦截*/



}
