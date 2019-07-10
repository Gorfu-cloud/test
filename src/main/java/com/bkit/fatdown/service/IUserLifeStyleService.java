package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbUserLifeStyle;

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

    TbUserLifeStyle getByUid(int uid);

    TbUserLifeStyle getById(int id);

    boolean delete(int id);
}
