package com.bkit.fatdown.dto.power;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @file: PermissionParam
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 权限对象参数
 * @date: Created in 2019/10/5 17:25
 * @modified:
 * @version: 1.0
 */
@ApiModel("权限参数")
public class PermissionParam implements Serializable {

    @ApiModelProperty(value = "父级权限id")
    private Integer pid;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "权限值")
    private String value;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）")
    private Integer type;

    @ApiModelProperty(value = "前端资源路径")
    private String url;

    @ApiModelProperty(value = "启用状态；0->禁用；1->启用")
    private Integer status;

    public PermissionParam() {
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PermissionParam{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                ", icon='" + icon + '\'' +
                ", type=" + type +
                ", url='" + url + '\'' +
                ", status=" + status +
                '}';
    }
}
