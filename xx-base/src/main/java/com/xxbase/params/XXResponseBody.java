package com.xxbase.params;

import com.alibaba.fastjson.JSON;

/**
 * Created by admin on 16/05/19.
 */
public class XXResponseBody<T> {

    public static final int CODE_RIGHT = 0;

    public static final int CODE_TIP_PARAM_ERROR = 100;

    private XXResponseBody(){}


    public static String success(){
        return JSON.toJSONString(new Body());
    }

    public static String success(Object data){
        return JSON.toJSONString(new Body(data));
    }

    public static String failure(int code, String message){
        return JSON.toJSONString(new Body<>(code, message));
    }

   static class Body<T>{

        private int code = CODE_RIGHT;
        private String message;
        private T data;

       public Body() {
       }

       public Body(T t) {
           this.data = t;
       }

        public Body(int code, String message) {
            this.code = code;
            this.message = message;
        }

        public Body(int code, String message, T data) {
            this.code = code;
            this.message = message;
            this.data = data;
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

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }

}
