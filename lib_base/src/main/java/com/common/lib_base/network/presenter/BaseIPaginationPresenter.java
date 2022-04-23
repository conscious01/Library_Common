package com.common.lib_base.network.presenter;


import com.common.lib_base.network.views.BaseIPaginationView;
import com.common.lib_base.network.views.BaseIStatusView;

/**
 * 分页数据
 */
public interface BaseIPaginationPresenter<V extends BaseIStatusView, T> extends BaseIPresenter<V> {

    void setPaginationView(BaseIPaginationView<T> view);

    void requestRefresh();

    void requestLoadMore();

}
