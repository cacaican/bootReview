package com.xiaocai.bootreview.rabbitMq.workQuene.service.impl;

import com.xiaocai.bootreview.rabbitMq.direct.config.DirectConfig;
import com.xiaocai.bootreview.rabbitMq.workQuene.config.WorkQueneConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName WorkQueneConsumer
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/18
 */
@Component
public class WorkConsumer2 {
    @RabbitListener(queues = WorkQueneConfig.WORKQUEUENAME)
    public void receive(String msg) {
        System.out.println("workQueue consumer2'msg = " + msg);
    }
}
