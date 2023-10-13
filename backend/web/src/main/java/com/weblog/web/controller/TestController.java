package com.weblog.web.controller;

import com.weblog.common.aspect.ApiOperationLog;
import com.weblog.common.enums.ResponseCodeEnum;
import com.weblog.common.exception.BizException;
import com.weblog.common.utils.Response;
import com.weblog.web.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TestController {
    @PostMapping("/test")
    @ApiOperationLog(description = "测试接口")
    public Response test(@RequestBody @Validated User user) {
        return Response.success();
    }
}
