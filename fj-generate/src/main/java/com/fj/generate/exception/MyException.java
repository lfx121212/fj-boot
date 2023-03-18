package com.fj.generate.exception;

/**
 * <p>
 * 自定义异常类
 * </P>
 *
 * @Author 10302
 * @Date 2023/3/16 15:53
 */
public class MyException extends RuntimeException  {
    public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(Throwable cause) {
        super(cause);
    }
}
