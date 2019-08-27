package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.mappers.TbAdminMapper;
import com.bkit.fatdown.mappers.dao.AdminRoleRelationDao;
import com.bkit.fatdown.service.IAdminService;
import com.bkit.fatdown.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminServiceImpl.class);
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private JwtTokenUtil jwtTokenUtil;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Resource
    private TbAdminMapper adminMapper;
    @Resource
    private AdminRoleRelationDao adminRoleRelationDao;

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

    /**
     * 根据用户名获取后台管理员
     *
     * @param username
     */
    @Override
    public TbAdmin getAdminByUsername(String username) {
        TbAdminExample example = new TbAdminExample();
        example.createCriteria().andUserNameEqualTo(username);
        List<TbAdmin> adminList = adminMapper.selectByExample(example);
        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }
        return null;
    }

    /**
     * 注册功能
     *
     * @param adminParam
     * @return
     */
    @Override
    public TbAdmin register(TbAdmin adminParam) {
        TbAdmin umsAdmin = new TbAdmin();
        BeanUtils.copyProperties(adminParam, umsAdmin);
        umsAdmin.setGmtCreate(new Date());
        umsAdmin.setStatus(1);

        //查询是否有相同用户名的用户
        TbAdminExample example = new TbAdminExample();
        example.createCriteria().andUserNameEqualTo(umsAdmin.getUserName());
        List<TbAdmin> umsAdminList = adminMapper.selectByExample(example);
        if (umsAdminList.size() > 0) {
            return null;
        }

        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(umsAdmin.getPassword());
        umsAdmin.setPassword(encodePassword);
        adminMapper.insert(umsAdmin);
        return umsAdmin;
    }

    /**
     * 登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
                    null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     *
     * @param adminId
     */
    @Override
    public List<TbPermission> getPermissionList(Integer adminId) {
        return adminRoleRelationDao.getPermissionList(adminId);
    }
}
