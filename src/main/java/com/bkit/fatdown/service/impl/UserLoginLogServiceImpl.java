package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.mappers.TbUserLoginLogMapper;
import com.bkit.fatdown.service.IUserLoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @file: UserLoginLogServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 用户日志实现类
 * @date: Created in 2019/10/21 21:24
 * @modified:
 * @version: 1.0
 */
@Service
public class UserLoginLogServiceImpl implements IUserLoginLogService {

    @Resource
    private TbUserLoginLogMapper logMapper;

    /**
     * 删除日志
     *
     * @param id 日志编号
     * @return 是否成功
     */
    @Override
    public boolean delete(long id) {
        return logMapper.deleteByPrimaryKey(id) > 0;
    }


    /**
     * 查找日志数
     *
     * @param id 日志编号
     * @return 日志数
     */
    @Override
    public int count(long id) {
        return 0;
    }
}
