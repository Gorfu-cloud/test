package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbAdminRole;
import com.bkit.fatdown.entity.TbAdminRoleExample;
import com.bkit.fatdown.mappers.TbAdminRoleMapper;
import com.bkit.fatdown.service.IAdminRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: AdminRoleServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 权限角色功能实现接口
 * @date: Created in 8/22/19  12:39 AM
 * @modified:
 * @version: 1.0
 */
@Service
public class AdminRoleServiceImpl implements IAdminRoleService {

    @Resource
    private TbAdminRoleMapper adminRoleMapper;

    /**
     * @return 获取所有角色权限
     */
    @Override
    public List<TbAdminRole> list() {
        return adminRoleMapper.selectByExample(new TbAdminRoleExample());
    }

    /**
     * @param role 角色
     * @return 是否成功
     */
    @Override
    public boolean add(TbAdminRole role) {
        if (role.getGmtCreate() == null) {
            role.setGmtCreate(new Date());
        }
        role.setGmtModified(new Date());
        return adminRoleMapper.insertSelective(role) > 0;
    }

    /**
     * @param roleId 角色id
     * @return 是否成功
     */
    @Override
    public boolean delete(int roleId) {
        return adminRoleMapper.deleteByPrimaryKey(roleId) > 0;
    }
}
