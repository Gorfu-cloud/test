package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbScoreInfo;

import java.util.List;

public interface IScoreService {

    /**
     * 根据用户名查询用户积分
     *
     * @param uid
     * @return
     */
    List<TbScoreInfo> getScoreByUid(int uid);

    /**
     * 查找所有用户平均分
     *
     * @return
     */
    TbScoreInfo getAverageScore();
}
