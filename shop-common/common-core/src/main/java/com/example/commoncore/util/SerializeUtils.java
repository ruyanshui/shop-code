package com.example.commoncore.util;

import java.io.*;

/**
 * 序列化工具类
 */
public class SerializeUtils {

    /**
     * 序列化对象
     * @param obj 创建一个对象
     * @return 字节流byte
     */
    public static byte[] doSerialize(Object obj){
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;

        baos = new ByteArrayOutputStream();

        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);

            byte[] byteArray = baos.toByteArray();
            return  byteArray;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 反序列化对象
     * @param byteArray 字节流byte
     * @return 返回一个对象
     */
    public static Object unSerialize(byte[] byteArray){
        ByteArrayInputStream bais = null;
        bais = new ByteArrayInputStream(byteArray);
        try {
            ObjectInputStream ois = new ObjectInputStream(bais);
            return  ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
