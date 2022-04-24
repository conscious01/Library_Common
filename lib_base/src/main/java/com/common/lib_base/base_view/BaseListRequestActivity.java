package com.common.lib_base.base_view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.common.lib_base.common.utils.ActivityTitleHelper;
import com.common.lib_base.network.presenter.BaseIPagePresenter;
import com.common.lib_base.network.presenter.BasePagePresenter;
import com.common.lib_base.network.views.BasePageView;
import com.example.lib_base.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;

public abstract class BaseListRequestActivity<P extends BaseIPagePresenter, T> extends
        BaseRequestActivity
        implements OnRefreshLoadMoreListener {


    public SmartRefreshLayout refreshLayout;
    public RecyclerView recyclerView;

    private BasePagePresenter pagePresenter;

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
        recyclerView.setAdapter(getAdapter());
        refreshLayout.setOnRefreshLoadMoreListener(this);
        initRecyclerView();
        pagePresenter=getPresenter();
        pagePresenter.setModelAndView(new BasePageView<>(recyclerView, refreshLayout, this));
        pagePresenter.requestRefresh();

    }

    abstract protected @StringRes
    int getTitleRes();

    abstract protected BaseQuickAdapter<T, BaseViewHolder> getAdapter();

    @Override
    public void onRetry() {
        pagePresenter.requestRefresh();
    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {
        pagePresenter.requestRefresh();
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        pagePresenter.requestLoadMore();
    }

    private void initView() {
        refreshLayout = findViewById(R.id.smart_refresh_layout);
        recyclerView = findViewById(R.id.recycler_view);
    }

    protected abstract BasePagePresenter getPresenter();

    protected abstract void initRecyclerView();
}
