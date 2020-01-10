package com.cn.kg.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import java.util.concurrent.TimeUnit;
/**
 * @program: mvc-template
 * @description: TODO
 * @author: konggang
 * @create: 2019-11-02 15:57
 **/
@Component
public class RedisCacheService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    public void set(String key,Object value){
        redisTemplate.opsForValue().set(key,value);
    }

    public boolean setNX(String key,Object value){
        return redisTemplate.opsForValue().setIfAbsent(key,value);
    }

    public void del(String... key){
         redisTemplate.delete(CollectionUtils.arrayToList(key));
    }

    public boolean expire(String key,long time,TimeUnit timeUnit){
        return redisTemplate.expire(key,time,timeUnit);
    }
}

