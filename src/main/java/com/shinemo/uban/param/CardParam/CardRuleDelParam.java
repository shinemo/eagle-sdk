package com.shinemo.uban.param.CardParam;

import com.shinemo.uban.param.BaseParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/13
 * Time: 11:47
 */
@Setter
@Getter
@NoArgsConstructor
public class CardRuleDelParam extends BaseParam {
    // 用户手机号码
    private String mobile;
}
