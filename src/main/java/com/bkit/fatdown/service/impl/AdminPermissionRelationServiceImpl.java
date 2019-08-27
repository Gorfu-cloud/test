package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbAdminPermissionRelation;
import com.bkit.fatdown.entity.TbAdminPermissionRelationExample;
import com.bkit.fatdown.mappers.TbAdminPermissionRelationMapper;
import com.bkit.fatdown.service.IAdminPermissionRelationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @file: AdminPermissionRelationServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 管理员权限功能实现类
 * @date: Created in 2019/8/27 11:53
 * @modified:
 * @version: 1.0
 */
@Service
public class AdminPermissionRelationServiceImpl implements IAdminPermissionRelationService {

    @Resource
    private TbAdminPermissionRelationMapper adminPermissionRelationMapper;

    /**
     * @param permissionRelation 权限关系
     * @return
     */
    @Override
    public boolean insert(TbAdminPermissionRelation permissionRelation) {
        return adminPermissionRelationMapper.insertSelective(permissionRelation) > 0;
    }

    /**
     * @param permissionRelation 权限关系
     * @return
     */
    @Override
    public boolean update(TbAdminPermissionRelation permissionRelation) {
        return adminPermissionRelationMapper.updateByPrimaryKeySelective(permissionRelation) > 0;
    }

    /**
     * @param id id
     * @return
     */
    @Override
    public boolean delete(int id) {
        return adminPermissionRelationMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * @param id id
     * @return
     */
    @Override
    public TbAdminPermissionRelation get(int id) {
        return adminPermissionRelationMapper.selectByPrimaryKey(id);
    }

    /**
     * @param adminId 管理员id
     * @return
     */
    @Override
    public List<TbAdminPermissionRelation> listByAdminId(int adminId) {
        TbAdminPermissionRelationExample example = new TbAdminPermissionRelationExample();
        example.createCriteria()
                .andAdminIdEqualTo(adminId);
        return adminPermissionRelationMapper.selectByExample(example);
    }

    /**
     * @param permissionId 权限id
     * @return
     */
    @Override
    public List<TbAdminPermissionRelation> listByPermissionId(int permissionId) {
        TbAdminPermissionRelationExample example = new TbAdminPermissionRelationExample();
        example.createCriteria()
                .andPermissionIdEqualTo(permissionId);
        return adminPermissionRelationMapper.selectByExample(example);
    }
}
