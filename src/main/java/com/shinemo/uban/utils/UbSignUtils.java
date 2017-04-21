package com.shinemo.uban.utils;

import java.util.Arrays;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/13
 * Time: 10:54
 */
public class UbSignUtils {
    /**
     * 生成签名
     *
     * @param account   账户
     * @param nonce     随机数
     * @param timestamp 时间戳
     * @param secret    秘钥
     * @return
     */
    public static String generateSign(String account, String nonce, String timestamp, String secret) {
        String[] arr = new String[]{account, nonce, timestamp, secret};
        Arrays.sort(arr);
        return UbMD5Utils.digest(arr[0] + arr[1] + arr[2] + arr[3]);
    }

    /**
     * 验签
     *
     * @param account
     * @param nonce
     * @param timestamp
     * @param secret
     * @param sign
     * @return
     */
    public static boolean checkSign(String account, String nonce, String timestamp, String secret, String sign) {
        return generateSign(account, nonce, timestamp, secret).equals(sign);
    }

    public static void main(String... args) {
        String account = "3s3DfszA";
        String nonce = UbRandomStringUtils.randomNumStr(8);
        long timestamp = System.currentTimeMillis();
        String secret = "n7*{e^O&PACYHD)Yj8VgOOV2K~^*M+(c";

        System.out.println("account:" + account);
        System.out.println("nonce:" + nonce);
        System.out.println("timestamp:" + timestamp);
        System.out.println("secret:" + secret);
        System.out.println("sign:" + generateSign(account, nonce, timestamp + "", secret));
    }
}
