package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbUserBasicInfo;

import java.util.List;

/**
 * @FileName: IUserBasicInfoService
 * @Author: YuJian
 * @Description: 用户基础信息功能接口
 * @Date: Created in 2019/7/9 14:24
 * @Modified:
 * @Version: 1.0
 */

public interface IUserBasicInfoService {
    /**
     * 创建新用户
     *
     * @param userBasicInfo
     * @return
     */
    boolean insert(TbUserBasicInfo userBasicInfo);

    /**
     * 更新用户信息
     *
     * @param userBasicInfo
     * @return
     */
    boolean update(TbUserBasicInfo userBasicInfo);

    /**
     * 查找用户存在数
     *
     * @param openId
     * @return
     */
    int countByOpenId(String openId);

    /**
     * 查看用户是否存在
     *
     * @param id
     * @return
     */
    int countById(int id);

    /**
     * 用户登陆
     *
     * @param code
     * @return
     */
    TbUserBasicInfo login(String code);

    /**
     * 获取openid对应的用户信息
     *
     * @param openId
     * @return
     */
    TbUserBasicInfo getByOpenId(String openId);

    /**
     * 通过用户id，获取用户信息
     *
     * @param id
     * @return
     */
    TbUserBasicInfo getById(int id);

    /**
     * 通过用户id，删除用户
     *
     * @param id
     * @return
     */
    boolean deleteUserById(int id);

    /**
     * 通过用户类型查找用户
     *
     * @param type
     * @return
     */
    List<TbUserBasicInfo> listByType(int type);

    /**
     * 通过用户名查找用户
     *
     * @param trueName
     * @return
     */
    List<TbUserBasicInfo> listByTrueName(String trueName);

    /**
     * 通过用户手机查找用户
     *
     * @param phone
     * @return
     */
    List<TbUserBasicInfo> listByPhone(String phone);

    /**
     * 分页查找用户
     *
     * @return
     */
    List<TbUserBasicInfo> listAll(Integer pageSize, Integer pageNum);

    List<TbUserBasicInfo> listByUserLever(Integer userLever, Integer pageSize, Integer pageNum);

}
