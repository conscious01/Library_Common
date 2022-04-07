package com.example.lib_base.network.core;


import com.example.lib_base.controller.views.core.BaseBaseBaseIPaginationView;
import com.example.lib_base.controller.views.core.BaseIView;

/**
 * 分页数据
 */
public interface BaseIPaginationPresenter<V extends BaseIView, T> extends BaseIPresenter<V> {

    void setPaginationView(BaseBaseBaseIPaginationView<T> view);

    void requestRefresh();

    void requestLoadMore();

}
