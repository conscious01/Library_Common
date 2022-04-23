package com.common.lib_base.controller.views.impl;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import com.common.lib_base.controller.views.core.BaseBaseBaseISingleRequestView;
import com.common.lib_base.common.utils.LifecycleCountDownTimer;
import com.common.lib_base.controller.views.core.BaseBaseIStatusView;


public class BaseCountDownTimerViewUpdate implements
        BaseBaseBaseISingleRequestView<Object> {

    private final TextView mTextView;
    private final Lifecycle mLifecycle;
    private final BaseBaseIStatusView mStatusView;

    public BaseCountDownTimerViewUpdate(@NonNull TextView textView, Lifecycle lifecycle) {
        this.mTextView = textView;
        this.mLifecycle = lifecycle;
        this.mStatusView = new BaseLoadingStatusView(textView.getContext());
    }

    @Override
    public void result() {
        new LifecycleCountDownTimer(mLifecycle, mTextView, "%d秒","").start();
    }

    @Override
    public void loading() {
        mStatusView.loading();
    }

    @Override
    public void offline() {
        mStatusView.offline();
    }

    @Override
    public void failure(Throwable throwable) {
        mStatusView.failure(throwable);
    }

    @Override
    public void complete() {
        mStatusView.complete();
    }

}
