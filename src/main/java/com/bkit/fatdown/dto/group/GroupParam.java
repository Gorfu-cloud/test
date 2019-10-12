package com.bkit.fatdown.dto.group;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @file: GroupParam
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 分组参数
 * @date: Created in 10/12/19  4:56 PM
 * @modified:
 * @version: 1.0
 */
@ApiModel("分组参数")
public class GroupParam implements Serializable {

    private String name;
    @ApiModelProperty("分组描述")
    private String note;
    @ApiModelProperty("管理员, 默认管理员 1")
    private Integer adminId;
    @ApiModelProperty("状态: 0 关闭, 1开启")
    private Integer status;

    public GroupParam() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GroupParam{" +
                "name='" + name + '\'' +
                ", note='" + note + '\'' +
                ", adminId=" + adminId +
                ", status=" + status +
                '}';
    }
}
