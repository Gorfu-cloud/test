package com.bkit.fatdown.dto.feedback;

import com.bkit.fatdown.entity.TbFeedbackInfo;
import com.bkit.fatdown.common.utils.DataTransferUtils;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @file: FeedbackInfoDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 反馈信息转换类
 * @date: Created in 8/15/19  11:25 PM
 * @modified:
 * @version: 1.0
 */

@ApiModel
public class FeedbackInfoDTO implements Serializable {
    private Integer id;
    private Integer typeId;
    private String typeName;
    private String content;
    private Integer status;
    private Date gmtCreate;
    private Set<String> imgUrlSet;

    public FeedbackInfoDTO() {
    }

    public FeedbackInfoDTO(Integer id, Integer typeId, String typeName, String content, Integer status,
                           Date gmtCreate, Set<String> imgUrlSet) {
        this.id = id;
        this.typeId = typeId;
        this.typeName = typeName;
        this.content = content;
        this.status = status;
        this.gmtCreate = gmtCreate;
        this.imgUrlSet = imgUrlSet;
    }

    public FeedbackInfoDTO(TbFeedbackInfo info) {
        this.id = info.getId();
        this.typeId = info.getTypeId();
        this.typeName = "";
        this.content = info.getContent();
        this.status = info.getStatus();
        this.gmtCreate = info.getGmtCreate();
        this.imgUrlSet = DataTransferUtils.string2Set(info.getImgUrlSet());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Set<String> getImgUrlSet() {
        return imgUrlSet;
    }

    public void setImgUrlSet(Set<String> imgUrlSet) {
        this.imgUrlSet = imgUrlSet;
    }

    @Override
    public String toString() {
        return "FeedbackInfoDTO{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", gmtCreate=" + gmtCreate +
                ", imgUrlSet=" + imgUrlSet.toString() +
                '}';
    }
}
