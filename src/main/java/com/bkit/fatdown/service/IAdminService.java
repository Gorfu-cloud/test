package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbAdmin;

/**
 * @file: IAdminService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 管理员服务接口
 * @date: Created in 8/17/19  3:05 PM
 * @modified:
 * @version: 1.0
 */

public interface IAdminService {
    /**
     * @param admin 管理员
     * @return 是否成功
     */
    boolean insert(TbAdmin admin);

    /**
     * @param admin 管理员
     * @return 是否成功
     */
    boolean update(TbAdmin admin);

    /**
     * @param id id
     * @return 是否成功
     */
    TbAdmin get(int id);

    /**
     * @param id id
     * @return 是否成功
     */
    boolean delete(int id);

    /**
     * @param id id
     * @return 记录数
     */
    int count(int id);

    /**
     * @param name     名称
     * @param password 密码
     * @return 记录数
     */
    int count(String name, String password);

    /**
     * @param userName 用户名
     * @param password 密码
     * @param status   状态
     * @return
     */
    int count(String userName, String password, Integer status);
}
