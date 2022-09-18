package com.xiaocai.bootreview.rabbitMq.direct.service.impl;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.xiaocai.bootreview.rabbitMq.direct.config.DirectConfig;
import org.springframework.amqp.core.Message;

/**
 * @ClassName DirectConsumer
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/18
 */
@Component
public class DirectConsumer {
    @RabbitListener(queues = DirectConfig.DIRECTQUEUENAME)
    public void receive(String msg) {
        System.out.println("msg = " + msg);}

    @RabbitListener(queues = DirectConfig.DIRECTQUEUENAME)
    public void receive(Message msg) {
        System.out.println("msg 类型的消息= " + msg);
    }

}
