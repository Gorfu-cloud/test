package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbAdminMenu;
import com.bkit.fatdown.entity.TbAdminMenuExample;
import com.bkit.fatdown.mappers.TbAdminMenuMapper;
import com.bkit.fatdown.service.IAdminMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @file: AdminMenuServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 角色菜单功能接口
 * @date: Created in 8/22/19  12:43 AM
 * @modified:
 * @version: 1.0
 */

@Service
public class AdminMenuServiceImpl implements IAdminMenuService {

    @Resource
    private TbAdminMenuMapper adminMenuMapper;

    /**
     * @return 所有用户菜单
     */
    @Override
    public List<TbAdminMenu> list() {
        return adminMenuMapper.selectByExample(new TbAdminMenuExample());
    }

    /**
     * @param adminId 管理员id
     * @return 对应功能菜单
     */
    @Override
    public List<TbAdminMenu> listByAdminId(int adminId) {

        return null;
    }

    /**
     * @return 功能菜单
     */
    @Override
    public List<TbAdminMenu> listMenuTree() {
        return null;
    }

    /**
     * @param roleId 角色id
     * @return 对应功能菜单
     */
    @Override
    public List<Integer> listByAdminRoleId(int roleId) {
        return null;
    }
}
