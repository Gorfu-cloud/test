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

    boolean uploadDir(MultipartFile uploadFile, int uid, int typeId);

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

    /**
     * 获取用餐记录
     *
     * @param start
     * @param end
     * @param uid
     * @return
     */
    Integer countRecord(Date start, Date end, Integer uid);

    /**
     * 获取饮食图片记录数
     *
     * @param uid 用户id
     * @param url 图片url
     * @return 记录数
     */
    Integer count(Integer uid, String url);

    /**
     * 删除饮食图片
     *
     * @param uid 用户id
     * @param url 图片url
     * @return 是否成功
     */
    boolean delete(Integer uid, String url);

    /**
     * 获取饮食图片
     *
     * @param uid 用户id
     * @param url 图片路径
     * @return 饮食图片
     */
    TbDietPicture getPicture(Integer uid, String url);


}
