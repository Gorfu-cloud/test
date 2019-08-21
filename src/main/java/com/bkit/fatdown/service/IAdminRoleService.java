package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbAdminRole;

import java.util.List;

/**
 * @file: IAdminRoleService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 用户权限角色
 * @date: Created in 8/22/19  12:28 AM
 * @modified:
 * @version: 1.0
 */

public interface IAdminRoleService {
    /**
     * @return 获取所有角色权限
     */
    List<TbAdminRole> list();

    /**
     * @param role 角色
     * @return 是否成功
     */
    boolean add(TbAdminRole role);

    /**
     * @param roleId 角色id
     * @return 是否成功
     */
    boolean delete(int roleId);
}
