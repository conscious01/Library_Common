package com.common.lib_base.base_view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.common.lib_base.multiple_state.OnStateLayoutClickListener;
import com.common.lib_base.multiple_state.StateLayout;
import com.common.lib_base.network.views.BaseIStatusView;
import com.common.lib_base.network.views.BaseMultipleStateView;

public abstract class BaseRequestFragment
//        <P extends RequestPresenter>
        extends BaseFragment implements
        OnStateLayoutClickListener,
        BaseIStatusView {

//    protected P mPresenter;
    protected StateLayout mNetworkStateLayout;
    private BaseIStatusView mRequestStateView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mNetworkStateLayout == null) {
            mNetworkStateLayout = new StateLayout(container.getContext());
            mNetworkStateLayout.setOnAnewRequestNetworkListener(this);
            mNetworkStateLayout.addView(super.onCreateView(inflater, mNetworkStateLayout, savedInstanceState));
        }

        return mNetworkStateLayout;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRequestStateView = createRequestView();

    }


    //
//    private void injection() {
//        try {
//            // 注入P层
//            Type genericSuperclass = getClass().getGenericSuperclass();
//            Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
//            mPresenter = ((Class<P>) type).newInstance();
//            mRequestStateView = createRequestView(); // 代理对象
//            mPresenter.setModelAndView(this);
//            getLifecycle().addObserver(mPresenter);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    protected BaseIStatusView createRequestView() {
        return new BaseMultipleStateView(this.mNetworkStateLayout);
    }

    @Override
    public void loading() {
        mRequestStateView.loading();
    }

    @Override
    public void offline(boolean showErrorMsg) {
        mRequestStateView.offline(showErrorMsg);
    }

    @Override
    public void failure(Throwable throwable,boolean showErrorMsg) {
        mRequestStateView.failure(throwable,showErrorMsg);
    }



    @Override
    public void complete() {
        mRequestStateView.complete();
    }

    @Override
    public void empty(CharSequence charSequence) {
        mRequestStateView.empty(charSequence);
    }

    @Override
    public void onRetry() {
        //mPresenter.anewRequest();
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        //mPresenter.onHiddenChanged(hidden);
    }





}
