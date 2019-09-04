package com.bkit.fatdown.service;

/**
 * @file: IRedisService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: redis操作Service， 对象和数组都以json形式进行存储
 * @date: Created in 9/4/19  11:22 PM
 * @modified:
 * @version: 1.0
 */

public interface IRedisService {
    /**
     * 存储数据
     *
     * @param key   键值
     * @param value 数据
     */
    void set(String key, String value);

    /**
     * 获取数据
     *
     * @param key 键值
     * @return 对应键值数据
     */
    String get(String key);

    /**
     * 设置超期时间
     *
     * @param key    键值
     * @param expire 时间
     * @return 是否成功
     */
    boolean expire(String key, long expire);

    /**
     * 删除数据
     *
     * @param key 键值
     */
    void remove(String key);

    /**
     * 自增操作
     *
     * @param key   键值
     * @param delta 自增步长
     * @return 步长数
     */
    Long increment(String key, long delta);
}
