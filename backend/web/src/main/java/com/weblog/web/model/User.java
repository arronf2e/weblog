package com.weblog.web.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class User {
    // 用户名
    @NotBlank(message = "用户名不能为空")
    private String username;
    // 性别
    private Integer sex;
}
