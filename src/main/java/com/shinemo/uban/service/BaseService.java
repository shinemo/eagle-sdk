package com.shinemo.uban.service;

import com.shinemo.uban.config.EgConstant;
import com.shinemo.uban.param.BaseParam;
import com.shinemo.uban.param.Result;
import com.shinemo.uban.utils.UbHttpClient;
import com.shinemo.uban.utils.UbJsonUtils;
import com.shinemo.uban.utils.UbRandomStringUtils;
import com.shinemo.uban.utils.UbSignUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/13
 * Time: 11:25
 */
public class BaseService {

    public Result invoke(BaseParam baseParam,String uri) throws Exception{
        String param = UbJsonUtils.toJson(baseParam);
        Map<String, String> header = getRequestHeader();
        String result = UbHttpClient.PostJsonRequest(EgConstant.EAGLE_URL + uri, header, param);
        return UbJsonUtils.fromJson(result, Result.class);
    }

    private Map<String, String> getRequestHeader() {
        String nonce = UbRandomStringUtils.randomNumStr(4);
        String secret = "****"; // 密钥
        String account = "****"; // 登录账号
        String timestamp = System.currentTimeMillis() + "";
        String sign = UbSignUtils.generateSign(account, nonce, timestamp, secret);
        Map<String, String> head = new HashMap<String, String>(4);
        head.put("nonce", nonce);
        head.put("account", account);
        head.put("timestamp", timestamp);
        head.put("sign", sign);
        return head;
    }
}
