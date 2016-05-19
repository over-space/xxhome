package com.xxbase.params;

/**
 * Created by admin on 16/05/19.
 */
public class XXResponseBody<T>{

    private static final int CODE_RIGHT = 0;

    private int code = Integer.valueOf(CODE_RIGHT);

    private String message;

    private T result;

    public XXResponseBody() {
    }

    public XXResponseBody(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public XXResponseBody(T result){
        this.result = result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
