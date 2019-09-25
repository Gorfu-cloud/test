package com.bkit.fatdown.dto;

import java.io.Serializable;

/**
 * @file: RedeemCodeDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 兑换码
 * @date: Created in 2019/9/25 15:48
 * @modified:
 * @version: 1.0
 */
public class RedeemCodeDTO implements Serializable {
    private String info;

    private String type;

    private Long typeId;

    private Long total;

    private Integer status;

    public RedeemCodeDTO() {
    }

    public RedeemCodeDTO(String info, String type, Long typeId, Integer status) {
        this.info = info;
        this.type = type;
        this.typeId = typeId;
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "RedeemCodeDTO{" +
                "info='" + info + '\'' +
                ", type='" + type + '\'' +
                ", typeId=" + typeId +
                ", total=" + total +
                ", status=" + status +
                '}';
    }
}
