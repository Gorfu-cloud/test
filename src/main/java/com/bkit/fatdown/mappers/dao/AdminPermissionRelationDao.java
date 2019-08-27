package com.bkit.fatdown.mappers.dao;

import com.bkit.fatdown.entity.TbAdminPermissionRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @file: AdminPermissionRelationDao
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 用户自定义权限Dao
 * @date: Created in 2019/8/27 19:45
 * @modified:
 * @version: 1.0
 */

public interface AdminPermissionRelationDao {
    int insertList(@Param("list") List<TbAdminPermissionRelation> list);
}
