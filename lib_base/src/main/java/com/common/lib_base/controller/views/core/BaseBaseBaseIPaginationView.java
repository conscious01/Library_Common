package com.common.lib_base.controller.views.core;

import java.util.List;

/**
 * 分页 view
 */
public interface BaseBaseBaseIPaginationView<T> extends BaseBaseIStatusView {

    void renderRefresh(List<T> refreshData);

    void renderLoadMore(List<T> loadMoreData);

    void renderNoMore();

}
