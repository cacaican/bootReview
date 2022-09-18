package com.xiaocai.bootreview.rabbitMq.deadQueue;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName DeadQueueConfig
 * @Description
 * TTL(time to live)时间超出，消息过期
 * 队列达到了最大设置长度(x-max-length)，超出的消息成为死信
 * 被nack并且未设置重回队列的消息，或者重新投递到了最大次数
 * @Author xiaocai
 * @Date 2022/9/18
 */
@Configuration
public class DeadQueueConfig {

    /**
     * 死信交换机声明
     * @param deadLetterExchange
     * @return
     */
    @Bean
    public Exchange userDeadExchange(@Value("${app.rabbitmq.exchange.dead}") String deadLetterExchange) {
        return ExchangeBuilder
                .topicExchange(deadLetterExchange)
                .durable(true)
                .build();
    }

    /*
     * 死信消息队列  死信消息路由的队列
     * @return
     */
    @Bean
    public Queue userDeadQueue(@Value("${app.rabbitmq.queue.dead}") String userDeadQueue) {
        return QueueBuilder
                .durable(userDeadQueue)
                .build();
    }

    /**
     * 死信队列绑定死信交换机
     * @return
     */
    @Bean
    public Binding userDeadLetterBinding(Queue userDeadQueue, Exchange userDeadExchange) {
        return BindingBuilder
                .bind(userDeadQueue)
                .to(userDeadExchange)
                .with("user-dead-letter.*")
                .noargs();
    }

    @Bean
    public Queue userQueue(@Value("${app.rabbitmq.queue.user}") String userQueueName
            , @Value("${app.rabbitmq.exchange.dead}") String deadLetterExchange) {
        return QueueBuilder
                .durable(userQueueName)
                //设置队列最大长度
                .withArgument("x-max-length", 10)
                //死信交换机声明
                .withArgument("x-dead-letter-exchange", deadLetterExchange)
                //死信消息的路由key
                .withArgument("x-dead-letter-routing-key", "user-dead-letter.routingkey")
                //消息过期时间设置 超出时间未消费成为死信
                .withArgument("x-message-ttl", 60000)
                .build();
    }

    /**
     * 用户交换及
     * @param deadLetterExchange
     * @return
     */
    @Bean
    public Exchange userExchange(@Value("${app.rabbitmq.exchange.user}") String deadLetterExchange) {
        return ExchangeBuilder
                .topicExchange(deadLetterExchange)
                .durable(true)
                .build();
    }

}
