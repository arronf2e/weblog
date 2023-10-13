package com.weblog.common.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BizException extends RuntimeException{
    private int code;
    private String errorMessage;

    public BizException(BaseExceptionInterface baseExceptionInterface) {
        this.code = baseExceptionInterface.getCode();
        this.errorMessage = baseExceptionInterface.getErrorMessage();
    }
}
