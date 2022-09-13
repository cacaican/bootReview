原文链接：https://zhuanlan.zhihu.com/p/139528556
1.添加依赖
~~~xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
~~~
2.application.yml中定义redisTemplate属性
~~~yaml
spring:
  redis:
    # Redis服务器地址
    host: localhost
    #Redis服务器连接端口
    port: 6379
    #password:
    # Redis数据库索引（默认为0）
    database: 1
    # 连接超时时间（毫秒）
    timeout: 5000
    jedis:
      pool:
        #连接池最大连接数（使用负值表示没有限制）
        max-active: 100
        # 连接池中的最小空闲连接
        max-idle: 10
        # 连接池最大阻塞等待时间（使用负值表示没有限制）
        max-wait: 100000
~~~
3.某些特殊字符解析时候需要特殊定义，所以重新定义redisTemplate
使用 自定义的配置 替换 JdkSerializationRedisSerializer， 否则序列化进 redis 会显示为特殊字符；
查阅 RedisReactiveAutoConfiguration 类可以查看 reactiveRedisTemplate 装配过程‘；
查阅 RedisAutoConfiguration 类可以查看 redisTemplate 装配过程‘
~~~java
/**
 * @Author lsc
 * <p> redis配置 替换默认的jdk序列化机制 </p>
 */
@Configuration
public class RedisConfig {
​
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        // 创建redisTemplate
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
​
        // 使用Jackson2JsonRedisSerialize替换默认序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
​
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
​
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
​
        // key采用String的序列化方式
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // value序列化方式采用jackson
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        // hash的key也采用String的序列化方式
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // hash的value序列化方式采用jackson
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}
~~~