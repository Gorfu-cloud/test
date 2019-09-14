package com.bkit.fatdown.mappers.dao;

import com.bkit.fatdown.entity.TbPermission;
import com.bkit.fatdown.entity.TbRolePermissionRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @file: RolePermissionRelationDao
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 后台用户角色管理自定义Dao
 * @date: Created in 2019/8/27 19:53
 * @modified:
 * @version: 1.0
 */
public interface RolePermissionRelationDao {
    /**
     * 批量插入角色和权限关系
     * @param list 角色权限关系表
     * @return
     */
    int insertList(@Param("list") List<TbRolePermissionRelation> list);

    /**
     * 根据角色获取权限
     * @param roleId 角色id
     * @return
     */
    List<TbPermission> getPermissionList(@Param("roleId") Integer roleId);
}
