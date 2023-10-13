package com.weblog.web.controller;

import com.weblog.common.aspect.ApiOperationLog;
import com.weblog.common.enums.ResponseCodeEnum;
import com.weblog.common.exception.BizException;
import com.weblog.common.utils.Response;
import com.weblog.web.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(tags = "首页模块")
public class TestController {
    @PostMapping("/test")
    @ApiOperationLog(description = "测试接口")
    @ApiOperation(value = "测试接口")
    public Response test(@RequestBody @Validated User user) {
        return Response.success();
    }
}
