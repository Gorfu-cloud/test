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

    /**
     * @Description: 创建隐私信息记录
     * @Param: privacyInfo
     * @return: boolean
     * @Author: YuJian
     * @date: 2019/7/9
     */

    boolean insert(TbUserPrivacyInfo privacyInfo);

    /**
     * @Description: 删除隐私信息记录
     * @Param: UID
     * @return: boolean
     * @Author: YuJian
     * @date: 2019/7/9
     */

    boolean delete(int id);

    /**
     * @Description: 更新用户隐私信息
     * @Param:
     * @return:
     * @Author: YuJian
     * @date: 2019/7/9
     */

    boolean update(TbUserPrivacyInfo privacyInfo);

    List<TbUserPrivacyInfo> findAllByUID(int UID);

    List<TbUserPrivacyInfo> findBetweenDate(int UID, Date starDate, Date endDate);

    TbUserPrivacyInfo findByUID(int UID);
}
