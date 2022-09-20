package com.xiaocai.bootreview.rabbitMq.direct.config;

import com.xiaocai.bootreview.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import static com.xiaocai.bootreview.rabbitMq.direct.config.DirectConfig.DIRECTQUEUENAME;


/**
 * @ClassName DirectConfigTest
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/18
 */
public class DirectConfigTest extends AbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DirectConfigTest.class);


    @Autowired
    RabbitTemplate rabbitTemplate;


    @Test
    public void contextLoads() {
        for (int i = 0; i < 1000; i++) {
            rabbitTemplate.convertAndSend(DIRECTQUEUENAME, "hello"+i);
//            rabbitTemplate.setRecoveryCallback(); 设置恢复后回调
            // 生产者发送消息后，如果发送成功，则打印“消息发送成功”的日志信息
            /*rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
                public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                    LOGGER.info("消息发送成功:correlationData({}),ack({}),cause({})", correlationData, ack, cause);
                }
            });*/
        }
    }


}
