package com.xiaocai.bootreview.config.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @ClassName InterceptorConfig
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/11
 */
@Configuration
public class InterceptorConfig  implements WebMvcConfigurer {

    @Resource
    private MyInterceptor myInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/api/v1/**");
    }
}
