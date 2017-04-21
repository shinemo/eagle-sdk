package com.shinemo.uban.service;

import com.shinemo.uban.config.EgConstant;
import com.shinemo.uban.param.CallParam;
import com.shinemo.uban.param.Result;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/13
 * Time: 12:10
 */
public class EgCallService extends BaseService {
    /**
     * 语音通话
     * @param callParam
     * @return
     * @throws Exception
     */
    public Result call(CallParam callParam) throws Exception {
        return invoke(callParam, EgConstant.CALL_CALL_URI);
    }
}
