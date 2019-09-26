package com.bkit.fatdown.service;

import com.bkit.fatdown.dto.RedeemCodeDTO;
import com.bkit.fatdown.entity.TbRedeemCode;

import java.util.List;

/**
 * @file: IRedeemCodeService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 兑换码
 * @date: Created in 2019/9/25 15:27
 * @modified:
 * @version: 1.0
 */

public interface IRedeemCodeService {
    /**
     * 创建
     *
     * @param params 创建
     * @return 是否成功
     */
    boolean insert(RedeemCodeDTO params);

    /**
     * 删除
     *
     * @param id 编号
     * @return 是否成功
     */
    boolean delete(Long id);

    /**
     * 更新
     *
     * @param id     编号
     * @param params 兑换码
     * @return 是否成功
     */
    boolean update(Long id, RedeemCodeDTO params);

    /**
     * 获取信息
     *
     * @param id 测试码编号
     * @return 测试码信息
     */
    TbRedeemCode get(Long id);

    /**
     * 获取测试码信息
     *
     * @param code 测试码
     * @return 测试码信息
     */
    TbRedeemCode get(String code);

    /**
     * 获取存在数目
     *
     * @param code 兑换码
     * @return 是否成功
     */
    boolean count(String code);

    /**
     * 判断是否存在
     *
     * @param id 编号
     * @return 是否存在
     */
    boolean count(long id);

    /**
     * 核查存在?
     *
     * @param code 兑换码
     * @return 是否成功
     */
    boolean check(String code);

    /**
     * 分页 查看兑换码
     *
     * @param keyword     类型
     * @param pageNum  分页
     * @param pageSize 页数
     * @return 列表
     */
    List<TbRedeemCode> list(String keyword, Integer status,Integer pageNum, Integer pageSize);

    /**
     * 批量更新状态
     *
     * @param idList 列表
     * @param status 状态
     * @return 修改记录数
     */
    int updateStatus(List<Long> idList, Integer status);


    /**
     * 批量删除
     *
     * @param idList 列表
     * @return 删除记录数
     */
    int delete(List<Long> idList);
}
