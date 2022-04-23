package com.common.lib_base.base;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.common.lib_base.network.core.BaseIPaginationPresenter;
import com.example.lib_base.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

public abstract class BaseListRequestFragment<P extends BaseIPaginationPresenter, T> extends
        BaseRequestFragment
        implements OnRefreshLoadMoreListener {


    private SmartRefreshLayout mSmartRefreshLayout;
    private RecyclerView mRecyclerView;

    @Override
    protected int getLayoutId() {
        return R.layout.include_smart_refresh_recycler_view;
    }

    @Override
    protected void initialize(Bundle savedInstanceState) {
        // 列表
        mRecyclerView.setAdapter(getAdapter());
        mSmartRefreshLayout.setOnRefreshLoadMoreListener(this);

        // 请求
        //RefreshAndLoadMoreView<T> view = new RefreshAndLoadMoreView<>(mRecyclerView, mSmartRefreshLayout, this);
        //view.setEmptyLayoutResId(R.layout.view_state_layout_empty);
        //mRequestPresenter.setModelAndView(view);
        //mRequestPresenter.requestRefresh();

    }

    abstract protected BaseQuickAdapter<T, BaseViewHolder> getAdapter();

    @Override
    public void onAnewRequestNetwork() {
        //mRequestPresenter.requestRefresh();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        //mRequestPresenter.requestRefresh();
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        //mRequestPresenter.requestLoadMore();
    }

    private void initView() {
        mSmartRefreshLayout = findViewById(R.id.smart_refresh_layout);
        mRecyclerView = findViewById(R.id.recycler_view);
    }
}
