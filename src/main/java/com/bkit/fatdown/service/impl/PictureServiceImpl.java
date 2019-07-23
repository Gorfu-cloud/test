package com.bkit.fatdown.service.impl;

import com.bkit.fatdown.entity.TbDietPicture;
import com.bkit.fatdown.entity.TbDietPictureExample;
import com.bkit.fatdown.entity.TbFoodRecord;
import com.bkit.fatdown.entity.TbFoodRecordExample;
import com.bkit.fatdown.mappers.TbDietPictureMapper;
import com.bkit.fatdown.mappers.TbFoodRecordMapper;
import com.bkit.fatdown.service.IPictureService;
import com.bkit.fatdown.utils.DateUtils;
import com.bkit.fatdown.utils.FtpUtils;
import com.bkit.fatdown.utils.IDUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
public class PictureServiceImpl implements IPictureService {

    private static final String FTP_ADDRESS = "134.175.135.105";
    private static final Integer FTP_PORT = 21;
    private static final String FTP_USERNAME = "ftpuser";
    private static final String FTP_PASSWORD = "ftpuser";
    private static final String FTP_BASE_PATH = "/";
    private static final String IMAGE_BASE_URL_HTTP = "http://image.sunnyqcloud.com";
    private DateFormat df = new SimpleDateFormat("/yyyy/MM/dd");

    @Resource
    private TbDietPictureMapper pictureMapper;

    /**
     * 上传图片
     *
     * @return
     */
    @Override
    @Transactional
    public Map<String, Object> upload(MultipartFile uploadFile, int uid, Date date) {
        Map<String, Object> resultMap = new HashMap<>(2);
        try {
            //取原始文件名
            String oldPictureName = uploadFile.getOriginalFilename();
            //生成新文件名
            String newPictureName = IDUtils.getImageName();
            //得到文件的后缀名称
            assert oldPictureName != null;
            String postfix = oldPictureName.substring(oldPictureName.lastIndexOf("."));
            //构建出一个新的文件名
            newPictureName = newPictureName + postfix;

            //图片上传 http://image.sunnyqcloud.com/pictures/4/2019/07/22/1563806098299320.jpg
            String imagePath = "/pictures/" + uid + df.format(date);
            boolean result = FtpUtils.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH,
                    imagePath, newPictureName, uploadFile.getInputStream());
            //返回结果
            if (result) {
                TbDietPicture picture = new TbDietPicture();
                resultMap.put("flag", 1);
                resultMap.put("url", IMAGE_BASE_URL_HTTP + imagePath + "/" + newPictureName);
                picture.setGmtCreate(date);
                picture.setUrl((String) resultMap.get("url"));
                picture.setUserId(uid);
                picture.setGmtCreate(new Date());
                picture.setGmtModified(new Date());
                // 上传图片到图库
                pictureMapper.insertSelective(picture);
            } else {
                // 上传图片失败
                resultMap.put("flag", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
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
