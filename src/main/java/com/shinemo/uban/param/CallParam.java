package com.shinemo.uban.param;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/13
 * Time: 12:10
 */
@Setter
@Getter
@NoArgsConstructor
public class CallParam extends BaseParam {
    // 显示号码
    private String displayNbr;
    // 主叫手机号
    private String callerMobile;
    // 被叫手机号
    private String calleeMobile;
    // 状态通知地址
    private String notifyUrl;
}
