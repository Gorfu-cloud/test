package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbDietPicture;
import com.bkit.fatdown.entity.TbDietPictureExample;
import com.bkit.fatdown.entity.TbPictureType;
import com.bkit.fatdown.mappers.TbDietPictureMapper;
import com.bkit.fatdown.service.IPictureService;
import com.bkit.fatdown.service.IPictureTypeService;
import com.bkit.fatdown.common.utils.DateUtils;
import com.bkit.fatdown.common.utils.FtpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @file: PictureService
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 图片功能实现类
 * @date: Created in 7/22/19  8:50 PM
 * @modified:
 * @version: 1.0
 */

@Service
@Transactional
public class PictureServiceImpl implements IPictureService {

    private static Logger logger = LoggerFactory.getLogger(PictureServiceImpl.class);

    @Resource
    private TbDietPictureMapper pictureMapper;
    @Resource
    private IPictureTypeService typeService;

    @Override
    public boolean uploadDir(MultipartFile uploadFile, int uid, int typeId) {
        logger.info("开始上传图片：" + uid + " " + uploadFile.getOriginalFilename() + " " + uploadFile.getSize());
        if (uploadFile.isEmpty()) {
            logger.error("upload picture is empty, typeId: {} and uid: {}", typeId, uid);
            return false;
        }

        TbPictureType type = typeService.get(typeId);
        String dirName = type.getTypeName();

        Map<String, String> uploadPictureResult = FtpUtils.uploadPicture2Dir(uploadFile, dirName);

        // 上传图片成功
        if ("true".equals(uploadPictureResult.get("flag"))) {
            TbDietPicture picture = new TbDietPicture();
            picture.setUrl(uploadPictureResult.get("imgUrl"));
            picture.setUserId(uid);
            picture.setTypeId(typeId);
            picture.setGmtCreate(new Date());
            picture.setGmtModified(new Date());
            // 添加记录
            return pictureMapper.insertSelective(picture) > 0;
        } else {
            // 上传图片失败
            logger.error("upload picture fail");
            return false;
        }
    }

    /**
     * 上传图片
     *
     * @return
     */
    @Override
    public Map<String, Object> upload(MultipartFile uploadFile, int uid, Date date) {
        logger.info("开始上传图片：" + uid + " " + uploadFile.getOriginalFilename() + " " + uploadFile.getSize());
        Map<String, Object> resultMap = new HashMap<>(3);
        if (uploadFile.isEmpty()) {
            logger.error("上传文件为空");

            resultMap.put("flag", 0);
            resultMap.put("msg", "上传文件为空！");
            return resultMap;
        }

        Map<String, String> uploadPictureResult = FtpUtils.uploadPicture(uploadFile, uid, date);

        // 上传图片成功
        if ("true".equals(uploadPictureResult.get("flag"))) {
            TbDietPicture picture = new TbDietPicture();
            resultMap.put("flag", 1);
            resultMap.put("url", uploadPictureResult.get("imgUrl"));
            picture.setUrl(uploadPictureResult.get("imgUrl"));
            picture.setUserId(uid);

            picture.setGmtCreate(date);
            picture.setGmtModified(new Date());
            // 添加记录
            pictureMapper.insertSelective(picture);

        } else {
            // 上传图片失败
            logger.error("上传图片失败");
            resultMap.put("flag", 0);
        }
        logger.info("上传图片结束");
        return resultMap;
    }

    /**
     * 获取饮食图片记录数
     *
     * @param uid 用户id
     * @param url 图片url
     * @return 记录数
     */
    @Override
    public Integer count(Integer uid, String url) {
        TbDietPictureExample example = new TbDietPictureExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andUrlEqualTo(url);
        return (int) pictureMapper.countByExample(example);
    }

    /**
     * 获取饮食图片
     *
     * @param uid 用户id
     * @param url 图片路径
     * @return 饮食图片
     */
    @Override
    public TbDietPicture getPicture(Integer uid, String url) {
        TbDietPictureExample example = new TbDietPictureExample();
        example.createCriteria()
                .andUrlEqualTo(url)
                .andUserIdEqualTo(uid);
        return pictureMapper.selectByExample(example).get(0);
    }

    /**
     * 删除饮食图片
     *
     * @param uid 用户id
     * @param url 图片url
     * @return 是否成功
     */
    @Override
    public boolean delete(Integer uid, String url) {
        TbDietPictureExample example = new TbDietPictureExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andUrlEqualTo(url);
        return pictureMapper.deleteByExample(example) > 0;
    }

    @Override
    public List<TbDietPicture> listBetweenTime(int uid, Date start, Date end) {
        TbDietPictureExample example = new TbDietPictureExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andGmtCreateBetween(start, end);
        return pictureMapper.selectByExample(example);
    }

    /**
     * 获取用餐记录
     *
     * @param start
     * @param end
     * @param uid
     * @return
     */
    @Override
    public Integer countRecord(Date start, Date end, Integer uid) {
        TbDietPictureExample example = new TbDietPictureExample();
        example.createCriteria()
                .andUserIdEqualTo(uid)
                .andGmtCreateBetween(start, end);
        return (int) pictureMapper.countByExample(example);
    }

    /**
     * 获取某日三餐记录
     *
     * @param uid
     * @param date
     * @return
     */
    @Override
    public HashMap<String, Object> listByDate(int uid, Date date) {
        HashMap<String, Object> map = new HashMap<>(3);
        map.put("breakfast", listBetweenTime(uid, DateUtils.getBreakfastStartTime(date), DateUtils.getBreakfastEndTime(date)));
        map.put("lunch", listBetweenTime(uid, DateUtils.getLunchStartTime(date), DateUtils.getLunchEndTime(date)));
        map.put("dinner", listBetweenTime(uid, DateUtils.getDinnerStartTime(date), DateUtils.getDinnerEndTime(date)));
        return map;
    }
}