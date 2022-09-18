package com.xiaocai.bootreview.rabbitMq.publishAndSubscribe.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @ClassName PublishAndSubscriteCondfig
 * @Description 发布订阅模式，也是广播模式，使用的时fanout路由器
 * @Author xiaocai
 * @Date 2022/9/18
 */
@Configuration
public class PublishAndSubscribeConfig {

    public static  final String PUBLISHANDSUBSCRIBEEXCHANGENAME ="publish_subscribe_exchange1";
    public static  final String PUBLISHANDSUBSCRIBEQUEUE1 ="publish_subscribe_queue1";
    public static  final String PUBLISHANDSUBSCRIBEQUEUE2 ="publish_subscribe_queue2";

    @Bean
    public Queue psQueue(){
        return new Queue(PUBLISHANDSUBSCRIBEQUEUE1);
    }

    @Bean
    public Queue psQueue2(){
        return new Queue(PUBLISHANDSUBSCRIBEQUEUE2);
    }

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange(PUBLISHANDSUBSCRIBEEXCHANGENAME);
    }

    @Bean
    public Binding bindPsQueueToPsExchange1(Queue psQueue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(psQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindPsQueueToPsExchange2(Queue psQueue2, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(psQueue2).to(fanoutExchange);
    }
}
