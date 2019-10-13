package com.bkit.fatdown.service;

import com.bkit.fatdown.dto.group.GroupParam;
import com.bkit.fatdown.entity.TbUserGroup;

import java.util.List;

/**
 * @file: IGroupService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 分组功能接口
 * @date: Created in 10/12/19  7:21 PM
 * @modified:
 * @version: 1.0
 */

public interface IUserGroupService {
    /**
     * 增加
     *
     * @param param 参数
     * @return 结果
     */
    boolean insert(GroupParam param);

    /**
     * 编辑
     *
     * @param id    编号
     * @param param 参数
     * @return 结果
     */
    boolean update(Integer id, GroupParam param);

    /**
     * 删除
     *
     * @param id 编号
     * @return 结果
     */
    boolean delete(Integer id);

    /**
     * 获取
     *
     * @param id 编号
     * @return 分组信息
     */
    TbUserGroup get(Integer id);

    /**
     * 查找
     *
     * @param keyWord  关键词
     * @param status 状态: -1 全部, 0 关闭, 1 开启
     * @param pageNum  页号
     * @param pageSize 页记录条数
     * @return 分组信息列表
     */
    List<TbUserGroup> list(String keyWord, Integer status, Integer pageNum, Integer pageSize);

    /**
     * 获取
     *
     * @param id 编号
     * @return 记录数
     */
    int count(Integer id);

    /**
     * 设置管理员
     *
     * @param adminId 管理员编号
     * @param list    分组编号列表
     * @return 记录数
     */
    int updateAdmin(Integer adminId, List<Integer> list);

    /**
     * 设置状态
     *
     * @param status 状态: 0 关, 1开
     * @param list   分组编号
     * @return 记录数
     */
    int updateStatus(Integer status, List<Integer> list);
}
