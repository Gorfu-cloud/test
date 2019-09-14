package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.mappers.TbAdminMapper;
import com.bkit.fatdown.mappers.TbAdminPermissionRelationMapper;
import com.bkit.fatdown.mappers.TbAdminRoleRelationMapper;
import com.bkit.fatdown.mappers.dao.AdminPermissionRelationDao;
import com.bkit.fatdown.mappers.dao.AdminRoleRelationDao;
import com.bkit.fatdown.service.IAdminService;
import com.bkit.fatdown.common.power.JwtTokenUtil;
import jdk.nashorn.internal.ir.annotations.Reference;
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
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
    @Resource
    private TbAdminRoleRelationMapper adminRoleRelationMapper;
    @Resource
    private TbAdminPermissionRelationMapper permissionRelationMapper;
    @Reference
    private AdminPermissionRelationDao adminPermissionRelationDao;

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
     * 刷新token的功能
     *
     * @param oldToken 旧的token
     */
    @Override
    public String refreshToken(String oldToken) {
        String token = oldToken.substring(tokenHead.length());
        if (jwtTokenUtil.canRefresh(token)) {
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }

    /**
     * 修改用户角色关系
     *
     * @param adminId    管理id
     * @param roleIdList 角色id列表
     * @return
     */
    @Override
    public int updateRole(Integer adminId, List<Integer> roleIdList) {
        int count = roleIdList == null ? 0 : roleIdList.size();
        //先删除原来的关系
        TbAdminRoleRelationExample adminRoleRelationExample = new TbAdminRoleRelationExample();
        adminRoleRelationExample.createCriteria().andAdminIdEqualTo(adminId);
        adminRoleRelationMapper.deleteByExample(adminRoleRelationExample);
        //建立新关系
        if (!CollectionUtils.isEmpty(roleIdList)) {
            List<TbAdminRoleRelation> list = new ArrayList<>();
            for (Integer roleId : roleIdList) {
                TbAdminRoleRelation roleRelation = new TbAdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setAdminRoleId(roleId);
                list.add(roleRelation);
            }
            adminRoleRelationDao.insertList(list);
        }
        return count;
    }

    /**
     * 获取用户对应角色
     *
     * @param adminId 用户id
     * @return
     */
    @Override
    public List<TbRole> listRoleList(Integer adminId) {
        return adminRoleRelationDao.getRoleList(adminId);
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

    /**
     * 将+-权限关系转化为对象
     */
    private List<TbAdminPermissionRelation> convert(Integer adminId,Integer type,List<Integer> permissionIdList) {
        return permissionIdList.stream().map(permissionId -> {
            TbAdminPermissionRelation relation = new TbAdminPermissionRelation();
            relation.setAdminId(adminId);
            relation.setType(type);
            relation.setPermissionId(permissionId);
            return relation;
        }).collect(Collectors.toList());
    }

    /**
     * 修改用户的+-权限
     *
     * @param adminId          用户id
     * @param permissionIdList 权限列表
     * @return
     */
    @Override
    public int updatePermission(Integer adminId, List<Integer> permissionIdList) {
        //删除原所有权限关系
        TbAdminPermissionRelationExample relationExample = new TbAdminPermissionRelationExample();
        relationExample.createCriteria().andAdminIdEqualTo(adminId);
        permissionRelationMapper.deleteByExample(relationExample);
        //获取用户所有角色权限
        List<TbPermission> permissionList = adminRoleRelationDao.getRolePermissionList(adminId);
        List<Integer> rolePermissionList = permissionList.stream().map(TbPermission::getId).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(permissionIdList)) {
            List<TbAdminPermissionRelation> relationList = new ArrayList<>();
            //筛选出+权限
            List<Integer> addPermissionIdList = permissionIdList.stream().filter(permissionId -> !rolePermissionList.contains(permissionId)).collect(Collectors.toList());
            //筛选出-权限
            List<Integer> subPermissionIdList = rolePermissionList.stream().filter(permissionId -> !permissionIdList.contains(permissionId)).collect(Collectors.toList());
            //插入+-权限关系
            relationList.addAll(convert(adminId,1,addPermissionIdList));
            relationList.addAll(convert(adminId,-1,subPermissionIdList));
            return adminPermissionRelationDao.insertList(relationList);
        }
        return 0;
    }
}
