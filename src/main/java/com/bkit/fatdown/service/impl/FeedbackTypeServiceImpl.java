package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbFeedbackType;
import com.bkit.fatdown.entity.TbFeedbackTypeExample;
import com.bkit.fatdown.mappers.TbFeedbackTypeMapper;
import com.bkit.fatdown.service.IFeedbackTypeService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: FeedbackTypeServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 反馈类型功能实现类
 * @date: Created in 8/13/19  10:10 PM
 * @modified:
 * @version: 1.0
 */
@Service
public class FeedbackTypeServiceImpl implements IFeedbackTypeService {

    @Resource
    private TbFeedbackTypeMapper typeMapper;

    /**
     * @param feedbackType 反馈类型
     * @return 是否成功
     */
    @Override
    public boolean insert(TbFeedbackType feedbackType) {
        if (feedbackType.getGmtCreate() == null) {
            feedbackType.setGmtCreate(new Date());
        }

        feedbackType.setGmtModified(new Date());
        return typeMapper.insertSelective(feedbackType) > 0;
    }

    /**
     * @param feedbackType 反馈类型
     * @return 是否成功
     */
    @Override
    public boolean update(TbFeedbackType feedbackType) {
        feedbackType.setGmtModified(new Date());
        return typeMapper.updateByPrimaryKeySelective(feedbackType) > 0;
    }

    /**
     * @param typeId 类型id
     * @return 是否成功
     */
    @Override
    public boolean delete(int typeId) {
        return typeMapper.deleteByPrimaryKey(typeId) > 0;
    }

    /**
     * @param typeId 反馈类型id
     * @return 是否成功
     */
    @Override
    public TbFeedbackType get(int typeId) {
        return typeMapper.selectByPrimaryKey(typeId);
    }

    /**
     * @param name
     * @param status
     * @param pageNo
     * @param pageSize
     * @return 所有类型
     */
    @Override
    public List<TbFeedbackType> listByPage(String name, Integer status, Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        TbFeedbackTypeExample example = new TbFeedbackTypeExample();
        example.setOrderByClause("total desc");
        TbFeedbackTypeExample.Criteria criteria = example.createCriteria();

        if (name != null) {
            criteria.andTypeNameLike("%" + name + "%");
        }

        if (status == 0 || status == 1) {
            criteria.andStatusEqualTo(status);
        }
        return typeMapper.selectByExample(example);
    }

    /**
     * @param pageNo
     * @param pageSize
     * @return 所有类型
     */
    @Override
    public List<TbFeedbackType> listByPage(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        TbFeedbackTypeExample example = new TbFeedbackTypeExample();
        example.setOrderByClause("total desc");
        return typeMapper.selectByExample(example);
    }

    /**
     * @return 所有类型
     */
    @Override
    public List<TbFeedbackType> list() {
        TbFeedbackTypeExample example = new TbFeedbackTypeExample();
        example.setOrderByClause("total desc");
        return typeMapper.selectByExample(example);
    }

    /**
     * @param typeName 反馈类型名称
     * @return 记录数
     */
    @Override
    public int count(String typeName) {
        TbFeedbackTypeExample example = new TbFeedbackTypeExample();
        example.createCriteria()
                .andTypeNameEqualTo(typeName);
        return (int) typeMapper.countByExample(example);
    }

    /**
     * @param typeId 类型id
     * @return 记录数
     */
    @Override
    public int count(int typeId) {
        TbFeedbackTypeExample example = new TbFeedbackTypeExample();
        example.createCriteria()
                .andIdEqualTo(typeId);
        return (int) typeMapper.countByExample(example);
    }

    /**
     * @param status 类型状态
     * @return 指定状态类型
     */
    @Override
    public List<TbFeedbackType> list(int status) {
        TbFeedbackTypeExample example = new TbFeedbackTypeExample();
        example.setOrderByClause("total desc");
        example.createCriteria()
                .andStatusEqualTo(status);
        return typeMapper.selectByExample(example);
    }

}
