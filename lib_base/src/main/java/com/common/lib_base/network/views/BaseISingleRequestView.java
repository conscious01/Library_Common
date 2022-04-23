package com.common.lib_base.network.views;

public interface BaseISingleRequestView<T> extends BaseIStatusView {

    default void result() {

    }


    default void result(T result) {

    }

}
