package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbAdminMenuRole;
import com.bkit.fatdown.entity.TbAdminMenuRoleExample;
import com.bkit.fatdown.mappers.TbAdminMenuRoleMapper;
import com.bkit.fatdown.service.IAdminMenuRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @file: AdminMenuRoleServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 管理员菜单角色
 * @date: Created in 8/22/19  12:54 AM
 * @modified:
 * @version: 1.0
 */
@Service
@Transactional
public class AdminMenuRoleServiceImpl implements IAdminMenuRoleService {

    @Resource
    private TbAdminMenuRoleMapper menuRoleMapper;

    /**
     * @param roleId 角色id
     * @return 是否成功
     */
    @Override
    public boolean deleteMenuByRoleId(int roleId) {
        TbAdminMenuRoleExample example = new TbAdminMenuRoleExample();
        example.createCriteria()
                .andRoleIdEqualTo(roleId);
        return menuRoleMapper.deleteByExample(example) > 0;
    }

    /**
     * @param roleId     角色id
     * @param menuIdList 菜单id列表
     * @return 是否成功
     */
    @Override
    public boolean addMenu(int roleId, int[] menuIdList) {
        TbAdminMenuRole menuRole = new TbAdminMenuRole();
        menuRole.setRoleId(roleId);
        for (int menuId : menuIdList) {
            menuRole.setMenuId(menuId);
            menuRole.setGmtCreate(new Date());
            menuRole.setGmtModified(new Date());
            if (menuRoleMapper.insertSelective(menuRole) == 0) {
                return false;
            }
        }
        return true;
    }
}
