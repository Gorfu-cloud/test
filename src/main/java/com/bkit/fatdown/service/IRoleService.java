package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbRole;

import java.util.List;

/**
 * @file: IRoleService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 角色权限
 * @date: Created in 2019/8/27 11:36
 * @modified:
 * @version: 1.0
 */
public interface IRoleService {
    boolean insert(TbRole role);

    boolean update(TbRole role);

    boolean delete(int id);

    TbRole get(int id);
}
