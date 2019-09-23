package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbUserLifeStyle;

import java.util.Date;
import java.util.List;

/**
 * @FileName: IUserLifeStyleService
 * @Author: YuJian
 * @Description: 用户口味倾向功能接口
 * @Date: Created in 2019/7/9 18:08
 * @Modified:
 * @Version: 1.0
 */

public interface IUserLifeStyleService {

    boolean insert(TbUserLifeStyle userLifeStyle);

    List<TbUserLifeStyle> listByUid(int uid);

   TbUserLifeStyle getNewByUid(int uid);

    TbUserLifeStyle getById(int id);

    boolean delete(int id);

    int countByUid(int uid);

    boolean update(TbUserLifeStyle userLifeStyle);

    List<TbUserLifeStyle> list(int uid,Integer pageSize,Integer pageNum);

    /**
     * 根据日期和uid查找是否存在隐私记录
     *
     * @param uid
     * @param date
     * @return
     */
    int countByUidAndCreateDate(int uid, Date date);
}
