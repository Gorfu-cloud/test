package com.bkit.fatdown.service;

import com.bkit.fatdown.dto.power.AdminParam;
import com.bkit.fatdown.entity.TbAdmin;
import com.bkit.fatdown.entity.TbPermission;
import com.bkit.fatdown.entity.TbRole;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @file: IAdminService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 管理员服务接口
 * @date: Created in 8/17/19  3:05 PM
 * @modified:
 * @version: 1.0
 */

public interface IAdminService {
    /**
     * 根据用户名获取后台管理员
     * @param username 用户名
     * @return 管理员信息
     */
    TbAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     *
     * @return 用户信息
     */
    TbAdmin register(AdminParam adminParam);

    /**
     * 登录功能
     *
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 刷新token
     * @param oldToken 原来的token
     * @return 新token
     */
    String refreshToken(String oldToken);

    /**
     * 获取用户信息
     * @param id id
     * @return 是否成功
     */
    TbAdmin get(int id);

    /**
     * 根据用户名或昵称分页查询用户
     * @param name 用户名称
     * @param pageSize 页数
     * @param pageNum 页号
     */
    List<TbAdmin> list(String name, Integer status, Integer pageSize, Integer pageNum);

    /**
     * 更新信息
     * @param id    管理员编号
     * @param admin 管理员
     * @return 是否成功
     */
    int update(Integer id, AdminParam admin);

    /**
     * 更新密码
     * @param id 用户id
     * @param password 用户密码
     * @return 结构
     */
    boolean updatePassword(Integer id,String password);

    /**
     * 删除用户
     * @param id id
     * @return 是否成功
     */
    int delete(int id);

    /**
     * 统计用户
     * @param id id
     * @return 用户个数
     */
    int count(int id);

    /**
     * 修改用户角色关系
     *
     * @param adminId    管理id
     * @param roleIdList 角色id列表
     * @return 成功记录
     */
    @Transactional
    int updateRole(Integer adminId, List<Integer> roleIdList);

    /**
     * 获取用户对应角色
     *
     * @param adminId 用户id
     * @return 成功记录
     */
    List<TbRole> getRoleList(Integer adminId);

    /**
     * 修改用户的+-权限
     *
     * @param adminId          用户id
     * @param permissionIdList 权限列表
     * @return 成功记录
     */
    @Transactional
    int updatePermission(Integer adminId, List<Integer> permissionIdList);


    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     * @param adminId 管理员编号
     * @return 权限列表
     */
    List<TbPermission> getPermissionList(Integer adminId);

    /**
     * 更新状态
     * @param ids 编号列表
     * @param status 状态码
     * @return 结果数
     */
    int updateStatus(List<Integer> ids,Integer status);

    /**
     * 设置一组用户角色
     * @param adminIdList 用户列表
     * @param roleIdList 角色列表
     * @return 成功次数
     */
    int updateRole(List<Integer> adminIdList,List<Integer> roleIdList);
}
