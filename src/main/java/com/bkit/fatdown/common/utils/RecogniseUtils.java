package com.bkit.fatdown.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestParam;
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
    private final static String BOUNDARY = UUID.randomUUID().toString().toLowerCase().replaceAll("-", "");
    private final static String PREFIX = "--";
    private final static String LINE_END = "\r\n";
    private final static String APP_SECRET = "4b69917eee2e45bbab36f8c1d9302514";
    private final static String APP_ID = "5d03342e61f1e975168ab559";
    private final static String ADDRESS = "https://open.jishiqi.net/api/v1/detect/img/detect";
    private final static Integer SUCCESS_CODE = 200;

    private static final Logger logger = LoggerFactory.getLogger(RecogniseUtils.class);

    /**
     * @description: 返回食物识别结果
     * @params:
     * @return:
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 7/23/19
     */
    public static JSONObject recognise(@RequestParam MultipartFile file) {
        URL url;
        InputStream input;
        OutputStream os;
        BufferedReader br;
        StringBuffer buffer = null;
        String requestId = System.currentTimeMillis() + "" + Math.round(Math.random() * 10000000);
        String s1 = DigestUtils.md5DigestAsHex(requestId.getBytes()).toUpperCase();
        String sign = DigestUtils.md5DigestAsHex((s1 + APP_SECRET).getBytes()).toUpperCase();
        try {
            // 服务地址
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
            Map<String, File> files = new HashMap<>(2);
            File newFile = DataTransferUtils.multipartFile2File(file);
            files.put("file", newFile);
            writeFile(files, os);
            // 请求结束标志
            String endTarget = PREFIX + BOUNDARY + PREFIX + LINE_END;
            os.write(endTarget.getBytes());
            os.flush();
            if (!newFile.delete()) {
                System.out.println(newFile.getName() + ":删除失败");
            }

            // 获取请求结果码
            if (connection.getResponseCode() == SUCCESS_CODE) {
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
        assert buffer != null;
        // 解析返回结果
        if (buffer.length()==0){
            return null;
        }
        return JSONObject.parseObject(buffer.toString());
    }

    /**
     * @description: 输出图片文件数据
     * @params:
     * @return:
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 7/22/19
     */
    private static void writeFile(Map<String, File> requestFile, OutputStream os) throws Exception {
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
                    int len;
                    while ((len = is.read(buffer)) != -1) {
                        os.write(buffer, 0, len);
                    }
                    os.write(LINE_END.getBytes());
                    os.flush();
                    msg.append(requestParams.toString());
                    logger.info(String.valueOf(msg));
                }
            }
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    /**
     * @description: 获取文件内容类型
     * @params:
     * @return:
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 7/22/19
     */
    private static String getContentType(File file) throws Exception {
        String streamContentType = "application/octet-stream";
        try (ImageInputStream image = ImageIO.createImageInputStream(file)) {
            if (image == null) {
                return streamContentType;
            }
            Iterator<ImageReader> it = ImageIO.getImageReaders(image);
            if (it.hasNext()) {
                String imageContentType;
                imageContentType = "image/" + it.next().getFormatName();
                return imageContentType;
            }
        } catch (IOException e) {
            throw new Exception(e);
        }
        return streamContentType;
    }
}
