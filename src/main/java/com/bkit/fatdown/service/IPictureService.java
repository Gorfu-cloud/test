package com.bkit.fatdown.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.Map;

/**
 * @file: IPictureService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 图片相关功能实现类
 * @date: Created in 2019/7/17 15:01
 * @modified:
 * @version: 1.0
 */

public interface IPictureService {
    /**
     * 上传图片
     *
     * @param uploadFile
     * @param uid
     * @param date
     * @return
     */
    Map<String, Object> upload(MultipartFile uploadFile, int uid, Date date);
}
