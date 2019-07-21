package com.bkit.fatdown.utils;


import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.io.*;
import java.util.*;

/**
 * @file: FTPUtils
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: FtpUtils
 * @date: Created in 2019/7/17  14:54
 * @modified:
 * @version: 1.0
 */

public class FTPUtils {
    /**
     * 边界标识
     */
    private final static String BOUNDARY = UUID.randomUUID().toString().toLowerCase().replaceAll("-", "");
    /**
     * 必须存在
     */
    private final static String PREFIX = "--";
    private final static String LINE_END = "\r\n";

    /**
     * @Description: 返回上传图片到服务器
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
     * 上传图片
     *
     * @param requestFile
     * @param os
     * @throws Exception
     */

    static void writeFile(Map<String, File> requestFile, OutputStream os) throws Exception {
        InputStream is = null;
        try {
            StringBuilder msg = new StringBuilder("请求上传文件部分:\n");
            if (requestFile == null || requestFile.isEmpty()) {
                msg.append("空");
            } else {
                StringBuilder requestParams = new StringBuilder();
                Set<Map.Entry<String, File>> set = requestFile.entrySet();
                for (Map.Entry<String, File> entry : set) {
                    requestParams.append(PREFIX).append(BOUNDARY).append(LINE_END);
                    requestParams.append("Content-Disposition: form-data; name=\"")
                            .append(entry.getKey()).append("\"; filename=\"")
                            .append(entry.getValue().getName()).append("\"")
                            .append(LINE_END);
                    requestParams.append("Content-Type:")
                            .append(getContentType(entry.getValue()))
                            .append(LINE_END);
                    requestParams.append("Content-Transfer-Encoding: 8bit").append(
                            LINE_END);
                    // 参数头设置完以后需要两个换行，然后才是参数内容
                    requestParams.append(LINE_END);

                    os.write(requestParams.toString().getBytes());

                    is = new FileInputStream(entry.getValue());

                    byte[] buffer = new byte[1024 * 1024];
                    int len = 0;
                    while ((len = is.read(buffer)) != -1) {
                        os.write(buffer, 0, len);
                    }
                    os.write(LINE_END.getBytes());
                    os.flush();

                    msg.append(requestParams.toString());
                }
            }
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception e) {
                throw new Exception(e);
            }
        }
    }

    /**
     * 获取图片类型
     *
     * @param file
     * @return
     * @throws Exception
     */
    private static String getContentType(File file) throws Exception {
        String streamContentType = "application/octet-stream";
        return getImageString(file, streamContentType);
    }

    /**
     * 获取图片字符串
     *
     * @param file
     * @param streamContentType
     * @return
     * @throws Exception
     */
    static String getImageString(File file, String streamContentType) throws Exception {
        String imageContentType;
        ImageInputStream image = null;
        try {
            image = ImageIO.createImageInputStream(file);
            if (image == null) {
                return streamContentType;
            }
            Iterator<ImageReader> it = ImageIO.getImageReaders(image);
            if (it.hasNext()) {
                imageContentType = "image/" + it.next().getFormatName();
                return imageContentType;
            }
        } catch (IOException e) {
            throw new Exception(e);
        } finally {
            try {
                if (image != null) {
                    image.close();
                }
            } catch (IOException e) {

                throw new Exception(e);
            }

        }
        return streamContentType;
    }


    /**
     * @Description: 转换为图片
     * @Param: MultipartFile
     * @return: File
     * @Author: YuJian
     * @date: 7/7/19
     */

    private File transferToFile(MultipartFile multipartFile) {
        int n;
        File f;
        // 创建文件
        f = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        try (InputStream in = multipartFile.getInputStream(); OutputStream os = new FileOutputStream(f)) {
            // 得到文件流。以文件流的方式输出到新文件
            // 可以使用byte[] ss = multipartFile.getBytes();代替while
            byte[] buffer = new byte[4096];
            while ((n = in.read(buffer, 0, 4096)) != -1) {
                os.write(buffer, 0, n);
            }
            // 读取文件第一行
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            // 输出路径
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return f;
    }
}
