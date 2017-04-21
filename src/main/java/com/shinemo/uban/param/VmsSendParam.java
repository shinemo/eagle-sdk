package com.shinemo.uban.param;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/13
 * Time: 14:34
 */
@Setter
@Getter
@NoArgsConstructor
public class VmsSendParam extends BaseParam {
    // 显示号码
    private String displayNbr;
    // 被叫手机号
    private String calleeMobile;
    // 语音签名
    private String vmsSign;
    // 短信模板ID
    private Long ttsTemplateId;
    // 重播次数
    private Integer replayTimes;
    // 状态通知地址
    private String notifyUrl;
    // 参数
    private Map<String, String> paramValue;
}
