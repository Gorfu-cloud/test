package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @file: RedisServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: redis操作Service的实现类
 * @date: Created in 9/4/19  11:27 PM
 * @modified:
 * @version: 1.0
 */
@Service
public class RedisServiceImpl implements IRedisService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 存储数据
     *
     * @param key   键值
     * @param value 数据
     */
    @Override
    public void set(String key, String value) {

    }

    /**
     * 获取数据
     *
     * @param key 键值
     * @return 对应键值数据
     */
    @Override
    public String get(String key) {
        return null;
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
        return false;
    }

    /**
     * 删除数据
     *
     * @param key 键值
     */
    @Override
    public void remove(String key) {

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
        return null;
    }
}
