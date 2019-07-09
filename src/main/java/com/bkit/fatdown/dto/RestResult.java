package com.bkit.fatdown.dto;

/**
 * @FileName: RestResult
 * @Author: YuJian
 * @Description: 插入, 删除, 查找存在, 结果返回对象
 * @Date: Created in 2019/7/9 17:42
 * @Modified:
 * @Version: 1.0
 */

public class RestResult {

    private Integer code;

    private String message;

    public RestResult() {
    }

    public RestResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
