package com.shinemo.uban.param.ConfParam;

import com.shinemo.uban.param.BaseParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/13
 * Time: 13:53
 */
@Setter
@Getter
@NoArgsConstructor
public class ConfCreateParam extends BaseParam{
    // 显示号码
    private String displayNbr;
    // 主叫手机号码
    private String callerMobile;
    // 状态通知地址
    private String notifyUrl;
}
