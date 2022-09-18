package com.xiaocai.bootreview.guava.config;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName RateLimiterInterceptor
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/18
 */
@Component
public class RateLimiterInterceptor implements HandlerInterceptor {
    private final RateLimiter rateLimiter;


    /**
     * 通过构造函数默认初始化限速器，创建一个限速器，预热1秒，产生10个令牌
     * permitsPerSecond：每秒产生多少个令牌
     * warmupPeriod：预热时间
     * unit：预热时间warmupPeriod的单位
     */
    public RateLimiterInterceptor() {
        super();
        this.rateLimiter = RateLimiter.create(5, 1, TimeUnit.SECONDS);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(this.rateLimiter.tryAcquire()) {
            //成功获取到令牌
            return true;
        }
        //获取失败，直接响应“错误信息”
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setCharacterEncoding(StandardCharsets.UTF_8.name());
        response.getWriter().write(JSON.toJSONString("服务器繁忙，请稍后重试！"));
        return false;
    }

}
