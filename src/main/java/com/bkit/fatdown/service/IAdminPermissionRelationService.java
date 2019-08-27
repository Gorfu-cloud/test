package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbAdminPermissionRelation;

import java.util.List;

/**
 * @file: IAdminPermissionRelationService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 管理员权限关系表
 * @date: Created in 2019/8/27 11:36
 * @modified:
 * @version: 1.0
 */

public interface IAdminPermissionRelationService {
    /**
     * @param permissionRelation 权限关系
     * @return
     */
    boolean insert(TbAdminPermissionRelation permissionRelation);

    /**
     * @param permissionRelation 权限关系
     * @return
     */
    boolean update(TbAdminPermissionRelation permissionRelation);

    /**
     * @param id id
     * @return
     */
    boolean delete(int id);

    /**
     * @param id id
     * @return
     */
    TbAdminPermissionRelation get(int id);

    /**
     * @param adminId 管理员id
     * @return
     */
    List<TbAdminPermissionRelation> listByAdminId(int adminId);

    /**
     * @param permissionId 权限id
     * @return
     */
    List<TbAdminPermissionRelation> listByPermissionId(int permissionId);
}
