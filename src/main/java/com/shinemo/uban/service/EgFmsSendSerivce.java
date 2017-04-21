package com.shinemo.uban.service;

import com.shinemo.uban.config.EgConstant;
import com.shinemo.uban.param.FmsSendParam;
import com.shinemo.uban.param.Result;
import com.shinemo.uban.param.SmsSendParam;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/13
 * Time: 14:29
 */
public class EgFmsSendSerivce extends BaseService {
    /**
     * 发送闪信（弾屏）
     * @param fmsSendParam
     * @return
     * @throws Exception
     */
    public Result send(FmsSendParam fmsSendParam) throws Exception {
        return invoke(fmsSendParam, EgConstant.SEND_FMS_URI);
    }
}
