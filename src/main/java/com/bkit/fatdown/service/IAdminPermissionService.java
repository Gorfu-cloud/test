package com.bkit.fatdown.service;

import com.bkit.fatdown.dto.power.PermissionNode;
import com.bkit.fatdown.entity.TbPermission;

import java.util.List;

/**
 * @file: IAdminPermissionService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 管理员权限关系表
 * @date: Created in 2019/8/27 11:36
 * @modified:
 * @version: 1.0
 */

public interface IAdminPermissionService {
    /**
     * 添加权限
     *
     * @param permission 权限
     * @return 成功记录数
     */
    int insert(TbPermission permission);

    /**
     * 修改权限
     *
     * @param id         权限id
     * @param permission 权限关系
     * @return 成功记录数
     */
    int update(Integer id, TbPermission permission);

    /**
     * 批量删除权限
     *
     * @param ids ids 权限列表
     * @return 成功记录数
     */
    int delete(List<Integer> ids);

    /**
     * 以层级结构返回所有权限
     * @return 以层级结构返回所有权限
     */
    List<PermissionNode> treeList();

    /**
     * 获取所有权限
     * @return 获取权限
     */
    List<TbPermission> list();
}
