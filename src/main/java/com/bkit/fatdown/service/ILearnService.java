package com.bkit.fatdown.service;


import com.bkit.fatdown.entity.TbLearnInfo;

import java.util.Date;
import java.util.List;

/**
 * @file: ILearnService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 学习服务接口
 * @date: Created in 2019/7/11  11:05
 * @modified:
 * @version: 1.0
 */

public interface ILearnService {

    /**
     * 通过日期获取已启用的试卷
     *
     * @param nowDate
     * @return
     */
    List<TbLearnInfo> listByDate(Date nowDate);

    /**
     * 获取所有学习内容
     *
     * @return
     */
    List<TbLearnInfo> listAll();

    /**
     * 创建学习知识信息
     *
     * @return
     */
    boolean insert();

    /**
     * 删除学习知识信息
     *
     * @param id
     * @return
     */
    boolean deleteById(int id);

    /**
     * 更新学习知识内容
     *
     * @return
     */
    boolean update(TbLearnInfo learnInfo);

    /**
     * 通过id获取对应的学习内容
     *
     * @param id
     * @return
     */
    TbLearnInfo getById(int id);
}
