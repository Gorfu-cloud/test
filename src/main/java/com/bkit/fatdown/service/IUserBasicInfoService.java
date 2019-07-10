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

    boolean insert(TbUserBasicInfo userBasicInfo);

    boolean update(TbUserBasicInfo userBasicInfo);

    int countByOpenid(String openid);

    TbUserBasicInfo register(String openid);

    TbUserBasicInfo getByOpenid(String openid);

    TbUserBasicInfo getById(int id);

    boolean deleteUserById(int id);

    List<TbUserBasicInfo> listByType(int type);

    List<TbUserBasicInfo> listByUserlevel(int userLevel);

    List<TbUserBasicInfo> listByTruename(String trueName);

    List<TbUserBasicInfo> listByPhone(String phone);

//  这里准备实现分页  List<TbUserBasicInfo> findAll();

}
