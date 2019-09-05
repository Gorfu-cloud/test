package com.bkit.fatdown.component;

import com.bkit.fatdown.service.IRedisService;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @file: RedisHelper
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: redis操作Service的实现类
 * @date: Created in 9/4/19  11:27 PM
 * @modified:
 * @version: 1.0
 */
@Component
public class RedisHelperImpl implements IRedisService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 存储数据
     *
     * @param key   键值
     * @param value 数据
     */
    @Override
    public void set(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 获取数据
     *
     * @param key 键值
     * @return 对应键值数据
     */
    @Override
    public String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 设置超期时间
     *
     * @param key    键值
     * @param expire 时间
     * @return 是否成功
     */
    @Override
    public boolean expire(String key, long expire) {
        return stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    /**
     * 删除数据
     *
     * @param key 键值
     */
    @Override
    public void remove(String key) {
        stringRedisTemplate.delete(key);
    }

    /**
     * 自增操作
     *
     * @param key   键值
     * @param delta 自增步长
     * @return 步长数
     */
    @Override
    public Long increment(String key, long delta) {
        return stringRedisTemplate.opsForValue().increment(key, delta);
    }
}
