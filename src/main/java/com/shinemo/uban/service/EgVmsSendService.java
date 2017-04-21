package com.shinemo.uban.service;

import com.shinemo.uban.config.EgConstant;
import com.shinemo.uban.param.Result;
import com.shinemo.uban.param.VmsSendParam;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/13
 * Time: 14:36
 */
public class EgVmsSendService extends BaseService {

    /**
     * 发送语音
     *
     * @param vmsSendParam
     * @return
     * @throws Exception
     */
    public Result send(VmsSendParam vmsSendParam) throws Exception {
        return invoke(vmsSendParam, EgConstant.SEND_VMS_URI);
    }
}
