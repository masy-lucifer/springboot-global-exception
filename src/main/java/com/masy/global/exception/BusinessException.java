package com.masy.global.exception;

/**
 * @ClassName BusinessException
 * @Description 业务异常
 * @Author masy
 * @Date 2023/4/322:18
 **/
public class BusinessException extends RuntimeException {

    private ErrorCode errorCode;

    public BusinessException() {
        this.errorCode = ErrorCode.FAIL;
    }

    public BusinessException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
