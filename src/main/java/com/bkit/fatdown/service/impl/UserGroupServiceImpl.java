package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.dto.group.GroupParam;
import com.bkit.fatdown.entity.TbUserGroup;
import com.bkit.fatdown.entity.TbUserGroupExample;
import com.bkit.fatdown.mappers.TbUserGroupMapper;
import com.bkit.fatdown.service.IUserGroupService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: UserGroupServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 分组功能接口实现类
 * @date: Created in 10/12/19  7:50 PM
 * @modified:
 * @version: 1.0
 */

@Service
public class UserGroupServiceImpl implements IUserGroupService {

    @Resource
    private TbUserGroupMapper groupMapper;

    /**
     * 增加
     *
     * @param param 参数
     * @return 结果
     */
    @Override
    public boolean insert(GroupParam param) {
        TbUserGroup group = new TbUserGroup();
        BeanUtils.copyProperties(param, group);

        group.setGmtCreate(new Date());
        group.setGmtModified(new Date());

        return groupMapper.insertSelective(group) > 0;
    }

    /**
     * 编辑
     *
     * @param id    编号
     * @param param 参数
     * @return 结果
     */
    @Override
    public boolean update(Integer id, GroupParam param) {
        TbUserGroup group = new TbUserGroup();
        BeanUtils.copyProperties(param, group);

        group.setId(id);
        group.setGmtModified(new Date());
        return groupMapper.updateByPrimaryKeySelective(group) > 0;
    }

    /**
     * 删除
     *
     * @param id 编号
     * @return 结果
     */
    @Override
    public boolean delete(Integer id) {
        return groupMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 获取
     *
     * @param id 编号
     * @return 分组信息
     */
    @Override
    public TbUserGroup get(Integer id) {
        return groupMapper.selectByPrimaryKey(id);
    }

    /**
     * 查找
     *
     * @param keyWord  关键词
     * @param pageNum  页号
     * @param pageSize 页记录条数
     * @return 分组信息列表
     */
    @Override
    public List<TbUserGroup> list(String keyWord, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        TbUserGroupExample example = new TbUserGroupExample();

        if (keyWord != null) {
            example.createCriteria()
                    .andNameLike("%" + keyWord + "%");
        }

        return groupMapper.selectByExample(example);
    }

    /**
     * 获取
     *
     * @param id 编号
     * @return 记录数
     */
    @Override
    public int count(Integer id) {
        TbUserGroupExample example = new TbUserGroupExample();
        example.createCriteria()
                .andIdEqualTo(id);
        return (int) groupMapper.countByExample(example);
    }

    /**
     * 设置管理员
     *
     * @param adminId 管理员编号
     * @param list    分组编号列表
     * @return 记录数
     */
    @Override
    public int updateAdmin(Integer adminId, List<Integer> list) {
        TbUserGroup group = new TbUserGroup();
        group.setGmtModified(new Date());
        group.setAdminId(adminId);

        TbUserGroupExample example = new TbUserGroupExample();
        example.createCriteria()
                .andIdIn(list);

        return groupMapper.updateByExampleSelective(group, example);
    }

    /**
     * 设置状态
     *
     * @param status 状态: 0 关, 1开
     * @param list   分组编号
     * @return 记录数
     */
    @Override
    public int updateStatus(Integer status, List<Integer> list) {
        TbUserGroup group = new TbUserGroup();
        group.setGmtModified(new Date());
        group.setStatus(status);

        TbUserGroupExample example = new TbUserGroupExample();
        example.createCriteria()
                .andIdIn(list);

        return groupMapper.updateByExampleSelective(group, example);
    }
}
