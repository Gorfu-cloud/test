package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbUserBasicInfo;
import com.bkit.fatdown.mappers.TbUserBasicInfoMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

/**
 * @file: UserBasicInfoServiceImplTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: //TODO
 * @date: Created in 7/10/19  8:21 PM
 * @modified:
 * @version: 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserBasicInfoServiceImplTest {

    @InjectMocks
    private UserBasicInfoServiceImpl userBasicInfoService;

    @Mock
    private TbUserBasicInfoMapper userBasicInfoMapper;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void insert() {
        TbUserBasicInfo basicInfo = new TbUserBasicInfo();
        basicInfo.setOpenId("test1");
        // 当依赖对象 Mapper 的 insert 方法被测试对象 Service 的 insert 方法调用的时候返回 1
        when(userBasicInfoMapper.insert(any(TbUserBasicInfo.class))).thenReturn(1);
        // 验证被测试对象 Service 的 insert 方法调用后正常执行
        // TODO 新建表出错 日期7-10, 预计处理7-11
        assertTrue(userBasicInfoService.insert(basicInfo));
        // 验证依赖对象 Mapper 的 insert 方法确实被调用了一次， times(1) 指的就是调用了一次
        verify(userBasicInfoMapper, times(1)).insert(any(TbUserBasicInfo.class));
    }

    @Test
    public void update() {
        TbUserBasicInfo basicInfo = new TbUserBasicInfo();
        basicInfo.setId(1);
        basicInfo.setOpenId("test1");
        // 当依赖对象 Mapper 的 insert 方法被测试对象 Service 的 insert 方法调用的时候返回 1
        when(userBasicInfoMapper.updateByPrimaryKeySelective(any(TbUserBasicInfo.class))).thenReturn(1);
        // 验证被测试对象 Service 的 insert 方法调用后正常执行
        assertTrue(userBasicInfoService.update(basicInfo));
        // 验证依赖对象 Mapper 的 insert 方法确实被调用了一次， times(1) 指的就是调用了一次
        verify(userBasicInfoMapper, times(1)).updateByPrimaryKeySelective(any(TbUserBasicInfo.class));
    }

    @Test
    public void countByOpenId() {

    }

    @Test
    public void login() {
    }

    @Test
    public void getByOpenId() {
    }

    @Test
    public void getById() {
    }

    @Test
    public void deleteUserById() {
        // 当依赖对象 Mapper 的 insert 方法被测试对象 Service 的 insert 方法调用的时候返回 1
        when(userBasicInfoMapper.deleteByPrimaryKey(anyInt())).thenReturn(1);
        // 验证被测试对象 Service 的 insert 方法调用后正常执行
        assertTrue(userBasicInfoService.deleteUserById(1));
        // 验证依赖对象 Mapper 的 insert 方法确实被调用了一次， times(1) 指的就是调用了一次
        verify(userBasicInfoMapper, times(1)).deleteByPrimaryKey(anyInt());
    }

    @Test
    public void listByType() {
    }

    @Test
    public void listByTruename() {
    }

    @Test
    public void listByPhone() {
    }

    @Test
    public void listByUserlevel() {
    }

    @Test
    public void listAll() {
        List<TbUserBasicInfo> basicInfoList = userBasicInfoService.listAll(10, 1);
        System.out.println(basicInfoList.size());
        System.out.println(basicInfoList.get(2));
        verify(userBasicInfoMapper, times(1)).selectByExample(null);
    }

    @Test
    public void listByUserLever() {
//        List<TbUserBasicInfo> basicInfoList = userBasicInfoService.listByUserLever(1, 3, 2);
//        System.out.println(basicInfoList.size());
    }
}