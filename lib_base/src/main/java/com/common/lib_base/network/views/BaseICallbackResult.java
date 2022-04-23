package com.common.lib_base.network.views;

public interface BaseICallbackResult<T> extends BaseIStatusView {

    void successful(T result);

}
