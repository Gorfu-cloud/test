package com.bkit.fatdown.dto.power;

import java.io.Serializable;

/**
 * @file: AdminParam
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 管理员注册信息
 * @date: Created in 9/17/19  7:15 PM
 * @modified:
 * @version: 1.0
 */

public class AdminParam implements Serializable {
    private String userName;

    private String password;

    private String nickName;

    private Integer status;

    private Integer power;

    public AdminParam() {
    }

    public AdminParam(String userName, String password, String nickName, Integer status, Integer power) {
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
        this.status = status;
        this.power = power;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    @Override
    public String toString() {
        return "AdminParam{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", status=" + status +
                ", power=" + power +
                '}';
    }
}
