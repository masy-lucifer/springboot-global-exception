package com.masy.global.exception;

/**
 * @ClassName ErrorCode
 * @Description 错误码枚举
 * @Author masy
 * @Date 2023/4/322:18
 **/
public enum ErrorCode {


    /*成功*/
    SUCCESS(0, "成功"),
    FAIL(500, "失败"),

    SYSTEM_ERROR(10000, "系统异常"),

    PARAM_ERROR(10100, "参数异常"),

    USER_AUTH_FAIL(20001, "用户鉴权失败"),
    ;
    private Integer code;
    private String msg;

    ErrorCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static String getMsgByCode(Integer code) {
        for (ErrorCode ec : values()) {
            if (ec.getCode().equals(code)) {
                return ec.getMsg();
            }
        }
        return null;
    }
}
