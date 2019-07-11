package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbScoreInfo;

import java.util.List;

/**
 * @file: IRankService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:  排名功能接口
 * @date: Created in 2019/7/11  11:04
 * @modified:
 * @version: 1.0
 */

public interface IRankService {

    /**
     * 查询饮食得分前十名
     *
     * @param type
     * @return
     */
    List<TbScoreInfo> getTopTen(String type);

    /**
     * 添加积分记录
     *
     * @param score
     * @return
     */
    Boolean insertScore(TbScoreInfo score);

    /**
     * 根据用户ID获取用户名
     *
     * @param UID
     * @return
     */
    String getUserNameByUID(int UID);

    /**
     * 根据排名获取用户积分记录
     *
     * @param rank
     * @param type
     * @return
     */
    TbScoreInfo getScoreByRank(int rank, String type);

    /**
     * 根据UID获取用户积分记录
     *
     * @param uid
     * @return
     */
    TbScoreInfo getScoreByUid(int uid);
}
