package com.bkit.fatdown.utils;

import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @file: RecogniseUtils
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 食物识别工具类
 * @date: Created in 7/15/19  9:39 PM
 * @modified:
 * @version: 1.0
 */

public class RecogniseUtils {

    private final static HostnameVerifier DO_NOT_VERIFY = (hostname, session) -> true;
    /**
     * 边界标识
     */
    private final static String BOUNDARY = UUID.randomUUID().toString().toLowerCase().replaceAll("-", "");
    /**
     * 必须存在
     */
    private final static String PREFIX = "--";
    private final static String LINE_END = "\r\n";
    private final static String APP_SECRET = "4b69917eee2e45bbab36f8c1d9302514";
    private final static String APP_ID = "5d03342e61f1e975168ab559";
    /**
     * 服务地址
     */
    private final static String ADDRESS = "https://open.jishiqi.net/api/v1/detect/img/detect";

    public static StringBuffer getRecognise(MultipartFile file) {
        URL url;
        InputStream input;
        OutputStream os;
        BufferedReader br;
        StringBuffer buffer = null;

        String requestId = System.currentTimeMillis() + "" + Math.round(Math.random() * 10000000);
        System.out.println(requestId);
        String s1 = DigestUtils.md5DigestAsHex(requestId.getBytes()).toUpperCase();
        String sign = DigestUtils.md5DigestAsHex((s1 + APP_SECRET).getBytes()).toUpperCase();
        try {
            url = new URL(ADDRESS);
            // 设定连接的相关参数
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setHostnameVerifier(DO_NOT_VERIFY);
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept", "*/*");
            connection.setRequestProperty("Connection", "keep-alive");
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            connection.setRequestProperty("Charset", "UTF-8");
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Sign", sign);
            connection.setRequestProperty("Request-Id", requestId);
            connection.setRequestProperty("App-Id", APP_ID);
            // 往服务器端写内容 也就是发起http请求需要带的参数
            os = new DataOutputStream(connection.getOutputStream());
            Map<String, File> files = new HashMap<>();
            File newFile = transferToFile(file);
            files.put("file", newFile);
            writeFile(files, os);
            // 请求结束标志
            String endTarget = PREFIX + BOUNDARY + PREFIX + LINE_END;
            os.write(endTarget.getBytes());
            os.flush();
            newFile.delete();
            if (connection.getResponseCode() == 200) {
                input = connection.getInputStream();
            } else {
                input = connection.getErrorStream();
            }

            br = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
            buffer = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                buffer.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return buffer;
    }

    /**
     * @description: 写入图片
     * @params: requestFile os
     * @return: void
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 7/15/19
     */

    private static void writeFile(Map<String, File> requestFile,
                                  OutputStream os) throws Exception {
        InputStream is = null;
        try {
            StringBuilder msg = new StringBuilder("请求上传文件部分:\n");
            if (requestFile == null || requestFile.isEmpty()) {
                msg.append("空");
            } else {
                StringBuilder requestParams = new StringBuilder();
                Set<Map.Entry<String, File>> set = requestFile.entrySet();
                Iterator<Map.Entry<String, File>> it = set.iterator();
                while (it.hasNext()) {
                    Map.Entry<String, File> entry = it.next();
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
     * @Description: 获取内容类型
     * @Param: file
     * @return: String
     * @Author: YuJian
     * @date: 7/7/19
     */

    private static String getContentType(File file) throws Exception {
        String streamContentType = "application/octet-stream";
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
     * @description: 转换为图片
     * @params: multipartFile
     * @return:
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 7/15/19
     */

    private static File transferToFile(MultipartFile multipartFile) {
        final int MEMORY_SIZE = 4096;
        int n;
        File f;
        // 创建文件
        f = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        try (InputStream in = multipartFile.getInputStream(); OutputStream os = new FileOutputStream(f)) {
            // 得到文件流。以文件流的方式输出到新文件
            // 可以使用byte[] ss = multipartFile.getBytes();代替while
            byte[] buffer = new byte[4096];
            while ((n = in.read(buffer, 0, MEMORY_SIZE)) != -1) {
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
