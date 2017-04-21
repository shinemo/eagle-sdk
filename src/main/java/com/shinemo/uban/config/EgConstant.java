package com.shinemo.uban.config;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/12
 * Time: 17:47
 */
public class EgConstant {
    // 前缀
    public final static String EAGLE_URL = "https://eagle.jituancaiyun.com/eagle";

    // 发送短信
    public final static String SEND_SMS_URI = "/sms/send.json";

    // 注册名片
    public final static String ADD_CARD_URI = "/card/add.json";
    // 取消名片
    public final static String DEL_CARD_URI = "/card/del.json";
    // 设置名片规则
    public final static String SET_CARD_RULE_URI = "/card/rule/set.json";
    // 删除名片规则
    public final static String DEL_CARD_RULE_URI = "/card/rule/del.json";

    // 添加名片模板
    public final static String ADD_TEMPLATE_URI = "/template/add.json";
    // 删除名片模板
    public final static String DEL_TEMPLATE_URI = "/template/del.json";

    // 语音通话
    public final static String CALL_CALL_URI = "/call/call.json";

    // 创建电话会议
    public final static String CREATE_CONF_URI = "/conf/create.json";
    // 关闭电话会议
    public final static String CLOSE_CONF_URI = "/conf/close.json";
    // 加入电话会议
    public final static String JOIN_CONF_URI = "/conf/join.json";
    // 离开电话会议
    public final static String LEAVE_CONF_URI = "/conf/leave.json";
    // 静音
    public final static String MUTE_CONF_URI = "/conf/mute.json";
    // 查询电话会议状态
    public final static String QUERY_CONF_URI = "/conf/query.json";

    // 发送闪信
    public final static String SEND_FMS_URI = "/fms/send.json";

    // 发送语音
    public final static String SEND_VMS_URI = "/vms/send.json";

}
