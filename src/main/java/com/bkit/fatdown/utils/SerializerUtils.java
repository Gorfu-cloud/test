package com.bkit.fatdown.utils;

import org.springframework.stereotype.Component;

import java.io.*;


/**
 * @FileName: SerializerUtil
 * @Author: YuJian
 * @Description: //TODO
 * @Date: Created in 7/5/19  11:19 PM
 * @Modified:
 * @Version: 1.0.0
 */

@Component
public class SerializerUtils {

    /**
     * @Description: 获取key序列化后byte
     * @Param: String
     * @return: byte[]
     * @Author: YuJian
     * @date: 7/5/19
     */

    public static byte[] serializeKey(String key) {
        return key.getBytes();
    }

    /**
     * @Description: 获取对象序列后的值
     * @Param: Object
     * @return: byte[]
     * @Author: YuJian
     * @date: 7/5/19
     */

    public static byte[] serializeValue(Object object) {
        return serialize(object);
    }

    /**
     * @Description: 获取对象序列化后的byte
     * @Param: byte[]
     * @return: Object
     * @Author: YuJian
     * @date: 7/5/19
     */

    public static Object deserializeValue(byte[] bytes) {
        return deSerialize(bytes);
    }

    /**
     * @Description: 还原序列化byte为String
     * @Param: byte[]
     * @return: String
     * @Author: YuJian
     * @date: 7/5/19
     */

    public static String deserializeKey(byte[] bytes) {
        return new String(bytes);
    }

    /**
     * @Description: 获取对象序列化byte
     * @Param: Object
     * @return: byte[]
     * @Author: YuJian
     * @date: 7/5/19
     */

    public static byte[] serialize(Object obj) {
        byte[] bytes = null;
        try {
            ByteArrayOutputStream byteArrayOPS = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(byteArrayOPS);
            oos.writeObject(obj);
            bytes = byteArrayOPS.toByteArray();
            byteArrayOPS.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    /**
     * @Description: 还原序列化byte为对象
     * @Param: byte[]
     * @return: Object
     * @Author: YuJian
     * @date: 7/5/19
     */

    public static Object deSerialize(byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            obj = ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

}
