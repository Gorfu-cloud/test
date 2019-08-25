package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbAdmin;
import com.bkit.fatdown.entity.TbAdminExample;
import com.bkit.fatdown.mappers.TbAdminMapper;
import com.bkit.fatdown.service.IAdminService;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
public class AdminServiceImpl implements IAdminService{
//public class AdminServiceImpl implements IAdminService, UserDetailsService {

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
     * @param userName 用户名
     * @return 是否成功
     */
    @Override
    public TbAdmin get(String userName) {
        TbAdminExample example = new TbAdminExample();
        example.createCriteria()
                .andUserNameEqualTo(userName);
        return adminMapper.selectByExample(example).get(0);
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
     * @param name 名称
     * @return 记录数
     */
    @Override
    public int count(String name) {
        TbAdminExample example = new TbAdminExample();
        example.createCriteria()
                .andUserNameEqualTo(name);
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

//    /**
//     * 执行登录的过程中，这个方法将根据用户名去查找用户，
//     * 如果用户不存在，则抛出 UsernameNotFoundException 异常，
//     * 否则直接将查到的Admin返回。
//     *
//     * @param s 用户名
//     * @return 用户信息
//     * @throws UsernameNotFoundException 用户不存在
//     */
//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        if (count(s) == 0) {
//            throw new UsernameNotFoundException("用户名不存在");
//        }
//        return get(s);
//    }
}
