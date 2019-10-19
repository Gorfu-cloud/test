package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.common.power.JwtTokenUtil;
import com.bkit.fatdown.dto.power.AdminParam;
import com.bkit.fatdown.entity.*;
import com.bkit.fatdown.mappers.TbAdminMapper;
import com.bkit.fatdown.mappers.TbAdminPermissionRelationMapper;
import com.bkit.fatdown.mappers.TbAdminRoleRelationMapper;
import com.bkit.fatdown.mappers.dao.AdminPermissionRelationDao;
import com.bkit.fatdown.mappers.dao.AdminRoleRelationDao;
import com.bkit.fatdown.service.IAdminService;
import com.github.pagehelper.PageHelper;
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
import org.springframework.util.StringUtils;

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
    //    @Resource
//    private AuthenticationManager authenticationManager;
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
    private TbAdminRoleRelationMapper adminRoleRelationMapper;
    @Resource
    private AdminRoleRelationDao adminRoleRelationDao;
    @Resource
    private TbAdminPermissionRelationMapper adminPermissionRelationMapper;
    @Resource
    private AdminPermissionRelationDao adminPermissionRelationDao;

    /**
     * 根据用户名获取后台管理员
     *
     * @param username 用户名
     * @return 管理员信息
     */
    @Override
    public TbAdmin getAdminByUsername(String username) {
        TbAdminExample example = new TbAdminExample();
        example.createCriteria()
                .andUserNameEqualTo(username);

        List<TbAdmin> adminList = adminMapper.selectByExample(example);

        if (adminList != null && adminList.size() > 0) {
            return adminList.get(0);
        }

        return null;
    }

    /**
     * 注册功能
     *
     * @param adminParam 用户注册信息
     * @return 用户信息
     */
    @Override
    public TbAdmin register(AdminParam adminParam) {
        TbAdmin admin = new TbAdmin();
        BeanUtils.copyProperties(adminParam, admin);
        admin.setGmtCreate(new Date());
        admin.setGmtModified(new Date());

        //查询是否有相同用户名的用户
        TbAdminExample example = new TbAdminExample();
        example.createCriteria().andUserNameEqualTo(admin.getUserName());
        List<TbAdmin> adminList = adminMapper.selectByExample(example);
        if (adminList.size() > 0) {
            return null;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(admin.getPassword());
        admin.setPassword(encodePassword);
        adminMapper.insertSelective(admin);
        return admin;
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
        //密码需要客户端加密后传递
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails,
                    null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(userDetails);
//            updateLoginTimeByUsername(username);
//            insertLoginLog(username);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    /**
     * 刷新token
     *
     * @param oldToken 原来的token
     * @return 新token
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
     * 获取用户信息
     *
     * @param id id
     * @return 是否成功
     */
    @Override
    public TbAdmin get(int id) {
        return adminMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据用户名或昵称分页查询用户
     *
     * @param name     用户名称
     * @param pageSize 页数
     * @param pageNum  页号
     */
    @Override
    public List<TbAdmin> list(String name, Integer status, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        TbAdminExample example = new TbAdminExample();
        TbAdminExample.Criteria criteria1 = example.createCriteria();
        TbAdminExample.Criteria criteria2 = example.createCriteria();
        if (status != -1) {
            criteria1.andStatusEqualTo(status);
            criteria2.andStatusEqualTo(status);
        }

        if (!StringUtils.isEmpty(name)) {
            criteria1.andUserNameLike("%" + name + "%");
            example.or(criteria2.andNickNameLike("%" + name + "%"));
        }

        return adminMapper.selectByExample(example);
    }

    /**
     * 更新密码
     *
     * @param id       用户id
     * @param password 用户密码
     * @return 结构
     */
    @Override
    public boolean updatePassword(Integer id, String password) {
        TbAdmin admin = new TbAdmin();
        admin.setId(id);
        admin.setGmtModified(new Date());

        String encodePassword = passwordEncoder.encode(password);
        admin.setPassword(encodePassword);

        return adminMapper.updateByPrimaryKeySelective(admin) > 0;
    }

    /**
     * 更新信息
     *
     * @param id    管理员编号
     * @param param 管理员
     * @return 是否成功
     */
    @Override
    public int update(Integer id, AdminParam param) {
        TbAdmin admin = new TbAdmin();
        BeanUtils.copyProperties(param, admin);
        admin.setId(id);
        admin.setGmtModified(new Date());
        //密码已经加密处理，需要单独修改
        admin.setPassword(null);
        return adminMapper.updateByPrimaryKeySelective(admin);
    }


    /**
     * 统计用户
     *
     * @param id id
     * @return 用户个数
     */
    @Override
    public int count(int id) {
        TbAdminExample example = new TbAdminExample();
        example.createCriteria()
                .andIdEqualTo(id);

        return (int) adminMapper.countByExample(example);
    }

    /**
     * 删除用户
     *
     * @param id id
     * @return 是否成功
     */
    @Override
    public int delete(int id) {
        return adminMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改用户角色关系
     *
     * @param adminId 管理id
     * @param roleIds 角色id列表
     * @return 成功记录
     */
    @Override
    public int updateRole(Integer adminId, List<Integer> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        //先删除原来的关系
        TbAdminRoleRelationExample adminRoleRelationExample = new TbAdminRoleRelationExample();
        adminRoleRelationExample.createCriteria().andAdminIdEqualTo(adminId);
        adminRoleRelationMapper.deleteByExample(adminRoleRelationExample);
        //建立新关系
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<TbAdminRoleRelation> list = new ArrayList<>();
            for (Integer roleId : roleIds) {
                TbAdminRoleRelation roleRelation = new TbAdminRoleRelation();
                roleRelation.setAdminId(adminId);
                roleRelation.setRoleId(roleId);
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
     * @return 成功记录
     */
    @Override
    public List<TbRole> getRoleList(Integer adminId) {
        return adminRoleRelationDao.getRoleList(adminId);
    }

    /**
     * 修改用户的+-权限
     *
     * @param adminId       用户id
     * @param permissionIds 权限列表
     * @return 成功记录
     */
    @Override
    public int updatePermission(Integer adminId, List<Integer> permissionIds) {

        //删除原所有权限关系
        TbAdminPermissionRelationExample relationExample = new TbAdminPermissionRelationExample();
        relationExample.createCriteria().andAdminIdEqualTo(adminId);
        adminPermissionRelationMapper.deleteByExample(relationExample);

        //获取用户所有角色权限
        List<TbPermission> permissionList = adminRoleRelationDao.getRolePermissionList(adminId);
        List<Integer> rolePermissionList = permissionList.stream()
                .map(TbPermission::getId).collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(permissionIds)) {
            List<TbAdminPermissionRelation> relationList = new ArrayList<>();
            //筛选出+权限
            List<Integer> addPermissionIdList = permissionIds.stream()
                    .filter(permissionId -> !rolePermissionList.contains(permissionId)).collect(Collectors.toList());
            //筛选出-权限
            List<Integer> subPermissionIdList = rolePermissionList.stream()
                    .filter(permissionId -> !permissionIds.contains(permissionId)).collect(Collectors.toList());
            //插入+-权限关系
            relationList.addAll(convert(adminId, 1, addPermissionIdList));
            relationList.addAll(convert(adminId, -1, subPermissionIdList));

            return adminPermissionRelationDao.insertList(relationList);
        }
        return 0;
    }

    /**
     * 通过名称获取id
     *
     * @param name 管理员名称
     * @return id
     */
    @Override
    public int getIdByAdminName(String name) {
        TbAdminExample example = new TbAdminExample();
        example.createCriteria()
                .andUserNameEqualTo(name);
        List<TbAdmin> list = adminMapper.selectByExample(example);

        if (list.isEmpty()) {
            return 0;
        } else {
            return list.get(0).getId();
        }
    }

    /**
     * 设置一组用户角色
     *
     * @param adminIdList 用户列表
     * @param roleIdList  角色列表
     * @return 成功次数
     */
    @Override
    public int updateRole(List<Integer> adminIdList, List<Integer> roleIdList) {
        int count = 0;
        if (adminIdList.isEmpty()) {
            return count;
        }

        for (Integer adminId : adminIdList) {
            count += updateRole(adminId, roleIdList);
        }
        return count;
    }

    /**
     * 更新状态
     *
     * @param ids    编号列表
     * @param status 状态码
     * @return 结果数
     */
    @Override
    public int updateStatus(List<Integer> ids, Integer status) {
        TbAdmin admin = new TbAdmin();
        admin.setStatus(status);

        TbAdminExample example = new TbAdminExample();
        example.createCriteria()
                .andIdIn(ids);

        return adminMapper.updateByExampleSelective(admin, example);
    }

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     *
     * @param adminId 管理员编号
     * @return 权限列表
     */
    @Override
    public List<TbPermission> getPermissionList(Integer adminId) {
        return adminRoleRelationDao.getPermissionList(adminId);
    }

    /**
     * 将+-权限关系转化为对象
     */
    private List<TbAdminPermissionRelation> convert(Integer adminId, Integer type, List<Integer> permissionIdList) {
        return permissionIdList.stream().map(permissionId -> {
            TbAdminPermissionRelation relation = new TbAdminPermissionRelation();
            relation.setAdminId(adminId);
            relation.setType(type);
            relation.setPermissionId(permissionId);
            return relation;
        }).collect(Collectors.toList());
    }
}
