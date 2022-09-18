package com.xiaocai.bootreview.rabbitMq.publishAndSubscribe.config;

import com.xiaocai.bootreview.AbstractTest;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.charset.StandardCharsets;

import static com.xiaocai.bootreview.rabbitMq.workQuene.config.WorkQueneConfig.WORKQUEUENAME;

/**
 * @ClassName PublishAndSubscribeTest
 * @Description 发布订阅测试类
 * @Author xiaocai
 * @Date 2022/9/18
 */
public class PublishAndSubscribeTest extends AbstractTest {
    @Autowired
    RabbitTemplate rabbitTemplate;


    @Test
    public void contextLoads() {
        for (int i = 0; i < 15; i++) {
            rabbitTemplate.convertAndSend(PublishAndSubscribeConfig.PUBLISHANDSUBSCRIBEEXCHANGENAME,
                    PublishAndSubscribeConfig.PUBLISHANDSUBSCRIBEQUEUE1,
                    "hello psQueue"+i);
            rabbitTemplate.convertAndSend(PublishAndSubscribeConfig.PUBLISHANDSUBSCRIBEEXCHANGENAME,
                    PublishAndSubscribeConfig.PUBLISHANDSUBSCRIBEQUEUE2,
                    "hello psQueue"+i);

            rabbitTemplate.convertAndSend(PublishAndSubscribeConfig.PUBLISHANDSUBSCRIBEEXCHANGENAME,
                    PublishAndSubscribeConfig.PUBLISHANDSUBSCRIBEQUEUE1,
                    ("hello psQueue byte"+i).getBytes(StandardCharsets.UTF_8));
            rabbitTemplate.convertAndSend(PublishAndSubscribeConfig.PUBLISHANDSUBSCRIBEEXCHANGENAME,
                    PublishAndSubscribeConfig.PUBLISHANDSUBSCRIBEQUEUE2,
                    ("hello psQueue byte"+i).getBytes(StandardCharsets.UTF_8));
        }
    }
}
