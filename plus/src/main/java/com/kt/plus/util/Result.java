package com.kt.plus.util;

public class Result<T> {
    /**
     *成功标志
     */
    private boolean success =true;
    /**
     *返回处理消息
     */
    private String message ="操作成功";
    /**
     * 返回消息的状态码
     */
    private int code=0;
    /**
     * 返回的数据
     */
    private T result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
    public void ok(String message){
        this.message=message;
        this.success=true;
    }
    public void error(String message){
        this.message=message;
        this.success=false;
    }
}
