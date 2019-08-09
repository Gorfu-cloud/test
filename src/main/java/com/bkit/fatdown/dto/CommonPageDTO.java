package com.bkit.fatdown.dto;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * @file: CommonPageDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 分页数据封装类
 * @date: Created in 2019/7/10 14:02
 * @modified:
 * @version: 1.0
 */

@ApiModel
public class CommonPageDTO<T> implements Serializable {
    /**
     * 页号
     */
    private Integer pageNum;
    /**
     * 页大小
     */
    private Integer pageSize;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 结果总数
     */
    private Long total;
    /**
     * 结果数据
     */
    private List<T> list;

    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public static <T> CommonPageDTO<T> restPage(List<T> list) {
        CommonPageDTO<T> result = new CommonPageDTO<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CommonPageDTO)) {
            return false;
        }
        CommonPageDTO<?> that = (CommonPageDTO<?>) o;
        return getPageNum().equals(that.getPageNum()) &&
                getPageSize().equals(that.getPageSize()) &&
                getTotalPage().equals(that.getTotalPage()) &&
                getTotal().equals(that.getTotal()) &&
                getList().equals(that.getList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPageNum(), getPageSize(), getTotalPage(), getTotal(), getList());
    }

    @Override
    public String toString() {
        return "CommonPageDTO{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", total=" + total +
                ", list=" + list +
                '}';
    }
}
