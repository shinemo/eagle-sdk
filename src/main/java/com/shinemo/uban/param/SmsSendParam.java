package com.shinemo.uban.param;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

/**
 * 短信发送参数集
 * User: huangyuting
 * Mail: huangyt@shinemo.com
 * Date: 2017/1/13
 * Time: 上午10:33
 */
@Setter
@Getter
@NoArgsConstructor
public class SmsSendParam extends BaseParam{
    // 接收者手机号
    private String to;
    // 短信签名内容
    private String smsSign;
    // 短信模板ID
    private Long smsTemplateId;
    // 参数
    private Map<String, String> paramValue;
}
