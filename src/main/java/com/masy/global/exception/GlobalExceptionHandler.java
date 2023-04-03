package com.masy.global.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * @ClassName GlobalExceptionHandler
 * @Description 全局异常拦截
 * @Author masy
 * @Date 2023/4/322:18
 **/
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 空指针异常
     *
     * @param e 异常
     * @return com.masy.global.exception.Result<?>
     * @author masy
     * @date 2023/4/3 22:46
     */
    @ExceptionHandler(value = NullPointerException.class)
    public Result<?> handler(NullPointerException e) {
        return Result.fail(ErrorCode.SYSTEM_ERROR);
    }

    /**
     * 参数异常
     *
     * @param e 异常
     * @return com.masy.global.exception.Result<?>
     * @author masy
     * @date 2023/4/3 22:46
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result<?> handler(MethodArgumentNotValidException e) {
        return Result.fail(ErrorCode.PARAM_ERROR);
    }

    /**
     * 捕获业务异常
     *
     * @param e 异常
     * @return com.masy.global.exception.Result<?>
     * @author masy
     * @date 2023/4/3 22:46
     */
    @ExceptionHandler(value = BusinessException.class)
    public Result<?> handler(BusinessException e) {
        return Result.fail(e.getErrorCode());
    }

    /**
     * 捕获其他异常
     *
     * @param e 异常
     * @return com.masy.global.exception.Result<?>
     * @author masy
     * @date 2023/4/3 22:46
     */
    @ExceptionHandler(value = Exception.class)
    public Result<?> handler(Exception e) {
        return Result.fail(ErrorCode.FAIL);
    }
}
