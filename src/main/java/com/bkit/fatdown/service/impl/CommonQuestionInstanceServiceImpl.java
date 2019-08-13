package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbCommonQuestion;
import com.bkit.fatdown.entity.TbCommonQuestionInstance;
import com.bkit.fatdown.entity.TbCommonQuestionInstanceExample;
import com.bkit.fatdown.mappers.TbCommonQuestionInstanceMapper;
import com.bkit.fatdown.service.ICommonQuestionInstanceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: CommonQuestionInstanceServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 常见问题功能实现类
 * @date: Created in 8/13/19  3:51 PM
 * @modified:
 * @version: 1.0
 */
@Service
public class CommonQuestionInstanceServiceImpl implements ICommonQuestionInstanceService {

    @Resource
    private TbCommonQuestionInstanceMapper questionInstanceMapper;

    /**
     * @param questionInstance 问题实例
     * @return 是否成功
     */
    @Override
    public boolean insert(TbCommonQuestionInstance questionInstance) {
        if (questionInstance.getGmtCreate() == null) {
            questionInstance.setGmtCreate(new Date());
        }
        questionInstance.setGmtModified(new Date());
        return questionInstanceMapper.insertSelective(questionInstance) > 0;
    }

    /**
     * @param questionInstance 问题实例
     * @return 是否成功
     */
    @Override
    public boolean update(TbCommonQuestionInstance questionInstance) {
        questionInstance.setGmtModified(new Date());
        return questionInstanceMapper.updateByPrimaryKeySelective(questionInstance) > 0;
    }

    /**
     * @param id 实例id
     * @return 是否成功
     */
    @Override
    public boolean delete(int id) {
        return questionInstanceMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * @param id 实例id
     * @return 实例
     */
    @Override
    public TbCommonQuestionInstance getCommonQuestionInstance(int id) {
        return questionInstanceMapper.selectByPrimaryKey(id);
    }

    /**
     * @param questionId 类型id
     * @return 常见问题列表
     */
    @Override
    public List<TbCommonQuestionInstance> listCommonQuestionInstance(int questionId) {
        TbCommonQuestionInstanceExample example = new TbCommonQuestionInstanceExample();
        example.createCriteria()
                .andQuestionIdEqualTo(questionId);
        return questionInstanceMapper.selectByExample(example);
    }

    /**
     * @param instanceId 实例id
     * @param evaluation 评价：0 未，1有帮助，2无帮助
     * @return
     */
    @Override
    public boolean instanceEvaluation(int instanceId, int evaluation) {
        TbCommonQuestionInstance instance = getCommonQuestionInstance(instanceId);
        int count;

        if (evaluation == 1) {
            count = instance.getUsefulTotal() + 1;
            instance.setUsefulTotal(count);
        } else if (evaluation == 2) {
            count = instance.getUselessTotal() - 1;
            instance.setUselessTotal(count);
        }

        return update(instance);
    }

    /**
     * @param id 问题id
     * @return 记录数
     */
    @Override
    public int countById(int id) {
        TbCommonQuestionInstanceExample example = new TbCommonQuestionInstanceExample();
        example.createCriteria()
                .andIdEqualTo(id);
        return (int) questionInstanceMapper.countByExample(example);
    }

    /**
     * @param questionId 类型id
     * @return 记录数
     */
    @Override
    public int count(int questionId) {
        TbCommonQuestionInstanceExample example = new TbCommonQuestionInstanceExample();
        example.createCriteria()
                .andQuestionIdEqualTo(questionId);
        return (int) questionInstanceMapper.countByExample(example);
    }
}
