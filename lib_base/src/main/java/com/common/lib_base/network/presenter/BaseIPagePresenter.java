package com.common.lib_base.network.presenter;


import com.common.lib_base.network.views.BaseIPageView;
import com.common.lib_base.network.views.BaseIStatusView;

/**
 * 分页数据
 */
public interface BaseIPagePresenter<V extends BaseIStatusView, T> extends BaseIPresenter<V> {

    void setPaginationView(BaseIPageView<T> view);

    void requestRefresh();

    void requestLoadMore();

}
