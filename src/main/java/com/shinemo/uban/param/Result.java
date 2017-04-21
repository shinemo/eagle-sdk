package com.shinemo.uban.param;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * User: luchao
 * Mail: luc@shinemo.com
 * Date: 2017/4/13
 * Time: 11:26
 */
@Setter
@Getter
@NoArgsConstructor
public class Result {
    boolean success;
    Object data;
    String msg;
    int code;
}
