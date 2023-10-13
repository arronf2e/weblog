package com.weblog.web.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@ApiModel(value = "用户实体类")
public class User {
    // 用户名
    @NotBlank(message = "用户名不能为空")
    private String username;
    // 性别
    private Integer sex;

    private LocalDateTime createTime;
    private LocalDate updateDate;
    private LocalTime time;
}
