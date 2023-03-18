package com.fj.generate.utils;

/**
 * <p>
 * annotation
 * </P>
 *
 * @Author 10302
 * @Date 2023/3/16 15:57
 */
public enum ResultCode {
    SUCCESS(200, "SUCCESS"),
    FAILURE(400, "FAILURE"),
    UN_LOGIN(401, "未登录"),
    UNAUTHORIZED(403, "未认证或Token失效"),
    USER_UNAUTHORIZED(402, "用户名或密码不正确"),
    NOT_FOUND(404, "接口不存在"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误");

    private int code;
    private String msg;

    private ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
