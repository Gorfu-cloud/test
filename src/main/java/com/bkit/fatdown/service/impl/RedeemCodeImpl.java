package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.dto.RedeemCodeDTO;
import com.bkit.fatdown.entity.TbRedeemCode;
import com.bkit.fatdown.entity.TbRedeemCodeExample;
import com.bkit.fatdown.mappers.TbRedeemCodeMapper;
import com.bkit.fatdown.service.IRedeemCodeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @file: RedeemCodeImpl
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 兑换码实现类
 * @date: Created in 2019/9/25 15:54
 * @modified:
 * @version: 1.0
 */
@Service
public class RedeemCodeImpl implements IRedeemCodeService {

    @Resource
    private TbRedeemCodeMapper codeMapper;

    /**
     * 创建
     *
     * @param params 创建
     * @return 是否成功
     */
    @Override
    public boolean insert(RedeemCodeDTO params) {

        TbRedeemCode code = new TbRedeemCode();
        BeanUtils.copyProperties(params, code);

        String key = generateCode(6);

        while (count(key)) {
            key = generateCode(6);
        }

        // 生成测试码
        code.setCode(key);

        return codeMapper.insertSelective(code) > 0;
    }

    /**
     * 删除
     *
     * @param id 编号
     * @return 是否成功
     */
    @Override
    public boolean delete(Long id) {
        return codeMapper.deleteByPrimaryKey(id) > 0;
    }

    /**
     * 更新
     *
     * @param id     编号
     * @param params 兑换码
     * @return 是否成功
     */
    @Override
    public boolean update(Long id, RedeemCodeDTO params) {
        TbRedeemCode code = new TbRedeemCode();
        BeanUtils.copyProperties(params, code);

        code.setId(id);
        code.setGmtModified(new Date());

        return codeMapper.updateByPrimaryKeySelective(code) > 0;
    }

    /**
     * 获取信息
     *
     * @param id 测试码编号
     * @return 测试码信息
     */
    @Override
    public TbRedeemCode get(Long id) {
        return codeMapper.selectByPrimaryKey(id);
    }

    /**
     * 获取测试码信息
     *
     * @param code 测试码
     * @return 测试码信息
     */
    @Override
    public TbRedeemCode get(String code) {
       TbRedeemCodeExample example = new TbRedeemCodeExample();
       example.createCriteria()
               .andCodeEqualTo(code);

       List<TbRedeemCode> list= codeMapper.selectByExample(example);

       if (list.size()==0){
           return null;
       }

       return list.get(0);
    }

    /**
     * 判断是否存在
     *
     * @param id 编号
     * @return 是否存在
     */
    @Override
    public boolean count(long id) {
        TbRedeemCodeExample example = new TbRedeemCodeExample();
        example.createCriteria()
                .andIdEqualTo(id);

        return codeMapper.countByExample(example) > 0;
    }

    /**
     * 获取存在数目
     *
     * @param code 兑换码
     * @return 是否成功
     */
    @Override
    public boolean count(String code) {
        TbRedeemCodeExample example = new TbRedeemCodeExample();
        example.createCriteria()
                .andCodeEqualTo(code);
        return codeMapper.countByExample(example) > 0;
    }

    /**
     * 核查存在?
     *
     * @param code 兑换码
     * @return 是否成功
     */
    @Override
    public boolean check(String code) {
        TbRedeemCodeExample example = new TbRedeemCodeExample();
        example.createCriteria()
                .andCodeEqualTo(code)
                .andStatusEqualTo(1);
        return codeMapper.countByExample(example) > 0;
    }

    /**
     * 批量更新状态
     *
     * @param idList 列表
     * @param status 状态
     * @return 修改记录数
     */
    @Override
    public int updateStatus(List<Long> idList, Integer status) {
        if (idList.isEmpty()) {
            return 0;
        }

        TbRedeemCode code= new TbRedeemCode();
        code.setStatus(status);
        code.setGmtModified(new Date());

        TbRedeemCodeExample example = new TbRedeemCodeExample();
        example.createCriteria()
                .andIdIn(idList);

        return codeMapper.updateByExampleSelective(code,example);
    }

    /**
     * 批量删除
     *
     * @param idList 列表
     * @return 删除记录数
     */
    @Override
    public int delete(List<Long> idList) {
        if (idList.isEmpty()){
            return 0;
        }

        TbRedeemCodeExample example = new TbRedeemCodeExample();
        example.createCriteria()
                .andIdIn(idList);

        return codeMapper.deleteByExample(example);
    }

    /**
     * 分页 查看兑换码
     *
     * @param pageNum  分页
     * @param pageSize 页数
     * @return 列表
     */
    @Override
    public List<TbRedeemCode> list(String keyword, Integer status, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        TbRedeemCodeExample example = new TbRedeemCodeExample();
        // 倒序输出
        example.setOrderByClause("gmt_create desc");

        TbRedeemCodeExample.Criteria criteria = example.createCriteria();

        if (status != null&& status!=-1){
            criteria.andStatusEqualTo(status);
        }

        if (!StringUtil.isEmpty(keyword)) {
            criteria.andTypeLike("%" + keyword + "%");
            example.or(example.createCriteria().andInfoLike("%"+keyword+"%"));
            example.or(example.createCriteria().andCodeLike("%" + keyword + "%"));
        }

        return codeMapper.selectByExample(example);
    }

    /**
     * 生成字母与数字的随机码
     * @param length 随机码长度
     * @return 随机码
     */
    private String generateCode(int length) {
        String codes = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRESTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(codes.length());
            sb.append(codes.charAt(index));
        }

        //返回随机字符
        return sb.toString();
    }
}
