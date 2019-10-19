package com.bkit.fatdown.dto;

import java.io.Serializable;

/**
 * @file: NameIdDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 用于查询的名称和ID
 * @date: Created in 10/19/19  8:58 AM
 * @modified:
 * @version: 1.0
 */

public class NameIdDTO implements Serializable {
    private String name ;
    private Integer id;

    public NameIdDTO() {
    }

    public NameIdDTO(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "NameIdDTO{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
