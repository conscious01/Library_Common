package com.common.lib_base.network.views;

public interface BaseIStatusView extends BaseIView {

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


    /**
     * 完成请求
     */
    default void complete() {
    }

    /**
     * 空数据
     */
    default void empty(CharSequence charSequence) {
    }

}
