package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbPictureType;

import java.util.List;

/**
 * @file: IPictureTypeService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 图片类型功能接口
 * @date: Created in 8/31/19  3:42 PM
 * @modified:
 * @version: 1.0
 */

public interface IPictureTypeService {

    boolean insert(TbPictureType type);

    boolean delete(int id);

    boolean update(TbPictureType type);

    TbPictureType get(int id);

    List<TbPictureType> list(Integer status,Integer pageNum,Integer pageSize);

    Integer search(String typeName);

    Integer count(String typeName);

    Integer count(Integer typeId);
}
