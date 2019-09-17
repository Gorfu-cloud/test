package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbPermission;
import com.bkit.fatdown.entity.TbRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @file: IAdminRoleService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 管理员角色功能接口
 * @date: Created in 2019/8/27 11:38
 * @modified:
 * @version: 1.0
 */

public interface IAdminRoleService {
    /**
     * 添加角色
     *
     * @param role 角色信息
     * @return 成功记录数
     */
    int insert(TbRole role);

    /**
     * 修改角色信息
     *
     * @param roleId 角色id
     * @param role   角色信息
     * @return 成功记录数
     */
    int update(Integer roleId, TbRole role);

    /**
     * @param ids 角色编号
     * @return 成功记录数
     */
    int delete(List<Integer> ids);

    /**
     * 获取指定角色权限
     *
     * @param roleId 角色编号
     * @return 权限列表
     */
    List<TbPermission> getPermissionList(int roleId);

    /**
     * 修改指定角色权限
     *
     * @param roleId        角色编号
     * @param permissionIds 权限列表
     * @return 成功记录
     */
    @Transactional
    int updatePermission(Integer roleId, List<Integer> permissionIds);

    /**
     * 获取角色列表
     *
     * @return 角色列表
     */
    List<TbRole> list();
}
