package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbPaperBasic;
import com.bkit.fatdown.entity.TbPaperBasicExample;
import com.bkit.fatdown.entity.TbQuestionBasic;
import com.bkit.fatdown.entity.TbQuestionBasicExample;
import com.bkit.fatdown.mappers.TbPaperBasicMapper;
import com.bkit.fatdown.mappers.TbQuestionBasicMapper;
import com.bkit.fatdown.service.ITestPaperService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: TestPaperServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 测试题功能实现类
 * @date: Created in 2019/7/18 15:41
 * @modified:
 * @version: 1.0
 */

@Service
public class TestPaperServiceImpl implements ITestPaperService {

    /**
     * 测试基础信息
     */
    @Resource
    private TbPaperBasicMapper paperBasicMapper;

    /**
     * 测试题目基础信息
     */
    @Resource
    private TbQuestionBasicMapper questionBasicMapper;

    /**
     * 获取抢答基础信息
     *
     * @return
     */
    @Override
    public List<TbPaperBasic> listPaperBasic() {
        return paperBasicMapper.selectByExample(new TbPaperBasicExample());
    }

    /**
     * 删除测试消息
     *
     * @param id
     * @return
     */
    @Override
    public boolean deletePaperInfo(int id) {
        return paperBasicMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 添加测试消息
     *
     * @param paperBasic
     * @return
     */
    @Override
    public boolean insertPaperInfo(TbPaperBasic paperBasic) {
        return paperBasicMapper.insertSelective(paperBasic) > 0;
    }

    /**
     * 统计试题的题目编号
     *
     * @param paperId
     * @return
     */
    @Override
    public int countQuestionByPaperId(int paperId) {
        TbQuestionBasicExample example = new TbQuestionBasicExample();
        example.createCriteria()
                .andPaperIdEqualTo(paperId);
        return (int) questionBasicMapper.countByExample(example);
    }

    /**
     * 通过测试编号获取题目
     *
     * @param paperId
     * @return
     */
    @Override
    public List<TbQuestionBasic> listQuestionByPaperId(int paperId) {
        TbQuestionBasicExample example = new TbQuestionBasicExample();
        example.createCriteria().andPaperIdEqualTo(paperId);
        return questionBasicMapper.selectByExample(example);
    }

    /**
     * 修改测试信息
     *
     * @param paperBasic
     * @return
     */
    @Override
    public boolean updatePaperInfo(TbPaperBasic paperBasic) {
        return paperBasicMapper.updateByPrimaryKeySelective(paperBasic) > 0;
    }

    /**
     * 查找日期之间的记录
     *
     * @param date
     * @return
     */
    //TODO 待完成
    @Override
    public List<TbPaperBasic> listPaperBasicByDate(Date date) {
        return null;
    }

    /**
     * 查找试题是否存在
     *
     * @param id
     * @return
     */
    @Override
    public boolean countQuestionById(int id) {
        TbQuestionBasic questionBasic = questionBasicMapper.selectByPrimaryKey(id);
        return questionBasic != null;
    }

    /**
     * 获取对应的题目内容
     *
     * @param id
     * @return
     */
    @Override
    public TbQuestionBasic getQuestionBasicById(int id) {
        return questionBasicMapper.selectByPrimaryKey(id);
    }
}
