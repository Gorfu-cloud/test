package com.bkit.fatdown.common.utils;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @file: FtpUtils
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: FtpUtils
 * @date: Created in 2019/7/17  14:54
 * @modified:
 * @version: 1.0
 */

public class FtpUtils {

    private static final String FTP_ADDRESS = "106.54.43.85";
    private static final Integer FTP_PORT = 21;
    private static final String FTP_USERNAME = "ftpuser1";
    private static final String FTP_PASSWORD = "jkgl2019@";
    private static final String FTP_BASE_PATH = "/home/ftpuser1";
    private static final String IMAGE_BASE_URL_HTTP = "http://image.sunnyqcloud.com";

    private static Logger LOGGER = LoggerFactory.getLogger(FtpUtils.class);

    /**
     * @description: 连接服务器，传送文件
     * @params:
     * @return:
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 7/22/19
     */
    private static boolean uploadFile(String host, int port, String username, String password, String basePath, String filePath,
                                      String filename, InputStream input) {
        LOGGER.info("ftp传送文件开始");
        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(host, port);
            ftp.login(username, password);
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                LOGGER.error("ftp连接失败,返回码：" + ftp.getReplyCode());
                ftp.disconnect();
                LOGGER.info("关闭ftp连接");
                return false;
            }

            // 创建目录和文件夹
            if (!ftp.changeWorkingDirectory(basePath + filePath)) {
                String[] dirs = filePath.split("/");
                String tempPath = basePath;
                for (String dir : dirs) {
                    if (null == dir || "".equals(dir)) {
                        continue;
                    }
                    tempPath += "/" + dir;
                    if (!ftp.changeWorkingDirectory(tempPath)) {
                        if (!ftp.makeDirectory(tempPath)) {
                            LOGGER.error("ftp，创建上传临时文件夹失败：" + tempPath);
                            return false;
                        } else {
                            ftp.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            // 主动模式和被动模式的区别可看.https://blog.csdn.net/zhangyuan12805/article/details/71425385
            // 腾讯云关于ftp 服务器可看. https://cloud.tencent.com/document/product/213/10912
            // 开启主动连接
            ftp.enterLocalActiveMode();
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            ftp.setControlEncoding("UTF-8");
            if (!ftp.storeFile(filename, input)) {
                LOGGER.error("ftp，存储文件失败");
                return false;
            }
            input.close();
            ftp.logout();
            result = true;
        } catch (Exception e) {
            LOGGER.error("ftp，传送文件失败：" + e);
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    LOGGER.error("ftp，传送文件，连接关闭失败：" + e);
                    e.printStackTrace();
                }
            }
        }
        LOGGER.info("ftp,传送文件结束");
        return result;
    }


    /**
     * 上传图片到云数据库
     *
     * @param uploadFile 上传图片
     * @param uid        用id
     * @param date       日期
     * @return imgUrl：图片路径，flag：是否上传成功（true、false）
     */
    public static Map<String, String> uploadPicture(MultipartFile uploadFile, int uid, Date date) {
        LOGGER.info("上传图片开始");
        Map<String, String> map = new HashMap<>(3);
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
        String imagePath = "/pictures/" + uid;

        boolean result = false;
        try {
            result = uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH,
                    imagePath, newPictureName, uploadFile.getInputStream());
            String imgUrl = IMAGE_BASE_URL_HTTP + imagePath + "/" + newPictureName;
            map.put("imgUrl", imgUrl);
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("上传图片到云数据库失败" + e);
        }
        map.put("flag", Boolean.toString(result));
        return map;
    }

    /**
     * 上传图片到云数据库
     *
     * @param uploadFile 上传图片
     * @return imgUrl：图片路径，flag：是否上传成功（true、false）
     */
    public static Map<String, String> uploadPicture2Dir(MultipartFile uploadFile, String dirName) {
        LOGGER.info("上传图片开始");
        //图片上传 http://image.sunnyqcloud.com/pictures/4/2019/07/22/1563806098299320.jpg
        String imagePath = "/" + dirName;

        Map<String, String> map = new HashMap<>(3);
        //取原始文件名
        String oldPictureName = uploadFile.getOriginalFilename();
        //生成新文件名
        String newPictureName = IDUtils.getImageName();
        //得到文件的后缀名称
        assert oldPictureName != null;
        String postfix = oldPictureName.substring(oldPictureName.lastIndexOf("."));
        //构建出一个新的文件名
        newPictureName = newPictureName + postfix;

        boolean result = false;
        try {
            result = uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH,
                    imagePath, newPictureName, uploadFile.getInputStream());
            String imgUrl = IMAGE_BASE_URL_HTTP + imagePath + "/" + newPictureName;
            map.put("imgUrl", imgUrl);
            LOGGER.info("uploadFile success !");
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("上传图片到云数据库失败" + e.getMessage());
        }
        map.put("flag", Boolean.toString(result));
        return map;
    }
}
