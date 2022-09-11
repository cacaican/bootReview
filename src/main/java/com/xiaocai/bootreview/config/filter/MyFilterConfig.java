package com.xiaocai.bootreview.config.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FilterConfig
 * @Description 注册我的第二个Filter，不使用webFilter注解 那种
 * @Author xiaocai
 * @Date 2022/9/11
 */
@Configuration
public class MyFilterConfig {
    /*首先实例化我的第二个Filter*/
    @Bean
    public MySecondFilter getMySecondFilter() {
        return new MySecondFilter();
    }

    /*@Bean,这里在构造的时候有问题，不要这样，
    public FilterRegistrationBean<MyFilter> getFilterRegistrationBean(MyFilter myFilter) {
        FilterRegistrationBean<MyFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(myFilter);
        filter.addUrlPatterns("/hahaha/*");
        filter.setName("myFilter");
        filter.setOrder(1);
        return filter;
    }*/

    @Bean
    public FilterRegistrationBean<MySecondFilter> getFilterRegistrationBean(MySecondFilter mySecondFilter) {
        FilterRegistrationBean<MySecondFilter> filter = new FilterRegistrationBean<>();
        filter.setFilter(mySecondFilter);
        filter.addUrlPatterns("/car/*");
        filter.setName("mySecondFilter");
        filter.setOrder(2);
        return filter;
    }


}
