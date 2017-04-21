package com.shinemo.uban.utils;

import java.io.*;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/13
 * Time: 10:58
 */
public class UbMD5Utils {
    protected static char[] hexDigits = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public UbMD5Utils() {
    }

    public static String digest(String inStr) {
        Object byteArray = null;

        byte[] var9;
        try {
            var9 = inStr.getBytes("UTF-8");
        } catch (UnsupportedEncodingException var91) {
            var91.printStackTrace();
            return null;
        }

        MessageDigest messagedigest = null;

        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException var8) {
            var8.printStackTrace();
            return null;
        }

        byte[] md5Bytes = messagedigest.digest(var9);
        StringBuffer hexValue = new StringBuffer();

        for(int i = 0; i < md5Bytes.length; ++i) {
            int val = md5Bytes[i] & 255;
            if(val < 16) {
                hexValue.append("0");
            }

            hexValue.append(Integer.toHexString(val));
        }

        return hexValue.toString().toLowerCase();
    }

    public static String getMD5(InputStream is) throws NoSuchAlgorithmException, IOException {
        StringBuffer md5 = new StringBuffer();
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] dataBytes = new byte[1024];
        boolean nread = false;

        int var7;
        while((var7 = is.read(dataBytes)) != -1) {
            md.update(dataBytes, 0, var7);
        }

        byte[] mdbytes = md.digest();

        for(int i = 0; i < mdbytes.length; ++i) {
            md5.append(Integer.toString((mdbytes[i] & 255) + 256, 16).substring(1));
        }

        return md5.toString();
    }

    public static String getFileMD5String(File file) throws IOException {
        FileInputStream in = new FileInputStream(file);
        FileChannel ch = in.getChannel();
        MappedByteBuffer byteBuffer = ch.map(FileChannel.MapMode.READ_ONLY, 0L, file.length());
        MessageDigest messagedigest = null;

        try {
            messagedigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException var6) {
            var6.printStackTrace();
        }

        messagedigest.update(byteBuffer);
        in.close();
        return bufferToHex(messagedigest.digest());
    }

    private static String bufferToHex(byte[] bytes) {
        return bufferToHex(bytes, 0, bytes.length);
    }

    private static String bufferToHex(byte[] bytes, int m, int n) {
        StringBuffer stringbuffer = new StringBuffer(2 * n);
        int k = m + n;

        for(int l = m; l < k; ++l) {
            char c0 = hexDigits[(bytes[l] & 240) >> 4];
            char c1 = hexDigits[bytes[l] & 15];
            stringbuffer.append(c0);
            stringbuffer.append(c1);
        }

        return stringbuffer.toString();
    }

    public static String encodeMD5(String str) {
        return encode(str, "MD5");
    }

    private static String encode(String str, String method) {
        MessageDigest md = null;
        String dstr = null;

        try {
            md = MessageDigest.getInstance(method);
            md.update(str.getBytes());
            dstr = (new BigInteger(1, md.digest())).toString(16);
        } catch (NoSuchAlgorithmException var5) {
            var5.printStackTrace();
        }

        return dstr;
    }
}
