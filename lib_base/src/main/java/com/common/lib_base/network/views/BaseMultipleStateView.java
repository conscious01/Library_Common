package com.common.lib_base.network.views;

import com.blankj.utilcode.util.LogUtils;

import com.common.lib_base.multiple_state.StateLayout;
import com.common.lib_base.network.exceptions.ExceptionHandler;
import com.common.lib_base.network.exceptions.ExceptionHandler.ResponeThrowable;
import com.mondo.logger.Logger;


/**
 * 多状态布局
 * 加载中
 * 网络错误
 * 数据为空
 * 没有网络
 */
public class BaseMultipleStateView implements BaseIStatusView {

    private final StateLayout mStateLayout;

    public BaseMultipleStateView(StateLayout layout) {
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
    public void offline(boolean showErrorMsg) {
        if (mStateLayout == null) {
            Logger.i("offline, %s", "状态布局未初始化");
            return;
        }

        mStateLayout.showStateView(StateLayout.OFFLINE_STATE);
    }

    @Override
    public void failure(Throwable throwable,boolean showErrorMsg) {
        if (mStateLayout == null) {
            Logger.i("failure, %s", "状态布局未初始化");
            return;
        }

        //todo 各种不同的网络
//        if (throwable instanceof UnauthorizedException) {
//
//        } else {
//
//
//            mStateLayout.showStateView(StateLayout.FAILURE_STATE, "");
//        }

        ResponeThrowable responeThrowable = ExceptionHandler.handleException(throwable);
        String errorMsg = responeThrowable.code + " " + responeThrowable.message;
        mStateLayout.showStateView(StateLayout.FAILURE_STATE,errorMsg);


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
