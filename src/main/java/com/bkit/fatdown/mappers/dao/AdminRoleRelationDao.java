package com.bkit.fatdown.mappers.dao;

import com.bkit.fatdown.entity.TbAdminRoleRelation;
import com.bkit.fatdown.entity.TbPermission;
import com.bkit.fatdown.entity.TbRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @file: AdminRoleRelationDao
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 获取用户权限
 * @date: Created in 2019/8/27 12:53
 * @modified:
 * @version: 1.0
 */
public interface AdminRoleRelationDao {
    /**
     * 批量插入用户角色关系
     */
    int insertList(@Param("list") List<TbAdminRoleRelation> adminRoleRelationList);

    /**
     * 获取用于所有角色
     */
    List<TbRole> getRoleList(@Param("adminId") Integer adminId);

    /**
     * 获取用户所有角色权限
     */
    List<TbPermission> getRolePermissionList(@Param("adminId") Integer adminId);

    /**
     * 获取用户所有权限(包括+-权限)
     */
    List<TbPermission> getPermissionList(@Param("adminId") Integer adminId);
}
