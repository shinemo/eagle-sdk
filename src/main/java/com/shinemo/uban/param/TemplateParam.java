package com.shinemo.uban.param;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/13
 * Time: 12:01
 */
@Setter
@Getter
@NoArgsConstructor
public class TemplateParam extends BaseParam {
    // 配置名称
    private String name;
    // 配置内容
    private String content;
}
