package com.bkit.fatdown.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @file: HttpRequestUtil
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: Http工具类
 * @date: Created in 2019/7/12  13:18
 * @modified:
 * @version: 1.0
 */

public class HttpRequestUtil {

    /**
     * @description: //TODO
     * @params:
     * @return:
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 2019/7/10
     */

    @Deprecated
    public static String sendPost(String url, String param) {
        return sendGet(url, param);
    }


    /**
     * @description: 发起http链接
     * @params: url, param
     * @return: String
     * @author: <a href="https://yujian95.cn/about/">YuJian</a>
     * @date: 2019/7/12
     */

    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 读取结果
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.err.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }

}