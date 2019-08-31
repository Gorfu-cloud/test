package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbPictureType;
import com.bkit.fatdown.entity.TbPictureTypeExample;
import com.bkit.fatdown.mappers.TbPictureTypeMapper;
import com.bkit.fatdown.service.IPictureTypeService;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @file: PictureTypeServiceImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 图片类型实现类
 * @date: Created in 8/31/19  3:46 PM
 * @modified:
 * @version: 1.0
 */
@Service
public class PictureTypeServiceImpl implements IPictureTypeService {
    @Resource
    private TbPictureTypeMapper typeMapper;

    @Override
    public boolean insert(TbPictureType type) {
        if (type.getGmtCreate()==null){
            type.setGmtCreate(new Date());
        }
        type.setGmtModified(new Date());
        return typeMapper.insertSelective(type)>0;
    }

    @Override
    public boolean delete(int id) {
        return typeMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public boolean update(TbPictureType type) {
        type.setGmtModified(new Date());
        return typeMapper.updateByPrimaryKeySelective(type)>0;
    }

    @Override
    public TbPictureType get(int id) {
        return typeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TbPictureType> list(Integer status, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        TbPictureTypeExample example = new TbPictureTypeExample();

        example.setOrderByClause("gmt_create desc");
        if (status!= -1) {
            example.createCriteria()
                    .andStatusEqualTo(status);
        }

        return typeMapper.selectByExample(example);
    }

    @Override
    public Integer count(Integer typeId) {
        TbPictureTypeExample example = new TbPictureTypeExample();
        example.createCriteria()
                .andIdEqualTo(typeId);
        return (int)typeMapper.countByExample(example);
    }

    @Override
    public Integer count(String typeName) {
        TbPictureTypeExample example = new TbPictureTypeExample();
        example.createCriteria()
                .andTypeNameEqualTo(typeName);
        return (int)typeMapper.countByExample(example);
    }

    @Override
    public Integer search(String typeName) {
        TbPictureTypeExample example = new TbPictureTypeExample();
        example.createCriteria()
                .andTypeNameEqualTo(typeName);
        return typeMapper.selectByExample(example).get(0).getId();
    }

}
