package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbUserBasicInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserBasicInfoServiceTest {

    @Resource
    private UserBasicInfoService userBasicInfoService;

    private  TbUserBasicInfo userBasicInfo = new TbUserBasicInfo();

    @Test
    public void checkUser() {
        String FALSE_OPENID = "2";
        String TRUE_OPENID = "1234";
        String NULL_OPENID = "";

        assertFalse(userBasicInfoService.checkUser(FALSE_OPENID));
        assertFalse(userBasicInfoService.checkUser(NULL_OPENID));
        assertTrue(userBasicInfoService.checkUser(TRUE_OPENID));
    }

    @Test
    public void insertUserBasicInfo() {
    }

    @Test
    public void updateUserBasicInfo() {
        userBasicInfo.setId(2);
        userBasicInfo.setCity("广州");
        assertTrue(userBasicInfoService.updateUserBasicInfo(userBasicInfo));
        userBasicInfo.setId(0);
        assertFalse(userBasicInfoService.updateUserBasicInfo(userBasicInfo));
    }

    @Test
    public void findUserBasicInfoByOpenid() {
        String FALSE_OPENID = "2";
        String TRUE_OPENID = "1234";
        String NULL_OPENID = "";
        System.out.println(userBasicInfoService.findUserBasicInfoByOpenid(TRUE_OPENID));
        System.out.println(userBasicInfoService.findUserBasicInfoByOpenid(FALSE_OPENID));
    }

    @Test
    public void findUserBasicInfoById() {
        System.out.println(userBasicInfoService.findUserBasicInfoById(2));
    }

    @Test
    public void deleteUserById() {
    }

    @Test
    public void findAllByType() {
    }

    @Test
    public void findAllByTruename() {
    }

    @Test
    public void findAllByPhone() {
    }

    @Test
    public void findAllByUserlevel() {
    }
}