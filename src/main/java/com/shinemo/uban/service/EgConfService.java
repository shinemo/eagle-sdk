package com.shinemo.uban.service;

import com.shinemo.uban.config.EgConstant;
import com.shinemo.uban.param.ConfParam.*;
import com.shinemo.uban.param.Result;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/13
 * Time: 14:04
 */
public class EgConfService extends BaseService {
    /**
     * 创建电话会议
     *
     * @param confCreateParam
     * @return
     * @throws Exception
     */
    public Result create(ConfCreateParam confCreateParam) throws Exception {
        return invoke(confCreateParam, EgConstant.CREATE_CONF_URI);
    }

    /**
     * 关闭电话会议
     *
     * @param confCloseParam
     * @return
     * @throws Exception
     */
    public Result close(ConfCloseParam confCloseParam) throws Exception {
        return invoke(confCloseParam, EgConstant.CLOSE_CONF_URI);
    }

    /**
     * 加入电话会议
     *
     * @param confJoinParam
     * @return
     * @throws Exception
     */
    public Result join(ConfJoinParam confJoinParam) throws Exception {
        return invoke(confJoinParam, EgConstant.JOIN_CONF_URI);
    }

    /**
     * 离开会议
     *
     * @param confLeaveParam
     * @return
     * @throws Exception
     */
    public Result leave(ConfLeaveParam confLeaveParam) throws Exception {
        return invoke(confLeaveParam, EgConstant.LEAVE_CONF_URI);
    }

    /**
     * 静音
     *
     * @param confMuteParam
     * @return
     * @throws Exception
     */
    public Result mute(ConfMuteParam confMuteParam) throws Exception {
        return invoke(confMuteParam, EgConstant.MUTE_CONF_URI);
    }

    /**
     * 查询会议状态
     *
     * @param confQueryParam
     * @return
     * @throws Exception
     */
    public Result query(ConfQueryParam confQueryParam) throws Exception {
        return invoke(confQueryParam, EgConstant.QUERY_CONF_URI);
    }
}
