package com.common.lib_base.base_view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.common.lib_base.common.utils.ActivityTitleHelper;
import com.common.lib_base.network.presenter.BaseIPaginationPresenter;
import com.example.lib_base.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

public abstract class BaseListRequestActivity<P extends BaseIPaginationPresenter, T> extends BaseRequestActivity
        implements OnRefreshLoadMoreListener {


    private SmartRefreshLayout mSmartRefreshLayout;
    private RecyclerView mRecyclerView;

    @Override
    protected int getTitleLayoutRes() {
        return R.layout.include_activity_title;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.include_smart_refresh_recycler_view;
    }

    @Override
    protected void initialize(Bundle savedInstanceState) {
        // 标题
        ActivityTitleHelper.setTitle(this, getTitleRes());
        initView();
        // 列表
        mRecyclerView.setAdapter(getAdapter());
        mSmartRefreshLayout.setOnRefreshLoadMoreListener(this);

        // 请求
        //RefreshAndLoadMoreView<T> view = new RefreshAndLoadMoreView<>(mRecyclerView, mSmartRefreshLayout, this);
        //view.setEmptyLayoutResId(R.layout.view_state_layout_empty);
        //mRequestPresenter.setModelAndView(view);
    }

    abstract protected @StringRes int getTitleRes();

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
