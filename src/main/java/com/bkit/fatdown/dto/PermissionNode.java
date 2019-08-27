package com.bkit.fatdown.dto;

import com.bkit.fatdown.entity.TbPermission;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.List;

/**
 * @file: PermissionNode
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 权限树
 * @date: Created in 2019/8/27 20:28
 * @modified:
 * @version: 1.0
 */

public class PermissionNode extends TbPermission {
    private List<PermissionNode> children;

    public List<PermissionNode> getChildren() {
        return children;
    }

    public void setChildren(List<PermissionNode> children) {
        this.children = children;
    }
}
