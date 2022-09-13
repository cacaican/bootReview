package com.xiaocai.bootreview.redis;

import com.xiaocai.bootreview.AbstractTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName RedisTest
 * @Description 测试字符串缓存操作
 * @Author xiaocai
 * @Date 2022/9/12
 */
public class StringTest extends AbstractTest {

    @Test
    public void test1(){
        System.out.println("hi test");
    }

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    // 测试 key 是否存在,存放和查询
    @Test
    public void testSetStering(){
        String key = "xiaocai";
        String value = "zhenshuai";
        //String数值存放
        redisTemplate.opsForValue().set(key,value);
        //查询是否存在
        Boolean aBoolean = redisTemplate.hasKey(key);
        //根据Key查询value值
        Object o = redisTemplate.opsForValue().get(key);
        // true
        System.out.println(String.format("key%s是否存在： %s--------------key为%s的值为： %s",key,aBoolean,key,value));

        //查询过期时间
        Long originExpire = redisTemplate.getExpire(key,TimeUnit.MILLISECONDS);
        //设置过期时间
        long expire = (long) (Math.random()*600000000);
        redisTemplate.boundValueOps(key).expire(expire, TimeUnit.MILLISECONDS);
        //查询过期时间
        Long finalExpire = redisTemplate.getExpire(key,TimeUnit.MILLISECONDS);

        System.out.println(String.format("key:%s原过期时间为： %s,\t将设置过期时间为%s\t 最后查询过期时间为%s",key,originExpire,expire,finalExpire));
    }

    @Test
    public void testDelete(){
//        String key = "zszxz";没有这个key时候返回false
        String key = "xiaocai"; //成功删除时候返回为true

        Boolean delete = redisTemplate.delete(key);
        System.out.println(String.format("key:%s删除操作结果为： %s",key,delete));

    }
}
