package com.shinemo.uban.param.CardParam;

import com.shinemo.uban.param.BaseParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/13
 * Time: 11:47
 */
@Setter
@Getter
@NoArgsConstructor
public class CardRuleSetParam extends BaseParam {
    // 订阅号码
    private String mobile;
    // 模板ID
    private Long templateId;
    // 变量map
    private List<String> vars;
    // 开始日期  "20160401"
    private String startTime;
    // 结束日期 "20160401"
    private String endTime;
    // 生效时间
    private String effectiveTime;
    // 失效时间
    private String failureTime;
    // 星期设置 "1111100"
    private String week;
}
