package com.xiaocai.bootreview.rabbitMq.workQuene.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName WorkQueneConfig
 * @Description 工作队列就是一个队列中的消息被多个消费者消费
 * @Author xiaocai
 * @Date 2022/9/18
 */
@Configuration
public class WorkQueneConfig {
    public final static  String  WORKQUEUENAME="work_quene";

    @Bean
    public Queue workQuene(){
        return new Queue(WORKQUEUENAME);
    }

}
