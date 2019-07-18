package com.bkit.fatdown.dto;

import java.util.Date;

/**
 * @file: TaskListDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 任务信息类, 整合任务记录和任务列表
 * @date: Created in 2019/7/18 9:54
 * @modified:
 * @version: 1.0
 */

public class TaskListDTO {
    /**
     * 任务类型
     */
    private String type;
    /**
     * 任务标题
     */
    private String title;
    /**
     * 任务积分
     */
    private Integer score;
    /**
     * 任务编号
     */
    private Integer taskId;
    /**
     * 任务是否已完成
     */
    private Integer complete;
    /**
     * 任务状态
     */
    private Integer flag;
    /**
     * 任务周期
     */
    private Date startDate;
}
