package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbAdmin;
import com.bkit.fatdown.entity.TbAdminExample;
import com.bkit.fatdown.mappers.TbAdminMapper;
import com.bkit.fatdown.service.IAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @file: AdminServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 管理员功能接口实现类
 * @date: Created in 8/17/19  3:30 PM
 * @modified:
 * @version: 1.0
 */
@Service
public class AdminServiceImpl implements IAdminService {

    @Resource
    private TbAdminMapper adminMapper;

    /**
     * @param admin 管理员
     * @return 是否成功
     */
    @Override
    public boolean insert(TbAdmin admin) {
        if (admin.getGmtCreate() == null) {
            admin.setGmtCreate(new Date());
        }
        admin.setGmtModified(new Date());
        return adminMapper.insertSelective(admin) > 0;
    }

    /**
     * @param admin 管理员
     * @return 是否成功
     */
    @Override
    public boolean update(TbAdmin admin) {
        admin.setGmtModified(new Date());
        return adminMapper.updateByPrimaryKeySelective(admin) > 0;
    }

    /**
     * @param id id
     * @return 是否成功
     */
    @Override
    public TbAdmin get(int id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    /**
     * @param id id
     * @return 是否成功
     */
    @Override
    public boolean delete(int id) {
        return adminMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * @param id id
     * @return 记录数
     */
    @Override
    public int count(int id) {
        TbAdminExample example = new TbAdminExample();
        example.createCriteria()
                .andIdEqualTo(id);
        return (int) adminMapper.countByExample(example);
    }

    /**
     * @param name     名称
     * @param password 密码
     * @return 记录数
     */
    @Override
    public int count(String name, String password) {
        TbAdminExample example = new TbAdminExample();
        example.createCriteria()
                .andUserNameEqualTo(name)
                .andPasswordEqualTo(password);
        return (int) adminMapper.countByExample(example);
    }

    /**
     * @param userName 账号名称
     * @param password 密码
     * @param status   状态
     * @return
     */
    @Override
    public int count(String userName, String password, Integer status) {
        TbAdminExample example = new TbAdminExample();
        example.createCriteria()
                .andUserNameEqualTo(userName)
                .andPasswordEqualTo(password)
                .andStatusEqualTo(status);
        return (int) adminMapper.countByExample(example);
    }
}
