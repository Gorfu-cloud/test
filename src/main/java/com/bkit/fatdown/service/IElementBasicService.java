package com.bkit.fatdown.service;

import com.bkit.fatdown.dto.food.ElementBasicDTO;
import com.bkit.fatdown.entity.TbElementBasic;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

/**
 * @file: IElementBasicService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 菜式基础元素功能接口
 * @date: Created in 7/26/19  10:18 AM
 * @modified:
 * @version: 1.0
 */

public interface IElementBasicService {
    /**
     * 插入新元素
     *
     * @param elementBasic
     * @return
     */
    boolean insert(ElementBasicDTO elementBasic);

    /**
     * 删除新元素
     *
     * @param id
     * @return
     */
    boolean delete(int id);

    /**
     * 更新新元素
     *
     * @param elementBasic
     * @return
     */
    boolean update(Integer id, ElementBasicDTO elementBasic);

    /**
     * 获取元素对象
     *
     * @param id
     * @return
     */
    TbElementBasic getElementBasic(int id);

    /**
     * 获取元素
     *
     * @param type
     * @return
     */
    List<TbElementBasic> listElementBasic(int type);

    /**
     * @param keyword 元素关键词
     * @param type     类型
     * @param pageNum  页数
     * @param pageSize 每页数目
     * @return 成分列表
     */
    List<TbElementBasic> listByPage(String keyword, Integer type, Integer pageNum, Integer pageSize);

    /**
     * 获取元素
     *
     * @param list
     * @return
     */
    List<TbElementBasic> listElementBasicByList(List<Integer> list);
}
