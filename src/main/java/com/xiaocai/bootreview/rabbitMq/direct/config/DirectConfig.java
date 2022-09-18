package com.xiaocai.bootreview.rabbitMq.direct.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName DirectConfig
 * @Description 这里展示直连方式的配置
 * @Author xiaocai
 * @Date 2022/9/18
 */
@Configuration
public class DirectConfig {

    public final static String DIRECTQUEUENAME = "direct_quene";
    public final static String DIRECTQUEUENAME2 = "direct_quene2";

    @Bean
    Queue directQuene1() {
        return new Queue(DIRECTQUEUENAME);
    }

    @Bean
    Queue directQuene2() {
        return new Queue(DIRECTQUEUENAME2);
    }
}
