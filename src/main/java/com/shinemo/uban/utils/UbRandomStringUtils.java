package com.shinemo.uban.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/13
 * Time: 10:12
 */
public class UbRandomStringUtils {

    public static String randomNumStr(int length) {
        return randomStr("0123456789", length);
    }

    public static String randomStr(String baseStr, int length) {
        if(StringUtils.isBlank(baseStr)) {
            baseStr = "`1234567890-=~!@#$%^&*()_+{}qwertyuioplkjhgfdsazxcvbnm<>QWERTYUIOPLKJHGFDSAZXCVBNM";
        }

        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < length; ++i) {
            int number = random.nextInt(baseStr.length());
            sb.append(baseStr.charAt(number));
        }

        return sb.toString();
    }
}
