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
public class CardAddParam extends BaseParam {
    // 订阅号码
    private String mobile;
    // 业务类型 0:主叫 1：被叫 2：主被叫
    private Integer bizType;
}
