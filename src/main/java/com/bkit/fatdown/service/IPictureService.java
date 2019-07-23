package com.bkit.fatdown.service;

import com.bkit.fatdown.entity.TbDietPicture;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

    /**
     * 通过日期时间获取，早餐：0->10,午餐：10->15,晚餐：15->24
     *
     * @param uid
     * @param start
     * @param end
     * @return
     */
    List<TbDietPicture> listBetweenTime(int uid, Date start, Date end);

    /**
     * 获取某日三餐记录
     *
     * @param uid
     * @param date
     * @return
     */
    HashMap<String, Object> listByDate(int uid, Date date);
}
