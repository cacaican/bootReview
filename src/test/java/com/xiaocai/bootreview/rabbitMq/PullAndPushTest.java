package com.xiaocai.bootreview.rabbitMq;

import com.xiaocai.bootreview.AbstractTest;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import static com.xiaocai.bootreview.rabbitMq.direct.config.DirectConfig.DIRECTQUEUENAME;
import static com.xiaocai.bootreview.rabbitMq.direct.config.DirectConfig.DIRECTQUEUENAME2;
import static com.xiaocai.bootreview.rabbitMq.workQuene.config.WorkQueneConfig.WORKQUEUENAME;

/**
 * @ClassName PullAndPushTest
 * @Description 测试rabbitMq的手动拉取和推送
 *     原文链接：https://blog.csdn.net/qq_29595463/article/details/107859140
 * @Author xiaocai
 * @Date 2022/9/18
 */
public class PullAndPushTest extends AbstractTest {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void receive() {
        Object o = rabbitTemplate.receiveAndConvert(WORKQUEUENAME);
        System.out.println(o.hashCode());
        System.out.println(o);
    }

    @Test
    public void sendDrict2() {
        for (int i = 0; i < 100; i++) {
            rabbitTemplate.convertAndSend(DIRECTQUEUENAME2, "hello"+i);
        }

    }

    @Test
    public void sendDead() {
        for (int i = 0; i < 100; i++) {
            rabbitTemplate.convertAndSend("user-queue", "hello"+i);
        }

    }

}
