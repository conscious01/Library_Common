package com.common.lib_base.base_view;

import com.blankj.utilcode.util.LogUtils;

import java.util.List;


public class BaseResListEntity<T> {

    private List<T> rows;
    private int code;
    private String msg;
    private String methodName;
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    private int page,pageSize;
    public boolean hasMore() {
        return (page * pageSize) < total;
    }


    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public BaseResListEntity() {
    }

    public BaseResListEntity(List<T>  rows) {
        this.code = 0;
        this.rows = rows;
    }

    public BaseResListEntity(List<T>  rows, int code, String msg) {
        this.rows = rows;
        this.code = code;
        this.msg = msg;
    }

    public BaseResListEntity(List<T> rows, int code, String msg, String methodName) {
        this.rows = rows;
        this.code = code;
        this.msg = msg;
        this.methodName = methodName;
        LogUtils.i(code,msg,methodName);
    }


    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public List<T>  getRows() {
        return rows;
    }


    @Override
    public String toString() {
        return "BasicResponseEntity{" +
                "data=" + rows +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", methodName='" + methodName + '\'' +
                '}';
    }
}
