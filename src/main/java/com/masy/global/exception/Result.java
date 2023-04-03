package com.masy.global.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @ClassName Result
 * @Description 返回值封装
 * @Author masy
 * @Date 2023/4/322:18
 **/
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1581329103599839148L;
    private boolean success;

    private Integer code;

    private String msg;

    private T data;

    private LocalDateTime timestamp = LocalDateTime.now();

    public Result() {
        this.success = true;
        this.code = ErrorCode.SUCCESS.getCode();
        this.msg = ErrorCode.SUCCESS.getMsg();
    }

    public Result(boolean success) {
        this.success = success;
        this.code = success ? ErrorCode.SUCCESS.getCode() : ErrorCode.FAIL.getCode();
        this.msg = success ? ErrorCode.SUCCESS.getMsg() : ErrorCode.FAIL.getMsg();
        this.timestamp = LocalDateTime.now();
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static <T> Result<T> success() {
        Result<T> res = new Result<>();
        res.setSuccess(true);
        res.setCode(ErrorCode.SUCCESS.getCode());
        res.setMsg(ErrorCode.SUCCESS.getMsg());
        return res;
    }

    public static <T> Result<T> success(T data) {
        Result<T> res = new Result<>();
        res.setSuccess(true);
        res.setCode(ErrorCode.SUCCESS.getCode());
        res.setMsg(ErrorCode.SUCCESS.getMsg());
        res.setData(data);
        return res;
    }

    public static <T> Result<T> fail(ErrorCode errorResponse) {
        Result<T> res = new Result<>();
        res.setSuccess(false);
        res.setCode(errorResponse.getCode());
        res.setMsg(errorResponse.getMsg());
        return res;
    }

    public static <T> Result<T> fail(ErrorCode errorResponse, T data) {
        Result<T> res = new Result<>();
        res.setSuccess(false);
        res.setCode(errorResponse.getCode());
        res.setMsg(errorResponse.getMsg());
        res.setData(data);
        return res;
    }

    public boolean isSuccess() {
        return success;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
