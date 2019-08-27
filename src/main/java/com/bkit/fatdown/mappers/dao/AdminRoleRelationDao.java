package com.bkit.fatdown.mappers.dao;

import com.bkit.fatdown.entity.TbPermission;
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
    List<TbPermission> getPermissionList(int adminId) ;
}
