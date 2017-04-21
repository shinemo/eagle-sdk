package com.shinemo.uban.service;

import com.shinemo.uban.config.EgConstant;
import com.shinemo.uban.param.Result;
import com.shinemo.uban.param.SmsSendParam;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/12
 * Time: 17:41
 */
public class EgSmsSendService extends BaseService {
    /**
     * 发送短信
     *
     * @param smsSendParam
     * @return
     * @throws Exception
     */
    public Result send(SmsSendParam smsSendParam) throws Exception {
        return invoke(smsSendParam, EgConstant.SEND_SMS_URI);
    }
}
