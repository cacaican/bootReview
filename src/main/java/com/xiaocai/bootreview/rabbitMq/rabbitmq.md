1.添加依赖
~~~xml
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-amqp</artifactId>
</dependency>
~~~
2.yaml文件中添加相关配置
~~~yml
spring:
    rabbitmq:
        host: 127.0.0.1
        port: 5672
        username: guest
        password: guest
        virtualHost: /
~~~
3.创建相关mq配置类，配置交换机，队列以及绑定
rabbitmq中有七种消息的传播方式，这里创建五个
简单队列:生产者--队列--消费者    详见：DirectConfig
工作列队：生产者--队列--多个消费者  详见：WorkQueneConfig
发布订阅： 生产者--交换机--各自队列--各自消费者
路由：生产者--交换机--根据路由键文本匹配的一对一或一对多的队列--各自消费者
主题：生产者--交换机--根据路由键模糊匹配的一对一或一对多的队列--各自消费者 ，其中api.core.* 中的* 表示单层匹配，#表示多层匹配
rpc：这里不做讨论
订阅确认模式
4.
