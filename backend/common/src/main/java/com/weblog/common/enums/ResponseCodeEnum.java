package com.weblog.common.enums;

import com.weblog.common.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCodeEnum implements BaseExceptionInterface {

    // ----------- 通用异常状态码 -----------
    SYSTEM_ERROR(10000, "出错啦，后台小哥正在努力修复中..."),
    PARAM_NOT_VALID(10001, "参数错误"),

    // ----------- 登录异常状态码 -----------
    LOGIN_FAIL(20000, "登录失败"),
    USERNAME_OR_PWD_ERROR(20001, "用户名或密码错误"),
    UNAUTHORIZED(20002, "无访问权限，请先登录！"),

    // ----------- 业务异常状态码 -----------
    PRODUCT_NOT_FOUND(20000, "该产品不存在（测试使用）"),
    ;

    private int code;
    // 错误信息
    private String errorMessage;
}
