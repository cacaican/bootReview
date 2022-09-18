package com.xiaocai.bootreview.rabbitMq.deadQueue;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName Sender
 * @Description 原文链接：https://blog.csdn.net/weixin_44507274/article/details/105469344
 * @Author xiaocai
 * @Date 2022/9/18
 */
@Component
public class Sender {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Value("${app.rabbitmq.exchange.user}")
    String userExchangeName;


    /**
     * 发送消息100条 超出的90条进入死信队列
     */
    public void sendMore()  {

        int i = 0;
        while (i < 100){
            i++;
            CorrelationData correlationData = new CorrelationData("messageId" + i);
            rabbitTemplate.convertAndSend(userExchangeName, "user-queue", "{'msg':'message'}", correlationData);
        }
    }}
