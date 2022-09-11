package com.xiaocai.bootreview.config.servlet;

import com.xiaocai.bootreview.config.filter.MySecondFilter;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Collections;

/**
 * @ClassName MyServletConfig
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/11
 */
@Configuration
public class MyServletConfig {
    @Bean
    public MySecondServlet getMySecondServlet(){
        return new MySecondServlet();
    }



    //注册 Servlet 到容器中
    @Bean
    public ServletRegistrationBean<MySecondServlet> myServlet(MySecondServlet mySecondServlet){

        ServletRegistrationBean<MySecondServlet> servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(mySecondServlet);
        servletRegistrationBean.setName("mySecondServlet");
        servletRegistrationBean.setUrlMappings(Collections.singletonList("/mySecondServlet"));
        return servletRegistrationBean;
    }
}
