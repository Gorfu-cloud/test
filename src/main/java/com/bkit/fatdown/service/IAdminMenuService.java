package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbAdminMenu;

import java.util.List;

/**
 * @file: IAdminMenuService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 管理员菜单功能接口
 * @date: Created in 8/22/19  12:18 AM
 * @modified:
 * @version: 1.0
 */

public interface IAdminMenuService {
    /**
     * @return 所有用户菜单
     */
    List<TbAdminMenu> list();

    /**
     * @param adminId 管理员id
     * @return 对应功能菜单
     */
    List<TbAdminMenu> listByAdminId(int adminId);

    /**
     * @return 功能菜单
     */
    List<TbAdminMenu> listMenuTree();

    /**
     * @param roleId 角色id
     * @return 对应功能菜单
     */
    List<Integer> listByAdminRoleId(int roleId);
}
