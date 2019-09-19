package com.bkit.fatdown.dto.power;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * @file: AdminLoginInfoDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 用户登陆信息
 * @date: Created in 8/17/19  3:45 PM
 * @modified:
 * @version: 1.0
 */
@ApiModel
public class AdminLoginInfoDTO implements Serializable {
    private String userName;
    private String password;

    public AdminLoginInfoDTO() {
    }

    public AdminLoginInfoDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminLoginInfoDTO{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
