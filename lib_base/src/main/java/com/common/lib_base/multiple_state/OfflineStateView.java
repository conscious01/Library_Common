package com.common.lib_base.multiple_state;


import android.os.Handler;
import android.os.Looper;
import com.example.lib_base.R;

public class OfflineStateView extends BaseStateView {

    private final int layoutResID;

    private OnStateLayoutClickListener onStateLayoutClickListener;

    public OfflineStateView(int layoutResID) {
        this.layoutResID = layoutResID;
    }

    @Override
    public Integer getStateCode() {
        return StateLayout.OFFLINE_STATE;
    }

    @Override
    public int getLayoutId() {
        return layoutResID;
    }

    @Override
    public void bindParentView(StateLayout parentView) {
        super.bindParentView(parentView);
        int duration = parentView.getResources().getInteger(R.integer.anew_request_delay_millis);

        getStateView()
                .findViewById(R.id.layout_state_container)
                .setOnClickListener(view -> {
                    if (onStateLayoutClickListener != null){
                        parentView.showStateView(StateLayout.LOADING_STATE);
                        new Handler(Looper.myLooper()).postDelayed(() ->
                                        onStateLayoutClickListener.onRetry(),
                                duration);
                    }
                });
    }

    @Override
    public void setOnAnewRequestNetworkListener(
            OnStateLayoutClickListener onStateLayoutClickListener) {
        this.onStateLayoutClickListener = onStateLayoutClickListener;
    }

}
