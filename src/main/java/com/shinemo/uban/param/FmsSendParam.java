package com.shinemo.uban.param;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/13
 * Time: 14:27
 */
@Setter
@Getter
@NoArgsConstructor
public class FmsSendParam extends BaseParam {
    // 接收者手机号
    private String to;
    // 闪信签名内容
    private String fmsSign;
    // 闪信模板ID
    private Long fmsTemplateId;
    // 参数
    private Map<String, String> paramValue;
}
