package com.bkit.fatdown.utils;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;

/**
 * @FileName: FtpUtils
 * @Author: YuJian
 * @Description: 文件传输工具类
 * @Date: Created in 7/5/19  11:38 PM
 * @Modified:
 * @Version: 1.0.0
 */

public class FtpUtils {

    /**
     * @Description: 返回上传文件是否成功
     * @Param:
     * @return: boolean
     * @Author: YuJian
     * @date: 7/5/19
     */

    public static boolean uploadFile(String host, int port, String username, String password, String basePath, String filePath,
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
                return result;
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
                            return result;
                        } else {
                            ftp.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            if (!ftp.storeFile(filename, input)) {
                return result;
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
}
