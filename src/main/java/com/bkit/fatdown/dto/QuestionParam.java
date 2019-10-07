package com.bkit.fatdown.dto;

import java.io.Serializable;

/**
 * @file: QuestionParam
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 问题参数
 * @date: Created in 2019/10/6 19:53
 * @modified:
 * @version: 1.0
 */

public class QuestionParam implements Serializable {
    private String title;

    private Integer status;

    public QuestionParam() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "QuestionParam{" +
                "title='" + title + '\'' +
                ", status=" + status +
                '}';
    }
}
