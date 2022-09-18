package com.xiaocai.bootreview.rabbitMq.deadQueue;

import com.xiaocai.bootreview.AbstractTest;
import org.junit.Test;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;


public class SenderTest extends AbstractTest{

    @Autowired
    private Sender sender;

    /**
     * 发送消息100条 超出的90条进入死信队列
     */
    @Test
    public void sendMore(){
        sender.sendMore();
    }
}

