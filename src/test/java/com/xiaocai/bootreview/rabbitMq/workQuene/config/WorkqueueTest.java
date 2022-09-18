package com.xiaocai.bootreview.rabbitMq.workQuene.config;

import com.xiaocai.bootreview.AbstractTest;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import static com.xiaocai.bootreview.rabbitMq.workQuene.config.WorkQueneConfig.WORKQUEUENAME;

/**
 * @ClassName WorkqueueTest
 * @Description 工作队列测试类，这里发布多条消息到工作队列上
 * @Author xiaocai
 * @Date 2022/9/18
 */
public class WorkqueueTest  extends AbstractTest {
    @Autowired
    RabbitTemplate rabbitTemplate;


    @Test
    public void contextLoads() {
        for (int i = 0; i < 1000; i++) {
            rabbitTemplate.convertAndSend(WORKQUEUENAME, "hello workQueue"+i);
            //等待发布确认
            boolean b = rabbitTemplate.waitForConfirms(1000);
            //等到自上次调用以来发布的所有消息都已被代理确认或确认；或直到超时。如果超时到期，则会引发 TimeoutException。
            // 如果有任何消息被取消，waitForConfirmsOrDie 将抛出 IOException。
            // 在非确认通道上调用时，它会抛出 IllegalStateException。
//            rabbitTemplate.waitForConfirmsOrDie(1000);
//            rabbitTemplate.getUnconfirmed();
//            rabbitTemplate.isConfirmListener();
            //((RabbitTemplate)rabbitTemplate).setConfirmCallback(); 设置发布确认后回调
            // ((RabbitTemplate)rabbitTemplate).setReturnsCallback(); 设置发布失败后回调
        }
    }
}
