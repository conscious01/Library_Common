package com.common.lib_base.multiple_state;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseStateView implements StateLayout.StateView {

    private View      mStateView;
    private ViewGroup mParentView;

    @Override
    public View getStateView() {
        return mStateView;
    }

    @Override
    public void bindParentView(StateLayout parentView) {
        this.mParentView = parentView;
        mStateView = LayoutInflater.from(parentView.getContext()).inflate(getLayoutId(), parentView, false);
        parentView.addView(mStateView);
    }

    @Override
    public void display(CharSequence message, boolean visibility) {

    }

    @Override
    public void setOnAnewRequestNetworkListener(
            OnStateLayoutClickListener onStateLayoutClickListener) {

    }

    public abstract int getLayoutId();
}
