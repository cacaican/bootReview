package com.xiaocai.bootreview.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RedisService
 * @Description TODO
 * @Author xiaocai
 * @Date 2022/9/12
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @RequestMapping("/getString")
    public String test01(String key){
        return String.valueOf(redisTemplate.boundValueOps(key).get());
    }
}
