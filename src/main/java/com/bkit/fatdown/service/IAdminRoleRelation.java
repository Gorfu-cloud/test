package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbAdminRoleRelation;

import java.util.List;

/**
 * @file: IAdminRoleRelation
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 管理员角色关系表
 * @date: Created in 2019/8/27 11:38
 * @modified:
 * @version: 1.0
 */

public interface IAdminRoleRelation {
    /**
     * @param roleRelation 角色关系
     * @return
     */
    boolean insert(TbAdminRoleRelation roleRelation);

    /**
     * @param roleRelation 角色关系
     * @return
     */
    boolean update(TbAdminRoleRelation roleRelation);

    /**
     * @param id id
     * @return
     */
    boolean delete(int id);

    /**
     * @param id id
     * @return
     */
    TbAdminRoleRelation get(int id);

    /**
     * @param adminId 管理员id
     * @return
     */
    List<TbAdminRoleRelation> list(int adminId);
}
