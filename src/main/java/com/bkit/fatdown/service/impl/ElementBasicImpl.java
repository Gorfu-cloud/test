package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbElementBasic;
import com.bkit.fatdown.entity.TbElementBasicExample;
import com.bkit.fatdown.mappers.TbElementBasicMapper;
import com.bkit.fatdown.service.IElementBasicService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: ElementBasicImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 元素组成实现类
 * @date: Created in 7/26/19  10:24 AM
 * @modified:
 * @version: 1.0
 */

@Service
public class ElementBasicImpl implements IElementBasicService {

    @Resource
    private TbElementBasicMapper elementBasicMapper;

    /**
     * 插入新元素
     *
     * @param elementBasic
     * @return
     */
    @Override
    public boolean insert(TbElementBasic elementBasic) {
        elementBasic.setGmtCreate(new Date());
        elementBasic.setGmtModified(new Date());
        return elementBasicMapper.insertSelective(elementBasic) > 0;
    }

    /**
     * 删除新元素
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(int id) {
        return elementBasicMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 更新新元素
     *
     * @param elementBasic
     * @return
     */
    @Override
    public boolean update(TbElementBasic elementBasic) {
        elementBasic.setGmtModified(new Date());
        return elementBasicMapper.updateByPrimaryKey(elementBasic) > 0;
    }

    /**
     * 获取元素对象
     *
     * @param id
     * @return
     */
    @Override
    public TbElementBasic getElementBasic(int id) {
        return elementBasicMapper.selectByPrimaryKey(id);
    }

    /**
     * @param keyword  元素关键词
     * @param type     类型
     * @param pageNum  页数
     * @param pageSize 每页数目
     * @return 成分列表
     */
    @Override
    public List<TbElementBasic> listByPage(String keyword, Integer type, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        TbElementBasicExample example = new TbElementBasicExample();
        TbElementBasicExample.Criteria criteria = example.createCriteria();

        if (keyword != null) {
            criteria.andNameLike("%" + keyword + "%");
        }

        // 查找所有类型 -1
        if (type != -1) {
            criteria.andTypeEqualTo(type);
        }

        return elementBasicMapper.selectByExample(example);
    }

    /**
     * 获取元素
     *
     * @param type
     * @return
     */
    @Override
    public List<TbElementBasic> listElementBasic(int type) {
        TbElementBasicExample example = new TbElementBasicExample();
        example.createCriteria()
                .andTypeEqualTo(type);
        return elementBasicMapper.selectByExample(example);
    }

    /**
     * 获取元素
     *
     * @param list
     * @return
     */
    @Override
    public List<TbElementBasic> listElementBasicByList(List<Integer> list) {
        TbElementBasicExample example = new TbElementBasicExample();
        example.createCriteria()
                .andIdIn(list);
        return elementBasicMapper.selectByExample(example);
    }
}
