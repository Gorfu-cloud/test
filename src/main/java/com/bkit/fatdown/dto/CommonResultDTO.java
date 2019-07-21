package com.bkit.fatdown.dto;

import com.bkit.fatdown.common.api.IErrorCode;
import com.bkit.fatdown.common.api.ResultCodeEnum;

/**
 * @file: CommonResultDTO
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 通用返回对象
 * @date: Created in 2019/7/10 13:11
 * @modified:
 * @version: 1.0
 */

public class CommonResultDTO<T> {
    private long code;
    private String message;
    private T data;

    protected CommonResultDTO() {
    }

    private CommonResultDTO(long code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 返回成功结果
     * @param <T>
     * @return
     */
    public static <T> CommonResultDTO<T> success() {
        return new CommonResultDTO<T>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(),null);
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     */
    public static <T> CommonResultDTO<T> success(T data) {
        return new CommonResultDTO<T>(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getMessage(), data);
    }

    /**
     * 成功返回结果
     *
     * @param data    获取的数据
     * @param message 提示信息
     */
    public static <T> CommonResultDTO<T> success(T data, String message) {
        return new CommonResultDTO<T>(ResultCodeEnum.SUCCESS.getCode(), message, data);
    }

    /**
     * 失败返回结果
     *
     * @param errorCode 错误码
     */
    private static <T> CommonResultDTO<T> failed(IErrorCode errorCode) {
        return new CommonResultDTO<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }

    /**
     * 失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> CommonResultDTO<T> failed(String message) {
        return new CommonResultDTO<T>(ResultCodeEnum.FAILED.getCode(), message, null);
    }

    /**
     * 失败返回结果
     */
    public static <T> CommonResultDTO<T> failed() {
        return failed(ResultCodeEnum.FAILED);
    }

    /**
     * 参数验证失败返回结果
     */
    public static <T> CommonResultDTO<T> validateFailed() {
        return failed(ResultCodeEnum.VALIDATE_FAILED);
    }

    /**
     * 参数验证失败返回结果
     *
     * @param message 提示信息
     */
    public static <T> CommonResultDTO<T> validateFailed(String message) {
        return new CommonResultDTO<T>(ResultCodeEnum.VALIDATE_FAILED.getCode(), message, null);
    }

    /**
     * 未登录返回结果
     */
    public static <T> CommonResultDTO<T> unauthorized(T data) {
        return new CommonResultDTO<T>(ResultCodeEnum.UNAUTHORIZED.getCode(), ResultCodeEnum.UNAUTHORIZED.getMessage(), data);
    }

    /**
     * 未授权返回结果
     */
    public static <T> CommonResultDTO<T> forbidden(T data) {
        return new CommonResultDTO<T>(ResultCodeEnum.FORBIDDEN.getCode(), ResultCodeEnum.FORBIDDEN.getMessage(), data);
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResultDTO{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
