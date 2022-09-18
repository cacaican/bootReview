package com.xiaocai.bootreview.rabbitMq.publishAndSubscribe.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName PsConsumer
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/18
 */
@Component
@RabbitListener(queues="publish_subscribe_queue2")
//    @RabbitListener这个注解可以放到类上面，此时，需要和RabbitListener组合使用，RabbitListener放到不同方法上，会根据不同类型的入参 去消费不同类型的消息
public class PsConsumer2 {

    @RabbitHandler
    public void process(String message){
        System.out.println("处理String消息"+message);
    }

    @RabbitHandler
    public void process2(byte[] bytesMessage){
        System.out.println("处理byte消息"+bytesMessage);
    }

}
