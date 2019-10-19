package com.bkit.fatdown.common.utils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @file: AliSendSmsUtilsTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 10/19/19  8:39 PM
 * @modified:
 * @version: 1.0
 */
public class AliSendSmsUtilsTest {

    @Test
    public void sendRegisterCode() {
        String phoneNumber = "15812572219";
        String code = "123123";
        assertTrue(AliSendSmsUtils.sendRegisterCode(phoneNumber, code));
    }
}