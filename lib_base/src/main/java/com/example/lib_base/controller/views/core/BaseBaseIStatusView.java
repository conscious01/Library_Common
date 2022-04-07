package com.example.lib_base.controller.views.core;

public interface BaseBaseIStatusView extends BaseIView {

    /**
     * 加载
     */
    void loading();

    /**
     * 离线、无网络
     */
    default void offline() {
    }

    /**
     * 失败
     */
    void failure(Throwable throwable);

    default void failureWithMethodName(Throwable throwable, String methodName) {
    }

    /**
     * 完成请求
     */
    default void complete() {
    }

    default void completeWithMethodName(String methodName) {
    }


    /**
     * 空数据
     */
    default void empty(CharSequence charSequence) {

    }

}
