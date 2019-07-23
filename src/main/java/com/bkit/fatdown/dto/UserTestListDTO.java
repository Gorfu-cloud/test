package com.bkit.fatdown.dto;

import com.bkit.fatdown.entity.TbPaperBasic;

import java.util.Date;

/**
 * @file: UserTestListDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 用户测试信息数据封装类
 * @date: Created in 7/23/19  4:49 PM
 * @modified:
 * @version: 1.0
 */

public class UserTestListDTO {
    private Integer id;
    private String title;
    private Date startTime;
    private Date endTime;
    /**
     * 测试是否完成
     */
    private Integer isDone;

    public UserTestListDTO() {
    }

    public UserTestListDTO(TbPaperBasic paperBasic) {
        this.id = paperBasic.getId();
        this.startTime = paperBasic.getStartTime();
        this.endTime = paperBasic.getEndTime();
        this.title = paperBasic.getTitle();
        this.isDone = 0;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getIsDone() {
        return isDone;
    }

    public void setIsDone(Integer isDone) {
        this.isDone = isDone;
    }
}
