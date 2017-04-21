package com.shinemo.uban.param.ConfParam;

import com.shinemo.uban.param.BaseParam;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/13
 * Time: 13:53
 */
@Setter
@Getter
@NoArgsConstructor
public class ConfMuteParam extends BaseParam {
    // 会议ID
    private Long confId;
    // 参加会议手机号列表
    private List<String> mobiles;
    // 是否静音 true:静音  false:取消静音
    private boolean isMute;
}
