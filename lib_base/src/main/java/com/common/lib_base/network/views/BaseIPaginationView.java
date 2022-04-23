package com.common.lib_base.network.views;

import java.util.List;

/**
 * 分页 view
 */
public interface BaseIPaginationView<T> extends BaseIStatusView {

    void renderRefresh(List<T> refreshData);

    void renderLoadMore(List<T> loadMoreData);

    void renderNoMore();

}
