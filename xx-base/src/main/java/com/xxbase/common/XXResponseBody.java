package com.xxbase.common;

/**
 * Created by admin on 16/05/19.
 */
public class XXResponseBody<T> {

    /**
     * 错误状态码约定：
     * errorCode == 0 , 返回结果完全正确
     * errorCode == 100，前端所传参数有错
     * errorCode == 1000，验证码输入错误
     * errorCode == 1000000，未知的异常
     */

    public static final int CODE_RIGHT = 0;

    public static final int CODE_PARAM_ERROR = 100;
    public static final String MESSAGE_PARAM_ERROR = "参数错误，请检查表单是否填写完整!";

    public static final int CODE_CAPTCHA_ERROR = 1000;
    public static final String MESSAGE_CAPTCHA_ERROR = "验证码输入错误!";

    public static final int CODE_UNKNOWN_EXCEPTION = 1000000;
    public static final String MESSAGE_UNKNOWN_EXCEPTION = "程序猿偷懒了，系统程序未知的BUG!";


    private int errorCode = CODE_RIGHT;

    private String message = "";

    private T data;


    public XXResponseBody() {
    }

    public XXResponseBody(T data) {
        this.data = data;
    }

    public XXResponseBody(int errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
