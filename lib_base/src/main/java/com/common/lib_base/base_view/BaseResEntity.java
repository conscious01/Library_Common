package com.common.lib_base.base_view;

import com.blankj.utilcode.util.LogUtils;


public class BaseResEntity<T> {

    private T data;
    private int code;
    private String msg;
    private boolean success;


    public BaseResEntity() {
    }

    public BaseResEntity(T data) {
        this.code = 0;
        this.data = data;
    }

    public BaseResEntity(T data, int code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }


    public BaseResEntity(T data, int code, String msg, boolean success) {
        this.data = data;
        this.code = code;
        this.msg = msg;
        this.success = success;
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
                '}';
    }
}
