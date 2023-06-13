package com.server.utils;

public class RegexUtils {

    /**
     * 是否为有效日期
     * @param str
     * @return
     */
    public static boolean isDate(String str){
        return str.matches("\\d{4}\\-\\d{1,2}\\-\\d{1,2}");
    }

    /**
     * 是否为有效邮箱
     * @param str
     * @return
     */
    public static boolean isEmail(String str){
        return str.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
    }

    /**
     * 是否为强密码
     * (必须包含大小写字母和数字的组合，不能使用特殊字符，长度在8-10之间)
     * @param str
     * @return
     */
    public static boolean isPassword(String str){
        return str.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,10}$");
    }

    /**
     * 是否为手机号码
     * @param str
     * @return
     */
    public static boolean isMobilePhone(String str){
        return str.matches("^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$");
    }
}
