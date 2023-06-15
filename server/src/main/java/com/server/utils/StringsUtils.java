package com.server.utils;

import org.springframework.util.DigestUtils;

import java.util.UUID;

public class StringsUtils {

    /**
     * 对字符串进行md5加密
     * @param str
     * @return
     */
    public static String toMD5(String str){
        return DigestUtils.md5DigestAsHex((str).getBytes());
    }

    /**
     * 生成32位id
     * @param str
     * @return
     */
    public static String makeId(String str){
        str+=System.currentTimeMillis();
        String s=UUID.nameUUIDFromBytes(str.getBytes()).toString();
        String[] split = s.split("-");
        String res="";
        for (int i = 0; i < split.length; i++) {
            res+=split[i];
        }
        return res;
    }
}
