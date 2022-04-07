package com.example.lib_base.controller.views.impl;

import com.blankj.utilcode.util.LogUtils;

import com.example.lib_base.controller.views.core.BaseBaseIStatusView;
import com.example.lib_base.network.exceptions.UnauthorizedException;
import com.mondo.logger.Logger;

import and.fast.statelayout.StateLayout;

public class BaseLayoutRequestStatusView implements BaseBaseIStatusView {

    private final StateLayout mStateLayout;

    public BaseLayoutRequestStatusView(StateLayout layout) {
        this.mStateLayout = layout;
    }

    @Override
    public void loading() {
        if (mStateLayout == null) {
            Logger.i("loading, %s", "状态布局未初始化");
            return;
        }

        mStateLayout.showStateView(StateLayout.LOADING_STATE);
    }

    @Override
    public void offline() {
        if (mStateLayout == null) {
            Logger.i("offline, %s", "状态布局未初始化");
            return;
        }

        mStateLayout.showStateView(StateLayout.OFFLINE_STATE);
    }

    @Override
    public void failure(Throwable throwable) {
        if (mStateLayout == null) {
            Logger.i("failure, %s", "状态布局未初始化");
            return;
        }

        if (throwable instanceof UnauthorizedException) {

        } else {


            mStateLayout.showStateView(StateLayout.FAILURE_STATE, "");
        }

    }

    @Override
    public void complete() {
        if (mStateLayout == null) {
            LogUtils.i("complete, %s", "mStateLayout == null");
            return;
        }

        mStateLayout.showContentView();
    }

    @Override
    public void empty(CharSequence charSequence) {
        if (mStateLayout == null) {
            LogUtils.i("empty, %s", "mStateLayout == null");
            return;
        }

        mStateLayout.showStateView(StateLayout.EMPTY_STATE, charSequence);
    }


}
