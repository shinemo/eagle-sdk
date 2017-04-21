package com.shinemo.uban.utils;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/12
 * Time: 18:16
 */
public class UbIOUtils {
    public UbIOUtils() {
    }

    public static byte[] getBytesFromInputStream(InputStream input) throws Exception {
        try {
            ByteArrayOutputStream bao = new ByteArrayOutputStream(1024);
            byte[] bb = new byte[1024];

            int len;
            while((len = input.read(bb)) > 0) {
                bao.write(bb, 0, len);
            }

            byte[] var4 = bao.toByteArray();
            return var4;
        } finally {
            if(input != null) {
                input.close();
            }

        }
    }

    public static String getStringFromInputStream(InputStream input) throws Exception {
        byte[] bytes = getBytesFromInputStream(input);
        return new String(bytes, "UTF-8");
    }
}
