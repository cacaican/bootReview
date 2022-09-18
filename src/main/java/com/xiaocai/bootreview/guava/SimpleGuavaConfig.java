package com.xiaocai.bootreview.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName SimpleGuavaConfig
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/18
 */
public class SimpleGuavaConfig {

    private final RateLimiter rateLimiter;

    public SimpleGuavaConfig(RateLimiter rateLimiter) {
        this.rateLimiter = rateLimiter;
    }

    public static void main(String[] args) {
        SimpleGuavaConfig config = new SimpleGuavaConfig(RateLimiter.create(10, 10, TimeUnit.SECONDS));

        for (int i = 0; i < 10; i++) {
            rateLimiter(config.rateLimiter);
        }
    }

    private static void rateLimiter(RateLimiter rateLimiter){
        if(rateLimiter.tryAcquire()) {
            doBusiness();
            return;
        }
        System.out.println("服务器忙，请稍后重试！");
    }

    private static void doBusiness(){
        System.out.println("可以通行，处理业务");
    }
}
