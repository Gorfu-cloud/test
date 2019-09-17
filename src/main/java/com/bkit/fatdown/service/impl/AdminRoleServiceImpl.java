package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.mappers.TbRoleMapper;
import com.bkit.fatdown.mappers.TbRolePermissionRelationMapper;
import com.bkit.fatdown.mappers.dao.RolePermissionRelationDao;
import com.bkit.fatdown.service.IAdminRoleService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @file: AdminRoleServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 管理员角色功能实现类
 * @date: Created in 9/17/19  8:23 PM
 * @modified:
 * @version: 1.0
 */

public class AdminRoleServiceImpl implements IAdminRoleService {

    @Resource
    private TbRoleMapper roleMapper;

    @Resource
    private TbRolePermissionRelationMapper rolePermissionRelationMapper;

    @Resource
    private RolePermissionRelationDao rolePermissionRelationDao;


    /**
     * 添加角色
     *
     * @param role 角色信息
     * @return 成功记录数
     */
    @Override
    public int insert(TbRole role) {
        role.setGmtCreate(new Date());
        role.setGmtModified(new Date());
        role.setStatus(1);

        return roleMapper.insert(role);
    }

    /**
     * 修改角色信息
     *
     * @param roleId 角色id
     * @param role   角色信息
     * @return 成功记录数
     */
    @Override
    public int update(Integer roleId, TbRole role) {
        role.setId(roleId);
        role.setGmtModified(new Date());
        return roleMapper.updateByPrimaryKeySelective(role);
    }

    /**
     * @param ids 角色编号
     * @return 成功记录数
     */
    @Override
    public int delete(List<Integer> ids) {
        TbRoleExample example = new TbRoleExample();
        example.createCriteria().andIdIn(ids);
        return roleMapper.deleteByExample(example);
    }

    /**
     * 获取指定角色权限
     *
     * @param roleId 角色编号
     * @return 权限列表
     */
    @Override
    public List<TbPermission> getPermissionList(int roleId) {
        return rolePermissionRelationDao.getPermissionList(roleId);
    }

    /**
     * 修改指定角色权限
     *
     * @param roleId        角色编号
     * @param permissionIds 权限列表
     * @return 成功记录
     */
    @Override
    public int updatePermission(Integer roleId, List<Integer> permissionIds) {
        // 删除原有关系
        TbRolePermissionRelationExample example = new TbRolePermissionRelationExample();
        example.createCriteria()
                .andRoleIdEqualTo(roleId);
        rolePermissionRelationMapper.deleteByExample(example);

        // 批量添加新关系

        List<TbRolePermissionRelation> relationList = new ArrayList<>();

        for (Integer permissionId : permissionIds) {
            TbRolePermissionRelation relation = new TbRolePermissionRelation();
            relation.setRoleId(roleId);
            relation.setPermissionId(permissionId);
            relation.setGmtCreate(new Date());
            relation.setGmtModified(new Date());
            relationList.add(relation);
        }

        return rolePermissionRelationDao.insertList(relationList);
    }

    /**
     * 获取角色列表
     *
     * @return 角色列表
     */
    @Override
    public List<TbRole> list() {
        return roleMapper.selectByExample(new TbRoleExample());
    }
}
