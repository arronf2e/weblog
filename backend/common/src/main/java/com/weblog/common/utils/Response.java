package com.weblog.common.utils;

import com.weblog.common.exception.BaseExceptionInterface;
import com.weblog.common.exception.BizException;
import lombok.Data;

import java.io.Serializable;

@Data
public class Response<T> implements Serializable {
    private boolean success = true;
    private String message;
    private int code = 0;
    private T data;

    // =================================== 成功响应 ===================================
    public static <T> Response<T> success() {
        Response<T> response = new Response<>();
        return response;
    }

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setData(data);
        return response;
    }

    // =================================== 失败响应 ===================================
    public static <T> Response<T> fail(String errorMessage) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setMessage(errorMessage);
        return response;
    }

    public static <T> Response<T> fail(int code, String errorMessage) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setCode(code);
        response.setMessage(errorMessage);
        return response;
    }

    public static <T> Response<T> fail(BaseExceptionInterface baseExceptionInterface) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setCode(baseExceptionInterface.getCode());
        response.setMessage(baseExceptionInterface.getErrorMessage());
        return response;
    }

    public static <T> Response<T> fail(BizException bizException) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setCode(bizException.getCode());
        response.setMessage(bizException.getErrorMessage());
        return response;
    }
}
