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
public class ConfCloseParam extends BaseParam{
    // 会议ID
    private Long confId;
}
