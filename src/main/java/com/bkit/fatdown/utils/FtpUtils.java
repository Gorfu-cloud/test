package com.bkit.fatdown.utils;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.uid;

/**
 * @file: FtpUtils
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: FtpUtils
 * @date: Created in 2019/7/17  14:54
 * @modified:
 * @version: 1.0
 */

public class FtpUtils {

    private static final String FTP_ADDRESS = "134.175.135.105";
    private static final Integer FTP_PORT = 21;
    private static final String FTP_USERNAME = "ftpuser";
    private static final String FTP_PASSWORD = "ftpuser";
    private static final String FTP_BASE_PATH = "/";
    private static final String IMAGE_BASE_URL_HTTP = "http://image.sunnyqcloud.com";
    private static final DateFormat DF = new SimpleDateFormat("/yyyy/MM/dd");

    /**
     * @description: 连接服务器，传送文件
     * @params:
     * @return:
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 7/22/19
     */
    private static boolean uploadFile(String host, int port, String username, String password, String basePath, String filePath,
                                      String filename, InputStream input) {
        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(host, port);
            ftp.login(username, password);
            ftp.enterLocalActiveMode();
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return false;
            }
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
                            return false;
                        } else {
                            ftp.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            if (!ftp.storeFile(filename, input)) {
                return false;
            }
            input.close();
            ftp.logout();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * 上传图片到云数据库
     *
     * @param uploadFile
     * @param uid
     * @param date
     * @return
     */
    public static Map<String, String> uploadPicture(MultipartFile uploadFile, int uid, Date date) {
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
        String imagePath = "/pictures/" + uid + DF.format(date);

        boolean result = false;

        try {
            result = uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME, FTP_PASSWORD, FTP_BASE_PATH,
                    imagePath, newPictureName, uploadFile.getInputStream());
            String imgUrl = IMAGE_BASE_URL_HTTP + imagePath + "/" + newPictureName;
            map.put("imgUrl", imgUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("flag", Boolean.toString(result));
        return map;
    }
}
