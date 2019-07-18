package com.bkit.fatdown.dto;

/**
 * @file: TaskListDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 任务信息类, 整合任务记录和任务列表
 * @date: Created in 2019/7/18 9:54
 * @modified:
 * @version: 1.0
 */

public class UserTaskListDTO {

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
    private Integer cycle;

    public UserTaskListDTO() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getComplete() {
        return complete;
    }

    public void setComplete(Integer complete) {
        this.complete = complete;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Integer getCycle() {
        return cycle;
    }

    public void setCycle(Integer cycle) {
        this.cycle = cycle;
    }
}
