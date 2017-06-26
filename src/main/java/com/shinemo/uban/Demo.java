package com.shinemo.uban;

import com.shinemo.uban.param.Result;
import com.shinemo.uban.param.SmsSendParam;
import com.shinemo.uban.service.EgSmsSendService;
import com.shinemo.uban.utils.UbJsonUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 发送短信Demo
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/6/26
 * Time: 10:57
 */
public class Demo {
    public static void main(String[] args) throws Exception {
        SmsSendParam smsSendParam = new SmsSendParam();
        smsSendParam.setTo("18368497687");// 接收手机号
        smsSendParam.setSmsSign("讯盟科技");// uban官网申请的短信签名
        smsSendParam.setSmsTemplateId(90L);// uban官网申请的短信模板ID
        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("1", "大家好");// 短信模板中的变量
        smsSendParam.setParamValue(paramMap);

        EgSmsSendService egSmsSendService = new EgSmsSendService();
        egSmsSendService.setAccount("*****");// uban管理中心的用户资料中的账号ID
        egSmsSendService.setSecret("*****");// uban管理中心的用户资料中的加密秘钥
        Result result = egSmsSendService.send(smsSendParam);
        System.out.println(UbJsonUtils.toJson(result).toString());
    }
}
