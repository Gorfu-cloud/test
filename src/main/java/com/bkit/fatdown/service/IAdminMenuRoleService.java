package com.bkit.fatdown.service;

/**
 * @file: IAdminMenuRoleService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 用户角色菜单功能接口
 * @date: Created in 8/22/19  12:24 AM
 * @modified:
 * @version: 1.0
 */

public interface IAdminMenuRoleService {
    /**
     * @param roleId 角色id
     * @return 是否成功
     */
    boolean deleteMenuByRoleId(int roleId);

    /**
     * @param roleId     角色id
     * @param menuIdList 菜单id列表
     * @return 是否成功
     */
    boolean addMenu(int roleId, int[] menuIdList);
}
