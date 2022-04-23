package com.common.lib_base.base_view;

import com.blankj.utilcode.util.LogUtils;


public class BaseResponseEntity<T> {

    private T data;
    private int code;
    private String msg;
    private boolean success;
    private String methodName;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
        LogUtils.i(methodName);
    }

    public BaseResponseEntity() {
    }

    public BaseResponseEntity(T data) {
        this.code = 0;
        this.data = data;
    }

    public BaseResponseEntity(T data, int code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }


    public BaseResponseEntity(T data, int code, String msg, boolean success) {
        this.data = data;
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    public BaseResponseEntity(T data, int code, String msg, String methodName) {
        this.data = data;
        this.code = code;
        this.msg = msg;
        this.methodName = methodName;
        LogUtils.i(code, msg, methodName);
    }

    public boolean isSucceed() {
        return code == 0;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public T getData() {
        return data;
    }


    @Override
    public String toString() {
        return "BasicResponseEntity{" +
                "data=" + data +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", methodName='" + methodName + '\'' +
                '}';
    }
}
