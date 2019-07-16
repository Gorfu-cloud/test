package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbUserPrivacyInfo;

import java.util.Date;
import java.util.List;

/**
 * @FileName: IUserPrivacyInfoService
 * @Author: YuJian
 * @Description: 用户隐私信息功能接口
 * @Date: Created in 2019/7/9 14:07
 * @Modified:
 * @Version: 1.0
 */

public interface IUserPrivacyInfoService {

    boolean insert(TbUserPrivacyInfo privacyInfo);

    boolean deleteById(int id);

    boolean update(TbUserPrivacyInfo privacyInfo);

    List<TbUserPrivacyInfo> listByUid(int uid);

    List<TbUserPrivacyInfo> listBetweenDate(int uid, Date starDate, Date endDate);

    TbUserPrivacyInfo getById(int id);

    int countByUidAndDate(int uid,Date date);
}
