package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.dto.power.PermissionNode;
import com.bkit.fatdown.dto.power.PermissionParam;
import com.bkit.fatdown.entity.TbPermission;
import com.bkit.fatdown.entity.TbPermissionExample;
import com.bkit.fatdown.mappers.TbPermissionMapper;
import com.bkit.fatdown.service.IAdminPermissionService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @file: AdminPermissionRelationServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 管理员权限功能实现类
 * @date: Created in 2019/8/27 11:53
 * @modified:
 * @version: 1.0
 */
@Service
public class AdminPermissionServiceImpl implements IAdminPermissionService {

    @Resource
    private TbPermissionMapper permissionMapper;

    /**
     * 添加权限
     *
     * @param param 权限
     * @return 成功记录数
     */
    @Override
    public int insert(PermissionParam param) {
        TbPermission permission = new TbPermission();
        BeanUtils.copyProperties(param, permission);
        permission.setGmtCreate(new Date());
        permission.setGmtModified(new Date());
        return permissionMapper.insertSelective(permission);
    }

    /**
     * 修改权限
     *
     * @param id    权限id
     * @param param 权限关系
     * @return 成功记录数
     */
    @Override
    public int update(Integer id, PermissionParam param) {
        TbPermission permission = new TbPermission();
        BeanUtils.copyProperties(param, permission);
        permission.setId(id);
        permission.setGmtModified(new Date());
        return permissionMapper.updateByPrimaryKeySelective(permission);
    }

    /**
     * 批量删除权限
     *
     * @param ids ids 权限列表
     * @return 成功记录数
     */
    @Override
    public int delete(List<Integer> ids) {
        TbPermissionExample example = new TbPermissionExample();
        example.createCriteria()
                .andIdIn(ids);

        return permissionMapper.deleteByExample(example);
    }

    /**
     * 以层级结构返回所有权限
     *
     * @return 以层级结构返回所有权限
     */
    @Override
    public List<PermissionNode> treeList() {
        List<TbPermission> permissionList = permissionMapper.selectByExample(new TbPermissionExample());
        return permissionList.stream()
                // 筛选父权限为0的根节点
                .filter(permission -> permission.getPid().equals(0))
                .map(permission -> covert(permission, permissionList)).collect(Collectors.toList());
    }

    /**
     * 获取所有权限
     *
     * @return 获取权限
     */
    @Override
    public List<TbPermission> list() {
        return permissionMapper.selectByExample(new TbPermissionExample());
    }

    /**
     * 将权限转换为带有子级的权限对象
     * 当找不到子级权限的时候map操作不会再递归调用 covert
     */
    private PermissionNode covert(TbPermission permission, List<TbPermission> permissionList) {
        PermissionNode node = new PermissionNode();
        BeanUtils.copyProperties(permission, node);
        List<PermissionNode> children = permissionList.stream()
                .filter(subPermission -> subPermission.getPid().equals(permission.getId()))
                .map(subPermission -> covert(subPermission, permissionList)).collect(Collectors.toList());
        node.setChildren(children);
        return node;
    }

    /**
     * 获取所有权限
     *
     * @param keyWord  关键词
     * @param type     类型：
     * @param status   状态
     * @param pageNum  页号
     * @param pageSize 页大小
     * @return 查找结果
     */
    @Override
    public List<TbPermission> list(String keyWord, int type, int status, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        TbPermissionExample example = new TbPermissionExample();
        TbPermissionExample.Criteria criteria = example.createCriteria();

        if (status != -1) {
            criteria.andStatusEqualTo(status);
        }

        if (keyWord != null) {
            criteria.andNameLike("%" + keyWord + "%");
        }

        if (type != -1) {
            criteria.andTypeEqualTo(type);
        }
        return permissionMapper.selectByExample(example);
    }

    /**
     * 通过类型获取父权限，
     *
     * @param type 权限类型
     * @return 父权限列表
     */
    @Override
    public List<TbPermission> list(Integer type) {

        // 顶级权限,无父权限，父权限为0
        if (type == 0){
            List<TbPermission> list = new ArrayList<>();

            TbPermission permission = new TbPermission();
            permission.setName("无父权权限");
            permission.setId(0);

            list.add(permission);
            return list;
        }

        // 查找父权限
        Integer pType = type -1;
        TbPermissionExample example = new TbPermissionExample();
        example.createCriteria()
                .andTypeEqualTo(pType);

        return permissionMapper.selectByExample(example);
    }
}
