package com.bkit.fatdown.common.api;

/**
 * @file: IErrorCode
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 封装API的错误码
 * @date: Created in 2019/7/10 13:05
 * @modified:
 * @version: 1.0
 */

public interface IErrorCode {
    /**
     * 获取结果码
     *
     * @return code
     */
    long getCode();

    /**
     * 返回结果信息
     *
     * @return message
     */
    String getMessage();
}
