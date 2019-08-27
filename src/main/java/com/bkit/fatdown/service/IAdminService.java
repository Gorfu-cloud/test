package com.bkit.fatdown.service;

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
     * @param admin 管理员
     * @return 是否成功
     */
    boolean insert(TbAdmin admin);

    /**
     * @param admin 管理员
     * @return 是否成功
     */
    boolean update(TbAdmin admin);

    /**
     * @param id id
     * @return 是否成功
     */
    TbAdmin get(int id);

    /**
     * @param userName 用户名
     * @return 是否成功
     */
    TbAdmin get(String userName);

    /**
     * @param id id
     * @return 是否成功
     */
    boolean delete(int id);

    /**
     * @param id id
     * @return 记录数
     */
    int count(int id);

    /**
     * @param name     名称
     * @param password 密码
     * @return 记录数
     */
    int count(String name, String password);

    /**
     * @param name     名称
     * @return 记录数
     */
    int count(String name);

    /**
     * @param userName 用户名
     * @param password 密码
     * @param status   状态
     * @return
     */
    int count(String userName, String password, Integer status);

    /**
     * 根据用户名获取后台管理员
     */
    TbAdmin getAdminByUsername(String username);

    /**
     * 注册功能
     * @return
     */
    TbAdmin register(TbAdmin adminParam);

    /**
     * 登录功能
     * @param username 用户名
     * @param password 密码
     * @return 生成的JWT的token
     */
    String login(String username, String password);

    /**
     * 获取用户所有权限（包括角色权限和+-权限）
     */
    List<TbPermission> getPermissionList(Integer adminId);

    /**
     * 刷新token的功能
     * @param oldToken 旧的token
     */
    String refreshToken(String oldToken);

    /**
     * 修改用户角色关系
     * @param adminId 管理id
     * @param roleIdList 角色id列表
     * @return
     */
    @Transactional
    int updateRole(Integer adminId, List<Integer> roleIdList);

    /**
     * 获取用户对应角色
     * @param adminId 用户id
     * @return
     */
    List<TbRole> listRoleList(Integer adminId);
}
