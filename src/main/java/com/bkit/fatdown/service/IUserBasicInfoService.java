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

    boolean insertUserBasicInfo(TbUserBasicInfo userBasicInfo);

    boolean updateUserBasicInfo(TbUserBasicInfo userBasicInfo);

    boolean checkUser(String openid);

    TbUserBasicInfo findUserBasicInfoByOpenid(String openid);

    TbUserBasicInfo findUserBasicInfoById(int id);

    boolean deleteUserById(int id);

    List<TbUserBasicInfo> findAllByType(int type);

    List<TbUserBasicInfo> findAllByUserlevel(int userLevel);

    List<TbUserBasicInfo> findAllByTruename(String trueName);

    List<TbUserBasicInfo> findAllByPhone(String phone);

//  这里准备实现分页  List<TbUserBasicInfo> findAll();

}
