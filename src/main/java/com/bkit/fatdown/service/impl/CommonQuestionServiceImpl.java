package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbCommonQuestion;
import com.bkit.fatdown.entity.TbCommonQuestionExample;
import com.bkit.fatdown.mappers.TbCommonQuestionMapper;
import com.bkit.fatdown.service.ICommonQuestionService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: CommonQuestionService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 常见问题功能实现类
 * @date: Created in 8/13/19  3:45 PM
 * @modified:
 * @version: 1.0
 */
@Service
public class CommonQuestionServiceImpl implements ICommonQuestionService {

    @Resource
    private TbCommonQuestionMapper commonQuestionMapper;

    /**
     * @param commonQuestion 常见问题
     * @return 是否成功
     */
    @Override
    public boolean insert(TbCommonQuestion commonQuestion) {
        if (commonQuestion.getGmtCreate() == null) {
            commonQuestion.setGmtCreate(new Date());
        }
        commonQuestion.setGmtModified(new Date());

        return commonQuestionMapper.insertSelective(commonQuestion) > 0;
    }

    /**
     * @param commonQuestion 常见问题
     * @return 是否成功
     */
    @Override
    public boolean update(TbCommonQuestion commonQuestion) {
        commonQuestion.setGmtModified(new Date());
        return commonQuestionMapper.updateByPrimaryKeySelective(commonQuestion) > 0;
    }

    /**
     * @param id 问题id
     * @return 是否成功
     */
    @Override
    public boolean delete(int id) {
        return commonQuestionMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * @param id 问题id
     * @return 常见问题信息
     */
    @Override
    public TbCommonQuestion getCommonQuestion(int id) {
        return commonQuestionMapper.selectByPrimaryKey(id);
    }

    /**
     * @return 所有问题类型
     */
    @Override
    public List<TbCommonQuestion> listCommonQuestion() {
        TbCommonQuestionExample example = new TbCommonQuestionExample();
        example.setOrderByClause("views_total desc");
        return commonQuestionMapper.selectByExample(example);
    }

    @Override
    public List<TbCommonQuestion> listCommonQuestion(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return commonQuestionMapper.selectByExample(new TbCommonQuestionExample());
    }

    @Override
    public List<TbCommonQuestion> listCommonQuestion(String title, Integer pageNum, Integer pageSize, int status) {
        PageHelper.startPage(pageNum, pageSize);
        TbCommonQuestionExample example = new TbCommonQuestionExample();
        example.setOrderByClause("views_total desc");
        TbCommonQuestionExample.Criteria criteria = example.createCriteria();
        if (status != -1) {
            criteria.andStatusEqualTo(status);
        }
        if (title != null) {
            criteria.andTitleLike("%" + title + "%");
        }

        return commonQuestionMapper.selectByExample(example);
    }

    @Override
    public List<TbCommonQuestion> listCommonQuestion(Integer pageNum, Integer pageSize, int status) {
        PageHelper.startPage(pageNum, pageSize);
        TbCommonQuestionExample example = new TbCommonQuestionExample();
        example.setOrderByClause("views_total desc");
        if (status != -1) {
            example.createCriteria()
                    .andStatusEqualTo(status);
        }

        return commonQuestionMapper.selectByExample(example);
    }

    /**
     * @param status 开启状态：0 不开启， 1开启
     * @return 参加问题列表
     */
    @Override
    public List<TbCommonQuestion> listCommonQuestion(int status) {
        TbCommonQuestionExample example = new TbCommonQuestionExample();
        example.setOrderByClause("views_total desc");
        example.createCriteria()
                .andStatusEqualTo(status);

        return commonQuestionMapper.selectByExample(example);
    }

    /**
     * @param id 记录编码
     * @return 记录数
     */
    @Override
    public int countCommonQuestion(int id) {
        TbCommonQuestionExample example = new TbCommonQuestionExample();
        example.createCriteria()
                .andIdEqualTo(id);
        return (int) commonQuestionMapper.countByExample(example);
    }

    /**
     * @param name 类型名称
     * @return 记录数
     */
    @Override
    public int countCommonQuestion(String name) {
        TbCommonQuestionExample example = new TbCommonQuestionExample();
        example.createCriteria()
                .andTitleEqualTo(name);
        return (int) commonQuestionMapper.countByExample(example);
    }
}
