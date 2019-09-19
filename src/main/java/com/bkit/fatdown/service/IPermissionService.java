package com.bkit.fatdown.service;

import com.bkit.fatdown.dto.power.PermissionNode;
import com.bkit.fatdown.entity.TbPermission;

import java.util.List;

/**
 * @file: IPermissionService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 权限表
 * @date: Created in 2019/8/27 11:39
 * @modified:
 * @version: 1.0
 */

public interface IPermissionService {
    /**
     * @param permission 权限
     * @return
     */
    boolean insert(TbPermission permission);

    /**
     * @param id id
     * @return
     */
    boolean delete(int id);

    /**
     * @param permission 权限
     * @return
     */
    boolean update(TbPermission permission);

    /**
     * @param permission 权限
     * @return
     */
    boolean update(Integer id,TbPermission permission);

    /**
     * @param id 编号
     * @return
     */
    TbPermission get(int id);

    /**
     * @param adminId id
     * @return
     */
    List<TbPermission> list(int adminId);

    /**
     * 批量删除权限
     * @param idList 权限id
     * @return
     */
    int delete(List<Integer> idList);

    /**
     * 以层级结构返回所有权限
     */
    List<PermissionNode> treeList();

    /**
     * 获取所有权限
     */
    List<TbPermission> list();
}
