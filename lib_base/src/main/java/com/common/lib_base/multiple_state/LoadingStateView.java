package com.common.lib_base.multiple_state;


public class LoadingStateView extends BaseStateView {

    private final int layoutResID;

    public LoadingStateView(int layoutResID){
        this.layoutResID = layoutResID;
    }

    @Override
    public Integer getStateCode() {
        return StateLayout.LOADING_STATE;
    }

    @Override
    public void setOnAnewRequestNetworkListener(
            OnStateLayoutClickListener onStateLayoutClickListener) {
    }

    @Override
    public int getLayoutId() {
        return layoutResID;
    }
}
